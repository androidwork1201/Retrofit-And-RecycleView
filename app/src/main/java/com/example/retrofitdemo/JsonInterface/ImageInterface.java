package com.example.retrofitdemo.JsonInterface;

import com.example.retrofitdemo.JsonObject.CardItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImageInterface {

    @GET("photos")
    Call<List<CardItem>> getImage();
}
