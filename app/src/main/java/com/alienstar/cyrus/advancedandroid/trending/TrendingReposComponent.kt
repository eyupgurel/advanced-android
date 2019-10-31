package com.alienstar.cyrus.advancedandroid.trending

import com.alienstar.cyrus.advancedandroid.base.ScreenModule
import com.alienstar.cyrus.advancedandroid.di.ScreenComponent
import com.alienstar.cyrus.advancedandroid.di.ScreenScope

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by cyrus on 3/5/18.
 */
@ScreenScope
@Subcomponent(modules = [ScreenModule::class, TrendingReposScreenModule::class])
interface TrendingReposComponent : ScreenComponent<TrendingReposController> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TrendingReposController>()
}
