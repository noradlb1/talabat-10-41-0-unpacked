package com.huawei.wisesecurity.kfs.interceptors;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import java.util.Map;

public class ArgumentChecker {
    public static void checkHeaderValue(String str) throws ParamException {
        if (!TextUtils.isEmpty(str)) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i11 = 0;
            while (i11 < length) {
                char c11 = charArray[i11];
                if ((c11 > 31 || c11 == 9) && c11 < 127) {
                    i11++;
                } else {
                    throw new ParamException("Unexpected char in header value");
                }
            }
        }
    }

    public static void checkHeaderValue(Map<String, String> map) throws ParamException {
        for (Map.Entry<String, String> value : map.entrySet()) {
            checkHeaderValue((String) value.getValue());
        }
    }

    public static <T> void checkNonNull(T t11) throws ParamException {
        if (t11 == null) {
            throw new ParamException("Null reference");
        }
    }
}
