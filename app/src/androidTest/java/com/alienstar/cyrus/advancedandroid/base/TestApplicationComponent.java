package com.alienstar.cyrus.advancedandroid.base;

import android.app.Application;

import com.alienstar.cyrus.advancedandroid.data.RepoRepository;
import com.alienstar.cyrus.advancedandroid.data.TestRepoService;
import com.alienstar.cyrus.advancedandroid.data.TestRepoServiceModule;
import com.alienstar.cyrus.advancedandroid.database.DatabaseModule;
import com.alienstar.cyrus.advancedandroid.networking.ServiceModule;
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposControllerTest;
import com.alienstar.cyrus.advancedandroid.ui.TestActivityViewInterceptorModule;
import com.alienstar.cyrus.advancedandroid.ui.TestNavigationModule;
import com.alienstar.cyrus.advancedandroid.ui.TestScreenNavigator;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        TestNavigationModule.class,
        TestActivityViewInterceptorModule.class,
        DatabaseModule.class
})
public interface TestApplicationComponent extends ApplicationComponent {
    void inject(TrendingReposControllerTest trendingReposControllerTest);

    TestScreenNavigator screenNavigator();

    TestRepoService repoService();

    RepoRepository repoRepository();

    @Component.Builder
    interface Builder{
        @BindsInstance
        TestApplicationComponent.Builder application(Application application);
        TestApplicationComponent build();
    }

}
