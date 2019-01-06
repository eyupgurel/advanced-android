package com.alienstar.cyrus.advancedandroid.data;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cyrus on 3/10/18.
 */
@Module
public abstract class TestRepoServiceModule {
    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);

    @Provides
    @Named("network_scheduler")
    static Scheduler provideNetworkScheduler() {
        return Schedulers.trampoline();
    }
}
