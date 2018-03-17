package com.alienstar.cyrus.advancedandroid.home;

import com.alienstar.cyrus.advancedandroid.di.ActivityScope;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by cyrus on 3/10/18.
 */
@ActivityScope
@Subcomponent(modules = {
        TestScreenBindingModule.class
})
public interface TestMainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }

}
