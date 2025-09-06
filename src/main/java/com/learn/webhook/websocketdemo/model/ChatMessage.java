package com.learn.webhook.websocketdemo.model;

import lombok.Data;

@Data
public class ChatMessage {
    private String sender;
    private String content;
}