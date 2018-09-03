package com.example.jangwoo.mvpdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jangwoo.mvpdemo2.repos.RepoListRepository;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRepos();
    }

    private void getRepos() {

        GithubRepository githubRepository = new GithubRepository();
        githubRepository.getRepos("zideajang");

    }
}
