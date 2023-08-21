package com.dialafrika.whatsapp.controllers;

import com.dialafrika.whatsapp.dtos.WhatsappMessageWebhook;
import com.dialafrika.whatsapp.services.whatsapp.WebhookService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
public class Webhook {

    @Autowired
    WebhookService webhookService;
    @GetMapping("/webhook/{id}")
    public ResponseEntity<String> validateWebhook(@RequestParam("hub.challenge") String challenge, @PathParam("id") String id) {
        log.info("registering new user of id: {}", id);
        return ResponseEntity.ok(challenge);
    }

    @PostMapping("/webhook/{id}")
    public ResponseEntity<String> receiveMessage(@RequestBody WhatsappMessageWebhook whatsappWebhook) throws IOException {
        // log the whole request
        log.info("Message: {}", whatsappWebhook.toString());
        webhookService.processWebhookService(whatsappWebhook);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        return ResponseEntity.ok().build();
    }
}



