package com.huawei.hms.utils;

import com.huawei.hms.framework.common.ExceptionCode;
import java.util.regex.Pattern;

public class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f49976a = Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)");

    private StringUtil() {
    }

    public static String addByteForNum(String str, int i11, char c11) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (length == i11) {
            return str;
        }
        if (length > i11) {
            return str.substring(length - i11);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (length < i11) {
            stringBuffer.append(c11);
            length++;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(String str) {
        return f49976a.matcher(str).find();
    }

    public static int convertVersion2Integer(String str) {
        if (!checkVersion(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return 0;
        }
        int parseInt = (Integer.parseInt(split[0]) * ExceptionCode.CRASH_EXCEPTION) + (Integer.parseInt(split[1]) * 100000) + (Integer.parseInt(split[2]) * 1000);
        if (split.length == 4) {
            return parseInt + Integer.parseInt(split[3]);
        }
        return parseInt;
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }
}
