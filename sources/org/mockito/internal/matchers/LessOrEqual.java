package org.mockito.internal.matchers;

import java.lang.Comparable;

public class LessOrEqual<T extends Comparable<T>> extends CompareTo<T> {
    public LessOrEqual(T t11) {
        super(t11);
    }

    public String a() {
        return "leq";
    }

    public boolean b(int i11) {
        return i11 <= 0;
    }
}
