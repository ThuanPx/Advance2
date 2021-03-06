package com.example.ths.demosearchuserdagger2.data.source.remote.api;

import android.app.Application;
import com.example.ths.demosearchuserdagger2.BuildConfig;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.middleware.InterceptorImpl;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.BooleanAdapter;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.GitHubApi;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.IntegerAdapter;
import com.example.ths.demosearchuserdagger2.utils.Constant;
import com.example.ths.demosearchuserdagger2.utils.dagger.AppScope;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ths on 23/05/2017.
 */
@Module
public class NetworkModule {
    private static final int CONNECTION_TIMEOUT = 60;
    private Application mApplication;

    public NetworkModule(Application application) {
        mApplication = application;
    }
    @AppScope
    @Provides
    Application provideApplication() {
        return mApplication;
    }
    @AppScope
    @Provides
    Gson provideGson(){
        BooleanAdapter booleanAdapter = new BooleanAdapter();
        IntegerAdapter integerAdapter = new IntegerAdapter();
        return new GsonBuilder()
                .registerTypeAdapter(Boolean.class, booleanAdapter)
                .registerTypeAdapter(boolean.class, booleanAdapter)
                .registerTypeAdapter(Integer.class, integerAdapter)
                .registerTypeAdapter(int.class, integerAdapter)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
    @AppScope
    @Provides
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }
    @AppScope
    @Provides
    Interceptor provideInterceptor() {
        return new InterceptorImpl();
    }
    @AppScope
    @Provides
    OkHttpClient provideOkHttpClient(Cache cache, Interceptor interceptor) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.cache(cache);
        httpClientBuilder.addInterceptor(interceptor);
        httpClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            httpClientBuilder.addInterceptor(logging);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return httpClientBuilder.build();
    }
    @AppScope
    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constant.END_POINT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    @AppScope
    @Provides
    GitHubApi provideNameApi(Retrofit retrofit) {
        return retrofit.create(GitHubApi.class);
    }

}
