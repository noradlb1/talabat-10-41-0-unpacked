package com.instabug.library.util;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static String joinLongListToString(CharSequence charSequence, List<Long> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(String.valueOf(list.get(i11)));
            if (i11 < list.size() - 1) {
                sb2.append(charSequence);
            }
        }
        return sb2.toString();
    }

    @Nullable
    public static <T> T safeGet(@Nullable List<T> list, int i11) {
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return null;
        }
        return list.get(i11);
    }

    @NonNull
    public static <T> List<List<T>> split(List<T> list, @IntRange(from = 1) int i11) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return split(list, Math.max(1, i11), new ArrayList());
    }

    @NonNull
    public static <T> List<T> toList(@Nullable Collection<T> collection) {
        if (collection instanceof List) {
            return (List) collection;
        }
        if (collection == null) {
            return Collections.emptyList();
        }
        return new ArrayList(collection);
    }

    @NonNull
    private static <T> List<List<T>> split(@NonNull List<T> list, @IntRange(from = 1) int i11, @NonNull List<List<T>> list2) {
        if (list.size() > i11) {
            list2.add(list.subList(0, i11));
            return split(list.subList(i11, list.size()), i11, list2);
        }
        list2.add(list);
        return list2;
    }
}
