package com.alienstar.cyrus.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by cyrus on 3/6/18.
 */

public interface ScreenNavigator {
    void initWithRouter(Router router, Controller rootScreen);
    boolean pop();
    void clear();
}
