package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdsq implements zzcqa {
    public final /* synthetic */ zzcjq zza;

    public /* synthetic */ zzdsq(zzcjq zzcjq) {
        this.zza = zzcjq;
    }

    public final void zza(boolean z11) {
        zzcjq zzcjq = this.zza;
        if (z11) {
            zzcjq.zzb();
        } else {
            zzcjq.zze(new zzelj(1, "Image Web View failed to load."));
        }
    }
}
