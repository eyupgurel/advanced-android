package com.alienstar.cyrus.advancedandroid.data;

import com.alienstar.cyrus.advancedandroid.model.Repo;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

/**
 * Created by cyrus on 3/7/18.
 */
@AutoValue
public abstract class TrendingReposResponse {
    @Json(name = "items")
    public abstract List<Repo> repos();
    public static JsonAdapter<TrendingReposResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_TrendingReposResponse.MoshiJsonAdapter(moshi);
    }
}
