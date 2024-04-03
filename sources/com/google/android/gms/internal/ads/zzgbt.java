package com.google.android.gms.internal.ads;

public final class zzgbt extends zzgkl<zzgbt, zzgbs> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgbt zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzgjf zzf = zzgjf.zzb;
    private zzgbz zzg;

    static {
        zzgbt zzgbt = new zzgbt();
        zzb = zzgbt;
        zzgkl.zzaK(zzgbt.class, zzgbt);
    }

    private zzgbt() {
    }

    public static zzgbs zzc() {
        return (zzgbs) zzb.zzat();
    }

    public static zzgbt zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgbt) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzj(zzgbt zzgbt, zzgbz zzgbz) {
        zzgbz.getClass();
        zzgbt.zzg = zzgbz;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgbt();
        } else {
            if (i12 == 4) {
                return new zzgbs((zzgbr) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgbz zzf() {
        zzgbz zzgbz = this.zzg;
        return zzgbz == null ? zzgbz.zze() : zzgbz;
    }

    public final zzgjf zzg() {
        return this.zzf;
    }
}
