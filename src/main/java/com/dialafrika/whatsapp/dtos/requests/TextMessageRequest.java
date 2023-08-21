package com.dialafrika.whatsapp.dtos.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class TextMessageRequest {

    @NotNull
    @Pattern(regexp="^[0-9]{12}$")
    String phoneNumber;

    @NotNull
    String organizationId;

    String text;

}
