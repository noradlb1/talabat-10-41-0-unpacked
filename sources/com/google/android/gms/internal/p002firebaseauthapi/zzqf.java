package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqf  reason: invalid package */
public final class zzqf extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzqf zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzafv zze = zzafv.zzb;

    static {
        zzqf zzqf = new zzqf();
        zzb = zzqf;
        zzaha.zzH(zzqf.class, zzqf);
    }

    private zzqf() {
    }

    public static zzqe zzb() {
        return (zzqe) zzb.zzt();
    }

    public static zzqf zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzqf) zzaha.zzx(zzb, zzafv, zzagn);
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
            return new zzqf();
        } else {
            if (i12 == 4) {
                return new zzqe((zzqd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
