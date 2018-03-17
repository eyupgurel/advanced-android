package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;

/**
 * Created by cyrus on 3/17/18.
 */
@Module
public abstract class RepoDetailsScreenModule {
    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUIManagerTask(RepoDetailsUIManager UIManager);

}
