package com.google.android.gms.internal.ads;

public final class zzfyd {
    private final zzgfi zza;

    private zzfyd(zzgfi zzgfi) {
        this.zza = zzgfi;
    }

    public static zzfyd zzd(String str, byte[] bArr, int i11) {
        int i12;
        zzgfh zza2 = zzgfi.zza();
        zza2.zza(str);
        zza2.zzb(zzgjf.zzv(bArr));
        int i13 = i11 - 1;
        if (i13 == 0) {
            i12 = 3;
        } else if (i13 != 1) {
            i12 = 5;
        } else {
            i12 = 4;
        }
        zza2.zzc(i12);
        return new zzfyd((zzgfi) zza2.zzah());
    }

    public final String zza() {
        return this.zza.zzf();
    }

    public final byte[] zzb() {
        return this.zza.zze().zzE();
    }

    public final int zzc() {
        int zzi = this.zza.zzi() - 2;
        int i11 = 1;
        if (zzi != 1) {
            i11 = 2;
            if (zzi != 2) {
                i11 = 3;
                if (zzi != 3) {
                    if (zzi == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i11;
    }
}
