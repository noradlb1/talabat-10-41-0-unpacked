package com.google.android.gms.internal.ads;

public final class zzgdm extends zzgkl<zzgdm, zzgdl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgdm zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzgjf zzf = zzgjf.zzb;

    static {
        zzgdm zzgdm = new zzgdm();
        zzb = zzgdm;
        zzgkl.zzaK(zzgdm.class, zzgdm);
    }

    private zzgdm() {
    }

    public static zzgdl zzc() {
        return (zzgdl) zzb.zzat();
    }

    public static zzgdm zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgdm) zzgkl.zzay(zzb, zzgjf, zzgjx);
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgdm();
        } else {
            if (i12 == 4) {
                return new zzgdl((zzgdk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjf zzf() {
        return this.zzf;
    }
}
