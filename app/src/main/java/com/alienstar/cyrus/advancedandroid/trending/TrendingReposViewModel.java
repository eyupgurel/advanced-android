package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by cyrus on 3/8/18.
 */

@ScreenScope
class TrendingReposViewModel {
    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();
    @Inject
    TrendingReposViewModel(){

    }
    Observable<Boolean> loading(){
        return loadingRelay;
    }
    Observable<List<Repo>> repos(){
        return reposRelay;
    }
    Observable<Integer> error(){
        return errorRelay;
    }
    Consumer<Boolean> loadingUpdated(){
        return loadingRelay;
    }
    Consumer<List<Repo>> reposUpdated(){
        errorRelay.accept(-1);
        return reposRelay;
    }
    Consumer<Throwable> onError(){
        return throwable -> {
            Timber.e(throwable, "Error loading Repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}
