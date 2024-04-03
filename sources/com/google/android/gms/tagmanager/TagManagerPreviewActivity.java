package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
@VisibleForTesting
public class TagManagerPreviewActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("TagManagerPreviewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "TagManagerPreviewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TagManagerPreviewActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (getIntent().getData() == null) {
            Log.e("GoogleTagManager", "Activity intent has no data.");
            TraceMachine.exitMethod();
            return;
        }
        zzbf.zza(getIntent(), (Context) this);
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
