package com.google.android.gms.internal.p002firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf  reason: invalid package */
public final class zztf extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zztf zzb;
    private String zzd = "";
    private String zze = "";
    private int zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zztf zztf = new zztf();
        zzb = zztf;
        zzaha.zzH(zztf.class, zztf);
    }

    private zztf() {
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zztf();
        } else {
            if (i12 == 4) {
                return new zzte((zztd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
