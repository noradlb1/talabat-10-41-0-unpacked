package com.google.android.gms.internal.ads;

import java.util.Random;

public final class zzbgo {
    private static final zzbgo zza = new zzbgo();
    private final zzcis zzb;
    private final zzbgm zzc;
    private final String zzd;
    private final zzcjf zze;
    private final Random zzf;

    public zzbgo() {
        zzcis zzcis = new zzcis();
        zzbgm zzbgm = new zzbgm(new zzbfc(), new zzbfa(), new zzbjv(), new zzbqh(), new zzcfl(), new zzcbp(), new zzbqi());
        String zzd2 = zzcis.zzd();
        zzcjf zzcjf = new zzcjf(0, 214106000, true, false, false);
        Random random = new Random();
        this.zzb = zzcis;
        this.zzc = zzbgm;
        this.zzd = zzd2;
        this.zze = zzcjf;
        this.zzf = random;
    }

    public static zzbgm zza() {
        return zza.zzc;
    }

    public static zzcis zzb() {
        return zza.zzb;
    }

    public static zzcjf zzc() {
        return zza.zze;
    }

    public static String zzd() {
        return zza.zzd;
    }

    public static Random zze() {
        return zza.zzf;
    }
}
