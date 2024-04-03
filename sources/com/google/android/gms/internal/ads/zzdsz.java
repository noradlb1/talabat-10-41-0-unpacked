package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdsz implements zzfvx {
    public final /* synthetic */ zzfxa zza;

    public /* synthetic */ zzdsz(zzfxa zzfxa) {
        this.zza = zzfxa;
    }

    public final zzfxa zza(Object obj) {
        zzfxa zzfxa = this.zza;
        if (((zzcop) obj) != null) {
            return zzfxa;
        }
        throw new zzelj(1, "Retrieve Web View from image ad response failed.");
    }
}
