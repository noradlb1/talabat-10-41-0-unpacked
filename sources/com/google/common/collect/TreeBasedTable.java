package com.google.common.collect;

import b9.g;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator2) {
            this.comparator = comparator2;
        }

        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    public class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {
        @CheckForNull
        final C lowerBound;
        @CheckForNull
        final C upperBound;
        @CheckForNull
        transient SortedMap<C, V> wholeRow;

        public TreeRow(TreeBasedTable treeBasedTable, R r11) {
            this(r11, (Object) null, (Object) null);
        }

        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        public int compare(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return rangeContains(obj) && super.containsKey(obj);
        }

        public C firstKey() {
            updateBackingRowMapField();
            Map<C, V> map = this.backingRowMap;
            if (map != null) {
                return ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        public SortedMap<C, V> headMap(C c11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)));
            return new TreeRow(this.rowKey, this.lowerBound, c11);
        }

        public C lastKey() {
            updateBackingRowMapField();
            Map<C, V> map = this.backingRowMap;
            if (map != null) {
                return ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        public void maintainEmptyInvariant() {
            updateWholeRowField();
            SortedMap<C, V> sortedMap = this.wholeRow;
            if (sortedMap != null && sortedMap.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.rowKey);
                this.wholeRow = null;
                this.backingRowMap = null;
            }
        }

        @CheckForNull
        public V put(C c11, V v11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)));
            return super.put(c11, v11);
        }

        public boolean rangeContains(@CheckForNull Object obj) {
            C c11;
            C c12;
            if (obj == null || (((c11 = this.lowerBound) != null && compare(c11, obj) > 0) || ((c12 = this.upperBound) != null && compare(c12, obj) <= 0))) {
                return false;
            }
            return true;
        }

        public SortedMap<C, V> subMap(C c11, C c12) {
            boolean z11;
            if (!rangeContains(Preconditions.checkNotNull(c11)) || !rangeContains(Preconditions.checkNotNull(c12))) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11);
            return new TreeRow(this.rowKey, c11, c12);
        }

        public SortedMap<C, V> tailMap(C c11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(c11)));
            return new TreeRow(this.rowKey, c11, this.upperBound);
        }

        public void updateWholeRowField() {
            SortedMap<C, V> sortedMap = this.wholeRow;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.rowKey))) {
                this.wholeRow = (SortedMap) TreeBasedTable.this.backingMap.get(this.rowKey);
            }
        }

        public TreeRow(R r11, @CheckForNull C c11, @CheckForNull C c12) {
            super(r11);
            this.lowerBound = c11;
            this.upperBound = c12;
            Preconditions.checkArgument(c11 == null || c12 == null || compare(c11, c12) <= 0);
        }

        @CheckForNull
        public SortedMap<C, V> computeBackingRowMap() {
            updateWholeRowField();
            SortedMap<C, V> sortedMap = this.wholeRow;
            if (sortedMap == null) {
                return null;
            }
            C c11 = this.lowerBound;
            if (c11 != null) {
                sortedMap = sortedMap.tailMap(c11);
            }
            C c12 = this.upperBound;
            return c12 != null ? sortedMap.headMap(c12) : sortedMap;
        }

        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.contains(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean containsColumn(@CheckForNull Object obj) {
        return super.containsColumn(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsRow(@CheckForNull Object obj) {
        return super.containsRow(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        final Comparator columnComparator2 = columnComparator();
        final UnmodifiableIterator<T> mergeSorted = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new g()), columnComparator2);
        return new AbstractIterator<C>(this) {
            @CheckForNull
            C lastValue;

            @CheckForNull
            public C computeNext() {
                boolean z11;
                while (mergeSorted.hasNext()) {
                    C next = mergeSorted.next();
                    C c11 = this.lastValue;
                    if (c11 == null || columnComparator2.compare(next, c11) != 0) {
                        z11 = false;
                        continue;
                    } else {
                        z11 = true;
                        continue;
                    }
                    if (!z11) {
                        this.lastValue = next;
                        return next;
                    }
                }
                this.lastValue = null;
                return endOfData();
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.get(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    public SortedMap<C, V> row(R r11) {
        return new TreeRow(this, r11);
    }

    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
