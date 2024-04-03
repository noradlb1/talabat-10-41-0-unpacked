package androidx.paging;

import androidx.annotation.IntRange;
import androidx.paging.PagingSource;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B;\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJY\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0007\u001a\u00020\b26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00150\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0002J\r\u0010$\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\bH\u0016J\u0006\u0010'\u001a\u00020\"J\r\u0010(\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010%J\b\u0010)\u001a\u00020*H\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"Landroidx/paging/PagingState;", "Key", "", "Value", "pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "anchorPosition", "", "config", "Landroidx/paging/PagingConfig;", "leadingPlaceholderCount", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", "getAnchorPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfig", "()Landroidx/paging/PagingConfig;", "getPages", "()Ljava/util/List;", "anchorPositionToPagedIndices", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pageIndex", "index", "anchorPositionToPagedIndices$paging_common", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "closestItemToPosition", "(I)Ljava/lang/Object;", "closestPageToPosition", "equals", "", "other", "firstItemOrNull", "()Ljava/lang/Object;", "hashCode", "isEmpty", "lastItemOrNull", "toString", "", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PagingState<Key, Value> {
    @Nullable
    private final Integer anchorPosition;
    @NotNull
    private final PagingConfig config;
    /* access modifiers changed from: private */
    public final int leadingPlaceholderCount;
    @NotNull
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;

    public PagingState(@NotNull List<PagingSource.LoadResult.Page<Key, Value>> list, @Nullable Integer num, @NotNull PagingConfig pagingConfig, @IntRange(from = 0) int i11) {
        Intrinsics.checkNotNullParameter(list, "pages");
        Intrinsics.checkNotNullParameter(pagingConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.pages = list;
        this.anchorPosition = num;
        this.config = pagingConfig;
        this.leadingPlaceholderCount = i11;
    }

    public final <T> T anchorPositionToPagedIndices$paging_common(int i11, @NotNull Function2<? super Integer, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int access$getLeadingPlaceholderCount$p = i11 - this.leadingPlaceholderCount;
        int i12 = 0;
        while (i12 < CollectionsKt__CollectionsKt.getLastIndex(getPages()) && access$getLeadingPlaceholderCount$p > CollectionsKt__CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) getPages().get(i12)).getData())) {
            access$getLeadingPlaceholderCount$p -= ((PagingSource.LoadResult.Page) getPages().get(i12)).getData().size();
            i12++;
        }
        return function2.invoke(Integer.valueOf(i12), Integer.valueOf(access$getLeadingPlaceholderCount$p));
    }

    @Nullable
    public final Value closestItemToPosition(int i11) {
        boolean z11;
        Iterable iterable = this.pages;
        int i12 = 0;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return null;
        }
        int access$getLeadingPlaceholderCount$p = i11 - this.leadingPlaceholderCount;
        while (i12 < CollectionsKt__CollectionsKt.getLastIndex(getPages()) && access$getLeadingPlaceholderCount$p > CollectionsKt__CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) getPages().get(i12)).getData())) {
            access$getLeadingPlaceholderCount$p -= ((PagingSource.LoadResult.Page) getPages().get(i12)).getData().size();
            i12++;
        }
        for (PagingSource.LoadResult.Page page : this.pages) {
            if (!page.getData().isEmpty()) {
                List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
                ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    PagingSource.LoadResult.Page previous = listIterator.previous();
                    if (!previous.getData().isEmpty()) {
                        if (access$getLeadingPlaceholderCount$p < 0) {
                            return CollectionsKt___CollectionsKt.first(page.getData());
                        }
                        if (i12 != CollectionsKt__CollectionsKt.getLastIndex(this.pages) || access$getLeadingPlaceholderCount$p <= CollectionsKt__CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.last(this.pages)).getData())) {
                            return this.pages.get(i12).getData().get(access$getLeadingPlaceholderCount$p);
                        }
                        return CollectionsKt___CollectionsKt.last(previous.getData());
                    }
                }
                throw new NoSuchElementException("List contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Nullable
    public final PagingSource.LoadResult.Page<Key, Value> closestPageToPosition(int i11) {
        Iterable iterable = this.pages;
        int i12 = 0;
        boolean z11 = true;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z11) {
            return null;
        }
        int access$getLeadingPlaceholderCount$p = i11 - this.leadingPlaceholderCount;
        while (i12 < CollectionsKt__CollectionsKt.getLastIndex(getPages()) && access$getLeadingPlaceholderCount$p > CollectionsKt__CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) getPages().get(i12)).getData())) {
            access$getLeadingPlaceholderCount$p -= ((PagingSource.LoadResult.Page) getPages().get(i12)).getData().size();
            i12++;
        }
        if (access$getLeadingPlaceholderCount$p < 0) {
            return (PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.first(this.pages);
        }
        return this.pages.get(i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof PagingState) {
            PagingState pagingState = (PagingState) obj;
            return Intrinsics.areEqual((Object) this.pages, (Object) pagingState.pages) && Intrinsics.areEqual((Object) this.anchorPosition, (Object) pagingState.anchorPosition) && Intrinsics.areEqual((Object) this.config, (Object) pagingState.config) && this.leadingPlaceholderCount == pagingState.leadingPlaceholderCount;
        }
    }

    @Nullable
    public final Value firstItemOrNull() {
        Object obj;
        List data;
        Iterator it = this.pages.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((PagingSource.LoadResult.Page) obj).getData().isEmpty()) {
                break;
            }
        }
        PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) obj;
        if (page == null || (data = page.getData()) == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.firstOrNull(data);
    }

    @Nullable
    public final Integer getAnchorPosition() {
        return this.anchorPosition;
    }

    @NotNull
    public final PagingConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages() {
        return this.pages;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.pages.hashCode();
        Integer num = this.anchorPosition;
        if (num != null) {
            i11 = num.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11 + this.config.hashCode() + this.leadingPlaceholderCount;
    }

    public final boolean isEmpty() {
        Iterable<PagingSource.LoadResult.Page> iterable = this.pages;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (PagingSource.LoadResult.Page data : iterable) {
            if (!data.getData().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final Value lastItemOrNull() {
        PagingSource.LoadResult.Page<Key, Value> page;
        List data;
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                page = null;
                break;
            }
            page = listIterator.previous();
            if (!page.getData().isEmpty()) {
                break;
            }
        }
        PagingSource.LoadResult.Page page2 = page;
        if (page2 == null || (data = page2.getData()) == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.lastOrNull(data);
    }

    @NotNull
    public String toString() {
        return "PagingState(pages=" + this.pages + ", anchorPosition=" + this.anchorPosition + ", config=" + this.config + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + "leadingPlaceholderCount=" + this.leadingPlaceholderCount + ')';
    }
}
