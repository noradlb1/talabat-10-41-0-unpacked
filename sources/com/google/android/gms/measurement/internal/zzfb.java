package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

final class zzfb extends BroadcastReceiver {
    @VisibleForTesting
    static final String zza = "com.google.android.gms.measurement.internal.zzfb";
    /* access modifiers changed from: private */
    public final zzlh zzb;
    private boolean zzc;
    private boolean zzd;

    public zzfb(zzlh zzlh) {
        Preconditions.checkNotNull(zzlh);
        this.zzb = zzlh;
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzB();
        String action = intent.getAction();
        this.zzb.zzaA().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action)) {
            boolean zza2 = this.zzb.zzj().zza();
            if (this.zzd != zza2) {
                this.zzd = zza2;
                this.zzb.zzaB().zzp(new zzfa(this, zza2));
                return;
            }
            return;
        }
        this.zzb.zzaA().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public final void zzb() {
        this.zzb.zzB();
        this.zzb.zzaB().zzg();
        if (!this.zzc) {
            this.zzb.zzaw().registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
            this.zzd = this.zzb.zzj().zza();
            this.zzb.zzaA().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    @WorkerThread
    public final void zzc() {
        this.zzb.zzB();
        this.zzb.zzaB().zzg();
        this.zzb.zzaB().zzg();
        if (this.zzc) {
            this.zzb.zzaA().zzj().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzaw().unregisterReceiver(this);
            } catch (IllegalArgumentException e11) {
                this.zzb.zzaA().zzd().zzb("Failed to unregister the network broadcast receiver", e11);
            }
        }
    }
}
