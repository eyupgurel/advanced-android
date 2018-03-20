package com.alienstar.cyrus.advancedandroid.model;

import com.alienstar.cyrus.poweradapter.item.RecyclerItem;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by cyrus on 3/7/18.
 */
@AutoValue
public abstract class Contributor implements RecyclerItem {

    public abstract long id();

    public abstract String login();

    @Json(name= "avatar_url")
    public abstract String avatarUrl();

    @Override
    public long getId() {
        return id();
    }

    @Override
    public String renderKey() {
        return "Contributor";
    }

    public static JsonAdapter<Contributor> jsonAdapter(Moshi moshi) {
        return new AutoValue_Contributor.MoshiJsonAdapter(moshi);
    }
}
