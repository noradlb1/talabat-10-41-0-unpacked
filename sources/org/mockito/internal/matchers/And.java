package org.mockito.internal.matchers;

import java.io.Serializable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.mockito.ArgumentMatcher;

public class And implements ArgumentMatcher<Object>, Serializable {

    /* renamed from: m1  reason: collision with root package name */
    private final ArgumentMatcher f63221m1;

    /* renamed from: m2  reason: collision with root package name */
    private final ArgumentMatcher f63222m2;

    public And(ArgumentMatcher<?> argumentMatcher, ArgumentMatcher<?> argumentMatcher2) {
        this.f63221m1 = argumentMatcher;
        this.f63222m2 = argumentMatcher2;
    }

    public boolean matches(Object obj) {
        return this.f63221m1.matches(obj) && this.f63222m2.matches(obj);
    }

    public String toString() {
        return "and(" + this.f63221m1 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f63222m2 + ")";
    }
}
