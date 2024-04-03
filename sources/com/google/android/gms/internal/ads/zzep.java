package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.dataflow.qual.Pure;

public final class zzep {
    @Pure
    public static void zza(String str, String str2, @Nullable Throwable th2) {
        Log.e(str, zzc(str2, th2));
    }

    @Pure
    public static void zzb(String str, String str2, @Nullable Throwable th2) {
        Log.w(str, zzc(str2, th2));
    }

    @Pure
    private static String zzc(String str, @Nullable Throwable th2) {
        String str2;
        if (th2 != null) {
            Throwable th3 = th2;
            while (true) {
                if (th3 == null) {
                    str2 = Log.getStackTraceString(th2).trim().replace("\t", "    ");
                    break;
                } else if (th3 instanceof UnknownHostException) {
                    str2 = "UnknownHostException (no network)";
                    break;
                } else {
                    th3 = th3.getCause();
                }
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = str2.replace(StringUtils.LF, "\n  ");
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + String.valueOf(replace).length());
        sb2.append(valueOf);
        sb2.append("\n  ");
        sb2.append(replace);
        sb2.append(10);
        return sb2.toString();
    }
}
