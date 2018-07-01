package com.nf.sun.retrofit;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

/**
 * Created by KarAmad-user on 6/6/2018.
 */

public class ApiClient
{



    private static Retrofit retrofit = null;
    private static String TAG=ApiClient.class.getSimpleName();



    public static Retrofit getClient(String BASE_URL) {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }




}
