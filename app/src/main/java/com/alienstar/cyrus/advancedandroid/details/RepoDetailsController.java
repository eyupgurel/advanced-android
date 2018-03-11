package com.alienstar.cyrus.advancedandroid.details;

import android.os.Bundle;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.base.BaseController;
import com.bluelinelabs.conductor.Controller;

/**
 * Created by cyrus on 3/10/18.
 */

public class RepoDetailsController extends BaseController {

    static final String REPO_NAME_KEY = "repo_name";
    static final String REPO_OWNER_KEY = "repo_owner";

    public static Controller newInstance(String repoName, String repoOwner){
        Bundle bundle = new Bundle();
        bundle.putString(REPO_NAME_KEY, repoName);
        bundle.putString(REPO_OWNER_KEY, repoOwner);
        return new RepoDetailsController(bundle);
    }

    public RepoDetailsController(Bundle bundle){
        super(bundle);
    }
    @Override
    protected int layoutRes() {
        return R.layout.screen_repo_details;
    }
}
