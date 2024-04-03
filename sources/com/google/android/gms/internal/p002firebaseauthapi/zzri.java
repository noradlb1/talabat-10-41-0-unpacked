package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzri  reason: invalid package */
public final class zzri extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzri zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzrl zzf;
    /* access modifiers changed from: private */
    public zzafv zzg = zzafv.zzb;

    static {
        zzri zzri = new zzri();
        zzb = zzri;
        zzaha.zzH(zzri.class, zzri);
    }

    private zzri() {
    }

    public static zzrh zzb() {
        return (zzrh) zzb.zzt();
    }

    public static zzri zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzri) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzh(zzri zzri, zzrl zzrl) {
        zzrl.getClass();
        zzri.zzf = zzrl;
        zzri.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzrl zze() {
        zzrl zzrl = this.zzf;
        return zzrl == null ? zzrl.zze() : zzrl;
    }

    public final zzafv zzf() {
        return this.zzg;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzri();
        } else {
            if (i12 == 4) {
                return new zzrh((zzrg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
