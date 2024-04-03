package org.mockito.internal.matchers;

import java.lang.Comparable;

public class LessThan<T extends Comparable<T>> extends CompareTo<T> {
    public LessThan(T t11) {
        super(t11);
    }

    public String a() {
        return "lt";
    }

    public boolean b(int i11) {
        return i11 < 0;
    }
}
