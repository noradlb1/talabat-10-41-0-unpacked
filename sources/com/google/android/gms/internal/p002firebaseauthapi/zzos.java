package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzos  reason: invalid package */
public final class zzos extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzos zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzafv zzf = zzafv.zzb;
    private zzoy zzg;

    static {
        zzos zzos = new zzos();
        zzb = zzos;
        zzaha.zzH(zzos.class, zzos);
    }

    private zzos() {
    }

    public static zzor zzb() {
        return (zzor) zzb.zzt();
    }

    public static zzos zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzos) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzi(zzos zzos, zzoy zzoy) {
        zzoy.getClass();
        zzos.zzg = zzoy;
        zzos.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzoy zze() {
        zzoy zzoy = this.zzg;
        return zzoy == null ? zzoy.zzd() : zzoy;
    }

    public final zzafv zzf() {
        return this.zzf;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzos();
        } else {
            if (i12 == 4) {
                return new zzor((zzoq) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
