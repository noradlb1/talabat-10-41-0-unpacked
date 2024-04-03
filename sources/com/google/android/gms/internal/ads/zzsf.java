package com.google.android.gms.internal.ads;

public final class zzsf implements Comparable<zzsf> {
    private final boolean zza;
    private final boolean zzb;

    public zzsf(zzab zzab, int i11) {
        this.zza = 1 != (zzab.zze & 1) ? false : true;
        this.zzb = zzsp.zzh(i11, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzsf zzsf) {
        return zzfsh.zzj().zzd(this.zzb, zzsf.zzb).zzd(this.zza, zzsf.zza).zza();
    }
}
