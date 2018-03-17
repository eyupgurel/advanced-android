package com.alienstar.cyrus.advancedandroid.ui;

import com.alienstar.cyrus.advancedandroid.lifecycle.ActivityLifecycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * Created by cyrus on 3/12/18.
 */
@Module
public abstract class TestNavigationModule {
    @Binds
    abstract ScreenNavigator bindScreenNavigator(TestScreenNavigator screenNavigator);

    @Binds
    @IntoSet
    abstract ActivityLifecycleTask bindScreenNavigatorTask(TestScreenNavigator screenNavigator);

}
