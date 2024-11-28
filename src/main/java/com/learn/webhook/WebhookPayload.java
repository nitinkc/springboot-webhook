package com.learn.webhook;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WebhookPayload {
    private String event;
    private String data;
}