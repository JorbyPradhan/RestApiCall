package com.example.jb.crudrestapi.model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface WebServices {
    String BASE_URL = "https://api.themoviedb.org/3/";
    String Feed = "movie/popular?api_key=7142a40c54b2c690a1f53e697a1d51aa";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    @GET(Feed)
    Call<List<Post>> getPost();

    @GET()
    Call<Post> getPost(@Url String url);

    @GET("org")
    Call<List<Post>> getPost(@Query("oid") Integer[] ids,
                             @Query("_sort") String sortBy,
                             @Query("_order") String orderBy);

    @GET("org")
    Call<List<Post>> getPost(@QueryMap Map<String , String > postMap);

    @POST("org")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("popular?api_key=7142a40c54b2c690a1f53e697a1d51aa&language=en-US&page=1")
    Call<Post> createPost(@Field("oid") int oid,
                          @Field("name") String name,
                          @Field("website") String website,
                          @Field("address") String address,
                          @Field("email") String email,
                          @Field("phone") String phone,
                          @Field("password") String password,
                          @Field("departments") Object departments);

    @FormUrlEncoded
    @POST("org")
    Call<Post> createPost(@FieldMap Map<String, String> postMap);

    @PUT("org/{oid}")
    Call<Post> putPost(@Path("oid") int oid,@Body Post post);

    @PATCH("org/{id}")
    Call<Post> patchPost(@Path("oid") int oid,@Body Post post);

    @DELETE("org/{id}")
    Call<Void> deletePost(@Path("oid") int oid);

}
