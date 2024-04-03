package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

final class zzblt extends zzblu {
    @Nullable
    private static final String zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < str.length() && str.charAt(i12) == ',') {
            i12++;
        }
        while (length > 0) {
            int i13 = length - 1;
            if (str.charAt(i13) != ',') {
                break;
            }
            length = i13;
        }
        if (length < i12) {
            return null;
        }
        if (i12 != 0) {
            i11 = i12;
        } else if (length == str.length()) {
            return str;
        }
        return str.substring(i11, length);
    }

    public final String zza(@Nullable String str, String str2) {
        String zzb = zzb(str);
        String zzb2 = zzb(str2);
        if (TextUtils.isEmpty(zzb)) {
            return zzb2;
        }
        if (TextUtils.isEmpty(zzb2)) {
            return zzb;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzb).length() + 1 + String.valueOf(zzb2).length());
        sb2.append(zzb);
        sb2.append(",");
        sb2.append(zzb2);
        return sb2.toString();
    }
}
