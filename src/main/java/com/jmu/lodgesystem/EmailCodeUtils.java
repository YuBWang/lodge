package com.jmu.lodgesystem;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.slf4j.Logger;
import org.slf4j.Logger;


/**
 * @ClassName EmailCodeUtils
 * @Description TODO 邮箱验证码工具类
 * @Author liwenju
 * @Date 2019/5/15 14:20
 * @Version 1.0
 **/

public class EmailCodeUtils {
    /**
     * 生成6位随机验证码
     *
     * @return
     */
    public static String getNumber() {
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * str.length());
            code += str.charAt(index);
        }
        return code;
    }

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public boolean sendSimpleMail(String userEmail) {
        boolean flag = false;
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * str.length());
            code += str.charAt(index);
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(userEmail); //自己给自己发送邮件
        message.setSubject("午托系统注册验证码");
        message.setText(code);
        try {
            mailSender.send(message);
            flag = true;
        } catch (Exception e) {

        }

        return flag;
    }


}
