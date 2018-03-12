package com.alienstar.cyrus.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by cyrus on 3/12/18.
 */
@Singleton
public class TestScreenNavigator implements ScreenNavigator {

    private final DefaultScreenNavigator defaultScreenNavigator;
    private Controller overrideController;

    @Inject
    TestScreenNavigator(DefaultScreenNavigator defaultScreenNavigator) {

        this.defaultScreenNavigator = defaultScreenNavigator;
    }

    /**
     * Set the Controller to launch when the Activity attaches to the ScreenNavigator. This will be
     * used instead of the Controller passed in to {@link ScreenNavigator#initWithRouter(Router, Controller}
     *
     *
     * @param overrideController Controller to launch when Activity starts. Or null to fall back to default
     */

    public void overrideInitialController(Controller overrideController) {

        this.overrideController = overrideController;
    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        Controller launchController = overrideController == null ? rootScreen : overrideController;
        defaultScreenNavigator.initWithRouter(router, launchController);

    }

    @Override
    public boolean pop() {
        return defaultScreenNavigator.pop();
    }

    @Override
    public void goToRepoDetails(String repoOwner, String repoName) {
        defaultScreenNavigator.goToRepoDetails(repoOwner, repoName);
    }

    @Override
    public void clear() {
        defaultScreenNavigator.clear();
    }
}
