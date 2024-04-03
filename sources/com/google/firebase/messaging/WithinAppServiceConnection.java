package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WithinAppServiceConnection implements ServiceConnection {
    private static final int REQUEST_TIMEOUT_MS = 9000;
    @Nullable
    private WithinAppServiceBinder binder;
    @GuardedBy("this")
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    public static class BindRequest {
        final Intent intent;
        private final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        public BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$arrangeTimeout$0() {
            Log.w(Constants.TAG, "Service took too long to process intent: " + this.intent.getAction() + " Releasing WakeLock.");
            finish();
        }

        public void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            boolean z11;
            long j11;
            if ((this.intent.getFlags() & 268435456) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            o oVar = new o(this);
            if (z11) {
                j11 = WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS;
            } else {
                j11 = 9000;
            }
            getTask().addOnCompleteListener((Executor) scheduledExecutorService, new p(scheduledExecutorService.schedule(oVar, j11, TimeUnit.MILLISECONDS)));
        }

        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }

        public Task<Void> getTask() {
            return this.taskCompletionSource.getTask();
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public WithinAppServiceConnection(Context context2, String str) {
        this(context2, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @GuardedBy("this")
    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    private synchronized void flushQueue() {
        boolean isLoggable = Log.isLoggable(Constants.TAG, 3);
        while (!this.intentQueue.isEmpty()) {
            boolean isLoggable2 = Log.isLoggable(Constants.TAG, 3);
            WithinAppServiceBinder withinAppServiceBinder = this.binder;
            if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                startConnectionIfNeeded();
                return;
            }
            boolean isLoggable3 = Log.isLoggable(Constants.TAG, 3);
            this.binder.send(this.intentQueue.poll());
        }
    }

    @GuardedBy("this")
    private void startConnectionIfNeeded() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("binder is dead. start connection? ");
            sb2.append(!this.connectionInProgress);
        }
        if (!this.connectionInProgress) {
            this.connectionInProgress = true;
            try {
                if (!ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
                    Log.e(Constants.TAG, "binding to the service failed");
                    this.connectionInProgress = false;
                    finishAllInQueue();
                }
            } catch (SecurityException e11) {
                Log.e(Constants.TAG, "Exception while binding the service", e11);
            }
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceConnected: ");
            sb2.append(componentName);
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            Log.e(Constants.TAG, "Invalid service connection: " + iBinder);
            finishAllInQueue();
            return;
        }
        this.binder = (WithinAppServiceBinder) iBinder;
        flushQueue();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceDisconnected: ");
            sb2.append(componentName);
        }
        flushQueue();
    }

    public synchronized Task<Void> sendIntent(Intent intent) {
        BindRequest bindRequest;
        boolean isLoggable = Log.isLoggable(Constants.TAG, 3);
        bindRequest = new BindRequest(intent);
        bindRequest.arrangeTimeout(this.scheduledExecutorService);
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.getTask();
    }

    @VisibleForTesting
    public WithinAppServiceConnection(Context context2, String str, ScheduledExecutorService scheduledExecutorService2) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(str).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService2;
    }
}
