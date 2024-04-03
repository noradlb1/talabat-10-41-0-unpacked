package com.google.android.gms.internal.ads;

public final class zzajo extends zzgkl<zzajo, zzajn> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzajo zzb;
    private int zze;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;

    static {
        zzajo zzajo = new zzajo();
        zzb = zzajo;
        zzgkl.zzaK(zzajo.class, zzajo);
    }

    private zzajo() {
    }

    public static zzajn zza() {
        return (zzajn) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzajo zzajo, long j11) {
        zzajo.zze |= 4;
        zzajo.zzh = j11;
    }

    public static /* synthetic */ void zze(zzajo zzajo, long j11) {
        zzajo.zze |= 8;
        zzajo.zzi = j11;
    }

    public static /* synthetic */ void zzf(zzajo zzajo, long j11) {
        zzajo.zze |= 16;
        zzajo.zzj = j11;
    }

    public static /* synthetic */ void zzg(zzajo zzajo, long j11) {
        zzajo.zze |= 32;
        zzajo.zzk = j11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zzajo();
        } else {
            if (i12 == 4) {
                return new zzajn((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
