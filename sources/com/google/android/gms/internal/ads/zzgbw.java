package com.google.android.gms.internal.ads;

public final class zzgbw extends zzgkl<zzgbw, zzgbv> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgbw zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgbz zzf;

    static {
        zzgbw zzgbw = new zzgbw();
        zzb = zzgbw;
        zzgkl.zzaK(zzgbw.class, zzgbw);
    }

    private zzgbw() {
    }

    public static zzgbv zzc() {
        return (zzgbv) zzb.zzat();
    }

    public static zzgbw zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgbw) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzh(zzgbw zzgbw, zzgbz zzgbz) {
        zzgbz.getClass();
        zzgbw.zzf = zzgbz;
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
            return new zzgbw();
        } else {
            if (i12 == 4) {
                return new zzgbv((zzgbu) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgbz zzf() {
        zzgbz zzgbz = this.zzf;
        return zzgbz == null ? zzgbz.zze() : zzgbz;
    }
}
