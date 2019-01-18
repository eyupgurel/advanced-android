package com.alienstar.cyrus.advancedandroid.base

import android.app.Activity
import com.alienstar.cyrus.advancedandroid.di.ActivityKey
import com.alienstar.cyrus.advancedandroid.home.MainActivity
import com.alienstar.cyrus.advancedandroid.home.MainActivityComponent

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by cyrus on 3/4/18.
 */
@Module(subcomponents = arrayOf(MainActivityComponent::class))
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}
