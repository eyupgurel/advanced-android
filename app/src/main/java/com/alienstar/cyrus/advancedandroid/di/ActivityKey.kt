package com.alienstar.cyrus.advancedandroid.di

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by cyrus on 3/5/18.
 */
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ActivityKey(val value: KClass<out Activity>)
