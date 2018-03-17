package com.alienstar.cyrus.advancedandroid.ui;

import android.app.Activity;
import android.support.annotation.LayoutRes;

/**
 * Created by cyrus on 3/16/18.
 */

public interface ActivityViewInterceptor {
    void setContentView(Activity activity, @LayoutRes int layoutRes);
    void clear();

    ActivityViewInterceptor DEFAULT = new ActivityViewInterceptor() {
        @Override
        public void setContentView(Activity activity, int layoutRes) {
            activity.setContentView(layoutRes);
        }

        @Override
        public void clear() {

        }
    };
}
