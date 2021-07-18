package com.jmu.lodgesystem.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//整合Druid
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1\配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        //StatViewServlet extends ResourceServlet，在resourceservelet内查找属性
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");
        initParameters.put("allow", "");//默认允许所有
        initParameters.put("deny", "");
        bean.setInitParameters(initParameters);
        return bean;
    }
    //http://localhost:8080/druid/login.html登录查看
    //配置一个web监控的filter
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//
//        bean.setFilter(new WebStatFilter());
//        Map<String,String> initParameters = new HashMap<>();
//        //initParameters.put("exclusions","*.js,*.css,/druid/*");//拦截除了这些文件
//       // bean.setInitParameters(initParameters);
//        //bean.setUrlPatterns(Arrays.asList("/*"));//拦截所有
//
//        return bean;
//    }


}
