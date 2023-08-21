package com.dialafrika.whatsapp.dtos.text_template;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@Data
public class TextTemplate {

    @JsonProperty("messaging_product")
    public String messaging_product;
    @JsonProperty("recipient_type")
    public String recipient_type;
    @JsonProperty("to")
    public String to;
    @JsonProperty("type")
    public String type;
    @JsonProperty("template")
    @Valid
    public Template template;

    @JsonProperty("text")
    public TextMessage text;

}