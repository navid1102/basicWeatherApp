package com.nf.sun.jsonClasses.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by KarAmad-user on 6/5/2018.
 */
public class Wind implements Serializable {

@SerializedName("speed")
@Expose
private double speed;


@SerializedName("deg")
@Expose
private int deg;

public Wind(double speed,int deg){
    this.speed=speed;
    this.deg=deg;
}

public double getSpeed() {
return speed;
}

public void setSpeed(double speed) {
this.speed = speed;
}


public int getDeg() {
return deg;
}

public void setDeg(int deg) {
this.deg = deg;
}

}
