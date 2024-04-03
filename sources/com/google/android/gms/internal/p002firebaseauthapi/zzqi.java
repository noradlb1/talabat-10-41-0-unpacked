package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqi  reason: invalid package */
public final class zzqi extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzqi zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zzqi zzqi = new zzqi();
        zzb = zzqi;
        zzaha.zzH(zzqi.class, zzqi);
    }

    private zzqi() {
    }

    public static zzqh zzc() {
        return (zzqh) zzb.zzt();
    }

    public static zzqi zze(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzqi) zzaha.zzx(zzb, zzafv, zzagn);
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
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        } else if (i12 == 3) {
            return new zzqi();
        } else {
            if (i12 == 4) {
                return new zzqh((zzqg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
