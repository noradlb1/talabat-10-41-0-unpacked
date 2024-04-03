package com.google.android.gms.internal.ads;

public final class zzgoo extends zzgkl<zzgoo, zzgom> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgoo zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private zzgjf zzh = zzgjf.zzb;

    static {
        zzgoo zzgoo = new zzgoo();
        zzb = zzgoo;
        zzgkl.zzaK(zzgoo.class, zzgoo);
    }

    private zzgoo() {
    }

    public static zzgom zza() {
        return (zzgom) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzgoo zzgoo, String str) {
        zzgoo.zze |= 2;
        zzgoo.zzg = "image/png";
    }

    public static /* synthetic */ void zze(zzgoo zzgoo, zzgjf zzgjf) {
        zzgjf.getClass();
        zzgoo.zze |= 4;
        zzgoo.zzh = zzgjf;
    }

    public static /* synthetic */ void zzf(zzgoo zzgoo, int i11) {
        zzgoo.zzf = 1;
        zzgoo.zze = 1 | zzgoo.zze;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zze", "zzf", zzgon.zza, "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzgoo();
        } else {
            if (i12 == 4) {
                return new zzgom((zzgnx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
