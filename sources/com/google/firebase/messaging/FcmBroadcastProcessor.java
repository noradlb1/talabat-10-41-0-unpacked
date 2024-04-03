package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import fa.c;
import fa.d;
import fa.e;
import i2.b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@KeepForSdk
public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    @GuardedBy("lock")
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
        this.executor = new b();
    }

    private static Task<Integer> bindToMessagingService(Context context2, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        if (ServiceStarter.getInstance().hasWakeLockPermission(context2)) {
            WakeLockHolder.sendWakefulServiceIntent(context2, getServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT"), intent);
        } else {
            getServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT").sendIntent(intent);
        }
        return Tasks.forResult(-1);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context2, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context2, str);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$startMessagingService$1(Task task) throws Exception {
        return 403;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$startMessagingService$2(Context context2, Intent intent, Task task) throws Exception {
        if (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) {
            return task;
        }
        return bindToMessagingService(context2, intent).continueWith(new b(), new e());
    }

    @VisibleForTesting
    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(Context context2, Intent intent) {
        boolean z11;
        boolean z12 = true;
        if (!PlatformVersion.isAtLeastO() || context2.getApplicationInfo().targetSdkVersion < 26) {
            z11 = false;
        } else {
            z11 = true;
        }
        if ((intent.getFlags() & 268435456) == 0) {
            z12 = false;
        }
        if (!z11 || z12) {
            return Tasks.call(this.executor, new c(context2, intent)).continueWithTask(this.executor, new d(context2, intent));
        }
        return bindToMessagingService(context2, intent);
    }

    public FcmBroadcastProcessor(Context context2, ExecutorService executorService) {
        this.context = context2;
        this.executor = executorService;
    }
}
