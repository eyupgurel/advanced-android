package com.alienstar.cyrus.advancedandroid.test;

import android.app.Activity;
import android.support.test.rule;

import com.alienstar.cyrus.advancedandroid.base.TestApplication;
import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.data.TestRepoService;
import com.alienstar.cyrus.advancedandroid.ui.TestScreenNavigator;

import junit.framework.Test;

/**
 * Created by cyrus on 3/12/18.
 */

public class ControllerTestRule<T extends Activity> extends ActivityTestRule<T> {
    public final TestScreenNavigator screenNavigator;
    public final TestRepoService repoService;
    public final RepoRepository repoRepository;
    public ControllerTestRule(Class<T> activityClass) {
        super(activityClass, true, false);
        screenNavigator = TestApplication.getComponent().screenNavigator();
        repoService = TestApplication.getComponent().repoService();
        repoRepository = TestApplication.getComponent().repoRepository();
    }
    public void clearState() {
        repoService.clearErrorFlags();
        repoService.clearHoldFlags();
        repoRepository.clearCache();
    }
}

