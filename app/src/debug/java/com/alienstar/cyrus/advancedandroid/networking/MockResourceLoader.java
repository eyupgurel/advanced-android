package com.alienstar.cyrus.advancedandroid.networking;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import timber.log.Timber;

/**
 * Created by cyrus on 3/17/18.
 */

class MockResourceLoader {
    private MockResourceLoader(){

    }
    @Nullable
    static String getResponseString(Context context, String method, String[] endpointParts){
        try{
            String currentPath = "mock";
            Set<String> mockList = new HashSet<>(Arrays.asList(context.getAssets().list(currentPath)));
            for (String endpoingPart: endpointParts){
                if (mockList.contains(endpoingPart)){
                    currentPath += "/" + endpoingPart;
                    mockList = new HashSet<>(Arrays.asList(context.getAssets().list(currentPath)));
                }
            }
            // At this stage, our mock list will be the list of files in the matching directory for
            // the endpoint parts.
            String finalPath = null;
            for(String path: mockList) {
                if(path.contains(method.toLowerCase())) {
                    finalPath = currentPath + "/" + path;
                    break;
                }
            }
            if (finalPath != null) {
                return responseFromPath(context, finalPath);
            }
            return null;
        } catch (IOException ioex){
            Timber.e(ioex, "Error loading mock response from assets");
            return null;
        }
    }

    private static String responseFromPath(Context context, String path) {
        StringBuilder sb = new StringBuilder();
        try(InputStream assetStream = context.getAssets().open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(assetStream))){
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ioex) {
            Timber.e(ioex, "Error reading mock response");
        }
        return sb.toString();
    }
}
