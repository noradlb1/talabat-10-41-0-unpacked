package com.google.android.gms.internal.ads;

public final class zzgdp extends zzgkl<zzgdp, zzgdo> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgdp zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgdp zzgdp = new zzgdp();
        zzb = zzgdp;
        zzgkl.zzaK(zzgdp.class, zzgdp);
    }

    private zzgdp() {
    }

    public static zzgdo zzc() {
        return (zzgdo) zzb.zzat();
    }

    public static zzgdp zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgdp) zzgkl.zzay(zzb, zzgjf, zzgjx);
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgdp();
        } else {
            if (i12 == 4) {
                return new zzgdo((zzgdn) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
