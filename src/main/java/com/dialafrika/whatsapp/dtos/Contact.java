package com.dialafrika.whatsapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Generated("jsonschema2pojo")
public class Contact {

    @JsonProperty("profile")
    public Profile profile;
    @JsonProperty("wa_id")
    public String waId;

}