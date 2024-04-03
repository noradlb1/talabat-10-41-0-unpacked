package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzam  reason: invalid package */
public abstract class zzam extends zzai implements List, RandomAccess {
    private static final zzba zza = new zzak(zzas.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzam zzg(Object[] objArr, int i11) {
        if (i11 == 0) {
            return zzas.zza;
        }
        return new zzas(objArr, i11);
    }

    public static zzam zzh(Collection collection) {
        Object[] array = collection.toArray();
        int length = array.length;
        zzar.zza(array, length);
        return zzg(array, length);
    }

    public static zzam zzi() {
        return zzas.zza;
    }

    public static zzam zzj(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        Object[] objArr = {"firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp"};
        zzar.zza(objArr, 8);
        return zzg(objArr, 8);
    }

    @Deprecated
    public final void add(int i11, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i11, Collection collection) {
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
                        if (zzq.zza(get(i11), list.get(i11))) {
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
                            if (!zzq.zza(it.next(), it2.next())) {
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
    public final Object remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i11, Object obj) {
        throw new UnsupportedOperationException();
    }

    public int zza(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i12] = get(i12);
        }
        return size;
    }

    public final zzaz zzd() {
        return listIterator(0);
    }

    /* renamed from: zzf */
    public zzam subList(int i11, int i12) {
        zzu.zzc(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return zzas.zza;
        }
        return new zzal(this, i11, i13);
    }

    /* renamed from: zzk */
    public final zzba listIterator(int i11) {
        zzu.zzb(i11, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzak(this, i11);
    }
}
