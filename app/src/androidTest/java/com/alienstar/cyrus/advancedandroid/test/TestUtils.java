package com.alienstar.cyrus.advancedandroid.test;

import com.squareup.moshi.Moshi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Created by cyrus on 3/10/18.
 */

public class TestUtils {
    private final Moshi moshi;
    @Inject
    TestUtils(Moshi moshi){
        this.moshi = moshi;
    }
    public <T> T loadJson(String path, Type type){
        try{
            String json = getFileString(path);
            //noinspection unchecked
            return (T) moshi.adapter(type).fromJson(json);
        } catch (IOException ioex){
            throw new IllegalArgumentException("Could not deserialize: " + path + " into type " + type);
        }
    }
    public <T> T loadJson(String path, Class<T> _class){
        try{
            String json = getFileString(path);
            return moshi.adapter(_class).fromJson(json);
        } catch (IOException ioex){
            throw new IllegalArgumentException("Could not deserialize: " + path + " into type " + _class);
        }
    }
    private String getFileString(String path){
        try{
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException ioex){
            throw new IllegalArgumentException("Could not read from resource at: " + path);
        }
    }

}
