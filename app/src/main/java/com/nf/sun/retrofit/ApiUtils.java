package com.nf.sun.retrofit;

public class ApiUtils
{
    public static final String BASE_URL_weatherData="http://api.openweathermap.org/";
    public static final String BASE_URL_get_country_data="https://restcountries.eu/";
    //https://restcountries.eu/rest/v2/all

    public static IMyAPI getApiClient(){
        return ApiClient.getClient(BASE_URL_weatherData).create(IMyAPI.class);
    }

    public static IMyAPI getApiClientCountryData(){

        return ApiClient.getClient(BASE_URL_get_country_data).create(IMyAPI.class);
    }
}
