package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrf  reason: invalid package */
public final class zzrf extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzrf zzb;
    private int zzd;
    private zzro zze;
    private zzqz zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzrf zzrf = new zzrf();
        zzb = zzrf;
        zzaha.zzH(zzrf.class, zzrf);
    }

    private zzrf() {
    }

    public static zzre zzb() {
        return (zzre) zzb.zzt();
    }

    public static zzrf zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzrf zzrf, zzro zzro) {
        zzro.getClass();
        zzrf.zze = zzro;
        zzrf.zzd |= 1;
    }

    public static /* synthetic */ void zzg(zzrf zzrf, zzqz zzqz) {
        zzqz.getClass();
        zzrf.zzf = zzqz;
        zzrf.zzd |= 2;
    }

    public final zzqz zza() {
        zzqz zzqz = this.zzf;
        return zzqz == null ? zzqz.zzc() : zzqz;
    }

    public final zzro zze() {
        zzro zzro = this.zze;
        return zzro == null ? zzro.zzc() : zzro;
    }

    public final int zzh() {
        int i11 = this.zzg;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzrf();
        } else {
            if (i12 == 4) {
                return new zzre((zzrd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
