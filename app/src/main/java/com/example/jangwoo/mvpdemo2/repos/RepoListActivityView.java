package com.example.jangwoo.mvpdemo2.repos;

import com.example.jangwoo.mvpdemo2.Model.Repo;

import java.util.List;

public interface RepoListActivityView {

    void displayRepos(List<Repo> repos);
    void displayNoBRepos();
}
