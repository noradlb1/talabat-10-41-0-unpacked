package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface Weigher<K, V> {
    int weigh(K k11, V v11);
}
