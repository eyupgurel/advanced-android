package com.alienstar.cyrus.advancedandroid.database.favorites;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by cyrus on 3/20/18.
 */
@Dao
public interface FavoriteContributorDao {
    @Query("select * from favoritecontributor")
    Flowable<List<FavoriteContributor>> getFavoriteContributors();

    @Insert
    void addFavorite(FavoriteContributor contributor);

    @Delete
    void deleteFavorite(FavoriteContributor contributor);
}
