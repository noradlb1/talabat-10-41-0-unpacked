package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import android.os.Build;

public class RootKeyUtil {

    /* renamed from: b  reason: collision with root package name */
    private static final String f33809b = "RootKeyUtil";

    /* renamed from: a  reason: collision with root package name */
    private byte[] f33810a = null;

    private RootKeyUtil() {
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public byte[] getRootKey() {
        return (byte[]) this.f33810a.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.f33810a);
    }

    @SuppressLint({"NewApi"})
    private void a(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            b.c(f33809b, "initRootKey: sha1");
            this.f33810a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
            return;
        }
        b.c(f33809b, "initRootKey: sha256");
        this.f33810a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, bArr);
        return rootKeyUtil;
    }
}
