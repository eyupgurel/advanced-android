package com.alienstar.cyrus.advancedandroid.data;

import com.alienstar.cyrus.advancedandroid.model.Contributor;
import com.alienstar.cyrus.advancedandroid.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by cyrus on 3/7/18.
 */

public class RepoRequester {
    private final RepoService service;
    @Inject
    RepoRequester(RepoService service) {
        this.service = service;
    }
    public Single<List<Repo>> getTrendingRepos() {
        return service.getTrendingRepos()
                .map(TrendingReposResponse::repos);
    }

    public Single<Repo> getRepo(String repoOwner, String repoName) {
        return service.getRepo(repoOwner, repoName);
    }

    public Single<List<Contributor>> getContributors(String url) {
        return service.getContributors(url);
    }

}
