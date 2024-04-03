package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkg;

public final class AppMeasurementService extends Service implements zzkf {
    private zzkg zza;

    private final zzkg zzd() {
        if (this.zza == null) {
            this.zza = new zzkg(this);
        }
        return this.zza;
    }

    @MainThread
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return zzd().zzb(intent);
    }

    @MainThread
    public void onCreate() {
        super.onCreate();
        zzd().zze();
    }

    @MainThread
    public void onDestroy() {
        zzd().zzf();
        super.onDestroy();
    }

    @MainThread
    public void onRebind(@NonNull Intent intent) {
        zzd().zzg(intent);
    }

    @MainThread
    public int onStartCommand(@NonNull Intent intent, int i11, int i12) {
        zzd().zza(intent, i11, i12);
        return 2;
    }

    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(@NonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void zzb(@NonNull JobParameters jobParameters, boolean z11) {
        throw new UnsupportedOperationException();
    }

    public final boolean zzc(int i11) {
        return stopSelfResult(i11);
    }
}
