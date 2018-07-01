package com.nf.sun.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by KarAmad-user on 5/27/2018.
 */

public class GPSTracker extends Service implements LocationListener {

    Context context;

    long minTime=60*1000;
    long minPlace=10;

    double latitude; // latitude
    double longitude; // longitude

    public boolean isnetworkEnabled=false;
    public boolean isGPSEnabled=false;

   public boolean canGetLocation=false;

    Location location;

    LocationManager locationManager;



    public GPSTracker(Context context) {
        this.context=context;
        getLocation();
        getLatitude();
        getLongitude();
    }

    public Location getLocation(){

        locationManager=(LocationManager) context.getSystemService(LOCATION_SERVICE);

        isnetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        isGPSEnabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!isGPSEnabled && !isnetworkEnabled){

        }

        else {

            canGetLocation=true;

            if (isnetworkEnabled){
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTime,minPlace,this);

            if (locationManager!=null){

                location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (location!=null){
                    latitude=location.getLatitude();
                    longitude=location.getLongitude();
                }
            }

        }


        if (isGPSEnabled){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minPlace,this);

            if (locationManager!=null){
                location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (location!=null){
                    latitude=location.getLatitude();
                    longitude=location.getLongitude();
                }
            }
        }
        }

        return location;
    }

    public double getLatitude(){
        if(location!=null){
            latitude=location.getLatitude();
        }
        return latitude;
    }

    public  double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }
        return longitude;
    }

    public boolean canGetLocation(){return this.canGetLocation;}




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
