package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

public class ApkResolutionFailedManager {

    /* renamed from: c  reason: collision with root package name */
    private static final ApkResolutionFailedManager f47805c = new ApkResolutionFailedManager();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f47806a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Runnable> f47807b = new HashMap(2);

    private ApkResolutionFailedManager() {
    }

    public static ApkResolutionFailedManager getInstance() {
        return f47805c;
    }

    public void postTask(String str, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "postTask is not in main thread");
            return;
        }
        this.f47807b.put(str, runnable);
        this.f47806a.postDelayed(runnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void removeTask(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeTask is not in main thread");
            return;
        }
        Runnable remove = this.f47807b.remove(str);
        if (remove == null) {
            HMSLog.e("ApkResolutionFailedManager", "cancel runnable is null");
        } else {
            this.f47806a.removeCallbacks(remove);
        }
    }

    public void removeValueOnly(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        } else {
            this.f47807b.remove(str);
        }
    }
}
