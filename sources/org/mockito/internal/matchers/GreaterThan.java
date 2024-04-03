package org.mockito.internal.matchers;

import java.lang.Comparable;

public class GreaterThan<T extends Comparable<T>> extends CompareTo<T> {
    public GreaterThan(T t11) {
        super(t11);
    }

    public String a() {
        return "gt";
    }

    public boolean b(int i11) {
        return i11 > 0;
    }
}
