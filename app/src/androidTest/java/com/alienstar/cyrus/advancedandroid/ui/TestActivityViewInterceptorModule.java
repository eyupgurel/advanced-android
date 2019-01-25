package com.alienstar.cyrus.advancedandroid.ui;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyrus on 3/16/18.
 */
@Module
public abstract class TestActivityViewInterceptorModule {
    @Provides
    static ActivityViewInterceptor provideActivityViewInterceptor() {
        return ActivityViewInterceptor.Companion.getDEFAULT();
    }
}
