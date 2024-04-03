package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

public abstract class zzge<E> extends zzgb<E> implements List<E>, RandomAccess {
    private static final zzhb<Object> zza = new zzgc(zzgr.zza, 0);

    public static <E> zzge<E> zzi(Object[] objArr) {
        return zzj(objArr, objArr.length);
    }

    public static <E> zzge<E> zzj(Object[] objArr, int i11) {
        if (i11 == 0) {
            return zzgr.zza;
        }
        return new zzgr(objArr, i11);
    }

    public static <E> zzge<E> zzk(Collection<? extends E> collection) {
        if (collection instanceof zzgb) {
            zzge<E> zzd = ((zzgb) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzj(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzgn.zza(array2, length);
        return zzj(array2, length);
    }

    public static <E> zzge<E> zzl(E[] eArr) {
        if (eArr.length == 0) {
            return zzgr.zza;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        zzgn.zza(objArr, length);
        return zzj(objArr, length);
    }

    public static <E> zzge<E> zzm() {
        return zzgr.zza;
    }

    public static <E> zzge<E> zzn(E e11) {
        Object[] objArr = {e11};
        zzgn.zza(objArr, 1);
        return zzj(objArr, 1);
    }

    public static <E> zzge<E> zzo(E e11, E e12) {
        Object[] objArr = {e11, e12};
        zzgn.zza(objArr, 2);
        return zzj(objArr, 2);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable<? extends E>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> com.google.android.libraries.places.internal.zzge<E> zzp(java.util.Comparator<? super E> r1, java.lang.Iterable<? extends E> r2) {
        /*
            java.lang.Object[] r2 = r2.toArray()
            int r0 = r2.length
            com.google.android.libraries.places.internal.zzgn.zza(r2, r0)
            java.util.Arrays.sort(r2, r1)
            com.google.android.libraries.places.internal.zzge r1 = zzj(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzge.zzp(java.util.Comparator, java.lang.Iterable):com.google.android.libraries.places.internal.zzge");
    }

    @Deprecated
    public final void add(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i11 = 0;
                    while (i11 < size) {
                        if (zzfi.zza(get(i11), list.get(i11))) {
                            i11++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzfi.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (i11 * 31) + get(i12).hashCode();
        }
        return i11;
    }

    public final int indexOf(@CheckForNull Object obj) {
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

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
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

    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final E remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    public int zza(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i12] = get(i12);
        }
        return size;
    }

    @Deprecated
    public final zzge<E> zzd() {
        return this;
    }

    public final zzha<E> zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzge<E> subList(int i11, int i12) {
        zzfm.zzg(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return zzgr.zza;
        }
        return new zzgd(this, i11, i13);
    }

    /* renamed from: zzq */
    public final zzhb<E> listIterator(int i11) {
        zzfm.zzb(i11, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzgc(this, i11);
    }
}
