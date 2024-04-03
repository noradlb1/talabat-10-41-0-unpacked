package org.checkerframework.checker.i18nformatter.qual;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import j$.util.StringJoiner;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public enum I18nConversionCategory {
    UNUSED((String) null, (int) null),
    GENERAL((String) null, (int) null),
    DATE(new Class[]{Date.class, r5}, new String[]{"date", "time"}),
    NUMBER(new Class[]{r5}, new String[]{CardTokenizationPlugin.ARG_NUMBER_KEY, "choice"});
    
    private static final I18nConversionCategory[] conversionCategoriesForIntersect = null;
    private static final I18nConversionCategory[] namedCategories = null;
    public final String[] strings;
    public final Class<?>[] types;

    /* access modifiers changed from: public */
    static {
        I18nConversionCategory i18nConversionCategory;
        I18nConversionCategory i18nConversionCategory2;
        namedCategories = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
        conversionCategoriesForIntersect = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
    }

    private I18nConversionCategory(Class<?>[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static I18nConversionCategory intersect(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory;
        }
        I18nConversionCategory i18nConversionCategory4 = GENERAL;
        if (i18nConversionCategory == i18nConversionCategory4) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory4) {
            return i18nConversionCategory;
        }
        Set arrayToSet = arrayToSet(i18nConversionCategory.types);
        arrayToSet.retainAll(arrayToSet(i18nConversionCategory2.types));
        for (I18nConversionCategory i18nConversionCategory5 : conversionCategoriesForIntersect) {
            if (arrayToSet(i18nConversionCategory5.types).equals(arrayToSet)) {
                return i18nConversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        return intersect(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String str) {
        String lowerCase = str.toLowerCase();
        for (I18nConversionCategory i18nConversionCategory : namedCategories) {
            for (String equals : i18nConversionCategory.strings) {
                if (equals.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type " + lowerCase);
    }

    public static I18nConversionCategory union(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3 || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = GENERAL) || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = DATE) || i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory3;
        }
        return NUMBER;
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

    public String toString() {
        StringBuilder sb2 = new StringBuilder(name());
        if (this.types == null) {
            sb2.append(" conversion category (all types)");
        } else {
            StringJoiner stringJoiner = new StringJoiner(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, " conversion category (one of: ", ")");
            for (Class<?> canonicalName : this.types) {
                stringJoiner.add(canonicalName.getCanonicalName());
            }
            sb2.append(stringJoiner);
        }
        return sb2.toString();
    }
}
