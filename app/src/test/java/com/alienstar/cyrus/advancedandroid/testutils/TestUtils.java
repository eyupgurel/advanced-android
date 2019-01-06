package com.alienstar.cyrus.advancedandroid.testutils;

import com.alienstar.cyrus.advancedandroid.model.AdapterFactory;
import com.alienstar.cyrus.advancedandroid.model.ZonedDateTimeAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * Created by cyrus on 3/9/18.
 */

public class TestUtils {
    private static TestUtils INSTANCE = new TestUtils();
    private static final Moshi TEST_MOSHI = initializeMoshi();
    private TestUtils() {

    }
    public static <T> T loadJson(String path, Type type){
        try{
            String json = getFileString(path);
            //noinspection unchecked
            return (T) TEST_MOSHI.adapter(type).fromJson(json);
        } catch (IOException ioex){
            throw new IllegalArgumentException("Could not deserialize: " + path + " into type " + type);
        }
    }
    public static <T> T loadJson(String path, Class<T> _class){
        try{
            String json = getFileString(path);
            return TEST_MOSHI.adapter(_class).fromJson(json);
        } catch (IOException ioex){
            throw new IllegalArgumentException("Could not deserialize: " + path + " into type " + _class);
        }
    }
    private static String getFileString(String path){
        try{
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(INSTANCE.getClass().getClassLoader().getResourceAsStream(path));
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

    private static Moshi initializeMoshi(){
        Moshi.Builder builder = new Moshi.Builder();
        builder.add(AdapterFactory.create());
        builder.add(new ZonedDateTimeAdapter());
        return builder.build();
    }
}
