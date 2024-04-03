package org.apache.commons.lang3;

public class CharUtils {
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    public static final char CR = '\r';
    public static final char LF = '\n';

    static {
        char c11 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c11 < strArr.length) {
                strArr[c11] = String.valueOf(c11);
                c11 = (char) (c11 + 1);
            } else {
                return;
            }
        }
    }

    public static boolean isAscii(char c11) {
        return c11 < 128;
    }

    public static boolean isAsciiAlpha(char c11) {
        return isAsciiAlphaUpper(c11) || isAsciiAlphaLower(c11);
    }

    public static boolean isAsciiAlphaLower(char c11) {
        return c11 >= 'a' && c11 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c11) {
        return c11 >= 'A' && c11 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c11) {
        return isAsciiAlpha(c11) || isAsciiNumeric(c11);
    }

    public static boolean isAsciiControl(char c11) {
        return c11 < ' ' || c11 == 127;
    }

    public static boolean isAsciiNumeric(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    public static boolean isAsciiPrintable(char c11) {
        return c11 >= ' ' && c11 < 127;
    }

    public static char toChar(Character ch2) {
        if (ch2 != null) {
            return ch2.charValue();
        }
        throw new IllegalArgumentException("The Character must not be null");
    }

    @Deprecated
    public static Character toCharacterObject(char c11) {
        return Character.valueOf(c11);
    }

    public static int toIntValue(char c11) {
        if (isAsciiNumeric(c11)) {
            return c11 - '0';
        }
        throw new IllegalArgumentException("The character " + c11 + " is not in the range '0' - '9'");
    }

    public static String toString(char c11) {
        if (c11 < 128) {
            return CHAR_STRING_ARRAY[c11];
        }
        return new String(new char[]{c11});
    }

    public static String unicodeEscaped(char c11) {
        if (c11 < 16) {
            return "\\u000" + Integer.toHexString(c11);
        } else if (c11 < 256) {
            return "\\u00" + Integer.toHexString(c11);
        } else if (c11 < 4096) {
            return "\\u0" + Integer.toHexString(c11);
        } else {
            return "\\u" + Integer.toHexString(c11);
        }
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static char toChar(Character ch2, char c11) {
        return ch2 == null ? c11 : ch2.charValue();
    }

    public static int toIntValue(char c11, int i11) {
        return !isAsciiNumeric(c11) ? i11 : c11 - '0';
    }

    public static String toString(Character ch2) {
        if (ch2 == null) {
            return null;
        }
        return toString(ch2.charValue());
    }

    public static char toChar(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("The String must not be empty");
    }

    public static int toIntValue(Character ch2) {
        if (ch2 != null) {
            return toIntValue(ch2.charValue());
        }
        throw new IllegalArgumentException("The character must not be null");
    }

    public static String unicodeEscaped(Character ch2) {
        if (ch2 == null) {
            return null;
        }
        return unicodeEscaped(ch2.charValue());
    }

    public static int toIntValue(Character ch2, int i11) {
        return ch2 == null ? i11 : toIntValue(ch2.charValue(), i11);
    }

    public static char toChar(String str, char c11) {
        if (StringUtils.isEmpty(str)) {
            return c11;
        }
        return str.charAt(0);
    }
}
