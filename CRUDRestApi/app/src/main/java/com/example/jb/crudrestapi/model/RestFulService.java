package com.example.jb.crudrestapi.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RestFulService {
    String BASE_URL = "http://192.168.1.2:8899/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    @POST("Movie")
    Call<Movie> createPost(@Body Movie movie);

    @GET("Movie")
    Call<List<Movie>> getAllMovie();

}
