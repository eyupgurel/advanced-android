package com.alienstar.cyrus.advancedandroid.trending

import com.alienstar.cyrus.advancedandroid.data.RepoRepository
import com.alienstar.cyrus.advancedandroid.di.ForScreen
import com.alienstar.cyrus.advancedandroid.di.ScreenScope
import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager
import com.alienstar.cyrus.advancedandroid.model.Repo
import com.alienstar.cyrus.advancedandroid.ui.ScreenNavigator
import com.alienstar.cyrus.poweradapter.adapter.RecyclerDataSource

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer

/**
 * Created by cyrus on 3/8/18.
 */
@ScreenScope
internal class TrendingReposPresenter @Inject
constructor(private val viewModel: TrendingReposViewModel,
            private val repoRepository: RepoRepository,
            private val screenNavigator: ScreenNavigator,
            @param:ForScreen private val disposableManager: DisposableManager,
            private val dataSource: RecyclerDataSource) {

    init {
        loadRepos()
    }

    private fun loadRepos() {
        disposableManager.add(repoRepository.trendingRepos
                .doOnSubscribe { viewModel.loadingUpdated().accept(true) }
                .doOnEvent { _ , _ -> viewModel.loadingUpdated().accept(false) }
                .doOnSuccess { viewModel.reposUpdated().run() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<List<Repo>> {
                    dataSource.setData(it)
                }, viewModel.onError()))
    }

    fun onRepoClicked(repo: Repo) {
        screenNavigator.goToRepoDetails(repo.owner().login(), repo.name())
    }


}
