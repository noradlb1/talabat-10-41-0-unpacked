package com.google.android.gms.internal.ads;

public final class zzbda extends zzgkl<zzbda, zzbct> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbda zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbda zzbda = new zzbda();
        zzb = zzbda;
        zzgkl.zzaK(zzbda.class, zzbda);
    }

    private zzbda() {
    }

    public static zzbct zza() {
        return (zzbct) zzb.zzat();
    }

    public static zzbda zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzi(zzbda zzbda, int i11) {
        zzbda.zzf = i11 - 1;
        zzbda.zze |= 1;
    }

    public static /* synthetic */ void zzj(zzbda zzbda, int i11) {
        zzbda.zzg = i11 - 1;
        zzbda.zze |= 2;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", zzbcy.zza, "zzg", zzbcv.zza});
        } else if (i12 == 3) {
            return new zzbda();
        } else {
            if (i12 == 4) {
                return new zzbct((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zze() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }

    public final int zzg() {
        int zza = zzbcw.zza(this.zzg);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzh() {
        int zza = zzbcz.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
