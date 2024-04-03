package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzcbg;

@KeepForSdk
public class OfflinePingSender extends Worker {
    private final zzcbg zza;

    public OfflinePingSender(@RecentlyNonNull Context context, @RecentlyNonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzbgo.zza().zzl(context, new zzbxe());
    }

    @RecentlyNonNull
    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzf();
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
