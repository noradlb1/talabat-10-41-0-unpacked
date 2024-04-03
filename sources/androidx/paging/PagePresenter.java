package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 7*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000278B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u001e\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002J\u0015\u0010&\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0002\u0010'J\u0015\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00020\bH\u0016¢\u0006\u0002\u0010'J\u0006\u0010*\u001a\u00020+J\u001e\u0010,\u001a\u00020\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\u001c\u0010.\u001a\u00020\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0000002\u0006\u0010!\u001a\u00020\"J\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002J\b\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f06H\u0002R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\n¨\u00069"}, d2 = {"Landroidx/paging/PagePresenter;", "T", "", "Landroidx/paging/NullPaddedList;", "insertEvent", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;)V", "originalPageOffsetFirst", "", "getOriginalPageOffsetFirst", "()I", "originalPageOffsetLast", "getOriginalPageOffsetLast", "pages", "", "Landroidx/paging/TransformablePage;", "<set-?>", "placeholdersAfter", "getPlaceholdersAfter", "placeholdersBefore", "getPlaceholdersBefore", "size", "getSize", "storageCount", "getStorageCount", "accessHintForPresenterIndex", "Landroidx/paging/ViewportHint$Access;", "index", "checkIndex", "", "dropPages", "drop", "Landroidx/paging/PageEvent$Drop;", "callback", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "dropPagesWithOffsets", "pageOffsetsToDrop", "Lkotlin/ranges/IntRange;", "get", "(I)Ljava/lang/Object;", "getFromStorage", "localIndex", "initializeHint", "Landroidx/paging/ViewportHint$Initial;", "insertPage", "insert", "processEvent", "pageEvent", "Landroidx/paging/PageEvent;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "toString", "", "fullCount", "", "Companion", "ProcessPageEventCallback", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PagePresenter<T> implements NullPaddedList<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PagePresenter<Object> INITIAL = new PagePresenter<>(PageEvent.Insert.Companion.getEMPTY_REFRESH_LOCAL());
    private final List<TransformablePage<T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int storageCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u0001H\u0000¢\u0006\u0002\b\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PagePresenter$Companion;", "", "()V", "INITIAL", "Landroidx/paging/PagePresenter;", "initial", "T", "initial$paging_common", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> PagePresenter<T> initial$paging_common() {
            PagePresenter<T> access$getINITIAL$cp = PagePresenter.INITIAL;
            if (access$getINITIAL$cp != null) {
                return access$getINITIAL$cp;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PagePresenter<T>");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "onStateUpdate", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "paging-common"}, k = 1, mv = {1, 4, 2})
    public interface ProcessPageEventCallback {
        void onChanged(int i11, int i12);

        void onInserted(int i11, int i12);

        void onRemoved(int i11, int i12);

        void onStateUpdate(@NotNull LoadType loadType, boolean z11, @NotNull LoadState loadState);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
        }
    }

    public PagePresenter(@NotNull PageEvent.Insert<T> insert) {
        Intrinsics.checkNotNullParameter(insert, "insertEvent");
        this.pages = CollectionsKt___CollectionsKt.toMutableList(insert.getPages());
        this.storageCount = fullCount(insert.getPages());
        this.placeholdersBefore = insert.getPlaceholdersBefore();
        this.placeholdersAfter = insert.getPlaceholdersAfter();
    }

    private final void checkIndex(int i11) {
        if (i11 < 0 || i11 >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + getSize());
        }
    }

    private final void dropPages(PageEvent.Drop<T> drop, ProcessPageEventCallback processPageEventCallback) {
        int i11;
        int size = getSize();
        LoadType loadType = drop.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType == loadType2) {
            int placeholdersBefore2 = getPlaceholdersBefore();
            this.storageCount = getStorageCount() - dropPagesWithOffsets(new IntRange(drop.getMinPageOffset(), drop.getMaxPageOffset()));
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            int size2 = getSize() - size;
            if (size2 > 0) {
                processPageEventCallback.onInserted(0, size2);
            } else if (size2 < 0) {
                processPageEventCallback.onRemoved(0, -size2);
            }
            int max = Math.max(0, placeholdersBefore2 + size2);
            int placeholdersRemaining = drop.getPlaceholdersRemaining() - max;
            if (placeholdersRemaining > 0) {
                processPageEventCallback.onChanged(max, placeholdersRemaining);
            }
            processPageEventCallback.onStateUpdate(loadType2, false, LoadState.NotLoading.Companion.getIncomplete$paging_common());
            return;
        }
        int placeholdersAfter2 = getPlaceholdersAfter();
        this.storageCount = getStorageCount() - dropPagesWithOffsets(new IntRange(drop.getMinPageOffset(), drop.getMaxPageOffset()));
        this.placeholdersAfter = drop.getPlaceholdersRemaining();
        int size3 = getSize() - size;
        if (size3 > 0) {
            processPageEventCallback.onInserted(size, size3);
        } else if (size3 < 0) {
            processPageEventCallback.onRemoved(size + size3, -size3);
        }
        if (size3 < 0) {
            i11 = Math.min(placeholdersAfter2, -size3);
        } else {
            i11 = 0;
        }
        int placeholdersRemaining2 = drop.getPlaceholdersRemaining() - (placeholdersAfter2 - i11);
        if (placeholdersRemaining2 > 0) {
            processPageEventCallback.onChanged(getSize() - drop.getPlaceholdersRemaining(), placeholdersRemaining2);
        }
        processPageEventCallback.onStateUpdate(LoadType.APPEND, false, LoadState.NotLoading.Companion.getIncomplete$paging_common());
    }

    private final int dropPagesWithOffsets(IntRange intRange) {
        boolean z11;
        Iterator<TransformablePage<T>> it = this.pages.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            TransformablePage next = it.next();
            int[] originalPageOffsets = next.getOriginalPageOffsets();
            int length = originalPageOffsets.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    z11 = false;
                    break;
                } else if (intRange.contains(originalPageOffsets[i12])) {
                    z11 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (z11) {
                i11 += next.getData().size();
                it.remove();
            }
        }
        return i11;
    }

    private final int fullCount(List<TransformablePage<T>> list) {
        int i11 = 0;
        for (TransformablePage data : list) {
            i11 += data.getData().size();
        }
        return i11;
    }

    private final int getOriginalPageOffsetFirst() {
        Integer minOrNull = ArraysKt___ArraysKt.minOrNull(((TransformablePage) CollectionsKt___CollectionsKt.first(this.pages)).getOriginalPageOffsets());
        Intrinsics.checkNotNull(minOrNull);
        return minOrNull.intValue();
    }

    private final int getOriginalPageOffsetLast() {
        Integer maxOrNull = ArraysKt___ArraysKt.maxOrNull(((TransformablePage) CollectionsKt___CollectionsKt.last(this.pages)).getOriginalPageOffsets());
        Intrinsics.checkNotNull(maxOrNull);
        return maxOrNull.intValue();
    }

    private final void insertPage(PageEvent.Insert<T> insert, ProcessPageEventCallback processPageEventCallback) {
        int fullCount = fullCount(insert.getPages());
        int size = getSize();
        int i11 = WhenMappings.$EnumSwitchMapping$0[insert.getLoadType().ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                int min = Math.min(getPlaceholdersBefore(), fullCount);
                int i12 = fullCount - min;
                this.pages.addAll(0, insert.getPages());
                this.storageCount = getStorageCount() + fullCount;
                this.placeholdersBefore = insert.getPlaceholdersBefore();
                processPageEventCallback.onChanged(getPlaceholdersBefore() - min, min);
                processPageEventCallback.onInserted(0, i12);
                int size2 = (getSize() - size) - i12;
                if (size2 > 0) {
                    processPageEventCallback.onInserted(0, size2);
                } else if (size2 < 0) {
                    processPageEventCallback.onRemoved(0, -size2);
                }
            } else if (i11 == 3) {
                int min2 = Math.min(getPlaceholdersAfter(), fullCount);
                int placeholdersBefore2 = getPlaceholdersBefore() + getStorageCount();
                int i13 = fullCount - min2;
                List<TransformablePage<T>> list = this.pages;
                list.addAll(list.size(), insert.getPages());
                this.storageCount = getStorageCount() + fullCount;
                this.placeholdersAfter = insert.getPlaceholdersAfter();
                processPageEventCallback.onChanged(placeholdersBefore2, min2);
                processPageEventCallback.onInserted(placeholdersBefore2 + min2, i13);
                int size3 = (getSize() - size) - i13;
                if (size3 > 0) {
                    processPageEventCallback.onInserted(getSize() - size3, size3);
                } else if (size3 < 0) {
                    processPageEventCallback.onRemoved(getSize(), -size3);
                }
            }
            insert.getCombinedLoadStates().forEach$paging_common(new PagePresenter$insertPage$1(processPageEventCallback));
            return;
        }
        throw new IllegalArgumentException();
    }

    @NotNull
    public final ViewportHint.Access accessHintForPresenterIndex(int i11) {
        int i12 = 0;
        int placeholdersBefore2 = i11 - getPlaceholdersBefore();
        while (placeholdersBefore2 >= this.pages.get(i12).getData().size() && i12 < CollectionsKt__CollectionsKt.getLastIndex(this.pages)) {
            placeholdersBefore2 -= this.pages.get(i12).getData().size();
            i12++;
        }
        return this.pages.get(i12).viewportHintFor(placeholdersBefore2, i11 - getPlaceholdersBefore(), ((getSize() - i11) - getPlaceholdersAfter()) - 1, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    @Nullable
    public final T get(int i11) {
        checkIndex(i11);
        int placeholdersBefore2 = i11 - getPlaceholdersBefore();
        if (placeholdersBefore2 < 0 || placeholdersBefore2 >= getStorageCount()) {
            return null;
        }
        return getFromStorage(placeholdersBefore2);
    }

    @NotNull
    public T getFromStorage(int i11) {
        int size = this.pages.size();
        int i12 = 0;
        while (i12 < size) {
            int size2 = this.pages.get(i12).getData().size();
            if (size2 > i11) {
                break;
            }
            i11 -= size2;
            i12++;
        }
        return this.pages.get(i12).getData().get(i11);
    }

    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public int getSize() {
        return getPlaceholdersBefore() + getStorageCount() + getPlaceholdersAfter();
    }

    public int getStorageCount() {
        return this.storageCount;
    }

    @NotNull
    public final ViewportHint.Initial initializeHint() {
        int storageCount2 = getStorageCount() / 2;
        return new ViewportHint.Initial(storageCount2, storageCount2, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final void processEvent(@NotNull PageEvent<T> pageEvent, @NotNull ProcessPageEventCallback processPageEventCallback) {
        Intrinsics.checkNotNullParameter(pageEvent, "pageEvent");
        Intrinsics.checkNotNullParameter(processPageEventCallback, "callback");
        if (pageEvent instanceof PageEvent.Insert) {
            insertPage((PageEvent.Insert) pageEvent, processPageEventCallback);
        } else if (pageEvent instanceof PageEvent.Drop) {
            dropPages((PageEvent.Drop) pageEvent, processPageEventCallback);
        } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
            PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent.LoadStateUpdate) pageEvent;
            processPageEventCallback.onStateUpdate(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator(), loadStateUpdate.getLoadState());
        }
    }

    @NotNull
    public final ItemSnapshotList<T> snapshot() {
        int placeholdersBefore2 = getPlaceholdersBefore();
        int placeholdersAfter2 = getPlaceholdersAfter();
        ArrayList arrayList = new ArrayList();
        for (TransformablePage data : this.pages) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, data.getData());
        }
        return new ItemSnapshotList<>(placeholdersBefore2, placeholdersAfter2, arrayList);
    }

    @NotNull
    public String toString() {
        int storageCount2 = getStorageCount();
        ArrayList arrayList = new ArrayList(storageCount2);
        for (int i11 = 0; i11 < storageCount2; i11++) {
            arrayList.add(getFromStorage(i11));
        }
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        return "[(" + getPlaceholdersBefore() + " placeholders), " + joinToString$default + ", (" + getPlaceholdersAfter() + " placeholders)]";
    }
}
