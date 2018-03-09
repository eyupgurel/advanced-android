package com.alienstar.cyrus.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by cyrus on 3/6/18.
 */
@Module
public abstract class NavigationModule {
    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
