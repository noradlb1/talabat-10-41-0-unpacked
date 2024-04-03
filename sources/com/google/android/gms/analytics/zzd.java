package com.google.android.gms.analytics;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;

@VisibleForTesting
public final class zzd {
    private static String zza(String str, int i11) {
        if (i11 <= 0) {
            zzch.zzf("index out of range for prefix", str);
            return "";
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11);
        sb2.append(str);
        sb2.append(i11);
        return sb2.toString();
    }

    public static String zzd(int i11) {
        return zza("&cd", i11);
    }

    public static String zze(int i11) {
        return zza("cd", i11);
    }

    public static String zzf(int i11) {
        return zza("&cm", i11);
    }

    public static String zzg(int i11) {
        return zza("cm", i11);
    }

    public static String zzh(int i11) {
        return zza("&pr", i11);
    }

    public static String zzi(int i11) {
        return zza("pr", i11);
    }

    public static String zzj(int i11) {
        return zza("&promo", i11);
    }

    public static String zzk(int i11) {
        return zza(NotificationCompat.CATEGORY_PROMO, i11);
    }

    public static String zzl(int i11) {
        return zza("pi", i11);
    }

    public static String zzm(int i11) {
        return zza("&il", i11);
    }

    public static String zzn(int i11) {
        return zza("il", i11);
    }

    public static String zzo(int i11) {
        return zza("cd", i11);
    }

    public static String zzp(int i11) {
        return zza("cm", i11);
    }
}
