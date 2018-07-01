package com.nf.sun.jsonClasses.forcast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by KarAmad-user on 6/5/2018.
 */
public class Clouds {

@SerializedName("all")
@Expose
private Integer all;

public Integer getAll() {
return all;
}

public void setAll(Integer all) {
this.all = all;
}

}
