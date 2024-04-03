package com.google.android.gms.internal.ads;

public final class zzgcx extends zzgkl<zzgcx, zzgcw> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgcx zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgcx zzgcx = new zzgcx();
        zzb = zzgcx;
        zzgkl.zzaK(zzgcx.class, zzgcx);
    }

    private zzgcx() {
    }

    public static zzgcw zzc() {
        return (zzgcw) zzb.zzat();
    }

    public static zzgcx zze() {
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
            return new zzgcx();
        } else {
            if (i12 == 4) {
                return new zzgcw((zzgcv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
