package com.dialafrika.whatsapp.apis;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
@Service
public class ChatDeskApiService {

    private static Retrofit retrofit;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatDeskApiService.class);



    @PostConstruct
    public void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(LOGGER::info);

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://chatdesk-prod.dialafrika.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public ChatDeskApi getService() {
        return retrofit.create(ChatDeskApi.class);
    }

}
