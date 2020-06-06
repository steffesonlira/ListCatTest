package com.example.listcattest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Images {

    @Expose
    @SerializedName("link")
    private String link;
    @Expose
    @SerializedName("type")
    private String type;

    public Images() {

    }

    public Images(String link, String type) {
        this.link = link;
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
