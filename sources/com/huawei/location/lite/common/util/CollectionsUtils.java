package com.huawei.location.lite.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CollectionsUtils {
    public static <T, K> T getOrDefault(Map<K, T> map, K k11, T t11) {
        T t12 = map.get(k11);
        if (t12 != null) {
            return t12;
        }
        map.put(k11, t11);
        return t11;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static int[] toArray(List<Integer> list) {
        if (isEmpty((Collection<?>) list)) {
            return new int[0];
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = list.get(i11).intValue();
        }
        return iArr;
    }

    public static List<Integer> toIntList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static List<String> toStringList(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        arrayList.addAll(new ArrayList(Arrays.asList(strArr)));
        return arrayList;
    }
}
