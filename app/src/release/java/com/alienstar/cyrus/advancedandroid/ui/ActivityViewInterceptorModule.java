package com.alienstar.cyrus.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by cyrus on 3/16/18.
 */
@Module
public abstract class ActivityViewInterceptorModule {
    @Provides
    static ActivityViewInterceptor provideActivityViewInterceptor() {
        return ActivityViewInterceptor.DEFAULT;
    }
}
