package com.alienstar.cyrus.advancedandroid.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.alienstar.cyrus.advancedandroid.database.favorites.FavoriteContributor;
import com.alienstar.cyrus.advancedandroid.database.favorites.FavoriteContributorDao;

/**
 * Created by cyrus on 3/20/18.
 */

@Database(entities = FavoriteContributor.class, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteContributorDao favoriteContributorDao();
}
