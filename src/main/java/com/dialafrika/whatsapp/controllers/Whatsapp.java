package com.dialafrika.whatsapp.controllers;

import com.dialafrika.whatsapp.dtos.BaseResponseDTO;
import com.dialafrika.whatsapp.dtos.requests.TemplateMessageRequest;
import com.dialafrika.whatsapp.dtos.requests.TextMessageRequest;
import com.dialafrika.whatsapp.services.whatsapp.TemplateService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/whatsapp")
public class Whatsapp {

    @Autowired
    TemplateService templateService;

    @PostMapping("/send_template_message")
    @CrossOrigin(origins = "*")
    public BaseResponseDTO sendTemplateMessage(@RequestBody @Valid TemplateMessageRequest templateMessageRequest) throws IOException {
        return templateService.sendWhatsappTextTemplate(templateMessageRequest);
    }


    @PostMapping("/send_text_message")
    @CrossOrigin(origins = "*")
    public BaseResponseDTO sendTextMessage(@RequestBody @Valid TextMessageRequest textMessageRequest) throws IOException {
        return templateService.sendWhatsappTextMessage(textMessageRequest);
    }

}
