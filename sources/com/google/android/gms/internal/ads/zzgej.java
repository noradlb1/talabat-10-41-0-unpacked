package com.google.android.gms.internal.ads;

public final class zzgej extends zzgkl<zzgej, zzgei> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgej zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgem zzf;
    /* access modifiers changed from: private */
    public zzgjf zzg = zzgjf.zzb;

    static {
        zzgej zzgej = new zzgej();
        zzb = zzgej;
        zzgkl.zzaK(zzgej.class, zzgej);
    }

    private zzgej() {
    }

    public static zzgei zzc() {
        return (zzgei) zzb.zzat();
    }

    public static zzgej zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgej) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzi(zzgej zzgej, zzgem zzgem) {
        zzgem.getClass();
        zzgej.zzf = zzgem;
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
            return new zzgej();
        } else {
            if (i12 == 4) {
                return new zzgei((zzgeh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgem zzf() {
        zzgem zzgem = this.zzf;
        return zzgem == null ? zzgem.zzf() : zzgem;
    }

    public final zzgjf zzg() {
        return this.zzg;
    }
}
