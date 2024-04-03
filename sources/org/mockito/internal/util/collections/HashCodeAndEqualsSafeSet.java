package org.mockito.internal.util.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.mockito.internal.util.Checks;

public class HashCodeAndEqualsSafeSet implements Set<Object> {
    /* access modifiers changed from: private */
    public final HashSet<HashCodeAndEqualsMockWrapper> backingHashSet = new HashSet<>();

    private HashSet<HashCodeAndEqualsMockWrapper> asWrappedMocks(Collection<?> collection) {
        Checks.checkNotNull(collection, "Passed collection should notify() be null");
        HashSet<HashCodeAndEqualsMockWrapper> hashSet = new HashSet<>();
        for (Object of2 : collection) {
            hashSet.add(HashCodeAndEqualsMockWrapper.of(of2));
        }
        return hashSet;
    }

    public static HashCodeAndEqualsSafeSet of(Object... objArr) {
        return of((Iterable<Object>) Arrays.asList(objArr));
    }

    private <T> T[] unwrapTo(T[] tArr) {
        Iterator it = iterator();
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (it.hasNext()) {
                tArr[i11] = it.next();
            }
        }
        return tArr;
    }

    public boolean add(Object obj) {
        return this.backingHashSet.add(HashCodeAndEqualsMockWrapper.of(obj));
    }

    public boolean addAll(Collection<?> collection) {
        return this.backingHashSet.addAll(asWrappedMocks(collection));
    }

    public void clear() {
        this.backingHashSet.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public boolean contains(Object obj) {
        return this.backingHashSet.contains(HashCodeAndEqualsMockWrapper.of(obj));
    }

    public boolean containsAll(Collection<?> collection) {
        return this.backingHashSet.containsAll(asWrappedMocks(collection));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HashCodeAndEqualsSafeSet)) {
            return false;
        }
        return this.backingHashSet.equals(((HashCodeAndEqualsSafeSet) obj).backingHashSet);
    }

    public int hashCode() {
        return this.backingHashSet.hashCode();
    }

    public boolean isEmpty() {
        return this.backingHashSet.isEmpty();
    }

    public Iterator<Object> iterator() {
        return new Object() {
            private final Iterator<HashCodeAndEqualsMockWrapper> iterator;

            {
                this.iterator = HashCodeAndEqualsSafeSet.this.backingHashSet.iterator();
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            public Object next() {
                return this.iterator.next().get();
            }

            public void remove() {
                this.iterator.remove();
            }
        };
    }

    public boolean remove(Object obj) {
        return this.backingHashSet.remove(HashCodeAndEqualsMockWrapper.of(obj));
    }

    public boolean removeAll(Collection<?> collection) {
        return this.backingHashSet.removeAll(asWrappedMocks(collection));
    }

    public boolean retainAll(Collection<?> collection) {
        return this.backingHashSet.retainAll(asWrappedMocks(collection));
    }

    public int size() {
        return this.backingHashSet.size();
    }

    public Object[] toArray() {
        return unwrapTo(new Object[size()]);
    }

    public String toString() {
        return this.backingHashSet.toString();
    }

    public static HashCodeAndEqualsSafeSet of(Iterable<Object> iterable) {
        HashCodeAndEqualsSafeSet hashCodeAndEqualsSafeSet = new HashCodeAndEqualsSafeSet();
        if (iterable != null) {
            for (Object add : iterable) {
                hashCodeAndEqualsSafeSet.add(add);
            }
        }
        return hashCodeAndEqualsSafeSet;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < size()) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size());
        }
        return unwrapTo(tArr);
    }
}
