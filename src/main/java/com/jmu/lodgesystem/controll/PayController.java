package com.jmu.lodgesystem.controll;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jmu.lodgesystem.AlipayConfig;
import com.jmu.lodgesystem.entity.Orderlist;
import com.jmu.lodgesystem.entity.Orders;
import com.jmu.lodgesystem.entity.ProMessage;
import com.jmu.lodgesystem.entity.Store;
import com.jmu.lodgesystem.service.OrderlistService;
import com.jmu.lodgesystem.service.ProMessageService;
import com.jmu.lodgesystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PayController {
    @Autowired
    private ProMessageService p;
    @Autowired
    private OrderlistService orderlist;
    @Autowired
    private StoreService store;


    @RequestMapping("/pay")
    @ResponseBody
    public void payController(String proid,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        ProMessage promess = p.findByProId(proid);
        String orderid = UUID.randomUUID()+"0";
        String storid = promess.getStoreid();
        String proids = promess.getProductid();
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");

        Store s = store.findById(storid);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderid;
        //付款金额，必填
        String total_amount = String.valueOf(promess.getEarmoney());
        //订单名称，必填
        String subject = s.getStorename()+"商品:"+promess.getTypes();
        //商品描述，可空
        String body = "时间："+promess.getStartday()+"--"+promess.getEndday()+"定金"+promess.getEarmoney();

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            Orderlist orders = new Orderlist(orderid,storid,proids,userid,1);
            orderlist.insertOrder(orders);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
    @RequestMapping("/pay2")
    @ResponseBody
    public void payController2(String listid,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        Orders li = orderlist.findBylistId(listid);
        String orderid = UUID.randomUUID()+"0";
        String storid = li.getStoreid();
        String proids = li.getProductid();
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");


        Store s = store.findById(storid);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderid;
        //付款金额，必填
        String total_amount = String.valueOf(li.getAllmoney()-li.getEarmoney());
        //订单名称，必填
        String subject = s.getStorename()+"商品:"+li.getTypes();
        //商品描述，可空
        String body = "时间："+li.getStartday()+"--"+li.getEndday()+"金额"+total_amount;

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");


        //请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            int flag = orderlist.updateStatus(listid,2);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }


    @RequestMapping("return1")
    public String return1(){
        return "return1";
    }
    @RequestMapping("return2")
    public String return2(){
        return "return2";
    }

}
