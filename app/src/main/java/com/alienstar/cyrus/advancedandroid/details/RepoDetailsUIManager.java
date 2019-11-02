package com.alienstar.cyrus.advancedandroid.details;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;
import com.alienstar.cyrus.advancedandroid.ui.ScreenNavigator;
import com.alienstar.cyrus.advancedandroid.util.ButterKnifeUtils;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by cyrus on 3/17/18.
 */

public class RepoDetailsUIManager extends ScreenLifecycleTask {
    private final String repoName;
    private final ScreenNavigator screenNavigator;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Unbinder unbinder;

    @Inject
    RepoDetailsUIManager(@Named("repo_name") String repoName, ScreenNavigator screenNavigator){
        this.repoName = repoName;
        this.screenNavigator = screenNavigator;
    }

    @Override
    public void onEnterScope(View view) {
        unbinder = ButterKnife.bind(this, view);
        toolbar.setTitle(repoName);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> screenNavigator.pop());
    }

    @Override
    public void onExitScope(View view) {
        toolbar.setNavigationOnClickListener(null);
        ButterKnifeUtils.unbind(unbinder);
    }
}
