package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzro  reason: invalid package */
public final class zzro extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzro zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzafv zzf = zzafv.zzb;

    static {
        zzro zzro = new zzro();
        zzb = zzro;
        zzaha.zzH(zzro.class, zzro);
    }

    private zzro() {
    }

    public static zzrn zza() {
        return (zzrn) zzb.zzt();
    }

    public static zzro zzc() {
        return zzb;
    }

    public final zzafv zzd() {
        return this.zzf;
    }

    public final int zzf() {
        int i11 = this.zzd;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? 0 : 7 : 6 : 5 : 4;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final int zzg() {
        int zzb2 = zzrv.zzb(this.zze);
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
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzro();
        } else {
            if (i12 == 4) {
                return new zzrn((zzrm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
