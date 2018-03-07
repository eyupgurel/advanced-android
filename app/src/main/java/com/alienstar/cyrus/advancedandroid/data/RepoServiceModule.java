package com.alienstar.cyrus.advancedandroid.data;

import com.alienstar.cyrus.advancedandroid.model.Repo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cyrus on 3/7/18.
 */
@Module
abstract public class RepoServiceModule {
    @Provides
    @Singleton
    static RepoService provideRepoService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }
}
