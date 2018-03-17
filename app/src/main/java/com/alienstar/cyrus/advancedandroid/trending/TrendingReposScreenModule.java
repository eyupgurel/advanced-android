package com.alienstar.cyrus.advancedandroid.trending;

import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * Created by cyrus on 3/17/18.
 */
@Module
public abstract class TrendingReposScreenModule {
    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUIManager(TrendingReposUIManager UIManager);
}
