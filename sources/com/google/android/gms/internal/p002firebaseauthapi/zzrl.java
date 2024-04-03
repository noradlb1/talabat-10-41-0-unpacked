package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrl  reason: invalid package */
public final class zzrl extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzrl zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzrf zzf;
    /* access modifiers changed from: private */
    public zzafv zzg;
    /* access modifiers changed from: private */
    public zzafv zzh;

    static {
        zzrl zzrl = new zzrl();
        zzb = zzrl;
        zzaha.zzH(zzrl.class, zzrl);
    }

    private zzrl() {
        zzafv zzafv = zzafv.zzb;
        this.zzg = zzafv;
        this.zzh = zzafv;
    }

    public static zzrk zzc() {
        return (zzrk) zzb.zzt();
    }

    public static zzrl zze() {
        return zzb;
    }

    public static zzrl zzf(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzrl) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzk(zzrl zzrl, zzrf zzrf) {
        zzrf.getClass();
        zzrl.zzf = zzrf;
        zzrl.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzrf zzb() {
        zzrf zzrf = this.zzf;
        return zzrf == null ? zzrf.zzd() : zzrf;
    }

    public final zzafv zzg() {
        return this.zzg;
    }

    public final zzafv zzh() {
        return this.zzh;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzrl();
        } else {
            if (i12 == 4) {
                return new zzrk((zzrj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
