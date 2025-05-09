package com.example.retrofitfetch;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView blogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blogView = findViewById(R.id.textViewPosts);

        fetchPosts();



    }

    private void fetchPosts() {

        ApiInterface.ApiService apiService = RetroFitClient.getRetrofitInstance().create(ApiInterface.ApiService.class);
        Call<List<Post>> call = apiService.getPosts();

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    StringBuilder blogTitles = new StringBuilder();

                    for (Post post : response.body()) {

                        blogTitles.append(post.getTitle()).append("\n\n");
                    }

                    blogView.setText(blogTitles.toString());
                } else {

                    Toast.makeText(MainActivity.this, "Failed to load posts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {


                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}