package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzov  reason: invalid package */
public final class zzov extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzov zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzoy zzf;

    static {
        zzov zzov = new zzov();
        zzb = zzov;
        zzaha.zzH(zzov.class, zzov);
    }

    private zzov() {
    }

    public static zzou zzb() {
        return (zzou) zzb.zzt();
    }

    public static zzov zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzov) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzg(zzov zzov, zzoy zzoy) {
        zzoy.getClass();
        zzov.zzf = zzoy;
        zzov.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzoy zze() {
        zzoy zzoy = this.zzf;
        return zzoy == null ? zzoy.zzd() : zzoy;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzov();
        } else {
            if (i12 == 4) {
                return new zzou((zzot) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
