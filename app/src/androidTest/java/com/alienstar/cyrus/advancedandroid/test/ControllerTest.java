package com.alienstar.cyrus.advancedandroid.test;

import android.content.Intent;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.data.TestRepoService;
import com.alienstar.cyrus.advancedandroid.home.MainActivity;
import com.alienstar.cyrus.advancedandroid.ui.TestScreenNavigator;
import com.bluelinelabs.conductor.Controller;

import org.junit.Rule;

/**
 * Created by cyrus on 3/12/18.
 */

abstract public class ControllerTest {

    @Rule
    public ControllerTestRule<MainActivity> testRule = new ControllerTestRule<>(MainActivity.class);

    protected TestRepoService repoService = testRule.repoService;
    protected RepoRepository repoRepository = testRule.repoRepository;
    protected TestScreenNavigator screenNavigator = testRule.screenNavigator;

    public ControllerTest() {
        screenNavigator.overrideInitialController(controllerToLaunch());
    }

    protected abstract Controller controllerToLaunch();

    protected void launch() {
        launch(null);
    }

    protected void launch(Intent intent) {
        testRule.launchActivity(intent);
    }
}
