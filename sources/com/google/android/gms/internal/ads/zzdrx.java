package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

public final class zzdrx implements zzdfl {
    private final zzdqc zza;
    private final zzdqh zzb;

    public zzdrx(zzdqc zzdqc, zzdqh zzdqh) {
        this.zza = zzdqc;
        this.zzb = zzdqh;
    }

    public final void zzl() {
        if (this.zza.zzu() != null) {
            zzcop zzq = this.zza.zzq();
            zzcop zzr = this.zza.zzr();
            if (zzq == null) {
                zzq = zzr != null ? zzr : null;
            }
            if (this.zzb.zzc() && zzq != null) {
                zzq.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }
}
