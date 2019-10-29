package com.alienstar.cyrus.advancedandroid.trending;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.di.ScreenScope;
import com.alienstar.cyrus.advancedandroid.lifecycle.ScreenLifecycleTask;
import com.alienstar.cyrus.advancedandroid.util.ButterKnifeUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by cyrus on 3/17/18.
 */
@ScreenScope
public class TrendingReposUIManager extends ScreenLifecycleTask {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Unbinder unbinder;

    @Inject
    TrendingReposUIManager(){

    }

    @Override
    public void onEnterScope(View view) {
       unbinder = ButterKnife.bind(this, view);
       toolbar.setTitle(R.string.screen_title_trending);
    }

    @Override
    public void onExitScope(View view) {
        ButterKnifeUtils.unbind(unbinder);
    }
}
