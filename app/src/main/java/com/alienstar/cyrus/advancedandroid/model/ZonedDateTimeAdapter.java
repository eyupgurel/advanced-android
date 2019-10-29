package com.alienstar.cyrus.advancedandroid.model;

import androidx.annotation.Nullable;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;



/**
 * Created by cyrus on 3/6/18.
 */

public class ZonedDateTimeAdapter {
    @FromJson
    ZonedDateTime fromJson(String json){
        return ZonedDateTime.parse(json);
    }

    @ToJson
    String toJson(@Nullable ZonedDateTime value) {
        return value != null ? value.toString() : null;
    }
}
