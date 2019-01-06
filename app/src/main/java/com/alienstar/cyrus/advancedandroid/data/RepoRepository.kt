package com.alienstar.cyrus.advancedandroid.data

import com.alienstar.cyrus.advancedandroid.model.Contributor
import com.alienstar.cyrus.advancedandroid.model.Repo

import java.util.ArrayList
import java.util.HashMap

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider
import javax.inject.Singleton

import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Created by cyrus on 3/10/18.
 */
@Singleton
class RepoRepository @Inject
internal constructor(private val repoRequesterProvider: Provider<RepoRequester>,
                     @param:Named("network_scheduler") private val scheduler: Scheduler) {
    private val cachedTrendingRepos = ArrayList<Repo>()
    private val cachedContributors = HashMap<String, List<Contributor>>()

    val trendingRepos: Single<List<Repo>>
        get() = Maybe.concat(cachedTrendingRepos(), apiTrendingRepos())
                .firstOrError()
                .subscribeOn(scheduler)

    fun getRepo(repoOwner: String, repoName: String): Single<Repo> {
        return Maybe.concat(cachedRepo(repoOwner, repoName), apiRepo(repoOwner, repoName))
                .firstOrError()
                .subscribeOn(scheduler)
    }

    fun getContributors(url: String): Single<List<Contributor>> {
        return Maybe.concat(cachedContributors(url), apiContributors(url))
                .firstOrError()
                .subscribeOn(scheduler)
    }

    fun clearCache() {
        cachedTrendingRepos.clear()
        cachedContributors.clear()
    }

    private fun cachedContributors(url: String): Maybe<List<Contributor>> {
        return Maybe.create { e ->
            if (cachedContributors.containsKey(url)) {
                cachedContributors[url]?.let { e.onSuccess(it) }
            }
            e.onComplete()
        }
    }

    private fun apiContributors(url: String): Maybe<List<Contributor>> {
        return repoRequesterProvider.get().getContributors(url)
                .doOnSuccess { contributors -> cachedContributors[url] = contributors }
                .toMaybe()
    }

    private fun cachedRepo(repoOwner: String, repoName: String): Maybe<Repo> {
        return Maybe.create { e ->
            for (cachedRepo in cachedTrendingRepos) {
                if (cachedRepo.owner().login() == repoOwner && cachedRepo.name() == repoName) {
                    e.onSuccess(cachedRepo)
                    break
                }
            }
            e.onComplete()
        }
    }

    private fun apiRepo(repoOwner: String, repoName: String): Maybe<Repo> {
        return repoRequesterProvider.get().getRepo(repoOwner, repoName).toMaybe()
    }

    private fun cachedTrendingRepos(): Maybe<List<Repo>> {
        return Maybe.create { e ->
            if (!cachedTrendingRepos.isEmpty()) {
                e.onSuccess(cachedTrendingRepos)
            }
            e.onComplete()
        }
    }

    private fun apiTrendingRepos(): Maybe<List<Repo>> {
        return repoRequesterProvider.get().trendingRepos
                .doOnSuccess { repos ->
                    cachedTrendingRepos.clear()
                    cachedTrendingRepos.addAll(repos)
                }
                .toMaybe()
    }

}
