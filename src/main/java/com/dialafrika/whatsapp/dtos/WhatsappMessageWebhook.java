package com.dialafrika.whatsapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Generated;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Generated("jsonschema2pojo")
@Data
public class WhatsappMessageWebhook {

    @JsonProperty("object")
    public String object;
    @JsonProperty("entry")
    public List<Entry> entry;

}