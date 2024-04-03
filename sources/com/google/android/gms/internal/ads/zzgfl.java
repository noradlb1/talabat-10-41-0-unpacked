package com.google.android.gms.internal.ads;

@Deprecated
public final class zzgfl extends zzgkl<zzgfl, zzgfk> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfl zzb;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private boolean zzh;
    private String zzi = "";

    static {
        zzgfl zzgfl = new zzgfl();
        zzb = zzgfl;
        zzgkl.zzaK(zzgfl.class, zzgfl);
    }

    private zzgfl() {
    }

    public final int zza() {
        return this.zzg;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzgfl();
        } else {
            if (i12 == 4) {
                return new zzgfk((zzgfj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzh;
    }
}
