package com.alienstar.cyrus.advancedandroid.base;

import android.app.Application;

import com.alienstar.cyrus.advancedandroid.data.RepoServiceModule;
import com.alienstar.cyrus.advancedandroid.database.DatabaseModule;
import com.alienstar.cyrus.advancedandroid.networking.ServiceModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

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
public interface ApplicationComponent   extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        ApplicationComponent.Builder application(Application application);
        ApplicationComponent build();
    }

}


