package com.example.retrofitfetch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static Retrofit retrofit;
    private static final String base_url = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofitInstance() {

        if(retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }
}
