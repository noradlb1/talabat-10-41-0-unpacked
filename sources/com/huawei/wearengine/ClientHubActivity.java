package com.huawei.wearengine;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.wearengine.common.Constants;
import com.huawei.wearengine.common.a;
import com.huawei.wearengine.utils.b;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ClientHubActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    private void a(int i11, String str) {
        a.c("ClientHubActivity", "errorReturn:" + str + ", resultCode:" + i11);
        setResult(i11);
        finish();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        a.b("ClientHubActivity", "onActivityResult requestCode:" + i11 + ", resultCode:" + i12);
        if (i11 == 19900) {
            a.b("ClientHubActivity", "onActivityResult finish");
            setResult(i12);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z11;
        String str;
        TraceMachine.startTracing("ClientHubActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ClientHubActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ClientHubActivity#onCreate", (ArrayList<String>) null);
        }
        a.b("ClientHubActivity", "ClientHubActivity onCreate");
        super.onCreate(bundle);
        b.a((Context) this);
        Intent intent = getIntent();
        if (intent == null) {
            a.c("ClientHubActivity", "checkIntent intent is null");
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            a(5, "invalid intent");
            TraceMachine.exitMethod();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.TARGET_JSON);
        String stringExtra2 = intent.getStringExtra(Constants.START_REQUEST_JSON);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            a(5, "ClientHubActivity start authNameJson is empty or requestDataJsonString is empty");
            TraceMachine.exitMethod();
            return;
        }
        a.b("ClientHubActivity", "startJumpActivity");
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            String string = jSONObject.getString(Constants.TARGET_PACKAGE_NAME_KEY);
            String string2 = jSONObject.getString(Constants.TARGET_ACTIVITY_NAME_KEY);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                str = "targetPackageName or targetActivityName is empty";
                a(12, str);
                TraceMachine.exitMethod();
            }
            Intent intent2 = new Intent();
            intent2.setPackage(string);
            intent2.setClassName(string, string2);
            intent2.putExtra(Constants.START_REQUEST_JSON, stringExtra2);
            Intent a11 = b.a(intent2);
            if (a11 == null) {
                str = "createExplicitActivityIntent, intent is null.";
                a(12, str);
                TraceMachine.exitMethod();
            }
            try {
                startActivityForResult(a11, 19900);
            } catch (ActivityNotFoundException unused2) {
                str = "startJumpActivity not find JumpActivity";
            }
            TraceMachine.exitMethod();
        } catch (JSONException unused3) {
            str = "startJumpActivity JSONException";
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
