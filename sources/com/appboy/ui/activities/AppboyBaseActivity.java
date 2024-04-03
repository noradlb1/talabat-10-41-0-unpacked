package com.appboy.ui.activities;

import android.app.Activity;
import com.braze.Braze;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;

@Instrumented
@Deprecated
public class AppboyBaseActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onPause() {
        super.onPause();
        BrazeInAppMessageManager.getInstance().unregisterInAppMessageManager(this);
    }

    public void onResume() {
        super.onResume();
        BrazeInAppMessageManager.getInstance().registerInAppMessageManager(this);
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        Braze.getInstance(this).openSession(this);
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        Braze.getInstance(this).closeSession(this);
    }
}
