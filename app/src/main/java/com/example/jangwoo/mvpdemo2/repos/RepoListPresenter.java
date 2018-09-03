package com.example.jangwoo.mvpdemo2.repos;

import com.example.jangwoo.mvpdemo2.Model.Repo;

import java.util.List;

public class RepoListPresenter {

    private RepoListActivityView view;
    private RepoListRepository repository;

    public RepoListPresenter(RepoListActivityView view, RepoListRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadRepos() {
        List<Repo> list = repository.getRepos();
        if(list.isEmpty()){
            view.displayNoBRepos();
        }else {
            view.displayRepos(list);
        }
    }

}
