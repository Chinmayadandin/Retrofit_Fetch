package com.example.retrofitfetch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class ApiInterface {

    public interface ApiService {

       @GET("posts")
        Call<List<Post>> getPosts();

    }
}
