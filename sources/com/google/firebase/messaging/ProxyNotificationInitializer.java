package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import i2.b;
import java.util.concurrent.Executor;

final class ProxyNotificationInitializer {
    private static final String MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED = "firebase_messaging_notification_delegation_enabled";

    private ProxyNotificationInitializer() {
    }

    private static boolean allowedToUse(Context context) {
        return Binder.getCallingUid() == context.getApplicationInfo().uid;
    }

    @WorkerThread
    public static void initialize(Context context) {
        if (!ProxyNotificationPreferences.isProxyNotificationInitialized(context)) {
            setEnableProxyNotification(new b(), context, shouldEnableProxyNotification(context));
        }
    }

    public static boolean isProxyNotificationEnabled(Context context) {
        if (!PlatformVersion.isAtLeastQ()) {
            Log.isLoggable(Constants.TAG, 3);
            return false;
        } else if (!allowedToUse(context)) {
            Log.e(Constants.TAG, "error retrieving notification delegate for package " + context.getPackageName());
            return false;
        } else if (!"com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
            return false;
        } else {
            Log.isLoggable(Constants.TAG, 3);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setEnableProxyNotification$0(Context context, boolean z11, TaskCompletionSource taskCompletionSource) {
        try {
            if (!allowedToUse(context)) {
                Log.e(Constants.TAG, "error configuring notification delegate for package " + context.getPackageName());
                return;
            }
            ProxyNotificationPreferences.setProxyNotificationsInitialized(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (z11) {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                notificationManager.setNotificationDelegate((String) null);
            }
            taskCompletionSource.trySetResult(null);
        } finally {
            taskCompletionSource.trySetResult(null);
        }
    }

    @TargetApi(29)
    public static Task<Void> setEnableProxyNotification(Executor executor, Context context, boolean z11) {
        if (!PlatformVersion.isAtLeastQ()) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new i(context, z11, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private static boolean shouldEnableProxyNotification(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            Context applicationContext = context.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(MANIFEST_METADATA_NOTIFICATION_DELEGATION_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
