package com.huawei.location.base.activity;

import android.content.Context;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class AbstractARServiceManager {
    private static final String TAG = "AbstractARServiceManager";
    protected long lastTimeByTimer = -1;
    protected Context mContext = ContextUtil.getContext();
    /* access modifiers changed from: protected */
    public ActivityRecognitionMappingManager recognitionMappingManager;
    protected ScheduledExecutorService scheduledExecutorService;
    protected ScheduledFuture scheduledFuture;
    protected ActivityTransitionMappingManager transitionMappingManager;

    public AbstractARServiceManager(ActivityTransitionMappingManager activityTransitionMappingManager, ActivityRecognitionMappingManager activityRecognitionMappingManager) {
        this.transitionMappingManager = activityTransitionMappingManager;
        this.recognitionMappingManager = activityRecognitionMappingManager;
    }

    public boolean checkActivityRecognitionPermission(ClientInfo clientInfo) {
        if (clientInfo == null) {
            return false;
        }
        return ARLocationPermissionManager.checkCPActivityRecognitionPermission(TAG, clientInfo.getClientPid(), clientInfo.getClientUid());
    }

    public abstract boolean connectService();

    public abstract boolean disConnectService();

    public abstract ActivityRecognitionResult getDetectedActivity(int i11, int i12);

    public ActivityRecognitionMappingManager getRecognitionRequestMapping() {
        return this.recognitionMappingManager;
    }

    public Runnable getTask() {
        return null;
    }

    public ActivityTransitionMappingManager getTransitionMappingManager() {
        return this.transitionMappingManager;
    }

    public abstract boolean isConnected();

    public abstract void removeActivityTransitionUpdates(ATCallback aTCallback, ClientInfo clientInfo);

    public abstract void removeActivityUpdates(ARCallback aRCallback, ClientInfo clientInfo);

    public abstract void requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo);

    public abstract void requestActivityUpdates(long j11, ARCallback aRCallback, ClientInfo clientInfo);

    public void restartScheduled(long j11) {
        stopScheduled();
        startScheduled(j11);
    }

    public synchronized void scheduleTimer() {
        try {
            long minTime = this.recognitionMappingManager.getMinTime();
            if (-1 == minTime) {
                LogConsole.i(TAG, "scheduleTimer return time is " + minTime);
                this.lastTimeByTimer = -1;
                stopScheduled();
                return;
            }
            long j11 = this.lastTimeByTimer;
            if (j11 == -1) {
                LogConsole.i(TAG, "scheduleTimer begin time is " + minTime);
                this.lastTimeByTimer = minTime;
                startScheduled(minTime);
            } else if (minTime != j11) {
                LogConsole.i(TAG, "scheduleTimer begin again time is " + minTime);
                this.lastTimeByTimer = minTime;
                restartScheduled(minTime);
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "scheduleTimer exception", true);
        }
        return;
    }

    public void startScheduled(long j11) {
        LogConsole.i(TAG, "startScheduled enter");
        if (this.scheduledExecutorService == null) {
            this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        }
        this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(getTask(), 0, j11, TimeUnit.MILLISECONDS);
        LogConsole.i(TAG, "startScheduled exit");
    }

    public void stopScheduled() {
        LogConsole.i(TAG, "stopScheduled enter");
        try {
            ScheduledFuture scheduledFuture2 = this.scheduledFuture;
            if (scheduledFuture2 != null) {
                if (!scheduledFuture2.isCancelled()) {
                    boolean cancel = this.scheduledFuture.cancel(true);
                    LogConsole.i(TAG, "stopScheduled exit:" + cancel);
                    return;
                }
            }
            LogConsole.i(TAG, "scheduled not init or cancelled");
        } catch (Exception unused) {
            LogConsole.e(TAG, "stopScheduled exit exception", true);
        }
    }
}
