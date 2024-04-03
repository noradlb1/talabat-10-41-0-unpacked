package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

public class BaseKeyUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33797a = "BaseKeyUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final int f33798b = 16;

    /* renamed from: c  reason: collision with root package name */
    private static final int f33799c = 16;

    /* renamed from: d  reason: collision with root package name */
    private static final int f33800d = 10000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f33801e = 32;

    /* renamed from: f  reason: collision with root package name */
    private static final int f33802f = 1;

    private static int a(int i11, int i12, int i13) {
        if (i12 < i11) {
            i11 = i12;
        }
        return i13 < i11 ? i13 : i11;
    }

    private static boolean a(int i11) {
        return i11 >= 16;
    }

    private static boolean a(int i11, byte[] bArr) {
        return a(i11) & a(bArr);
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i11, boolean z11) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i11, z11));
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z11) {
        return exportRootKey(str, str2, str3, bArr, 16, z11);
    }

    public static byte[] exportRootKey32(String str, String str2, String str3, byte[] bArr, boolean z11) {
        return exportRootKey(str, str2, str3, bArr, 32, z11);
    }

    public static byte[] exportRootKey32Iteration1(String str, String str2, String str3, byte[] bArr, boolean z11) {
        return exportRootKey(str, str2, str3, bArr, 1, 32, z11);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKeyIteration1(String str, String str2, String str3, byte[] bArr, boolean z11) {
        return exportRootKey(str, str2, str3, bArr, 1, 16, z11);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i11, boolean z11) {
        return exportRootKey(str, str2, str3, bArr, 10000, i11, z11);
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i11, int i12, boolean z11) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int a11 = a(hexStr2ByteArray.length, hexStr2ByteArray2.length, hexStr2ByteArray3.length);
        if (a(a11, bArr)) {
            char[] cArr = new char[a11];
            for (int i13 = 0; i13 < a11; i13++) {
                cArr[i13] = (char) ((hexStr2ByteArray[i13] ^ hexStr2ByteArray2[i13]) ^ hexStr2ByteArray3[i13]);
            }
            if (!z11) {
                b.c(f33797a, "exportRootKey: sha1");
                return PBKDF2.pbkdf2(cArr, bArr, i11, i12 * 8);
            }
            b.c(f33797a, "exportRootKey: sha256");
            return PBKDF2.pbkdf2SHA256(cArr, bArr, i11, i12 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i11, boolean z11) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i11, z11);
    }
}
