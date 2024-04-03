package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzty  reason: invalid package */
public final class zzty extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzty zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzub zzf;

    static {
        zzty zzty = new zzty();
        zzb = zzty;
        zzaha.zzH(zzty.class, zzty);
    }

    private zzty() {
    }

    public static zztx zzb() {
        return (zztx) zzb.zzt();
    }

    public static zzty zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzty) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzg(zzty zzty, zzub zzub) {
        zzub.getClass();
        zzty.zzf = zzub;
        zzty.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzub zze() {
        zzub zzub = this.zzf;
        return zzub == null ? zzub.zzc() : zzub;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzty();
        } else {
            if (i12 == 4) {
                return new zztx((zztw) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
