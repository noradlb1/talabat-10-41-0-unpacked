package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(@ParametricNullness C c11) {
        return delegate().column(c11);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().contains(obj, obj2);
    }

    public boolean containsColumn(@CheckForNull Object obj) {
        return delegate().containsColumn(obj);
    }

    public boolean containsRow(@CheckForNull Object obj) {
        return delegate().containsRow(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    public abstract Table<R, C, V> delegate();

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().get(obj, obj2);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V put(@ParametricNullness R r11, @ParametricNullness C c11, @ParametricNullness V v11) {
        return delegate().put(r11, c11, v11);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public Map<C, V> row(@ParametricNullness R r11) {
        return delegate().row(r11);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
