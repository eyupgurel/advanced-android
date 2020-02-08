package com.alienstar.cyrus.advancedandroid.base;

//import android.support.test.InstrumentationRegistry;

import android.app.Application;

import androidx.test.InstrumentationRegistry;

import com.alienstar.cyrus.advancedandroid.BuildConfig;
import com.alienstar.cyrus.advancedandroid.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by cyrus on 3/10/18.
 */

public class TestApplication extends Application  implements ProvidesActivityInjector {
    @Inject
    ActivityInjector activityInjector;
    protected TestApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = initComponent();
        component.inject(this);
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
    protected TestApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder().application(this).build();
    }
    public static TestApplicationComponent getComponent() {
       return (TestApplicationComponent) ((TestApplication) androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext()).component;
    }

    @Override
    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
