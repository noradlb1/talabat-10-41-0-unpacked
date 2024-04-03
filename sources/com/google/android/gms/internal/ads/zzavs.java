package com.google.android.gms.internal.ads;

public final class zzavs {
    public final zzavd zza;
    public final zzavp zzb;
    public final Object zzc;
    public final zzapn[] zzd;

    public zzavs(zzavd zzavd, zzavp zzavp, Object obj, zzapn[] zzapnArr) {
        this.zza = zzavd;
        this.zzb = zzavp;
        this.zzc = obj;
        this.zzd = zzapnArr;
    }

    public final boolean zza(zzavs zzavs, int i11) {
        if (zzavs != null && zzaxb.zzo(this.zzb.zza(i11), zzavs.zzb.zza(i11)) && zzaxb.zzo(this.zzd[i11], zzavs.zzd[i11])) {
            return true;
        }
        return false;
    }
}
