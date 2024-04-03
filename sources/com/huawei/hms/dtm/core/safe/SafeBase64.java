package com.huawei.hms.dtm.core.safe;

import android.util.Base64;
import com.huawei.hms.dtm.core.util.Logger;

public class SafeBase64 {
    private SafeBase64() {
    }

    public static byte[] decode(String str, int i11) {
        try {
            return Base64.decode(str, i11);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "decode:" + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(byte[] bArr, int i11) {
        try {
            return Base64.decode(bArr, i11);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "decode:" + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(byte[] bArr, int i11, int i12, int i13) {
        try {
            return Base64.decode(bArr, i11, i12, i13);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "decode:" + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i11) {
        try {
            return Base64.encode(bArr, i11);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "encode:" + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i11, int i12, int i13) {
        try {
            return Base64.encode(bArr, i11, i12, i13);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "encode:" + e11.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i11) {
        try {
            return Base64.encodeToString(bArr, i11);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "encodeToString:" + e11.getMessage());
            return "";
        }
    }

    public static String encodeToString(byte[] bArr, int i11, int i12, int i13) {
        try {
            return Base64.encodeToString(bArr, i11, i12, i13);
        } catch (Exception e11) {
            Logger.error("SafeBase64", "encodeToString:" + e11.getMessage());
            return "";
        }
    }
}
