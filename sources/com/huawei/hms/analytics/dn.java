package com.huawei.hms.analytics;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.huawei.hms.analytics.core.log.HiLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class dn {
    private static final String[] lmn = {Constants.SHA256, "SHA-384", "SHA-512"};

    public static String lmn(String str) {
        return lmn(str, Constants.SHA256);
    }

    private static String lmn(String str, String str2) {
        boolean z11;
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SHA", "content or algorithm is null.");
            return "";
        }
        String[] strArr = lmn;
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = false;
                break;
            } else if (strArr[i11].equals(str2)) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (!z11) {
            str3 = "algorithm is not safe or legal";
        } else {
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes("UTF-8"));
                byte[] digest = instance.digest();
                if (digest == null || digest.length == 0) {
                    return "";
                }
                StringBuilder sb2 = new StringBuilder();
                for (byte b11 : digest) {
                    String hexString = Integer.toHexString(b11 & 255);
                    if (hexString.length() == 1) {
                        sb2.append('0');
                    }
                    sb2.append(hexString);
                }
                return sb2.toString();
            } catch (UnsupportedEncodingException unused) {
                str3 = "Error in generate SHA UnsupportedEncodingException";
            } catch (NoSuchAlgorithmException unused2) {
                str3 = "Error in generate SHA NoSuchAlgorithmException";
            }
        }
        HiLog.e("SHA", str3);
        return "";
    }
}
