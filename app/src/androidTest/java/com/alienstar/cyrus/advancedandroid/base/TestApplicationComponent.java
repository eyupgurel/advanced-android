package com.alienstar.cyrus.advancedandroid.base;

import com.alienstar.cyrus.advancedandroid.data.TestRepoServiceModule;
import com.alienstar.cyrus.advancedandroid.networking.ServiceModule;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposControllerTest;
import com.alienstar.cyrus.advancedandroid.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cyrus on 3/10/18.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent {
    void inject(TrendingReposControllerTest trendingReposControllerTest);
}
