package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public abstract SortedSet<E> delegate();

    @ParametricNullness
    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(@ParametricNullness E e11) {
        return delegate().headSet(e11);
    }

    @ParametricNullness
    public E last() {
        return delegate().last();
    }

    public boolean standardContains(@CheckForNull Object obj) {
        try {
            if (ForwardingSortedMap.unsafeCompare(comparator(), tailSet(obj).first(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public boolean standardRemove(@CheckForNull Object obj) {
        try {
            Iterator it = tailSet(obj).iterator();
            if (it.hasNext()) {
                if (ForwardingSortedMap.unsafeCompare(comparator(), it.next(), obj) == 0) {
                    it.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> standardSubSet(@ParametricNullness E e11, @ParametricNullness E e12) {
        return tailSet(e11).headSet(e12);
    }

    public SortedSet<E> subSet(@ParametricNullness E e11, @ParametricNullness E e12) {
        return delegate().subSet(e11, e12);
    }

    public SortedSet<E> tailSet(@ParametricNullness E e11) {
        return delegate().tailSet(e11);
    }
}
