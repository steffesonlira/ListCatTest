package com.example.listcattest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatResponse {


    @SerializedName("data")
    @Expose
    private List<DataItem> data = null;

    public CatResponse(List<DataItem> data) {
        this.data = data;
    }

    public List<DataItem> getData() {
        return data;
    }
}
