package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoy  reason: invalid package */
public final class zzoy extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzoy zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzoy zzoy = new zzoy();
        zzb = zzoy;
        zzaha.zzH(zzoy.class, zzoy);
    }

    private zzoy() {
    }

    public static zzox zzb() {
        return (zzox) zzb.zzt();
    }

    public static zzoy zzd() {
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
            return new zzoy();
        } else {
            if (i12 == 4) {
                return new zzox((zzow) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
