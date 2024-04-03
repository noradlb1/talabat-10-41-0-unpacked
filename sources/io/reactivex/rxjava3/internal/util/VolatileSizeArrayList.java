package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.annotations.NonNull;
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
    public final ArrayList<T> f23201b;

    public VolatileSizeArrayList() {
        this.f23201b = new ArrayList<>();
    }

    public boolean add(T t11) {
        boolean add = this.f23201b.add(t11);
        lazySet(this.f23201b.size());
        return add;
    }

    public boolean addAll(@NonNull Collection<? extends T> collection) {
        boolean addAll = this.f23201b.addAll(collection);
        lazySet(this.f23201b.size());
        return addAll;
    }

    public void clear() {
        this.f23201b.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.f23201b.contains(obj);
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f23201b.containsAll(collection);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.f23201b.equals(((VolatileSizeArrayList) obj).f23201b);
        }
        return this.f23201b.equals(obj);
    }

    public T get(int i11) {
        return this.f23201b.get(i11);
    }

    public int hashCode() {
        return this.f23201b.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f23201b.indexOf(obj);
    }

    public boolean isEmpty() {
        return get() == 0;
    }

    public Iterator<T> iterator() {
        return this.f23201b.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f23201b.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.f23201b.listIterator();
    }

    public boolean remove(Object obj) {
        boolean remove = this.f23201b.remove(obj);
        lazySet(this.f23201b.size());
        return remove;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean removeAll = this.f23201b.removeAll(collection);
        lazySet(this.f23201b.size());
        return removeAll;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean retainAll = this.f23201b.retainAll(collection);
        lazySet(this.f23201b.size());
        return retainAll;
    }

    public T set(int i11, T t11) {
        return this.f23201b.set(i11, t11);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i11, int i12) {
        return this.f23201b.subList(i11, i12);
    }

    public Object[] toArray() {
        return this.f23201b.toArray();
    }

    public String toString() {
        return this.f23201b.toString();
    }

    public ListIterator<T> listIterator(int i11) {
        return this.f23201b.listIterator(i11);
    }

    public <E> E[] toArray(@NonNull E[] eArr) {
        return this.f23201b.toArray(eArr);
    }

    public VolatileSizeArrayList(int i11) {
        this.f23201b = new ArrayList<>(i11);
    }

    public void add(int i11, T t11) {
        this.f23201b.add(i11, t11);
        lazySet(this.f23201b.size());
    }

    public boolean addAll(int i11, @NonNull Collection<? extends T> collection) {
        boolean addAll = this.f23201b.addAll(i11, collection);
        lazySet(this.f23201b.size());
        return addAll;
    }

    public T remove(int i11) {
        T remove = this.f23201b.remove(i11);
        lazySet(this.f23201b.size());
        return remove;
    }
}
