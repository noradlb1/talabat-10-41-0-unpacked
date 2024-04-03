package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    public abstract ListMultimap<K, V> delegate();

    public List<V> get(@ParametricNullness K k11) {
        return delegate().get((Object) k11);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public List<V> replaceValues(@ParametricNullness K k11, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k11, (Iterable) iterable);
    }
}
