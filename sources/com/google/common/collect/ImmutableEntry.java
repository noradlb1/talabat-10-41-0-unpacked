package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @ParametricNullness
    final K key;
    @ParametricNullness
    final V value;

    public ImmutableEntry(@ParametricNullness K k11, @ParametricNullness V v11) {
        this.key = k11;
        this.value = v11;
    }

    @ParametricNullness
    public final K getKey() {
        return this.key;
    }

    @ParametricNullness
    public final V getValue() {
        return this.value;
    }

    @ParametricNullness
    public final V setValue(@ParametricNullness V v11) {
        throw new UnsupportedOperationException();
    }
}
