package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    public V apply(K k11) {
        return delegate().apply(k11);
    }

    public abstract LoadingCache<K, V> delegate();

    @CanIgnoreReturnValue
    public V get(K k11) throws ExecutionException {
        return delegate().get(k11);
    }

    @CanIgnoreReturnValue
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return delegate().getAll(iterable);
    }

    @CanIgnoreReturnValue
    public V getUnchecked(K k11) {
        return delegate().getUnchecked(k11);
    }

    public void refresh(K k11) {
        delegate().refresh(k11);
    }

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> delegate;

        public SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
