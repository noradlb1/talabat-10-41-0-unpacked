package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdc<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzll = new Object[0];

    @Deprecated
    public final boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zzll);
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i11) {
        zzdr zzdr = (zzdr) iterator();
        while (zzdr.hasNext()) {
            objArr[i11] = zzdr.next();
            i11++;
        }
        return i11;
    }

    /* renamed from: zzby */
    public abstract zzdr<E> iterator();

    public Object[] zzbz() {
        return null;
    }

    public int zzca() {
        throw new UnsupportedOperationException();
    }

    public int zzcb() {
        throw new UnsupportedOperationException();
    }

    public zzdf<E> zzcc() {
        return isEmpty() ? zzdf.zzcd() : zzdf.zza(toArray());
    }

    public final <T> T[] toArray(T[] tArr) {
        zzct.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzbz = zzbz();
            if (zzbz != null) {
                return Arrays.copyOfRange(zzbz, zzca(), zzcb(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
