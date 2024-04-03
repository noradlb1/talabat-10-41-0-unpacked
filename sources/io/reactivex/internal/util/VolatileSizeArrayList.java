package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<T> f18640b;

    public VolatileSizeArrayList() {
        this.f18640b = new ArrayList<>();
    }

    public boolean add(T t11) {
        boolean add = this.f18640b.add(t11);
        lazySet(this.f18640b.size());
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.f18640b.addAll(collection);
        lazySet(this.f18640b.size());
        return addAll;
    }

    public void clear() {
        this.f18640b.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.f18640b.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f18640b.containsAll(collection);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.f18640b.equals(((VolatileSizeArrayList) obj).f18640b);
        }
        return this.f18640b.equals(obj);
    }

    public T get(int i11) {
        return this.f18640b.get(i11);
    }

    public int hashCode() {
        return this.f18640b.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f18640b.indexOf(obj);
    }

    public boolean isEmpty() {
        return get() == 0;
    }

    public Iterator<T> iterator() {
        return this.f18640b.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f18640b.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.f18640b.listIterator();
    }

    public boolean remove(Object obj) {
        boolean remove = this.f18640b.remove(obj);
        lazySet(this.f18640b.size());
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.f18640b.removeAll(collection);
        lazySet(this.f18640b.size());
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.f18640b.retainAll(collection);
        lazySet(this.f18640b.size());
        return retainAll;
    }

    public T set(int i11, T t11) {
        return this.f18640b.set(i11, t11);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i11, int i12) {
        return this.f18640b.subList(i11, i12);
    }

    public Object[] toArray() {
        return this.f18640b.toArray();
    }

    public String toString() {
        return this.f18640b.toString();
    }

    public ListIterator<T> listIterator(int i11) {
        return this.f18640b.listIterator(i11);
    }

    public <E> E[] toArray(E[] eArr) {
        return this.f18640b.toArray(eArr);
    }

    public VolatileSizeArrayList(int i11) {
        this.f18640b = new ArrayList<>(i11);
    }

    public void add(int i11, T t11) {
        this.f18640b.add(i11, t11);
        lazySet(this.f18640b.size());
    }

    public boolean addAll(int i11, Collection<? extends T> collection) {
        boolean addAll = this.f18640b.addAll(i11, collection);
        lazySet(this.f18640b.size());
        return addAll;
    }

    public T remove(int i11) {
        T remove = this.f18640b.remove(i11);
        lazySet(this.f18640b.size());
        return remove;
    }
}
