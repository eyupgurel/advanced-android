package com.alienstar.cyrus.advancedandroid.lifecycle

import androidx.appcompat.app.AppCompatActivity

//import android.support.v7.app.AppCompatActivity

/**
 * Created by cyrus on 3/17/18.
 */

abstract class ActivityLifecycleTask {

    open fun onCreate(activity: AppCompatActivity) {

    }

    fun onStart(activity: AppCompatActivity) {

    }

    fun onResume(activity: AppCompatActivity) {

    }

    fun onPause(activity: AppCompatActivity) {

    }

    fun onStop(activity: AppCompatActivity) {

    }

    open fun onDestroy(activity: AppCompatActivity) {

    }


}
