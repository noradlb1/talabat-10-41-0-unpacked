package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsj  reason: invalid package */
public final class zzsj extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzsj zzb;
    private int zzd;
    private zzsm zze;

    static {
        zzsj zzsj = new zzsj();
        zzb = zzsj;
        zzaha.zzH(zzsj.class, zzsj);
    }

    private zzsj() {
    }

    public static zzsi zza() {
        return (zzsi) zzb.zzt();
    }

    public static zzsj zzc(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzsj) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zze(zzsj zzsj, zzsm zzsm) {
        zzsm.getClass();
        zzsj.zze = zzsm;
        zzsj.zzd |= 1;
    }

    public final zzsm zzd() {
        zzsm zzsm = this.zze;
        return zzsm == null ? zzsm.zzc() : zzsm;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzsj();
        } else {
            if (i12 == 4) {
                return new zzsi((zzsh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
