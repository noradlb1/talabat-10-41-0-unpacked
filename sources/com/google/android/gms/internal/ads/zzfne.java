package com.google.android.gms.internal.ads;

public final class zzfne extends zzgkl<zzfne, zzfnd> implements zzglw {
    private static final zzgkr<Integer, Object> zzb = new zzfnb();
    /* access modifiers changed from: private */
    public static final zzfne zze;
    private int zzf;
    private zzgkq zzg = zzgkl.zzaB();
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzfne zzfne = new zzfne();
        zze = zzfne;
        zzgkl.zzaK(zzfne.class, zzfne);
    }

    private zzfne() {
    }

    public static zzfnd zza() {
        return (zzfnd) zze.zzat();
    }

    public static /* synthetic */ void zzd(zzfne zzfne, String str) {
        str.getClass();
        zzfne.zzf |= 1;
        zzfne.zzh = str;
    }

    public static /* synthetic */ void zze(zzfne zzfne, int i11) {
        zzgkq zzgkq = zzfne.zzg;
        if (!zzgkq.zzc()) {
            zzfne.zzg = zzgkl.zzaC(zzgkq);
        }
        zzfne.zzg.zzh(2);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zze, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzf", "zzg", zzfnc.zza, "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzfne();
        } else {
            if (i12 == 4) {
                return new zzfnd((zzfnb) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zze;
        }
    }
}
