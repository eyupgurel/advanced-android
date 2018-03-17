package com.alienstar.cyrus.advancedandroid.util;

import butterknife.Unbinder;
import timber.log.Timber;

/**
 * Created by cyrus on 3/17/18.
 */

public class ButterKnifeUtils {

    public ButterKnifeUtils(){
    }

    public static void unbind(Unbinder unbinder) {
        if (unbinder != null) {
            try {
                unbinder.unbind();
            } catch (IllegalStateException illsex) {
                Timber.e(illsex, "Error unbinding views");
            }
        }
    }
}
