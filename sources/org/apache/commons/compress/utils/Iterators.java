package org.apache.commons.compress.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Iterators {
    private Iterators() {
    }

    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it) {
        Objects.requireNonNull(collection);
        Objects.requireNonNull(it);
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= collection.add(it.next());
        }
        return z11;
    }
}
