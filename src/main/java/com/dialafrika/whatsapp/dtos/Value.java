package com.dialafrika.whatsapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@ToString
@Data
public class Value {

    @JsonProperty("messaging_product")
    public String messagingProduct;
    @JsonProperty("metadata")
    public Metadata metadata;
    @JsonProperty("contacts")
    public List<Contact> contacts;
    @JsonProperty("messages")
    public List<Message> messages;
}
