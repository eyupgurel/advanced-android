package com.alienstar.cyrus.advancedandroid.networking;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.Request;

/**
 * Created by cyrus on 3/17/18.
 */

class MockResponseFactory {
    private final Context context;
    private final int startIndex;

    @Inject
    MockResponseFactory(Context context, @Named("base_url") String baseUrl){
        this.context = context;
        startIndex = baseUrl.length();
    }

    String getMockResponse(Request request) {
        String[] endPointParts = getEndPoint(request).split("/");
        return MockResourceLoader.getResponseString(context, request.method(), endPointParts);
    }

    private String getEndPoint(Request request){
        String url = request.url().toString();
        int queryParamsStart = url.indexOf("?");
        return queryParamsStart == -1 ? url.substring(startIndex) : url.substring(startIndex, queryParamsStart);
    }
}
