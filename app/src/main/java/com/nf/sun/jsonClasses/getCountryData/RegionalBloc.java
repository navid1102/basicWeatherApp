package com.nf.sun.jsonClasses.getCountryData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionalBloc {

@SerializedName("acronym")
@Expose
private String acronym;
@SerializedName("name")
@Expose
private String name;
@SerializedName("otherAcronyms")
@Expose
private List<String> otherAcronyms = null;
@SerializedName("otherNames")
@Expose
private List<Object> otherNames = null;

public String getAcronym() {
return acronym;
}

public void setAcronym(String acronym) {
this.acronym = acronym;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<String> getOtherAcronyms() {
return otherAcronyms;
}

public void setOtherAcronyms(List<String> otherAcronyms) {
this.otherAcronyms = otherAcronyms;
}

public List<Object> getOtherNames() {
return otherNames;
}

public void setOtherNames(List<Object> otherNames) {
this.otherNames = otherNames;
}

}
