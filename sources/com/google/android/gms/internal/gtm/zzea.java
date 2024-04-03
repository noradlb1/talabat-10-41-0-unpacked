package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.CrashUtils;

final class zzea {
    public static void zza(String str, Context context) {
        zzev.zzav(str);
        if (CrashUtils.addDynamiteErrorToDropBox(context, new RuntimeException(str))) {
            zzev.zzab("Crash reported successfully.");
        } else {
            zzev.zzab("Failed to report crash");
        }
    }

    public static void zzb(String str, Context context) {
        zzev.zzac(str);
        if (CrashUtils.addDynamiteErrorToDropBox(context, new RuntimeException(str))) {
            zzev.zzab("Crash reported successfully.");
        } else {
            zzev.zzab("Failed to report crash");
        }
    }

    public static void zza(String str, Throwable th2, Context context) {
        zzev.zza(str, th2);
        if (CrashUtils.addDynamiteErrorToDropBox(context, th2)) {
            zzev.zzab("Crash reported successfully.");
        } else {
            zzev.zzab("Failed to report crash");
        }
    }
}
