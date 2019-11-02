package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.R;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import io.reactivex.observers.TestObserver;

/**
 * Created by cyrus on 3/9/18.
 */
public class TrendingReposViewModelTest {
    private TrendingReposViewModel viewModel;

    @BeforeEach
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
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().run();
        errorObserver.assertValues(R.string.api_error_repos, -1);
    }

}