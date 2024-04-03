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
import java.util.Set;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@JsonQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DeserializeOnly {
    public static final JsonAdapter.Factory ADAPTER_FACTORY = new JsonAdapter.Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Set<? extends Annotation> nextAnnotations = Types.nextAnnotations(set, DeserializeOnly.class);
            if (nextAnnotations == null) {
                return null;
            }
            return new TransientJsonAdapter(moshi.adapter(type, nextAnnotations), false, true);
        }
    };
}
