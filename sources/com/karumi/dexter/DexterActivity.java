package com.karumi.dexter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@Instrumented
public final class DexterActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback, TraceFieldInterface {
    public Trace _nr_trace;

    private boolean isTargetSdkUnderAndroidM() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.targetSdkVersion < 23;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("DexterActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DexterActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DexterActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Dexter.onActivityReady(this);
        getWindow().addFlags(16);
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        Dexter.onActivityDestroyed();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Dexter.onActivityReady(this);
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (isTargetSdkUnderAndroidM()) {
            linkedList2.addAll(Arrays.asList(strArr));
        } else {
            for (int i12 = 0; i12 < strArr.length; i12++) {
                String str = strArr[i12];
                int i13 = iArr[i12];
                if (i13 == -2 || i13 == -1) {
                    linkedList2.add(str);
                } else if (i13 == 0) {
                    linkedList.add(str);
                }
            }
        }
        Dexter.onPermissionsRequested(linkedList, linkedList2);
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
