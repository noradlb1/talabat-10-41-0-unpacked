package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T nextOrNull;

    public AbstractSequentialIterator(@CheckForNull T t11) {
        this.nextOrNull = t11;
    }

    @CheckForNull
    public abstract T computeNext(T t11);

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        T t11 = this.nextOrNull;
        if (t11 != null) {
            this.nextOrNull = computeNext(t11);
            return t11;
        }
        throw new NoSuchElementException();
    }
}
