package com.alienstar.cyrus.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by cyrus on 3/12/18.
 */
@Module
public abstract class TestNavigationModule {
    @Binds
    abstract ScreenNavigator bindScreenNavigator(TestScreenNavigator screenNavigator);

}
