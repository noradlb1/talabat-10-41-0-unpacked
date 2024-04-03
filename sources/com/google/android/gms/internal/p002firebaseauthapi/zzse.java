package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzse  reason: invalid package */
public final class zzse extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzse zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzse zzse = new zzse();
        zzb = zzse;
        zzaha.zzH(zzse.class, zzse);
    }

    private zzse() {
    }

    public static zzsd zzb() {
        return (zzsd) zzb.zzt();
    }

    public static zzse zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzf() {
        int zzb2 = zzrv.zzb(this.zzd);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzse();
        } else {
            if (i12 == 4) {
                return new zzsd((zzsc) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
