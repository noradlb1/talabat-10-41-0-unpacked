package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class HMACSHA256 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33743a = "HMACSHA256";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33744b = "HmacSHA256";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33745c = "";

    /* renamed from: d  reason: collision with root package name */
    private static final int f33746d = 32;

    public static byte[] hmacEncrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            b.b(f33743a, "content or key is null.");
            return new byte[0];
        } else if (bArr2.length < 32) {
            b.b(f33743a, "hmac key length is not right");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f33744b);
                Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
                instance.init(secretKeySpec);
                return instance.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e11) {
                String str = f33743a;
                b.b(str, "hmacsha256 encrypt exception" + e11.getMessage());
                return new byte[0];
            }
        }
    }

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            b.b(f33743a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            String str2 = f33743a;
            b.b(str2, "hmacsha256 encrypt exception" + e11.getMessage());
            bArr2 = new byte[0];
        }
        return HexUtil.byteArray2HexStr(hmacEncrypt(bArr2, bArr));
    }
}
