package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.emptyList()")
    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k11, @NonNull V v11, @NonNull K k12, @NonNull V v12, @NonNull K k13, @NonNull V v13) {
        Map zza = zza(3, false);
        zza.put(k11, v11);
        zza.put(k12, v12);
        zza.put(k13, v13);
        return Collections.unmodifiableMap(zza);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map zza = zza(length, false);
            for (int i11 = 0; i11 < kArr.length; i11++) {
                zza.put(kArr[i11], vArr[i11]);
            }
            return Collections.unmodifiableMap(zza);
        }
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i11) {
        if (i11 == 0) {
            return new ArraySet();
        }
        return zzb(i11, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t11, @NonNull T t12, @NonNull T t13) {
        Set zzb = zzb(3, false);
        zzb.add(t11);
        zzb.add(t12);
        zzb.add(t13);
        return Collections.unmodifiableSet(zzb);
    }

    private static Map zza(int i11, boolean z11) {
        if (i11 <= 256) {
            return new ArrayMap(i11);
        }
        return new HashMap(i11, 1.0f);
    }

    private static Set zzb(int i11, boolean z11) {
        int i12;
        float f11;
        if (true != z11) {
            i12 = 256;
        } else {
            i12 = 128;
        }
        if (i11 <= i12) {
            return new ArraySet(i11);
        }
        if (true != z11) {
            f11 = 1.0f;
        } else {
            f11 = 0.75f;
        }
        return new HashSet(i11, f11);
    }

    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.singletonList(item)")
    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T t11) {
        return Collections.singletonList(t11);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k11, @NonNull V v11, @NonNull K k12, @NonNull V v12, @NonNull K k13, @NonNull V v13, @NonNull K k14, @NonNull V v14, @NonNull K k15, @NonNull V v15, @NonNull K k16, @NonNull V v16) {
        Map zza = zza(6, false);
        zza.put(k11, v11);
        zza.put(k12, v12);
        zza.put(k13, v13);
        zza.put(k14, v14);
        zza.put(k15, v15);
        zza.put(k16, v16);
        return Collections.unmodifiableMap(zza);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t11 = tArr[0];
            T t12 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t11);
            zzb.add(t12);
            return Collections.unmodifiableSet(zzb);
        } else if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set zzb2 = zzb(length, false);
                Collections.addAll(zzb2, tArr);
                return Collections.unmodifiableSet(zzb2);
            }
            T t13 = tArr[0];
            T t14 = tArr[1];
            T t15 = tArr[2];
            T t16 = tArr[3];
            Set zzb3 = zzb(4, false);
            zzb3.add(t13);
            zzb3.add(t14);
            zzb3.add(t15);
            zzb3.add(t16);
            return Collections.unmodifiableSet(zzb3);
        }
    }
}
