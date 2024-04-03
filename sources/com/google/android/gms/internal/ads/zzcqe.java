package com.google.android.gms.internal.ads;

public final class zzcqe {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcqe(int i11, int i12, int i13) {
        this.zzc = i11;
        this.zzb = i12;
        this.zza = i13;
    }

    public static zzcqe zza() {
        return new zzcqe(0, 0, 0);
    }

    public static zzcqe zzb(int i11, int i12) {
        return new zzcqe(1, i11, i12);
    }

    public static zzcqe zzc(zzbfi zzbfi) {
        if (zzbfi.zzd) {
            return new zzcqe(3, 0, 0);
        }
        if (zzbfi.zzi) {
            return new zzcqe(2, 0, 0);
        }
        if (zzbfi.zzh) {
            return zza();
        }
        return zzb(zzbfi.zzf, zzbfi.zzc);
    }

    public static zzcqe zzd() {
        return new zzcqe(5, 0, 0);
    }

    public static zzcqe zze() {
        return new zzcqe(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
