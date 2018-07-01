package com.nf.sun;

import android.app.Application;
import android.app.Fragment;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.nf.sun.R;
import com.nf.sun.adapter.ViewPagerListAdapter;
import com.nf.sun.fragments.AddLocationFragment;
import com.nf.sun.fragments.CountryCardFragment;
import com.nf.sun.fragments.HomeFragment;
import com.nf.sun.fragments.UpDateFragment;
import com.nf.sun.fragments.WetherDataFragment;
import com.nf.sun.jsonClasses.CityName.Example;
import com.nf.sun.location.GPSTracker;
import com.nf.sun.utils.ApplicationPermission;
import com.viewpagerindicator.CirclePageIndicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

   /* @BindView(R.id.pager)ViewPager pager;
    @BindView(R.id.indicator)CirclePageIndicator indicator;
    @BindView(R.id.bottom_navigation)BottomNavigationView bottomNavigationView;*/

    BottomNavigationView bottomNavigationView;

    private static Retrofit retrofit=null;

    double lat,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ButterKnife.bind(this);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,new HomeFragment()).commit();

        isconected();

        NotificationCompat.Builder notif=new NotificationCompat.Builder(getApplicationContext(),"nn");
        notif.setContentTitle("temperature");
        notif.setContentText("new temp:");
        notif.setSmallIcon(R.mipmap.ic_launcher_round);
        notif.setAutoCancel(true);
        notif.setVibrate(new long[]{100,200,100,200});

        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notif.build());



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

    public void isconected()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if (networkInfo!=null && networkInfo.isConnected()){
            Toast.makeText(getApplicationContext(),"connected",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "خطا در اتصال به اینترنت!", Toast.LENGTH_LONG).show();

        }
    }
}
