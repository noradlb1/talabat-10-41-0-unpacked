package com.google.android.play.core.review.internal;

import android.util.Base64;
import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzv {
    public static String zza(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Constants.SHA256);
            instance.update(bArr);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
