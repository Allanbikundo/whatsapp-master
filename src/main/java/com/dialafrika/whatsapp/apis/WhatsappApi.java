package com.dialafrika.whatsapp.apis;

import com.dialafrika.whatsapp.dtos.text_template.TextTemplate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WhatsappApi {

    //create template , get template , send message

    @POST("{phone_number_id}/messages")
    Call<Object> sendTextTemplate(
            @Path("phone_number_id") String phoneNumberId,
            @Body TextTemplate textTemplate);

    @POST("{phone_number_id}/messages")
    Call<Object> sendTextMessage(
            @Path("phone_number_id") String phoneNumberId,
            @Body TextTemplate textTemplate);
}
