package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpe  reason: invalid package */
public final class zzpe extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzpe zzb;
    private int zzd;
    private zzpk zze;
    private zzsb zzf;

    static {
        zzpe zzpe = new zzpe();
        zzb = zzpe;
        zzaha.zzH(zzpe.class, zzpe);
    }

    private zzpe() {
    }

    public static zzpd zza() {
        return (zzpd) zzb.zzt();
    }

    public static zzpe zzc(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzpe) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzf(zzpe zzpe, zzpk zzpk) {
        zzpk.getClass();
        zzpe.zze = zzpk;
        zzpe.zzd |= 1;
    }

    public static /* synthetic */ void zzg(zzpe zzpe, zzsb zzsb) {
        zzsb.getClass();
        zzpe.zzf = zzsb;
        zzpe.zzd |= 2;
    }

    public final zzpk zzd() {
        zzpk zzpk = this.zze;
        return zzpk == null ? zzpk.zzd() : zzpk;
    }

    public final zzsb zze() {
        zzsb zzsb = this.zzf;
        return zzsb == null ? zzsb.zze() : zzsb;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzpe();
        } else {
            if (i12 == 4) {
                return new zzpd((zzpc) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
