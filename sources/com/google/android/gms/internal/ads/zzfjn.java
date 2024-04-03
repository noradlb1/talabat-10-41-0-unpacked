package com.google.android.gms.internal.ads;

public final class zzfjn extends zzgkl<zzfjn, zzfjm> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzfjn zzb;
    private zzfjj zze;

    static {
        zzfjn zzfjn = new zzfjn();
        zzb = zzfjn;
        zzgkl.zzaK(zzfjn.class, zzfjn);
    }

    private zzfjn() {
    }

    public static zzfjm zza() {
        return (zzfjm) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzfjn zzfjn, zzfjj zzfjj) {
        zzfjj.getClass();
        zzfjn.zze = zzfjj;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0006\u0006\u0001\u0000\u0000\u0000\u0006\t", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzfjn();
        } else {
            if (i12 == 4) {
                return new zzfjm((zzfjk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
