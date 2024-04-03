package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfm;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfm.zza {
    private zzfm zza;

    @NonNull
    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @MainThread
    public void doStartService(@NonNull Context context, @NonNull Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @MainThread
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfm(this);
        }
        this.zza.zza(context, intent);
    }
}
