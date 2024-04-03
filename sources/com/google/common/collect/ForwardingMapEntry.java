package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    public abstract Map.Entry<K, V> delegate();

    public boolean equals(@CheckForNull Object obj) {
        return delegate().equals(obj);
    }

    @ParametricNullness
    public K getKey() {
        return delegate().getKey();
    }

    @ParametricNullness
    public V getValue() {
        return delegate().getValue();
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V v11) {
        return delegate().setValue(v11);
    }

    public boolean standardEquals(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public int standardHashCode() {
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

    public String standardToString() {
        return getKey() + "=" + getValue();
    }
}
