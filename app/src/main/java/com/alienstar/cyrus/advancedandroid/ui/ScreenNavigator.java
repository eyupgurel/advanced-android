package com.alienstar.cyrus.advancedandroid.ui;
/**
 * Created by cyrus on 3/6/18.
 */

public interface ScreenNavigator {
    boolean pop();
    void goToRepoDetails(String repoOwner, String repoName);
}
