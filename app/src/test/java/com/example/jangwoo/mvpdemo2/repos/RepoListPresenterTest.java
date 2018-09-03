package com.example.jangwoo.mvpdemo2.repos;

import com.example.jangwoo.mvpdemo2.Model.Repo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class RepoListPresenterTest {

    @Test
    public void shouldPass(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void shouldHandleNoReposFound(){
        //given
        RepoListActivityView view = new MockView();
        RepoListRepository repository = new MockRepoListRepository(false);
        //when
        RepoListPresenter presenter = new RepoListPresenter(view, repository);
        presenter.loadRepos();

        Assert.assertEquals(true,((MockView)view).displayReposWithNoReposCalled);
    }

    @Test
    public void souldPassReposToView(){
        //given
        RepoListActivityView view = new MockView();
        RepoListRepository repository = new MockRepoListRepository(true);
        //when
        RepoListPresenter presenter = new RepoListPresenter(view, repository);
        presenter.loadRepos();
        //then
        Assert.assertEquals(true,((MockView) view).displayReposWithReposCalled);
    }

    private class MockView implements RepoListActivityView{

        boolean displayReposWithReposCalled;
        boolean displayReposWithNoReposCalled;

        @Override
        public void displayRepos(List<Repo> repos) {
            displayReposWithReposCalled = true;
        }

        @Override
        public void displayNoBRepos() {
            displayReposWithNoReposCalled = true;
        }
    }

    private class MockRepoListRepository implements RepoListRepository{

        private boolean returnSomeRepos;

        public MockRepoListRepository(boolean returnSomeRepos) {
            this.returnSomeRepos = returnSomeRepos;
        }

        @Override
        public List<Repo> getRepos() {
            if(returnSomeRepos)
                return Arrays.asList(
                        new Repo(),
                        new Repo(),
                        new Repo()

                );
            else
                return Collections.emptyList();
        }
    }
}