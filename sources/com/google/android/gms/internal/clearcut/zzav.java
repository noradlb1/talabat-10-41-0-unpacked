package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzav<E> extends AbstractList<E> implements zzcn<E> {
    private boolean zzfa = true;

    public void add(int i11, E e11) {
        zzw();
        super.add(i11, e11);
    }

    public boolean add(E e11) {
        zzw();
        return super.add(e11);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        zzw();
        return super.addAll(i11, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzw();
        return super.addAll(collection);
    }

    public void clear() {
        zzw();
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
        zzw();
        return super.remove(i11);
    }

    public boolean remove(Object obj) {
        zzw();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzw();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzw();
        return super.retainAll(collection);
    }

    public E set(int i11, E e11) {
        zzw();
        return super.set(i11, e11);
    }

    public boolean zzu() {
        return this.zzfa;
    }

    public final void zzv() {
        this.zzfa = false;
    }

    public final void zzw() {
        if (!this.zzfa) {
            throw new UnsupportedOperationException();
        }
    }
}
