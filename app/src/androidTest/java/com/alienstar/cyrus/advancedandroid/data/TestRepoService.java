package com.alienstar.cyrus.advancedandroid.data;

import android.os.Handler;
import android.os.Looper;

import com.alienstar.cyrus.advancedandroid.model.Contributor;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.alienstar.cyrus.advancedandroid.test.TestUtils;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by cyrus on 3/10/18.
 */
@Singleton
public class TestRepoService implements RepoService  {

    public static final int FLAG_TRENDING_REPOS = 1;
    public static final int FLAG_GET_REPO = 2;
    public static final int FLAG_GET_CONTRIBUTORS = 4;

    private final TestUtils testUtils;

    private int errorFlags;
    private int holdFlags;

    @Inject
    TestRepoService(TestUtils testUtils) {
        this.testUtils = testUtils;
    }

    @Override
    public Single<TrendingReposResponse> getTrendingRepos() {
        if ((errorFlags & FLAG_TRENDING_REPOS) == 0) {
            TrendingReposResponse response = testUtils.loadJson("mock/search/get_trending_repos.json", TrendingReposResponse.class);
            if((holdFlags & FLAG_TRENDING_REPOS) == FLAG_TRENDING_REPOS) {
                return holdingSingle(response, FLAG_TRENDING_REPOS);
            }
            return Single.just(response);
        }
        return Single.error(new IOException());
    }

    @Override
    public Single<Repo> getRepo(String repoOwner, String repoName) {
        if ((errorFlags & FLAG_GET_REPO) == 0) {
            Repo repo = testUtils.loadJson("mock/repos/get_repo.json", Repo.class);
            if((holdFlags & FLAG_GET_REPO) == FLAG_GET_REPO) {
                return holdingSingle(repo, FLAG_GET_REPO);
            }
            return Single.just(repo);
        }
        return Single.error(new IOException());
    }

    @Override
    public Single<List<Contributor>> getContributors(String url) {
        if ((errorFlags & FLAG_GET_CONTRIBUTORS) == 0) {
            List<Contributor> contributors = testUtils.loadJson("mock/repos/contributors/get_contributors.json",
                                                                      Types.newParameterizedType(List.class,
                                                                                                 Contributor.class));
            if((holdFlags & FLAG_GET_CONTRIBUTORS) == FLAG_GET_CONTRIBUTORS) {
                return holdingSingle(contributors, FLAG_GET_CONTRIBUTORS);
            }
            return Single.just(contributors);
        }
        return Single.error(new IOException());
    }

    private <T> Single<T> holdingSingle(T result, int flag) {
        return Single.create(e -> {
            final Handler handler  = new Handler(Looper.getMainLooper());
            Runnable holdRunnable = new Runnable() {
                @Override
                public void run() {
                    if((holdFlags & flag) == flag){
                        handler.postDelayed(this,50);
                    } else {
                        e.onSuccess(result);
                    }
                }
            };
            holdRunnable.run();
        });
    }

    public void setErrorFlags(int errorFlags) {
        this.errorFlags = errorFlags;
    }

    public void clearErrorFlags() {
        this.errorFlags = 0;
    }

    public void setHoldFlags(int holdFlags) {
        this.holdFlags = holdFlags;
    }

    public void clearHoldFlags() {
        this.holdFlags = 0;
    }
}
