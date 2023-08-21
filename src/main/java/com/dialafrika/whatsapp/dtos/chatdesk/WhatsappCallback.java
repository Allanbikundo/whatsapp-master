package com.dialafrika.whatsapp.dtos.chatdesk;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class WhatsappCallback {

    @JsonProperty("text")
    public String text;
    @JsonProperty("organizationId")
    public Integer organizationId;
    @JsonProperty("phoneNumber")
    public String phoneNumber;

}
