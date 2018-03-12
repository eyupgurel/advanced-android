package com.alienstar.cyrus.advancedandroid.ui;

import com.alienstar.cyrus.advancedandroid.details.RepoDetailsController;
import com.alienstar.cyrus.advancedandroid.di.ActivityScope;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;

import javax.inject.Inject;

/**
 * Created by cyrus on 3/6/18.
 */

public class DefaultScreenNavigator implements ScreenNavigator {
    private Router router;
    @Inject
    DefaultScreenNavigator(){

    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        this.router = router;
        if(!router.hasRootController()){
            router.setRoot(RouterTransaction.with(rootScreen));
        }
    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void goToRepoDetails(String repoOwner, String repoName) {
        if(router != null){
            router.pushController(RouterTransaction.with(RepoDetailsController.newInstance(repoName, repoOwner))
                  .pushChangeHandler(new FadeChangeHandler())
                  .popChangeHandler(new FadeChangeHandler()));
        }
    }

    @Override
    public void clear() {
        router = null;
    }
}
