package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzql  reason: invalid package */
public final class zzql extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzql zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzafv zze = zzafv.zzb;

    static {
        zzql zzql = new zzql();
        zzb = zzql;
        zzaha.zzH(zzql.class, zzql);
    }

    private zzql() {
    }

    public static zzqk zzb() {
        return (zzqk) zzb.zzt();
    }

    public static zzql zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzql) zzaha.zzx(zzb, zzafv, zzagn);
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
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzql();
        } else {
            if (i12 == 4) {
                return new zzqk((zzqj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
