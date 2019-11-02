package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.alienstar.cyrus.advancedandroid.testutils.TestUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created by cyrus on 3/11/18.
 */
public class RepoDetailsViewModelTest {

    private RepoDetailsViewModel viewModel;

    private Repo repo = TestUtils.loadJson("mock/repos/get_repo.json", Repo.class);


    @BeforeEach
    public void setUp() throws Exception {
        viewModel = new RepoDetailsViewModel();
    }

    @Test
    public void details() throws Exception {
        viewModel.processRepo().accept(repo);
        viewModel.details().test().assertValue(RepoDetailState.builder()
                                               .loading(false)
                                               .name("RxJava")
                                               .description("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                                               .createdDate("Jan 08, 2013")
                                               .updatedDate("Mar 09, 2018")
                                               .build());
    }

    @Test
    public void contributors() throws Exception {
        viewModel.contributorsLoaded().accept(new Object());

        viewModel.contributors().test().assertValue(ContributorState.builder().
                                                    loading(false).
                                                    build());
    }

    @Test
    public void detailsError() throws Exception {
        viewModel.detailsError().accept(new IOException());
        viewModel.details().test().assertValue(RepoDetailState.builder()
                                                .loading(false)
                                                .errorRes(R.string.api_error_single_repo)
                                                .build());

    }

    @Test
    public void contributorsError() throws Exception {
        viewModel.contributorsError().accept(new IOException());
        viewModel.contributors().test().assertValue(ContributorState.builder()
                                                    .loading(false)
                                                    .errorRes(R.string.api_error_contributors)
                                                    .build());
    }

}