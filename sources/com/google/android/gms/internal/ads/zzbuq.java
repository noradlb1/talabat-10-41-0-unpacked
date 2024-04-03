package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

public final /* synthetic */ class zzbuq implements Predicate {
    public final /* synthetic */ zzbrt zza;

    public /* synthetic */ zzbuq(zzbrt zzbrt) {
        this.zza = zzbrt;
    }

    public final boolean apply(Object obj) {
        zzbrt zzbrt = this.zza;
        zzbrt zzbrt2 = (zzbrt) obj;
        if (!(zzbrt2 instanceof zzbuv) || !((zzbuv) zzbrt2).zzb.equals(zzbrt)) {
            return false;
        }
        return true;
    }
}
