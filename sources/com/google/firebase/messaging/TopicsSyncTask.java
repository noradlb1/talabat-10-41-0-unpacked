package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.IOException;

class TopicsSyncTask implements Runnable {
    private static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean hasAccessNetworkStatePermission;
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean hasWakeLockPermission;
    /* access modifiers changed from: private */
    public final Context context;
    private final Metadata metadata;
    private final long nextDelaySeconds;
    private final PowerManager.WakeLock syncWakeLock;
    /* access modifiers changed from: private */
    public final TopicsSubscriber topicsSubscriber;

    @VisibleForTesting
    public class ConnectivityChangeReceiver extends BroadcastReceiver {
        @GuardedBy("this")
        @Nullable
        private TopicsSyncTask task;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.task = topicsSyncTask;
        }

        public synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.task;
            if (topicsSyncTask != null) {
                if (topicsSyncTask.isDeviceConnected()) {
                    boolean access$100 = TopicsSyncTask.isLoggable();
                    this.task.topicsSubscriber.scheduleSyncTaskWithDelaySeconds(this.task, 0);
                    context.unregisterReceiver(this);
                    this.task = null;
                }
            }
        }

        public void registerReceiver() {
            boolean unused = TopicsSyncTask.isLoggable();
            TopicsSyncTask.this.context.registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
    }

    public TopicsSyncTask(TopicsSubscriber topicsSubscriber2, Context context2, Metadata metadata2, long j11) {
        this.topicsSubscriber = topicsSubscriber2;
        this.context = context2;
        this.nextDelaySeconds = j11;
        this.metadata = metadata2;
        this.syncWakeLock = ((PowerManager) context2.getSystemService("power")).newWakeLock(1, Constants.FCM_WAKE_LOCK);
    }

    private static String createPermissionMissingLog(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean hasAccessNetworkStatePermission(Context context2) {
        boolean z11;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            Boolean bool = hasAccessNetworkStatePermission;
            if (bool == null) {
                z11 = hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE", bool);
            } else {
                z11 = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z11);
            hasAccessNetworkStatePermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean hasPermission(Context context2, String str, Boolean bool) {
        boolean z11;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context2.checkCallingOrSelfPermission(str) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && Log.isLoggable(Constants.TAG, 3)) {
            createPermissionMissingLog(str);
        }
        return z11;
    }

    private static boolean hasWakeLockPermission(Context context2) {
        boolean z11;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            Boolean bool = hasWakeLockPermission;
            if (bool == null) {
                z11 = hasPermission(context2, "android.permission.WAKE_LOCK", bool);
            } else {
                z11 = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z11);
            hasWakeLockPermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean isDeviceConnected() {
        NetworkInfo networkInfo;
        boolean z11;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public static boolean isLoggable() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    @SuppressLint({"Wakelock"})
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (hasWakeLockPermission(this.context)) {
            this.syncWakeLock.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            this.topicsSubscriber.setSyncScheduledOrRunning(true);
            if (!this.metadata.isGmscorePresent()) {
                this.topicsSubscriber.setSyncScheduledOrRunning(false);
                if (hasWakeLockPermission(this.context)) {
                    try {
                        this.syncWakeLock.release();
                    } catch (RuntimeException unused) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!hasAccessNetworkStatePermission(this.context) || isDeviceConnected()) {
                if (this.topicsSubscriber.syncTopics()) {
                    this.topicsSubscriber.setSyncScheduledOrRunning(false);
                } else {
                    this.topicsSubscriber.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (hasWakeLockPermission(this.context)) {
                    try {
                        wakeLock = this.syncWakeLock;
                        wakeLock.release();
                    } catch (RuntimeException unused2) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (hasWakeLockPermission(this.context)) {
                    try {
                        this.syncWakeLock.release();
                    } catch (RuntimeException unused3) {
                        Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e11) {
            Log.e(Constants.TAG, "Failed to sync topics. Won't retry sync. " + e11.getMessage());
            this.topicsSubscriber.setSyncScheduledOrRunning(false);
            if (hasWakeLockPermission(this.context)) {
                wakeLock = this.syncWakeLock;
            }
        } catch (Throwable th2) {
            if (hasWakeLockPermission(this.context)) {
                try {
                    this.syncWakeLock.release();
                } catch (RuntimeException unused4) {
                    Log.i(Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th2;
        }
    }
}
