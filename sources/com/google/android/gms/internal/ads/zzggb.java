package com.google.android.gms.internal.ads;

public final class zzggb extends zzgkl<zzggb, zzgga> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzggb zzb;
    private String zze = "";

    static {
        zzggb zzggb = new zzggb();
        zzb = zzggb;
        zzgkl.zzaK(zzggb.class, zzggb);
    }

    private zzggb() {
    }

    public static zzggb zzc() {
        return zzb;
    }

    public static zzggb zzd(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzggb) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzggb();
        } else {
            if (i12 == 4) {
                return new zzgga((zzgfz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zze() {
        return this.zze;
    }
}
