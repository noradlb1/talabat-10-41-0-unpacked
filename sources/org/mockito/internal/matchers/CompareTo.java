package org.mockito.internal.matchers;

import java.io.Serializable;
import java.lang.Comparable;
import org.mockito.ArgumentMatcher;

public abstract class CompareTo<T extends Comparable<T>> implements ArgumentMatcher<T>, Serializable {
    private final T wanted;

    public CompareTo(T t11) {
        this.wanted = t11;
    }

    public abstract String a();

    public abstract boolean b(int i11);

    public final String toString() {
        return a() + "(" + this.wanted + ")";
    }

    public final boolean matches(T t11) {
        if (t11 != null && t11.getClass().isInstance(this.wanted)) {
            return b(t11.compareTo(this.wanted));
        }
        return false;
    }
}
