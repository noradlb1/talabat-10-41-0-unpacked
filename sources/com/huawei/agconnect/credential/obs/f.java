package com.huawei.agconnect.credential.obs;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.common.base.Ascii;
import com.huawei.agconnect.common.api.Logger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f47574a = "0123456789ABCDEF".toCharArray();

    public static String a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = Constants.SHA256;
            }
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(str.getBytes(Charset.defaultCharset()));
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e11) {
            Logger.e("", "", e11);
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            char[] cArr = f47574a;
            sb2.append(cArr[(b11 >> 4) & 15]);
            sb2.append(cArr[b11 & Ascii.SI]);
        }
        return sb2.toString();
    }
}
