package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.ads.AdRequest;
import com.google.android.gms.common.util.VisibleForTesting;

public class zzciz {
    protected static final zzfqp zza = zzfqp.zzb(4000);

    @VisibleForTesting
    public static String zzd(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb2 = new StringBuilder(str.length() + 13);
        sb2.append(str);
        sb2.append(" @");
        sb2.append(lineNumber);
        return sb2.toString();
    }

    public static void zze(String str) {
        if (zzm(3) && str != null && str.length() > 4000) {
            for (String next : zza.zzd(str)) {
            }
        }
    }

    public static void zzf(String str, Throwable th2) {
        zzm(3);
    }

    public static void zzg(String str) {
        if (!zzm(6)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.e(AdRequest.LOGTAG, str);
            return;
        }
        boolean z11 = true;
        for (String next : zza.zzd(str)) {
            if (z11) {
                Log.e(AdRequest.LOGTAG, next);
            } else {
                Log.e("Ads-cont", next);
            }
            z11 = false;
        }
    }

    public static void zzh(String str, Throwable th2) {
        if (zzm(6)) {
            Log.e(AdRequest.LOGTAG, str, th2);
        }
    }

    public static void zzi(String str) {
        if (!zzm(4)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.i(AdRequest.LOGTAG, str);
            return;
        }
        boolean z11 = true;
        for (String next : zza.zzd(str)) {
            if (z11) {
                Log.i(AdRequest.LOGTAG, next);
            } else {
                Log.i("Ads-cont", next);
            }
            z11 = false;
        }
    }

    public static void zzj(String str) {
        if (!zzm(5)) {
            return;
        }
        if (str == null || str.length() <= 4000) {
            Log.w(AdRequest.LOGTAG, str);
            return;
        }
        boolean z11 = true;
        for (String next : zza.zzd(str)) {
            if (z11) {
                Log.w(AdRequest.LOGTAG, next);
            } else {
                Log.w("Ads-cont", next);
            }
            z11 = false;
        }
    }

    public static void zzk(String str, Throwable th2) {
        if (zzm(5)) {
            Log.w(AdRequest.LOGTAG, str, th2);
        }
    }

    public static void zzl(String str, @Nullable Throwable th2) {
        if (!zzm(5)) {
            return;
        }
        if (th2 != null) {
            zzk(zzd(str), th2);
        } else {
            zzj(zzd(str));
        }
    }

    public static boolean zzm(int i11) {
        if (i11 >= 5 || Log.isLoggable(AdRequest.LOGTAG, i11)) {
            return true;
        }
        return false;
    }
}
