package com.dialafrika.whatsapp.services.whatsapp;

import com.dialafrika.whatsapp.apis.WhatsappApiService;
import com.dialafrika.whatsapp.dtos.BaseResponseDTO;
import com.dialafrika.whatsapp.dtos.requests.TemplateMessageRequest;
import com.dialafrika.whatsapp.dtos.requests.TextMessageRequest;
import com.dialafrika.whatsapp.dtos.text_template.Language;
import com.dialafrika.whatsapp.dtos.text_template.Template;
import com.dialafrika.whatsapp.dtos.text_template.TextMessage;
import com.dialafrika.whatsapp.dtos.text_template.TextTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TemplateService {

    @Autowired
    WhatsappApiService whatsappApiService;

    public BaseResponseDTO sendWhatsappTextTemplate(TemplateMessageRequest templateMessageRequest) throws IOException {

        //build the textMessage template
        TextTemplate textTemplate = new TextTemplate();
        textTemplate.setMessaging_product("whatsapp");
        textTemplate.setRecipient_type("individual");
        textTemplate.setTo(templateMessageRequest.getPhoneNumber());
        textTemplate.setType("template");

        // create template
        Template template = new Template();
        template.setName("hello_world");

        Language language = new Language();
        language.setCode("en_US");
        template.setLanguage(language);

        textTemplate.setTemplate(template);
        whatsappApiService.getService().sendTextTemplate("118000064615223",textTemplate).execute();
        return  BaseResponseDTO.builder()
                .code("0")
                .message("Message sent successfully")
                .build();
    }

    public BaseResponseDTO sendWhatsappTextMessage(TextMessageRequest textMessageRequest) throws IOException {
        //build the textMessage template
        TextTemplate textTemplate = new TextTemplate();
        textTemplate.setMessaging_product("whatsapp");
        textTemplate.setRecipient_type("individual");
        textTemplate.setTo(textMessageRequest.getPhoneNumber());
        textTemplate.setType("text");

        // create template
        Template template = new Template();
        template.setName("hello_world");

        Language language = new Language();
        language.setCode("en_US");
        template.setLanguage(language);

        textTemplate.setTemplate(template);

        //create textMessage
        TextMessage textMessage = new TextMessage();
        textMessage.setBody(textMessageRequest.getText());

        textTemplate.setText(textMessage);

        //todo: get the phone number id from the database
        whatsappApiService.getService().sendTextMessage("118000064615223",textTemplate).execute();

        return  BaseResponseDTO.builder()
                .code("0")
                .message("Message sent successfully")
                .build();
    }


}

