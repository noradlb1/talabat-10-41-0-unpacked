package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33756a = "SHA";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33757b = "SHA-256";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33758c = "";

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f33759d = {"SHA-256", "SHA-384", "SHA-512"};

    private SHA() {
    }

    private static boolean a(String str) {
        for (String equals : f33759d) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, "SHA-256");
    }

    public static String shaEncrypt(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f33756a, "content or algorithm is null.");
            return "";
        } else if (!a(str2)) {
            b.b(f33756a, "algorithm is not safe or legal");
            return "";
        } else {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = new byte[0];
                b.b(f33756a, "Error in generate SHA UnsupportedEncodingException");
            }
            return HexUtil.byteArray2HexStr(shaEncryptByte(bArr, str2));
        }
    }

    public static byte[] shaEncryptByte(byte[] bArr, String str) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            b.b(f33756a, "content or algorithm is null.");
            return new byte[0];
        } else if (!a(str)) {
            b.b(f33756a, "algorithm is not safe or legal");
            return new byte[0];
        } else {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                instance.update(bArr);
                return instance.digest();
            } catch (NoSuchAlgorithmException unused) {
                b.b(f33756a, "Error in generate SHA NoSuchAlgorithmException");
                return new byte[0];
            }
        }
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    public static boolean validateSHA256(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }
}
