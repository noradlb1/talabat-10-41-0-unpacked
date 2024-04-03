package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqz  reason: invalid package */
public final class zzqz extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzqz zzb;
    private int zzd;
    private zztc zze;

    static {
        zzqz zzqz = new zzqz();
        zzb = zzqz;
        zzaha.zzH(zzqz.class, zzqz);
    }

    private zzqz() {
    }

    public static zzqy zza() {
        return (zzqy) zzb.zzt();
    }

    public static zzqz zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzqz zzqz, zztc zztc) {
        zztc.getClass();
        zzqz.zze = zztc;
        zzqz.zzd |= 1;
    }

    public final zztc zzd() {
        zztc zztc = this.zze;
        return zztc == null ? zztc.zzc() : zztc;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzqz();
        } else {
            if (i12 == 4) {
                return new zzqy((zzqx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
