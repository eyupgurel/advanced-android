package com.alienstar.cyrus.advancedandroid.home

import com.alienstar.cyrus.advancedandroid.details.RepoDetailsComponent
import com.alienstar.cyrus.advancedandroid.details.RepoDetailsController
import com.alienstar.cyrus.advancedandroid.di.ControllerKey
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposComponent
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposController
import com.bluelinelabs.conductor.Controller

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by cyrus on 3/5/18.
 */
@Module(subcomponents = arrayOf(TrendingReposComponent::class, RepoDetailsComponent::class))
abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController::class)
    internal abstract fun bindTrendingReposInjector(builder: TrendingReposComponent.Builder): AndroidInjector.Factory<out Controller>

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController::class)
    internal abstract fun bindRepoDetailsInjector(builder: RepoDetailsComponent.Builder): AndroidInjector.Factory<out Controller>
}
