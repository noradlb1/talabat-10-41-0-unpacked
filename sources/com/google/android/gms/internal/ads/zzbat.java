package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbat implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcjr zza;
    final /* synthetic */ zzbau zzb;

    public zzbat(zzbau zzbau, zzcjr zzcjr) {
        this.zzb = zzbau;
        this.zza = zzcjr;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zze(new RuntimeException("Connection failed."));
        }
    }
}
