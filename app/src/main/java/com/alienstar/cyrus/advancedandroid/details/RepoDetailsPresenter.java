package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.di.ForScreen;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by cyrus on 3/11/18.
 */
@ScreenScope
public class RepoDetailsPresenter {
    @Inject
    RepoDetailsPresenter(@Named("repo_owner") String repoOwner,
                         @Named("repo_name") String repoName,
                         RepoRepository repoRepository,
                         RepoDetailsViewModel viewModel,
                         @ForScreen DisposableManager disposableManager) {
      disposableManager.add(repoRepository.getRepo(repoOwner, repoName)
                            .doOnSuccess(viewModel.processRepo())
                            .doOnError(viewModel.detailsError())
                            .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl())
                            .doOnError(viewModel.contributorsError()))
                            .subscribe(viewModel.processContributors(), throwable -> {
                                // We handle logging in the view model
                            }));
    }
}
