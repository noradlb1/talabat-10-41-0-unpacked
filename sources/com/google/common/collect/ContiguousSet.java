package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Objects;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i11, int i12) {
        return create(Range.closed(Integer.valueOf(i11), Integer.valueOf(i12)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Integer> closedOpen(int i11, int i12) {
        return create(Range.closedOpen(Integer.valueOf(i11), Integer.valueOf(i12)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Range<C> range2;
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            if (!range.hasLowerBound()) {
                range2 = range.intersection(Range.atLeast(discreteDomain.minValue()));
            } else {
                range2 = range;
            }
            if (!range.hasUpperBound()) {
                range2 = range2.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            boolean z11 = true;
            if (!range2.isEmpty()) {
                C leastValueAbove = range.lowerBound.leastValueAbove(discreteDomain);
                Objects.requireNonNull(leastValueAbove);
                C greatestValueBelow = range.upperBound.greatestValueBelow(discreteDomain);
                Objects.requireNonNull(greatestValueBelow);
                if (Range.compareOrThrow((Comparable) leastValueAbove, (Comparable) greatestValueBelow) <= 0) {
                    z11 = false;
                }
            }
            if (z11) {
                return new EmptyContiguousSet(discreteDomain);
            }
            return new RegularContiguousSet(range2, discreteDomain);
        } catch (NoSuchElementException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @GwtIncompatible
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    public abstract ContiguousSet<C> headSetImpl(C c11, boolean z11);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    public abstract ContiguousSet<C> subSetImpl(C c11, boolean z11, C c12, boolean z12);

    public abstract ContiguousSet<C> tailSetImpl(C c11, boolean z11);

    public String toString() {
        return range().toString();
    }

    public static ContiguousSet<Long> closed(long j11, long j12) {
        return create(Range.closed(Long.valueOf(j11), Long.valueOf(j12)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Long> closedOpen(long j11, long j12) {
        return create(Range.closedOpen(Long.valueOf(j11), Long.valueOf(j12)), DiscreteDomain.longs());
    }

    public ContiguousSet<C> headSet(C c11) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c11), false);
    }

    public ContiguousSet<C> subSet(C c11, C c12) {
        Preconditions.checkNotNull(c11);
        Preconditions.checkNotNull(c12);
        Preconditions.checkArgument(comparator().compare(c11, c12) <= 0);
        return subSetImpl(c11, true, c12, false);
    }

    public ContiguousSet<C> tailSet(C c11) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c11), true);
    }

    @GwtIncompatible
    public ContiguousSet<C> headSet(C c11, boolean z11) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c11), z11);
    }

    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c11, boolean z11) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c11), z11);
    }

    @GwtIncompatible
    public ContiguousSet<C> subSet(C c11, boolean z11, C c12, boolean z12) {
        Preconditions.checkNotNull(c11);
        Preconditions.checkNotNull(c12);
        Preconditions.checkArgument(comparator().compare(c11, c12) <= 0);
        return subSetImpl(c11, z11, c12, z12);
    }
}
