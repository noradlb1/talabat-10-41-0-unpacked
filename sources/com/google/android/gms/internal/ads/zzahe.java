package com.google.android.gms.internal.ads;

import android.util.Log;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Locale;

public final class zzahe {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable(zza, 2);
    private static final String zzc = zzahe.class.getName();

    public static void zza(String str, Object... objArr) {
        zze(str, objArr);
    }

    public static void zzb(String str, Object... objArr) {
        Log.e(zza, zze(str, objArr));
    }

    public static void zzc(Throwable th2, String str, Object... objArr) {
        Log.e(zza, zze(str, objArr), th2);
    }

    public static void zzd(String str, Object... objArr) {
        if (zzb) {
            zze(str, objArr);
        }
    }

    private static String zze(String str, Object... objArr) {
        String str2;
        String format = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i11 = 2;
        while (true) {
            if (i11 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i11].getClassName().equals(zzc)) {
                String className = stackTrace[i11].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i11].getMethodName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb2.append(substring2);
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                sb2.append(methodName);
                str2 = sb2.toString();
                break;
            } else {
                i11++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, format});
    }
}
