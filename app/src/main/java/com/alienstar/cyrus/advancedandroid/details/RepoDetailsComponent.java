package com.alienstar.cyrus.advancedandroid.details;

import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.bluelinelabs.conductor.Controller;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by cyrus on 3/10/18.
 */
@ScreenScope
@Subcomponent
public interface RepoDetailsComponent extends AndroidInjector<RepoDetailsController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RepoDetailsController> {

        @BindsInstance
        public abstract void bindRepoOwner(@Named("repo_owner") String repoOwner);

        @BindsInstance
        public abstract  void bindRepoName(@Named("repo_name") String repoName);

        @Override
        public void seedInstance(RepoDetailsController instance) {
            bindRepoOwner(instance.getArgs().getString(RepoDetailsController.REPO_OWNER_KEY));
            bindRepoName(instance.getArgs().getString(RepoDetailsController.REPO_NAME_KEY));
        }

    }
}