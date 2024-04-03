package com.google.android.gms.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zza {
    public static int zza(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzb(AdSize adSize) {
        return adSize.zza();
    }

    public static AdSize zzc(int i11, int i12, String str) {
        return new AdSize(i11, i12, str);
    }

    public static AdSize zzd(int i11, int i12) {
        AdSize adSize = new AdSize(i11, i12);
        adSize.zze(true);
        adSize.zzc(i12);
        return adSize;
    }

    public static AdSize zze(int i11, int i12) {
        AdSize adSize = new AdSize(i11, i12);
        adSize.zzf(true);
        adSize.zzd(i12);
        return adSize;
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zzg();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzh(AdSize adSize) {
        return adSize.zzi();
    }
}
