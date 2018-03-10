package com.alienstar.cyrus.advancedandroid.data;

import com.alienstar.cyrus.advancedandroid.test.TestUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by cyrus on 3/10/18.
 */
@Singleton
public class TestRepoService implements RepoService  {

    private boolean sendError;
    private final TestUtils testUtils;

    @Inject
    TestRepoService(TestUtils testUtils) {
        this.testUtils = testUtils;
    }

    @Override
    public Single<TrendingReposResponse> getTrendingRepos() {
        if (!sendError) {
            TrendingReposResponse response = testUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
            return Single.just(response);
        }
        return Single.error(new IOException());
    }

    public void setSendError(boolean sendError){
        this.sendError = sendError;
    }
}
