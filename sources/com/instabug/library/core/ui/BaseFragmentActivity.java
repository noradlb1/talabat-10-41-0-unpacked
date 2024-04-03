package com.instabug.library.core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.instabug.library.R;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugThemeResolver;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.StatusBarUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class BaseFragmentActivity extends AppCompatActivity implements _InstabugActivity, BaseContract.View, TraceFieldInterface {
    private static final String IB_PID = "INSTABUG_PROCESS_ID";
    public Trace _nr_trace;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public BaseContract.Presenter f34199i;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public void finishActivity() {
        finish();
    }

    @LayoutRes
    public abstract int getLayout();

    public AppCompatActivity getViewContext() {
        return this;
    }

    public abstract void initViews();

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("BaseFragmentActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "BaseFragmentActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BaseFragmentActivity#onCreate", (ArrayList<String>) null);
        }
        StatusBarUtils.setStatusBar(this);
        LocaleUtils.setLocale(this, InstabugCore.getLocale(this));
        super.onCreate(bundle);
        setTheme(InstabugThemeResolver.resolveTheme(SettingsManager.getInstance().getTheme()));
        setContentView(getLayout());
        initViews();
        getWindow().getDecorView().setId(R.id.instabug_decor_view);
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        Intent intent = new Intent();
        intent.setAction("SDK invoked");
        intent.putExtra("SDK invoking state", false);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null && bundle.getInt(IB_PID, -1) != Process.myPid()) {
            finishActivity();
        }
    }

    public void onResume() {
        super.onResume();
        Intent intent = new Intent();
        intent.setAction("SDK invoked");
        intent.putExtra("SDK invoking state", true);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(IB_PID, Process.myPid());
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        LocaleUtils.setAppLocale(this);
        super.onStop();
    }
}
