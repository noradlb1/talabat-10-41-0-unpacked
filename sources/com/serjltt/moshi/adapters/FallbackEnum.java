package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Set;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FallbackEnum {
    public static final JsonAdapter.Factory ADAPTER_FACTORY = new JsonAdapter.Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            FallbackEnum fallbackEnum;
            if (!set.isEmpty()) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (!rawType.isEnum() || (fallbackEnum = (FallbackEnum) rawType.getAnnotation(FallbackEnum.class)) == null) {
                return null;
            }
            return new FallbackEnumJsonAdapter(rawType, fallbackEnum.name()).nullSafe();
        }
    };

    String name();
}
