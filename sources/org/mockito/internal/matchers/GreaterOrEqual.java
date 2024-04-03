package org.mockito.internal.matchers;

import java.lang.Comparable;

public class GreaterOrEqual<T extends Comparable<T>> extends CompareTo<T> {
    public GreaterOrEqual(T t11) {
        super(t11);
    }

    public String a() {
        return "geq";
    }

    public boolean b(int i11) {
        return i11 >= 0;
    }
}
