package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    @CheckForNull
    public E ceiling(@ParametricNullness E e11) {
        return delegate().ceiling(e11);
    }

    public abstract NavigableSet<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @CheckForNull
    public E floor(@ParametricNullness E e11) {
        return delegate().floor(e11);
    }

    public NavigableSet<E> headSet(@ParametricNullness E e11, boolean z11) {
        return delegate().headSet(e11, z11);
    }

    @CheckForNull
    public E higher(@ParametricNullness E e11) {
        return delegate().higher(e11);
    }

    @CheckForNull
    public E lower(@ParametricNullness E e11) {
        return delegate().lower(e11);
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @CheckForNull
    public E standardCeiling(@ParametricNullness E e11) {
        return Iterators.getNext(tailSet(e11, true).iterator(), null);
    }

    @ParametricNullness
    public E standardFirst() {
        return iterator().next();
    }

    @CheckForNull
    public E standardFloor(@ParametricNullness E e11) {
        return Iterators.getNext(headSet(e11, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(@ParametricNullness E e11) {
        return headSet(e11, false);
    }

    @CheckForNull
    public E standardHigher(@ParametricNullness E e11) {
        return Iterators.getNext(tailSet(e11, false).iterator(), null);
    }

    @ParametricNullness
    public E standardLast() {
        return descendingIterator().next();
    }

    @CheckForNull
    public E standardLower(@ParametricNullness E e11) {
        return Iterators.getNext(headSet(e11, false).descendingIterator(), null);
    }

    @CheckForNull
    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    @CheckForNull
    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    public NavigableSet<E> standardSubSet(@ParametricNullness E e11, boolean z11, @ParametricNullness E e12, boolean z12) {
        return tailSet(e11, z11).headSet(e12, z12);
    }

    public SortedSet<E> standardTailSet(@ParametricNullness E e11) {
        return tailSet(e11, true);
    }

    public NavigableSet<E> subSet(@ParametricNullness E e11, boolean z11, @ParametricNullness E e12, boolean z12) {
        return delegate().subSet(e11, z11, e12, z12);
    }

    public NavigableSet<E> tailSet(@ParametricNullness E e11, boolean z11) {
        return delegate().tailSet(e11, z11);
    }

    public SortedSet<E> standardSubSet(@ParametricNullness E e11, @ParametricNullness E e12) {
        return subSet(e11, true, e12, false);
    }
}
