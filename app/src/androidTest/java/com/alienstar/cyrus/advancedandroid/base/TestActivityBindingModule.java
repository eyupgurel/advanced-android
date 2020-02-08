package com.alienstar.cyrus.advancedandroid.base;

import android.app.Activity;

import com.alienstar.cyrus.advancedandroid.di.ActivityKey;
import com.alienstar.cyrus.advancedandroid.home.MainActivity;
import com.alienstar.cyrus.advancedandroid.home.TestMainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;


@Module(subcomponents = TestMainActivityComponent.class)
public abstract class TestActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestMainActivityComponent.Builder builder);
}
