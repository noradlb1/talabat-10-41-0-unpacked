package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher;", "", "()V", "dispatchDiff", "", "T", "oldList", "Landroidx/paging/NullPaddedList;", "newList", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "Landroidx/paging/NullPaddedDiffResult;", "PlaceholderUsingUpdateCallback", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
public final class OverlappingListsDiffDispatcher {
    @NotNull
    public static final OverlappingListsDiffDispatcher INSTANCE = new OverlappingListsDiffDispatcher();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\r\u0010!\u001a\u00020\t*\u00020\tH\bR\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback;", "T", "Landroidx/recyclerview/widget/ListUpdateCallback;", "oldList", "Landroidx/paging/NullPaddedList;", "newList", "callback", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;)V", "placeholdersAfter", "", "placeholdersAfterState", "placeholdersBefore", "placeholdersBeforeState", "storageCount", "dispatchInsertAsPlaceholderAfter", "", "position", "count", "dispatchInsertAsPlaceholderBefore", "dispatchRemovalAsPlaceholdersAfter", "dispatchRemovalAsPlaceholdersBefore", "fixLeadingPlaceholders", "", "fixPlaceholders", "fixTrailingPlaceholders", "onChanged", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "offsetForDispatch", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
    public static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int UNUSED = 1;
        private static final int USED_FOR_ADDITION = 3;
        private static final int USED_FOR_REMOVAL = 2;
        private final ListUpdateCallback callback;
        private final NullPaddedList<T> newList;
        private final NullPaddedList<T> oldList;
        private int placeholdersAfter;
        private int placeholdersAfterState = 1;
        /* access modifiers changed from: private */
        public int placeholdersBefore;
        private int placeholdersBeforeState = 1;
        private int storageCount;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback$Companion;", "", "()V", "UNUSED", "", "USED_FOR_ADDITION", "USED_FOR_REMOVAL", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public PlaceholderUsingUpdateCallback(@NotNull NullPaddedList<T> nullPaddedList, @NotNull NullPaddedList<T> nullPaddedList2, @NotNull ListUpdateCallback listUpdateCallback) {
            Intrinsics.checkNotNullParameter(nullPaddedList, "oldList");
            Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
            Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
            this.oldList = nullPaddedList;
            this.newList = nullPaddedList2;
            this.callback = listUpdateCallback;
            this.placeholdersBefore = nullPaddedList.getPlaceholdersBefore();
            this.placeholdersAfter = nullPaddedList.getPlaceholdersAfter();
            this.storageCount = nullPaddedList.getStorageCount();
        }

        private final boolean dispatchInsertAsPlaceholderAfter(int i11, int i12) {
            if (i11 < this.storageCount || this.placeholdersAfterState == 2) {
                return false;
            }
            int min = Math.min(i12, this.placeholdersAfter);
            if (min > 0) {
                this.placeholdersAfterState = 3;
                this.callback.onChanged(this.placeholdersBefore + i11, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.placeholdersAfter -= min;
            }
            int i13 = i12 - min;
            if (i13 <= 0) {
                return true;
            }
            this.callback.onInserted(i11 + min + this.placeholdersBefore, i13);
            return true;
        }

        private final boolean dispatchInsertAsPlaceholderBefore(int i11, int i12) {
            if (i11 > 0 || this.placeholdersBeforeState == 2) {
                return false;
            }
            int min = Math.min(i12, this.placeholdersBefore);
            if (min > 0) {
                this.placeholdersBeforeState = 3;
                this.callback.onChanged((0 - min) + this.placeholdersBefore, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.placeholdersBefore -= min;
            }
            int i13 = i12 - min;
            if (i13 <= 0) {
                return true;
            }
            this.callback.onInserted(this.placeholdersBefore + 0, i13);
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersAfter(int i11, int i12) {
            if (i11 + i12 < this.storageCount || this.placeholdersAfterState == 3) {
                return false;
            }
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersAfter() - this.placeholdersAfter, i12), 0);
            int i13 = i12 - coerceAtLeast;
            if (coerceAtLeast > 0) {
                this.placeholdersAfterState = 2;
                this.callback.onChanged(this.placeholdersBefore + i11, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.placeholdersAfter += coerceAtLeast;
            }
            if (i13 <= 0) {
                return true;
            }
            this.callback.onRemoved(i11 + coerceAtLeast + this.placeholdersBefore, i13);
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersBefore(int i11, int i12) {
            if (i11 > 0 || this.placeholdersBeforeState == 3) {
                return false;
            }
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersBefore() - this.placeholdersBefore, i12), 0);
            int i13 = i12 - coerceAtLeast;
            if (i13 > 0) {
                this.callback.onRemoved(this.placeholdersBefore + 0, i13);
            }
            if (coerceAtLeast <= 0) {
                return true;
            }
            this.placeholdersBeforeState = 2;
            this.callback.onChanged(this.placeholdersBefore + 0, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.placeholdersBefore += coerceAtLeast;
            return true;
        }

        private final void fixLeadingPlaceholders() {
            int min = Math.min(this.oldList.getPlaceholdersBefore(), this.placeholdersBefore);
            int placeholdersBefore2 = this.newList.getPlaceholdersBefore() - this.placeholdersBefore;
            if (placeholdersBefore2 > 0) {
                if (min > 0) {
                    this.callback.onChanged(0, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.callback.onInserted(0, placeholdersBefore2);
            } else if (placeholdersBefore2 < 0) {
                this.callback.onRemoved(0, -placeholdersBefore2);
                int i11 = min + placeholdersBefore2;
                if (i11 > 0) {
                    this.callback.onChanged(0, i11, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.placeholdersBefore = this.newList.getPlaceholdersBefore();
        }

        private final void fixTrailingPlaceholders() {
            boolean z11;
            int min = Math.min(this.oldList.getPlaceholdersAfter(), this.placeholdersAfter);
            int placeholdersAfter2 = this.newList.getPlaceholdersAfter();
            int i11 = this.placeholdersAfter;
            int i12 = placeholdersAfter2 - i11;
            int i13 = this.placeholdersBefore + this.storageCount + i11;
            int i14 = i13 - min;
            if (i14 != this.oldList.getSize() - min) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i12 > 0) {
                this.callback.onInserted(i13, i12);
            } else if (i12 < 0) {
                this.callback.onRemoved(i13 + i12, -i12);
                min += i12;
            }
            if (min > 0 && z11) {
                this.callback.onChanged(i14, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.placeholdersAfter = this.newList.getPlaceholdersAfter();
        }

        private final int offsetForDispatch(int i11) {
            return i11 + this.placeholdersBefore;
        }

        public final void fixPlaceholders() {
            fixLeadingPlaceholders();
            fixTrailingPlaceholders();
        }

        public void onChanged(int i11, int i12, @Nullable Object obj) {
            this.callback.onChanged(i11 + this.placeholdersBefore, i12, obj);
        }

        public void onInserted(int i11, int i12) {
            if (!dispatchInsertAsPlaceholderAfter(i11, i12) && !dispatchInsertAsPlaceholderBefore(i11, i12)) {
                this.callback.onInserted(i11 + this.placeholdersBefore, i12);
            }
            this.storageCount += i12;
        }

        public void onMoved(int i11, int i12) {
            this.callback.onMoved(i11 + this.placeholdersBefore, i12 + this.placeholdersBefore);
        }

        public void onRemoved(int i11, int i12) {
            if (!dispatchRemovalAsPlaceholdersAfter(i11, i12) && !dispatchRemovalAsPlaceholdersBefore(i11, i12)) {
                this.callback.onRemoved(i11 + this.placeholdersBefore, i12);
            }
            this.storageCount -= i12;
        }
    }

    private OverlappingListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(@NotNull NullPaddedList<T> nullPaddedList, @NotNull NullPaddedList<T> nullPaddedList2, @NotNull ListUpdateCallback listUpdateCallback, @NotNull NullPaddedDiffResult nullPaddedDiffResult) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "oldList");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "newList");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "diffResult");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(nullPaddedList, nullPaddedList2, listUpdateCallback);
        nullPaddedDiffResult.getDiff().dispatchUpdatesTo((ListUpdateCallback) placeholderUsingUpdateCallback);
        placeholderUsingUpdateCallback.fixPlaceholders();
    }
}
