package com.google.android.gms.internal.ads;

public final class zzgoh extends zzgkl<zzgoh, zzgoe> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgoh zzb;
    private int zze;
    private zzgog zzf;
    private zzgku<zzgod> zzg = zzgkl.zzaE();
    private zzgjf zzh;
    private zzgjf zzi;
    private int zzj;
    private byte zzk = 2;

    static {
        zzgoh zzgoh = new zzgoh();
        zzb = zzgoh;
        zzgkl.zzaK(zzgoh.class, zzgoh);
    }

    private zzgoh() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzh = zzgjf;
        this.zzi = zzgjf;
    }

    public static zzgoe zza() {
        return (zzgoe) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzgoh zzgoh, zzgod zzgod) {
        zzgod.getClass();
        zzgku<zzgod> zzgku = zzgoh.zzg;
        if (!zzgku.zzc()) {
            zzgoh.zzg = zzgkl.zzaF(zzgku);
        }
        zzgoh.zzg.add(zzgod);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzk);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zze", "zzf", "zzg", zzgod.class, "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzgoh();
        } else {
            if (i12 == 4) {
                return new zzgoe((zzgnx) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzk = b11;
            return null;
        }
    }
}
