package com.google.android.gms.internal.ads;

public final class zzaiu extends zzgkl<zzaiu, zzait> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaiu zzb;
    private int zze;
    private int zzf = 2;

    static {
        zzaiu zzaiu = new zzaiu();
        zzb = zzaiu;
        zzgkl.zzaK(zzaiu.class, zzaiu);
    }

    private zzaiu() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zze", "zzf", zzaiv.zza});
        } else if (i12 == 3) {
            return new zzaiu();
        } else {
            if (i12 == 4) {
                return new zzait((zzaiq) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
