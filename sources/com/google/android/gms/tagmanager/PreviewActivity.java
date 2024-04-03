package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.visa.checkout.PurchaseInfo;
import java.util.ArrayList;

@Instrumented
@VisibleForTesting
public class PreviewActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        TraceMachine.startTracing("PreviewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "PreviewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "PreviewActivity#onCreate", (ArrayList<String>) null);
        }
        try {
            super.onCreate(bundle);
            zzdi.zzaw("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zza(data)) {
                String valueOf = String.valueOf(data);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 73);
                sb2.append("Cannot preview the app with the uri: ");
                sb2.append(valueOf);
                sb2.append(". Launching current version instead.");
                String sb3 = sb2.toString();
                zzdi.zzac(sb3);
                AlertDialog create = new AlertDialog.Builder(this).create();
                create.setTitle("Preview failure");
                create.setMessage(sb3);
                create.setButton(-1, PurchaseInfo.UserReviewAction.CONTINUE, new zzeg(this));
                create.show();
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                String valueOf2 = String.valueOf(getPackageName());
                if (valueOf2.length() != 0) {
                    str3 = "Invoke the launch activity for package name: ".concat(valueOf2);
                } else {
                    str3 = new String("Invoke the launch activity for package name: ");
                }
                zzdi.zzaw(str3);
                startActivity(launchIntentForPackage);
                TraceMachine.exitMethod();
                return;
            }
            String valueOf3 = String.valueOf(getPackageName());
            if (valueOf3.length() != 0) {
                str2 = "No launch activity found for package name: ".concat(valueOf3);
            } else {
                str2 = new String("No launch activity found for package name: ");
            }
            zzdi.zzaw(str2);
            TraceMachine.exitMethod();
        } catch (Exception e11) {
            String valueOf4 = String.valueOf(e11.getMessage());
            if (valueOf4.length() != 0) {
                str = "Calling preview threw an exception: ".concat(valueOf4);
            } else {
                str = new String("Calling preview threw an exception: ");
            }
            zzdi.zzav(str);
            TraceMachine.exitMethod();
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
