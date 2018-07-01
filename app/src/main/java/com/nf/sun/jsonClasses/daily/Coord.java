package com.nf.sun.jsonClasses.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by KarAmad-user on 6/5/2018.
 */
public class Coord implements Serializable {

@SerializedName("lon")
@Expose
private int lon;


@SerializedName("lat")
@Expose
private int lat;



public Coord(int lon,int lat){
    this.lon=lon;
    this.lat=lat;
}



public int getLon() {
return lon;
}

public void setLon(int lon) {
this.lon = lon;
}

public int getLat() {
return lat;
}

public void setLat(int lat) {
this.lat = lat;
}

}
