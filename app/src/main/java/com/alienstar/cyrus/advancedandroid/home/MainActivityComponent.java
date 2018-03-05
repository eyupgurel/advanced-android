package com.alienstar.cyrus.advancedandroid.home;

import com.alienstar.cyrus.advancedandroid.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by cyrus on 3/4/18.
 */
@ActivityScope
@Subcomponent(modules = {
                        MainScreenBindingModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
