package com.example.ths.demosearchuserrx.data.source.remote.api.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ths on 19/05/2017.
 */

public class ClientService {
    private static final String LINK_URL = "https://api.github.com";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(LINK_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());
    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okBuilder =
            new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
    private static OkHttpClient okHttpClient = okBuilder.build();

    public static <T> T createService(Class<T> serviceTClass) {
        if (retrofit == null) {
            retrofit = builder.client(okHttpClient).build();
        }
        return retrofit.create(serviceTClass);
    }
}
