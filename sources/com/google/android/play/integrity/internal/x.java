package com.google.android.play.integrity.internal;

import android.util.Base64;
import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class x {
    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Constants.SHA256);
            instance.update(bArr);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
