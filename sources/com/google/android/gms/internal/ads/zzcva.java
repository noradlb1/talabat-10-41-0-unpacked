package com.google.android.gms.internal.ads;

public final class zzcva implements zzgpr<zzcje> {
    private final zzgqe<zzbwu> zza;
    private final zzgqe<String> zzb;

    public zzcva(zzgqe<zzbwu> zzgqe, zzgqe<String> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* synthetic */ Object zzb() {
        zzbww zzbww = new zzbww();
        String zzb2 = this.zzb.zzb();
        if (zzbmy.zza.zze().booleanValue()) {
            return new zzbwv(zzbww, zzb2);
        }
        return new zzcje(zzb2);
    }
}
