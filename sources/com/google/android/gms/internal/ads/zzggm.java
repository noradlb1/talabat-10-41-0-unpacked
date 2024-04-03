package com.google.android.gms.internal.ads;

import java.util.List;

@Deprecated
public final class zzggm extends zzgkl<zzggm, zzggl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzggm zzb;
    private String zze = "";
    private zzgku<zzgfl> zzf = zzgkl.zzaE();

    static {
        zzggm zzggm = new zzggm();
        zzb = zzggm;
        zzgkl.zzaK(zzggm.class, zzggm);
    }

    private zzggm() {
    }

    public static zzggm zzc() {
        return zzb;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzgfl.class});
        } else if (i12 == 3) {
            return new zzggm();
        } else {
            if (i12 == 4) {
                return new zzggl((zzggk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List<zzgfl> zzd() {
        return this.zzf;
    }
}
