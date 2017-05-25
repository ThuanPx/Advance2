package com.example.ths.demoretrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ths on 11/05/2017.
 */

public class ServiceGenerator {
    private static final String URL_ = "https://reqres.in/";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL_)
            .addConverterFactory(GsonConverterFactory.create());

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
    private static OkHttpClient okHttpClient =okBuilder.build();

    public static <T> T createService(Class<T> serviceClass) {
        if (retrofit == null) {
            retrofit = builder.client(okHttpClient).
                    build();
        }
        return retrofit.create(serviceClass);
    }
}
