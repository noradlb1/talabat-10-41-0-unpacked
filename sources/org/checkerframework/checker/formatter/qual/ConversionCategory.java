package org.checkerframework.checker.formatter.qual;

import j$.util.StringJoiner;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.dataflow.qual.Pure;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public enum ConversionCategory {
    GENERAL("bBhHsS", (int) null),
    CHAR("cC", Character.class, r7, r9, r11),
    INT("doxX", r7, r9, r11, r14, BigInteger.class),
    FLOAT("eEfgGaA", Float.class, Double.class, BigDecimal.class),
    TIME("tT", r14, Calendar.class, Date.class),
    CHAR_AND_INT((String) null, r7, r9, r11),
    INT_AND_TIME((String) null, r14),
    NULL((String) null, new Class[0]),
    UNUSED((String) null, (int) null);
    
    private static final ConversionCategory[] conversionCategoriesForIntersect = null;
    private static final ConversionCategory[] conversionCategoriesForUnion = null;
    private static final ConversionCategory[] conversionCategoriesWithChar = null;
    public final String chars;
    public final Class<?>[] types;

    /* access modifiers changed from: public */
    static {
        ConversionCategory conversionCategory;
        ConversionCategory conversionCategory2;
        ConversionCategory conversionCategory3;
        ConversionCategory conversionCategory4;
        ConversionCategory conversionCategory5;
        ConversionCategory conversionCategory6;
        ConversionCategory conversionCategory7;
        ConversionCategory conversionCategory8;
        conversionCategoriesWithChar = new ConversionCategory[]{conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5};
        conversionCategoriesForIntersect = new ConversionCategory[]{conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5, conversionCategory6, conversionCategory7, conversionCategory8};
        conversionCategoriesForUnion = new ConversionCategory[]{conversionCategory8, conversionCategory6, conversionCategory7, conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5};
    }

    private ConversionCategory(String str, Class<?>... clsArr) {
        this.chars = str;
        if (clsArr == null) {
            this.types = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            arrayList.add(cls);
            Class<? extends Object> unwrapPrimitive = unwrapPrimitive(cls);
            if (unwrapPrimitive != null) {
                arrayList.add(unwrapPrimitive);
            }
        }
        this.types = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static ConversionCategory fromConversionChar(char c11) {
        for (ConversionCategory conversionCategory : conversionCategoriesWithChar) {
            if (conversionCategory.chars.contains(String.valueOf(c11))) {
                return conversionCategory;
            }
        }
        throw new IllegalArgumentException("Bad conversion character " + c11);
    }

    public static ConversionCategory intersect(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.retainAll(arrayToSet(conversionCategory2.types));
        for (ConversionCategory conversionCategory5 : conversionCategoriesForIntersect) {
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        return intersect(conversionCategory, conversionCategory2) == conversionCategory;
    }

    public static ConversionCategory union(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3 || conversionCategory2 == conversionCategory3 || conversionCategory == (conversionCategory3 = GENERAL) || conversionCategory2 == conversionCategory3) {
            return conversionCategory3;
        }
        ConversionCategory conversionCategory4 = CHAR_AND_INT;
        if ((conversionCategory == conversionCategory4 && conversionCategory2 == INT_AND_TIME) || (conversionCategory == INT_AND_TIME && conversionCategory2 == conversionCategory4)) {
            return INT;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.addAll(arrayToSet(conversionCategory2.types));
        for (ConversionCategory conversionCategory5 : conversionCategoriesForUnion) {
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        return GENERAL;
    }

    private static Class<? extends Object> unwrapPrimitive(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return null;
    }

    public boolean isAssignableFrom(Class<?> cls) {
        Class<?>[] clsArr = this.types;
        if (clsArr == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Pure
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name());
        sb2.append(" conversion category");
        Class<?>[] clsArr = this.types;
        if (clsArr == null || clsArr.length == 0) {
            return sb2.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "(one of: ", ")");
        for (Class<?> simpleName : this.types) {
            stringJoiner.add(simpleName.getSimpleName());
        }
        sb2.append(" ");
        sb2.append(stringJoiner);
        return sb2.toString();
    }
}
