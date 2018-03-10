package com.alienstar.cyrus.advancedandroid.base;

import android.app.Application;

import com.alienstar.cyrus.advancedandroid.BuildConfig;
import com.alienstar.cyrus.advancedandroid.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by cyrus on 3/4/18.
 */

public class MyApplication extends Application {
    @Inject ActivityInjector activityInjector;
    protected ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = initComponent();
        component.inject(this);
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    protected ApplicationComponent initComponent(){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ActivityInjector getActivityInjector(){
        return activityInjector;
    }
}
