package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrc  reason: invalid package */
public final class zzrc extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzrc zzb;
    private int zzd;
    private zzrf zze;

    static {
        zzrc zzrc = new zzrc();
        zzb = zzrc;
        zzaha.zzH(zzrc.class, zzrc);
    }

    private zzrc() {
    }

    public static zzrb zza() {
        return (zzrb) zzb.zzt();
    }

    public static zzrc zzc(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzrc) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zze(zzrc zzrc, zzrf zzrf) {
        zzrf.getClass();
        zzrc.zze = zzrf;
        zzrc.zzd |= 1;
    }

    public final zzrf zzd() {
        zzrf zzrf = this.zze;
        return zzrf == null ? zzrf.zzd() : zzrf;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzrc();
        } else {
            if (i12 == 4) {
                return new zzrb((zzra) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
