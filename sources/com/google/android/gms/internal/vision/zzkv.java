package com.google.android.gms.internal.vision;

public final class zzkv implements zzcu<zzku> {
    private static zzkv zzagg = new zzkv();
    private final zzcu<zzku> zzagd;

    private zzkv(zzcu<zzku> zzcu) {
        this.zzagd = zzcx.zza(zzcu);
    }

    public static boolean zzjp() {
        return ((zzku) zzagg.get()).zzjp();
    }

    public static boolean zzjq() {
        return ((zzku) zzagg.get()).zzjq();
    }

    public final /* synthetic */ Object get() {
        return this.zzagd.get();
    }

    public zzkv() {
        this(zzcx.zzd(new zzkw()));
    }
}
