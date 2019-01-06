package com.alienstar.cyrus.advancedandroid.test;

import android.support.test.runner.AndroidJUnitRunner;
import android.app.Application;
import android.content.Context;

import com.alienstar.cyrus.advancedandroid.base.TestApplication;

/**
 * Created by cyrus on 3/10/18.
 */

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestApplication.class.getName(), context);
    }
}
