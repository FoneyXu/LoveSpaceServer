package org.foney.lovespace.websocket;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.foney.lovespace.model.LoveChat;
import org.foney.lovespace.service.LoveChatService;
import org.foney.lovespace.util.SysUtil;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 
 * @author Administrator
 * 类名：
 * 类描述：继承WebSocketHandler对象。该对象提供了客户端连接,关闭,错误,发送等方法,重写这几个方法即可实现自定义业务逻辑
 * SpringWebSocketHandler消息处理类，这个类主要就是用来做消息的逻辑处理的，代码如下。
 * 创建日期：
 */
public class SpringWebSocketHandler extends TextWebSocketHandler{
	
	@Resource
	private LoveChatService loveChatService;
	
	private static final ArrayList<WebSocketSession> CUSTOMERS;//这个会出现性能问题，最好用Map来存储，key用userid
    static {
    	CUSTOMERS = new ArrayList<WebSocketSession>();
    }
    
    public SpringWebSocketHandler() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        CUSTOMERS.add(session);
        Integer customerId= (Integer) session.getAttributes().get("WEBSOCKET_CUSTOMER_ID");
        System.out.println("用户" + customerId + "连接");
        System.out.println("connect to the websocket success......当前数量:"+CUSTOMERS.size());
    }
    
    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    	System.out.println("websocket connection closed......");
        Integer customerId= (Integer) session.getAttributes().get("WEBSOCKET_CUSTOMER_ID");
        System.out.println("用户"+customerId+"已退出！");
        CUSTOMERS.remove(session);
        System.out.println("剩余在线用户"+CUSTOMERS.size());
    }

    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override    
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("用户发送信息");
        String msg = message.getPayload();
        LoveChat loveChat = SysUtil.parseJsonWithGson(msg, LoveChat.class);
        //发送消息给对方
        sendMessageToUser(loveChat.getToCustomerId(), message);
        //保存消息
        loveChatService.saveLoveChat(loveChat);
    	super.handleTextMessage(session, message);
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){session.close();}
//        logger.debug("websocket connection closed......");
        System.out.println("websocket connection closed......");
        CUSTOMERS.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }
    
    
    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(Integer customerId, TextMessage message) {
        for (WebSocketSession customer : CUSTOMERS) {
            if (customer.getAttributes().get("WEBSOCKET_CUSTOMER_ID").equals(customerId)) {
                try {
                    if (customer.isOpen()) {
                    	customer.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession customer : CUSTOMERS) {
            try {
                if (customer.isOpen()) {
                	customer.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
}
