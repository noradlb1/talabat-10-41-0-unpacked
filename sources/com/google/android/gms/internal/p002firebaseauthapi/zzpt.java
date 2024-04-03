package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpt  reason: invalid package */
public final class zzpt extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzpt zzb;
    private int zzd;
    private zzpw zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzpt zzpt = new zzpt();
        zzb = zzpt;
        zzaha.zzH(zzpt.class, zzpt);
    }

    private zzpt() {
    }

    public static zzps zzb() {
        return (zzps) zzb.zzt();
    }

    public static zzpt zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzpt) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzf(zzpt zzpt, zzpw zzpw) {
        zzpw.getClass();
        zzpt.zze = zzpw;
        zzpt.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzpw zze() {
        zzpw zzpw = this.zze;
        return zzpw == null ? zzpw.zzd() : zzpw;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzpt();
        } else {
            if (i12 == 4) {
                return new zzps((zzpr) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
