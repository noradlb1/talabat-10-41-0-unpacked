package com.google.android.gms.internal.p002firebaseauthapi;

import org.apache.commons.compress.archivers.tar.TarConstants;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqu  reason: invalid package */
public final class zzqu extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzqu zzb;

    static {
        zzqu zzqu = new zzqu();
        zzb = zzqu;
        zzaha.zzH(zzqu.class, zzqu);
    }

    private zzqu() {
    }

    public static zzqu zzb() {
        return zzb;
    }

    public static zzqu zzc(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzqu) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, TarConstants.VERSION_ANT, (Object[]) null);
        }
        if (i12 == 3) {
            return new zzqu();
        }
        if (i12 == 4) {
            return new zzqt((zzqs) null);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
