package com.google.common.collect;

import b9.c;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final long serialVersionUID = 0;
    @CheckForNull
    private transient ImmutableSortedMap<K, V> descendingMap;
    /* access modifiers changed from: private */
    public final transient RegularImmutableSortedSet<K> keySet;
    /* access modifiers changed from: private */
    public final transient ImmutableList<V> valueList;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;
        private transient Object[] keys;
        private transient Object[] values;

        public Builder(Comparator<? super K> comparator2) {
            this(comparator2, 4);
        }

        private void ensureCapacity(int i11) {
            Object[] objArr = this.keys;
            if (i11 > objArr.length) {
                int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(objArr.length, i11);
                this.keys = Arrays.copyOf(this.keys, expandedCapacity);
                this.values = Arrays.copyOf(this.values, expandedCapacity);
            }
        }

        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder<K, V> builder) {
            ensureCapacity(this.size + builder.size);
            System.arraycopy(builder.keys, 0, this.keys, this.size, builder.size);
            System.arraycopy(builder.values, 0, this.values, this.size, builder.size);
            this.size += builder.size;
            return this;
        }

        private Builder(Comparator<? super K> comparator2, int i11) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
            this.keys = new Object[i11];
            this.values = new Object[i11];
        }

        public ImmutableSortedMap<K, V> build() {
            return buildOrThrow();
        }

        @DoNotCall
        @Deprecated
        public final ImmutableSortedMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        public ImmutableSortedMap<K, V> buildOrThrow() {
            int i11 = this.size;
            if (i11 == 0) {
                return ImmutableSortedMap.emptyMap(this.comparator);
            }
            if (i11 != 1) {
                Object[] copyOf = Arrays.copyOf(this.keys, i11);
                Arrays.sort(copyOf, this.comparator);
                Object[] objArr = new Object[this.size];
                for (int i12 = 0; i12 < this.size; i12++) {
                    if (i12 > 0) {
                        int i13 = i12 - 1;
                        if (this.comparator.compare(copyOf[i13], copyOf[i12]) == 0) {
                            throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i13] + " and " + copyOf[i12]);
                        }
                    }
                    Object obj = this.keys[i12];
                    Objects.requireNonNull(obj);
                    int binarySearch = Arrays.binarySearch(copyOf, obj, this.comparator);
                    Object obj2 = this.values[i12];
                    Objects.requireNonNull(obj2);
                    objArr[binarySearch] = obj2;
                }
                return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(copyOf), this.comparator), ImmutableList.asImmutableList(objArr));
            }
            Comparator<? super K> comparator2 = this.comparator;
            Object obj3 = this.keys[0];
            Objects.requireNonNull(obj3);
            Object obj4 = this.values[0];
            Objects.requireNonNull(obj4);
            return ImmutableSortedMap.of(comparator2, obj3, obj4);
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator2) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k11, V v11) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(k11, v11);
            Object[] objArr = this.keys;
            int i11 = this.size;
            objArr[i11] = k11;
            this.values[i11] = v11;
            this.size = i11 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll(map);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }
    }

    @J2ktIncompatible
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public SerializedForm(ImmutableSortedMap<K, V> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        public Builder<K, V> makeBuilder(int i11) {
            return new Builder<>(this.comparator);
        }
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, (ImmutableSortedMap) null);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z11;
        boolean z12 = false;
        if (map instanceof SortedMap) {
            Comparator comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z11 = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z11 = true;
            }
            z12 = z11;
        }
        if (z12 && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, z12, map.entrySet());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.SortedMap<K, ? extends V>, java.util.SortedMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOfSorted(java.util.SortedMap<K, ? extends V> r3) {
        /*
            java.util.Comparator r0 = r3.comparator()
            if (r0 != 0) goto L_0x0008
            java.util.Comparator<java.lang.Comparable> r0 = NATURAL_ORDER
        L_0x0008:
            boolean r1 = r3 instanceof com.google.common.collect.ImmutableSortedMap
            if (r1 == 0) goto L_0x0016
            r1 = r3
            com.google.common.collect.ImmutableSortedMap r1 = (com.google.common.collect.ImmutableSortedMap) r1
            boolean r2 = r1.isPartialView()
            if (r2 != 0) goto L_0x0016
            return r1
        L_0x0016:
            r1 = 1
            java.util.Set r3 = r3.entrySet()
            com.google.common.collect.ImmutableSortedMap r3 = fromEntries(r0, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSortedMap.copyOfSorted(java.util.SortedMap):com.google.common.collect.ImmutableSortedMap");
    }

    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntries(Ordering.natural(), false, entryArr, entryArr.length);
    }

    private ImmutableSortedMap<K, V> getSubMap(int i11, int i12) {
        if (i11 == 0 && i12 == size()) {
            return this;
        }
        if (i11 == i12) {
            return emptyMap(comparator());
        }
        return new ImmutableSortedMap<>(this.keySet.getSubSet(i11, i12), this.valueList.subList(i11, i12));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$fromEntries$0(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        Objects.requireNonNull(entry);
        Objects.requireNonNull(entry2);
        return comparator.compare(entry.getKey(), entry2.getKey());
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return NATURAL_EMPTY_MAP;
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k11) {
        return tailMap(k11, true).firstEntry();
    }

    @CheckForNull
    public K ceilingKey(K k11) {
        return Maps.keyOrNull(ceilingEntry(k11));
    }

    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet<K, V>() {
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                return new ImmutableList<Map.Entry<K, V>>() {
                    public boolean isPartialView() {
                        return true;
                    }

                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }

                    public Map.Entry<K, V> get(int i11) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i11), ImmutableSortedMap.this.valueList.get(i11));
                    }
                };
            }

            public ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }

            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }
        };
    }

    public ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    public ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().asList().get(0);
    }

    public K firstKey() {
        return keySet().first();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k11) {
        return headMap(k11, true).lastEntry();
    }

    @CheckForNull
    public K floorKey(K k11) {
        return Maps.keyOrNull(floorEntry(k11));
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k11) {
        return tailMap(k11, false).firstEntry();
    }

    @CheckForNull
    public K higherKey(K k11) {
        return Maps.keyOrNull(higherEntry(k11));
    }

    public boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().asList().get(size() - 1);
    }

    public K lastKey() {
        return keySet().last();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k11) {
        return headMap(k11, false).lastEntry();
    }

    @CheckForNull
    public K lowerKey(K k11) {
        return Maps.keyOrNull(lowerEntry(k11));
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.valueList.size();
    }

    @J2ktIncompatible
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, @CheckForNull ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z11, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.toArray(iterable, (T[]) ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z11, entryArr, entryArr.length);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11) {
        return of(Ordering.natural(), k11, v11);
    }

    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return emptyMap(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return copyOfInternal(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    /* access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> comparator, K k11, V v11) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k11), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.of(v11));
    }

    public ImmutableSortedMap<K, V> headMap(K k11) {
        return headMap(k11, false);
    }

    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    public ImmutableSortedMap<K, V> subMap(K k11, K k12) {
        return subMap(k11, true, k12, false);
    }

    public ImmutableSortedMap<K, V> tailMap(K k11) {
        return tailMap(k11, true);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) NATURAL_ORDER);
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z11, Map.Entry<K, V>[] entryArr, int i11) {
        if (i11 == 0) {
            return emptyMap(comparator);
        }
        if (i11 != 1) {
            Object[] objArr = new Object[i11];
            Object[] objArr2 = new Object[i11];
            if (z11) {
                for (int i12 = 0; i12 < i11; i12++) {
                    Map.Entry<K, V> entry = entryArr[i12];
                    Objects.requireNonNull(entry);
                    Map.Entry entry2 = entry;
                    Object key = entry2.getKey();
                    Object value = entry2.getValue();
                    CollectPreconditions.checkEntryNotNull(key, value);
                    objArr[i12] = key;
                    objArr2[i12] = value;
                }
            } else {
                Arrays.sort(entryArr, 0, i11, new c(comparator));
                Map.Entry<K, V> entry3 = entryArr[0];
                Objects.requireNonNull(entry3);
                Map.Entry entry4 = entry3;
                Object key2 = entry4.getKey();
                objArr[0] = key2;
                Object value2 = entry4.getValue();
                objArr2[0] = value2;
                CollectPreconditions.checkEntryNotNull(objArr[0], value2);
                int i13 = 1;
                while (i13 < i11) {
                    Map.Entry<K, V> entry5 = entryArr[i13 - 1];
                    Objects.requireNonNull(entry5);
                    Map.Entry entry6 = entry5;
                    Map.Entry<K, V> entry7 = entryArr[i13];
                    Objects.requireNonNull(entry7);
                    Map.Entry entry8 = entry7;
                    Object key3 = entry8.getKey();
                    Object value3 = entry8.getValue();
                    CollectPreconditions.checkEntryNotNull(key3, value3);
                    objArr[i13] = key3;
                    objArr2[i13] = value3;
                    ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, "key", entry6, entry8);
                    i13++;
                    key2 = key3;
                }
            }
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(objArr), comparator), ImmutableList.asImmutableList(objArr2));
        }
        Map.Entry<K, V> entry9 = entryArr[0];
        Objects.requireNonNull(entry9);
        Map.Entry entry10 = entry9;
        return of(comparator, entry10.getKey(), entry10.getValue());
    }

    public ImmutableSortedMap<K, V> headMap(K k11, boolean z11) {
        return getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(k11), z11));
    }

    public ImmutableSortedMap<K, V> subMap(K k11, boolean z11, K k12, boolean z12) {
        Preconditions.checkNotNull(k11);
        Preconditions.checkNotNull(k12);
        Preconditions.checkArgument(comparator().compare(k11, k12) <= 0, "expected fromKey <= toKey but %s > %s", (Object) k11, (Object) k12);
        return headMap(k12, z12).tailMap(k11, z11);
    }

    public ImmutableSortedMap<K, V> tailMap(K k11, boolean z11) {
        return getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(k11), z11), size());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return fromEntries((Comparator) Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17), ImmutableMap.entryOf(k18, v18));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17), ImmutableMap.entryOf(k18, v18), ImmutableMap.entryOf(k19, v19));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19, K k21, V v21) {
        return fromEntries(ImmutableMap.entryOf(k11, v11), ImmutableMap.entryOf(k12, v12), ImmutableMap.entryOf(k13, v13), ImmutableMap.entryOf(k14, v14), ImmutableMap.entryOf(k15, v15), ImmutableMap.entryOf(k16, v16), ImmutableMap.entryOf(k17, v17), ImmutableMap.entryOf(k18, v18), ImmutableMap.entryOf(k19, v19), ImmutableMap.entryOf(k21, v21));
    }
}
