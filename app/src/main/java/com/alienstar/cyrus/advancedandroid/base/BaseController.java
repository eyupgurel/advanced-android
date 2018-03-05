package com.alienstar.cyrus.advancedandroid.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alienstar.cyrus.advancedandroid.di.Injector;
import com.bluelinelabs.conductor.Controller;

/**
 * Created by cyrus on 3/5/18.
 */

public abstract class BaseController extends Controller {
    private boolean injected = false;
    @Override
    protected void onContextAvailable(@NonNull Context context) {
        // Controller instances are retained config changes, so this method can be called more than once.
        // This makes sure we do not waste any time injecting more than once, though technically it would not change functionality.
        if(!injected){
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }
}
