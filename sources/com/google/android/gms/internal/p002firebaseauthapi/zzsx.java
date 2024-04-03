package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsx  reason: invalid package */
public final class zzsx extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzsx zzb;
    /* access modifiers changed from: private */
    public String zzd = "";
    /* access modifiers changed from: private */
    public zzafv zze = zzafv.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzsx zzsx = new zzsx();
        zzb = zzsx;
        zzaha.zzH(zzsx.class, zzsx);
    }

    private zzsx() {
    }

    public static zzsu zza() {
        return (zzsu) zzb.zzt();
    }

    public static zzsx zzd() {
        return zzb;
    }

    public final zzsw zzb() {
        int i11 = this.zzf;
        zzsw zzsw = zzsw.UNKNOWN_KEYMATERIAL;
        zzsw zzsw2 = i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? null : zzsw.REMOTE : zzsw.ASYMMETRIC_PUBLIC : zzsw.ASYMMETRIC_PRIVATE : zzsw.SYMMETRIC : zzsw.UNKNOWN_KEYMATERIAL;
        return zzsw2 == null ? zzsw.UNRECOGNIZED : zzsw2;
    }

    public final zzafv zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzd;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzsx();
        } else {
            if (i12 == 4) {
                return new zzsu((zzst) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
