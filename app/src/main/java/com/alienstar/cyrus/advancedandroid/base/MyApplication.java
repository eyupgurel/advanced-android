package com.alienstar.cyrus.advancedandroid.base;

import android.app.Application;

import com.alienstar.cyrus.advancedandroid.di.ActivityInjector;

import javax.inject.Inject;

/**
 * Created by cyrus on 3/4/18.
 */

public class MyApplication extends Application {
    @Inject ActivityInjector activityInjector;
    private ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        component.inject(this);
    }
    public ActivityInjector getActivityInjector(){
        return activityInjector;
    }
}
