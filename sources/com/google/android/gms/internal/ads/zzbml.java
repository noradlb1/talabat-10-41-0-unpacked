package com.google.android.gms.internal.ads;

public class zzbml<T> {
    private final String zza;
    private final T zzb;
    private final int zzc;

    public zzbml(String str, T t11, int i11) {
        this.zza = str;
        this.zzb = t11;
        this.zzc = i11;
    }

    public static zzbml<Double> zza(String str, double d11) {
        return new zzbml<>(str, Double.valueOf(d11), 3);
    }

    public static zzbml<Long> zzb(String str, long j11) {
        return new zzbml<>(str, Long.valueOf(j11), 2);
    }

    public static zzbml<String> zzc(String str, String str2) {
        return new zzbml<>(str, str2, 4);
    }

    public static zzbml<Boolean> zzd(String str, boolean z11) {
        return new zzbml<>(str, Boolean.valueOf(z11), 1);
    }

    public final T zze() {
        zzbnl zza2 = zzbnn.zza();
        if (zza2 == null) {
            if (zzbnn.zzb() != null) {
                zzbnn.zzb().zza();
            }
            return this.zzb;
        }
        int i11 = this.zzc - 1;
        if (i11 == 0) {
            return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i11 == 1) {
            return zza2.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        if (i11 != 2) {
            return zza2.zzd(this.zza, (String) this.zzb);
        }
        return zza2.zzb(this.zza, ((Double) this.zzb).doubleValue());
    }
}
