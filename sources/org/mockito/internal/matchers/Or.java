package org.mockito.internal.matchers;

import java.io.Serializable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.mockito.ArgumentMatcher;

public class Or implements ArgumentMatcher<Object>, Serializable {

    /* renamed from: m1  reason: collision with root package name */
    private final ArgumentMatcher f63223m1;

    /* renamed from: m2  reason: collision with root package name */
    private final ArgumentMatcher f63224m2;

    public Or(ArgumentMatcher<?> argumentMatcher, ArgumentMatcher<?> argumentMatcher2) {
        this.f63223m1 = argumentMatcher;
        this.f63224m2 = argumentMatcher2;
    }

    public boolean matches(Object obj) {
        return this.f63223m1.matches(obj) || this.f63224m2.matches(obj);
    }

    public String toString() {
        return "or(" + this.f63223m1 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f63224m2 + ")";
    }
}
