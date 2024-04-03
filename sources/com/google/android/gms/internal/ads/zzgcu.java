package com.google.android.gms.internal.ads;

public final class zzgcu extends zzgkl<zzgcu, zzgct> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgcu zzb;
    private zzgcx zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgcu zzgcu = new zzgcu();
        zzb = zzgcu;
        zzgkl.zzaK(zzgcu.class, zzgcu);
    }

    private zzgcu() {
    }

    public static zzgct zzc() {
        return (zzgct) zzb.zzat();
    }

    public static zzgcu zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgcu) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzg(zzgcu zzgcu, zzgcx zzgcx) {
        zzgcx.getClass();
        zzgcu.zze = zzgcx;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgcu();
        } else {
            if (i12 == 4) {
                return new zzgct((zzgcs) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgcx zzf() {
        zzgcx zzgcx = this.zze;
        return zzgcx == null ? zzgcx.zze() : zzgcx;
    }
}
