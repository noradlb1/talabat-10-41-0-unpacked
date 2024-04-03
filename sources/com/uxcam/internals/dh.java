package com.uxcam.internals;

public class dh {
    public static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i11 = 0; i11 < charArray.length; i11++) {
            bArr[i11] = (byte) charArray[i11];
        }
        return bArr;
    }
}
