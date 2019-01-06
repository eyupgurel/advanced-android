package com.alienstar.cyrus.advancedandroid.di

import android.app.Activity

import com.alienstar.cyrus.advancedandroid.base.BaseActivity
import com.bluelinelabs.conductor.Controller

/**
 * Created by cyrus on 3/5/18.
 */

object Injector {
    fun inject(activity: Activity) {
        ActivityInjector.get(activity).inject(activity)

    }

    fun clearComponent(activity: Activity) {
        ActivityInjector.get(activity).clear(activity)
    }

    fun inject(controller: Controller) {
        ScreenInjector.get(controller.activity).inject(controller)
    }

    fun clearComponent(controller: Controller) {
        ScreenInjector.get(controller.activity).clear(controller)
    }
}
