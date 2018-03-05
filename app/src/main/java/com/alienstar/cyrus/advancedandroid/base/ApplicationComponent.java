package com.alienstar.cyrus.advancedandroid.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cyrus on 3/4/18.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
