package com.huawei.secure.android.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;

@Instrumented
public class SafeFragmentActivity extends FragmentActivity implements TraceFieldInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33676a = SafeFragmentActivity.class.getSimpleName();
    public Trace _nr_trace;

    public void finish() {
        try {
            SafeFragmentActivity.super.finish();
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "finish exception : " + e11.getMessage(), true);
        }
    }

    public void finishAffinity() {
        try {
            SafeFragmentActivity.super.finishAffinity();
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "finishAffinity: " + e11.getMessage(), true);
        }
    }

    public Intent getIntent() {
        try {
            return new SafeIntent(SafeFragmentActivity.super.getIntent());
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "getIntent: " + e11.getMessage(), true);
            return new SafeIntent(new Intent());
        }
    }

    public Uri getReferrer() {
        try {
            return SafeFragmentActivity.super.getReferrer();
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "getReferrer: " + e11.getMessage(), true);
            return null;
        }
    }

    public void startActivities(Intent[] intentArr) {
        try {
            SafeFragmentActivity.super.startActivities(intentArr);
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent) {
        try {
            SafeFragmentActivity.super.startActivity(new SafeIntent(intent));
        } catch (Exception unused) {
            a.a(f33676a, "startActivity Exception ");
        }
    }

    public void startActivityForResult(Intent intent, int i11) {
        try {
            SafeFragmentActivity.super.startActivityForResult(new SafeIntent(intent), i11);
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public boolean startActivityIfNeeded(Intent intent, int i11) {
        try {
            return SafeFragmentActivity.super.startActivityIfNeeded(intent, i11);
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "startActivityIfNeeded: " + e11.getMessage(), true);
            return false;
        }
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            SafeFragmentActivity.super.startActivities(intentArr, bundle);
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
        try {
            SafeFragmentActivity.super.startActivity(new SafeIntent(intent), bundle);
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public void startActivityForResult(Intent intent, int i11, Bundle bundle) {
        try {
            SafeFragmentActivity.super.startActivityForResult(new SafeIntent(intent), i11, bundle);
        } catch (Exception e11) {
            String str = f33676a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }
}
