package com.google.android.gms.internal.ads;

public final class zzgem extends zzgkl<zzgem, zzgel> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgem zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgeg zzf;
    /* access modifiers changed from: private */
    public zzgjf zzg;
    /* access modifiers changed from: private */
    public zzgjf zzh;

    static {
        zzgem zzgem = new zzgem();
        zzb = zzgem;
        zzgkl.zzaK(zzgem.class, zzgem);
    }

    private zzgem() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzg = zzgjf;
        this.zzh = zzgjf;
    }

    public static zzgel zzd() {
        return (zzgel) zzb.zzat();
    }

    public static zzgem zzf() {
        return zzb;
    }

    public static zzgem zzg(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgem) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzk(zzgem zzgem, zzgeg zzgeg) {
        zzgeg.getClass();
        zzgem.zzf = zzgeg;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzgem();
        } else {
            if (i12 == 4) {
                return new zzgel((zzgek) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgeg zzc() {
        zzgeg zzgeg = this.zzf;
        return zzgeg == null ? zzgeg.zze() : zzgeg;
    }

    public final zzgjf zzh() {
        return this.zzg;
    }

    public final zzgjf zzi() {
        return this.zzh;
    }
}
