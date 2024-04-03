package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzpo<E> extends AbstractList<E> implements zzrj<E> {
    private boolean zzavs = true;

    public boolean add(E e11) {
        zzmz();
        return super.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzmz();
        return super.addAll(collection);
    }

    public void clear() {
        zzmz();
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
        zzmz();
        return super.remove(i11);
    }

    public boolean removeAll(Collection<?> collection) {
        zzmz();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzmz();
        return super.retainAll(collection);
    }

    public E set(int i11, E e11) {
        zzmz();
        return super.set(i11, e11);
    }

    public final void zzmi() {
        this.zzavs = false;
    }

    public boolean zzmy() {
        return this.zzavs;
    }

    public final void zzmz() {
        if (!this.zzavs) {
            throw new UnsupportedOperationException();
        }
    }

    public void add(int i11, E e11) {
        zzmz();
        super.add(i11, e11);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        zzmz();
        return super.addAll(i11, collection);
    }

    public boolean remove(Object obj) {
        zzmz();
        return super.remove(obj);
    }
}
