package com.google.android.gms.internal.ads;

public final class zzgfv extends zzgkl<zzgfv, zzgfs> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfv zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgku<zzgfu> zzf = zzgkl.zzaE();

    static {
        zzgfv zzgfv = new zzgfv();
        zzb = zzgfv;
        zzgkl.zzaK(zzgfv.class, zzgfv);
    }

    private zzgfv() {
    }

    public static zzgfs zza() {
        return (zzgfs) zzb.zzat();
    }

    public static /* synthetic */ void zze(zzgfv zzgfv, zzgfu zzgfu) {
        zzgfu.getClass();
        zzgku<zzgfu> zzgku = zzgfv.zzf;
        if (!zzgku.zzc()) {
            zzgfv.zzf = zzgkl.zzaF(zzgku);
        }
        zzgfv.zzf.add(zzgfu);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzgfu.class});
        } else if (i12 == 3) {
            return new zzgfv();
        } else {
            if (i12 == 4) {
                return new zzgfs((zzgfr) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
