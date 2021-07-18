package com.jmu.lodgesystem.controll;

import com.jmu.lodgesystem.entity.Apply;
import com.jmu.lodgesystem.entity.Store;
import com.jmu.lodgesystem.service.ApplyService;
import com.jmu.lodgesystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jmu.lodgesystem.GetLatAndLngByBaidu;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class fileControl {
    @Autowired
    private StoreService stores;
    @Autowired
    private ApplyService apl;
    @GetMapping(value = "/file")
    public String file() {
        return "WriteMessage";
    }

    @PostMapping(value = "MessageUpload")
    public String fileUpload(String account,String storename,String licenseid,String address,String mobilephone,String fixedphone,String email,@RequestParam(value = "storephoto") MultipartFile storephoto,@RequestParam(value = "fidcard") MultipartFile fidcard, @RequestParam(value = "ridcard") MultipartFile ridcard, @RequestParam(value = "licensephoto") MultipartFile licensephoto,@RequestParam(value = "inphoto1") MultipartFile inphoto1,@RequestParam(value = "inphoto2") MultipartFile inphoto2,@RequestParam(value = "inphoto3") MultipartFile inphoto3,@RequestParam(value = "inphoto4") MultipartFile inphoto4,String describe, Model model, HttpServletRequest request) throws IOException {
        if (fidcard.isEmpty()) {
            System.out.println("文件1为空空");
        }
        String fileName1 = fidcard.getOriginalFilename();  // 文件名
        String suffixName1 = fileName1.substring(fileName1.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        // String filePath = "/root/temp-rainy/"; // 上传后的路径
        fileName1 = UUID.randomUUID() + suffixName1; // 新文件名
        File dest1 = new File(filePath + fileName1);
        if (!dest1.getParentFile().exists()) {
            dest1.getParentFile().mkdirs();
        }
        try {
            fidcard.transferTo(dest1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename1 = "/temp-rainy/" + fileName1;
        // String filename1 = "/temp-rainy/" + fileName1;
        model.addAttribute("filename1", filename1);

        if (ridcard.isEmpty()) {
            System.out.println("文件2为空空");
        }
        String fileName2 = ridcard.getOriginalFilename();  // 文件名
        String suffixName2 = fileName2.substring(fileName2.lastIndexOf("."));  // 后缀名
        // String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName2 = UUID.randomUUID() + suffixName2; // 新文件名
        File dest2 = new File(filePath + fileName2);
        if (!dest2.getParentFile().exists()) {
            dest2.getParentFile().mkdirs();
        }
        try {
            ridcard.transferTo(dest2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename2 = "/temp-rainy/" + fileName2;
        // String filename2 = "/temp-rainy/" + fileName2;
        model.addAttribute("filename2", filename2);


        if (licensephoto.isEmpty()) {
            System.out.println("文件3为空空");
        }
        String fileName3 = licensephoto.getOriginalFilename();  // 文件名
        String suffixName3 = fileName3.substring(fileName3.lastIndexOf("."));  // 后缀名
        // String filePath = "/root/temp-rainy/"; // 上传后的路径
        fileName3 = UUID.randomUUID() + suffixName3; // 新文件名
        File dest3 = new File(filePath + fileName3);
        if (!dest3.getParentFile().exists()) {
            dest3.getParentFile().mkdirs();
        }
        try {
            licensephoto.transferTo(dest3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename3 = "/temp-rainy/" + fileName3;
        // String filename1 = "/temp-rainy/" + fileName1;
        model.addAttribute("filename3", filename3);

        if (storephoto.isEmpty()) {
            System.out.println("文件4为空空");
        }
        String fileName4 = storephoto.getOriginalFilename();  // 文件名
        String suffixName4 = fileName4.substring(fileName4.lastIndexOf("."));  // 后缀名
        // String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName4 = UUID.randomUUID() + suffixName4; // 新文件名
        File dest4 = new File(filePath + fileName4);
        if (!dest4.getParentFile().exists()) {
            dest4.getParentFile().mkdirs();
        }
        try {
            storephoto.transferTo(dest4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename4 = "/temp-rainy/" + fileName4;
        // String filename2 = "/temp-rainy/" + fileName2;
        model.addAttribute("filename4", filename4);


        if (inphoto1.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName5 = inphoto1.getOriginalFilename();  // 文件名
        String suffixName5 = fileName5.substring(fileName5.lastIndexOf("."));  // 后缀名
        // String filePath = "/root/temp-rainy/"; // 上传后的路径
        fileName5 = UUID.randomUUID() + suffixName5; // 新文件名
        File dest5 = new File(filePath + fileName5);
        if (!dest5.getParentFile().exists()) {
            dest5.getParentFile().mkdirs();
        }
        try {
            inphoto1.transferTo(dest5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename5 = "/temp-rainy/" + fileName5;
        // String filename1 = "/temp-rainy/" + fileName1;
        model.addAttribute("filename5", filename5);

        if (inphoto2.isEmpty()) {
            System.out.println("内部照片为空空");
        }
        String fileName6 = inphoto2.getOriginalFilename();  // 文件名
        String suffixName6 = fileName6.substring(fileName6.lastIndexOf("."));  // 后缀名
        // String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName6 = UUID.randomUUID() + suffixName6; // 新文件名
        File dest6 = new File(filePath + fileName6);
        if (!dest6.getParentFile().exists()) {
            dest6.getParentFile().mkdirs();
        }
        try {
            inphoto2.transferTo(dest6);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename6 = "/temp-rainy/" + fileName6;
        // String filename2 = "/temp-rainy/" + fileName2;
        model.addAttribute("filename6", filename6);

        if (inphoto3.isEmpty()) {
            System.out.println("内部照片为空空");
        }
        String fileName7 = inphoto3.getOriginalFilename();  // 文件名
        String suffixName7 = fileName7.substring(fileName7.lastIndexOf("."));  // 后缀名
        // String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName7 = UUID.randomUUID() + suffixName7; // 新文件名
        File dest7 = new File(filePath + fileName7);
        if (!dest7.getParentFile().exists()) {
            dest7.getParentFile().mkdirs();
        }
        try {
            inphoto3.transferTo(dest7);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename7 = "/temp-rainy/" + fileName7;
        // String filename2 = "/temp-rainy/" + fileName2;
        model.addAttribute("filename7", filename7);

        if (inphoto4.isEmpty()) {
            System.out.println("内部照片为空空");
        }
        String fileName8 = inphoto4.getOriginalFilename();  // 文件名
        String suffixName8 = fileName8.substring(fileName8.lastIndexOf("."));  // 后缀名
        // String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName8 = UUID.randomUUID() + suffixName8; // 新文件名
        File dest8 = new File(filePath + fileName8);
        if (!dest8.getParentFile().exists()) {
            dest8.getParentFile().mkdirs();
        }
        try {
            inphoto4.transferTo(dest8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename8 = "/temp-rainy/" + fileName8;
        // String filename2 = "/temp-rainy/" + fileName2;
        model.addAttribute("filename8", filename8);




        String storeid = UUID.randomUUID()+"0";


//        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String times = dateFormat.format(date);

        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH);
        int d=cal.get(Calendar.DATE);
        String times = String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d);
        System.out.println("年份："+y+"月："+m+"日："+d);
        System.out.println(times);
//
//        int h=cal.get(Calendar.HOUR_OF_DAY);
//
//        int mi=cal.get(Calendar.MINUTE);
//
//        int s=cal.get(Calendar.SECOND);
//
//        System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        double [] result = getLatAndLngByBaidu.getCoordinate(address);
        double ln = result[0];
        double la = result[1];
        Store s = new Store(account,storeid,storename,licenseid,address,mobilephone,fixedphone,email,filename4,filename1,filename2,filename3,filename5,filename6,filename7,filename8,describe,times,0,0,1,0,ln,la);
        int flag = stores.insertStore(s);
        Apply ap = new Apply(storeid,0,null);
        int flag2 = apl.inserts(ap);
        if(flag==1){
            return "WriteMessageSuccess";
        }
        return "WriteMessage";
    }


}
