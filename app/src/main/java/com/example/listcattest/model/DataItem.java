package com.example.listcattest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataItem {




    @SerializedName("images")
    @Expose
    private List<Images> images;

    public DataItem(){
    }

    public DataItem(List<Images> images) {

        this.images = images;
    }



    public List<Images> getImages() {
        return images;
    }
}
