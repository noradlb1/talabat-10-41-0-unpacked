package org.junit.platform.commons.util;

import j$.util.stream.IntStream;
import java.util.Arrays;
import java.util.regex.Pattern;
import l30.l2;
import l30.m2;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class StringUtils {
    private static final Pattern ISO_CONTROL_PATTERN = a();
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");

    private StringUtils() {
    }

    public static Pattern a() {
        try {
            return Pattern.compile("\\p{Cntrl}", 256);
        } catch (IllegalArgumentException unused) {
            return Pattern.compile("\\p{Cntrl}");
        }
    }

    public static boolean containsIsoControlCharacter(String str) {
        return str != null && IntStream.VivifiedWrapper.convert(str.codePoints()).anyMatch(new l2());
    }

    public static boolean containsWhitespace(String str) {
        return str != null && IntStream.VivifiedWrapper.convert(str.codePoints()).anyMatch(new m2());
    }

    public static String defaultToString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
    }

    public static boolean doesNotContainIsoControlCharacter(String str) {
        return !containsIsoControlCharacter(str);
    }

    public static boolean doesNotContainWhitespace(String str) {
        return !containsWhitespace(str);
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String nullSafeToString(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            if (obj.getClass().isArray()) {
                if (obj.getClass().getComponentType().isPrimitive()) {
                    if (obj instanceof boolean[]) {
                        return Arrays.toString((boolean[]) obj);
                    }
                    if (obj instanceof char[]) {
                        return Arrays.toString((char[]) obj);
                    }
                    if (obj instanceof short[]) {
                        return Arrays.toString((short[]) obj);
                    }
                    if (obj instanceof byte[]) {
                        return Arrays.toString((byte[]) obj);
                    }
                    if (obj instanceof int[]) {
                        return Arrays.toString((int[]) obj);
                    }
                    if (obj instanceof long[]) {
                        return Arrays.toString((long[]) obj);
                    }
                    if (obj instanceof float[]) {
                        return Arrays.toString((float[]) obj);
                    }
                    if (obj instanceof double[]) {
                        return Arrays.toString((double[]) obj);
                    }
                }
                return Arrays.deepToString((Object[]) obj);
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2;
            }
            return "null";
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            return defaultToString(obj);
        }
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static String replaceIsoControlCharacters(String str, String str2) {
        Preconditions.notNull(str2, "replacement must not be null");
        if (str == null) {
            return null;
        }
        return ISO_CONTROL_PATTERN.matcher(str).replaceAll(str2);
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static String replaceWhitespaceCharacters(String str, String str2) {
        Preconditions.notNull(str2, "replacement must not be null");
        if (str == null) {
            return null;
        }
        return WHITESPACE_PATTERN.matcher(str).replaceAll(str2);
    }
}
