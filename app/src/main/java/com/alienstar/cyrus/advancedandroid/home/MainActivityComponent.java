package com.alienstar.cyrus.advancedandroid.home;
import com.alienstar.cyrus.advancedandroid.di.ActivityScope;
import com.alienstar.cyrus.advancedandroid.ui.ActivityViewInterceptorModule;
import com.alienstar.cyrus.advancedandroid.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
        ActivityViewInterceptorModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}