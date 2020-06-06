package com.example.listcattest.retrofit;

import com.example.listcattest.model.CatResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiGalleryPhoto {

    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("search/?q=cats")
    Call<CatResponse> getPhoto();

}
