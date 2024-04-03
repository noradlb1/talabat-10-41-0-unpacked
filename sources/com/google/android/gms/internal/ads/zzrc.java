package com.google.android.gms.internal.ads;

public final class zzrc implements zzqk {
    private final zzdh zza;
    private int zzb = 1048576;
    private final zzrb zzc;
    private final zztq zzd = new zztq(-1);
    private final zznb zze = new zznb();

    public zzrc(zzdh zzdh, zzww zzww) {
        zzrb zzrb = new zzrb(zzww);
        this.zza = zzdh;
        this.zzc = zzrb;
    }

    public final zzrc zza(int i11) {
        this.zzb = i11;
        return this;
    }

    public final zzre zzb(zzaz zzaz) {
        zzaz.zzd.getClass();
        return new zzre(zzaz, this.zza, this.zzc, zznk.zza, this.zzd, this.zzb, (zzrd) null, (byte[]) null);
    }
}
