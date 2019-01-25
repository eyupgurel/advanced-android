package com.alienstar.cyrus.advancedandroid.ui

import android.app.Activity
import android.support.annotation.LayoutRes

/**
 * Created by cyrus on 3/16/18.
 */

interface ActivityViewInterceptor {
    fun setContentView(activity: Activity, @LayoutRes layoutRes: Int)
    fun clear()

    companion object {

        val DEFAULT: ActivityViewInterceptor = object : ActivityViewInterceptor {
            override fun setContentView(activity: Activity, layoutRes: Int) {
                activity.setContentView(layoutRes)
            }

            override fun clear() {

            }
        }
    }
}
