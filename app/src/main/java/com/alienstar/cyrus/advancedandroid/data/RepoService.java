package com.alienstar.cyrus.advancedandroid.data;

import com.alienstar.cyrus.advancedandroid.model.Contributor;
import com.alienstar.cyrus.advancedandroid.model.Repo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by cyrus on 3/7/18.
 */

public interface RepoService {
    // url:https://api.github.com/search/repositories?q=language:java&order=desc&sort=stars
    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();

    // url:https://api.github.com/repos/ReactiveX/RxJava
    @GET("repos/{owner}/{name}")
    Single<Repo> getRepo(@Path("owner") String repoOwner, @Path("name") String repoName);

    @GET
    Single<List<Contributor>> getContributors(@Url String url);
}
