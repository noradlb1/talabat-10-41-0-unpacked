package com.huawei.secure.android.common.encrypt.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class HexUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33807a = "";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33808b = "HexUtil";

    private HexUtil() {
    }

    public static String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static byte[] hexStr2ByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = upperCase.length() / 2;
            byte[] bArr = new byte[length];
            try {
                byte[] bytes = upperCase.getBytes("UTF-8");
                for (int i11 = 0; i11 < length; i11++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("0x");
                    int i12 = i11 * 2;
                    sb2.append(new String(new byte[]{bytes[i12]}, "UTF-8"));
                    bArr[i11] = (byte) (((byte) (Byte.decode(sb2.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i12 + 1]}, "UTF-8")).byteValue());
                }
                return bArr;
            } catch (UnsupportedEncodingException | NumberFormatException e11) {
                b.b(f33808b, "hex string 2 byte array exception : " + e11.getMessage());
                return new byte[0];
            }
        } catch (Throwable th2) {
            b.b(f33808b, "hex string toUpperCase exception : " + th2.getMessage());
            return new byte[0];
        }
    }

    public static String byteArray2HexStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e11) {
            b.b(f33808b, "byte array 2 hex string exception : " + e11.getMessage());
            return "";
        }
    }
}
