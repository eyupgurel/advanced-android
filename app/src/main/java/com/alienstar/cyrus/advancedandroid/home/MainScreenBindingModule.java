package com.alienstar.cyrus.advancedandroid.home;

import com.alienstar.cyrus.advancedandroid.details.RepoDetailsComponent;
import com.alienstar.cyrus.advancedandroid.details.RepoDetailsController;
import com.alienstar.cyrus.advancedandroid.di.ControllerKey;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposComponent;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposController;
import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by cyrus on 3/5/18.
 */
@Module(subcomponents = {
        TrendingReposComponent.class, RepoDetailsComponent.class
})
public abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract  AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);
}
