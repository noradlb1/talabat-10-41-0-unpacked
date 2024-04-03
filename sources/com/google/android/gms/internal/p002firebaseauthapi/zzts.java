package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzts  reason: invalid package */
public final class zzts extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzts zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zztv zzf;

    static {
        zzts zzts = new zzts();
        zzb = zzts;
        zzaha.zzH(zzts.class, zzts);
    }

    private zzts() {
    }

    public static zztr zzb() {
        return (zztr) zzb.zzt();
    }

    public static zzts zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzts) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzg(zzts zzts, zztv zztv) {
        zztv.getClass();
        zzts.zzf = zztv;
        zzts.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zztv zze() {
        zztv zztv = this.zzf;
        return zztv == null ? zztv.zzb() : zztv;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzts();
        } else {
            if (i12 == 4) {
                return new zztr((zztq) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
