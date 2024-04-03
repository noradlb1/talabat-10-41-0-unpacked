package com.google.android.gms.internal.p002firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug  reason: invalid package */
public final class zzug extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzug zzb;
    private String zzd = "";
    private zzahf zze = zzaha.zzA();

    static {
        zzug zzug = new zzug();
        zzb = zzug;
        zzaha.zzH(zzug.class, zzug);
    }

    private zzug() {
    }

    public static zzug zzb() {
        return zzb;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zztf.class});
        } else if (i12 == 3) {
            return new zzug();
        } else {
            if (i12 == 4) {
                return new zzuf((zzue) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
