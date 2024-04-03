package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f49086a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str, int i11) {
        if (str == null || str.length() < i11) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, i11);
        return new Pair<>(HexUtil.hexStr2ByteArray(substring), str.substring(i11));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> a11 = a(str, 32);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) a11.second), HexUtil.hexStr2ByteArray(str2), (byte[]) a11.first), f49086a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
            if (hexStr2ByteArray.length >= 16) {
                return HexUtil.byteArray2HexStr(AesGcm.encrypt(bArr, hexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        v.b("AesCipher", str2);
        return "";
    }

    public static String b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f49086a), HexUtil.hexStr2ByteArray(str2)));
    }
}
