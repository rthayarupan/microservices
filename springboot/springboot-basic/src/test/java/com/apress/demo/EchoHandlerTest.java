package com.apress.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class EchoHandlerTest {

	private final EchoHandler handler = new EchoHandler();
	
	@Test
	public void shouldEchoMessage() throws Exception {
		WebSocketSession mockSession = mock(WebSocketSession.class);
		TextMessage msg = new TextMessage("Hello World!");
	handler.handleTextMessage(mockSession, msg);
	verify(mockSession, times(1))
	.sendMessage(eq(new TextMessage("RECEIVED: Hello World!")));
	}
}
