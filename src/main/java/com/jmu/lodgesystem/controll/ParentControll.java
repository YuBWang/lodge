package com.jmu.lodgesystem.controll;

import com.jmu.lodgesystem.GetLatAndLngByBaidu;
import com.jmu.lodgesystem.entity.*;
import com.jmu.lodgesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParentControll {
    @Autowired
    private UserService userservice;
    @Autowired
    private StoreService stor;
    @Autowired
    ProMessageService pro;
    @Autowired
    private UseMessageService usemess;
    @Autowired
    private MealsService mel;
    @Autowired
    private MessageService messages;
    @Autowired
    private OrderlistService ordlist;
    @Autowired
    private SigninService sigservice;
    @Autowired
    private CommentService commentser;

    @RequestMapping("parSearch")
    public String firstsearch(String searchplace, Model model,HttpServletRequest request) throws IOException {
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
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Parent/UserFirstPage";
    }
    @RequestMapping("findStoreDetail")
    public String home(String storid, Model model,HttpServletRequest request){
        Store s = stor.findById(storid);
        model.addAttribute("list",s);
        List<ProMessage> p = pro.selectById(storid);
        model.addAttribute("p",p);
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("account");
        UseMessage us = usemess.findByuseid(userid);
        model.addAttribute("usermessage",us);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        int  commentPeople = commentser.commentCount(storid);
        model.addAttribute("people",commentPeople);
        List<Comment> comts = commentser.returnAllComment(storid);
        model.addAttribute("comts",comts);
        return "Parent/FindStoreDetail";

    }
    @RequestMapping("paySuccess")
    public String success(HttpServletRequest request,Model model){
        List<List> list = new ArrayList<>();
        list = null;
        model.addAttribute("list",list);
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Parent/UserFirstPage";
    }
    @RequestMapping("userInfo")
    public String Userinfo(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String userid= (String) session.getAttribute("account");
        UseMessage us = usemess.findByuseid(userid);
        model.addAttribute("list",us);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Parent/UserInfo";
    }
    @RequestMapping("upInfo")
    @ResponseBody
    public String updateinfo(String username,String phone,String childname,String sex,String age,String school,String grades,String classes,HttpServletRequest request){
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        String userid = (String) session.getAttribute("userid");
        int age1 = Integer.parseInt(age);
        UseMessage us = new UseMessage(account,userid,username,phone,childname,sex,age1,school,grades,classes,1);
         int flag = usemess.updateInfo(us);
         if(flag==1){
             return "true";
         }
         return "false";

    }
    @RequestMapping("mealdetail")
    public String eatdetail(String storid,Model model,HttpServletRequest request){
        List<Meals> list = mel.findById(storid);
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

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Parent/eatDetail";
    }
    @RequestMapping("chats")
    public String chatWithStore(String storeid, Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        model.addAttribute("inuse",account);
        model.addAttribute("outuse",storeid);
        List<Message> list = messages.findAll(account,storeid,account);
        for(Message li:list){
            if(li.getSenderid().equals(account)){
                li.setSenderid("我");
            }
        }
        model.addAttribute("list",list);
        Store s = stor.findByid(storeid);
        String storename = s.getStorename();
        model.addAttribute("storeName",storename);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Parent/chats";

    }
    @RequestMapping("home")
    public String returnHome(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        List<List> list = new ArrayList<>();
        list = null;
        model.addAttribute("list",list);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        return "Parent/UserFirstPage";
    }
    @RequestMapping("MessageList")
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
        return "Parent/MessageList";
    }

    @RequestMapping("chats1")
    public String chatWithStore1(String fr,String to, Model model,HttpServletRequest request){
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
        Store s = stor.findByid(fr);
        String storename = s.getStorename();
        model.addAttribute("storeName",storename);
        String id = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id);
        model.addAttribute("count",count);
        int flag = messages.upReadMessage(fr,id);
        return "Parent/chats";

    }
    @RequestMapping("deletechats1")
    public String deletechatWithStore1(String fr,String to, Model model,HttpServletRequest request){
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
        return "Parent/MessageList";


    }
    @RequestMapping("Personordmanager")
    public String ordManager(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userid");
        List<Orders> list = ordlist.findByid2(id);
        model.addAttribute("list",list);
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Parent/PersonOrderList";
    }
    @RequestMapping("Personordmanager1")
    public String ordManager1(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        int statu = Integer.parseInt(request.getParameter("ordertype"));
        String id = (String) session.getAttribute("userid");
        if(statu==-1){
            List<Orders> list = ordlist.findByid2(id);
            model.addAttribute("list",list);
        }
        else{
            List<Orders> list = ordlist.findByStatus2(id,statu);
            model.addAttribute("list",list);
        }
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Parent/PersonOrderList";
    }
    @RequestMapping("findByListId1")
    @ResponseBody
    public List<String> findByListid(String listid){
        Orders ord = ordlist.findBylistId(listid);
        String storid = ord.getStoreid();
        String userid = ord.getUserid();
        Store sto = stor.findById(storid);
        List<Meals> mea = mel.findNearThreeMeal(storid);
        List<Signin> sig = sigservice.findThree(userid,listid);
        List<String> list = new ArrayList<>();
        list.add(listid);
        list.add(sto.getStorename());
        list.add(sto.getAddress());
        list.add(sto.getMobilephone());
        list.add(sto.getEmail());
        list.add(ord.getStartday()+"-"+ord.getEndday());
        for(int i=0;i<mea.size();i++){
            String [] arr=mea.get(i).getPhotolist().split(";");
            for(int j=0;j<arr.length;j++){
               list.add(arr[j]);
            }
            for(int f=1;f<=5-arr.length;f++){
                list.add("../static/jiemian3/images/image.png");
            }
        }
        for(int j=0;j<sig.size();j++){
            LocalDateTime temp = sig.get(j).getTimes();
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dastr = temp.format(fm);
            list.add(dastr);
            String status;
            if(sig.get(j).getStatus()==0){
                status="未签到";
            }
            else{
                status="签到";
            }
            list.add(status);

        }
        return list;

    }
    @RequestMapping("toComment")
    public String toCommeng(String listId,Model model){
        Orders ord = ordlist.findBylistId(listId);
        String storid = ord.getStoreid();
        String userid = ord.getUserid();
        Store sto = stor.findById(storid);
        model.addAttribute("list",sto);
        model.addAttribute("listid",listId);
        return "Parent/Comments";


    }
    @RequestMapping("upComment")
    public String upcomment(String grades,String message1,String listid,HttpServletRequest request,Model model){
        Orders ord = ordlist.findBylistId(listid);
        String storid = ord.getStoreid();
        String userid = ord.getUserid();
        String productid = ord.getProductid();
        Comment co = new Comment(storid,productid,userid,listid,Double.valueOf(grades),message1);
        int flag1 = commentser.insertComment(co);
        double avgGrade = commentser.avgcount(storid);

        int flag2 = stor.upgrade(storid,avgGrade);
        int flag4 = ordlist.updateStatus(listid,4);
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userid");
        List<Orders> list = ordlist.findByid2(id);
        model.addAttribute("list",list);
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);
        return "Parent/PersonOrderList";
    }
    @RequestMapping("upOrdlistStatus")
    @ResponseBody
    public String upOrderStatus(String listid,HttpServletRequest request,Model model){
        int flag1 = ordlist.updateStatus(listid,3);
       return "true";

    }
    @RequestMapping("findChildMessage")
    public String findToday(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userid");
        Signin s = sigservice.findTodaySign(id);
        if(s!=null){
            model.addAttribute("list",s);
            if(s.getPhotolist()!=null){
                String [] arr= s.getPhotolist().split(";");
                List<String> photoList = new ArrayList<>();
                for(int j=0;j<arr.length;j++){
                    photoList.add(arr[j]);
                }
                model.addAttribute("photoList",photoList);
            }

            LocalDateTime temp = s.getTimes();
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dastr = temp.format(fm);

            String status;
            if(s.getStatus()==0){
                status="未签到";
            }
            else{
                status="签到";
            }
            model.addAttribute("time",dastr);
            model.addAttribute("statu",status);

        }
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);

        return "Parent/TodayNew";


    }
    @RequestMapping("findChildByDate")
    public String findBydate(String date,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userid");
        String datetime = date+"%";
        Signin s = sigservice.findeveryDay(id,datetime);
        if(s!=null){
            model.addAttribute("list",s);
            if(s.getPhotolist()!=null){
                String [] arr= s.getPhotolist().split(";");
                List<String> photoList = new ArrayList<>();
                for(int j=0;j<arr.length;j++){
                    photoList.add(arr[j]);
                }
                model.addAttribute("photoList",photoList);
            }

            LocalDateTime temp = s.getTimes();
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dastr = temp.format(fm);

            String status;
            if(s.getStatus()==0){
                status="未签到";
            }
            else{
                status="签到";
            }
            model.addAttribute("time",dastr);
            model.addAttribute("statu",status);

        }
        String id1 = (String) session.getAttribute("account");
        int count = messages.findUnreadCount(id1);
        model.addAttribute("count",count);

        return "Parent/TodayNew";
    }


}
