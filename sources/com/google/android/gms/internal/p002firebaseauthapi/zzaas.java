package com.google.android.gms.internal.p002firebaseauthapi;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaas  reason: invalid package */
public final /* synthetic */ class zzaas {
    public static String zza(zzaat zzaat, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance(Constants.SHA256).digest(str.getBytes()));
            int length = str2.length();
            int i11 = 0;
            while (i11 < length) {
                if (zze.zza(str2.charAt(i11))) {
                    char[] charArray = str2.toCharArray();
                    while (i11 < length) {
                        char c11 = charArray[i11];
                        if (zze.zza(c11)) {
                            charArray[i11] = (char) (c11 ^ ' ');
                        }
                        i11++;
                    }
                    return String.valueOf(charArray);
                }
                i11++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaat.zza.e("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }
}
