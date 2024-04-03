package com.google.android.gms.internal.ads;

public final class zzgfu extends zzgkl<zzgfu, zzgft> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfu zzb;
    private String zze = "";
    private int zzf;
    /* access modifiers changed from: private */
    public int zzg;
    /* access modifiers changed from: private */
    public int zzh;

    static {
        zzgfu zzgfu = new zzgfu();
        zzb = zzgfu;
        zzgkl.zzaK(zzgfu.class, zzgfu);
    }

    private zzgfu() {
    }

    public static zzgft zza() {
        return (zzgft) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzgfu zzgfu, String str) {
        str.getClass();
        zzgfu.zze = str;
    }

    public static /* synthetic */ void zzg(zzgfu zzgfu, int i11) {
        if (i11 != 1) {
            zzgfu.zzf = i11 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzgfu();
        } else {
            if (i12 == 4) {
                return new zzgft((zzgfr) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
