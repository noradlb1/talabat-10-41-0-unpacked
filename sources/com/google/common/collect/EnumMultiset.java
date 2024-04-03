package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient int[] counts;
    private transient int distinctElements;
    /* access modifiers changed from: private */
    public transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    public abstract class Itr<T> implements Iterator<T>, j$.util.Iterator {
        int index = 0;
        int toRemove = -1;

        public Itr() {
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            while (this.index < EnumMultiset.this.enumConstants.length) {
                int[] access$100 = EnumMultiset.this.counts;
                int i11 = this.index;
                if (access$100[i11] > 0) {
                    return true;
                }
                this.index = i11 + 1;
            }
            return false;
        }

        public T next() {
            if (hasNext()) {
                T output = output(this.index);
                int i11 = this.index;
                this.toRemove = i11;
                this.index = i11 + 1;
                return output;
            }
            throw new NoSuchElementException();
        }

        public abstract T output(int i11);

        public void remove() {
            boolean z11;
            if (this.toRemove >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            CollectPreconditions.checkRemove(z11);
            if (EnumMultiset.this.counts[this.toRemove] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset enumMultiset = EnumMultiset.this;
                EnumMultiset.access$322(enumMultiset, (long) enumMultiset.counts[this.toRemove]);
                EnumMultiset.this.counts[this.toRemove] = 0;
            }
            this.toRemove = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.enumConstants = eArr;
        this.counts = new int[eArr.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i11 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i11 - 1;
        return i11;
    }

    public static /* synthetic */ long access$322(EnumMultiset enumMultiset, long j11) {
        long j12 = enumMultiset.size - j11;
        enumMultiset.size = j12;
        return j12;
    }

    private void checkIsE(Object obj) {
        Preconditions.checkNotNull(obj);
        if (!isActuallyE(obj)) {
            throw new ClassCastException("Expected an " + this.type + " but got " + obj);
        }
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(@CheckForNull Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        E e11 = (Enum) obj;
        int ordinal = e11.ordinal();
        E[] eArr = this.enumConstants;
        if (ordinal >= eArr.length || eArr[ordinal] != e11) {
            return false;
        }
        return true;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.enumConstants = eArr;
        this.counts = new int[eArr.length];
        Serialization.populateMultiset(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    public int count(@CheckForNull Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    public int distinctElements() {
        return this.distinctElements;
    }

    public java.util.Iterator<E> elementIterator() {
        return new EnumMultiset<E>.Itr<E>() {
            public E output(int i11) {
                return EnumMultiset.this.enumConstants[i11];
            }
        };
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public java.util.Iterator<Multiset.Entry<E>> entryIterator() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> output(final int i11) {
                return new Multisets.AbstractEntry<E>() {
                    public int getCount() {
                        return EnumMultiset.this.counts[i11];
                    }

                    public E getElement() {
                        return EnumMultiset.this.enumConstants[i11];
                    }
                };
            }
        };
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public java.util.Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i11) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum enumR = (Enum) obj;
        CollectPreconditions.checkNonnegative(i11, "occurrences");
        if (i11 == 0) {
            return count(obj);
        }
        int ordinal = enumR.ordinal();
        int[] iArr = this.counts;
        int i12 = iArr[ordinal];
        if (i12 == 0) {
            return 0;
        }
        if (i12 <= i11) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= (long) i12;
        } else {
            iArr[ordinal] = i12 - i11;
            this.size -= (long) i11;
        }
        return i12;
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        java.util.Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(((Enum) it.next()).getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    @CanIgnoreReturnValue
    public int add(E e11, int i11) {
        checkIsE(e11);
        CollectPreconditions.checkNonnegative(i11, "occurrences");
        if (i11 == 0) {
            return count(e11);
        }
        int ordinal = e11.ordinal();
        int i12 = this.counts[ordinal];
        long j11 = (long) i11;
        long j12 = ((long) i12) + j11;
        Preconditions.checkArgument(j12 <= 2147483647L, "too many occurrences: %s", j12);
        this.counts[ordinal] = (int) j12;
        if (i12 == 0) {
            this.distinctElements++;
        }
        this.size += j11;
        return i12;
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean setCount(@ParametricNullness Object obj, int i11, int i12) {
        return super.setCount(obj, i11, i12);
    }

    @CanIgnoreReturnValue
    public int setCount(E e11, int i11) {
        checkIsE(e11);
        CollectPreconditions.checkNonnegative(i11, "count");
        int ordinal = e11.ordinal();
        int[] iArr = this.counts;
        int i12 = iArr[ordinal];
        iArr[ordinal] = i11;
        this.size += (long) (i11 - i12);
        if (i12 == 0 && i11 > 0) {
            this.distinctElements++;
        } else if (i12 > 0 && i11 == 0) {
            this.distinctElements--;
        }
        return i12;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }
}
