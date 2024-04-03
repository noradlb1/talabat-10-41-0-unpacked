package com.google.android.libraries.places.internal;

public final class zzdk {
    public static zzjr zza(zzwh zzwh) {
        zzjp zza = zzjr.zza();
        zza.zzb(1);
        zza.zza(zzwh);
        return (zzjr) zza.zzt();
    }

    public static zzwc zzb(zzdf zzdf) {
        int i11;
        int zzc = zzdf.zzc();
        int i12 = zzc - 1;
        if (zzc != 0) {
            if (i12 == 0) {
                i11 = 2;
            } else if (i12 != 1) {
                i11 = 1;
            } else {
                i11 = 4;
            }
            zzwc zza = zzwh.zza();
            zzjt zza2 = zzjy.zza();
            zza2.zza(zzdf.zzb());
            zza2.zzb(zzdf.zza());
            zza.zzb((zzjy) zza2.zzt());
            zza.zzf(true);
            zza.zzk(i11);
            zza.zzi("2.5.0");
            return zza;
        }
        throw null;
    }
}
