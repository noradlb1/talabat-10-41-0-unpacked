package com.google.android.gms.internal.ads;

public final class zzgdj extends zzgkl<zzgdj, zzgdi> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgdj zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgdj zzgdj = new zzgdj();
        zzb = zzgdj;
        zzgkl.zzaK(zzgdj.class, zzgdj);
    }

    private zzgdj() {
    }

    public static zzgdi zzc() {
        return (zzgdi) zzb.zzat();
    }

    public static zzgdj zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgdj) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
        } else if (i12 == 3) {
            return new zzgdj();
        } else {
            if (i12 == 4) {
                return new zzgdi((zzgdh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
