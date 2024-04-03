package org.mockito.internal.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    private static final Pattern CAPS = Pattern.compile("([A-Z\\d][^A-Z\\d]*)");

    private StringUtil() {
    }

    private static String decamelizeClassName(String str) {
        Matcher matcher = CAPS.matcher(str);
        StringBuilder sb2 = new StringBuilder();
        while (matcher.find()) {
            if (sb2.length() == 0) {
                sb2.append(matcher.group());
            } else {
                sb2.append(" ");
                sb2.append(matcher.group().toLowerCase());
            }
        }
        return sb2.toString();
    }

    public static String decamelizeMatcherName(String str) {
        if (str.length() == 0) {
            return "<custom argument matcher>";
        }
        String decamelizeClassName = decamelizeClassName(str);
        if (decamelizeClassName.length() == 0) {
            return "<" + str + ">";
        }
        return "<" + decamelizeClassName + ">";
    }

    public static String join(Object... objArr) {
        return join(StringUtils.LF, Arrays.asList(objArr));
    }

    public static String removeFirstLine(String str) {
        return str.replaceFirst(".*?\n", "");
    }

    public static String join(String str, Collection<?> collection) {
        return join(str, "", collection);
    }

    public static String join(String str, String str2, Collection<?> collection) {
        if (collection.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(str);
        for (Object next : collection) {
            sb2.append(str2);
            sb2.append(next);
            sb2.append(StringUtils.LF);
        }
        return sb2.substring(0, sb2.length() - 1);
    }
}
