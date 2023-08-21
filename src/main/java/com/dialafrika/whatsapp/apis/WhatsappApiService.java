package com.dialafrika.whatsapp.apis;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
@Service
public class WhatsappApiService {

    @Value("${whatsapp.access-token}")
    private String whatsappAccessToken;
    private static Retrofit retrofit;

    private static final Logger LOGGER = LoggerFactory.getLogger(WhatsappApiService.class);

    @PostConstruct
    public void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(LOGGER::info);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", "Bearer " + whatsappAccessToken)
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://graph.facebook.com/v16.0/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public WhatsappApi getService() {
        return retrofit.create(WhatsappApi.class);
    }

}
