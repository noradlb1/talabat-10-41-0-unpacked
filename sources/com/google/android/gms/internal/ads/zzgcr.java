package com.google.android.gms.internal.ads;

public final class zzgcr extends zzgkl<zzgcr, zzgcq> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgcr zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgcx zzf;
    /* access modifiers changed from: private */
    public zzgjf zzg = zzgjf.zzb;

    static {
        zzgcr zzgcr = new zzgcr();
        zzb = zzgcr;
        zzgkl.zzaK(zzgcr.class, zzgcr);
    }

    private zzgcr() {
    }

    public static zzgcq zzc() {
        return (zzgcq) zzb.zzat();
    }

    public static zzgcr zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgcr) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzi(zzgcr zzgcr, zzgcx zzgcx) {
        zzgcx.getClass();
        zzgcr.zzf = zzgcx;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgcr();
        } else {
            if (i12 == 4) {
                return new zzgcq((zzgcp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgcx zzf() {
        zzgcx zzgcx = this.zzf;
        return zzgcx == null ? zzgcx.zze() : zzgcx;
    }

    public final zzgjf zzg() {
        return this.zzg;
    }
}
