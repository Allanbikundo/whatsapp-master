package com.dialafrika.whatsapp.dtos.text_template;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TextMessage {
    public String preview_url;
    public String body;

}
