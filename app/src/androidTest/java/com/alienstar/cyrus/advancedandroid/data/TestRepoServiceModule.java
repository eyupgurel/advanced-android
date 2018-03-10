package com.alienstar.cyrus.advancedandroid.data;

import dagger.Binds;
import dagger.Module;

/**
 * Created by cyrus on 3/10/18.
 */
@Module
public abstract class TestRepoServiceModule {
    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);
}
