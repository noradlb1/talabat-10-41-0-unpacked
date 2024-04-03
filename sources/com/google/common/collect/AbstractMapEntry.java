package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    @ParametricNullness
    public abstract K getKey();

    @ParametricNullness
    public abstract V getValue();

    public int hashCode() {
        int i11;
        Object key = getKey();
        Object value = getValue();
        int i12 = 0;
        if (key == null) {
            i11 = 0;
        } else {
            i11 = key.hashCode();
        }
        if (value != null) {
            i12 = value.hashCode();
        }
        return i11 ^ i12;
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V v11) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
