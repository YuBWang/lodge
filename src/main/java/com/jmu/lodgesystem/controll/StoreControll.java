package com.jmu.lodgesystem.controll;

import com.jmu.lodgesystem.entity.*;
import com.jmu.lodgesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class StoreControll {
    @Autowired
    private StoreService storservice;
    @Autowired
    private ProMessageService pro;
    @Autowired
    private MealsService mel;
    @Autowired
    private OrderlistService ordlist;
    @Autowired
    private MessageService messages;
    @Autowired
    private SigninService signservice;
    @Autowired
    private UseMessageService usemessage;
    @RequestMapping("test")
    public String te(){
      return  "multipleIndex";
    }
    @RequestMapping("StoreHome")
    public String home(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("account");
        String storeid = (String) session.getAttribute("storeid");
        Store s = storservice.findByid(id);
        model.addAttribute("list",s);
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        int a1 = usemessage.findAgeCount(storeid,0,4);
        int a2 = usemessage.findAgeCount(storeid,5,6);
        int a3 = usemessage.findAgeCount(storeid,7,8);
        int a4 = usemessage.findAgeCount(storeid,9,10);
        int a5 = usemessage.findAgeCount(storeid,11,12);
        int a6 = usemessage.findAgeCount(storeid,13,14);
        int a7 = usemessage.findAgeCount(storeid,15,25);
        int a8 = usemessage.findSexCount(storeid,"男",0,4);
        int a9 = usemessage.findSexCount(storeid,"男",5,6);
        int a10 = usemessage.findSexCount(storeid,"男",7,8);
        int a11 = usemessage.findSexCount(storeid,"男",9,10);
        int a12 = usemessage.findSexCount(storeid,"男",11,12);
        int a13 = usemessage.findSexCount(storeid,"男",13,14);
        int a14 = usemessage.findSexCount(storeid,"男",15,25);
        int a15 = usemessage.findSexCount(storeid,"女",0,4);
        int a16 = usemessage.findSexCount(storeid,"女",5,6);
        int a17 = usemessage.findSexCount(storeid,"女",7,8);
        int a18 = usemessage.findSexCount(storeid,"女",9,10);
        int a19 = usemessage.findSexCount(storeid,"女",11,12);
        int a20 = usemessage.findSexCount(storeid,"女",13,14);
        int a21 = usemessage.findSexCount(storeid,"女",15,25);
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


    @RequestMapping("/multipleImageUpload1")
    @ResponseBody
    public String multipleImageUpload(@RequestParam("uploadFiles") MultipartFile[] files,HttpServletRequest request) {
        System.out.println("上传的图片数：" + files.length);
        String str = "";
        for(MultipartFile file : files){
            if (file.isEmpty()) {
                System.out.println("文件1为空空");
            }
            String fileName1 = file.getOriginalFilename();  // 文件名
            String suffixName1 = fileName1.substring(fileName1.lastIndexOf("."));  // 后缀名
            String filePath = "D://temp-rainy//"; // 上传后的路径
            // String filePath = "/root/temp-rainy/"; // 上传后的路径
            fileName1 = UUID.randomUUID() + suffixName1; // 新文件名
            File dest1 = new File(filePath + fileName1);
            if (!dest1.getParentFile().exists()) {
                dest1.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename1 = "/temp-rainy/" + fileName1;
            // String filename1 = "/temp-rainy/" + fileName1;
            str+=filename1+";";
        }
        String mealid = UUID.randomUUID() + "0";
        HttpSession session = request.getSession();
        String storid = (String) session.getAttribute("storeid");

        LocalDate data1 = LocalDate.now();
        DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dastr1 = data1.format(fm1);
        LocalDate d1 = LocalDate.parse(dastr1, fm1);

        System.out.println(str);
        Meals m = new Meals(mealid,storid,d1,str);
        mel.inserts(m);
        return "false";
    }
    @RequestMapping("ProdectManager")
    public String promanager(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = String.valueOf(session.getAttribute("storeid"));
        List<ProMessage> list = pro.selectById(id);
        model.addAttribute("list",list);
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Store/ProductManager";

    }
    @RequestMapping("addProduct")
    public String addpro(String types,String startday,String endday,String allmoney,String earmoney,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String storeid = (String) session.getAttribute("storeid");
        String productid = UUID.randomUUID()+"0";
        double money1 = Double.valueOf(allmoney);
        double money2 = Double.valueOf(earmoney);
        ProMessage p = new ProMessage(productid,storeid,types,startday,endday,money1,money2);
        pro.inserts(p);
        List<ProMessage> list = pro.selectById(storeid);
        model.addAttribute("list",list);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Store/ProductManager";

    }
    @RequestMapping("deleProduct")
    public String deleteProduct(String proid,HttpServletRequest request,Model model){
        int flag = pro.deletById(proid);
        HttpSession session = request.getSession();
        String id = String.valueOf(session.getAttribute("storeid"));
        List<ProMessage> list = pro.selectById(id);
        model.addAttribute("list",list);
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Store/ProductManager";

    }
    @RequestMapping("addEat")
    public String eat(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        List<Meals> list = mel.findById(id);
        List<List> listAll = new ArrayList<>();
        if(list!=null){
            for(int i=0;i<list.size();i++){
                List<String> listPhoto = new ArrayList<>();
                LocalDate data =  list.get(i).getTimes();
                DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dastr1 = data.format(fm1);
                listPhoto.add(list.get(i).getMeaid());
                listPhoto.add(list.get(i).getStoreid());
                listPhoto.add(dastr1);
                String [] arr=list.get(i).getPhotolist().split(";");
                for(int j=0;j<arr.length;j++){
                    listPhoto.add(arr[j]);
                }
                for(int f=1;f<=5-arr.length;f++){
                        listPhoto.add("../../static/jiemian3/images/image.png");
                }

                listAll.add(listPhoto);
            }
            for(List li:listAll){
                System.out.println("这是一条list数据："+li.get(0)+"=="+li.get(1)+" "+li.get(2)+"==="+li.get(3)+" "+li.get(4)+"==="+li.get(5)+" "+li.get(6)+"==="+li.get(7));
            }

        }
        model.addAttribute("photoList",listAll);

        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Store/EatManager1";
    }
    @RequestMapping("deleteMeals")
    public String deleteMeals(String meaid,HttpServletRequest request,Model model){
        int flag = mel.deleteById(meaid);
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        List<Meals> list = mel.findById(id);
        List<List> listAll = new ArrayList<>();
        if(list!=null){
            for(int i=0;i<list.size();i++){
                List<String> listPhoto = new ArrayList<>();
                LocalDate data =  list.get(i).getTimes();
                DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dastr1 = data.format(fm1);
                listPhoto.add(list.get(i).getMeaid());
                listPhoto.add(list.get(i).getStoreid());
                listPhoto.add(dastr1);
                String [] arr=list.get(i).getPhotolist().split(";");
                for(int j=0;j<arr.length;j++){
                    listPhoto.add(arr[j]);
                }
                for(int f=1;f<=5-arr.length;f++){
                    listPhoto.add("../static/jiemian3/images/image.png");
                }

                listAll.add(listPhoto);
            }
            for(List li:listAll){
                System.out.println("这是一条list数据："+li.get(0)+"=="+li.get(1)+" "+li.get(2)+"==="+li.get(3)+" "+li.get(4)+"==="+li.get(5)+" "+li.get(6)+"==="+li.get(7));
            }

        }
        model.addAttribute("photoList",listAll);

        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Store/EatManager1";
    }
    @RequestMapping("ordmanager")
    public String ordManager(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        List<Orders> list = ordlist.findByid(id);
        model.addAttribute("list",list);
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Store/OrderManager";
    }
    @RequestMapping("ordmanager1")
    public String ordManager1(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        int statu = Integer.parseInt(request.getParameter("ordertype"));
        String id = (String) session.getAttribute("storeid");
        if(statu==-1){
            List<Orders> list = ordlist.findByid(id);
            model.addAttribute("list",list);
        }
        else{
            List<Orders> list = ordlist.findByStatus(id,statu);
            model.addAttribute("list",list);
        }
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Store/OrderManager";
    }
    @RequestMapping("messageList")
    public String toMessageList(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id1 = (String) session.getAttribute("account");
        List<String> nameList1 = messages.findallname(id1);
        List<Message> messList1  = new ArrayList<>();
        for(String s:nameList1){
            Message mid = messages.findAllUnreadMessage(s,id1);
            messList1.add(mid);
        }
        List<String> nameList2 = messages.findHadREadName(id1);
        List<Message> messList2  = new ArrayList<>();
        for(String s:nameList2){
            List<Message> mid = messages.findAll(s,id1,id1);
            Message mid1 = mid.get(mid.size()-1);
            messList2.add(mid1);
        }

       model.addAttribute("list1",messList1);
        model.addAttribute("list2",messList2);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Store/messageList";
    }
    @RequestMapping("StoreChat")
    public String toStoreChat(String fr,String to, Model model,HttpServletRequest request){
        System.out.println("============================"+fr+to);
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        if(account.equals(fr)){
            fr=to;
        }
        model.addAttribute("inuse",account);
        model.addAttribute("outuse",fr);
        List<Message> list = messages.findAll(account,fr,account);
        for(Message li:list){
            if(li.getSenderid().equals(account)){
                li.setSenderid("我");
            }
        }
        model.addAttribute("list",list);
        model.addAttribute("storeName",fr);

        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);

        int flag = messages.upReadMessage(fr,id1);
        return "Store/StoreChat";

    }
    @RequestMapping("deleteStoreChat")
    public String deletetoStoreChat(String fr,String to, Model model,HttpServletRequest request){
        System.out.println("============================"+fr+to);
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        if(account.equals(fr)){
            fr=to;
        }
       int flag1 = messages.deleteMessage(account,fr,account);
        int flag2 = messages.deleteMessage(fr,account,account);
        List<String> nameList1 = messages.findallname(account);
        List<Message> messList1  = new ArrayList<>();
        for(String s:nameList1){
            Message mid = messages.findAllUnreadMessage(s,account);
            messList1.add(mid);
        }
        List<String> nameList2 = messages.findHadREadName(account);
        List<Message> messList2  = new ArrayList<>();
        for(String s:nameList2){
            List<Message> mid = messages.findAll(s,account,account);
            Message mid1 = mid.get(mid.size()-1);
            messList2.add(mid1);
        }

        model.addAttribute("list1",messList1);
        model.addAttribute("list2",messList2);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Store/messageList";
    }

    @RequestMapping("toSignhtml")
    public String tosignhtml(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        String signid = signservice.findSignid(id);
        List<List> list = new ArrayList<>();
        List<Signin> signlist= signservice.findAll(signid);
        for(Signin s:signlist){
            List<String> temp = new ArrayList<>();
            signList mid = signservice.findSign(s.getStoreid(),s.getUserid(),s.getOrderid());
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime da = s.getTimes();
            String dastr = da.format(fm);
            temp.add(dastr);
            temp.add(mid.getChildname());
            temp.add(mid.getUsername());
            temp.add(mid.getPhone());
            temp.add(mid.getSchool()+mid.getGrades()+mid.getClasses());
            String status;
            if(s.getStatus()==0){
                status="未签到";
            }
            else{
                status="已签到";
            }
            temp.add(status);
            temp.add(s.getSigninid());
            temp.add(s.getUserid());
            temp.add(s.getOrderid());
            list.add(temp);

        }

        model.addAttribute("list",list);
        return "Store/SignList";
    }
    @RequestMapping("addNewSign")
    public String addNewSign(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        List<signList> signlist = signservice.findSignList(id);
        String signinid = String.valueOf(UUID.randomUUID());
        LocalDateTime data = LocalDateTime.now();
        System.out.println("localdata时间:"+data);
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dastr = data.format(fm);
        System.out.println("转换成String后时间:"+dastr);
        LocalDateTime d2 = LocalDateTime.parse(dastr,fm);
        System.out.println("localdata时间:"+d2);
        List<List> alllist = new ArrayList<>();
        for(signList s:signlist){
            Signin sig = new Signin(signinid,s.getStoreid(),s.getUserid(),s.getListid(),d2,0,null,null);
            int flag1 = signservice.insertSign(sig);
            List<String> temp = new ArrayList<>();
            temp.add(dastr);
            temp.add(s.getChildname());
            temp.add(s.getUsername());
            temp.add(s.getPhone());
            temp.add(s.getSchool()+s.getGrades()+s.getClasses());
            temp.add("未签到");
            temp.add(signinid);
            temp.add(s.getUserid());
            temp.add(s.getListid());
            alllist.add(temp);
        }

        model.addAttribute("list",alllist);

        return "Store/SignList";
    }
    @RequestMapping("upSignStatus")
    public String toUpSign(String sid,String uid,String listid,Model model,HttpServletRequest request){
        int flag = signservice.upSignState(sid,uid,listid);
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        String signid = signservice.findSignid(id);
        List<List> list = new ArrayList<>();
        List<Signin> signlist= signservice.findAll(signid);
        for(Signin s:signlist){
            List<String> temp = new ArrayList<>();
            signList mid = signservice.findSign(s.getStoreid(),s.getUserid(),s.getOrderid());
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime da = s.getTimes();
            String dastr = da.format(fm);
            temp.add(dastr);
            temp.add(mid.getChildname());
            temp.add(mid.getUsername());
            temp.add(mid.getPhone());
            temp.add(mid.getSchool()+mid.getGrades()+mid.getClasses());
            String status;
            if(s.getStatus()==0){
                status="未签到";
            }
            else{
                status="已签到";
            }
            temp.add(status);
            temp.add(s.getSigninid());
            temp.add(s.getUserid());
            temp.add(s.getOrderid());
            list.add(temp);

        }

        model.addAttribute("list",list);
        return "Store/SignList";


    }
    @RequestMapping("findByListId")
    @ResponseBody
    public List<String> findByListid(String listid){
        Orders s = ordlist.findBylistId(listid);
        String uid = s.getUserid();
        UseMessage use = usemessage.findByuseid1(uid);
        List<String> li = new ArrayList<>();
        li.add(s.getOrderid());
        li.add(s.getTypes());
        li.add(s.getStartday());
        li.add(s.getEndday());
        li.add(String.valueOf(s.getEarmoney()));
        li.add(String.valueOf(s.getAllmoney()));
        if(s.getStatus()==0){
            li.add("未支付，未完成");
        }
        else if(s.getStatus()==1){
            li.add("定金已支付，未完成");
        }
        else if(s.getStatus()==2){
            li.add("总价格已支付，未完成");
        }
        else if(s.getStatus()==3){
            li.add("已完成");
        }
        li.add(use.getUsername());
        li.add(use.getPhone());
        li.add(use.getChildname());
        li.add(String.valueOf(use.getAge()));
        li.add(use.getSex());
        li.add(use.getSchool());
        li.add(use.getGrades());
        li.add(use.getClasses());

        return li;
    }
    @RequestMapping("writeDaysMessage")
    public String  towrite(String sid,String uid,String listid,Model model,HttpServletRequest request){
        Signin s = signservice.findSignOne(sid,uid,listid);
        model.addAttribute("list",s);
        HttpSession session = request.getSession();
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        if(s.getPhotolist()!=null){
            String [] arr= s.getPhotolist().split(";");
            List<String> photoList = new ArrayList<>();
            for(int j=0;j<arr.length;j++){
                photoList.add(arr[j]);
            }
            model.addAttribute("photoList",photoList);
        }


        return "Store/WriteStudentMessage";


    }

    @RequestMapping("/StudentPhoto")
    @ResponseBody
    public String multipleImageUpload1(@RequestParam("uploadFiles") MultipartFile[] files,@RequestParam("sid") String sid,@RequestParam("uid") String uid,@RequestParam("listid")String listid,HttpServletRequest request) {
        System.out.println("上传的图片数：" + files.length);
        String str = "";
        for(MultipartFile file : files){
            if (file.isEmpty()) {
                System.out.println("文件空");
            }
            String fileName1 = file.getOriginalFilename();  // 文件名
            String suffixName1 = fileName1.substring(fileName1.lastIndexOf("."));  // 后缀名
            String filePath = "D://temp-rainy//"; // 上传后的路径
            // String filePath = "/root/temp-rainy/"; // 上传后的路径
            fileName1 = UUID.randomUUID() + suffixName1; // 新文件名
            File dest1 = new File(filePath + fileName1);
            if (!dest1.getParentFile().exists()) {
                dest1.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename1 = "/temp-rainy/" + fileName1;
            // String filename1 = "/temp-rainy/" + fileName1;
            str+=filename1+";";
        }
        int flag1 = signservice.upPhotoList(sid,uid,str,listid);
        return "false";
    }
    @RequestMapping("upDataMessage")
    public String Upmessages1(String siginid,String userid,String listid,String message1,Model model,HttpServletRequest request){
        int flag1 = signservice.upMessage(siginid,userid,message1,listid);

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("storeid");
        String signid = signservice.findSignid(id);
        List<List> list = new ArrayList<>();
        List<Signin> signlist= signservice.findAll(signid);
        for(Signin s:signlist){
            List<String> temp = new ArrayList<>();
            signList mid = signservice.findSign(s.getStoreid(),s.getUserid(),s.getOrderid());
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime da = s.getTimes();
            String dastr = da.format(fm);
            temp.add(dastr);
            temp.add(mid.getChildname());
            temp.add(mid.getUsername());
            temp.add(mid.getPhone());
            temp.add(mid.getSchool()+mid.getGrades()+mid.getClasses());
            String status;
            if(s.getStatus()==0){
                status="未签到";
            }
            else{
                status="已签到";
            }
            temp.add(status);
            temp.add(s.getSigninid());
            temp.add(s.getUserid());
            temp.add(s.getOrderid());
            list.add(temp);

        }

        model.addAttribute("list",list);
        return "Store/SignList";
    }



}
