package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpw  reason: invalid package */
public final class zzpw extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzpw zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzpw zzpw = new zzpw();
        zzb = zzpw;
        zzaha.zzH(zzpw.class, zzpw);
    }

    private zzpw() {
    }

    public static zzpv zzb() {
        return (zzpv) zzb.zzt();
    }

    public static zzpw zzd() {
        return zzb;
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
            return new zzpw();
        } else {
            if (i12 == 4) {
                return new zzpv((zzpu) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
