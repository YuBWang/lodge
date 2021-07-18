package com.jmu.lodgesystem.controll;

import com.jmu.lodgesystem.GetLatAndLngByBaidu;
import com.jmu.lodgesystem.entity.*;
import com.jmu.lodgesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserControll {

    @Autowired
    private UserService userservice;
    @Autowired
    private StoreService stor;
    @Autowired
    private UseMessageService usemap;
    @Autowired
    private MessageService messages;
    @Autowired
    private ApplyService aplyservice;


    @RequestMapping("/")
    public String logins(Model model) {
        List<List> list = new ArrayList<>();
        list = null;
        model.addAttribute("list",list);
        return "FirstPage";

    }

    @RequestMapping("loginpage")
    public String TologinPage() {
        return "login";
    }

    @RequestMapping("forgetPage")
    public String forget() {
        return "forgot";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("registerJudge")
    public String registerjudge(String account, String password, String code, String returncode, HttpServletRequest request) throws Exception {
//        HttpSession session = request.getSession();
//        String codeResult = (String) session.getAttribute("codeResult");
        System.out.println("coderesult:" + returncode);
        System.out.println("code" + code);

        User ns = new User(account, password, 2);
        User us = userservice.findById(account);
        if (us == null) {
            if (returncode.equals(code)) {
                int flag = userservice.insertInfo(ns);
                String useid = String.valueOf(UUID.randomUUID());
                UseMessage usmess = new UseMessage(account,useid,null,null,null,null,0,null,null,null,0);
                int flag2 = usemap.insertInfo(usmess);
                if (flag == 1) {
                    return "registerSucess";
                }
            }

        }
        return "FirstPage";

    }

    @RequestMapping("StoreRegister")
    public String storeregister() {
        return "StoreRegister";
    }

    @RequestMapping("StoreRegisterJudge")
    public String StoreJudge(String account, String password, String code, String returncode, Model model,HttpServletRequest request) throws Exception {
//        HttpSession session = request.getSession();
//        String codeResult = (String) session.getAttribute("codeResult");
        System.out.println("coderesult:" + returncode);
        System.out.println("code" + code);

        User ns = new User(account, password, 1);
        User us = userservice.findById(account);
        if (us == null) {
            if (returncode.equals(code)) {
                int flag = userservice.insertInfo(ns);
                if (flag == 1) {
                    model.addAttribute("account",account);
                    return "Store/WriteMessage";
                }
            }

        }
        return "FirstPage";

    }

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @RequestMapping("sendemail")
    @ResponseBody
    public String sendSimpleMail(HttpServletRequest request, Model model) throws Exception {
        String email = request.getParameter("account");
        String pass = request.getParameter("password");
        System.out.println(email);
        System.out.println(pass);
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * str.length());
            code += str.charAt(index);
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(email); //自己给自己发送邮件
        message.setSubject("午托系统注册验证码");
        message.setText(code);
        String codeResult = code;
        try {
            mailSender.send(message);
        } catch (Exception e) {

        }
//        User ns = new User();
//        ns.setAccount(email);
//        ns.setPassword(pass);
//        model.addAttribute("user",ns);
        //request.setAttribute("codeResult",codeResult);
        //model.addAttribute("codeResult",codeResult);
//        HttpSession session = request.getSession();
//        session.setAttribute("codeResult",codeResult);
        System.out.println("发给邮箱的验证码：" + codeResult);
        return codeResult;
    }

    @RequestMapping("chat")
    public String chatt() {
        return "chat";
    }
    @RequestMapping("judgeAccount")
    @ResponseBody
    public String judges(String account){
        User us = userservice.findById(account);
        if(us==null){
            return "true";
        }
        return "false";
    }

    @RequestMapping("logJudge")
    @ResponseBody
    public String logjudge(String account,String password){
        User us = userservice.findById(account);
        if(us!=null&&us.getPassword().equals(password)){
            System.out.println("true===========================================");
            return "true";
        }
        System.out.println("false===========================================");
        return "false";
    }
    @RequestMapping("login")
    public String toLogin(String email,String password,Model model,HttpServletRequest request){
        System.out.println("传送过来的数字=======:"+email+"        "+password);
        User us = userservice.findById(email);
        if(us==null){
            return "login";
        }
        else{
            System.out.println("账号为："+us.getAccount()+"     密码是:"+us.getPassword());
            if(us!=null&&us.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("account",email);
                System.out.println("账号密码正确");
                if(us.getRole()==0){
                    int userCount = userservice.findAllCount();
                    int storeCount = stor.findAllCounts();
                    model.addAttribute("UserCount",userCount);
                    model.addAttribute("StoreCount",storeCount);
                    return "Admin/AdminisPage";
                }
                else if(us.getRole()==1){
                    Store s =stor.findByid(email);
                    if(s==null){
                        model.addAttribute("account",email);
                        return "Store/WriteMessage";
                    }
                    String storeid = s.getStoreid();
                    int flag3 = aplyservice.returnStatus(storeid);
                    if(flag3==-1){
                        Apply failureResult = aplyservice.returnAply(storeid);
                        model.addAttribute("failureResult",failureResult);
                        int flag6 = aplyservice.deleteOne(storeid);
                        int flag7 = stor.deleByid(storeid);
                        return "Store/ApplyFailure";
                    }
                    if(flag3==0){
                        return "WriteMessageSuccess";
                    }
                    model.addAttribute("list",s);
                    session.setAttribute("storeid",s.getStoreid());

                    int count = messages.findUnreadCount(email);
                    model.addAttribute("count",count);
                    int a1 = usemap.findAgeCount(storeid,0,4);
                    int a2 = usemap.findAgeCount(storeid,5,6);
                    int a3 = usemap.findAgeCount(storeid,7,8);
                    int a4 = usemap.findAgeCount(storeid,9,10);
                    int a5 = usemap.findAgeCount(storeid,11,12);
                    int a6 = usemap.findAgeCount(storeid,13,14);
                    int a7 = usemap.findAgeCount(storeid,15,25);
                    int a8 = usemap.findSexCount(storeid,"男",0,4);
                    int a9 = usemap.findSexCount(storeid,"男",5,6);
                    int a10 = usemap.findSexCount(storeid,"男",7,8);
                    int a11 = usemap.findSexCount(storeid,"男",9,10);
                    int a12 = usemap.findSexCount(storeid,"男",11,12);
                    int a13 = usemap.findSexCount(storeid,"男",13,14);
                    int a14 = usemap.findSexCount(storeid,"男",15,25);
                    int a15 = usemap.findSexCount(storeid,"女",0,4);
                    int a16 = usemap.findSexCount(storeid,"女",5,6);
                    int a17 = usemap.findSexCount(storeid,"女",7,8);
                    int a18 = usemap.findSexCount(storeid,"女",9,10);
                    int a19 = usemap.findSexCount(storeid,"女",11,12);
                    int a20 = usemap.findSexCount(storeid,"女",13,14);
                    int a21 = usemap.findSexCount(storeid,"女",15,25);
                    List<Integer> ageCount = new ArrayList<>();
                    ageCount.add(a1);
                    ageCount.add(a2);
                    ageCount.add(a3);
                    ageCount.add(a4);
                    ageCount.add(a5);
                    ageCount.add(a6);
                    ageCount.add(a7);
                    ageCount.add(a8);
                    ageCount.add(a9);
                    ageCount.add(a10);
                    ageCount.add(a11);
                    ageCount.add(a12);
                    ageCount.add(a13);
                    ageCount.add(a14);
                    ageCount.add(a15);
                    ageCount.add(a16);
                    ageCount.add(a17);
                    ageCount.add(a18);
                    ageCount.add(a19);
                    ageCount.add(a20);
                    ageCount.add(a21);
                    model.addAttribute("ageCount",ageCount);
                    return "Store/StoreManager";
                }
                else if(us.getRole()==2){
                    UseMessage usme = usemap.findByuseid(email);
                    session.setAttribute("userid",usme.getUserid());
                    System.out.println("userid==============================="+usme.getUserid());
                    List<List> list = new ArrayList<>();
                    list = null;
                    model.addAttribute("list",list);
                    String id = (String) session.getAttribute("account");
                    int count = messages.findUnreadCount(id);
                    model.addAttribute("count",count);
                    return "Parent/UserFirstPage";

                }

            }
        }

        return "login";
    }
    @RequestMapping("FirstSearch")
    public String firstsearch(String searchplace,Model model) throws IOException {
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        double[] o = getLatAndLngByBaidu.getCoordinate(searchplace);
        Point2D pointDD = new Point2D.Double(o[0],o[1] );
        double[] around = getLatAndLngByBaidu.getAround(o[0],o[1]);
        double minLng = around[0];
        double minLat = around[1];
        double maxLng = around[2];
        double maxLat = around[3];
        List<Store> li = stor.searchBetween(minLng,minLat,maxLng,maxLat);
        List<List> list = new ArrayList<>();
        for(int i=0;i<li.size();i++){
            List<String> temp = new ArrayList<>();
            temp.add(li.get(i).getStorephoto());
            temp.add(li.get(i).getStorename());
            temp.add(li.get(i).getAddress());
            String grade = String.valueOf(li.get(i).getGrade());
            temp.add(grade);
            Point2D pointXD = new Point2D.Double(li.get(i).getLongitue(),li.get(i).getLatitude());
            double dis = getLatAndLngByBaidu.getDistance(pointDD,pointXD);
            String distance = String.valueOf(dis);
            temp.add(distance);
            temp.add(li.get(i).getStoreid());
            list.add(temp);
            for(int j=0;j<temp.size();j++){
                System.out.println(temp.get(j));
            }
        }
        model.addAttribute("list",list);
        return "FirstPage";
    }

}
