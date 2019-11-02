package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.jakewharton.rxrelay2.BehaviorRelay;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by cyrus on 3/8/18.
 */

@ScreenScope
class TrendingReposViewModel {
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();
    @Inject
    TrendingReposViewModel(){

    }
    Observable<Boolean> loading(){
        return loadingRelay;
    }
    Observable<Integer> error(){
        return errorRelay;
    }
    Consumer<Boolean> loadingUpdated(){
        return loadingRelay;
    }
    Action reposUpdated(){
       return () -> errorRelay.accept(-1);
    }
    Consumer<Throwable> onError(){
        return throwable -> {
            Timber.e(throwable, "Error loading Repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}
