package com.google.android.gms.internal.ads;

public final class zzgow extends zzgkl<zzgow, zzgov> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgow zzb;
    private int zze;
    private String zzf = "";
    private long zzg;
    private boolean zzh;

    static {
        zzgow zzgow = new zzgow();
        zzb = zzgow;
        zzgkl.zzaK(zzgow.class, zzgow);
    }

    private zzgow() {
    }

    public static zzgov zza() {
        return (zzgov) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzgow zzgow, String str) {
        zzgow.zze |= 1;
        zzgow.zzf = str;
    }

    public static /* synthetic */ void zze(zzgow zzgow, long j11) {
        zzgow.zze |= 2;
        zzgow.zzg = j11;
    }

    public static /* synthetic */ void zzf(zzgow zzgow, boolean z11) {
        zzgow.zze |= 4;
        zzgow.zzh = z11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzgow();
        } else {
            if (i12 == 4) {
                return new zzgov((zzgnx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
