package com.google.android.gms.internal.ads;

public final class zzgco extends zzgkl<zzgco, zzgcn> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgco zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgco zzgco = new zzgco();
        zzb = zzgco;
        zzgkl.zzaK(zzgco.class, zzgco);
    }

    private zzgco() {
    }

    public static zzgcn zzc() {
        return (zzgcn) zzb.zzat();
    }

    public static zzgco zze() {
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
            return new zzgco();
        } else {
            if (i12 == 4) {
                return new zzgcn((zzgcm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
