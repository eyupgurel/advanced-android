package com.alienstar.cyrus.advancedandroid.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by cyrus on 3/16/18.
 */
@Module
public abstract class ActivityViewInterceptorModule {
    @Binds
    abstract ActivityViewInterceptor bindDebugActivityViewInterceptor(DebugActivityViewInterceptor activityViewInterceptor);
}
