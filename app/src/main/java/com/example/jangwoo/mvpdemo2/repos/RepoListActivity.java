package com.example.jangwoo.mvpdemo2.repos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jangwoo.mvpdemo2.Model.Repo;
import com.example.jangwoo.mvpdemo2.R;

import java.util.List;

public class RepoListActivity extends AppCompatActivity implements RepoListActivityView{

    RepoListPresenter presenter;
    private RepoListRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        presenter = new RepoListPresenter(this, null);
    }

    @Override
    public void displayRepos(List<Repo> repos) {

    }

    @Override
    public void displayNoBRepos() {

    }
}
