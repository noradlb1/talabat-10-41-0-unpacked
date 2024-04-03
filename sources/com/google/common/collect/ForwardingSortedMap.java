package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    public class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
            super(forwardingSortedMap);
        }
    }

    public static int unsafeCompare(@CheckForNull Comparator<?> comparator, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    public abstract SortedMap<K, V> delegate();

    @ParametricNullness
    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(@ParametricNullness K k11) {
        return delegate().headMap(k11);
    }

    @ParametricNullness
    public K lastKey() {
        return delegate().lastKey();
    }

    public boolean standardContainsKey(@CheckForNull Object obj) {
        try {
            if (unsafeCompare(comparator(), tailMap(obj).firstKey(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public SortedMap<K, V> standardSubMap(K k11, K k12) {
        boolean z11;
        if (unsafeCompare(comparator(), k11, k12) <= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "fromKey must be <= toKey");
        return tailMap(k11).headMap(k12);
    }

    public SortedMap<K, V> subMap(@ParametricNullness K k11, @ParametricNullness K k12) {
        return delegate().subMap(k11, k12);
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K k11) {
        return delegate().tailMap(k11);
    }
}
