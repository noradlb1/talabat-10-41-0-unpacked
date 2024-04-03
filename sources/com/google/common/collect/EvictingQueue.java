package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    @VisibleForTesting
    final int maxSize;

    private EvictingQueue(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "maxSize (%s) must >= 0", i11);
        this.delegate = new ArrayDeque(i11);
        this.maxSize = i11;
    }

    public static <E> EvictingQueue<E> create(int i11) {
        return new EvictingQueue<>(i11);
    }

    @CanIgnoreReturnValue
    public boolean add(E e11) {
        Preconditions.checkNotNull(e11);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e11);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return Iterables.addAll(this, Iterables.skip(collection, size - this.maxSize));
    }

    @CanIgnoreReturnValue
    public boolean offer(E e11) {
        return add(e11);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @J2ktIncompatible
    public Object[] toArray() {
        return super.toArray();
    }

    public Queue<E> delegate() {
        return this.delegate;
    }
}
