package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.data.TrendingReposResponse;
import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.alienstar.cyrus.advancedandroid.testutils.TestUtils;
import com.alienstar.cyrus.advancedandroid.ui.ScreenNavigator;
import com.alienstar.cyrus.poweradapter.adapter.RecyclerDataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayName("TrendingReposPresenter test")
public class TrendingReposPresenterTest {
    static {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }
    @Mock RepoRepository repoRepository;
    @Mock TrendingReposViewModel viewModel;
    @Mock Consumer<Throwable> onErrorConsumer;
    @Mock Consumer<Boolean> loadingConsumer;
    @Mock ScreenNavigator screenNavigator;
    @Mock DisposableManager disposableManager;
    @Mock RecyclerDataSource dataSource;

    private TrendingReposPresenter presenter;

    @Test
    public void reposLoaded() throws Exception {
        //  setup mocks
        List<Repo> repos = setUpSuccess();
        //  run unit
        initializePresenter();
        //  verify
        verify(repoRepository).getTrendingRepos();
        verify(dataSource).setData(repos);
        verifyNoInteractions(onErrorConsumer);
    }


    @Test
    public void reposLoadedError() throws Exception {

        Throwable error = setUpError();
        initializePresenter();

        verify(onErrorConsumer).accept(error);
        verifyNoInteractions(dataSource);
    }

    @Test
    public void loadingSuccess() throws Exception {

        setUpSuccess();
        initializePresenter();

        InOrder inOrder = Mockito.inOrder(loadingConsumer);
        inOrder.verify(loadingConsumer).accept(true);
        inOrder.verify(loadingConsumer).accept(false);
    }

    @Test
    public void loadingError() throws Exception {
        //noinspection ThrowableNotThrown
        setUpError();
        initializePresenter();

        InOrder inOrder = Mockito.inOrder(loadingConsumer);
        inOrder.verify(loadingConsumer).accept(true);
        inOrder.verify(loadingConsumer).accept(false);
    }

    @Test
    public void onRepoClicked() throws Exception {
        setUpSuccess();
        initializePresenter();

        Repo repo = TestUtils.loadJson("mock/repos/get_repo.json", Repo.class);
        presenter.onRepoClicked(repo);
        verify(screenNavigator).goToRepoDetails(repo.owner().login(), repo.name());
    }

    private List<Repo> setUpSuccess() {
        MockitoAnnotations.initMocks(this);
        when(viewModel.loadingUpdated()).thenReturn(loadingConsumer);
        when(viewModel.onError()).thenReturn(onErrorConsumer);
        when(viewModel.reposUpdated()).thenReturn(() -> {});

        TrendingReposResponse response = TestUtils.loadJson("mock/search/get_trending_repos.json", TrendingReposResponse.class);
        List<Repo> repos = response.repos();

        when(repoRepository.getTrendingRepos()).thenReturn(Single.just(repos));

        return repos;
    }

    private Throwable setUpError() {
        MockitoAnnotations.initMocks(this);
        when(viewModel.loadingUpdated()).thenReturn(loadingConsumer);
        when(viewModel.onError()).thenReturn(onErrorConsumer);
        Throwable error = new IOException();
        when(repoRepository.getTrendingRepos()).thenReturn(Single.error(error));
        return error;
    }

    private void initializePresenter() {
        presenter = new TrendingReposPresenter(viewModel,
                repoRepository,
                screenNavigator,
                disposableManager,
                dataSource);
    }
}
