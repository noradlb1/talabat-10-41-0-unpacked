package com.google.android.gms.internal.ads;

import org.apache.commons.compress.archivers.tar.TarConstants;

public final class zzgdv extends zzgkl<zzgdv, zzgdu> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgdv zzb;

    static {
        zzgdv zzgdv = new zzgdv();
        zzb = zzgdv;
        zzgkl.zzaK(zzgdv.class, zzgdv);
    }

    private zzgdv() {
    }

    public static zzgdv zzc() {
        return zzb;
    }

    public static zzgdv zzd(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgdv) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, TarConstants.VERSION_ANT, (Object[]) null);
        }
        if (i12 == 3) {
            return new zzgdv();
        }
        if (i12 == 4) {
            return new zzgdu((zzgdt) null);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
