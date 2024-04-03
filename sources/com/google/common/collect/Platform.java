package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {
    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
    }

    public static <T> T[] copy(Object[] objArr, int i11, int i12, T[] tArr) {
        return Arrays.copyOfRange(objArr, i11, i12, tArr.getClass());
    }

    public static <E extends Enum<E>> Class<E> getDeclaringClassOrObjectForJ2cl(E e11) {
        return e11.getDeclaringClass();
    }

    public static <T> T[] newArray(T[] tArr, int i11) {
        if (tArr.length != 0) {
            tArr = Arrays.copyOf(tArr, 0);
        }
        return Arrays.copyOf(tArr, i11);
    }

    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int i11) {
        return CompactHashMap.createWithExpectedSize(i11);
    }

    public static <E> Set<E> newHashSetWithExpectedSize(int i11) {
        return CompactHashSet.createWithExpectedSize(i11);
    }

    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i11) {
        return CompactLinkedHashMap.createWithExpectedSize(i11);
    }

    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int i11) {
        return CompactLinkedHashSet.createWithExpectedSize(i11);
    }

    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static int reduceExponentIfGwt(int i11) {
        return i11;
    }

    public static int reduceIterationsIfGwt(int i11) {
        return i11;
    }

    @J2ktIncompatible
    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
