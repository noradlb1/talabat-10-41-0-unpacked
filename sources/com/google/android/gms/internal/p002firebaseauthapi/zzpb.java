package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpb  reason: invalid package */
public final class zzpb extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzpb zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzph zzf;
    private zzry zzg;

    static {
        zzpb zzpb = new zzpb();
        zzb = zzpb;
        zzaha.zzH(zzpb.class, zzpb);
    }

    private zzpb() {
    }

    public static zzpa zzb() {
        return (zzpa) zzb.zzt();
    }

    public static zzpb zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzpb) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzh(zzpb zzpb, zzph zzph) {
        zzph.getClass();
        zzpb.zzf = zzph;
        zzpb.zzd |= 1;
    }

    public static /* synthetic */ void zzi(zzpb zzpb, zzry zzry) {
        zzry.getClass();
        zzpb.zzg = zzry;
        zzpb.zzd |= 2;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzph zze() {
        zzph zzph = this.zzf;
        return zzph == null ? zzph.zzd() : zzph;
    }

    public final zzry zzf() {
        zzry zzry = this.zzg;
        return zzry == null ? zzry.zzd() : zzry;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzpb();
        } else {
            if (i12 == 4) {
                return new zzpa((zzoz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
