package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.data.TrendingReposResponse;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.alienstar.cyrus.advancedandroid.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

/**
 * Created by cyrus on 3/9/18.
 */
public class TrendingReposViewModelTest {
    private TrendingReposViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new TrendingReposViewModel();
    }

    @Test
    public void loading() throws Exception {
        TestObserver<Boolean> loadingObserver = viewModel.loading().test();
        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);
        loadingObserver.assertValues(true, false);
    }

    @Test
    public void repos() throws Exception {
        TestObserver<List<Repo>> reposObserver = viewModel.repos().test();
        TrendingReposResponse response = TestUtils.loadJson("mock/search/get_trending_repos.json", TrendingReposResponse.class);
        viewModel.reposUpdated().accept(response.repos());
        reposObserver.assertValue(response.repos());
    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().accept(Collections.emptyList());
        errorObserver.assertValues(R.string.api_error_repos, -1);
    }

}