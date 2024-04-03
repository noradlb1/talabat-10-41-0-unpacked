package com.huawei.secure.android.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;

@Instrumented
public class SafeAppCompatActivity extends AppCompatActivity implements TraceFieldInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33675a = SafeAppCompatActivity.class.getSimpleName();
    public Trace _nr_trace;

    public void finish() {
        try {
            SafeAppCompatActivity.super.finish();
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "finish exception : " + e11.getMessage(), true);
        }
    }

    public void finishAffinity() {
        try {
            SafeAppCompatActivity.super.finishAffinity();
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "finishAffinity: " + e11.getMessage(), true);
        }
    }

    public Intent getIntent() {
        try {
            return new SafeIntent(SafeAppCompatActivity.super.getIntent());
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "getIntent: " + e11.getMessage(), true);
            return new SafeIntent(new Intent());
        }
    }

    public Uri getReferrer() {
        try {
            return SafeAppCompatActivity.super.getReferrer();
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "getReferrer: " + e11.getMessage(), true);
            return null;
        }
    }

    public void startActivities(Intent[] intentArr) {
        try {
            SafeAppCompatActivity.super.startActivities(intentArr);
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent) {
        try {
            SafeAppCompatActivity.super.startActivity(intent);
        } catch (Exception unused) {
            a.a(f33675a, "startActivity Exception ");
        }
    }

    public void startActivityForResult(Intent intent, int i11) {
        try {
            SafeAppCompatActivity.super.startActivityForResult(intent, i11);
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public boolean startActivityIfNeeded(Intent intent, int i11) {
        try {
            return SafeAppCompatActivity.super.startActivityIfNeeded(intent, i11);
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "startActivityIfNeeded: " + e11.getMessage(), true);
            return false;
        }
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            SafeAppCompatActivity.super.startActivities(intentArr, bundle);
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
        try {
            SafeAppCompatActivity.super.startActivity(intent, bundle);
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public void startActivityForResult(Intent intent, int i11, Bundle bundle) {
        try {
            SafeAppCompatActivity.super.startActivityForResult(intent, i11, bundle);
        } catch (Exception e11) {
            String str = f33675a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }
}
