package com.apress.demo;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("CONNECTION ESTABLISHED");
		session.sendMessage(new TextMessage("CONNECTION ESTABLISHED"));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		System.out.println("RECEIVED");
		session.sendMessage(new TextMessage("RECEIVED: " + msg));
	}	
}
