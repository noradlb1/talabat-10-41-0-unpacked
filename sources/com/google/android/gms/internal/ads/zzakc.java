package com.google.android.gms.internal.ads;

public final class zzakc extends zzgkl<zzakc, zzakb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzakc zzb;
    private int zze;
    private zzgku<zzgjf> zzf = zzgkl.zzaE();
    private zzgjf zzg = zzgjf.zzb;
    private int zzh = 1;
    private int zzi = 1;

    static {
        zzakc zzakc = new zzakc();
        zzb = zzakc;
        zzgkl.zzaK(zzakc.class, zzakc);
    }

    private zzakc() {
    }

    public static zzakb zza() {
        return (zzakb) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzakc zzakc, zzgjf zzgjf) {
        zzgku<zzgjf> zzgku = zzakc.zzf;
        if (!zzgku.zzc()) {
            zzakc.zzf = zzgkl.zzaF(zzgku);
        }
        zzakc.zzf.add(zzgjf);
    }

    public static /* synthetic */ void zze(zzakc zzakc, zzgjf zzgjf) {
        zzakc.zze |= 1;
        zzakc.zzg = zzgjf;
    }

    public static /* synthetic */ void zzf(zzakc zzakc, int i11) {
        zzakc.zzi = i11 - 1;
        zzakc.zze |= 4;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh", zzajw.zza, "zzi", zzaju.zza});
        } else if (i12 == 3) {
            return new zzakc();
        } else {
            if (i12 == 4) {
                return new zzakb((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
