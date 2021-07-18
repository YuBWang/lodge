package com.jmu.lodgesystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LodgeSystemApplicationTests {


    //    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String sender;
//    @Test
//    public void sendSimpleMail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(sender);
//        message.setTo("yubinwang_b@163.com"); //自己给自己发送邮件
//        message.setSubject("主题：简单邮件");
//
//        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String code = "";
//        for(int i= 0;i<6;i++){
//            int index = (int)(Math.random()*str.length());
//            code+=str.charAt(index);
//        }
//
//        message.setText(code);
//        mailSender.send(message);
//    }
    @Test
    void contextLoads() {
    }

}
