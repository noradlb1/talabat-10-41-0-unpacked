package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztv  reason: invalid package */
public final class zztv extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zztv zzb;
    private String zzd = "";

    static {
        zztv zztv = new zztv();
        zzb = zztv;
        zzaha.zzH(zztv.class, zztv);
    }

    private zztv() {
    }

    public static zztv zzb() {
        return zzb;
    }

    public static zztv zzc(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zztv) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public final String zzd() {
        return this.zzd;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zztv();
        } else {
            if (i12 == 4) {
                return new zztu((zztt) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
