package com.alienstar.cyrus.advancedandroid.di

import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager

import dagger.android.AndroidInjector

/**
 * Created by cyrus on 3/17/18.
 */

interface ScreenComponent<T> : AndroidInjector<T> {
    @ForScreen
    fun disposableManager(): DisposableManager
}
