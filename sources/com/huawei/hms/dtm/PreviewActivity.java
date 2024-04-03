package com.huawei.hms.dtm;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.dtm.sdk.R;
import com.huawei.hms.dtm.sdk.util.SafeIntent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class PreviewActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    public String f48252a;

    /* renamed from: b  reason: collision with root package name */
    public String f48253b;

    /* renamed from: c  reason: collision with root package name */
    public String f48254c;

    public final void a() {
        String str;
        l a11 = l.a();
        a11.a(getApplicationContext());
        if (TextUtils.isEmpty(this.f48254c)) {
            str = null;
        } else {
            str = this.f48252a + "&digest=" + this.f48253b + "&version=" + this.f48254c;
        }
        a11.preview(str);
    }

    public final void b() {
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

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("PreviewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "PreviewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "PreviewActivity#onCreate", (ArrayList<String>) null);
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
                finish();
                TraceMachine.exitMethod();
                return;
            }
            Uri data = safeIntent.getData();
            if (data != null) {
                this.f48252a = F.a(data, "id");
                this.f48253b = F.a(data, "digest");
                this.f48254c = F.a(data, "version");
            }
            if (TextUtils.isEmpty(this.f48252a)) {
                finish();
                TraceMachine.exitMethod();
                return;
            }
            a();
            b();
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
