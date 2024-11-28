package com.learn.webhook;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
public class EventController {

    private final WebhookEventProducer eventProducer;

    public EventController(WebhookEventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping("/trigger")
    public String simulateEvent(
            @RequestParam(required = true) String clientUrl,
            @RequestParam(required = false, defaultValue = "defaultEvent") String event,
            @RequestParam(required = false, defaultValue = "defaultData") String data) {
        eventProducer.triggerWebhook(clientUrl, event, data);
        return "Event triggered and webhook sent!";
    }
}
