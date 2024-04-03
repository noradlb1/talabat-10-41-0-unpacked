package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonQualifier;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

final class Util {
    private Util() {
        throw new AssertionError("No instances.");
    }

    public static <A extends Annotation> Pair<A, Set<Annotation>> nextAnnotations(Set<? extends Annotation> set, Class<A> cls) {
        if (!cls.isAnnotationPresent(JsonQualifier.class)) {
            throw new IllegalArgumentException(cls + " is not a JsonQualifier.");
        } else if (set.isEmpty()) {
            return null;
        } else {
            for (Annotation annotation : set) {
                if (cls.equals(annotation.annotationType())) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(set);
                    linkedHashSet.remove(annotation);
                    return new Pair<>(annotation, Collections.unmodifiableSet(linkedHashSet));
                }
            }
            return null;
        }
    }
}
