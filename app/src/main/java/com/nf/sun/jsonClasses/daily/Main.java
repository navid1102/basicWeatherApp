package com.nf.sun.jsonClasses.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by KarAmad-user on 6/5/2018.
 */
public class Main implements Serializable {

@SerializedName("temp")
@Expose
private double temp;


@SerializedName("pressure")
@Expose
private int pressure;


@SerializedName("humidity")
@Expose
private int humidity;


@SerializedName("temp_min")
@Expose
private double tempMin;


@SerializedName("temp_max")
@Expose
private double tempMax;

public Main(double temp,int pressure,int humidity,int tempMin,int tempMax){
    this.temp=temp;
    this.pressure=pressure;
    this.humidity=humidity;
    this.tempMin=tempMin;
    this.tempMax=tempMax;

}




public double getTemp() {
return temp;
}

public void setTemp(double temp) {
this.temp = temp;
}

public int getPressure() {
return pressure;
}

public void setPressure(int pressure) {
this.pressure = pressure;
}

public int getHumidity() {
return humidity;
}

public void setHumidity(int humidity) {
this.humidity = humidity;
}

public double getTempMin() {
return tempMin;
}

public void setTempMin(double tempMin) {
this.tempMin = tempMin;
}

public double getTempMax() {
return tempMax;
}

public void setTempMax(double tempMax) {
this.tempMax = tempMax;
}

}
