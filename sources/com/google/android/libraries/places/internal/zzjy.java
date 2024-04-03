package com.google.android.libraries.places.internal;

public final class zzjy extends zzabs<zzjy, zzjt> implements zzada {
    /* access modifiers changed from: private */
    public static final zzjy zzb;
    private int zze;
    private String zzf = "";
    private int zzg;
    private int zzh;
    private String zzi = "";
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;

    static {
        zzjy zzjy = new zzjy();
        zzb = zzjy;
        zzabs.zzG(zzjy.class, zzjy);
    }

    private zzjy() {
    }

    public static zzjt zza() {
        return (zzjt) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzjy zzjy, String str) {
        zzjy.zze |= 1;
        zzjy.zzf = str;
    }

    public static /* synthetic */ void zze(zzjy zzjy, int i11) {
        zzjy.zze |= 2;
        zzjy.zzg = i11;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007\tဌ\b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzju.zza, "zzl", zzjw.zza, "zzm", zzjv.zza, "zzn", zzjx.zza});
        } else if (i12 == 3) {
            return new zzjy();
        } else {
            if (i12 == 4) {
                return new zzjt((zzjs) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
