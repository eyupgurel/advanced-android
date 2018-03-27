package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.model.Contributor;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by cyrus on 3/11/18.
 */
@ScreenScope
class RepoDetailsViewModel {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private final BehaviorRelay<RepoDetailState> detailStateRelay = BehaviorRelay.create();
    private final BehaviorRelay<ContributorState> contributorStateRelay = BehaviorRelay.create();

    @Inject
    RepoDetailsViewModel(){
        detailStateRelay.accept(RepoDetailState.builder().loading(true).build());
        contributorStateRelay.accept(ContributorState.builder().loading(true).build());
    }

    Observable<RepoDetailState> details(){
        return detailStateRelay;
    }

    Observable<ContributorState> contributors(){
        return contributorStateRelay;
    }

    Consumer<Repo> processRepo() {
        return repo -> detailStateRelay.accept(RepoDetailState.builder()
                                                              .loading(false)
                                                              .name(repo.name())
                                                              .description(repo.description())
                                                              .createdDate(repo.createdDate().format(DATE_FORMATTER))
                                                              .updatedDate(repo.updatedDate().format(DATE_FORMATTER))
                                                              .build());
    }

    Consumer<Object> contributorsLoaded() {
        return __ -> contributorStateRelay.accept(
                        ContributorState.builder()
                                        .loading(false)
                                        .build());
    }

    Consumer<Throwable> detailsError() {
        return throwable -> {
            Timber.e(throwable, "Error handling repo details");
            detailStateRelay.accept(
                                    RepoDetailState.builder()
                                                    .loading(false)
                                                    .errorRes(R.string.api_error_single_repo)
                                                    .build()
                                    );};
    }

    Consumer<Throwable> contributorsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading contributors");
            contributorStateRelay.accept(
                                        ContributorState.builder()
                                                        .loading(false)
                                                        .errorRes(R.string.api_error_contributors)
                                                        .build()
                                                    );};
        }


}
