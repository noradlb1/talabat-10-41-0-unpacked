package com.google.android.gms.internal.ads;

final class zzcta implements zzdzz {
    private final zzcui zza;
    private final zzctg zzb;
    private Long zzc;
    private String zzd;

    public /* synthetic */ zzcta(zzcui zzcui, zzctg zzctg, zzcsz zzcsz) {
        this.zza = zzcui;
        this.zzb = zzctg;
    }

    public final /* synthetic */ zzdzz zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdzz zzb(long j11) {
        this.zzc = Long.valueOf(j11);
        return this;
    }

    public final zzeaa zzc() {
        zzgpz.zzc(this.zzc, Long.class);
        zzgpz.zzc(this.zzd, String.class);
        return new zzctc(this.zza, this.zzb, this.zzc, this.zzd, (zzctb) null);
    }
}
