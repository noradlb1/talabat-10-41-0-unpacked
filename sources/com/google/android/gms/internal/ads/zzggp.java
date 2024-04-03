package com.google.android.gms.internal.ads;

public final class zzggp extends zzgkl<zzggp, zzggo> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzggp zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzgjf zzf = zzgjf.zzb;

    static {
        zzggp zzggp = new zzggp();
        zzb = zzggp;
        zzgkl.zzaK(zzggp.class, zzggp);
    }

    private zzggp() {
    }

    public static zzggo zzc() {
        return (zzggo) zzb.zzat();
    }

    public static zzggp zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzggp) zzgkl.zzay(zzb, zzgjf, zzgjx);
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzggp();
        } else {
            if (i12 == 4) {
                return new zzggo((zzggn) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjf zzf() {
        return this.zzf;
    }
}
