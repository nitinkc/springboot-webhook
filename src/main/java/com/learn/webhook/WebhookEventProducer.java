package com.learn.webhook;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebhookEventProducer {

    private final RestTemplate restTemplate;

    public void triggerWebhook(String clientUrl, String event, String data) {
        // Prepare the payload
        WebhookPayload payload = new WebhookPayload();
        payload.setEvent(event);
        payload.setData(data);

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // Wrap payload in an HTTP request entity
        HttpEntity<WebhookPayload> request = new HttpEntity<>(payload, headers);

        // Make the POST request
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    clientUrl,
                    HttpMethod.POST,
                    request,
                    String.class
            );

            log.info("Webhook sent successfully! Response: {}", response.getBody());
        } catch (Exception e) {
            log.error("Failed to send webhook: {}", e.getMessage());
        }
    }
}