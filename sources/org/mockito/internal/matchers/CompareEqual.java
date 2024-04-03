package org.mockito.internal.matchers;

import java.lang.Comparable;

public class CompareEqual<T extends Comparable<T>> extends CompareTo<T> {
    public CompareEqual(T t11) {
        super(t11);
    }

    public String a() {
        return "cmpEq";
    }

    public boolean b(int i11) {
        return i11 == 0;
    }
}
