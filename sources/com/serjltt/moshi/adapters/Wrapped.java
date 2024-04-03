package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Set;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JsonQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Wrapped {
    public static final JsonAdapter.Factory ADAPTER_FACTORY = new JsonAdapter.Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Pair<A, Set<Annotation>> nextAnnotations = Util.nextAnnotations(set, Wrapped.class);
            if (nextAnnotations == null) {
                return null;
            }
            JsonAdapter adapter = moshi.adapter(type, (Set<? extends Annotation>) (Set) nextAnnotations.f52929b);
            Wrapped wrapped = (Wrapped) nextAnnotations.f52928a;
            return new WrappedJsonAdapter(adapter, wrapped.path(), wrapped.failOnNotFound());
        }
    };

    public static final class Factory {
        private Factory() {
            throw new AssertionError("No instances.");
        }

        public static Wrapped create(String... strArr) {
            return create(true, strArr);
        }

        public static Wrapped create(final boolean z11, final String... strArr) {
            return new Wrapped() {
                public Class<? extends Annotation> annotationType() {
                    return Wrapped.class;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || AnonymousClass1.class != obj.getClass()) {
                        return false;
                    }
                    Wrapped wrapped = (Wrapped) obj;
                    if (!Arrays.equals(strArr, wrapped.path()) || z11 != wrapped.failOnNotFound()) {
                        return false;
                    }
                    return true;
                }

                public boolean failOnNotFound() {
                    return z11;
                }

                public int hashCode() {
                    return (Arrays.hashCode(strArr) * 43) + (z11 ? 1 : 0);
                }

                public String[] path() {
                    return strArr;
                }

                public String toString() {
                    return "Wrapped(path=" + Arrays.asList(strArr) + ", failOnNotFound=" + z11 + ")";
                }
            };
        }
    }

    boolean failOnNotFound() default true;

    String[] path();
}
