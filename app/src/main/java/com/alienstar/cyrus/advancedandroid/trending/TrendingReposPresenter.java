package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.data.RepoRequester;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.model.Repo;

import javax.inject.Inject;

/**
 * Created by cyrus on 3/8/18.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener{

    private TrendingReposViewModel viewModel;
    private RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository){
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        loadRepos();
    }

    private void loadRepos() {
        repoRepository.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d,t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
