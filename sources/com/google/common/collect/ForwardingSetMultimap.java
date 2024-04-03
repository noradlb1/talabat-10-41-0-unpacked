package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSetMultimap<K, V> extends ForwardingMultimap<K, V> implements SetMultimap<K, V> {
    public abstract SetMultimap<K, V> delegate();

    public Set<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    public Set<V> get(@ParametricNullness K k11) {
        return delegate().get((Object) k11);
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> replaceValues(@ParametricNullness K k11, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k11, (Iterable) iterable);
    }
}
