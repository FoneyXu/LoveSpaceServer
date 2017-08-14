package org.foney.lovespace.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.foney.lovespace.model.CustomerSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * 
 * @author Administrator
 * 类名：
 * 类描述：拦截配置拦截信息，并将拦截信息交给websocket的WebSocketSession来管理，
 * 因为这样websocket就可以知道用户是否在线，是否不在线了，而且还能给别的用户发送消息，非常的方便。
 * 创建日期：
 */

public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {
	
	@Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
       try {
    	   if (request instanceof ServletServerHttpRequest) {
               ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
               HttpSession session = servletRequest.getServletRequest().getSession(false);
               if (session != null) {
               	CustomerSession customerSession = (CustomerSession)session.getAttribute("customerSession");
                   Integer customerId = customerSession.getId();
                   if(customerId == null) {
                   	customerId = 10;
                   }
                   attributes.put("WEBSOCKET_CUSTOMER_ID",customerId);
               }else {
               	attributes.put("WEBSOCKET_CUSTOMER_ID",10);
               }
           }
		} catch (Exception e) {
			e.printStackTrace();
		}
       return super.beforeHandshake(request, response, wsHandler, attributes);
    }
    
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {
        super.afterHandshake(request, response, wsHandler, ex);
    }
	
}
