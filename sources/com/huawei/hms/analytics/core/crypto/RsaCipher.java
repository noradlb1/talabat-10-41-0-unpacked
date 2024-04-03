package com.huawei.hms.analytics.core.crypto;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class RsaCipher {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f47908a = Charset.forName("UTF-8");

    public static String encrypt(byte[] bArr, String str) {
        String str2;
        if (bArr == null || str == null || str.length() == 0) {
            HiLog.e("RsaCipherCommander", "content or public key is null");
            return "";
        }
        try {
            return HAHexUtil.byteArray2HexString(RSAEncrypt.encrypt(str.getBytes(f47908a), KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            HiLog.w("RsaCipherCommander", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "rsaEncrypt(): InvalidKeySpecException";
            HiLog.w("RsaCipherCommander", str2);
            return "";
        }
    }
}
