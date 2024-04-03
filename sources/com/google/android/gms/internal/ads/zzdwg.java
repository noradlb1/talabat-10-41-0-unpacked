package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdwg implements zzcqa {
    public final /* synthetic */ zzcjr zza;

    public /* synthetic */ zzdwg(zzcjr zzcjr) {
        this.zza = zzcjr;
    }

    public final void zza(boolean z11) {
        zzcjr zzcjr = this.zza;
        if (z11) {
            zzcjr.zzd(null);
        } else {
            zzcjr.zze(new Exception("Ad Web View failed to load."));
        }
    }
}
