package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.gtm.zzcq;
import com.google.android.gms.internal.gtm.zzcu;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements zzcu {
    private zzcq<AnalyticsJobService> zzrd;

    private final zzcq<AnalyticsJobService> zzad() {
        if (this.zzrd == null) {
            this.zzrd = new zzcq<>(this);
        }
        return this.zzrd;
    }

    public final boolean callServiceStopSelfResult(int i11) {
        return stopSelfResult(i11);
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

    public final boolean onStartJob(JobParameters jobParameters) {
        return zzad().onStartJob(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z11) {
        jobFinished(jobParameters, false);
    }
}
