package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0001H\u0002J4\u0010\r\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010¨\u0006\u0012"}, d2 = {"Landroidx/paging/DistinctListsDiffDispatcher;", "", "()V", "dispatchChange", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "startBoundary", "", "endBoundary", "start", "end", "payload", "dispatchDiff", "T", "oldList", "Landroidx/paging/NullPaddedList;", "newList", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
public final class DistinctListsDiffDispatcher {
    @NotNull
    public static final DistinctListsDiffDispatcher INSTANCE = new DistinctListsDiffDispatcher();

    private DistinctListsDiffDispatcher() {
    }

    private final void dispatchChange(ListUpdateCallback listUpdateCallback, int i11, int i12, int i13, int i14, Object obj) {
        int i15 = i11 - i13;
        if (i15 > 0) {
            listUpdateCallback.onChanged(i13, i15, obj);
        }
        int i16 = i14 - i12;
        if (i16 > 0) {
            listUpdateCallback.onChanged(i12, i16, obj);
        }
    }

    public final <T> void dispatchDiff(@NotNull ListUpdateCallback listUpdateCallback, @NotNull NullPaddedList<T> nullPaddedList, @NotNull NullPaddedList<T> nullPaddedList2) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Intrinsics.checkNotNullParameter(nullPaddedList, "oldList");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        int max = Math.max(nullPaddedList.getPlaceholdersBefore(), nullPaddedList2.getPlaceholdersBefore());
        int min = Math.min(nullPaddedList.getPlaceholdersBefore() + nullPaddedList.getStorageCount(), nullPaddedList2.getPlaceholdersBefore() + nullPaddedList2.getStorageCount());
        int i11 = min - max;
        if (i11 > 0) {
            listUpdateCallback.onRemoved(max, i11);
            listUpdateCallback.onInserted(max, i11);
        }
        int min2 = Math.min(max, min);
        ListUpdateCallback listUpdateCallback2 = listUpdateCallback;
        int i12 = min2;
        int max2 = Math.max(max, min);
        dispatchChange(listUpdateCallback2, i12, max2, RangesKt___RangesKt.coerceAtMost(nullPaddedList.getPlaceholdersBefore(), nullPaddedList2.getSize()), RangesKt___RangesKt.coerceAtMost(nullPaddedList.getPlaceholdersBefore() + nullPaddedList.getStorageCount(), nullPaddedList2.getSize()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        dispatchChange(listUpdateCallback2, i12, max2, RangesKt___RangesKt.coerceAtMost(nullPaddedList2.getPlaceholdersBefore(), nullPaddedList.getSize()), RangesKt___RangesKt.coerceAtMost(nullPaddedList2.getPlaceholdersBefore() + nullPaddedList2.getStorageCount(), nullPaddedList.getSize()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int size = nullPaddedList2.getSize() - nullPaddedList.getSize();
        if (size > 0) {
            listUpdateCallback.onInserted(nullPaddedList.getSize(), size);
        } else if (size < 0) {
            listUpdateCallback.onRemoved(nullPaddedList.getSize() + size, -size);
        }
    }
}
