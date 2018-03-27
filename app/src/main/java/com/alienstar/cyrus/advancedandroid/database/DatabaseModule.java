package com.alienstar.cyrus.advancedandroid.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyrus on 3/20/18.
 */
@Module
public abstract class DatabaseModule {
    @Provides
    @Singleton
    static AppDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "favorites-database").build();
    }
}