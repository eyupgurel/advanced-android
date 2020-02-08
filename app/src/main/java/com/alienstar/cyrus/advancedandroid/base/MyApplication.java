package com.alienstar.cyrus.advancedandroid.base;
import android.app.Application;
import com.alienstar.cyrus.advancedandroid.BuildConfig;
import com.alienstar.cyrus.advancedandroid.di.ActivityInjector;
import javax.inject.Inject;
import javax.inject.Provider;

import timber.log.Timber;

/**
 * Created by cyrus on 3/4/18.
 */

public class MyApplication extends Application implements ProvidesActivityInjector {
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
        //Only top level components has Dagger component classes
        return DaggerApplicationComponent.builder().application(this).build();
    }
    @Override
    public ActivityInjector getActivityInjector(){
        return activityInjector;
    }
}
