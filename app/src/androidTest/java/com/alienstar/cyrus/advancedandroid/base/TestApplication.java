package com.alienstar.cyrus.advancedandroid.base;

//import android.support.test.InstrumentationRegistry;

import androidx.test.InstrumentationRegistry;

/**
 * Created by cyrus on 3/10/18.
 */

public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder().application(this).build();
    }
    public static TestApplicationComponent getComponent() {
       return (TestApplicationComponent) ((TestApplication) androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext()).component;
    }
}
