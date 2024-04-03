package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum  reason: invalid package */
public final class zzum extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzum zzb;
    private int zzd;

    static {
        zzum zzum = new zzum();
        zzb = zzum;
        zzaha.zzH(zzum.class, zzum);
    }

    private zzum() {
    }

    public static zzum zzc() {
        return zzb;
    }

    public static zzum zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzum) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public final int zza() {
        return this.zzd;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zzum();
        } else {
            if (i12 == 4) {
                return new zzul((zzuk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
