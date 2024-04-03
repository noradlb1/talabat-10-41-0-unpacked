package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvt  reason: invalid package */
public final class zzvt {
    public static String zza(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(r1 + r1);
        for (byte b11 : bArr) {
            byte b12 = b11 & 255;
            sb2.append("0123456789abcdef".charAt(b12 >> 4));
            sb2.append("0123456789abcdef".charAt(b12 & Ascii.SI));
        }
        return sb2.toString();
    }
}
