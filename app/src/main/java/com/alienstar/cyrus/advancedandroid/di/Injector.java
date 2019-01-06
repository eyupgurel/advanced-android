package com.alienstar.cyrus.advancedandroid.di;

import android.app.Activity;

import com.alienstar.cyrus.advancedandroid.base.BaseActivity;
import com.bluelinelabs.conductor.Controller;

/**
 * Created by cyrus on 3/5/18.
 */

public class Injector {
    private Injector(){

    }
    public static void inject(Activity activity){
        ActivityInjector.get(activity).inject(activity);

    }
    public static void clearComponent(Activity activity){
        ActivityInjector.get(activity).clear(activity);
    }

    public static void inject(Controller controller){
        ScreenInjector.get(controller.getActivity()).inject(controller);
    }

    public static void clearComponent(Controller controller){
        ScreenInjector.get(controller.getActivity()).clear(controller);
    }
}
