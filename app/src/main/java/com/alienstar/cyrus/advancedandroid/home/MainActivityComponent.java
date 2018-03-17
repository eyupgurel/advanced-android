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
                        MainScreenBindingModule.class, NavigationModule.class,
                        ActivityViewInterceptorModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
