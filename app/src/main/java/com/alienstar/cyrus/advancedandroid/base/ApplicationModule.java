package com.alienstar.cyrus.advancedandroid.base;



import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyrus on 3/4/18.
 */
@Module
public class ApplicationModule {
    private final Application application;
    ApplicationModule(Application application){
        this.application = application;
    }
    @Provides
    Context provideApplicationContext() {
        return application;
    }
}
