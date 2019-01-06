package com.alienstar.cyrus.advancedandroid.lifecycle;

import android.view.View;

/**
 * Created by cyrus on 3/17/18.
 */

public abstract class ScreenLifecycleTask {

    /**
     * Callback received when a Screen becomes the visible screen.
     * @param view
     */
    public void onEnterScope(View view) {

    }

    /**
     * Callback received when a Screen is either popped or moved to the back of stack.
     * @param view
     */
    public void onExitScope(View view) {

    }

    /**
     * Callback received when Screen is destroyed and will not be coming back (except as a new instance).
     * This should be used to clear any {@link ActivityScope} connections (Disposables,  etc.).
     * @param view
     */
    public void onDestroy(View view) {

    }



}
