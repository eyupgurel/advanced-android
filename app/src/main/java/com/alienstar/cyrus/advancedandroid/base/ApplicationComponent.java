package com.alienstar.cyrus.advancedandroid.base;

import com.alienstar.cyrus.advancedandroid.data.RepoServiceModule;
import com.alienstar.cyrus.advancedandroid.database.DatabaseModule;
import com.alienstar.cyrus.advancedandroid.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cyrus on 3/4/18.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
        DatabaseModule.class
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
