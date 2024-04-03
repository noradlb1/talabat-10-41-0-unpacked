package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    public abstract class Itr<T> implements Iterator<T>, j$.util.Iterator {
        int entryIndex;
        int expectedModCount;
        int toRemove = -1;

        public Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.entryIndex >= 0) {
                return true;
            }
            return false;
        }

        @ParametricNullness
        public T next() {
            if (hasNext()) {
                T result = result(this.entryIndex);
                int i11 = this.entryIndex;
                this.toRemove = i11;
                this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i11);
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z11;
            checkForConcurrentModification();
            if (this.toRemove != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            CollectPreconditions.checkRemove(z11);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        @ParametricNullness
        public abstract T result(int i11);
    }

    public AbstractMapBasedMultiset(int i11) {
        this.backingMap = newBackingMap(i11);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        this.backingMap = newBackingMap(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public final int add(@ParametricNullness E e11, int i11) {
        boolean z11;
        if (i11 == 0) {
            return count(e11);
        }
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "occurrences cannot be negative: %s", i11);
        int indexOf = this.backingMap.indexOf(e11);
        if (indexOf == -1) {
            this.backingMap.put(e11, i11);
            this.size += (long) i11;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j11 = (long) i11;
        long j12 = ((long) value) + j11;
        if (j12 > 2147483647L) {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "too many occurrences: %s", j12);
        this.backingMap.setValue(indexOf, (int) j12);
        this.size += j11;
        return value;
    }

    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    public final void clear() {
        this.backingMap.clear();
        this.size = 0;
    }

    public final int count(@CheckForNull Object obj) {
        return this.backingMap.get(obj);
    }

    public final int distinctElements() {
        return this.backingMap.size();
    }

    public final java.util.Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() {
            @ParametricNullness
            public E result(int i11) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i11);
            }
        };
    }

    public final java.util.Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> result(int i11) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i11);
            }
        };
    }

    public final java.util.Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public abstract ObjectCountHashMap<E> newBackingMap(int i11);

    @CanIgnoreReturnValue
    public final int remove(@CheckForNull Object obj, int i11) {
        boolean z11;
        if (i11 == 0) {
            return count(obj);
        }
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "occurrences cannot be negative: %s", i11);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i11) {
            this.backingMap.setValue(indexOf, value - i11);
        } else {
            this.backingMap.removeEntry(indexOf);
            i11 = value;
        }
        this.size -= (long) i11;
        return value;
    }

    @CanIgnoreReturnValue
    public final int setCount(@ParametricNullness E e11, int i11) {
        CollectPreconditions.checkNonnegative(i11, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i11 == 0 ? objectCountHashMap.remove(e11) : objectCountHashMap.put(e11, i11);
        this.size += (long) (i11 - remove);
        return remove;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    public final boolean setCount(@ParametricNullness E e11, int i11, int i12) {
        CollectPreconditions.checkNonnegative(i11, "oldCount");
        CollectPreconditions.checkNonnegative(i12, "newCount");
        int indexOf = this.backingMap.indexOf(e11);
        if (indexOf == -1) {
            if (i11 != 0) {
                return false;
            }
            if (i12 > 0) {
                this.backingMap.put(e11, i12);
                this.size += (long) i12;
            }
            return true;
        } else if (this.backingMap.getValue(indexOf) != i11) {
            return false;
        } else {
            if (i12 == 0) {
                this.backingMap.removeEntry(indexOf);
                this.size -= (long) i11;
            } else {
                this.backingMap.setValue(indexOf, i12);
                this.size += (long) (i12 - i11);
            }
            return true;
        }
    }
}
