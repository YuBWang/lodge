package com.jmu.lodgesystem.chat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jmu.lodgesystem.config.ApplicationHelper;
import com.jmu.lodgesystem.entity.Message;
import com.jmu.lodgesystem.service.MessageService;
import com.jmu.lodgesystem.service.impl.MessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket 聊天服务端
 *
 * @see ServerEndpoint WebSocket服务端 需指定端点的访问路径
 * @see Session   WebSocket会话对象 通过它给客户端发送消息
 */
@Component
@ServerEndpoint("/websocket/{username}")
public class WebSocketChatServer {

    private  static MessageService messages ;
    @Autowired
    public void setWebSocketChatServer(MessageService messages){
        WebSocketChatServer.messages=messages;
    }
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    /**
     * 在线人数
     */
    public static int onlineNumber = 0;
    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, WebSocketChatServer> clients = new ConcurrentHashMap<String, WebSocketChatServer>();
    /**
     * 会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String username;


    /**
     * 当客户端打开连接：1.添加会话对象 2.更新在线人数
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        onlineNumber++;
        log.info("现在来连接的客户id：" + session.getId() + "用户名：" + username);
        this.username = username;
        this.session = session;
        log.info("有新连接加入！ 当前在线人数" + onlineNumber);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("username", username);
        //把自己的信息加入到map当中去
        clients.put(username, this);
    }

    /**
     * 当客户端发送消息：1.获取它的用户名和消息 2.发送消息给所有人
     * <p>
     * PS: 这里约定传递的消息为JSON字符串 方便传递更多参数！
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
        JSONObject jsonObject = JSON.parseObject(message);
        String textMessage = jsonObject.getString("message");
        String fromusername = jsonObject.getString("username");
        String tousername = jsonObject.getString("to");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("textMessage", textMessage);
        map1.put("fromusername", fromusername);
        map1.put("tousername", tousername);
        sendMessageTo(JSON.toJSONString(map1), tousername);
        sendMessageTo(JSON.toJSONString(map1),username);
        int flag=0;
        for (WebSocketChatServer item : clients.values()) {
            System.out.println("item.username:  "+item.username);
            System.out.println("tourusername:  "+tousername);
            if (item.username.equals(tousername)) {
                flag=1;
            }
        }
        System.out.println("执行到这一步了");
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dastr = data.format(fm);
        System.out.println(dastr);
        LocalDateTime d1 = LocalDateTime.parse(dastr,fm);
        Message mess1 = new Message(1,fromusername,tousername,textMessage,data,fromusername,1);
        System.out.println("创建对象成功");
        System.out.println(mess1);
        messages.insertMessage(mess1);
        System.out.println("数据已插入");
        Message mess2 = new Message(1,fromusername,tousername,textMessage,data,tousername,flag);
        messages.insertMessage(mess2);
        log.info("消息已发送===============");

    }

    /**
     * 当关闭连接：1.移除会话对象 2.更新在线人数
     */
    @OnClose
    public void onClose() {
        onlineNumber--;
        //webSockets.remove(this);
        clients.remove(username);
    }

    /**
     * 当通信发生异常：打印错误日志
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 公共方法：发送信息给所有人
     */
    private static void sendMessageToAll(String msg) {
        onlineSessions.forEach((id, session) -> {
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void sendMessageTo(String message, String ToUserName) throws IOException {
        for (WebSocketChatServer item : clients.values()) {
            log.info("item.name"+item.username+"            "+"tousername"+ToUserName);
            if (item.username.equals(ToUserName)) {
                log.info("发送方：====="+username+"接收方"+ToUserName);
                //item.session.getAsyncRemote().sendText(message);
                item.session.getBasicRemote().sendText(message);
                break;
            }
        }
    }



}
