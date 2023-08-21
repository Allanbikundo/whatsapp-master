package com.dialafrika.whatsapp.apis;

import com.dialafrika.whatsapp.dtos.chatdesk.WhatsappCallback;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ChatDeskApi {

    @POST("whatsapp")
    Call<Object> whatsappCallback(@Body WhatsappCallback whatsappCallback);
}
