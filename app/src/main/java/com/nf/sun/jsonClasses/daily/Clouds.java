package com.nf.sun.jsonClasses.daily;

import com.google.gson.annotations.Expose;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Clouds implements Serializable {

@SerializedName("all")
@Expose
private int all;

public Clouds(int all){
    this.all=all;
}

public int getAll() {
return all;
}

public void setAll(int all) {
this.all = all;
}

}


