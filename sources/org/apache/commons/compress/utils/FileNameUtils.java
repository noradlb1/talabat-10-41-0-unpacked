package org.apache.commons.compress.utils;

import java.io.File;

public class FileNameUtils {
    public static String getBaseName(String str) {
        if (str == null) {
            return null;
        }
        String name2 = new File(str).getName();
        int lastIndexOf = name2.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return name2;
        }
        return name2.substring(0, lastIndexOf);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        String name2 = new File(str).getName();
        int lastIndexOf = name2.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "";
        }
        return name2.substring(lastIndexOf + 1);
    }
}
