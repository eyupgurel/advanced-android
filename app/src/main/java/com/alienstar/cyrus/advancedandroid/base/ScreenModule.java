package com.alienstar.cyrus.advancedandroid.base;

import com.alienstar.cyrus.advancedandroid.di.ForScreen;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.DisposableManager;
import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;

import java.lang.annotation.Retention;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.Multibinds;

/**
 * Created by cyrus on 3/17/18.
 */
@Module
public abstract class ScreenModule {
    @Provides
    @ScreenScope
    @ForScreen
    static DisposableManager provideDisposableManager() {
        return new DisposableManager();
    }


    @Multibinds
    abstract Set<ScreenLifecycleTask> screenLifecycleTasks();

}
