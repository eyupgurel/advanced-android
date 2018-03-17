package com.alienstar.cyrus.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by cyrus on 3/17/18.
 */

public interface RouterProvider {
    Router getRouter();

    Controller initialScreen();
}
