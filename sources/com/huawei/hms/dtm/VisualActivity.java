package com.huawei.hms.dtm;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.dtm.sdk.R;
import com.huawei.hms.dtm.sdk.util.SafeIntent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.Locale;

@Instrumented
public class VisualActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public final void a() {
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(67108864);
                D.a(this, launchIntentForPackage);
            }
        } catch (ActivityNotFoundException e11) {
            B.b("HMS-DTM", "ActivityNotFoundException#" + e11.getMessage());
            finish();
        }
    }

    public final void a(Uri uri) {
        String str;
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            B.b("HMS-DTM", "illegal domain");
            finish();
            return;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            B.b("HMS-DTM", "illegal path");
            finish();
            return;
        }
        int port = uri.getPort();
        if (port == -1) {
            str = "wss://" + host + path;
        } else {
            str = "wss://" + host + CertificateUtil.DELIMITER + port + path;
        }
        String a11 = F.a(uri, "id");
        String a12 = F.a(uri, LegacyTokenLocalDataSourceImpl.KEY);
        if (TextUtils.isEmpty(a11) || TextUtils.isEmpty(a12)) {
            B.b("HMS-DTM", "illegal id or token");
            finish();
            return;
        }
        l a13 = l.a();
        a13.a(getApplicationContext());
        a13.startVisualTrace(String.format(Locale.ENGLISH, "%s?id=%s&token=%s", new Object[]{str, a11, a12}));
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.contains("\\") || str.contains("\\.") || str.contains("\\\\.") || str.contains("@");
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("VisualActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "VisualActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VisualActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.dtm_preview_activity);
        Intent intent = getIntent();
        if (intent == null) {
            TraceMachine.exitMethod();
            return;
        }
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            if (!"android.intent.action.VIEW".equals(safeIntent.getAction())) {
                B.b("HMS-DTM", "illegal action");
                finish();
                TraceMachine.exitMethod();
                return;
            }
            Uri data = safeIntent.getData();
            if (data != null) {
                if (!a(data.toString())) {
                    a(data);
                    a();
                    TraceMachine.exitMethod();
                    return;
                }
            }
            B.b("HMS-DTM", "illegal url");
            finish();
            TraceMachine.exitMethod();
        } catch (Exception e11) {
            B.b("HMS-DTM", "Exception#" + e11.getClass().getSimpleName());
            finish();
        }
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
