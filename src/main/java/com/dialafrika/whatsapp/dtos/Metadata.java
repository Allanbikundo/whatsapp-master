package com.dialafrika.whatsapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
@ToString
public class Metadata {

    @JsonProperty("display_phone_number")
    public String displayPhoneNumber;
    @JsonProperty("phone_number_id")
    public String phoneNumberId;

}