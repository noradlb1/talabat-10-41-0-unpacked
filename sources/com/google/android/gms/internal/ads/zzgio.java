package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzgio<E> extends AbstractList<E> implements zzgku<E> {
    private boolean zza = true;

    public void add(int i11, E e11) {
        zzbU();
        super.add(i11, e11);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        zzbU();
        return super.addAll(i11, collection);
    }

    public void clear() {
        zzbU();
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
        zzbU();
        return super.remove(i11);
    }

    public final boolean removeAll(Collection<?> collection) {
        zzbU();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection<?> collection) {
        zzbU();
        return super.retainAll(collection);
    }

    public E set(int i11, E e11) {
        zzbU();
        return super.set(i11, e11);
    }

    public final void zzb() {
        this.zza = false;
    }

    public final void zzbU() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    public boolean add(E e11) {
        zzbU();
        return super.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzbU();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzbU();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
