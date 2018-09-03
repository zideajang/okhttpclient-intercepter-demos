package com.example.jangwoo.mvpdemo2;

import android.util.Log;

import com.example.jangwoo.mvpdemo2.Model.Repo;
import com.example.jangwoo.mvpdemo2.api.ApiService;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRepository {




    private static final String TAG = "GithubRepository";

    public void getRepos(String username){
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new AddHeaderInterceptor());
//        httpClient.addInterceptor(new LogJsonIntercepter());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())

                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.listRepos(username)
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        Log.d(TAG, "onResponse: " + response.body().size());
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }
                });
    }
}
