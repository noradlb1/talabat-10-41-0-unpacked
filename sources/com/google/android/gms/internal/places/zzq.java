package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzq<E> extends AbstractList<E> implements zzbh<E> {
    private boolean zzdy = true;

    public boolean add(E e11) {
        zzac();
        return super.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzac();
        return super.addAll(collection);
    }

    public void clear() {
        zzac();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (!get(i11).equals(list.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (i11 * 31) + get(i12).hashCode();
        }
        return i11;
    }

    public E remove(int i11) {
        zzac();
        return super.remove(i11);
    }

    public boolean removeAll(Collection<?> collection) {
        zzac();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzac();
        return super.retainAll(collection);
    }

    public E set(int i11, E e11) {
        zzac();
        return super.set(i11, e11);
    }

    public boolean zzaa() {
        return this.zzdy;
    }

    public final void zzab() {
        this.zzdy = false;
    }

    public final void zzac() {
        if (!this.zzdy) {
            throw new UnsupportedOperationException();
        }
    }

    public void add(int i11, E e11) {
        zzac();
        super.add(i11, e11);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        zzac();
        return super.addAll(i11, collection);
    }

    public boolean remove(Object obj) {
        zzac();
        return super.remove(obj);
    }
}
