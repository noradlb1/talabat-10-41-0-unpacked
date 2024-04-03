package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableList.of or another implementation")
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    public static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] contents;
        boolean forceCopy;
        int size = 0;

        public ArrayBasedBuilder(int i11) {
            CollectPreconditions.checkNonnegative(i11, "initialCapacity");
            this.contents = new Object[i11];
        }

        private void getReadyToExpandTo(int i11) {
            Object[] objArr = this.contents;
            if (objArr.length < i11) {
                this.contents = Arrays.copyOf(objArr, Builder.expandedCapacity(objArr.length, i11));
                this.forceCopy = false;
            } else if (this.forceCopy) {
                this.contents = (Object[]) objArr.clone();
                this.forceCopy = false;
            }
        }

        public final void addAll(Object[] objArr, int i11) {
            ObjectArrays.checkElementsNotNull(objArr, i11);
            getReadyToExpandTo(this.size + i11);
            System.arraycopy(objArr, 0, this.contents, this.size, i11);
            this.size += i11;
        }

        @CanIgnoreReturnValue
        public ArrayBasedBuilder<E> add(E e11) {
            Preconditions.checkNotNull(e11);
            getReadyToExpandTo(this.size + 1);
            Object[] objArr = this.contents;
            int i11 = this.size;
            this.size = i11 + 1;
            objArr[i11] = e11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            addAll(eArr, eArr.length);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                getReadyToExpandTo(this.size + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.size = ((ImmutableCollection) collection).copyIntoArray(this.contents, this.size);
                    return this;
                }
            }
            super.addAll(iterable);
            return this;
        }
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] objArr, int i11) {
        UnmodifiableIterator it = iterator();
        while (it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return i11;
    }

    @CheckForNull
    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

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

    @J2ktIncompatible
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @DoNotMock
    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        public static int expandedCapacity(int i11, int i12) {
            if (i12 >= 0) {
                int i13 = i11 + (i11 >> 1) + 1;
                if (i13 < i12) {
                    i13 = Integer.highestOneBit(i12 - 1) << 1;
                }
                if (i13 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i13;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CanIgnoreReturnValue
        public abstract Builder<E> add(E e11);

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E add : eArr) {
                add(add);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            for (Object add : iterable) {
                add(add);
            }
            return this;
        }

        public abstract ImmutableCollection<E> build();

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add(it.next());
            }
            return this;
        }
    }

    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return Platform.copy(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
