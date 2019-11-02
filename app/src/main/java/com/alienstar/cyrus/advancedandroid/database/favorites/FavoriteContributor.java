package com.alienstar.cyrus.advancedandroid.database.favorites;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by cyrus on 3/20/18.
 */
@Entity
public class FavoriteContributor {
    @PrimaryKey
    private final long id;


    public FavoriteContributor(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }
}
