package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a:\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¨\u0006\u0010"}, d2 = {"computeDiff", "Landroidx/paging/NullPaddedDiffResult;", "T", "", "Landroidx/paging/NullPaddedList;", "newList", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "dispatchDiff", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "transformAnchorIndex", "", "oldPosition", "paging-runtime_release"}, k = 2, mv = {1, 4, 2})
public final class NullPaddedListDiffHelperKt {
    @NotNull
    public static final <T> NullPaddedDiffResult computeDiff(@NotNull NullPaddedList<T> nullPaddedList, @NotNull NullPaddedList<T> nullPaddedList2, @NotNull DiffUtil.ItemCallback<T> itemCallback) {
        boolean z11;
        Intrinsics.checkNotNullParameter(nullPaddedList, "$this$computeDiff");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        Intrinsics.checkNotNullParameter(itemCallback, "diffCallback");
        boolean z12 = true;
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new NullPaddedListDiffHelperKt$computeDiff$diffResult$1(nullPaddedList, nullPaddedList2, itemCallback, nullPaddedList.getStorageCount(), nullPaddedList2.getStorageCount()), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(\n…    },\n        true\n    )");
        IntRange until = RangesKt___RangesKt.until(0, nullPaddedList.getStorageCount());
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator it = until.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (calculateDiff.convertOldPositionToNew(((IntIterator) it).nextInt()) != -1) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            return new NullPaddedDiffResult(calculateDiff, z12);
        }
        z12 = false;
        return new NullPaddedDiffResult(calculateDiff, z12);
    }

    public static final <T> void dispatchDiff(@NotNull NullPaddedList<T> nullPaddedList, @NotNull ListUpdateCallback listUpdateCallback, @NotNull NullPaddedList<T> nullPaddedList2, @NotNull NullPaddedDiffResult nullPaddedDiffResult) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "$this$dispatchDiff");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "diffResult");
        if (nullPaddedDiffResult.getHasOverlap()) {
            OverlappingListsDiffDispatcher.INSTANCE.dispatchDiff(nullPaddedList, nullPaddedList2, listUpdateCallback, nullPaddedDiffResult);
        } else {
            DistinctListsDiffDispatcher.INSTANCE.dispatchDiff(listUpdateCallback, nullPaddedList, nullPaddedList2);
        }
    }

    public static final int transformAnchorIndex(@NotNull NullPaddedList<?> nullPaddedList, @NotNull NullPaddedDiffResult nullPaddedDiffResult, @NotNull NullPaddedList<?> nullPaddedList2, int i11) {
        int convertOldPositionToNew;
        Intrinsics.checkNotNullParameter(nullPaddedList, "$this$transformAnchorIndex");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "diffResult");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        if (!nullPaddedDiffResult.getHasOverlap()) {
            return RangesKt___RangesKt.coerceIn(i11, (ClosedRange<Integer>) RangesKt___RangesKt.until(0, nullPaddedList2.getSize()));
        }
        int placeholdersBefore = i11 - nullPaddedList.getPlaceholdersBefore();
        int storageCount = nullPaddedList.getStorageCount();
        if (placeholdersBefore >= 0 && storageCount > placeholdersBefore) {
            for (int i12 = 0; i12 <= 29; i12++) {
                int i13 = i12 / 2;
                int i14 = 1;
                if (i12 % 2 == 1) {
                    i14 = -1;
                }
                int i15 = (i13 * i14) + placeholdersBefore;
                if (i15 >= 0 && i15 < nullPaddedList.getStorageCount() && (convertOldPositionToNew = nullPaddedDiffResult.getDiff().convertOldPositionToNew(i15)) != -1) {
                    return convertOldPositionToNew + nullPaddedList2.getPlaceholdersBefore();
                }
            }
        }
        return RangesKt___RangesKt.coerceIn(i11, (ClosedRange<Integer>) RangesKt___RangesKt.until(0, nullPaddedList2.getSize()));
    }
}
