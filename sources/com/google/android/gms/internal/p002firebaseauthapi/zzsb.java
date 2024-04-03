package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsb  reason: invalid package */
public final class zzsb extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzsb zzb;
    private int zzd;
    private zzse zze;
    /* access modifiers changed from: private */
    public int zzf;
    private int zzg;

    static {
        zzsb zzsb = new zzsb();
        zzb = zzsb;
        zzaha.zzH(zzsb.class, zzsb);
    }

    private zzsb() {
    }

    public static zzsa zzc() {
        return (zzsa) zzb.zzt();
    }

    public static zzsb zze() {
        return zzb;
    }

    public static zzsb zzf(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzsb) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzh(zzsb zzsb, zzse zzse) {
        zzse.getClass();
        zzsb.zze = zzse;
        zzsb.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final zzse zzg() {
        zzse zzse = this.zze;
        return zzse == null ? zzse.zzd() : zzse;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzsb();
        } else {
            if (i12 == 4) {
                return new zzsa((zzrz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
