package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzry  reason: invalid package */
public final class zzry extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzry zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzse zzf;
    /* access modifiers changed from: private */
    public zzafv zzg = zzafv.zzb;

    static {
        zzry zzry = new zzry();
        zzb = zzry;
        zzaha.zzH(zzry.class, zzry);
    }

    private zzry() {
    }

    public static zzrx zzb() {
        return (zzrx) zzb.zzt();
    }

    public static zzry zzd() {
        return zzb;
    }

    public static zzry zze(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzry) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzi(zzry zzry, zzse zzse) {
        zzse.getClass();
        zzry.zzf = zzse;
        zzry.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzse zzf() {
        zzse zzse = this.zzf;
        return zzse == null ? zzse.zzd() : zzse;
    }

    public final zzafv zzg() {
        return this.zzg;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzry();
        } else {
            if (i12 == 4) {
                return new zzrx((zzrw) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
