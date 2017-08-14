package org.foney.lovespace.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 
 * @author Administrator
 * 类名：
 * 类描述：建立一个类实现WebSocketConfigurer接口
 * WebSocketConfig.java，这一个类似于servlet项目中的@ServerEndpoint注解，它的作用就是在html页面中可以直接访问这个类配置的网址，
 * 从而进行相关逻辑的处理，而不是经过controller层来管理，有了这个类，WebSocketConfig就相当于是controller层了。
 * 创建日期：
 */
@Configuration
@EnableWebSocket
public class SpringWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler(), "/websocket/socketServer").addInterceptors(new SpringWebSocketHandlerInterceptor()).setAllowedOrigins("*");
		registry.addHandler(webSocketHandler(), "/sockjs/socketServer").addInterceptors(new SpringWebSocketHandlerInterceptor()).setAllowedOrigins("*").withSockJS();
	}
	
	@Bean
    public TextWebSocketHandler webSocketHandler(){
        return new SpringWebSocketHandler();
    }
	
}
