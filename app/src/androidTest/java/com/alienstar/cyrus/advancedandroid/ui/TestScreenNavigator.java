package com.alienstar.cyrus.advancedandroid.ui;

import android.support.v7.app.AppCompatActivity;

import com.alienstar.cyrus.advancedandroid.lifecycle.ActivityLifecycleTask;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by cyrus on 3/12/18.
 */
@Singleton
public class TestScreenNavigator extends ActivityLifecycleTask implements ScreenNavigator {

    private final DefaultScreenNavigator defaultScreenNavigator;
    private Controller overrideController;

    @Inject
    TestScreenNavigator() {
        this.defaultScreenNavigator = new DefaultScreenNavigator();
    }

    /**
     * Set the Controller to launch when the Activity attaches to the ScreenNavigator. This will be
     * used instead of the Controller provided by {@link RouterProvider#initialScreen()}
     *
     *
     * @param overrideController Controller to launch when Activity starts. Or null to fall back to default
     */

    public void overrideInitialController(Controller overrideController) {

        this.overrideController = overrideController;
    }

    @Override
    public void onCreate(AppCompatActivity activity) {
        if(!(activity instanceof RouterProvider)){
            throw new IllegalArgumentException("Activity must be an implementation of RouterProvider interface");
        }
        RouterProvider routerProvider = (RouterProvider) activity;
        Controller launchController = overrideController == null ? routerProvider.initialScreen() : overrideController;
        defaultScreenNavigator.initWithRouter(routerProvider.getRouter(), launchController);
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
    public void onDestroy(AppCompatActivity activity) {
        defaultScreenNavigator.onDestroy(activity);
    }
}
