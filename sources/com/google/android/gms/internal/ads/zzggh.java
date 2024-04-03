package com.google.android.gms.internal.ads;

public final class zzggh extends zzgkl<zzggh, zzggg> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzggh zzb;
    private String zze = "";
    private zzgfi zzf;

    static {
        zzggh zzggh = new zzggh();
        zzb = zzggh;
        zzgkl.zzaK(zzggh.class, zzggh);
    }

    private zzggh() {
    }

    public static zzggh zzd() {
        return zzb;
    }

    public static zzggh zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzggh) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public final zzgfi zza() {
        zzgfi zzgfi = this.zzf;
        return zzgfi == null ? zzgfi.zzd() : zzgfi;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzggh();
        } else {
            if (i12 == 4) {
                return new zzggg((zzggf) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zzf != null;
    }
}
