package com.alienstar.cyrus.advancedandroid.data

import com.alienstar.cyrus.advancedandroid.model.Contributor
import com.alienstar.cyrus.advancedandroid.model.Repo

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 * Created by cyrus on 3/7/18.
 */

interface RepoService {
    // url:https://api.github.com/search/repositories?q=language:java&order=desc&sort=stars
    @get:GET("search/repositories?q=language:java&order=desc&sort=stars")
    val trendingRepos: Single<TrendingReposResponse>

    // url:https://api.github.com/repos/ReactiveX/RxJava
    @GET("repos/{owner}/{name}")
    fun getRepo(@Path("owner") repoOwner: String, @Path("name") repoName: String): Single<Repo>

    @GET
    fun getContributors(@Url url: String): Single<List<Contributor>>
}
