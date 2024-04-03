package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbaf implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbag zza;

    public zzbaf(zzbag zzbag) {
        this.zza = zzbag;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zza.zzb) {
            this.zza.zze = null;
            if (this.zza.zzc != null) {
                this.zza.zzc = null;
            }
            this.zza.zzb.notifyAll();
        }
    }
}
