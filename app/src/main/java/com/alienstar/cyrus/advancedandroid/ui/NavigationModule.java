package com.alienstar.cyrus.advancedandroid.ui;

import com.alienstar.cyrus.advancedandroid.di.ActivityScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.ActivityLifecycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * Created by cyrus on 3/6/18.
 */
@Module
public abstract class NavigationModule {
    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);

    @Binds
    @IntoSet
    abstract ActivityLifecycleTask bindScreenNavigatorTask(DefaultScreenNavigator screenNavigator);
}
