package com.huawei.wisesecurity.kfs.util;

public final class ByteUtil {
    public static byte[] clone(byte[] bArr) {
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }
}
