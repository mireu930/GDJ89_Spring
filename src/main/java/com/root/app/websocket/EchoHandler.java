package com.root.app.websocket;

import java.lang.System.Logger;

import org.mybatis.logging.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@RequestMapping(value = "/echo")
public class EchoHandler extends TextWebSocketHandler {
	
//	private final static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	//Ŭ���̾�Ʈ�� ����Ǿ����� ����
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
	}
	
	//Ŭ���̾�Ʈ�� �޽��� �����Ҷ� ����
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}

	//Ŭ���̾�Ʈ�� ������ �������� ����
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}
}
