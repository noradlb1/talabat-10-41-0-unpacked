package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ImmutableSortedSet<T> implements Iterable<T> {
    private final ImmutableSortedMap<T, Void> map;

    public static class WrappedEntryIterator<T> implements Iterator<T>, j$.util.Iterator {
        final Iterator<Map.Entry<T, Void>> iterator;

        public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> it) {
            this.iterator = it;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public T next() {
            return this.iterator.next().getKey();
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator) {
        this.map = ImmutableSortedMap.Builder.buildFrom(list, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    public boolean contains(T t11) {
        return this.map.containsKey(t11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableSortedSet)) {
            return false;
        }
        return this.map.equals(((ImmutableSortedSet) obj).map);
    }

    public T getMaxEntry() {
        return this.map.getMaxKey();
    }

    public T getMinEntry() {
        return this.map.getMinKey();
    }

    public T getPredecessorEntry(T t11) {
        return this.map.getPredecessorKey(t11);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public int indexOf(T t11) {
        return this.map.indexOf(t11);
    }

    public ImmutableSortedSet<T> insert(T t11) {
        return new ImmutableSortedSet<>(this.map.insert(t11, null));
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public java.util.Iterator<T> iterator() {
        return new WrappedEntryIterator(this.map.iterator());
    }

    public java.util.Iterator<T> iteratorFrom(T t11) {
        return new WrappedEntryIterator(this.map.iteratorFrom(t11));
    }

    public ImmutableSortedSet<T> remove(T t11) {
        ImmutableSortedMap<T, Void> remove = this.map.remove(t11);
        if (remove == this.map) {
            return this;
        }
        return new ImmutableSortedSet<>(remove);
    }

    public java.util.Iterator<T> reverseIterator() {
        return new WrappedEntryIterator(this.map.reverseIterator());
    }

    public java.util.Iterator<T> reverseIteratorFrom(T t11) {
        return new WrappedEntryIterator(this.map.reverseIteratorFrom(t11));
    }

    public int size() {
        return this.map.size();
    }

    public ImmutableSortedSet<T> unionWith(ImmutableSortedSet<T> immutableSortedSet) {
        ImmutableSortedSet<T> immutableSortedSet2;
        ImmutableSortedSet<T> immutableSortedSet3;
        if (size() < immutableSortedSet.size()) {
            immutableSortedSet3 = immutableSortedSet;
            immutableSortedSet2 = this;
        } else {
            immutableSortedSet3 = this;
            immutableSortedSet2 = immutableSortedSet;
        }
        java.util.Iterator it = immutableSortedSet2.iterator();
        while (it.hasNext()) {
            immutableSortedSet3 = immutableSortedSet3.insert(it.next());
        }
        return immutableSortedSet3;
    }

    private ImmutableSortedSet(ImmutableSortedMap<T, Void> immutableSortedMap) {
        this.map = immutableSortedMap;
    }
}
