package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public abstract Set<V> createCollection();

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k11, @ParametricNullness V v11) {
        return super.put(k11, v11);
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    public Collection<V> wrapCollection(@ParametricNullness K k11, Collection<V> collection) {
        return new AbstractMapBasedMultimap.WrappedSet(k11, (Set) collection);
    }

    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    public Set<V> get(@ParametricNullness K k11) {
        return (Set) super.get(k11);
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(@CheckForNull Object obj) {
        return (Set) super.removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> replaceValues(@ParametricNullness K k11, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k11, iterable);
    }
}
