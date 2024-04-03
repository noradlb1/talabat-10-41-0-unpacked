package com.google.android.gms.internal.ads;

public final class zzgge extends zzgkl<zzgge, zzggd> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgge zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzggh zzf;

    static {
        zzgge zzgge = new zzgge();
        zzb = zzgge;
        zzgkl.zzaK(zzgge.class, zzgge);
    }

    private zzgge() {
    }

    public static zzggd zzc() {
        return (zzggd) zzb.zzat();
    }

    public static zzgge zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgge) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzh(zzgge zzgge, zzggh zzggh) {
        zzggh.getClass();
        zzgge.zzf = zzggh;
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
            return new zzgge();
        } else {
            if (i12 == 4) {
                return new zzggd((zzggc) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzggh zzf() {
        zzggh zzggh = this.zzf;
        return zzggh == null ? zzggh.zzd() : zzggh;
    }
}
