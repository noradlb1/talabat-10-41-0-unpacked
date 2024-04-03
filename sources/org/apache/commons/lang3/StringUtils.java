package org.apache.commons.lang3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import net.bytebuddy.pool.TypePool;

public class StringUtils {
    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    private static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("(?: |\\u00A0|\\s|[\\s&&[^ ]])\\s*");

    public static String abbreviate(String str, int i11) {
        return abbreviate(str, 0, i11);
    }

    public static String abbreviateMiddle(String str, String str2, int i11) {
        if (isEmpty(str) || isEmpty(str2) || i11 >= str.length() || i11 < str2.length() + 2) {
            return str;
        }
        int length = i11 - str2.length();
        int i12 = length / 2;
        int i13 = (length % 2) + i12;
        int length2 = str.length() - i12;
        StringBuilder sb2 = new StringBuilder(i11);
        sb2.append(str.substring(0, i13));
        sb2.append(str2);
        sb2.append(str.substring(length2));
        return sb2.toString();
    }

    private static String appendIfMissing(String str, CharSequence charSequence, boolean z11, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || endsWith(str, charSequence, z11)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(str, endsWith, z11)) {
                    return str;
                }
            }
        }
        return str + charSequence.toString();
    }

    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String capitalize(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (Character.isTitleCase(charAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(Character.toTitleCase(charAt));
        sb2.append(str.substring(1));
        return sb2.toString();
    }

    public static String center(String str, int i11) {
        return center(str, i11, ' ');
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            return (charAt == 13 || charAt == 10) ? "" : str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == 10) {
            if (str.charAt(length - 1) == 13) {
                length--;
            }
        } else if (charAt2 != 13) {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i11 = length - 1;
        String substring = str.substring(0, i11);
        if (str.charAt(i11) == 10) {
            int i12 = i11 - 1;
            if (substring.charAt(i12) == 13) {
                return substring.substring(0, i12);
            }
        }
        return substring;
    }

    private static int commonPrefixLength(CharSequence charSequence, CharSequence charSequence2) {
        int length = getCommonPrefix(charSequence.toString(), charSequence2.toString()).length();
        if (length > 4) {
            return 4;
        }
        return length;
    }

    public static boolean contains(CharSequence charSequence, int i11) {
        if (!isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i11, 0) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i11 = length - 1;
            int i12 = length2 - 1;
            for (int i13 = 0; i13 < length; i13++) {
                char charAt = charSequence.charAt(i13);
                for (int i14 = 0; i14 < length2; i14++) {
                    if (cArr[i14] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i14 == i12) {
                            return true;
                        }
                        if (i13 < i11 && cArr[i14 + 1] == charSequence.charAt(i13 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence == null || charSequence2 == null)) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            for (int i11 = 0; i11 <= length2; i11++) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i11, charSequence2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (!(charSequence == null || cArr == null)) {
            int length = charSequence.length();
            int i11 = length - 1;
            int length2 = cArr.length;
            int i12 = length2 - 1;
            for (int i13 = 0; i13 < length; i13++) {
                char charAt = charSequence.charAt(i13);
                for (int i14 = 0; i14 < length2; i14++) {
                    if (cArr[i14] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i14 == i12) {
                            return false;
                        }
                        if (i13 < i11 && cArr[i14 + 1] == charSequence.charAt(i13 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        if (cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1) {
            return true;
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.isWhitespace(charSequence.charAt(i11))) {
                return true;
            }
        }
        return false;
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i11 = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i12 = 0;
        while (true) {
            int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i11);
            if (indexOf == -1) {
                return i12;
            }
            i12++;
            i11 = indexOf + charSequence2.length();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T t11, T t12) {
        return isBlank(t11) ? t12 : t11;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t11, T t12) {
        return isEmpty(t11) ? t12 : t11;
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (!Character.isWhitespace(str.charAt(i12))) {
                cArr[i11] = str.charAt(i12);
                i11++;
            }
        }
        if (i11 == length) {
            return str;
        }
        return new String(cArr, 0, i11);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(charSequence, endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        return CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == charSequence2) {
                return true;
            }
            return false;
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
        }
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            String str = strArr[0];
            if (str == null) {
                return "";
            }
            return str;
        } else if (indexOfDifference == 0) {
            return "";
        } else {
            return strArr[0].substring(0, indexOfDifference);
        }
    }

    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        double score = score(charSequence, charSequence2);
        return ((double) Math.round((score + ((((double) commonPrefixLength(charSequence, charSequence2)) * 0.1d) * (1.0d - score))) * 100.0d)) / 100.0d;
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            int i11 = length2;
            length2 = charSequence.length();
            length = i11;
        } else {
            CharSequence charSequence3 = charSequence2;
            charSequence2 = charSequence;
            charSequence = charSequence3;
        }
        int i12 = length + 1;
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 <= length; i13++) {
            iArr[i13] = i13;
        }
        int i14 = 1;
        while (i14 <= length2) {
            char charAt = charSequence.charAt(i14 - 1);
            iArr2[0] = i14;
            for (int i15 = 1; i15 <= length; i15++) {
                int i16 = i15 - 1;
                iArr2[i15] = Math.min(Math.min(iArr2[i16] + 1, iArr[i15] + 1), iArr[i16] + (charSequence2.charAt(i16) == charAt ? 0 : 1));
            }
            i14++;
            int[] iArr3 = iArr;
            iArr = iArr2;
            iArr2 = iArr3;
        }
        return iArr[length];
    }

    private static String getSetOfMatchingCharacterWithin(CharSequence charSequence, CharSequence charSequence2, int i11) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder(charSequence2);
        int i12 = 0;
        while (i12 < charSequence.length()) {
            char charAt = charSequence.charAt(i12);
            int max = Math.max(0, i12 - i11);
            boolean z11 = false;
            while (!z11 && max < Math.min(i12 + i11, charSequence2.length())) {
                if (sb3.charAt(max) == charAt) {
                    sb2.append(charAt);
                    sb3.setCharAt(max, TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
                    z11 = true;
                }
                max++;
            }
            i12++;
        }
        return sb2.toString();
    }

    public static int indexOf(CharSequence charSequence, int i11) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i11, 0);
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i11 = length - 1;
            int length2 = cArr.length;
            int i12 = length2 - 1;
            for (int i13 = 0; i13 < length; i13++) {
                char charAt = charSequence.charAt(i13);
                for (int i14 = 0; i14 < length2; i14++) {
                    if (cArr[i14] == charAt && (i13 >= i11 || i14 >= i12 || !Character.isHighSurrogate(charAt) || cArr[i14 + 1] == charSequence.charAt(i13 + 1))) {
                        return i13;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i11 = length - 1;
            int length2 = cArr.length;
            int i12 = length2 - 1;
            int i13 = 0;
            while (i13 < length) {
                char charAt = charSequence.charAt(i13);
                int i14 = 0;
                while (i14 < length2) {
                    if (cArr[i14] != charAt || (i13 < i11 && i14 < i12 && Character.isHighSurrogate(charAt) && cArr[i14 + 1] != charSequence.charAt(i13 + 1))) {
                        i14++;
                    } else {
                        i13++;
                    }
                }
                return i13;
            }
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i11 = 0;
        if (!(charSequence == null || charSequence2 == null)) {
            while (i11 < charSequence.length() && i11 < charSequence2.length() && charSequence.charAt(i11) == charSequence2.charAt(i11)) {
                i11++;
            }
            if (i11 < charSequence2.length() || i11 < charSequence.length()) {
                return i11;
            }
            return -1;
        }
        return i11;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isLowerCase(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isUpperCase(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isLetter(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isLetter(charSequence.charAt(i11)) && charSequence.charAt(i11) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i11)) && charSequence.charAt(i11) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return true;
        }
        for (CharSequence isBlank : charSequenceArr) {
            if (isBlank(isBlank)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return true;
        }
        for (CharSequence isEmpty : charSequenceArr) {
            if (isEmpty(isEmpty)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (!(charSequence == null || (length = charSequence.length()) == 0)) {
            for (int i11 = 0; i11 < length; i11++) {
                if (!Character.isWhitespace(charSequence.charAt(i11))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        return !isAnyBlank(charSequenceArr);
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        return !isAnyEmpty(charSequenceArr);
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isDigit(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isDigit(charSequence.charAt(i11)) && charSequence.charAt(i11) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static <T> String join(T... tArr) {
        return join((Object[]) tArr, (String) null);
    }

    public static int lastIndexOf(CharSequence charSequence, int i11) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i11, charSequence.length());
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int lastIndexOf;
        int i11 = -1;
        if (!(charSequence == null || charSequenceArr == null)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i11) {
                    i11 = lastIndexOf;
                }
            }
        }
        return i11;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        return ordinalIndexOf(charSequence, charSequence2, i11, true);
    }

    public static String left(String str, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 < 0) {
            return "";
        }
        if (str.length() <= i11) {
            return str;
        }
        return str.substring(0, i11);
    }

    public static String leftPad(String str, int i11) {
        return leftPad(str, i11, ' ');
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String mid(String str, int i11, int i12) {
        if (str == null) {
            return null;
        }
        if (i12 < 0 || i11 > str.length()) {
            return "";
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int i13 = i12 + i11;
        if (str.length() <= i13) {
            return str.substring(i11);
        }
        return str.substring(i11, i13);
    }

    public static String normalizeSpace(String str) {
        if (str == null) {
            return null;
        }
        return WHITESPACE_PATTERN.matcher(trim(str)).replaceAll(" ");
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        return ordinalIndexOf(charSequence, charSequence2, i11, false);
    }

    public static String overlay(String str, String str2, int i11, int i12) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 > length) {
            i11 = length;
        }
        if (i12 < 0) {
            i12 = 0;
        }
        if (i12 > length) {
            i12 = length;
        }
        if (i11 > i12) {
            int i13 = i12;
            i12 = i11;
            i11 = i13;
        }
        StringBuilder sb2 = new StringBuilder(((length + i11) - i12) + str2.length() + 1);
        sb2.append(str.substring(0, i11));
        sb2.append(str2);
        sb2.append(str.substring(i12));
        return sb2.toString();
    }

    private static String prependIfMissing(String str, CharSequence charSequence, boolean z11, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || startsWith(str, charSequence, z11)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(str, startsWith, z11)) {
                    return str;
                }
            }
        }
        return charSequence.toString() + str;
    }

    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String removeEnd(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String removePattern(String str, String str2) {
        return replacePattern(str, str2, "");
    }

    public static String removeStart(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) {
            return str;
        }
        return str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) {
            return str;
        }
        return str.substring(str2.length());
    }

    public static String repeat(String str, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 <= 0) {
            return "";
        }
        int length = str.length();
        if (i11 == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i11 <= 8192) {
            return repeat(str.charAt(0), i11);
        }
        int i12 = length * i11;
        if (length == 1) {
            return repeat(str.charAt(0), i11);
        }
        if (length != 2) {
            StringBuilder sb2 = new StringBuilder(i12);
            for (int i13 = 0; i13 < i11; i13++) {
                sb2.append(str);
            }
            return sb2.toString();
        }
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        char[] cArr = new char[i12];
        for (int i14 = (i11 * 2) - 2; i14 >= 0; i14 = (i14 - 1) - 1) {
            cArr[i14] = charAt;
            cArr[i14 + 1] = charAt2;
        }
        return new String(cArr);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replaceChars(String str, char c11, char c12) {
        if (str == null) {
            return null;
        }
        return str.replace(c11, c12);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        int i11;
        if (strArr == null) {
            i11 = 0;
        } else {
            i11 = strArr.length;
        }
        return replaceEach(str, strArr, strArr2, true, i11);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replacePattern(String str, String str2, String str3) {
        return Pattern.compile(str2, 32).matcher(str).replaceAll(str3);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c11) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c11);
        ArrayUtils.reverse((Object[]) split);
        return join((Object[]) split, c11);
    }

    public static String right(String str, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 < 0) {
            return "";
        }
        if (str.length() <= i11) {
            return str;
        }
        return str.substring(str.length() - i11);
    }

    public static String rightPad(String str, int i11) {
        return rightPad(str, i11, ' ');
    }

    private static double score(CharSequence charSequence, CharSequence charSequence2) {
        String str;
        String str2;
        if (charSequence.length() > charSequence2.length()) {
            str2 = charSequence.toString().toLowerCase();
            str = charSequence2.toString().toLowerCase();
        } else {
            String lowerCase = charSequence2.toString().toLowerCase();
            str = charSequence.toString().toLowerCase();
            str2 = lowerCase;
        }
        int length = (str.length() / 2) + 1;
        String setOfMatchingCharacterWithin = getSetOfMatchingCharacterWithin(str, str2, length);
        String setOfMatchingCharacterWithin2 = getSetOfMatchingCharacterWithin(str2, str, length);
        if (setOfMatchingCharacterWithin.length() == 0 || setOfMatchingCharacterWithin2.length() == 0 || setOfMatchingCharacterWithin.length() != setOfMatchingCharacterWithin2.length()) {
            return 0.0d;
        }
        return (((((double) setOfMatchingCharacterWithin.length()) / ((double) str.length())) + (((double) setOfMatchingCharacterWithin2.length()) / ((double) str2.length()))) + (((double) (setOfMatchingCharacterWithin.length() - transpositions(setOfMatchingCharacterWithin, setOfMatchingCharacterWithin2))) / ((double) setOfMatchingCharacterWithin.length()))) / 3.0d;
    }

    public static String[] split(String str) {
        return split(str, (String) null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i11, boolean z11) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, (String) null, i11, z11);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < length) {
            i12 = str.indexOf(str2, i13);
            if (i12 > -1) {
                if (i12 > i13) {
                    i14++;
                    if (i14 == i11) {
                        arrayList.add(str.substring(i13));
                    } else {
                        arrayList.add(str.substring(i13, i12));
                    }
                } else if (z11) {
                    i14++;
                    if (i14 == i11) {
                        arrayList.add(str.substring(i13));
                        i12 = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i13 = i12 + length2;
            } else {
                arrayList.add(str.substring(i13));
            }
            i12 = length;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, (String) null, -1, true);
    }

    private static String[] splitWorker(String str, char c11, boolean z11) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        boolean z12 = false;
        boolean z13 = false;
        int i12 = 0;
        while (i11 < length) {
            if (str.charAt(i11) == c11) {
                if (z12 || z11) {
                    arrayList.add(str.substring(i12, i11));
                    z12 = false;
                    z13 = true;
                }
                i12 = i11 + 1;
                i11 = i12;
            } else {
                i11++;
                z13 = false;
                z12 = true;
            }
        }
        if (z12 || (z11 && z13)) {
            arrayList.add(str.substring(i12, i11));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(charSequence, startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    public static String strip(String str) {
        return strip(str, (String) null);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("");
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, (String) null);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i11 = 0;
        if (str2 == null) {
            while (i11 != length && Character.isWhitespace(str.charAt(i11))) {
                i11++;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (i11 != length && str2.indexOf(str.charAt(i11)) != -1) {
                i11++;
            }
        }
        return str.substring(i11);
    }

    public static String stripToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return strip(str, (String) null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, (String) null);
        if (strip.isEmpty()) {
            return null;
        }
        return strip;
    }

    public static String substring(String str, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 < 0) {
            i11 += str.length();
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 > str.length()) {
            return "";
        }
        return str.substring(i11);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String substringBeforeLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = r5 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] substringsBetween(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0058
            boolean r1 = isEmpty(r8)
            if (r1 != 0) goto L_0x0058
            boolean r1 = isEmpty(r9)
            if (r1 == 0) goto L_0x0010
            goto L_0x0058
        L_0x0010:
            int r1 = r7.length()
            if (r1 != 0) goto L_0x0019
            java.lang.String[] r7 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            return r7
        L_0x0019:
            int r2 = r9.length()
            int r3 = r8.length()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x0027:
            int r6 = r1 - r2
            if (r5 >= r6) goto L_0x0044
            int r5 = r7.indexOf(r8, r5)
            if (r5 >= 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            int r5 = r5 + r3
            int r6 = r7.indexOf(r9, r5)
            if (r6 >= 0) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            java.lang.String r5 = r7.substring(r5, r6)
            r4.add(r5)
            int r5 = r6 + r2
            goto L_0x0027
        L_0x0044:
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x004b
            return r0
        L_0x004b:
            int r7 = r4.size()
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.Object[] r7 = r4.toArray(r7)
            java.lang.String[] r7 = (java.lang.String[]) r7
            return r7
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.substringsBetween(java.lang.String, java.lang.String, java.lang.String):java.lang.String[]");
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            char c11 = charArray[i11];
            if (Character.isUpperCase(c11)) {
                charArray[i11] = Character.toLowerCase(c11);
            } else if (Character.isTitleCase(c11)) {
                charArray[i11] = Character.toLowerCase(c11);
            } else if (Character.isLowerCase(c11)) {
                charArray[i11] = Character.toUpperCase(c11);
            }
        }
        return new String(charArray);
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        return new String(bArr, charset);
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        String str2;
        if (str == null) {
            str2 = new String(bArr, Charset.defaultCharset());
        }
        return str2;
    }

    private static int transpositions(CharSequence charSequence, CharSequence charSequence2) {
        int i11 = 0;
        for (int i12 = 0; i12 < charSequence.length(); i12++) {
            if (charSequence.charAt(i12) != charSequence2.charAt(i12)) {
                i11++;
            }
        }
        return i11 / 2;
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String uncapitalize(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(Character.toLowerCase(charAt));
        sb2.append(str.substring(1));
        return sb2.toString();
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String abbreviate(String str, int i11, int i12) {
        if (str == null) {
            return null;
        }
        if (i12 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if (str.length() <= i12) {
            return str;
        } else {
            if (i11 > str.length()) {
                i11 = str.length();
            }
            int i13 = i12 - 3;
            if (str.length() - i11 < i13) {
                i11 = str.length() - i13;
            }
            if (i11 <= 4) {
                return str.substring(0, i13) + "...";
            } else if (i12 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else if ((i12 + i11) - 3 < str.length()) {
                return "..." + abbreviate(str.substring(i11), i13);
            } else {
                return "..." + str.substring(str.length() - i13);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String center(java.lang.String r2, int r3, char r4) {
        /*
            if (r2 == 0) goto L_0x0019
            if (r3 > 0) goto L_0x0005
            goto L_0x0019
        L_0x0005:
            int r0 = r2.length()
            int r1 = r3 - r0
            if (r1 > 0) goto L_0x000e
            return r2
        L_0x000e:
            int r1 = r1 / 2
            int r0 = r0 + r1
            java.lang.String r2 = leftPad((java.lang.String) r2, (int) r0, (char) r4)
            java.lang.String r2 = rightPad((java.lang.String) r2, (int) r3, (char) r4)
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.center(java.lang.String, int, char):java.lang.String");
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z11) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z11, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
        }
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i11) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i11 < 0) {
                i11 = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i11 > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i11;
            }
            while (i11 < length) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i11, charSequence2, 0, charSequence2.length())) {
                    return i11;
                }
                i11++;
            }
        }
        return -1;
    }

    public static String join(Object[] objArr, char c11) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c11, 0, objArr.length);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i11) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i11 > charSequence.length() - charSequence2.length()) {
                i11 = charSequence.length() - charSequence2.length();
            }
            if (i11 < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i11;
            }
            while (i11 >= 0) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i11, charSequence2, 0, charSequence2.length())) {
                    return i11;
                }
                i11--;
            }
        }
        return -1;
    }

    public static String leftPad(String str, int i11, char c11) {
        if (str == null) {
            return null;
        }
        int length = i11 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i11, String.valueOf(c11));
        }
        return repeat(c11, length).concat(str);
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i11, boolean z11) {
        int i12 = -1;
        if (charSequence == null || charSequence2 == null || i11 <= 0) {
            return i12;
        }
        int i13 = 0;
        if (charSequence2.length() != 0) {
            if (z11) {
                i12 = charSequence.length();
            }
            do {
                if (z11) {
                    i12 = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i12 - 1);
                } else {
                    i12 = CharSequenceUtils.indexOf(charSequence, charSequence2, i12 + 1);
                }
                if (i12 < 0) {
                    return i12;
                }
                i13++;
            } while (i13 < i11);
            return i12;
        } else if (z11) {
            return charSequence.length();
        } else {
            return 0;
        }
    }

    public static String replace(String str, String str2, String str3, int i11) {
        int i12;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i11 == 0) {
            return str;
        }
        int i13 = 0;
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        if (i11 < 0) {
            i12 = 16;
        } else {
            i12 = 64;
            if (i11 <= 64) {
                i12 = i11;
            }
        }
        StringBuilder sb2 = new StringBuilder(str.length() + (length2 * i12));
        while (indexOf != -1) {
            sb2.append(str.substring(i13, indexOf));
            sb2.append(str3);
            i13 = indexOf + length;
            i11--;
            if (i11 == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i13);
        }
        sb2.append(str.substring(i13));
        return sb2.toString();
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb2 = new StringBuilder(length2);
        boolean z11 = false;
        for (int i11 = 0; i11 < length2; i11++) {
            char charAt = str.charAt(i11);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    sb2.append(str3.charAt(indexOf));
                }
                z11 = true;
            } else {
                sb2.append(charAt);
            }
        }
        return z11 ? sb2.toString() : str;
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z11, int i11) {
        String str2;
        String str3;
        int length;
        String str4;
        if (str == null || str.isEmpty() || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i11 >= 0) {
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 == length3) {
                boolean[] zArr = new boolean[length2];
                int i12 = -1;
                int i13 = -1;
                for (int i14 = 0; i14 < length2; i14++) {
                    if (!zArr[i14] && (str4 = strArr[i14]) != null && !str4.isEmpty() && strArr2[i14] != null) {
                        int indexOf = str.indexOf(strArr[i14]);
                        if (indexOf == -1) {
                            zArr[i14] = true;
                        } else if (i12 == -1 || indexOf < i12) {
                            i13 = i14;
                            i12 = indexOf;
                        }
                    }
                }
                if (i12 == -1) {
                    return str;
                }
                int i15 = 0;
                for (int i16 = 0; i16 < strArr.length; i16++) {
                    if (!(strArr[i16] == null || (str3 = strArr2[i16]) == null || (length = str3.length() - strArr[i16].length()) <= 0)) {
                        i15 += length * 3;
                    }
                }
                StringBuilder sb2 = new StringBuilder(str.length() + Math.min(i15, str.length() / 5));
                int i17 = 0;
                while (i12 != -1) {
                    while (i17 < i12) {
                        sb2.append(str.charAt(i17));
                        i17++;
                    }
                    sb2.append(strArr2[i13]);
                    i17 = strArr[i13].length() + i12;
                    i12 = -1;
                    i13 = -1;
                    for (int i18 = 0; i18 < length2; i18++) {
                        if (!zArr[i18] && (str2 = strArr[i18]) != null && !str2.isEmpty() && strArr2[i18] != null) {
                            int indexOf2 = str.indexOf(strArr[i18], i17);
                            if (indexOf2 == -1) {
                                zArr[i18] = true;
                            } else if (i12 == -1 || indexOf2 < i12) {
                                i13 = i18;
                                i12 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i17 < length4) {
                    sb2.append(str.charAt(i17));
                    i17++;
                }
                String sb3 = sb2.toString();
                if (!z11) {
                    return sb3;
                }
                return replaceEach(sb3, strArr, strArr2, z11, i11 - 1);
            }
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
    }

    public static String rightPad(String str, int i11, char c11) {
        if (str == null) {
            return null;
        }
        int length = i11 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i11, String.valueOf(c11));
        }
        return str.concat(repeat(c11, length));
    }

    public static String[] split(String str, char c11) {
        return splitWorker(str, c11, false);
    }

    private static String[] splitByCharacterType(String str, boolean z11) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int type = Character.getType(charArray[0]);
        for (int i12 = 1; i12 < charArray.length; i12++) {
            int type2 = Character.getType(charArray[i12]);
            if (type2 != type) {
                if (z11 && type2 == 2 && type == 1) {
                    int i13 = i12 - 1;
                    if (i13 != i11) {
                        arrayList.add(new String(charArray, i11, i13 - i11));
                        i11 = i13;
                    }
                } else {
                    arrayList.add(new String(charArray, i11, i12 - i11));
                    i11 = i12;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i11, charArray.length - i11));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i11) {
        return splitByWholeSeparatorWorker(str, str2, i11, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i11) {
        return splitByWholeSeparatorWorker(str, str2, i11, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c11) {
        return splitWorker(str, c11, true);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z11) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z11, 0, charSequence2, 0, charSequence2.length());
        }
    }

    public static String strip(String str, String str2) {
        if (isEmpty(str)) {
            return str;
        }
        return stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            strArr2[i11] = strip(strArr[i11], str);
        }
        return strArr2;
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static int indexOf(CharSequence charSequence, int i11, int i12) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i11, i12);
    }

    public static String join(long[] jArr, char c11) {
        if (jArr == null) {
            return null;
        }
        return join(jArr, c11, 0, jArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, int i11, int i12) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i11, i12);
    }

    public static String remove(String str, char c11) {
        if (isEmpty(str) || str.indexOf(c11) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i11 = 0;
        for (char c12 : charArray) {
            if (c12 != c11) {
                charArray[i11] = c12;
                i11++;
            }
        }
        return new String(charArray, 0, i11);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (charSequenceArr != null && charSequenceArr.length > 1) {
            int length = charSequenceArr.length;
            int i11 = Integer.MAX_VALUE;
            boolean z11 = true;
            int i12 = 0;
            boolean z12 = false;
            for (int i13 = 0; i13 < length; i13++) {
                CharSequence charSequence = charSequenceArr[i13];
                if (charSequence == null) {
                    z12 = true;
                    i11 = 0;
                } else {
                    i11 = Math.min(charSequence.length(), i11);
                    i12 = Math.max(charSequenceArr[i13].length(), i12);
                    z11 = false;
                }
            }
            if (!z11 && (i12 != 0 || z12)) {
                if (i11 == 0) {
                    return 0;
                }
                int i14 = -1;
                for (int i15 = 0; i15 < i11; i15++) {
                    char charAt = charSequenceArr[0].charAt(i15);
                    int i16 = 1;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        } else if (charSequenceArr[i16].charAt(i15) != charAt) {
                            i14 = i15;
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (i14 != -1) {
                        break;
                    }
                }
                return (i14 != -1 || i11 == i12) ? i14 : i11;
            }
        }
        return -1;
    }

    public static String join(int[] iArr, char c11) {
        if (iArr == null) {
            return null;
        }
        return join(iArr, c11, 0, iArr.length);
    }

    public static String[] split(String str, String str2, int i11) {
        return splitWorker(str, str2, i11, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i11) {
        return splitWorker(str, str2, i11, true);
    }

    public static String substring(String str, int i11, int i12) {
        if (str == null) {
            return null;
        }
        if (i12 < 0) {
            i12 += str.length();
        }
        if (i11 < 0) {
            i11 += str.length();
        }
        if (i12 > str.length()) {
            i12 = str.length();
        }
        if (i11 > i12) {
            return "";
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 < 0) {
            i12 = 0;
        }
        return str.substring(i11, i12);
    }

    public static String center(String str, int i11, String str2) {
        if (str == null || i11 <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i12 = i11 - length;
        if (i12 <= 0) {
            return str;
        }
        return rightPad(leftPad(str, length + (i12 / 2), str2), i11, str2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static String join(short[] sArr, char c11) {
        if (sArr == null) {
            return null;
        }
        return join(sArr, c11, 0, sArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static String leftPad(String str, int i11, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i11 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i11, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i12 = 0; i12 < length2; i12++) {
            cArr[i12] = charArray[i12 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String rightPad(String str, int i11, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i11 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i11, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i12 = 0; i12 < length2; i12++) {
            cArr[i12] = charArray[i12 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i11);
    }

    public static String join(byte[] bArr, char c11) {
        if (bArr == null) {
            return null;
        }
        return join(bArr, c11, 0, bArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i11);
    }

    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static String join(char[] cArr, char c11) {
        if (cArr == null) {
            return null;
        }
        return join(cArr, c11, 0, cArr.length);
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return removeEnd(str, str2);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                char charAt = charSequence.charAt(i11);
                boolean z11 = CharSequenceUtils.indexOf(charSequence2, (int) charAt, 0) >= 0;
                int i12 = i11 + 1;
                if (i12 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i12);
                    if (z11 && CharSequenceUtils.indexOf(charSequence2, (int) charAt2, 0) < 0) {
                        return i11;
                    }
                } else if (!z11) {
                    return i11;
                }
                i11 = i12;
            }
        }
        return -1;
    }

    public static String join(float[] fArr, char c11) {
        if (fArr == null) {
            return null;
        }
        return join(fArr, c11, 0, fArr.length);
    }

    private static String[] splitWorker(String str, String str2, int i11, boolean z11) {
        int i12;
        int i13;
        boolean z12;
        boolean z13;
        int i14;
        boolean z14;
        boolean z15;
        int i15;
        boolean z16;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i12 = 0;
            z13 = false;
            z12 = false;
            i13 = 0;
            int i16 = 1;
            while (i12 < length) {
                if (Character.isWhitespace(str.charAt(i12))) {
                    if (z13 || z11) {
                        int i17 = i16 + 1;
                        if (i16 == i11) {
                            i12 = length;
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        arrayList.add(str.substring(i13, i12));
                        i16 = i17;
                        z13 = false;
                    }
                    i13 = i12 + 1;
                    i12 = i13;
                } else {
                    i12++;
                    z12 = false;
                    z13 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i15 = 0;
                z15 = false;
                z14 = false;
                i14 = 0;
                int i18 = 1;
                while (i15 < length) {
                    if (str.charAt(i15) == charAt) {
                        if (z15 || z11) {
                            int i19 = i18 + 1;
                            if (i18 == i11) {
                                i15 = length;
                                z14 = false;
                            } else {
                                z14 = true;
                            }
                            arrayList.add(str.substring(i14, i15));
                            i18 = i19;
                            z15 = false;
                        }
                        i14 = i15 + 1;
                        i15 = i14;
                    } else {
                        i15++;
                        z14 = false;
                        z15 = true;
                    }
                }
            } else {
                int i21 = 0;
                z15 = false;
                z14 = false;
                i14 = 0;
                int i22 = 1;
                while (i15 < length) {
                    if (str2.indexOf(str.charAt(i15)) >= 0) {
                        if (z15 || z11) {
                            int i23 = i22 + 1;
                            if (i22 == i11) {
                                i15 = length;
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            arrayList.add(str.substring(i14, i15));
                            i22 = i23;
                            z15 = false;
                        }
                        i14 = i15 + 1;
                        i21 = i14;
                    } else {
                        i21 = i15 + 1;
                        z14 = false;
                        z15 = true;
                    }
                }
            }
            i12 = i15;
            z13 = z15;
            z12 = z14;
            i13 = i14;
        }
        if (z13 || (z11 && z12)) {
            arrayList.add(str.substring(i13, i12));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String join(double[] dArr, char c11) {
        if (dArr == null) {
            return null;
        }
        return join(dArr, c11, 0, dArr.length);
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int indexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i11 = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (!(charSequence2 == null || (indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) == -1 || indexOf >= i11)) {
                i11 = indexOf;
            }
        }
        if (i11 == Integer.MAX_VALUE) {
            return -1;
        }
        return i11;
    }

    public static String join(Object[] objArr, char c11, int i11, int i12) {
        if (objArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            Object obj = objArr[i14];
            if (obj != null) {
                sb2.append(obj);
            }
        }
        return sb2.toString();
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i11) {
        int i12;
        int i13;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i14;
        int i15 = i11;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (i15 >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                if (length2 <= i15) {
                    return length2;
                }
                return -1;
            } else if (length2 != 0) {
                if (length > length2) {
                    i12 = charSequence.length();
                    i13 = length2;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i13 = length;
                    i12 = length2;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                int i16 = i13 + 1;
                int[] iArr = new int[i16];
                int[] iArr2 = new int[i16];
                int min = Math.min(i13, i15) + 1;
                char c11 = 0;
                for (int i17 = 0; i17 < min; i17++) {
                    iArr[i17] = i17;
                }
                int i18 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min, i16, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i19 = 1;
                while (i19 <= i12) {
                    char charAt = charSequence4.charAt(i19 - 1);
                    iArr2[c11] = i19;
                    int max = Math.max(1, i19 - i15);
                    if (i19 > i18 - i15) {
                        i14 = i13;
                    } else {
                        i14 = Math.min(i13, i19 + i15);
                    }
                    if (max > i14) {
                        return -1;
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i18;
                    }
                    while (max <= i14) {
                        int i21 = max - 1;
                        if (charSequence3.charAt(i21) == charAt) {
                            iArr2[max] = iArr[i21];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i21], iArr[max]), iArr[i21]) + 1;
                        }
                        max++;
                    }
                    i19++;
                    c11 = 0;
                    i18 = Integer.MAX_VALUE;
                    int[] iArr3 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr3;
                }
                int i22 = iArr[i13];
                if (i22 <= i15) {
                    return i22;
                }
                return -1;
            } else if (length <= i15) {
                return length;
            } else {
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
    }

    public static String repeat(String str, String str2, int i11) {
        if (str == null || str2 == null) {
            return repeat(str, i11);
        }
        return removeEnd(repeat(str + str2, i11), str2);
    }

    public static String join(long[] jArr, char c11, int i11, int i12) {
        if (jArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(jArr[i14]);
        }
        return sb2.toString();
    }

    public static String repeat(char c11, int i11) {
        char[] cArr = new char[i11];
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            cArr[i12] = c11;
        }
        return new String(cArr);
    }

    public static String join(int[] iArr, char c11, int i11, int i12) {
        if (iArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(iArr[i14]);
        }
        return sb2.toString();
    }

    public static String join(byte[] bArr, char c11, int i11, int i12) {
        if (bArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(bArr[i14]);
        }
        return sb2.toString();
    }

    public static String join(short[] sArr, char c11, int i11, int i12) {
        if (sArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(sArr[i14]);
        }
        return sb2.toString();
    }

    public static String join(char[] cArr, char c11, int i11, int i12) {
        if (cArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(cArr[i14]);
        }
        return sb2.toString();
    }

    public static String join(double[] dArr, char c11, int i11, int i12) {
        if (dArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(dArr[i14]);
        }
        return sb2.toString();
    }

    public static String join(float[] fArr, char c11, int i11, int i12) {
        if (fArr == null) {
            return null;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(c11);
            }
            sb2.append(fArr[i14]);
        }
        return sb2.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i11, int i12) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i13 * 16);
        for (int i14 = i11; i14 < i12; i14++) {
            if (i14 > i11) {
                sb2.append(str);
            }
            Object obj = objArr[i14];
            if (obj != null) {
                sb2.append(obj);
            }
        }
        return sb2.toString();
    }

    public static String join(Iterator<?> it, char c11) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb2 = new StringBuilder(256);
        if (next != null) {
            sb2.append(next);
        }
        while (it.hasNext()) {
            sb2.append(c11);
            Object next2 = it.next();
            if (next2 != null) {
                sb2.append(next2);
            }
        }
        return sb2.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb2 = new StringBuilder(256);
        if (next != null) {
            sb2.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb2.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb2.append(next2);
            }
        }
        return sb2.toString();
    }

    public static String join(Iterable<?> iterable, char c11) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c11);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }
}
