package com.alienstar.cyrus.advancedandroid.networking;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by cyrus on 3/7/18.
 */
@Module
public abstract class NetworkModule {
    @Provides
    @Singleton
    static Call.Factory provideOkHttp() {
        return new OkHttpClient.Builder().build();
    }
    @Provides
    @Named("base_url")
    static String provideBaseUrl() {
        return "https://api.github.com/";
    }
}
