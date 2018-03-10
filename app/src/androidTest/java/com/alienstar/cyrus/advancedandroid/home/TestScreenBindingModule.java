package com.alienstar.cyrus.advancedandroid.home;

import com.alienstar.cyrus.advancedandroid.di.ControllerKey;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposComponent;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposController;
import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by cyrus on 3/10/18.
 */
@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class TestScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
