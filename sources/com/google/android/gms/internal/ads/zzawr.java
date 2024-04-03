package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

public final class zzawr {
    public static boolean zza(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzc(str));
    }

    public static boolean zzb(String str) {
        return "video".equals(zzc(str));
    }

    private static String zzc(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        if (str.length() != 0) {
            str2 = "Invalid mime type: ".concat(str);
        } else {
            str2 = new String("Invalid mime type: ");
        }
        throw new IllegalArgumentException(str2);
    }
}
