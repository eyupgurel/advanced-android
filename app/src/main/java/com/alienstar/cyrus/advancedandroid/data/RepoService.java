package com.alienstar.cyrus.advancedandroid.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by cyrus on 3/7/18.
 */

public interface RepoService {
    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();
}
