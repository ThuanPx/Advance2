package com.example.ths.demosearchuserdagger2.data.source.remote.api.middleware;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by ths on 23/05/2017.
 */

public class RxErrorHandlingCallAdapterFactory extends  CallAdapter.Factory {
    private static final String TAG = RxErrorHandlingCallAdapterFactory.class.getName();

    private final RxJava2CallAdapterFactory original;

    private RxErrorHandlingCallAdapterFactory() {
        original = RxJava2CallAdapterFactory.create();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return null;
    }

    public static CallAdapter.Factory create() {
        return new RxErrorHandlingCallAdapterFactory();
    }

    private static class RxCallAdapterWrapper implements CallAdapter<Retrofit,Observable<?>>{
        private final Retrofit retrofit;

        private RxCallAdapterWrapper(Retrofit retrofit) {
            this.retrofit = retrofit;
        }

        @Override
        public Type responseType() {
            return null;
        }

        @Override
        public Observable<?> adapt(Call<Retrofit> call) {
            return null;
        }
    }
}
