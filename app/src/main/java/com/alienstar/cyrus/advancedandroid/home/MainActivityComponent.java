package com.alienstar.cyrus.advancedandroid.home;

import com.alienstar.cyrus.advancedandroid.di.ActivityScope;
import com.alienstar.cyrus.advancedandroid.ui.ActivityViewInterceptorModule;
import com.alienstar.cyrus.advancedandroid.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by cyrus on 3/4/18.
 */
@ActivityScope
@Subcomponent(modules = {
                        MainScreenBindingModule.class,
                        NavigationModule.class,
                        ActivityViewInterceptorModule.class
})
//Components has injecting role rather than defining and implementing an inject method we can
// extend AndroidInjector<T> interface of which dagger will handle the implementation for us.
public interface MainActivityComponent extends AndroidInjector<MainActivity>{
    // We define an abstract class which extends AndroidInjector.Builder<T>. Dagger implementation
    // of this builder will supply the AndroidInjector<T> via its create method. This builder
    // will be bound into a map with MainActivity.class key in the Activity Binding Module
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}


