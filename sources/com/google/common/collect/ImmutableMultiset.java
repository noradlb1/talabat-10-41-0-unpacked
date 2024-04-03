package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> asList;
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        boolean buildInvoked;
        @CheckForNull
        ObjectCountHashMap<E> contents;
        boolean isLinkedHash;

        public Builder() {
            this(4);
        }

        @CheckForNull
        public static <T> ObjectCountHashMap<T> tryGetMap(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e11, int i11) {
            Objects.requireNonNull(this.contents);
            if (i11 == 0) {
                return this;
            }
            if (this.buildInvoked) {
                this.contents = new ObjectCountHashMap<>(this.contents);
                this.isLinkedHash = false;
            }
            this.buildInvoked = false;
            Preconditions.checkNotNull(e11);
            ObjectCountHashMap<E> objectCountHashMap = this.contents;
            objectCountHashMap.put(e11, i11 + objectCountHashMap.get(e11));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e11, int i11) {
            Objects.requireNonNull(this.contents);
            if (i11 == 0 && !this.isLinkedHash) {
                this.contents = new ObjectCountLinkedHashMap(this.contents);
                this.isLinkedHash = true;
            } else if (this.buildInvoked) {
                this.contents = new ObjectCountHashMap<>(this.contents);
                this.isLinkedHash = false;
            }
            this.buildInvoked = false;
            Preconditions.checkNotNull(e11);
            if (i11 == 0) {
                this.contents.remove(e11);
            } else {
                this.contents.put(Preconditions.checkNotNull(e11), i11);
            }
            return this;
        }

        public Builder(int i11) {
            this.buildInvoked = false;
            this.isLinkedHash = false;
            this.contents = ObjectCountHashMap.createWithExpectedSize(i11);
        }

        public ImmutableMultiset<E> build() {
            Objects.requireNonNull(this.contents);
            if (this.contents.size() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.isLinkedHash) {
                this.contents = new ObjectCountHashMap<>(this.contents);
                this.isLinkedHash = false;
            }
            this.buildInvoked = true;
            return new RegularImmutableMultiset(this.contents);
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e11) {
            return addCopies(e11, 1);
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.contents);
            if (iterable instanceof Multiset) {
                Multiset<? extends E> cast = Multisets.cast(iterable);
                ObjectCountHashMap<T> tryGetMap = tryGetMap(cast);
                if (tryGetMap != null) {
                    ObjectCountHashMap<E> objectCountHashMap = this.contents;
                    objectCountHashMap.ensureCapacity(Math.max(objectCountHashMap.size(), tryGetMap.size()));
                    for (int firstIndex = tryGetMap.firstIndex(); firstIndex >= 0; firstIndex = tryGetMap.nextIndex(firstIndex)) {
                        addCopies(tryGetMap.getKey(firstIndex), tryGetMap.getValue(firstIndex));
                    }
                } else {
                    Set<Multiset.Entry<? extends E>> entrySet = cast.entrySet();
                    ObjectCountHashMap<E> objectCountHashMap2 = this.contents;
                    objectCountHashMap2.ensureCapacity(Math.max(objectCountHashMap2.size(), entrySet.size()));
                    for (Multiset.Entry next : cast.entrySet()) {
                        addCopies(next.getElement(), next.getCount());
                    }
                }
            } else {
                super.addAll(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add(eArr);
            return this;
        }

        public Builder(boolean z11) {
            this.buildInvoked = false;
            this.isLinkedHash = false;
            this.contents = null;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll(it);
            return this;
        }
    }

    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        @J2ktIncompatible
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @GwtIncompatible
        @J2ktIncompatible
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        public Multiset.Entry<E> get(int i11) {
            return ImmutableMultiset.this.getEntry(i11);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new Builder().add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Builder builder = new Builder(collection.size());
        for (Multiset.Entry entry : collection) {
            builder.addCopies(entry.getElement(), entry.getCount());
        }
        return builder.build();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet();
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int add(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList2 = super.asList();
        this.asList = asList2;
        return asList2;
    }

    public boolean contains(@CheckForNull Object obj) {
        return count(obj) > 0;
    }

    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i11) {
        UnmodifiableIterator it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            Arrays.fill(objArr, i11, entry.getCount() + i11, entry.getElement());
            i11 += entry.getCount();
        }
        return i11;
    }

    public abstract ImmutableSet<E> elementSet();

    public boolean equals(@CheckForNull Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    public abstract Multiset.Entry<E> getEntry(int i11);

    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int remove(@CheckForNull Object obj, int i11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int setCount(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return entrySet().toString();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(Multisets.inferDistinctElements(iterable));
        builder.addAll((Iterable) iterable);
        return builder.build();
    }

    public static <E> ImmutableMultiset<E> of(E e11) {
        return copyFromElements(e11);
    }

    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<E>(this) {
            @CheckForNull
            E element;
            int remaining;

            public boolean hasNext() {
                return this.remaining > 0 || it.hasNext();
            }

            public E next() {
                if (this.remaining <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) it.next();
                    this.element = entry.getElement();
                    this.remaining = entry.getCount();
                }
                this.remaining--;
                E e11 = this.element;
                Objects.requireNonNull(e11);
                return e11;
            }
        };
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean setCount(E e11, int i11, int i12) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12) {
        return copyFromElements(e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13) {
        return copyFromElements(e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14) {
        return copyFromElements(e11, e12, e13, e14);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15) {
        return copyFromElements(e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableMultiset<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        return new Builder().add((Object) e11).add((Object) e12).add((Object) e13).add((Object) e14).add((Object) e15).add((Object) e16).add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new Builder().addAll((Iterator) it).build();
    }
}
