package com.google.android.gms.internal.ads;

public final class zzgfy extends zzgkl<zzgfy, zzgfx> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfy zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzggb zzf;

    static {
        zzgfy zzgfy = new zzgfy();
        zzb = zzgfy;
        zzgkl.zzaK(zzgfy.class, zzgfy);
    }

    private zzgfy() {
    }

    public static zzgfx zzc() {
        return (zzgfx) zzb.zzat();
    }

    public static zzgfy zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgfy) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzh(zzgfy zzgfy, zzggb zzggb) {
        zzggb.getClass();
        zzgfy.zzf = zzggb;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgfy();
        } else {
            if (i12 == 4) {
                return new zzgfx((zzgfw) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzggb zzf() {
        zzggb zzggb = this.zzf;
        return zzggb == null ? zzggb.zzc() : zzggb;
    }
}
