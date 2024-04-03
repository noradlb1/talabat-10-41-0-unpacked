package com.huawei.hms.activity;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class EnableServiceActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("EnableServiceActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "EnableServiceActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "EnableServiceActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setContentView(ResourceLoaderUtil.getLayoutId("activity_endisable_service"));
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
