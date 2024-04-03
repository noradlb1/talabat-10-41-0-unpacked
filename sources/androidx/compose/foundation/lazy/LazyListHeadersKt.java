package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyListHeadersKt {
    @Nullable
    public static final LazyListPositionedItem findOrComposeLazyListHeader(@NotNull List<LazyListPositionedItem> list, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider, @NotNull List<Integer> list2, int i11, int i12, int i13) {
        int i14;
        int i15;
        List<LazyListPositionedItem> list3 = list;
        LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
        List<Integer> list4 = list2;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(list, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider2, "itemProvider");
        Intrinsics.checkNotNullParameter(list4, "headerIndexes");
        int index = ((LazyListPositionedItem) CollectionsKt___CollectionsKt.first(list)).getIndex();
        int size = list2.size();
        int i17 = -1;
        int i18 = -1;
        int i19 = 0;
        while (i19 < size && list4.get(i19).intValue() <= index) {
            i17 = list4.get(i19).intValue();
            i19++;
            if (i19 < 0 || i19 > CollectionsKt__CollectionsKt.getLastIndex(list2)) {
                i15 = -1;
            } else {
                i15 = list4.get(i19);
            }
            i18 = i15.intValue();
        }
        int size2 = list.size();
        int i21 = Integer.MIN_VALUE;
        int i22 = Integer.MIN_VALUE;
        int i23 = -1;
        for (int i24 = 0; i24 < size2; i24++) {
            LazyListPositionedItem lazyListPositionedItem = list.get(i24);
            if (lazyListPositionedItem.getIndex() == i17) {
                i21 = lazyListPositionedItem.getOffset();
                i23 = i24;
            } else if (lazyListPositionedItem.getIndex() == i18) {
                i22 = lazyListPositionedItem.getOffset();
            }
        }
        if (i17 == -1) {
            return null;
        }
        LazyMeasuredItem r12 = lazyMeasuredItemProvider2.m648getAndMeasureZjPyQlc(DataIndex.m612constructorimpl(i17));
        if (i21 != Integer.MIN_VALUE) {
            i14 = Math.max(-i16, i21);
        } else {
            i14 = -i16;
        }
        if (i22 != Integer.MIN_VALUE) {
            i14 = Math.min(i14, i22 - r12.getSize());
        }
        LazyListPositionedItem position = r12.position(i14, i12, i13);
        if (i23 != -1) {
            list.set(i23, position);
        } else {
            list.add(0, position);
        }
        return position;
    }
}
