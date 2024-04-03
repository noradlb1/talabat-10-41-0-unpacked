package com.huawei.secure.android.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.huawei.secure.android.common.intent.IntentUtils;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class SafePreferenceActivity extends PreferenceActivity implements TraceFieldInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33677a = "SafePreferenceActivity";
    public Trace _nr_trace;

    public void finish() {
        try {
            super.finish();
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "finish exception : " + e11.getMessage(), true);
        }
    }

    public void finishAffinity() {
        try {
            super.finishAffinity();
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "finishAffinity: " + e11.getMessage(), true);
        }
    }

    public Intent getIntent() {
        try {
            return new SafeIntent(super.getIntent());
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "getIntent: " + e11.getMessage(), true);
            return new SafeIntent(new Intent());
        }
    }

    public Uri getReferrer() {
        try {
            return super.getReferrer();
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "getReferrer: " + e11.getMessage(), true);
            return null;
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        try {
            super.onActivityResult(i11, i12, new SafeIntent(intent));
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "onActivityResult exception : " + e11.getMessage(), true);
        }
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing(f33677a);
        try {
            TraceMachine.enterMethod(this._nr_trace, "SafePreferenceActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SafePreferenceActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (IntentUtils.hasIntentBomb(super.getIntent())) {
            finish();
        }
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "onDestroy exception : " + e11.getMessage(), true);
        }
    }

    public void onRestart() {
        if (IntentUtils.hasIntentBomb(super.getIntent())) {
            a.a(f33677a, "onRestart : hasIntentBomb");
        }
        super.onRestart();
    }

    public void onResume() {
        if (IntentUtils.hasIntentBomb(super.getIntent())) {
            a.a(f33677a, "onResume : hasIntentBomb");
        }
        super.onResume();
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        if (IntentUtils.hasIntentBomb(super.getIntent())) {
            a.a(f33677a, "onStart : hasIntentBomb");
        }
        super.onStart();
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        if (IntentUtils.hasIntentBomb(super.getIntent())) {
            a.a(f33677a, "onStop : hasIntentBomb");
        }
        super.onStop();
    }

    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception unused) {
            a.a(f33677a, "startActivity Exception ");
        }
    }

    public void startActivityForResult(Intent intent, int i11) {
        try {
            super.startActivityForResult(new SafeIntent(intent), i11);
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public boolean startActivityIfNeeded(Intent intent, int i11) {
        try {
            return super.startActivityIfNeeded(intent, i11);
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "startActivityIfNeeded: " + e11.getMessage(), true);
            return false;
        }
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            super.startActivities(intentArr, bundle);
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
        try {
            super.startActivity(new SafeIntent(intent), bundle);
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public void startActivityForResult(Intent intent, int i11, Bundle bundle) {
        try {
            super.startActivityForResult(new SafeIntent(intent), i11, bundle);
        } catch (Exception e11) {
            String str = f33677a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }
}
