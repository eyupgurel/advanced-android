package com.alienstar.cyrus.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by cyrus on 3/6/18.
 */

public interface ScreenNavigator {
    boolean pop();
    void goToRepoDetails(String repoOwner, String repoName);
}
