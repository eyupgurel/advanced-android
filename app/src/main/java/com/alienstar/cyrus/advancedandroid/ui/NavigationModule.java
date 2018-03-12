package com.alienstar.cyrus.advancedandroid.ui;

import com.alienstar.cyrus.advancedandroid.di.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by cyrus on 3/6/18.
 */
@Module
public abstract class NavigationModule {
    @Binds
    @ActivityScope
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
