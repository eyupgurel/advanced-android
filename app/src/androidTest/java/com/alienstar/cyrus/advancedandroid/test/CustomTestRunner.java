package com.alienstar.cyrus.advancedandroid.test;
import android.app.Application;
import android.content.Context;

import com.alienstar.cyrus.advancedandroid.base.TestApplication;

import androidx.test.runner.AndroidJUnitRunner;

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestApplication.class.getName(), context);
    }
}
