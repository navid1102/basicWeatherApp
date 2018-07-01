package com.nf.sun.retrofit;

import android.icu.util.ULocale;

import com.nf.sun.jsonClasses.daily.Blog;
import com.nf.sun.jsonClasses.forcast.Clouds;
import com.nf.sun.jsonClasses.forcast.Example2;
import com.nf.sun.jsonClasses.daily.Example;
import com.nf.sun.jsonClasses.getCountryData.AllCountryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.nf.sun.retrofit.ServiceGenerator.BASE_URL_RETROFIT;

/**
 * Created by KarAmad-user on 6/5/2018.
 */

public interface IMyAPI
{
    String API_KEY="fcadb22087e743db11e06410c1a5ed7c";

    @GET("weather?mode=json")
    Call<Example> dailyService2(@Query("apikey") String apiKey, @Query("lat") double latitude, @Query("lon") double longitude);

    @GET("/data/2.5/weather")
    Call<Example> dailySevice(@Query("q")String cityName,@Query("APPID")String appId,@Query("units")String unit);


    @GET("/data/2.5/forecast?id={cityID}&APPID=25e2e7d71527a390705f4752f71ced2b")
    Call<Example2> mountlyDta(@Path("cityID")long cityID);


    @GET("list_of_blogs.php")
    Call<List<Blog>> getBlogList();

    @GET("data/2.5/weather?lat=35&lon=139&appid=25e2e7d71527a390705f4752f71ced2b")
    Call<Example> dailyData();

    @GET("rest/v2/name/Russia")
    Call<AllCountryData> getCountryData();

//***************************************************************************
    @GET("/data/2.5/weather")
    Call<com.nf.sun.jsonClasses.CityName.Example> getWeatherFromApi (
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("units") String units,
            @Query("APPID") String appId);
//******************************************************************************



    @GET("/forecast")
    void getWeatherInfo (@Query("lat") String latitude,
                         @Query("lon") String longitude,
                         @Query("cnt") String cnt,
                         @Query("appid") String appid,
                         Callback<Example2> cb);


}
