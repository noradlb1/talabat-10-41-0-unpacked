package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class Validate {
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";

    public static <T> void exclusiveBetween(T t11, T t12, Comparable<T> comparable) {
        if (comparable.compareTo(t11) <= 0 || comparable.compareTo(t12) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{comparable, t11, t12}));
        }
    }

    public static <T> void inclusiveBetween(T t11, T t12, Comparable<T> comparable) {
        if (comparable.compareTo(t11) < 0 || comparable.compareTo(t12) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{comparable, t11, t12}));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (!cls.isAssignableFrom(cls2)) {
            Object[] objArr = new Object[2];
            objArr[0] = cls2 == null ? "null" : cls2.getName();
            objArr[1] = cls.getName();
            throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (!cls.isInstance(obj)) {
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = obj == null ? "null" : obj.getClass().getName();
            throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, objArr));
        }
    }

    public static void isTrue(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(str, new Object[]{Long.valueOf(j11)}));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, new Object[]{charSequence, str}));
        }
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        notNull(tArr);
        int i11 = 0;
        while (i11 < tArr.length) {
            if (tArr[i11] != null) {
                i11++;
            } else {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.add((T[]) objArr, Integer.valueOf(i11))));
            }
        }
        return tArr;
    }

    public static <T extends CharSequence> T notBlank(T t11, String str, Object... objArr) {
        if (t11 == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!StringUtils.isBlank(t11)) {
            return t11;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (tArr.length != 0) {
            return tArr;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T notNull(T t11) {
        return notNull(t11, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i11, String str, Object... objArr) {
        notNull(tArr);
        if (i11 >= 0 && i11 < tArr.length) {
            return tArr;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static void validState(boolean z11) {
        if (!z11) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void isTrue(boolean z11, String str, double d11) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(str, new Object[]{Double.valueOf(d11)}));
        }
    }

    public static <T> T notNull(T t11, String str, Object... objArr) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void validState(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> void exclusiveBetween(T t11, T t12, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t11) <= 0 || comparable.compareTo(t12) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void inclusiveBetween(T t11, T t12, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t11) < 0 || comparable.compareTo(t12) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static void isTrue(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static <T extends CharSequence> T notBlank(T t11) {
        return notBlank(t11, DEFAULT_NOT_BLANK_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return notEmpty(tArr, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i11) {
        return validIndex(tArr, i11, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, Integer.valueOf(i11));
    }

    public static void exclusiveBetween(long j11, long j12, long j13) {
        if (j13 <= j11 || j13 >= j12) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Long.valueOf(j13), Long.valueOf(j11), Long.valueOf(j12)}));
        }
    }

    public static void inclusiveBetween(long j11, long j12, long j13) {
        if (j13 < j11 || j13 > j12) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Long.valueOf(j13), Long.valueOf(j11), Long.valueOf(j12)}));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t11, String str, Object... objArr) {
        if (t11 == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!t11.isEmpty()) {
            return t11;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T validIndex(T t11, int i11, String str, Object... objArr) {
        notNull(t11);
        if (i11 >= 0 && i11 < t11.size()) {
            return t11;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static void exclusiveBetween(long j11, long j12, long j13, String str) {
        if (j13 <= j11 || j13 >= j12) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void inclusiveBetween(long j11, long j12, long j13, String str) {
        if (j13 < j11 || j13 > j12) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static <T> T[] noNullElements(T[] tArr) {
        return noNullElements(tArr, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static void exclusiveBetween(double d11, double d12, double d13) {
        if (d13 <= d11 || d13 >= d12) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Double.valueOf(d13), Double.valueOf(d11), Double.valueOf(d12)}));
        }
    }

    public static void inclusiveBetween(double d11, double d12, double d13) {
        if (d13 < d11 || d13 > d12) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Double.valueOf(d13), Double.valueOf(d11), Double.valueOf(d12)}));
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t11, String str, Object... objArr) {
        notNull(t11);
        int i11 = 0;
        for (Object obj : t11) {
            if (obj != null) {
                i11++;
            } else {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll((T[]) objArr, (T[]) new Object[]{Integer.valueOf(i11)})));
            }
        }
        return t11;
    }

    public static void exclusiveBetween(double d11, double d12, double d13, String str) {
        if (d13 <= d11 || d13 >= d12) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void inclusiveBetween(double d11, double d12, double d13, String str) {
        if (d13 < d11 || d13 > d12) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t11) {
        return notEmpty(t11, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T validIndex(T t11, int i11) {
        return validIndex(t11, i11, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(i11));
    }

    public static <T extends Map<?, ?>> T notEmpty(T t11, String str, Object... objArr) {
        if (t11 == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!t11.isEmpty()) {
            return t11;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T validIndex(T t11, int i11, String str, Object... objArr) {
        notNull(t11);
        if (i11 >= 0 && i11 < t11.length()) {
            return t11;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T extends Iterable<?>> T noNullElements(T t11) {
        return noNullElements(t11, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Map<?, ?>> T notEmpty(T t11) {
        return notEmpty(t11, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T validIndex(T t11, int i11) {
        return validIndex(t11, i11, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(i11));
    }

    public static <T extends CharSequence> T notEmpty(T t11, String str, Object... objArr) {
        if (t11 == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (t11.length() != 0) {
            return t11;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T notEmpty(T t11) {
        return notEmpty(t11, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]);
    }
}
