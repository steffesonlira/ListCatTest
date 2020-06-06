package com.example.listcattest.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final String BASE_URL = "https://api.imgur.com/3/gallery/";
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //region getApiService
    public ApiGalleryPhoto getApiService() {
        return this.retrofit.create(ApiGalleryPhoto.class);
    }
    //endregion
}
