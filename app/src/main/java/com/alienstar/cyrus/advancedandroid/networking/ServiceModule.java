package com.alienstar.cyrus.advancedandroid.networking;
import com.alienstar.cyrus.advancedandroid.model.AdapterFactory;
import com.alienstar.cyrus.advancedandroid.model.ZonedDateTimeAdapter;
import com.squareup.moshi.Moshi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by cyrus on 3/7/18.
 */
@Module(includes = NetworkModule.class)
public abstract class ServiceModule {
    @Provides
    @Singleton
    static Moshi provideMoshi(){
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZonedDateTimeAdapter())
                .build();
    }
    @Provides
    @Singleton
    static Retrofit provideRetrofit(Moshi moshi,
                                    Call.Factory callFactory,
                                    @Named("base_url") String baseUrl){
        return new Retrofit.Builder()
                .callFactory(callFactory)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

    }

}
