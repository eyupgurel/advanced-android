package com.alienstar.cyrus.advancedandroid.di

import com.bluelinelabs.conductor.Controller

import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by cyrus on 3/5/18.
 */
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ControllerKey(val value: KClass<out Controller>)
