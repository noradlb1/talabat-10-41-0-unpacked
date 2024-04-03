package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzdw {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(@Nullable String str, @Nullable String str2) {
        long j11 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j11 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 28);
                sb2.append("Unexpected Content-Length [");
                sb2.append(str);
                sb2.append("]");
                Log.e("HttpUtil", sb2.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j11;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j11;
        }
        try {
            String group = matcher.group(2);
            group.getClass();
            long parseLong = Long.parseLong(group);
            String group2 = matcher.group(1);
            group2.getClass();
            long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
            if (j11 < 0) {
                return parseLong2;
            }
            if (j11 == parseLong2) {
                return j11;
            }
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(str2).length());
            sb3.append("Inconsistent headers [");
            sb3.append(str);
            sb3.append("] [");
            sb3.append(str2);
            sb3.append("]");
            Log.w("HttpUtil", sb3.toString());
            return Math.max(j11, parseLong2);
        } catch (NumberFormatException unused2) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str2).length() + 27);
            sb4.append("Unexpected Content-Range [");
            sb4.append(str2);
            sb4.append("]");
            Log.e("HttpUtil", sb4.toString());
            return j11;
        }
    }

    public static long zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }
}
