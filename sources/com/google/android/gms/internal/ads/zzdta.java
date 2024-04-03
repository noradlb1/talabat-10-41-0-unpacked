package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdta implements zzfvx {
    public final /* synthetic */ zzfxa zza;

    public /* synthetic */ zzdta(zzfxa zzfxa) {
        this.zza = zzfxa;
    }

    public final zzfxa zza(Object obj) {
        zzfxa zzfxa = this.zza;
        zzcop zzcop = (zzcop) obj;
        if (zzcop != null && zzcop.zzs() != null) {
            return zzfxa;
        }
        throw new zzelj(1, "Retrieve video view in html5 ad response failed.");
    }
}
