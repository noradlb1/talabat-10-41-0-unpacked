package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Sets {

    public static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        private CartesianSet(ImmutableList<ImmutableSet<E>> immutableList, CartesianList<E> cartesianList) {
            this.axes = immutableList;
            this.delegate = cartesianList;
        }

        public static <E> Set<List<E>> create(List<? extends Set<? extends E>> list) {
            ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
            for (Set copyOf : list) {
                ImmutableSet copyOf2 = ImmutableSet.copyOf(copyOf);
                if (copyOf2.isEmpty()) {
                    return ImmutableSet.of();
                }
                builder.add((Object) copyOf2);
            }
            final ImmutableList build = builder.build();
            return new CartesianSet(build, new CartesianList(new ImmutableList<List<E>>() {
                public boolean isPartialView() {
                    return true;
                }

                public int size() {
                    return ImmutableList.this.size();
                }

                public List<E> get(int i11) {
                    return ((ImmutableSet) ImmutableList.this.get(i11)).asList();
                }
            }));
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            List<Object> list = (List) obj;
            if (list.size() != this.axes.size()) {
                return false;
            }
            int i11 = 0;
            for (Object contains : list) {
                if (!this.axes.get(i11).contains(contains)) {
                    return false;
                }
                i11++;
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof CartesianSet) {
                return this.axes.equals(((CartesianSet) obj).axes);
            }
            return super.equals(obj);
        }

        public int hashCode() {
            int i11 = 1;
            int size = size() - 1;
            for (int i12 = 0; i12 < this.axes.size(); i12++) {
                size = ~(~(size * 31));
            }
            UnmodifiableIterator<ImmutableSet<E>> it = this.axes.iterator();
            while (it.hasNext()) {
                Set next = it.next();
                i11 = ~(~((i11 * 31) + ((size() / next.size()) * next.hashCode())));
            }
            return ~(~(i11 + size));
        }

        public Collection<List<E>> delegate() {
            return this.delegate;
        }
    }

    @GwtIncompatible
    public static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        public DescendingSet(NavigableSet<E> navigableSet) {
            this.forward = navigableSet;
        }

        private static <T> Ordering<T> reverse(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e11) {
            return this.forward.floor(e11);
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.forward.comparator();
            if (comparator == null) {
                return Ordering.natural().reverse();
            }
            return reverse(comparator);
        }

        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        @ParametricNullness
        public E first() {
            return this.forward.last();
        }

        @CheckForNull
        public E floor(@ParametricNullness E e11) {
            return this.forward.ceiling(e11);
        }

        public NavigableSet<E> headSet(@ParametricNullness E e11, boolean z11) {
            return this.forward.tailSet(e11, z11).descendingSet();
        }

        @CheckForNull
        public E higher(@ParametricNullness E e11) {
            return this.forward.lower(e11);
        }

        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        @ParametricNullness
        public E last() {
            return this.forward.first();
        }

        @CheckForNull
        public E lower(@ParametricNullness E e11) {
            return this.forward.higher(e11);
        }

        @CheckForNull
        public E pollFirst() {
            return this.forward.pollLast();
        }

        @CheckForNull
        public E pollLast() {
            return this.forward.pollFirst();
        }

        public NavigableSet<E> subSet(@ParametricNullness E e11, boolean z11, @ParametricNullness E e12, boolean z12) {
            return this.forward.subSet(e12, z12, e11, z11).descendingSet();
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e11, boolean z11) {
            return this.forward.headSet(e11, z11).descendingSet();
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public String toString() {
            return standardToString();
        }

        public SortedSet<E> headSet(@ParametricNullness E e11) {
            return standardHeadSet(e11);
        }

        public SortedSet<E> subSet(@ParametricNullness E e11, @ParametricNullness E e12) {
            return standardSubSet(e11, e12);
        }

        public SortedSet<E> tailSet(@ParametricNullness E e11) {
            return standardTailSet(e11);
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public NavigableSet<E> delegate() {
            return this.forward;
        }
    }

    @GwtIncompatible
    public static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        public FilteredNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e11) {
            return Iterables.find(unfiltered().tailSet(e11, true), this.predicate, null);
        }

        public Iterator<E> descendingIterator() {
            return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
        }

        public NavigableSet<E> descendingSet() {
            return Sets.filter(unfiltered().descendingSet(), this.predicate);
        }

        @CheckForNull
        public E floor(@ParametricNullness E e11) {
            return Iterators.find(unfiltered().headSet(e11, true).descendingIterator(), this.predicate, null);
        }

        public NavigableSet<E> headSet(@ParametricNullness E e11, boolean z11) {
            return Sets.filter(unfiltered().headSet(e11, z11), this.predicate);
        }

        @CheckForNull
        public E higher(@ParametricNullness E e11) {
            return Iterables.find(unfiltered().tailSet(e11, false), this.predicate, null);
        }

        @ParametricNullness
        public E last() {
            return Iterators.find(unfiltered().descendingIterator(), this.predicate);
        }

        @CheckForNull
        public E lower(@ParametricNullness E e11) {
            return Iterators.find(unfiltered().headSet(e11, false).descendingIterator(), this.predicate, null);
        }

        @CheckForNull
        public E pollFirst() {
            return Iterables.removeFirstMatching(unfiltered(), this.predicate);
        }

        @CheckForNull
        public E pollLast() {
            return Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
        }

        public NavigableSet<E> subSet(@ParametricNullness E e11, boolean z11, @ParametricNullness E e12, boolean z12) {
            return Sets.filter(unfiltered().subSet(e11, z11, e12, z12), this.predicate);
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e11, boolean z11) {
            return Sets.filter(unfiltered().tailSet(e11, z11), this.predicate);
        }

        public NavigableSet<E> unfiltered() {
            return (NavigableSet) this.unfiltered;
        }
    }

    public static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        public FilteredSet(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        public FilteredSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        @CheckForNull
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        @ParametricNullness
        public E first() {
            return Iterators.find(this.unfiltered.iterator(), this.predicate);
        }

        public SortedSet<E> headSet(@ParametricNullness E e11) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(e11), this.predicate);
        }

        @ParametricNullness
        public E last() {
            SortedSet sortedSet = (SortedSet) this.unfiltered;
            while (true) {
                E last = sortedSet.last();
                if (this.predicate.apply(last)) {
                    return last;
                }
                sortedSet = sortedSet.headSet(last);
            }
        }

        public SortedSet<E> subSet(@ParametricNullness E e11, @ParametricNullness E e12) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(e11, e12), this.predicate);
        }

        public SortedSet<E> tailSet(@ParametricNullness E e11) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(e11), this.predicate);
        }
    }

    public static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        public boolean removeAll(Collection<?> collection) {
            return Sets.removeAllImpl((Set<?>) this, collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    public static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        public PowerSet(Set<E> set) {
            boolean z11;
            if (set.size() <= 30) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Too many elements to create power set: %s > 30", set.size());
            this.inputSet = Maps.indexMap(set);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.inputSet.keySet().containsAll((Set) obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof PowerSet) {
                return this.inputSet.keySet().equals(((PowerSet) obj).inputSet.keySet());
            }
            return super.equals(obj);
        }

        public int hashCode() {
            return this.inputSet.keySet().hashCode() << (this.inputSet.size() - 1);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<Set<E>> iterator() {
            return new AbstractIndexedListIterator<Set<E>>(size()) {
                public Set<E> get(int i11) {
                    return new SubSet(PowerSet.this.inputSet, i11);
                }
            };
        }

        public int size() {
            return 1 << this.inputSet.size();
        }

        public String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean add(@ParametricNullness E e11) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S copyInto(S s11) {
            s11.addAll(this);
            return s11;
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf(this);
        }

        public abstract UnmodifiableIterator<E> iterator();

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        private SetView() {
        }
    }

    public static final class SubSet<E> extends AbstractSet<E> {
        /* access modifiers changed from: private */
        public final ImmutableMap<E, Integer> inputSet;
        /* access modifiers changed from: private */
        public final int mask;

        public SubSet(ImmutableMap<E, Integer> immutableMap, int i11) {
            this.inputSet = immutableMap;
            this.mask = i11;
        }

        public boolean contains(@CheckForNull Object obj) {
            Integer num = this.inputSet.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.mask) != 0) {
                    return true;
                }
            }
            return false;
        }

        public Iterator<E> iterator() {
            return new UnmodifiableIterator<E>() {
                final ImmutableList<E> elements;
                int remainingSetBits;

                {
                    this.elements = SubSet.this.inputSet.keySet().asList();
                    this.remainingSetBits = SubSet.this.mask;
                }

                public boolean hasNext() {
                    return this.remainingSetBits != 0;
                }

                public E next() {
                    int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.remainingSetBits);
                    if (numberOfTrailingZeros != 32) {
                        this.remainingSetBits &= ~(1 << numberOfTrailingZeros);
                        return this.elements.get(numberOfTrailingZeros);
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        public int size() {
            return Integer.bitCount(this.mask);
        }
    }

    private Sets() {
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> list) {
        return CartesianSet.create(list);
    }

    public static <E> Set<Set<E>> combinations(Set<E> set, final int i11) {
        boolean z11;
        final ImmutableMap<E, Integer> indexMap = Maps.indexMap(set);
        CollectPreconditions.checkNonnegative(i11, BindingAdaptersKt.QUERY_SIZE);
        if (i11 <= indexMap.size()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "size (%s) must be <= set.size() (%s)", i11, indexMap.size());
        if (i11 == 0) {
            return ImmutableSet.of(ImmutableSet.of());
        }
        if (i11 == indexMap.size()) {
            return ImmutableSet.of(indexMap.keySet());
        }
        return new AbstractSet<Set<E>>() {
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Set)) {
                    return false;
                }
                Set set = (Set) obj;
                if (set.size() != i11 || !indexMap.keySet().containsAll(set)) {
                    return false;
                }
                return true;
            }

            public Iterator<Set<E>> iterator() {
                return new AbstractIterator<Set<E>>() {
                    final BitSet bits;

                    {
                        this.bits = new BitSet(indexMap.size());
                    }

                    @CheckForNull
                    public Set<E> computeNext() {
                        if (this.bits.isEmpty()) {
                            this.bits.set(0, i11);
                        } else {
                            int nextSetBit = this.bits.nextSetBit(0);
                            int nextClearBit = this.bits.nextClearBit(nextSetBit);
                            if (nextClearBit == indexMap.size()) {
                                return (Set) endOfData();
                            }
                            int i11 = (nextClearBit - nextSetBit) - 1;
                            this.bits.set(0, i11);
                            this.bits.clear(i11, nextClearBit);
                            this.bits.set(nextClearBit);
                        }
                        final BitSet bitSet = (BitSet) this.bits.clone();
                        return new AbstractSet<E>() {
                            public boolean contains(@CheckForNull Object obj) {
                                Integer num = (Integer) indexMap.get(obj);
                                if (num == null || !bitSet.get(num.intValue())) {
                                    return false;
                                }
                                return true;
                            }

                            public Iterator<E> iterator() {
                                return new AbstractIterator<E>() {

                                    /* renamed from: i  reason: collision with root package name */
                                    int f44641i = -1;

                                    @CheckForNull
                                    public E computeNext() {
                                        int nextSetBit = bitSet.nextSetBit(this.f44641i + 1);
                                        this.f44641i = nextSetBit;
                                        if (nextSetBit == -1) {
                                            return endOfData();
                                        }
                                        return indexMap.keySet().asList().get(this.f44641i);
                                    }
                                };
                            }

                            public int size() {
                                return i11;
                            }
                        };
                    }
                };
            }

            public int size() {
                return IntMath.binomial(indexMap.size(), i11);
            }

            public String toString() {
                return "Sets.combinations(" + indexMap.keySet() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11 + ")";
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(collection, ((Enum) collection.iterator().next()).getDeclaringClass());
    }

    public static <E> SetView<E> difference(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }

            public boolean isEmpty() {
                return set2.containsAll(set);
            }

            public int size() {
                int i11 = 0;
                for (Object contains : set) {
                    if (!set2.contains(contains)) {
                        i11++;
                    }
                }
                return i11;
            }

            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    final Iterator<E> itr;

                    {
                        this.itr = set.iterator();
                    }

                    @CheckForNull
                    public E computeNext() {
                        while (this.itr.hasNext()) {
                            E next = this.itr.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public static boolean equalsImpl(Set<?> set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <E> Set<E> filter(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return filter((SortedSet) set, predicate);
        }
        if (!(set instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.checkNotNull(set), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) set;
        return new FilteredSet((Set) filteredSet.unfiltered, Predicates.and(filteredSet.predicate, predicate));
    }

    public static int hashCodeImpl(Set<?> set) {
        int i11;
        int i12 = 0;
        for (Object next : set) {
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 = ~(~(i12 + i11));
        }
        return i12;
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E e11, E... eArr) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(e11, eArr));
    }

    public static <E> SetView<E> intersection(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }

            public boolean isEmpty() {
                return Collections.disjoint(set2, set);
            }

            public int size() {
                int i11 = 0;
                for (Object contains : set) {
                    if (set2.contains(contains)) {
                        i11++;
                    }
                }
                return i11;
            }

            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    final Iterator<E> itr;

                    {
                        this.itr = set.iterator();
                    }

                    @CheckForNull
                    public E computeNext() {
                        while (this.itr.hasNext()) {
                            E next = this.itr.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    @GwtIncompatible
    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> collection, Class<E> cls) {
        EnumSet<E> allOf = EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> noneOf = EnumSet.noneOf(cls);
        Iterables.addAll(noneOf, iterable);
        return noneOf;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int i11) {
        return new HashSet<>(Maps.capacity(i11));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i11) {
        return new LinkedHashSet<>(Maps.capacity(i11));
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<>();
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        return new PowerSet(set);
    }

    public static boolean removeAllImpl(Set<?> set, Iterator<?> it) {
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= set.remove(it.next());
        }
        return z11;
    }

    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> navigableSet, Range<K> range) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            if (navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkArgument(z12, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            if (lowerBoundType == boundType) {
                z11 = true;
            } else {
                z11 = false;
            }
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() != boundType) {
                z13 = false;
            }
            return navigableSet.subSet(lowerEndpoint, z11, upperEndpoint, z13);
        } else if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() != BoundType.CLOSED) {
                z13 = false;
            }
            return navigableSet.tailSet(lowerEndpoint2, z13);
        } else if (!range.hasUpperBound()) {
            return (NavigableSet) Preconditions.checkNotNull(navigableSet);
        } else {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z13 = false;
            }
            return navigableSet.headSet(upperEndpoint2, z13);
        }
    }

    public static <E> SetView<E> symmetricDifference(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set2.contains(obj) ^ set.contains(obj);
            }

            public boolean isEmpty() {
                return set.equals(set2);
            }

            public int size() {
                int i11 = 0;
                for (Object contains : set) {
                    if (!set2.contains(contains)) {
                        i11++;
                    }
                }
                for (Object contains2 : set2) {
                    if (!set.contains(contains2)) {
                        i11++;
                    }
                }
                return i11;
            }

            public UnmodifiableIterator<E> iterator() {
                final Iterator it = set.iterator();
                final Iterator it2 = set2.iterator();
                return new AbstractIterator<E>() {
                    @CheckForNull
                    public E computeNext() {
                        while (it.hasNext()) {
                            E next = it.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        while (it2.hasNext()) {
                            E next2 = it2.next();
                            if (!set.contains(next2)) {
                                return next2;
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet) {
        return Synchronized.navigableSet(navigableSet);
    }

    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            public <S extends Set<E>> S copyInto(S s11) {
                s11.addAll(set);
                s11.addAll(set2);
                return s11;
            }

            public ImmutableSet<E> immutableCopy() {
                return new ImmutableSet.Builder().addAll((Iterable) set).addAll((Iterable) set2).build();
            }

            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            public int size() {
                int size = set.size();
                for (Object contains : set2) {
                    if (!set.contains(contains)) {
                        size++;
                    }
                }
                return size;
            }

            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    final Iterator<? extends E> itr1;
                    final Iterator<? extends E> itr2;

                    {
                        this.itr1 = set.iterator();
                        this.itr2 = set2.iterator();
                    }

                    @CheckForNull
                    public E computeNext() {
                        if (this.itr1.hasNext()) {
                            return this.itr1.next();
                        }
                        while (this.itr2.hasNext()) {
                            E next = this.itr2.next();
                            if (!set.contains(next)) {
                                return next;
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        if ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) {
            return navigableSet;
        }
        return new UnmodifiableNavigableSet(navigableSet);
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... setArr) {
        return cartesianProduct(Arrays.asList(setArr));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return ImmutableSet.of();
            }
            return ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return ImmutableSet.of();
        }
        EnumSet of2 = EnumSet.of((Enum) it.next());
        Iterators.addAll(of2, it);
        return ImmutableEnumSet.asImmutable(of2);
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> iterable) {
        Set<E> newConcurrentHashSet = newConcurrentHashSet();
        Iterables.addAll(newConcurrentHashSet, iterable);
        return newConcurrentHashSet;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> java.util.concurrent.CopyOnWriteArraySet<E> newCopyOnWriteArraySet(java.lang.Iterable<? extends E> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r1 = (java.util.Collection) r1
            goto L_0x000b
        L_0x0007:
            java.util.ArrayList r1 = com.google.common.collect.Lists.newArrayList(r1)
        L_0x000b:
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.newCopyOnWriteArraySet(java.lang.Iterable):java.util.concurrent.CopyOnWriteArraySet");
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> newHashSetWithExpectedSize = newHashSetWithExpectedSize(eArr.length);
        Collections.addAll(newHashSetWithExpectedSize, eArr);
        return newHashSetWithExpectedSize;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>((Collection) iterable);
        }
        LinkedHashSet<E> newLinkedHashSet = newLinkedHashSet();
        Iterables.addAll(newLinkedHashSet, iterable);
        return newLinkedHashSet;
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> iterable) {
        TreeSet<E> newTreeSet = newTreeSet();
        Iterables.addAll(newTreeSet, iterable);
        return newTreeSet;
    }

    public static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;
        @CheckForNull
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e11) {
            return this.delegate.ceiling(e11);
        }

        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.descendingSet = this;
            return unmodifiableNavigableSet2;
        }

        @CheckForNull
        public E floor(@ParametricNullness E e11) {
            return this.delegate.floor(e11);
        }

        public NavigableSet<E> headSet(@ParametricNullness E e11, boolean z11) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(e11, z11));
        }

        @CheckForNull
        public E higher(@ParametricNullness E e11) {
            return this.delegate.higher(e11);
        }

        @CheckForNull
        public E lower(@ParametricNullness E e11) {
            return this.delegate.lower(e11);
        }

        @CheckForNull
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        public NavigableSet<E> subSet(@ParametricNullness E e11, boolean z11, @ParametricNullness E e12, boolean z12) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(e11, z11, e12, z12));
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e11, boolean z11) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(e11, z11));
        }

        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }

    public static boolean removeAllImpl(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return removeAllImpl(set, collection.iterator());
        }
        return Iterators.removeAll(set.iterator(), collection);
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<>((Collection) iterable);
        }
        return newHashSet(iterable.iterator());
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) Preconditions.checkNotNull(comparator));
    }

    @GwtIncompatible
    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> cls) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        return makeComplementByHand(collection, cls);
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        HashSet<E> newHashSet = newHashSet();
        Iterators.addAll(newHashSet, it);
        return newHashSet;
    }

    public static <E> SortedSet<E> filter(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (!(sortedSet instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(sortedSet), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) sortedSet;
        return new FilteredSortedSet((SortedSet) filteredSet.unfiltered, Predicates.and(filteredSet.predicate, predicate));
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> filter(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (!(navigableSet instanceof FilteredSet)) {
            return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(navigableSet), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) navigableSet;
        return new FilteredNavigableSet((NavigableSet) filteredSet.unfiltered, Predicates.and(filteredSet.predicate, predicate));
    }
}
