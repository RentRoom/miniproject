package com.Service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class DBFactory
{
    final public static String BASE_URL = "http://203.195.224.226:8081/Qshelter/";

    /**
     * 创建OkHttp实例
     * @return
     */
    private static OkHttpClient createOkHttp()
    {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    /**
     * 创建Retrofit
     * @param url
     * @return
     */
    private static Retrofit createRetrofit(String url)
    {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(createOkHttp())
                .build();
    }

    /**
     * 创建服务
     * @return
     */
    public static DbService createDBService()
    {
        Retrofit retrofit = createRetrofit(BASE_URL);
        DbService service = retrofit.create(DbService.class);
        return service;
    }
}
