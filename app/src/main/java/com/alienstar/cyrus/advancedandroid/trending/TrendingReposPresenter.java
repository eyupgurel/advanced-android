package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.data.RepoRequester;
import com.alienstar.cyrus.advancedandroid.di.ForScreen;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.alienstar.cyrus.advancedandroid.ui.ScreenNavigator;

import javax.inject.Inject;

/**
 * Created by cyrus on 3/8/18.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener{

    private final TrendingReposViewModel viewModel;
    private final RepoRepository repoRepository;
    private final ScreenNavigator screenNavigator;
    private final DisposableManager disposableManager;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel,
                           RepoRepository repoRepository,
                           ScreenNavigator screenNavigator,
                           @ForScreen DisposableManager disposableManager){
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        this.screenNavigator = screenNavigator;
        this.disposableManager = disposableManager;
        loadRepos();
    }

    private void loadRepos() {
        disposableManager.add(repoRepository.getTrendingRepos()
                            .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                            .doOnEvent((d,t) -> viewModel.loadingUpdated().accept(false))
                            .subscribe(viewModel.reposUpdated(), viewModel.onError()));
    }

    @Override
    public void onRepoClicked(Repo repo) {
        screenNavigator.goToRepoDetails(repo.owner().login(), repo.name());
    }
}
