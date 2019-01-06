package com.alienstar.cyrus.advancedandroid.database.favorites;

import com.alienstar.cyrus.advancedandroid.database.AppDatabase;
import com.alienstar.cyrus.advancedandroid.model.Contributor;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by cyrus on 3/20/18.
 */
@Singleton
public class FavoriteService {
    private final BehaviorRelay<Set<Long>> favoritedContributorIdRelay = BehaviorRelay.createDefault(new HashSet<>());
    private final AppDatabase appDatabase;

    @Inject
    FavoriteService(AppDatabase appDatabase){
        this.appDatabase = appDatabase;
        appDatabase.favoriteContributorDao().getFavoriteContributors()
                .subscribeOn(Schedulers.io())
                .map(favoriteContributors -> {
                    Set<Long> contributorsIds = new HashSet<>();
                    for(FavoriteContributor favoriteContributor: favoriteContributors) {
                        contributorsIds.add(favoriteContributor.getId());
                    }
                    return contributorsIds;
                })
                .subscribe(favoritedContributorIdRelay,
                        throwable -> Timber.e(throwable,
                                    "Error loading favorited contributors from database"));
    }

    public Observable<Set<Long>> favoritedContributorIds() {
        return favoritedContributorIdRelay;

    }

    public void toggleFavoriteContributor(Contributor contributor){
        runDbOp(() -> {
            if(favoritedContributorIdRelay.getValue().contains(contributor.id())) {
                deleteFavoriteContributor(contributor);
            } else {
                addFavoriteContributor(contributor);
            }
        });

    }

    private void addFavoriteContributor(Contributor contributor) {
        appDatabase.favoriteContributorDao().addFavorite(new FavoriteContributor(contributor.id()));
    }

    private void deleteFavoriteContributor(Contributor contributor) {
        appDatabase.favoriteContributorDao().deleteFavorite(new FavoriteContributor(contributor.id()));
    }

    private void runDbOp(Action action){
        Completable.fromAction(action).subscribeOn(Schedulers.io())
                .subscribe(() -> {}, throwable -> Timber.e(throwable,
                                                  "Error performing database operation"));
    }
}
