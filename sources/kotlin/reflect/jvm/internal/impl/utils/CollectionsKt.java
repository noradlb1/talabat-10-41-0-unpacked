package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CollectionsKt {
    public static final <T> void addIfNotNull(@NotNull Collection<T> collection, @Nullable T t11) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (t11 != null) {
            collection.add(t11);
        }
    }

    private static final int capacity(int i11) {
        if (i11 < 3) {
            return 3;
        }
        return i11 + (i11 / 3) + 1;
    }

    @NotNull
    public static final <T> List<T> compact(@NotNull ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (size == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(CollectionsKt___CollectionsKt.first(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, Integer> mapToIndex(@NotNull Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        for (Object put : iterable) {
            linkedHashMap.put(put, Integer.valueOf(i11));
            i11++;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i11) {
        return new HashMap<>(capacity(i11));
    }

    @NotNull
    public static final <E> HashSet<E> newHashSetWithExpectedSize(int i11) {
        return new HashSet<>(capacity(i11));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i11) {
        return new LinkedHashSet<>(capacity(i11));
    }
}
