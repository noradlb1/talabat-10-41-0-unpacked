package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new Object() {
                @CheckForNull
                private Map.Entry<K, V> nextOrNull;
                @CheckForNull
                private Map.Entry<K, V> toRemove = null;

                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                public /* synthetic */ void forEachRemaining(Consumer consumer) {
                    Iterator.CC.$default$forEachRemaining(this, consumer);
                }

                public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                    forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                }

                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                public void remove() {
                    if (this.toRemove != null) {
                        StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                        this.toRemove = null;
                        return;
                    }
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }

                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> entry = this.nextOrNull;
                    if (entry != null) {
                        this.toRemove = entry;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        return entry;
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        public NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }
    }

    public class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k11) {
        return delegate().ceilingEntry(k11);
    }

    @CheckForNull
    public K ceilingKey(@ParametricNullness K k11) {
        return delegate().ceilingKey(k11);
    }

    public abstract NavigableMap<K, V> delegate();

    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k11) {
        return delegate().floorEntry(k11);
    }

    @CheckForNull
    public K floorKey(@ParametricNullness K k11) {
        return delegate().floorKey(k11);
    }

    public NavigableMap<K, V> headMap(@ParametricNullness K k11, boolean z11) {
        return delegate().headMap(k11, z11);
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k11) {
        return delegate().higherEntry(k11);
    }

    @CheckForNull
    public K higherKey(@ParametricNullness K k11) {
        return delegate().higherKey(k11);
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k11) {
        return delegate().lowerEntry(k11);
    }

    @CheckForNull
    public K lowerKey(@ParametricNullness K k11) {
        return delegate().lowerKey(k11);
    }

    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> standardCeilingEntry(@ParametricNullness K k11) {
        return tailMap(k11, true).firstEntry();
    }

    @CheckForNull
    public K standardCeilingKey(@ParametricNullness K k11) {
        return Maps.keyOrNull(ceilingEntry(k11));
    }

    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @CheckForNull
    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> standardFloorEntry(@ParametricNullness K k11) {
        return headMap(k11, true).lastEntry();
    }

    @CheckForNull
    public K standardFloorKey(@ParametricNullness K k11) {
        return Maps.keyOrNull(floorEntry(k11));
    }

    public SortedMap<K, V> standardHeadMap(@ParametricNullness K k11) {
        return headMap(k11, false);
    }

    @CheckForNull
    public Map.Entry<K, V> standardHigherEntry(@ParametricNullness K k11) {
        return tailMap(k11, false).firstEntry();
    }

    @CheckForNull
    public K standardHigherKey(@ParametricNullness K k11) {
        return Maps.keyOrNull(higherEntry(k11));
    }

    @CheckForNull
    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> standardLowerEntry(@ParametricNullness K k11) {
        return headMap(k11, false).lastEntry();
    }

    @CheckForNull
    public K standardLowerKey(@ParametricNullness K k11) {
        return Maps.keyOrNull(lowerEntry(k11));
    }

    @CheckForNull
    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    @CheckForNull
    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    public SortedMap<K, V> standardSubMap(@ParametricNullness K k11, @ParametricNullness K k12) {
        return subMap(k11, true, k12, false);
    }

    public SortedMap<K, V> standardTailMap(@ParametricNullness K k11) {
        return tailMap(k11, true);
    }

    public NavigableMap<K, V> subMap(@ParametricNullness K k11, boolean z11, @ParametricNullness K k12, boolean z12) {
        return delegate().subMap(k11, z11, k12, z12);
    }

    public NavigableMap<K, V> tailMap(@ParametricNullness K k11, boolean z11) {
        return delegate().tailMap(k11, z11);
    }
}
