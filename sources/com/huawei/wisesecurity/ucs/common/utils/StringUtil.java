package com.huawei.wisesecurity.ucs.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.nio.charset.StandardCharsets;

public class StringUtil {
    public static byte[] base64Decode(String str, int i11) throws UcsException {
        if (str == null) {
            return new byte[0];
        }
        try {
            return Base64.decode(str, i11);
        } catch (Exception unused) {
            throw new UcsException(UcsErrorCode.BAD_PARAMETERS, "base64 decode error");
        }
    }

    public static String base64DecodeToString(String str, int i11) throws UcsException {
        if (str == null) {
            return "";
        }
        try {
            return new String(Base64.decode(str, i11), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            throw new UcsException(UcsErrorCode.BAD_PARAMETERS, "base64 decode to string error");
        }
    }

    public static String base64EncodeToString(byte[] bArr, int i11) throws UcsException {
        if (bArr != null) {
            try {
                return Base64.encodeToString(bArr, i11);
            } catch (Exception unused) {
                throw new UcsException(UcsErrorCode.BAD_PARAMETERS, "base64 encodeToString error");
            }
        } else {
            throw new UcsException(UcsErrorCode.BAD_PARAMETERS, "base64 encodeToString error: data is null");
        }
    }

    public static boolean checkStringUpperLimit(String str, int i11) {
        return str == null || str.length() <= i11;
    }

    public static boolean isLetterDigitHyphens(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-z0-9A-Z\\-]+$");
    }
}
