package com.nf.sun.jsonClasses.daily;

import com.google.gson.annotations.SerializedName;

public class Blog {

    @SerializedName("blog_address")
    private String blogAddress;
    @SerializedName("blog_author")
    private String blogAuthor;

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }
}