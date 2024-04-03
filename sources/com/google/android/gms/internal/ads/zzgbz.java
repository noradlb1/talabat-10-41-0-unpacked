package com.google.android.gms.internal.ads;

public final class zzgbz extends zzgkl<zzgbz, zzgby> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgbz zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgbz zzgbz = new zzgbz();
        zzb = zzgbz;
        zzgkl.zzaK(zzgbz.class, zzgbz);
    }

    private zzgbz() {
    }

    public static zzgby zzc() {
        return (zzgby) zzb.zzat();
    }

    public static zzgbz zze() {
        return zzb;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzgbz();
        } else {
            if (i12 == 4) {
                return new zzgby((zzgbx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
