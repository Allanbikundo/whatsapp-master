package com.dialafrika.whatsapp.services.whatsapp;

import com.dialafrika.whatsapp.apis.ChatDeskApiService;
import com.dialafrika.whatsapp.dtos.WhatsappMessageWebhook;
import com.dialafrika.whatsapp.dtos.chatdesk.WhatsappCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WebhookService {
    @Autowired
    ChatDeskApiService chatDeskApiService;

    public void processWebhookService(WhatsappMessageWebhook whatsappMessage) {
        whatsappMessage.getEntry().forEach(entry -> {
            entry.getChanges().forEach(change -> {
                change.getValue().getMessages().forEach(message -> {
                    WhatsappCallback whatsappCallback = WhatsappCallback
                            .builder()
                            .text(message.getText().getBody())
                            .phoneNumber(message.getFrom())
                            .organizationId(1)
                            .build();
                    try {
                        chatDeskApiService.getService().whatsappCallback(whatsappCallback).execute();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        });
    }
}
