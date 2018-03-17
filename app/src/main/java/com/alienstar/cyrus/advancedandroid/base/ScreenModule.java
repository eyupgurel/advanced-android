package com.alienstar.cyrus.advancedandroid.base;

import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;

import java.util.Set;

import dagger.Module;
import dagger.multibindings.Multibinds;

/**
 * Created by cyrus on 3/17/18.
 */
@Module
public abstract class ScreenModule {

    @Multibinds
    abstract Set<ScreenLifecycleTask> screenLifecycleTasks();

}
