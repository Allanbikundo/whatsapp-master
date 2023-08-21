package com.dialafrika.whatsapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@ToString
@Data
public class Message {

    @JsonProperty("from")
    public String from;
    @JsonProperty("id")
    public String id;
    @JsonProperty("timestamp")
    public String timestamp;
    @JsonProperty("type")
    public String type;
    @JsonProperty("text")
    public Text text;

}