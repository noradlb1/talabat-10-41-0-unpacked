package com.afollestad.materialdialogs.utils;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¨\u0006\u0006"}, d2 = {"appendAll", "", "values", "", "", "removeAll", "com.afollestad.material-dialogs.core"}, k = 2, mv = {1, 1, 15})
public final class IntArraysKt {
    @NotNull
    public static final int[] appendAll(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$appendAll");
        Intrinsics.checkParameterIsNotNull(collection, "values");
        List mutableList = ArraysKt___ArraysKt.toMutableList(iArr);
        mutableList.addAll(collection);
        return CollectionsKt___CollectionsKt.toIntArray(mutableList);
    }

    @NotNull
    public static final int[] removeAll(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$removeAll");
        Intrinsics.checkParameterIsNotNull(collection, "values");
        List mutableList = ArraysKt___ArraysKt.toMutableList(iArr);
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(mutableList, new IntArraysKt$removeAll$$inlined$apply$lambda$1(collection));
        return CollectionsKt___CollectionsKt.toIntArray(mutableList);
    }
}
