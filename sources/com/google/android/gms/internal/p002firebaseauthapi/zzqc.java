package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqc  reason: invalid package */
public final class zzqc extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzqc zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zzqc zzqc = new zzqc();
        zzb = zzqc;
        zzaha.zzH(zzqc.class, zzqc);
    }

    private zzqc() {
    }

    public static zzqb zzc() {
        return (zzqb) zzb.zzt();
    }

    public static zzqc zze(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzqc) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzqc();
        } else {
            if (i12 == 4) {
                return new zzqb((zzqa) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
