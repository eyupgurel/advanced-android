package com.alienstar.cyrus.advancedandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.di.Injector;
import com.alienstar.cyrus.advancedandroid.di.ScreenInjector;
import com.alienstar.cyrus.advancedandroid.lifecycle.ActivityLifecycleTask;
import com.alienstar.cyrus.advancedandroid.ui.ActivityViewInterceptor;
import com.alienstar.cyrus.advancedandroid.ui.RouterProvider;
import com.alienstar.cyrus.advancedandroid.ui.ScreenNavigator;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;

import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by cyrus on 3/5/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements RouterProvider {
    private static String INSTANCE_ID_KEY = "instance_id";
    @Inject ScreenInjector screenInjector;
    @Inject ScreenNavigator screenNavigator;
    @Inject ActivityViewInterceptor activityViewInterceptor;
    @Inject Set<ActivityLifecycleTask> activityLifecycleTasks;
    private String instanceId;
    private Router router;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        activityViewInterceptor.setContentView(this, layoutRes());
        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if(screenContainer == null){
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }
        router = Conductor.attachRouter(this, screenContainer, savedInstanceState);
        monitorBackStack();

        for(ActivityLifecycleTask task: activityLifecycleTasks) {
            task.onCreate(this);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onStart(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onResume(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onPause(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onStop(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()){
            Injector.clearComponent(this);
        }
        activityViewInterceptor.clear();

        for (ActivityLifecycleTask task : activityLifecycleTasks) {
            task.onDestroy(this);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }
    public String getInstanceId(){
        return instanceId;
    }

    @Override
    public void onBackPressed() {
        if(!screenNavigator.pop()){
            super.onBackPressed();
        }
    }

    @Override
    public Router getRouter() {
        return router;
    }

    public ScreenInjector getScreenInjector(){
        return screenInjector;
    }

    private void monitorBackStack(){
        router.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(@Nullable Controller to,
                                        @Nullable Controller from,
                                        boolean isPush,
                                        @NonNull ViewGroup container,
                                        @NonNull ControllerChangeHandler handler) {

            }

            @Override
            public void onChangeCompleted(@Nullable Controller to,
                                          @Nullable Controller from,
                                          boolean isPush,
                                          @NonNull ViewGroup container,
                                          @NonNull ControllerChangeHandler handler) {
                if(!isPush && from != null) {
                    Injector.clearComponent(from);
                }

            }
        });
    }

    @LayoutRes
    protected abstract int layoutRes();

    public abstract Controller initialScreen();
}
