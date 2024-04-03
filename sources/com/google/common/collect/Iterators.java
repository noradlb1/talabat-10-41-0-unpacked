package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Iterators {

    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        static final UnmodifiableListIterator<Object> EMPTY = new ArrayItr(new Object[0], 0, 0, 0);
        private final T[] array;
        private final int offset;

        public ArrayItr(T[] tArr, int i11, int i12, int i13) {
            super(i12, i13);
            this.array = tArr;
            this.offset = i11;
        }

        @ParametricNullness
        public T get(int i11) {
            return this.array[this.offset + i11];
        }
    }

    public static class ConcatenatedIterator<T> implements Iterator<T>, j$.util.Iterator {
        private Iterator<? extends T> iterator = Iterators.emptyIterator();
        @CheckForNull
        private Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;
        @CheckForNull
        private Iterator<? extends T> toRemove;
        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> topMetaIterator;

        public ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it) {
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(it);
        }

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.topMetaIterator;
                if (it != null && it.hasNext()) {
                    return this.topMetaIterator;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.metaIterators;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.topMetaIterator = this.metaIterators.removeFirst();
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            while (!((java.util.Iterator) Preconditions.checkNotNull(this.iterator)).hasNext()) {
                java.util.Iterator<? extends java.util.Iterator<? extends T>> topMetaIterator2 = getTopMetaIterator();
                this.topMetaIterator = topMetaIterator2;
                if (topMetaIterator2 == null) {
                    return false;
                }
                java.util.Iterator<? extends T> it = (java.util.Iterator) topMetaIterator2.next();
                this.iterator = it;
                if (it instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) it;
                    this.iterator = concatenatedIterator.iterator;
                    if (this.metaIterators == null) {
                        this.metaIterators = new ArrayDeque();
                    }
                    this.metaIterators.addFirst(this.topMetaIterator);
                    if (concatenatedIterator.metaIterators != null) {
                        while (!concatenatedIterator.metaIterators.isEmpty()) {
                            this.metaIterators.addFirst(concatenatedIterator.metaIterators.removeLast());
                        }
                    }
                    this.topMetaIterator = concatenatedIterator.topMetaIterator;
                }
            }
            return true;
        }

        @ParametricNullness
        public T next() {
            if (hasNext()) {
                java.util.Iterator<? extends T> it = this.iterator;
                this.toRemove = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            java.util.Iterator<? extends T> it = this.toRemove;
            if (it != null) {
                it.remove();
                this.toRemove = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    public enum EmptyModifiableIterator implements java.util.Iterator<Object>, j$.util.Iterator {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    public static class MergingIterator<T> extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends java.util.Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.queue = new PriorityQueue(2, new c(comparator));
            for (java.util.Iterator it : iterable) {
                if (it.hasNext()) {
                    this.queue.add(Iterators.peekingIterator(it));
                }
            }
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @ParametricNullness
        public T next() {
            PeekingIterator remove = this.queue.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.queue.add(remove);
            }
            return next;
        }
    }

    public static class PeekingImpl<E> implements PeekingIterator<E>, j$.util.Iterator {
        private boolean hasPeeked;
        private final java.util.Iterator<? extends E> iterator;
        @CheckForNull
        private E peekedElement;

        public PeekingImpl(java.util.Iterator<? extends E> it) {
            this.iterator = (java.util.Iterator) Preconditions.checkNotNull(it);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        @ParametricNullness
        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.peekedElement);
            this.hasPeeked = false;
            this.peekedElement = null;
            return uncheckedCastNullableTToT;
        }

        @ParametricNullness
        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return NullnessCasts.uncheckedCastNullableTToT(this.peekedElement);
        }

        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }
    }

    private Iterators() {
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, java.util.Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= collection.add(it.next());
        }
        return z11;
    }

    @CanIgnoreReturnValue
    public static int advance(java.util.Iterator<?> it, int i11) {
        boolean z11;
        Preconditions.checkNotNull(it);
        int i12 = 0;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "numberToAdvance must be nonnegative");
        while (i12 < i11 && it.hasNext()) {
            it.next();
            i12++;
        }
        return i12;
    }

    public static <T> boolean all(java.util.Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(java.util.Iterator<T> it, Predicate<? super T> predicate) {
        return indexOf(it, predicate) != -1;
    }

    public static <T> Enumeration<T> asEnumeration(final java.util.Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new Enumeration<T>() {
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @ParametricNullness
            public T nextElement() {
                return it.next();
            }
        };
    }

    public static <T> ListIterator<T> cast(java.util.Iterator<T> it) {
        return (ListIterator) it;
    }

    public static void checkNonnegative(int i11) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("position (" + i11 + ") must not be negative");
        }
    }

    public static void clear(java.util.Iterator<?> it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T> it, java.util.Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        return concat(consumingForArray(it, it2));
    }

    public static <T> java.util.Iterator<T> concatNoDefensiveCopy(java.util.Iterator<? extends T>... itArr) {
        for (java.util.Iterator checkNotNull : (java.util.Iterator[]) Preconditions.checkNotNull(itArr)) {
            Preconditions.checkNotNull(checkNotNull);
        }
        return concat(consumingForArray(itArr));
    }

    private static <I extends java.util.Iterator<?>> java.util.Iterator<I> consumingForArray(final I... iArr) {
        return new UnmodifiableIterator<I>() {
            int index = 0;

            public boolean hasNext() {
                return this.index < iArr.length;
            }

            public I next() {
                if (hasNext()) {
                    I i11 = iArr[this.index];
                    Objects.requireNonNull(i11);
                    I i12 = (java.util.Iterator) i11;
                    java.util.Iterator[] itArr = iArr;
                    int i13 = this.index;
                    itArr[i13] = null;
                    this.index = i13 + 1;
                    return i12;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> java.util.Iterator<T> consumingIterator(final java.util.Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            @ParametricNullness
            public T next() {
                T next = it.next();
                it.remove();
                return next;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean contains(java.util.Iterator<?> it, @CheckForNull Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> java.util.Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Object() {
            java.util.Iterator<T> iterator = Iterators.emptyModifiableIterator();

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.iterator.hasNext() || iterable.iterator().hasNext();
            }

            @ParametricNullness
            public T next() {
                if (!this.iterator.hasNext()) {
                    java.util.Iterator<T> it = iterable.iterator();
                    this.iterator = it;
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.iterator.next();
            }

            public void remove() {
                this.iterator.remove();
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean elementsEqual(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.equal(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.elementsEqual(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    public static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return ArrayItr.EMPTY;
    }

    public static <T> java.util.Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> filter(final java.util.Iterator<T> it, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>() {
            @CheckForNull
            public T computeNext() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        };
    }

    @ParametricNullness
    public static <T> T find(java.util.Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        return forArray(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @ParametricNullness
            public T next() {
                return enumeration.nextElement();
            }
        };
    }

    public static int frequency(java.util.Iterator<?> it, @CheckForNull Object obj) {
        int i11 = 0;
        while (contains(it, obj)) {
            i11++;
        }
        return i11;
    }

    @ParametricNullness
    public static <T> T get(java.util.Iterator<T> it, int i11) {
        checkNonnegative(i11);
        int advance = advance(it, i11);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException("position (" + i11 + ") must be less than the number of elements that remained (" + advance + ")");
    }

    @ParametricNullness
    public static <T> T getLast(java.util.Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @ParametricNullness
    public static <T> T getNext(java.util.Iterator<? extends T> it, @ParametricNullness T t11) {
        return it.hasNext() ? it.next() : t11;
    }

    @ParametricNullness
    public static <T> T getOnlyElement(java.util.Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i11 = 0; i11 < 4 && it.hasNext(); i11++) {
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(it.next());
        }
        if (it.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append(Typography.greater);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static <T> int indexOf(java.util.Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i11 = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static <T> java.util.Iterator<T> limit(final java.util.Iterator<T> it, final int i11) {
        boolean z11;
        Preconditions.checkNotNull(it);
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "limit is negative");
        return new Object() {
            private int count;

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.count < i11 && it.hasNext();
            }

            @ParametricNullness
            public T next() {
                if (hasNext()) {
                    this.count++;
                    return it.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                it.remove();
            }
        };
    }

    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends java.util.Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(java.util.Iterator<T> it, int i11) {
        return partitionImpl(it, i11, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(java.util.Iterator<T> it, int i11) {
        return partitionImpl(it, i11, false);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final java.util.Iterator<T> it, final int i11, final boolean z11) {
        boolean z12;
        Preconditions.checkNotNull(it);
        if (i11 > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        return new UnmodifiableIterator<List<T>>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public List<T> next() {
                if (hasNext()) {
                    Object[] objArr = new Object[i11];
                    int i11 = 0;
                    while (i11 < i11 && it.hasNext()) {
                        objArr[i11] = it.next();
                        i11++;
                    }
                    for (int i12 = i11; i12 < i11; i12++) {
                        objArr[i12] = null;
                    }
                    List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                    return (z11 || i11 == i11) ? unmodifiableList : unmodifiableList.subList(0, i11);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> PeekingIterator<T> peekingIterator(java.util.Iterator<? extends T> it) {
        if (it instanceof PeekingImpl) {
            return (PeekingImpl) it;
        }
        return new PeekingImpl(it);
    }

    @CheckForNull
    public static <T> T pollNext(java.util.Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(java.util.Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(java.util.Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z11 = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(java.util.Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@ParametricNullness final T t11) {
        return new UnmodifiableIterator<T>() {
            boolean done;

            public boolean hasNext() {
                return !this.done;
            }

            @ParametricNullness
            public T next() {
                if (!this.done) {
                    this.done = true;
                    return t11;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static int size(java.util.Iterator<?> it) {
        long j11 = 0;
        while (it.hasNext()) {
            it.next();
            j11++;
        }
        return Ints.saturatedCast(j11);
    }

    @GwtIncompatible
    public static <T> T[] toArray(java.util.Iterator<? extends T> it, Class<T> cls) {
        return Iterables.toArray(Lists.newArrayList(it), cls);
    }

    public static String toString(java.util.Iterator<?> it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        while (it.hasNext()) {
            if (!z11) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(it.next());
            z11 = false;
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public static <F, T> java.util.Iterator<T> transform(java.util.Iterator<F> it, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(it) {
            @ParametricNullness
            public T transform(@ParametricNullness F f11) {
                return function.apply(f11);
            }
        };
    }

    public static <T> Optional<T> tryFind(java.util.Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final java.util.Iterator<? extends T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            @ParametricNullness
            public T next() {
                return it.next();
            }
        };
    }

    public static <T> UnmodifiableListIterator<T> forArray(T[] tArr, int i11, int i12, int i13) {
        Preconditions.checkArgument(i12 >= 0);
        Preconditions.checkPositionIndexes(i11, i11 + i12, tArr.length);
        Preconditions.checkPositionIndex(i13, i12);
        if (i12 == 0) {
            return emptyListIterator();
        }
        return new ArrayItr(tArr, i11, i12, i13);
    }

    @SafeVarargs
    public static <T> java.util.Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList((E[]) tArr));
    }

    @ParametricNullness
    public static <T> T getLast(java.util.Iterator<? extends T> it, @ParametricNullness T t11) {
        return it.hasNext() ? getLast(it) : t11;
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T> it, java.util.Iterator<? extends T> it2, java.util.Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(consumingForArray(it, it2, it3));
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(java.util.Iterator<?> it, Class<T> cls) {
        return filter(it, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    @ParametricNullness
    public static <T> T get(java.util.Iterator<? extends T> it, int i11, @ParametricNullness T t11) {
        checkNonnegative(i11);
        advance(it, i11);
        return getNext(it, t11);
    }

    @CheckForNull
    public static <T> T find(java.util.Iterator<? extends T> it, Predicate<? super T> predicate, @CheckForNull T t11) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t11;
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T> it, java.util.Iterator<? extends T> it2, java.util.Iterator<? extends T> it3, java.util.Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(consumingForArray(it, it2, it3, it4));
    }

    @ParametricNullness
    public static <T> T getOnlyElement(java.util.Iterator<? extends T> it, @ParametricNullness T t11) {
        return it.hasNext() ? getOnlyElement(it) : t11;
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends T>... itArr) {
        return concatNoDefensiveCopy((java.util.Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> java.util.Iterator<T> concat(java.util.Iterator<? extends java.util.Iterator<? extends T>> it) {
        return new ConcatenatedIterator(it);
    }
}
