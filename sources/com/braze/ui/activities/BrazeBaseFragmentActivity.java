package com.braze.ui.activities;

import androidx.fragment.app.FragmentActivity;
import com.braze.Braze;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import kotlin.Metadata;

@Instrumented
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/braze/ui/activities/BrazeBaseFragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onPause", "", "onResume", "onStart", "onStop", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BrazeBaseFragmentActivity extends FragmentActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onPause() {
        super.onPause();
        BrazeInAppMessageManager.Companion.getInstance().unregisterInAppMessageManager(this);
    }

    public void onResume() {
        super.onResume();
        BrazeInAppMessageManager.Companion.getInstance().registerInAppMessageManager(this);
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        Braze.Companion.getInstance(this).openSession(this);
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        Braze.Companion.getInstance(this).closeSession(this);
    }
}
