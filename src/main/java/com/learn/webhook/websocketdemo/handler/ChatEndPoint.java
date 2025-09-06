package com.learn.webhook.websocketdemo.handler;

import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/ws/chat")
@Slf4j
public class ChatEndPoint {

  @OnOpen
  public void onOpen(Session session) {
    log.info("HTTP 101 Switching Protocols: WebSocket handshake successful for session {}", session.getId());
  }
}