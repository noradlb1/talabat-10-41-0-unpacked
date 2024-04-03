package com.google.android.gms.internal.ads;

import android.util.Base64;

public final class zzake {
    public static String zza(byte[] bArr, boolean z11) {
        return Base64.encodeToString(bArr, true != z11 ? 2 : 11);
    }

    public static byte[] zzb(String str, boolean z11) throws IllegalArgumentException {
        int i11;
        String str2;
        if (true != z11) {
            i11 = 2;
        } else {
            i11 = 11;
        }
        byte[] decode = Base64.decode(str, i11);
        if (decode.length != 0 || str.length() <= 0) {
            return decode;
        }
        if (str.length() != 0) {
            str2 = "Unable to decode ".concat(str);
        } else {
            str2 = new String("Unable to decode ");
        }
        throw new IllegalArgumentException(str2);
    }
}
