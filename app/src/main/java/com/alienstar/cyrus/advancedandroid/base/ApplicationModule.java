package com.alienstar.cyrus.advancedandroid.base;

import android.app.Application;
import android.content.Context;
import dagger.Binds;
import dagger.Module;


/**
 * Created by cyrus on 3/4/18.
 */
@Module
public abstract class ApplicationModule {
    @Binds
    abstract Context bindApplicationContext(Application application);
}
