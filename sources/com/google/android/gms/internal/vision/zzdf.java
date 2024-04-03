package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdf<E> extends zzdc<E> implements List<E>, RandomAccess {
    private static final zzdq<Object> zzln = new zzde(zzdi.zzlt, 0);

    public static <E> zzdf<E> zza(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return zzdi.zzlt;
        }
        return new zzdi(objArr, length);
    }

    public static <E> zzdf<E> zzcd() {
        return zzdi.zzlt;
    }

    @Deprecated
    public final void add(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzct.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i11 = 0;
                    while (i11 < size) {
                        if (zzco.equal(get(i11), list.get(i11))) {
                            i11++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i12 = 0;
                while (true) {
                    if (i12 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i12);
                        i12++;
                        if (!zzco.equal(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = ~(~((i11 * 31) + get(i12).hashCode()));
        }
        return i11;
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (obj.equals(get(i11))) {
                return i11;
            }
        }
        return -1;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator(int i11) {
        zzct.zzd(i11, size());
        if (isEmpty()) {
            return zzln;
        }
        return new zzde(this, i11);
    }

    @Deprecated
    public final E remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    public final zzdr<E> zzby() {
        return (zzdq) listIterator();
    }

    public final zzdf<E> zzcc() {
        return this;
    }

    /* renamed from: zze */
    public zzdf<E> subList(int i11, int i12) {
        zzct.zza(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return zzdi.zzlt;
        }
        return new zzdh(this, i11, i13);
    }

    public int zza(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i11 + i12] = get(i12);
        }
        return i11 + size;
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzdq) listIterator(0);
    }
}
