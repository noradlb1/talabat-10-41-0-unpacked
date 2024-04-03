package com.google.android.gms.internal.ads;

public final class zzgfi extends zzgkl<zzgfi, zzgfh> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfi zzb;
    private String zze = "";
    /* access modifiers changed from: private */
    public zzgjf zzf = zzgjf.zzb;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgfi zzgfi = new zzgfi();
        zzb = zzgfi;
        zzgkl.zzaK(zzgfi.class, zzgfi);
    }

    private zzgfi() {
    }

    public static zzgfh zza() {
        return (zzgfh) zzb.zzat();
    }

    public static zzgfi zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zzgfi zzgfi, String str) {
        str.getClass();
        zzgfi.zze = str;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgfi();
        } else {
            if (i12 == 4) {
                return new zzgfh((zzgfg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjf zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    public final int zzi() {
        int zzb2 = zzggj.zzb(this.zzg);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
    }
}
