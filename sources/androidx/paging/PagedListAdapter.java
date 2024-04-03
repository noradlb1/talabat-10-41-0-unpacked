package androidx.paging;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005J\u0018\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H\u0016J\"\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H\u0017J(\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H\u0016J\"\u0010\u0015\u001a\u00020\b2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0011H\u0016J\"\u0010\u0016\u001a\u00020\b2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0012\u0010\u001c\u001a\u00020\u00192\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0017J\u001e\u0010\u001d\u001a\u00020\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0017R&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0000X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R<\u0010\u0014\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u0012\u0004\b&\u0010$R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068VX\u0004¢\u0006\f\u0012\u0004\b)\u0010$\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/paging/PagedListAdapter;", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/paging/PagedList;", "pagedList", "", "submitList", "Ljava/lang/Runnable;", "commitCallback", "", "getItemCount", "currentList", "onCurrentListChanged", "previousList", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "listener", "addLoadStateListener", "removeLoadStateListener", "Landroidx/paging/LoadStateAdapter;", "header", "Landroidx/recyclerview/widget/ConcatAdapter;", "withLoadStateHeader", "footer", "withLoadStateFooter", "withLoadStateHeaderAndFooter", "Landroidx/paging/AsyncPagedListDiffer;", "differ", "Landroidx/paging/AsyncPagedListDiffer;", "getDiffer$paging_runtime_release", "()Landroidx/paging/AsyncPagedListDiffer;", "getDiffer$paging_runtime_release$annotations", "()V", "Lkotlin/jvm/functions/Function2;", "getListener$annotations", "getCurrentList", "()Landroidx/paging/PagedList;", "getCurrentList$annotations", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
@Deprecated(message = "PagedListAdapter is deprecated and has been replaced by PagingDataAdapter", replaceWith = @ReplaceWith(expression = "PagingDataAdapter<T, VH>", imports = {"androidx.paging.PagingDataAdapter"}))
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    @NotNull
    private final AsyncPagedListDiffer<T> differ;
    private final Function2<PagedList<T>, PagedList<T>, Unit> listener;

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    public static /* synthetic */ void getDiffer$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getListener$annotations() {
    }

    public void addLoadStateListener(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.addLoadStateListener(function2);
    }

    @Nullable
    public PagedList<T> getCurrentList() {
        return this.differ.getCurrentList();
    }

    @NotNull
    public final AsyncPagedListDiffer<T> getDiffer$paging_runtime_release() {
        return this.differ;
    }

    public int getItemCount() {
        return this.differ.getItemCount();
    }

    @Deprecated(message = "Use the two argument variant instead.", replaceWith = @ReplaceWith(expression = "onCurrentListChanged(previousList, currentList)", imports = {}))
    public void onCurrentListChanged(@Nullable PagedList<T> pagedList) {
    }

    public void onCurrentListChanged(@Nullable PagedList<T> pagedList, @Nullable PagedList<T> pagedList2) {
    }

    public void removeLoadStateListener(@NotNull Function2<? super LoadType, ? super LoadState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.removeLoadStateListener(function2);
    }

    public void submitList(@Nullable PagedList<T> pagedList) {
        this.differ.submitList(pagedList);
    }

    @NotNull
    public final ConcatAdapter withLoadStateFooter(@NotNull LoadStateAdapter<?> loadStateAdapter) {
        Intrinsics.checkNotNullParameter(loadStateAdapter, "footer");
        addLoadStateListener(new PagedListAdapter$withLoadStateFooter$1(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this, loadStateAdapter});
    }

    @NotNull
    public final ConcatAdapter withLoadStateHeader(@NotNull LoadStateAdapter<?> loadStateAdapter) {
        Intrinsics.checkNotNullParameter(loadStateAdapter, "header");
        addLoadStateListener(new PagedListAdapter$withLoadStateHeader$1(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this});
    }

    @NotNull
    public final ConcatAdapter withLoadStateHeaderAndFooter(@NotNull LoadStateAdapter<?> loadStateAdapter, @NotNull LoadStateAdapter<?> loadStateAdapter2) {
        Intrinsics.checkNotNullParameter(loadStateAdapter, "header");
        Intrinsics.checkNotNullParameter(loadStateAdapter2, "footer");
        addLoadStateListener(new PagedListAdapter$withLoadStateHeaderAndFooter$1(loadStateAdapter, loadStateAdapter2));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this, loadStateAdapter2});
    }

    public void submitList(@Nullable PagedList<T> pagedList, @Nullable Runnable runnable) {
        this.differ.submitList(pagedList, runnable);
    }
}
