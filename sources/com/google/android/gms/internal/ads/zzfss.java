package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

public abstract class zzfss<E> extends zzfsn<E> implements List<E>, RandomAccess {
    private static final zzfuv<Object> zza = new zzfsq(zzfug.zza, 0);

    public static <E> zzfsp<E> zzi() {
        return new zzfsp<>(4);
    }

    public static <E> zzfss<E> zzj(Object[] objArr) {
        return zzk(objArr, objArr.length);
    }

    public static <E> zzfss<E> zzk(Object[] objArr, int i11) {
        if (i11 == 0) {
            return zzfug.zza;
        }
        return new zzfug(objArr, i11);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Collection, java.lang.Iterable<? extends E>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> com.google.android.gms.internal.ads.zzfss<E> zzl(java.lang.Iterable<? extends E> r0) {
        /*
            r0.getClass()
            com.google.android.gms.internal.ads.zzfss r0 = zzm(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfss.zzl(java.lang.Iterable):com.google.android.gms.internal.ads.zzfss");
    }

    public static <E> zzfss<E> zzm(Collection<? extends E> collection) {
        if (collection instanceof zzfsn) {
            zzfss<E> zzd = ((zzfsn) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzk(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzfue.zzb(array2, length);
        return zzk(array2, length);
    }

    public static <E> zzfss<E> zzn(E[] eArr) {
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        zzfue.zzb(objArr, length);
        return zzk(objArr, length);
    }

    public static <E> zzfss<E> zzo() {
        return zzfug.zza;
    }

    public static <E> zzfss<E> zzp(E e11) {
        Object[] objArr = {e11};
        zzfue.zzb(objArr, 1);
        return zzk(objArr, 1);
    }

    public static <E> zzfss<E> zzq(E e11, E e12) {
        Object[] objArr = {e11, e12};
        zzfue.zzb(objArr, 2);
        return zzk(objArr, 2);
    }

    public static <E> zzfss<E> zzr(E e11, E e12, E e13) {
        Object[] objArr = {"2011", "1009", "3010"};
        zzfue.zzb(objArr, 3);
        return zzk(objArr, 3);
    }

    public static <E> zzfss<E> zzs(E e11, E e12, E e13, E e14, E e15) {
        Object[] objArr = {e11, e12, e13, e14, e15};
        zzfue.zzb(objArr, 5);
        return zzk(objArr, 5);
    }

    public static <E> zzfss<E> zzt(E e11, E e12, E e13, E e14, E e15, E e16) {
        Object[] objArr = {e11, e12, e13, e14, e15, e16};
        zzfue.zzb(objArr, 6);
        return zzk(objArr, 6);
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
                        if (zzfqc.zza(get(i11), list.get(i11))) {
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
                            if (!zzfqc.zza(it.next(), it2.next())) {
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

    public final /* synthetic */ Iterator iterator() {
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

    public final /* synthetic */ ListIterator listIterator() {
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
            objArr[i11 + i12] = get(i12);
        }
        return i11 + size;
    }

    @Deprecated
    public final zzfss<E> zzd() {
        return this;
    }

    public final zzfuu<E> zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzfss<E> subList(int i11, int i12) {
        zzfqg.zzf(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return zzfug.zza;
        }
        return new zzfsr(this, i11, i13);
    }

    /* renamed from: zzu */
    public final zzfuv<E> listIterator(int i11) {
        zzfqg.zzb(i11, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzfsq(this, i11);
    }
}
