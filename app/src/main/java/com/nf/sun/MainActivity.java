package com.nf.sun;

import android.app.Application;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.nf.sun.adapter.ViewPagerListAdapter;
import com.nf.sun.fragments.AddLocationFragment;
import com.nf.sun.fragments.CountryCardFragment;
import com.nf.sun.fragments.HomeFragment;
import com.nf.sun.fragments.UpDateFragment;
import com.nf.sun.location.GPSTracker;
import com.nf.sun.utils.ApplicationPermission;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

   /* @BindView(R.id.pager)ViewPager pager;
    @BindView(R.id.indicator)CirclePageIndicator indicator;
    @BindView(R.id.bottom_navigation)BottomNavigationView bottomNavigationView;*/

    BottomNavigationView bottomNavigationView;
    GPSTracker gpsTracker;

   private static Retrofit retrofit=null;

    double lat,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ButterKnife.bind(this);
        gpsTracker=new GPSTracker(getApplicationContext());
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);


        LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean GPSEnabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!GPSEnabled){

            Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }




        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,new HomeFragment()).commit();

                     bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                         @Override
                         public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                             android.support.v4.app.Fragment fragment=null;

                             switch (item.getItemId()){
                                 case R.id.bottom_home:
                                     fragment=new HomeFragment();

                                     break;

                                 case R.id.bottom_country_cards:
                                     fragment=new CountryCardFragment();
                                     break;

                                 case R.id.bottom_update:
                                     fragment=new UpDateFragment();
                                     break;
                             }
                             getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,fragment).commit();
                             return false;
                         }
                     });



        if (Build.VERSION.SDK_INT>=23)
        {
            boolean chek= ApplicationPermission.isLocationPermissionGranted(MainActivity.this);
            if (chek=true){

                try {
                    location();
                }

                catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }else {
            location();
        }


    }

    private void location() {
        this.lat=lat;
        this.lng=lng;

        GPSTracker gpsTracker=new GPSTracker(getApplicationContext());

        if (gpsTracker.canGetLocation()){
            lat=gpsTracker.getLatitude();
            lng=gpsTracker.getLongitude();

            Locale locale=new Locale("fa");

            Geocoder geocoder=new Geocoder(getApplicationContext(),locale);
            try {
                List<Address> addressList=new ArrayList<>();

                addressList=  geocoder.getFromLocation(lat,lng,1);


                Address address=addressList.get(0);
                String country=address.getCountryCode();

               String countryName=address.getCountryName();



            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        location();
    }
}
