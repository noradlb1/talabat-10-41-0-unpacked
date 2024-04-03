package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Set;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@JsonQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface FallbackOnNull {
    public static final JsonAdapter.Factory ADAPTER_FACTORY = new JsonAdapter.Factory() {
        private String fallbackType(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            return "fallback" + (simpleName.substring(0, 1).toUpperCase(Locale.US) + simpleName.substring(1));
        }

        private Object retrieveFallback(FallbackOnNull fallbackOnNull, String str) {
            try {
                return FallbackOnNull.class.getMethod(str, new Class[0]).invoke(fallbackOnNull, new Object[0]);
            } catch (Exception e11) {
                throw new AssertionError(e11);
            }
        }

        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Pair<A, Set<Annotation>> nextAnnotations = Util.nextAnnotations(set, FallbackOnNull.class);
            if (nextAnnotations == null) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (!FallbackOnNullJsonAdapter.f52924d.contains(rawType)) {
                return null;
            }
            String fallbackType = fallbackType(rawType);
            return new FallbackOnNullJsonAdapter(moshi.adapter(type, (Set<? extends Annotation>) (Set) nextAnnotations.f52929b), retrieveFallback((FallbackOnNull) nextAnnotations.f52928a, fallbackType), fallbackType);
        }
    };

    boolean fallbackBoolean() default false;

    byte fallbackByte() default Byte.MIN_VALUE;

    char fallbackChar() default '\u0000';

    double fallbackDouble() default Double.MIN_VALUE;

    float fallbackFloat() default Float.MIN_VALUE;

    int fallbackInt() default Integer.MIN_VALUE;

    long fallbackLong() default Long.MIN_VALUE;

    short fallbackShort() default Short.MIN_VALUE;
}
