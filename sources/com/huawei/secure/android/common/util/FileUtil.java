package com.huawei.secure.android.common.util;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;

public class FileUtil {
    private static String a(String str) {
        int lastIndexOf;
        int i11;
        if (str.isEmpty() || (lastIndexOf = str.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) == -1 || (i11 = lastIndexOf + 1) == str.length()) {
            return "";
        }
        return str.substring(i11).toLowerCase(Locale.ENGLISH);
    }

    public static boolean checkFileExtValid(String str, String[] strArr) {
        if (!(str == null || str.isEmpty() || strArr == null)) {
            String a11 = a(str);
            for (String equalsIgnoreCase : strArr) {
                if (a11.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean filePathIsValid(String str, String str2) throws IllegalArgumentException, IOException {
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            try {
                String decode = URLDecoder.decode(str2, "utf-8");
                String decode2 = URLDecoder.decode(str, "utf-8");
                if (!decode2.contains("..") && !decode2.contains("./") && !decode2.contains(".\\.\\") && !decode2.contains("%00") && !decode.contains("..") && !decode.contains("./") && !decode.contains(".\\.\\") && !decode.contains("%00")) {
                    return new File(decode2, decode).getCanonicalPath().startsWith(new File(decode2).getCanonicalPath());
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public static boolean filePathIsValid(String str) throws UnsupportedEncodingException {
        if (str == null || str.equals("")) {
            return true;
        }
        if (str.contains("%")) {
            str = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        }
        String decode = URLDecoder.decode(str, "utf-8");
        if (decode.contains("..") || decode.contains("./") || decode.contains(".\\.\\") || decode.contains("%00")) {
            return false;
        }
        return true;
    }
}
