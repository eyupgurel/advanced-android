package com.alienstar.cyrus.advancedandroid.home;
import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.base.BaseActivity;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposController;
import com.bluelinelabs.conductor.Controller;

public class MainActivity extends BaseActivity {
    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
