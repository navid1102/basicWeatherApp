package com.nf.sun.fragments;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nf.sun.MainActivity;
import com.nf.sun.R;
import com.nf.sun.jsonClasses.getCountryData.AllCountryData;
import com.nf.sun.location.GPSTracker;
import com.nf.sun.retrofit.ApiClient;
import com.nf.sun.retrofit.ApiUtils;
import com.nf.sun.retrofit.IMyAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WetherDataFragment extends Fragment {





public  static final String URL="http://api.openweathermap.org/";

    String API_KEY="b5f8100428ca05de43f7ffed109ceaf3";


   // WetherData wetherData;



    public WetherDataFragment() {
        // Required empty public constructor

    }


    @BindView(R.id.current_temperature_field)TextView text_temp;
    @BindView(R.id.city_field)TextView text_cityName;
    @BindView(R.id.weather_icon)TextView weatherIcon;
    @BindView(R.id.details_field)TextView detailsField;
    @BindView(R.id.addres)TextView addresField;
    @BindView(R.id.celsius_text)TextView celsiusText;
    @BindView(R.id.max_temp)TextView maxTempText;
    @BindView(R.id.min_temp)TextView minTempText;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        GPSTracker gpsTracker=new GPSTracker(getActivity());

        View view= inflater.inflate(R.layout.fragment_wether_data, container, false);

        ButterKnife.bind(this,view);

        double s1=((gpsTracker.getLatitude()));
        double s2=((gpsTracker.getLongitude()));

        NewDat(s1,s2);


        //getCountryData();
        //  apiClient=new ApiClient();
        // volleyServiceCaller=new VolleyServiceCaller(getActivity());
        // getWetherData();


        return view;
    }



//====================================*******  get data with Retrofit********  ==============================
    public void NewDat(double lat,double lon){

//--------------------------------------------for get address and set in the textView----------------
        Locale locale=new Locale("fa");

        Geocoder geocoder=new Geocoder(getActivity(),locale);
        List<Address> addressList=new ArrayList<>();

        try {
            addressList = geocoder.getFromLocation(lat, lon, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Address address=addressList.get(0);
        final String country=address.getCountryName();
        final String ostan=address.getAdminArea();
        final String shahr=address.getSubAdminArea();
        final String local=address.getLocality();
//--------------------------------------------------get data from api with retrofit--------------------------------

        IMyAPI iMyAPI=ApiClient.getClient(URL).create(IMyAPI.class);
        iMyAPI.getWeatherFromApi(lat+"",lon+"","metric",API_KEY).enqueue(new Callback<com.nf.sun.jsonClasses.CityName.Example>() {
            @Override
            public void onResponse(Call<com.nf.sun.jsonClasses.CityName.Example> call, Response<com.nf.sun.jsonClasses.CityName.Example> response) {

                if (response.isSuccessful()){
                    Log.d("oooookkkk","response");

                    com.nf.sun.jsonClasses.CityName.Example example=response.body();
                    String cityName=example.getName();
                    String temp=example.getMain().getTemp().toString();
                    String minTemp=example.getMain().getTempMin().toString();
                    String maxTemp=example.getMain().getTempMax().toString();
                   // List<Weather> data=example.getWeather().get(1);

                   // weather_report.setText(response.getList().get(0).getWeather().get(0).getDescription());
                    detailsField.setText(response.body().getWeather().get(0).getDescription());
                    text_cityName.setText(cityName);
                    addresField.setText(country+"-"+ostan+"-"+shahr+"-"+local);
                    MainActivity mainActivity=new MainActivity();
                    text_temp.setText(temp);
                    celsiusText.setText(R.string.wi_celsius);
                    minTempText.setText(minTemp);
                    maxTempText.setText(maxTemp);

//---------------------------set icon for difrent weather data--------------------------------------

                    switch (response.body().getWeather().get(0).getIcon()){
                        case "01d":
                            weatherIcon.setText(R.string.wi_day_sunny);
                            break;
                        case "02d":
                            weatherIcon.setText(R.string.wi_cloudy_gusts);
                            break;
                        case "03d":
                            weatherIcon.setText(R.string.wi_cloud_down);
                            break;
                        case "04d":
                            weatherIcon.setText(R.string.wi_cloudy);
                            break;
                        case "04n":
                            weatherIcon.setText(R.string.wi_night_cloudy);
                            break;
                        case "10d":
                            weatherIcon.setText(R.string.wi_day_rain_mix);
                            break;
                        case "11d":
                            weatherIcon.setText(R.string.wi_day_thunderstorm);
                            break;
                        case "13d":
                            weatherIcon.setText(R.string.wi_day_snow);
                            break;
                        case "01n":
                            weatherIcon.setText(R.string.wi_night_clear);
                            break;
                        case "02n":
                            weatherIcon.setText(R.string.wi_night_cloudy);
                            break;
                        case "03n":
                            weatherIcon.setText(R.string.wi_night_cloudy_gusts);
                            break;
                        case "10n":
                            weatherIcon.setText(R.string.wi_night_cloudy_gusts);
                            break;
                        case "11n":
                            weatherIcon.setText(R.string.wi_night_rain);
                            break;
                        case "13n":
                            weatherIcon.setText(R.string.wi_night_snow);
                            break;
                    }


                }
                else
                    {
                    Log.d("oooookkkk","else");
                }
            }

            @Override
            public void onFailure(Call<com.nf.sun.jsonClasses.CityName.Example> call, Throwable t) {

                if (t instanceof IOException){
                    Log.d("faiiiiil","no internet");

                }else {
                    Log.d("fail","errrroooorrrrr");
                }
            }
        });
    }





//=============================api for get country data and set in the country card fragment===================

    public void getCountryData(){

        IMyAPI iMyAPI= ApiUtils.getApiClientCountryData();
        iMyAPI.getCountryData().enqueue(new Callback<AllCountryData>() {
            @Override
            public void onResponse(Call<AllCountryData> call, Response<AllCountryData> response) {

                if (response.isSuccessful()){
                    Log.d("okkkk","succese");
                }
                else {
                    Log.d("ok","error");
                }
            }

            @Override
            public void onFailure(Call<AllCountryData> call, Throwable t) {

                Log.d("faile","faile");
            }
        });
    }
//==================================================================================================

}
