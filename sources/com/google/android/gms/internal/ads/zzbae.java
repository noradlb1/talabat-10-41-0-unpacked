package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbae implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbag zza;

    public zzbae(zzbag zzbag) {
        this.zza = zzbag;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zza.zzb) {
            try {
                if (this.zza.zzc != null) {
                    zzbag zzbag = this.zza;
                    zzbag.zze = zzbag.zzc.zzq();
                }
            } catch (DeadObjectException e11) {
                zzciz.zzh("Unable to obtain a cache service instance.", e11);
                zzbag.zzh(this.zza);
            }
            this.zza.zzb.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i11) {
        synchronized (this.zza.zzb) {
            this.zza.zze = null;
            this.zza.zzb.notifyAll();
        }
    }
}
