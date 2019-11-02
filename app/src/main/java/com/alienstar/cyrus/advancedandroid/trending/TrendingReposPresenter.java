package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.di.ForScreen;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.alienstar.cyrus.advancedandroid.ui.ScreenNavigator;
import com.alienstar.cyrus.poweradapter.adapter.RecyclerDataSource;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by cyrus on 3/8/18.
 */
@ScreenScope
class TrendingReposPresenter{
    private final TrendingReposViewModel viewModel;
    private final RepoRepository repoRepository;
    private final ScreenNavigator screenNavigator;
    private final DisposableManager disposableManager;
    private final RecyclerDataSource dataSource;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel,
                           RepoRepository repoRepository,
                           ScreenNavigator screenNavigator,
                           @ForScreen DisposableManager disposableManager,
                           RecyclerDataSource dataSource){
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        this.screenNavigator = screenNavigator;
        this.disposableManager = disposableManager;
        this.dataSource = dataSource;
        loadRepos();
    }

    private void loadRepos() {
        disposableManager.add(repoRepository.getTrendingRepos()
                            .doOnSubscribe( __ -> viewModel.loadingUpdated().accept(true))
                            .doOnEvent((d,t) -> viewModel.loadingUpdated().accept(false))
                            .doOnSuccess( __ -> viewModel.reposUpdated().run())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(dataSource::setData, viewModel.onError()));
    }

    void onRepoClicked(Repo repo) {
        screenNavigator.goToRepoDetails(repo.owner().login(), repo.name());
    }


}
