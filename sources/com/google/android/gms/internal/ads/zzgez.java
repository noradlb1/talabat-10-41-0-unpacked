package com.google.android.gms.internal.ads;

public final class zzgez extends zzgkl<zzgez, zzgey> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgez zzb;
    private zzgfc zze;
    /* access modifiers changed from: private */
    public int zzf;
    private int zzg;

    static {
        zzgez zzgez = new zzgez();
        zzb = zzgez;
        zzgkl.zzaK(zzgez.class, zzgez);
    }

    private zzgez() {
    }

    public static zzgey zzc() {
        return (zzgey) zzb.zzat();
    }

    public static zzgez zze() {
        return zzb;
    }

    public static zzgez zzf(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgez) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzh(zzgez zzgez, zzgfc zzgfc) {
        zzgfc.getClass();
        zzgez.zze = zzgfc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgez();
        } else {
            if (i12 == 4) {
                return new zzgey((zzgex) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgfc zzg() {
        zzgfc zzgfc = this.zze;
        return zzgfc == null ? zzgfc.zze() : zzgfc;
    }
}
