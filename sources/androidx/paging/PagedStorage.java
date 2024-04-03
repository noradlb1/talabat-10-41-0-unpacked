package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.LegacyPageFetcher;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001YB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fB\u0015\b\u0012\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\u000eJ+\u00100\u001a\u0002012\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0000¢\u0006\u0002\b4J\u0018\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u00106\u001a\u00020\bH\u0002¢\u0006\u0002\u00107J\u0015\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00020\bH\u0016¢\u0006\u0002\u00107J\u001a\u0010:\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010;2\u0006\u0010<\u001a\u00020=JD\u0010>\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J:\u0010>\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002J\u0016\u0010C\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bJ\u0016\u0010D\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bJ+\u0010E\u001a\u0002012\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0000¢\u0006\u0002\bFJ\u001e\u0010G\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010J\u001a\u00020KH\u0016J`\u0010L\u001a\u0002HM\"\u0004\b\u0001\u0010M2\u0006\u00109\u001a\u00020\b2B\b\u0004\u0010N\u001a<\u0012\u001d\u0012\u001b\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u0002HM0OH\b¢\u0006\u0002\u0010SJ-\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bVJ-\u0010W\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bXR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00028\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00028\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u001d\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u001e\u0010!\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n0\"X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001e\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u001e\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0013R\u0014\u0010,\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0017R\u001e\u0010.\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017¨\u0006Z"}, d2 = {"Landroidx/paging/PagedStorage;", "T", "", "Ljava/util/AbstractList;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/NullPaddedList;", "()V", "leadingNulls", "", "page", "Landroidx/paging/PagingSource$LoadResult$Page;", "trailingNulls", "(ILandroidx/paging/PagingSource$LoadResult$Page;I)V", "other", "(Landroidx/paging/PagedStorage;)V", "counted", "", "firstLoadedItem", "getFirstLoadedItem$paging_common", "()Ljava/lang/Object;", "value", "lastLoadAroundIndex", "getLastLoadAroundIndex", "()I", "setLastLoadAroundIndex", "(I)V", "lastLoadAroundLocalIndex", "lastLoadedItem", "getLastLoadedItem$paging_common", "middleOfLoadedRange", "getMiddleOfLoadedRange", "nextKey", "getNextKey", "pages", "", "<set-?>", "placeholdersAfter", "getPlaceholdersAfter", "placeholdersBefore", "getPlaceholdersBefore", "positionOffset", "getPositionOffset", "prevKey", "getPrevKey", "size", "getSize", "storageCount", "getStorageCount", "appendPage", "", "callback", "Landroidx/paging/PagedStorage$Callback;", "appendPage$paging_common", "get", "index", "(I)Ljava/lang/Object;", "getFromStorage", "localIndex", "getRefreshKeyInfo", "Landroidx/paging/PagingState;", "config", "Landroidx/paging/PagedList$Config;", "init", "needsTrim", "maxSize", "requiredRemaining", "localPageIndex", "needsTrimFromEnd", "needsTrimFromFront", "prependPage", "prependPage$paging_common", "shouldPreTrimNewPage", "countToBeAdded", "snapshot", "toString", "", "traversePages", "V", "onLastPage", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pageInternalIndex", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "trimFromEnd", "insertNulls", "trimFromEnd$paging_common", "trimFromFront", "trimFromFront$paging_common", "Callback", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, NullPaddedList<T> {
    private boolean counted;
    private int lastLoadAroundLocalIndex;
    /* access modifiers changed from: private */
    public final List<PagingSource.LoadResult.Page<?, T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int positionOffset;
    private int storageCount;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagedStorage$Callback;", "", "onInitialized", "", "count", "", "onPageAppended", "endPosition", "changed", "added", "onPagePrepended", "leadingNulls", "onPagesRemoved", "startOfDrops", "onPagesSwappedToPlaceholder", "paging-common"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void onInitialized(int i11);

        void onPageAppended(int i11, int i12, int i13);

        void onPagePrepended(int i11, int i12, int i13);

        void onPagesRemoved(int i11, int i12);

        void onPagesSwappedToPlaceholder(int i11, int i12);
    }

    public PagedStorage() {
        this.pages = new ArrayList();
        this.counted = true;
    }

    public static /* synthetic */ void appendPage$paging_common$default(PagedStorage pagedStorage, PagingSource.LoadResult.Page page, Callback callback, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            callback = null;
        }
        pagedStorage.appendPage$paging_common(page, callback);
    }

    private final void init(int i11, PagingSource.LoadResult.Page<?, T> page, int i12, int i13, boolean z11) {
        this.placeholdersBefore = i11;
        this.pages.clear();
        this.pages.add(page);
        this.placeholdersAfter = i12;
        this.positionOffset = i13;
        this.storageCount = page.getData().size();
        this.counted = z11;
        this.lastLoadAroundLocalIndex = page.getData().size() / 2;
    }

    public static /* synthetic */ void init$default(PagedStorage pagedStorage, int i11, PagingSource.LoadResult.Page page, int i12, int i13, Callback callback, boolean z11, int i14, Object obj) {
        if ((i14 & 32) != 0) {
            z11 = true;
        }
        pagedStorage.init(i11, page, i12, i13, callback, z11);
    }

    private final boolean needsTrim(int i11, int i12, int i13) {
        PagingSource.LoadResult.Page page = this.pages.get(i13);
        if (getStorageCount() <= i11 || this.pages.size() <= 2 || getStorageCount() - page.getData().size() < i12) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void prependPage$paging_common$default(PagedStorage pagedStorage, PagingSource.LoadResult.Page page, Callback callback, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            callback = null;
        }
        pagedStorage.prependPage$paging_common(page, callback);
    }

    private final <V> V traversePages(int i11, Function2<? super PagingSource.LoadResult.Page<?, T>, ? super Integer, ? extends V> function2) {
        int size = this.pages.size();
        int i12 = 0;
        while (i12 < size) {
            int size2 = ((PagingSource.LoadResult.Page) this.pages.get(i12)).getData().size();
            if (size2 > i11) {
                break;
            }
            i11 -= size2;
            i12++;
        }
        return function2.invoke(this.pages.get(i12), Integer.valueOf(i11));
    }

    public final void appendPage$paging_common(@NotNull PagingSource.LoadResult.Page<?, T> page, @Nullable Callback callback) {
        Intrinsics.checkNotNullParameter(page, "page");
        int size = page.getData().size();
        if (size != 0) {
            this.pages.add(page);
            this.storageCount = getStorageCount() + size;
            int min = Math.min(getPlaceholdersAfter(), size);
            int i11 = size - min;
            if (min != 0) {
                this.placeholdersAfter = getPlaceholdersAfter() - min;
            }
            if (callback != null) {
                callback.onPageAppended((getPlaceholdersBefore() + getStorageCount()) - size, min, i11);
            }
        }
    }

    @Nullable
    public T get(int i11) {
        int placeholdersBefore2 = i11 - getPlaceholdersBefore();
        if (i11 < 0 || i11 >= size()) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + size());
        } else if (placeholdersBefore2 < 0 || placeholdersBefore2 >= getStorageCount()) {
            return null;
        } else {
            return getFromStorage(placeholdersBefore2);
        }
    }

    @NotNull
    public final T getFirstLoadedItem$paging_common() {
        return CollectionsKt___CollectionsKt.first(((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.first(this.pages)).getData());
    }

    @NotNull
    public T getFromStorage(int i11) {
        int size = this.pages.size();
        int i12 = 0;
        while (i12 < size) {
            int size2 = ((PagingSource.LoadResult.Page) this.pages.get(i12)).getData().size();
            if (size2 > i11) {
                break;
            }
            i11 -= size2;
            i12++;
        }
        return ((PagingSource.LoadResult.Page) this.pages.get(i12)).getData().get(i11);
    }

    public final int getLastLoadAroundIndex() {
        return getPlaceholdersBefore() + this.lastLoadAroundLocalIndex;
    }

    @NotNull
    public final T getLastLoadedItem$paging_common() {
        return CollectionsKt___CollectionsKt.last(((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.last(this.pages)).getData());
    }

    public final int getMiddleOfLoadedRange() {
        return getPlaceholdersBefore() + (getStorageCount() / 2);
    }

    @Nullable
    public Object getNextKey() {
        if (!this.counted || getPlaceholdersAfter() > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.last(this.pages)).getNextKey();
        }
        return null;
    }

    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final int getPositionOffset() {
        return this.positionOffset;
    }

    @Nullable
    public Object getPrevKey() {
        if (!this.counted || getPlaceholdersBefore() + this.positionOffset > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.first(this.pages)).getPrevKey();
        }
        return null;
    }

    @Nullable
    public final PagingState<?, T> getRefreshKeyInfo(@NotNull PagedList.Config config) {
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        if (this.pages.isEmpty()) {
            return null;
        }
        List list = CollectionsKt___CollectionsKt.toList(this.pages);
        if (list != null) {
            return new PagingState<>(list, Integer.valueOf(getLastLoadAroundIndex()), new PagingConfig(config.pageSize, config.prefetchDistance, config.enablePlaceholders, config.initialLoadSizeHint, config.maxSize, 0, 32, (DefaultConstructorMarker) null), getPlaceholdersBefore());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T>>");
    }

    public int getSize() {
        return getPlaceholdersBefore() + getStorageCount() + getPlaceholdersAfter();
    }

    public int getStorageCount() {
        return this.storageCount;
    }

    public final boolean needsTrimFromEnd(int i11, int i12) {
        return needsTrim(i11, i12, this.pages.size() - 1);
    }

    public final boolean needsTrimFromFront(int i11, int i12) {
        return needsTrim(i11, i12, 0);
    }

    public final void prependPage$paging_common(@NotNull PagingSource.LoadResult.Page<?, T> page, @Nullable Callback callback) {
        Intrinsics.checkNotNullParameter(page, "page");
        int size = page.getData().size();
        if (size != 0) {
            this.pages.add(0, page);
            this.storageCount = getStorageCount() + size;
            int min = Math.min(getPlaceholdersBefore(), size);
            int i11 = size - min;
            if (min != 0) {
                this.placeholdersBefore = getPlaceholdersBefore() - min;
            }
            this.positionOffset -= i11;
            if (callback != null) {
                callback.onPagePrepended(getPlaceholdersBefore(), min, i11);
            }
        }
    }

    public final /* bridge */ T remove(int i11) {
        return removeAt(i11);
    }

    public /* bridge */ Object removeAt(int i11) {
        return super.remove(i11);
    }

    public final void setLastLoadAroundIndex(int i11) {
        this.lastLoadAroundLocalIndex = RangesKt___RangesKt.coerceIn(i11 - getPlaceholdersBefore(), 0, getStorageCount() - 1);
    }

    public final boolean shouldPreTrimNewPage(int i11, int i12, int i13) {
        return getStorageCount() + i13 > i11 && this.pages.size() > 1 && getStorageCount() >= i12;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public final PagedStorage<T> snapshot() {
        return new PagedStorage<>(this);
    }

    @NotNull
    public String toString() {
        return "leading " + getPlaceholdersBefore() + ", storage " + getStorageCount() + ", trailing " + getPlaceholdersAfter() + ' ' + CollectionsKt___CollectionsKt.joinToString$default(this.pages, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final boolean trimFromEnd$paging_common(boolean z11, int i11, int i12, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i13 = 0;
        while (needsTrimFromEnd(i11, i12)) {
            List<PagingSource.LoadResult.Page<?, T>> list = this.pages;
            int size = list.remove(list.size() - 1).getData().size();
            i13 += size;
            this.storageCount = getStorageCount() - size;
        }
        this.lastLoadAroundLocalIndex = RangesKt___RangesKt.coerceAtMost(this.lastLoadAroundLocalIndex, getStorageCount() - 1);
        if (i13 > 0) {
            int placeholdersBefore2 = getPlaceholdersBefore() + getStorageCount();
            if (z11) {
                this.placeholdersAfter = getPlaceholdersAfter() + i13;
                callback.onPagesSwappedToPlaceholder(placeholdersBefore2, i13);
            } else {
                callback.onPagesRemoved(placeholdersBefore2, i13);
            }
        }
        if (i13 > 0) {
            return true;
        }
        return false;
    }

    public final boolean trimFromFront$paging_common(boolean z11, int i11, int i12, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i13 = 0;
        while (needsTrimFromFront(i11, i12)) {
            int size = this.pages.remove(0).getData().size();
            i13 += size;
            this.storageCount = getStorageCount() - size;
        }
        this.lastLoadAroundLocalIndex = RangesKt___RangesKt.coerceAtLeast(this.lastLoadAroundLocalIndex - i13, 0);
        if (i13 > 0) {
            if (z11) {
                int placeholdersBefore2 = getPlaceholdersBefore();
                this.placeholdersBefore = getPlaceholdersBefore() + i13;
                callback.onPagesSwappedToPlaceholder(placeholdersBefore2, i13);
            } else {
                this.positionOffset += i13;
                callback.onPagesRemoved(getPlaceholdersBefore(), i13);
            }
        }
        if (i13 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PagedStorage(int i11, @NotNull PagingSource.LoadResult.Page<?, T> page, int i12) {
        this();
        Intrinsics.checkNotNullParameter(page, "page");
        init(i11, page, i12, 0, true);
    }

    private PagedStorage(PagedStorage<T> pagedStorage) {
        ArrayList arrayList = new ArrayList();
        this.pages = arrayList;
        this.counted = true;
        arrayList.addAll(pagedStorage.pages);
        this.placeholdersBefore = pagedStorage.getPlaceholdersBefore();
        this.placeholdersAfter = pagedStorage.getPlaceholdersAfter();
        this.positionOffset = pagedStorage.positionOffset;
        this.counted = pagedStorage.counted;
        this.storageCount = pagedStorage.getStorageCount();
        this.lastLoadAroundLocalIndex = pagedStorage.lastLoadAroundLocalIndex;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void init(int i11, @NotNull PagingSource.LoadResult.Page<?, T> page, int i12, int i13, @NotNull Callback callback, boolean z11) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(callback, "callback");
        init(i11, page, i12, i13, z11);
        callback.onInitialized(size());
    }
}
