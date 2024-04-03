package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.gtm.zzcq;
import com.google.android.gms.internal.gtm.zzcu;

public final class AnalyticsService extends Service implements zzcu {
    private zzcq<AnalyticsService> zzrd;

    private final zzcq<AnalyticsService> zzad() {
        if (this.zzrd == null) {
            this.zzrd = new zzcq<>(this);
        }
        return this.zzrd;
    }

    public final boolean callServiceStopSelfResult(int i11) {
        return stopSelfResult(i11);
    }

    public final IBinder onBind(Intent intent) {
        zzad();
        return null;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        zzad().onCreate();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        zzad().onDestroy();
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i11, int i12) {
        return zzad().onStartCommand(intent, i11, i12);
    }

    public final void zza(JobParameters jobParameters, boolean z11) {
        throw new UnsupportedOperationException();
    }
}
