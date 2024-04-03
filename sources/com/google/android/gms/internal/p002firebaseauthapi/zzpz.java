package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpz  reason: invalid package */
public final class zzpz extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzpz zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzafv zze = zzafv.zzb;

    static {
        zzpz zzpz = new zzpz();
        zzb = zzpz;
        zzaha.zzH(zzpz.class, zzpz);
    }

    private zzpz() {
    }

    public static zzpy zzb() {
        return (zzpy) zzb.zzt();
    }

    public static zzpz zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzpz) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzafv zze() {
        return this.zze;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzpz();
        } else {
            if (i12 == 4) {
                return new zzpy((zzpx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
