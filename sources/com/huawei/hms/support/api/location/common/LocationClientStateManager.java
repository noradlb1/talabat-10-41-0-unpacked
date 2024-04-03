package com.huawei.hms.support.api.location.common;

import android.os.SystemClock;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LocationClientStateManager {
    private static final long MAX_INTERVAL_TIME = 300000;
    private static final int MAX_RECONNECT_COUNT = 3;
    private static final long REPEAT_REQUEST_INTERVAL_TIME = 500;
    public static final int RE_START_STATE_DOING = 1;
    public static final int RE_START_STATE_FAILED = 2;
    public static final int RE_START_STATE_INITIAL = 0;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "LocationClientStateManager";
    private volatile AtomicLong lastDisConnectTime;
    private volatile AtomicInteger reConnectCount;
    private volatile AtomicInteger resendState;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final LocationClientStateManager f49840a = new LocationClientStateManager();
    }

    private LocationClientStateManager() {
        this.lastDisConnectTime = new AtomicLong(0);
        this.reConnectCount = new AtomicInteger(0);
        this.resendState = new AtomicInteger(0);
    }

    private boolean checkReconnectStrategy() {
        synchronized (SYNC_LOCK) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.lastDisConnectTime.get() < 500) {
                HMSLog.e(TAG, "can not reconnect , not satisfied interval");
                return false;
            } else if (this.reConnectCount.get() == 0) {
                this.lastDisConnectTime.set(elapsedRealtime);
                this.reConnectCount.incrementAndGet();
                HMSLog.i(TAG, "first reconnect");
                return true;
            } else if (elapsedRealtime - this.lastDisConnectTime.get() > 300000) {
                this.reConnectCount.set(1);
                this.lastDisConnectTime.set(elapsedRealtime);
                HMSLog.i(TAG, "over MAX_INTERVAL_TIME , restart first reconnect");
                return true;
            } else if (this.reConnectCount.get() >= 3) {
                this.lastDisConnectTime.set(elapsedRealtime);
                HMSLog.i(TAG, "can not reconnect , cause count > MAX_RECONNECT_COUNT");
                return false;
            } else {
                HMSLog.i(TAG, "can reconnect");
                this.lastDisConnectTime.set(elapsedRealtime);
                this.reConnectCount.incrementAndGet();
                return true;
            }
        }
    }

    public static LocationClientStateManager getInstance() {
        return b.f49840a;
    }

    public boolean canResendRequest() {
        boolean z11;
        synchronized (SYNC_LOCK) {
            if (this.resendState.get() != 2) {
                if (this.resendState.get() != 0) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public boolean checkCanResendRequest() {
        boolean z11;
        synchronized (SYNC_LOCK) {
            z11 = checkReconnectStrategy() && canResendRequest();
        }
        return z11;
    }

    public synchronized int getResendState() {
        return this.resendState.get();
    }

    public void resetCache() {
        synchronized (SYNC_LOCK) {
            if (this.reConnectCount.get() == 0 && this.lastDisConnectTime.get() == 0) {
                HMSLog.i(TAG, "not need resetCache");
                return;
            }
            HMSLog.i(TAG, "resetCache");
            this.lastDisConnectTime.set(0);
            this.reConnectCount.set(0);
        }
    }

    public void setResendState(int i11) {
        synchronized (SYNC_LOCK) {
            this.resendState.set(i11);
        }
    }
}
