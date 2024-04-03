package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, (char[]) null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, (char[]) null);
    }

    public static String initials(String str) {
        return initials(str, (char[]) null);
    }

    private static boolean isDelimiter(char c11, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c11);
        }
        for (char c12 : cArr) {
            if (c11 == c12) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z11 = true;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            char c11 = charArray[i11];
            if (Character.isUpperCase(c11)) {
                charArray[i11] = Character.toLowerCase(c11);
            } else if (Character.isTitleCase(c11)) {
                charArray[i11] = Character.toLowerCase(c11);
            } else {
                if (!Character.isLowerCase(c11)) {
                    z11 = Character.isWhitespace(c11);
                } else if (z11) {
                    charArray[i11] = Character.toTitleCase(c11);
                } else {
                    charArray[i11] = Character.toUpperCase(c11);
                }
            }
            z11 = false;
        }
        return new String(charArray);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, (char[]) null);
    }

    public static String wrap(String str, int i11) {
        return wrap(str, i11, (String) null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z11 = true;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            char c11 = charArray[i11];
            if (isDelimiter(c11, cArr)) {
                z11 = true;
            } else if (z11) {
                charArray[i11] = Character.toTitleCase(c11);
                z11 = false;
            }
        }
        return new String(charArray);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[((length / 2) + 1)];
        boolean z11 = true;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (isDelimiter(charAt, cArr)) {
                z11 = true;
            } else if (z11) {
                cArr2[i11] = charAt;
                i11++;
                z11 = false;
            }
        }
        return new String(cArr2, 0, i11);
    }

    public static String uncapitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z11 = true;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            char c11 = charArray[i11];
            if (isDelimiter(c11, cArr)) {
                z11 = true;
            } else if (z11) {
                charArray[i11] = Character.toLowerCase(c11);
                z11 = false;
            }
        }
        return new String(charArray);
    }

    public static String wrap(String str, int i11, String str2, boolean z11) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = SystemUtils.LINE_SEPARATOR;
        }
        if (i11 < 1) {
            i11 = 1;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length + 32);
        int i12 = 0;
        while (length - i12 > i11) {
            if (str.charAt(i12) == ' ') {
                i12++;
            } else {
                int i13 = i11 + i12;
                int lastIndexOf = str.lastIndexOf(32, i13);
                if (lastIndexOf >= i12) {
                    sb2.append(str.substring(i12, lastIndexOf));
                    sb2.append(str2);
                    i12 = lastIndexOf + 1;
                } else {
                    if (z11) {
                        sb2.append(str.substring(i12, i13));
                        sb2.append(str2);
                    } else {
                        int indexOf = str.indexOf(32, i13);
                        if (indexOf >= 0) {
                            sb2.append(str.substring(i12, indexOf));
                            sb2.append(str2);
                            i13 = indexOf + 1;
                        } else {
                            sb2.append(str.substring(i12));
                            i12 = length;
                        }
                    }
                    i12 = i13;
                }
            }
        }
        sb2.append(str.substring(i12));
        return sb2.toString();
    }
}
