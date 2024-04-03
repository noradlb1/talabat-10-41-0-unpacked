package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbtk implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcjr zza;
    final /* synthetic */ zzbtm zzb;

    public zzbtk(zzbtm zzbtm, zzcjr zzcjr) {
        this.zzb = zzbtm;
        this.zza = zzcjr;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zza.zzd(this.zzb.zza.zzp());
        } catch (DeadObjectException e11) {
            this.zza.zze(e11);
        }
    }

    public final void onConnectionSuspended(int i11) {
        zzcjr zzcjr = this.zza;
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("onConnectionSuspended: ");
        sb2.append(i11);
        zzcjr.zze(new RuntimeException(sb2.toString()));
    }
}
