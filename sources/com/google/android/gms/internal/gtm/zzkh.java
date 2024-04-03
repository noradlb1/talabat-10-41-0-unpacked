package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class zzkh extends zzhb {
    public static String encode(String str, String str2) throws UnsupportedEncodingException {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        Charset forName = Charset.forName("UTF-8");
        int i12 = 0;
        while (i12 < str.length()) {
            char charAt = str.charAt(i12);
            if (str2.indexOf(charAt) != -1) {
                sb2.append((char) charAt);
                i12++;
            } else {
                if (Character.isHighSurrogate((char) charAt)) {
                    int i13 = i12 + 1;
                    if (i13 >= str.length()) {
                        throw new UnsupportedEncodingException();
                    } else if (Character.isLowSurrogate(str.charAt(i13))) {
                        i11 = 2;
                    } else {
                        throw new UnsupportedEncodingException();
                    }
                } else {
                    i11 = 1;
                }
                int i14 = i11 + i12;
                byte[] bytes = str.substring(i12, i14).getBytes(forName);
                for (int i15 = 0; i15 < bytes.length; i15++) {
                    sb2.append("%");
                    sb2.append(Character.toUpperCase(Character.forDigit((bytes[i15] >> 4) & 15, 16)));
                    sb2.append(Character.toUpperCase(Character.forDigit(bytes[i15] & Ascii.SI, 16)));
                }
                i12 = i14;
            }
        }
        return sb2.toString().replaceAll(" ", "%20");
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa zzoa;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            zzoa = (zzoa) Preconditions.checkNotNull(zzoaArr[0]);
        } else {
            zzoa = zzog.zzaum;
        }
        try {
            return new zzom(encode(zzha.zzd(zzoa), "#;/?:@&=+$,abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_.!~*'()0123456789"));
        } catch (UnsupportedEncodingException unused) {
            return zzog.zzaum;
        }
    }
}
