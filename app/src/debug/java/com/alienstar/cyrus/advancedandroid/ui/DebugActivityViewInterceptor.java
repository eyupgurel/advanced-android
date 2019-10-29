package com.alienstar.cyrus.advancedandroid.ui;

//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Switch;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.alienstar.cyrus.advancedandroid.R;
import com.alienstar.cyrus.advancedandroid.settings.DebugPreferences;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by cyrus on 3/16/18.
 */

public class DebugActivityViewInterceptor implements ActivityViewInterceptor {

    @BindView(R.id.sw_mock_responses)
    Switch mockResponseSwitch;

    private final DebugPreferences debugPreferences;
    private final CompositeDisposable disposables = new CompositeDisposable();

    private Unbinder unbinder;

    @Inject
    DebugActivityViewInterceptor(DebugPreferences debugPreferences) {
        this.debugPreferences = debugPreferences;
    }

    @Override
    public void setContentView(Activity activity, int layoutRes) {
        View debugLayout = LayoutInflater.from(activity).inflate(R.layout.debug_drawer, null);
        unbinder = ButterKnife.bind(this, debugLayout);
        initializePrefs();

        View activityLayout = LayoutInflater.from(activity).inflate(layoutRes, null);
        debugLayout.<ViewGroup>findViewById(R.id.activity_layout_container).addView(activityLayout);
        activity.setContentView(debugLayout);
    }

    @Override
    public void clear() {
        disposables.clear();
        if(unbinder!=null){
            unbinder.unbind();
            unbinder = null;
        }
    }
    private void initializePrefs() {
        mockResponseSwitch.setChecked(debugPreferences.useMockResponsesEnabled());
        disposables.addAll(
                RxCompoundButton.checkedChanges(mockResponseSwitch)
                .subscribe(debugPreferences::setUseMockResponses)
        );
    }
}
