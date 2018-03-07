package com.alienstar.cyrus.advancedandroid.model;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

/**
 * Created by cyrus on 3/7/18.
 */
@MoshiAdapterFactory
public abstract class AdapterFactory implements JsonAdapter.Factory {
    public static JsonAdapter.Factory create(){
        return new AutoValueMoshi_AdapterFactory();
    }
}
