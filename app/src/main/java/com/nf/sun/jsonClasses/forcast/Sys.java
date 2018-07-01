package com.nf.sun.jsonClasses.forcast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by KarAmad-user on 6/5/2018.
 */
public class Sys {

@SerializedName("pod")
@Expose
private String pod;

public String getPod() {
return pod;
}

public void setPod(String pod) {
this.pod = pod;
}

}
