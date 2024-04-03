package com.google.android.libraries.places.internal;

public final class zzg {
    static zzg zza;
    private final zzh zzb;

    private zzg(zzh zzh) {
        this.zzb = zzh;
    }

    public static zzg zza() {
        zzg zzg = zza;
        if (zzg != null) {
            zzh zzh = zzg.zzb;
        }
        zzg zzg2 = new zzg(new zzf());
        zza = zzg2;
        return zzg2;
    }
}
