package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Multisets {

    public static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (getCount() != entry.getCount() || !Objects.equal(getElement(), entry.getElement())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11;
            Object element = getElement();
            if (element == null) {
                i11 = 0;
            } else {
                i11 = element.hashCode();
            }
            return i11 ^ getCount();
        }

        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    public static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
        static final DecreasingCount INSTANCE = new DecreasingCount();

        private DecreasingCount() {
        }

        public int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    public static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        public void clear() {
            multiset().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return multiset().contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return multiset().containsAll(collection);
        }

        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        public abstract Iterator<E> iterator();

        public abstract Multiset<E> multiset();

        public boolean remove(@CheckForNull Object obj) {
            return multiset().remove(obj, Integer.MAX_VALUE) > 0;
        }

        public int size() {
            return multiset().entrySet().size();
        }
    }

    public static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        public void clear() {
            multiset().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() > 0 && multiset().count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        public abstract Multiset<E> multiset();

        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object element = entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return multiset().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static final class FilteredMultiset<E> extends ViewMultiset<E> {
        final Predicate<? super E> predicate;
        final Multiset<E> unfiltered;

        public FilteredMultiset(Multiset<E> multiset, Predicate<? super E> predicate2) {
            super();
            this.unfiltered = (Multiset) Preconditions.checkNotNull(multiset);
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate2);
        }

        public int add(@ParametricNullness E e11, int i11) {
            Preconditions.checkArgument(this.predicate.apply(e11), "Element %s does not match predicate %s", (Object) e11, (Object) this.predicate);
            return this.unfiltered.add(e11, i11);
        }

        public int count(@CheckForNull Object obj) {
            int count = this.unfiltered.count(obj);
            if (count <= 0) {
                return 0;
            }
            if (this.predicate.apply(obj)) {
                return count;
            }
            return 0;
        }

        public Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }

        public Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), new Predicate<Multiset.Entry<E>>() {
                public boolean apply(Multiset.Entry<E> entry) {
                    return FilteredMultiset.this.predicate.apply(entry.getElement());
                }
            });
        }

        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        public Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        public int remove(@CheckForNull Object obj, int i11) {
            CollectPreconditions.checkNonnegative(i11, "occurrences");
            if (i11 == 0) {
                return count(obj);
            }
            if (contains(obj)) {
                return this.unfiltered.remove(obj, i11);
            }
            return 0;
        }

        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }
    }

    public static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        @ParametricNullness
        private final E element;

        public ImmutableEntry(@ParametricNullness E e11, int i11) {
            this.element = e11;
            this.count = i11;
            CollectPreconditions.checkNonnegative(i11, "count");
        }

        public final int getCount() {
            return this.count;
        }

        @ParametricNullness
        public final E getElement() {
            return this.element;
        }

        @CheckForNull
        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    public static final class MultisetIteratorImpl<E> implements Iterator<E>, j$.util.Iterator {
        private boolean canRemove;
        @CheckForNull
        private Multiset.Entry<E> currentEntry;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private int laterCount;
        private final Multiset<E> multiset;
        private int totalCount;

        public MultisetIteratorImpl(Multiset<E> multiset2, Iterator<Multiset.Entry<E>> it) {
            this.multiset = multiset2;
            this.entryIterator = it;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.laterCount > 0 || this.entryIterator.hasNext();
        }

        @ParametricNullness
        public E next() {
            if (hasNext()) {
                if (this.laterCount == 0) {
                    Multiset.Entry<E> next = this.entryIterator.next();
                    this.currentEntry = next;
                    int count = next.getCount();
                    this.laterCount = count;
                    this.totalCount = count;
                }
                this.laterCount--;
                this.canRemove = true;
                Multiset.Entry<E> entry = this.currentEntry;
                java.util.Objects.requireNonNull(entry);
                return entry.getElement();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.totalCount == 1) {
                this.entryIterator.remove();
            } else {
                Multiset<E> multiset2 = this.multiset;
                Multiset.Entry<E> entry = this.currentEntry;
                java.util.Objects.requireNonNull(entry);
                multiset2.remove(entry.getElement());
            }
            this.totalCount--;
            this.canRemove = false;
        }
    }

    public static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;
        @CheckForNull
        transient Set<E> elementSet;
        @CheckForNull
        transient Set<Multiset.Entry<E>> entrySet;

        public UnmodifiableMultiset(Multiset<? extends E> multiset) {
            this.delegate = multiset;
        }

        public boolean add(@ParametricNullness E e11) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }

        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }

        public java.util.Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        public boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int setCount(@ParametricNullness E e11, int i11) {
            throw new UnsupportedOperationException();
        }

        public int add(@ParametricNullness E e11, int i11) {
            throw new UnsupportedOperationException();
        }

        public int remove(@CheckForNull Object obj, int i11) {
            throw new UnsupportedOperationException();
        }

        public boolean setCount(@ParametricNullness E e11, int i11, int i12) {
            throw new UnsupportedOperationException();
        }

        public Multiset<E> delegate() {
            return this.delegate;
        }
    }

    public static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        private ViewMultiset() {
        }

        public void clear() {
            elementSet().clear();
        }

        public int distinctElements() {
            return elementSet().size();
        }

        public java.util.Iterator<E> iterator() {
            return Multisets.iteratorImpl(this);
        }

        public int size() {
            return Multisets.linearTimeSizeImpl(this);
        }
    }

    private Multisets() {
    }

    public static <E> boolean addAllImpl(Multiset<E> multiset, Collection<? extends E> collection) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            return addAllImpl(multiset, cast(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.addAll(multiset, collection.iterator());
    }

    public static <T> Multiset<T> cast(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    @CanIgnoreReturnValue
    public static boolean containsOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (Multiset.Entry next : multiset2.entrySet()) {
            if (multiset.count(next.getElement()) < next.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, DecreasingCount.INSTANCE);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(entryArr));
    }

    public static <E> Multiset<E> difference(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() {
            public void clear() {
                throw new UnsupportedOperationException();
            }

            public int count(@CheckForNull Object obj) {
                int count = Multiset.this.count(obj);
                if (count == 0) {
                    return 0;
                }
                return Math.max(0, count - multiset2.count(obj));
            }

            public int distinctElements() {
                return Iterators.size(entryIterator());
            }

            public java.util.Iterator<E> elementIterator() {
                final java.util.Iterator it = Multiset.this.entrySet().iterator();
                return new AbstractIterator<E>() {
                    @CheckForNull
                    public E computeNext() {
                        while (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            E element = entry.getElement();
                            if (entry.getCount() > multiset2.count(element)) {
                                return element;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            public java.util.Iterator<Multiset.Entry<E>> entryIterator() {
                final java.util.Iterator it = Multiset.this.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    @CheckForNull
                    public Multiset.Entry<E> computeNext() {
                        while (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            int count = entry.getCount() - multiset2.count(element);
                            if (count > 0) {
                                return Multisets.immutableEntry(element, count);
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }
        };
    }

    public static <E> java.util.Iterator<E> elementIterator(java.util.Iterator<Multiset.Entry<E>> it) {
        return new TransformedIterator<Multiset.Entry<E>, E>(it) {
            @ParametricNullness
            public E transform(Multiset.Entry<E> entry) {
                return entry.getElement();
            }
        };
    }

    public static boolean equalsImpl(Multiset<?> multiset, @CheckForNull Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> Multiset<E> filter(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (!(multiset instanceof FilteredMultiset)) {
            return new FilteredMultiset(multiset, predicate);
        }
        FilteredMultiset filteredMultiset = (FilteredMultiset) multiset;
        return new FilteredMultiset(filteredMultiset.unfiltered, Predicates.and(filteredMultiset.predicate, predicate));
    }

    public static <E> Multiset.Entry<E> immutableEntry(@ParametricNullness E e11, int i11) {
        return new ImmutableEntry(e11, i11);
    }

    public static int inferDistinctElements(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Multiset<E> intersection(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() {
            public int count(@CheckForNull Object obj) {
                int count = Multiset.this.count(obj);
                if (count == 0) {
                    return 0;
                }
                return Math.min(count, multiset2.count(obj));
            }

            public Set<E> createElementSet() {
                return Sets.intersection(Multiset.this.elementSet(), multiset2.elementSet());
            }

            public java.util.Iterator<E> elementIterator() {
                throw new AssertionError("should never be called");
            }

            public java.util.Iterator<Multiset.Entry<E>> entryIterator() {
                final java.util.Iterator it = Multiset.this.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    @CheckForNull
                    public Multiset.Entry<E> computeNext() {
                        while (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            int min = Math.min(entry.getCount(), multiset2.count(element));
                            if (min > 0) {
                                return Multisets.immutableEntry(element, min);
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }
        };
    }

    public static <E> java.util.Iterator<E> iteratorImpl(Multiset<E> multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    public static int linearTimeSizeImpl(Multiset<?> multiset) {
        long j11 = 0;
        for (Multiset.Entry<?> count : multiset.entrySet()) {
            j11 += (long) count.getCount();
        }
        return Ints.saturatedCast(j11);
    }

    public static boolean removeAllImpl(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return removeOccurrences(multiset, (Multiset<?>) (Multiset) iterable);
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        boolean z11 = false;
        for (Object remove : iterable) {
            z11 |= multiset.remove(remove);
        }
        return z11;
    }

    public static boolean retainAllImpl(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean retainOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        return retainOccurrencesImpl(multiset, multiset2);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        java.util.Iterator<Multiset.Entry<E>> it = multiset.entrySet().iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            Multiset.Entry next = it.next();
            int count = multiset2.count(next.getElement());
            if (count == 0) {
                it.remove();
            } else if (count < next.getCount()) {
                multiset.setCount(next.getElement(), count);
            }
            z11 = true;
        }
        return z11;
    }

    public static <E> int setCountImpl(Multiset<E> multiset, @ParametricNullness E e11, int i11) {
        CollectPreconditions.checkNonnegative(i11, "count");
        int count = multiset.count(e11);
        int i12 = i11 - count;
        if (i12 > 0) {
            multiset.add(e11, i12);
        } else if (i12 < 0) {
            multiset.remove(e11, -i12);
        }
        return count;
    }

    public static <E> Multiset<E> sum(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return Multiset.this.contains(obj) || multiset2.contains(obj);
            }

            public int count(@CheckForNull Object obj) {
                return Multiset.this.count(obj) + multiset2.count(obj);
            }

            public Set<E> createElementSet() {
                return Sets.union(Multiset.this.elementSet(), multiset2.elementSet());
            }

            public java.util.Iterator<E> elementIterator() {
                throw new AssertionError("should never be called");
            }

            public java.util.Iterator<Multiset.Entry<E>> entryIterator() {
                final java.util.Iterator it = Multiset.this.entrySet().iterator();
                final java.util.Iterator it2 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    @CheckForNull
                    public Multiset.Entry<E> computeNext() {
                        if (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            return Multisets.immutableEntry(element, entry.getCount() + multiset2.count(element));
                        }
                        while (it2.hasNext()) {
                            Multiset.Entry entry2 = (Multiset.Entry) it2.next();
                            Object element2 = entry2.getElement();
                            if (!Multiset.this.contains(element2)) {
                                return Multisets.immutableEntry(element2, entry2.getCount());
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }

            public boolean isEmpty() {
                return Multiset.this.isEmpty() && multiset2.isEmpty();
            }

            public int size() {
                return IntMath.saturatedAdd(Multiset.this.size(), multiset2.size());
            }
        };
    }

    public static <E> Multiset<E> union(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new ViewMultiset<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return Multiset.this.contains(obj) || multiset2.contains(obj);
            }

            public int count(@CheckForNull Object obj) {
                return Math.max(Multiset.this.count(obj), multiset2.count(obj));
            }

            public Set<E> createElementSet() {
                return Sets.union(Multiset.this.elementSet(), multiset2.elementSet());
            }

            public java.util.Iterator<E> elementIterator() {
                throw new AssertionError("should never be called");
            }

            public java.util.Iterator<Multiset.Entry<E>> entryIterator() {
                final java.util.Iterator it = Multiset.this.entrySet().iterator();
                final java.util.Iterator it2 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    @CheckForNull
                    public Multiset.Entry<E> computeNext() {
                        if (it.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it.next();
                            Object element = entry.getElement();
                            return Multisets.immutableEntry(element, Math.max(entry.getCount(), multiset2.count(element)));
                        }
                        while (it2.hasNext()) {
                            Multiset.Entry entry2 = (Multiset.Entry) it2.next();
                            Object element2 = entry2.getElement();
                            if (!Multiset.this.contains(element2)) {
                                return Multisets.immutableEntry(element2, entry2.getCount());
                            }
                        }
                        return (Multiset.Entry) endOfData();
                    }
                };
            }

            public boolean isEmpty() {
                return Multiset.this.isEmpty() && multiset2.isEmpty();
            }
        };
    }

    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) Preconditions.checkNotNull(multiset));
    }

    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.checkNotNull(sortedMultiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> immutableMultiset) {
        return (Multiset) Preconditions.checkNotNull(immutableMultiset);
    }

    public static <E> boolean setCountImpl(Multiset<E> multiset, @ParametricNullness E e11, int i11, int i12) {
        CollectPreconditions.checkNonnegative(i11, "oldCount");
        CollectPreconditions.checkNonnegative(i12, "newCount");
        if (multiset.count(e11) != i11) {
            return false;
        }
        multiset.setCount(e11, i12);
        return true;
    }

    private static <E> boolean addAllImpl(Multiset<E> multiset, Multiset<? extends E> multiset2) {
        if (multiset2 instanceof AbstractMapBasedMultiset) {
            return addAllImpl(multiset, (AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry next : multiset2.entrySet()) {
            multiset.add(next.getElement(), next.getCount());
        }
        return true;
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        java.util.Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            Multiset.Entry next = it.next();
            int count = multiset2.count(next.getElement());
            if (count >= next.getCount()) {
                it.remove();
            } else if (count > 0) {
                multiset.remove(next.getElement(), count);
            }
            z11 = true;
        }
        return z11;
    }

    private static <E> boolean addAllImpl(Multiset<E> multiset, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(multiset);
        return true;
    }
}
