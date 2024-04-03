package com.google.android.gms.internal.ads;

public final class zzgod extends zzgkl<zzgod, zzgoc> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgod zzb;
    private int zze;
    private zzgjf zzf;
    private zzgjf zzg;
    private byte zzh = 2;

    static {
        zzgod zzgod = new zzgod();
        zzb = zzgod;
        zzgkl.zzaK(zzgod.class, zzgod);
    }

    private zzgod() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzf = zzgjf;
        this.zzg = zzgjf;
    }

    public static zzgoc zza() {
        return (zzgoc) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzgod zzgod, zzgjf zzgjf) {
        zzgod.zze |= 1;
        zzgod.zzf = zzgjf;
    }

    public static /* synthetic */ void zze(zzgod zzgod, zzgjf zzgjf) {
        zzgod.zze |= 2;
        zzgod.zzg = zzgjf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgod();
        } else {
            if (i12 == 4) {
                return new zzgoc((zzgnx) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzh = b11;
            return null;
        }
    }
}
