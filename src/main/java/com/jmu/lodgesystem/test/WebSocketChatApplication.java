package com.jmu.lodgesystem.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@Controller
public class WebSocketChatApplication {

   @RequestMapping("start1")
    public String testStart(HttpServletRequest request){
       System.out.println("条进来了");
       String s = request.getParameter("test");
       System.out.println(s);
       return "test/index";
   }
   @RequestMapping("l")
    public String to(){
       return "test/test";
   }
}
