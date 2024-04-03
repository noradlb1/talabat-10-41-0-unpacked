package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u0011J\u0016\u0010\u0012\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/paging/FlattenedPageEventStorage;", "T", "", "()V", "loadStates", "Landroidx/paging/MutableLoadStateCollection;", "pages", "Ljava/util/ArrayDeque;", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "placeholdersBefore", "add", "", "event", "Landroidx/paging/PageEvent;", "getAsEvents", "", "handleInsert", "Landroidx/paging/PageEvent$Insert;", "handleLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "handlePageDrop", "Landroidx/paging/PageEvent$Drop;", "paging-common"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 2)
public final class FlattenedPageEventStorage<T> {
    private final MutableLoadStateCollection loadStates = new MutableLoadStateCollection();
    private final ArrayDeque<TransformablePage<T>> pages = new ArrayDeque<>();
    private int placeholdersAfter;
    private int placeholdersBefore;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.PREPEND;
            iArr[loadType.ordinal()] = 1;
            LoadType loadType2 = LoadType.APPEND;
            iArr[loadType2.ordinal()] = 2;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LoadType.REFRESH.ordinal()] = 1;
            iArr2[loadType.ordinal()] = 2;
            iArr2[loadType2.ordinal()] = 3;
        }
    }

    private final void handleInsert(PageEvent.Insert<T> insert) {
        this.loadStates.set(insert.getCombinedLoadStates());
        int i11 = WhenMappings.$EnumSwitchMapping$1[insert.getLoadType().ordinal()];
        if (i11 == 1) {
            this.pages.clear();
            this.placeholdersAfter = insert.getPlaceholdersAfter();
            this.placeholdersBefore = insert.getPlaceholdersBefore();
            this.pages.addAll(insert.getPages());
        } else if (i11 == 2) {
            this.placeholdersBefore = insert.getPlaceholdersBefore();
            Iterator it = RangesKt___RangesKt.downTo(insert.getPages().size() - 1, 0).iterator();
            while (it.hasNext()) {
                this.pages.addFirst(insert.getPages().get(((IntIterator) it).nextInt()));
            }
        } else if (i11 == 3) {
            this.placeholdersAfter = insert.getPlaceholdersAfter();
            this.pages.addAll(insert.getPages());
        }
    }

    private final void handleLoadStateUpdate(PageEvent.LoadStateUpdate<T> loadStateUpdate) {
        this.loadStates.set(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator(), loadStateUpdate.getLoadState());
    }

    private final void handlePageDrop(PageEvent.Drop<T> drop) {
        int i11 = 0;
        this.loadStates.set(drop.getLoadType(), false, LoadState.NotLoading.Companion.getIncomplete$paging_common());
        int i12 = WhenMappings.$EnumSwitchMapping$0[drop.getLoadType().ordinal()];
        if (i12 == 1) {
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            int pageCount = drop.getPageCount();
            while (i11 < pageCount) {
                this.pages.removeFirst();
                i11++;
            }
        } else if (i12 == 2) {
            this.placeholdersAfter = drop.getPlaceholdersRemaining();
            int pageCount2 = drop.getPageCount();
            while (i11 < pageCount2) {
                this.pages.removeLast();
                i11++;
            }
        } else {
            throw new IllegalArgumentException("Page drop type must be prepend or append");
        }
    }

    public final void add(@NotNull PageEvent<T> pageEvent) {
        Intrinsics.checkNotNullParameter(pageEvent, "event");
        if (pageEvent instanceof PageEvent.Insert) {
            handleInsert((PageEvent.Insert) pageEvent);
        } else if (pageEvent instanceof PageEvent.Drop) {
            handlePageDrop((PageEvent.Drop) pageEvent);
        } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
            handleLoadStateUpdate((PageEvent.LoadStateUpdate) pageEvent);
        }
    }

    @NotNull
    public final List<PageEvent<T>> getAsEvents() {
        ArrayList arrayList = new ArrayList();
        if (!this.pages.isEmpty()) {
            arrayList.add(PageEvent.Insert.Companion.Refresh(CollectionsKt___CollectionsKt.toList(this.pages), this.placeholdersBefore, this.placeholdersAfter, this.loadStates.snapshot()));
        } else {
            MutableLoadStateCollection mutableLoadStateCollection = this.loadStates;
            LoadStates access$getSource$p = mutableLoadStateCollection.source;
            LoadType loadType = LoadType.REFRESH;
            LoadState refresh = access$getSource$p.getRefresh();
            PageEvent.LoadStateUpdate.Companion companion = PageEvent.LoadStateUpdate.Companion;
            if (companion.canDispatchWithoutInsert$paging_common(refresh, false)) {
                arrayList.add(new PageEvent.LoadStateUpdate(loadType, false, refresh));
            }
            LoadType loadType2 = LoadType.PREPEND;
            LoadState prepend = access$getSource$p.getPrepend();
            if (companion.canDispatchWithoutInsert$paging_common(prepend, false)) {
                arrayList.add(new PageEvent.LoadStateUpdate(loadType2, false, prepend));
            }
            LoadType loadType3 = LoadType.APPEND;
            LoadState append = access$getSource$p.getAppend();
            if (companion.canDispatchWithoutInsert$paging_common(append, false)) {
                arrayList.add(new PageEvent.LoadStateUpdate(loadType3, false, append));
            }
            LoadStates access$getMediator$p = mutableLoadStateCollection.mediator;
            if (access$getMediator$p != null) {
                LoadState refresh2 = access$getMediator$p.getRefresh();
                if (companion.canDispatchWithoutInsert$paging_common(refresh2, true)) {
                    arrayList.add(new PageEvent.LoadStateUpdate(loadType, true, refresh2));
                }
                LoadState prepend2 = access$getMediator$p.getPrepend();
                if (companion.canDispatchWithoutInsert$paging_common(prepend2, true)) {
                    arrayList.add(new PageEvent.LoadStateUpdate(loadType2, true, prepend2));
                }
                LoadState append2 = access$getMediator$p.getAppend();
                if (companion.canDispatchWithoutInsert$paging_common(append2, true)) {
                    arrayList.add(new PageEvent.LoadStateUpdate(loadType3, true, append2));
                }
            }
        }
        return arrayList;
    }
}
