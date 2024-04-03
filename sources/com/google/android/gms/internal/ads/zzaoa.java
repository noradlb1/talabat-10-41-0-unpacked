package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzaoa implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzams zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzaiz zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzaoa(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        this.zzb = zzams;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzaiz;
        this.zzg = i11;
        this.zzh = i12;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzk() throws Exception {
        int i11;
        try {
            long nanoTime = System.nanoTime();
            Method zzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = zzj;
            if (zzj == null) {
                return null;
            }
            zza();
            zzalo zzd2 = this.zzb.zzd();
            if (!(zzd2 == null || (i11 = this.zzg) == Integer.MIN_VALUE)) {
                zzd2.zzc(this.zzh, i11, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
