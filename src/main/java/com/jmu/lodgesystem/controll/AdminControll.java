package com.jmu.lodgesystem.controll;

import com.jmu.lodgesystem.entity.Apply;
import com.jmu.lodgesystem.entity.Store;
import com.jmu.lodgesystem.service.ApplyService;
import com.jmu.lodgesystem.service.StoreService;
import com.jmu.lodgesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminControll {
    @Autowired
    private UserService use;
    @Autowired
    private StoreService stor;
    @Autowired
    private ApplyService apl;
    @RequestMapping("/Adminmanage")
    public String AdminLogin(Model mode){
        int userCount = use.findAllCount();
        int storeCount = stor.findAllCounts();
        mode.addAttribute("UserCount",userCount);
        mode.addAttribute("StoreCount",storeCount);
        return "Admin/AdminisPage";
    }
    @RequestMapping("StoreCheck")
    public String Storelist(Model model){
        List<Store> allstore = stor.findApply();
        model.addAttribute("allStore",allstore);
        int counts = stor.findApplyCount();
        model.addAttribute("counts",counts);
        return "Admin/StoreCheck";
    }
    @RequestMapping("StoreList")
    public String StoreChrck(Model model){
        List<Store> allstore = stor.findAll();
        model.addAttribute("allStore",allstore);
        int counts = stor.findAllCounts();
        model.addAttribute("counts",counts);
        return "Admin/StoreList";
    }
    @RequestMapping("details")
    public String ToDetails(String storeid,Model model){
        Store result = stor.findById(storeid);
        model.addAttribute("list",result);
      return "Admin/ApplyDetail";
    }
    @RequestMapping("details2")
    public String ToDetails2(String storeid,Model model){
        Store result = stor.findById(storeid);
        model.addAttribute("list",result);
        return "Admin/ApplyDetails2";
    }

    @RequestMapping("ApplySuccess")
    public void success(String account,Model model){
        int flag1 = stor.upStoreData(account);
        Apply ap = new Apply(account,1,null);
        int flag2 = apl.upstatus(ap);
    }
    @RequestMapping("ApplyFault1")
    public void fault1(String account , String result, Model model){
        System.out.println("账号有传过来吗;;;;;;;;;;;"+account);
        int flag1 = stor.upStoreData(account);
        Apply ap = new Apply(account,-1,result);
        int flag2 = apl.upstatus(ap);
    }
    @RequestMapping("deleteApply")
    public String dele(String storeid,Model model){
        int f = stor.deleByid(storeid);
        List<Store> allstore = stor.findApply();
        model.addAttribute("allStore",allstore);
        int counts = stor.findApplyCount();
        model.addAttribute("counts",counts);
        return "Admin/StoreCheck";
    }
    @RequestMapping("selectOne")
    public String selecton(String store,Model model){
        System.out.println(store);
        List<Store> li = stor.searchByName(store);
        model.addAttribute("allStore",li);
        int count = li.size();
        model.addAttribute("counts",count);
        return "Admin/StoreList";
    }
}
