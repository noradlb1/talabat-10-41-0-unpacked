package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    public void addFirst(@ParametricNullness E e11) {
        delegate().addFirst(e11);
    }

    public void addLast(@ParametricNullness E e11) {
        delegate().addLast(e11);
    }

    public abstract Deque<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @ParametricNullness
    public E getFirst() {
        return delegate().getFirst();
    }

    @ParametricNullness
    public E getLast() {
        return delegate().getLast();
    }

    @CanIgnoreReturnValue
    public boolean offerFirst(@ParametricNullness E e11) {
        return delegate().offerFirst(e11);
    }

    @CanIgnoreReturnValue
    public boolean offerLast(@ParametricNullness E e11) {
        return delegate().offerLast(e11);
    }

    @CheckForNull
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @CheckForNull
    public E peekLast() {
        return delegate().peekLast();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    public void push(@ParametricNullness E e11) {
        delegate().push(e11);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(@CheckForNull Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(@CheckForNull Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
