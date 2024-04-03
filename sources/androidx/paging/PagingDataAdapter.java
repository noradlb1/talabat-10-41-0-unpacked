package androidx.paging;

import androidx.annotation.IntRange;
import androidx.lifecycle.Lifecycle;
import androidx.paging.LoadState;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B)\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0004¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0017\u0010 \u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010!\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0006\u0010\"\u001a\u00020\u0016J\u001a\u0010#\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u0018J\u0006\u0010$\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0014J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+J\u001c\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000J\u001f\u0010,\u001a\u00020\u00162\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0012\u00102\u001a\u0002032\n\u00104\u001a\u0006\u0012\u0002\b\u000305J\u0012\u00106\u001a\u0002032\n\u00107\u001a\u0006\u0012\u0002\b\u000305J\u001e\u00108\u001a\u0002032\n\u00107\u001a\u0006\u0012\u0002\b\u0003052\n\u00104\u001a\u0006\u0012\u0002\b\u000305R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Landroidx/paging/PagingDataAdapter;", "T", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "workerDispatcher", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "userSetRestorationPolicy", "", "addLoadStateListener", "", "listener", "Lkotlin/Function1;", "getItem", "position", "", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "peek", "index", "refresh", "removeLoadStateListener", "retry", "setHasStableIds", "hasStableIds", "setStateRestorationPolicy", "strategy", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "submitData", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "pagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLoadStateFooter", "Landroidx/recyclerview/widget/ConcatAdapter;", "footer", "Landroidx/paging/LoadStateAdapter;", "withLoadStateHeader", "header", "withLoadStateHeaderAndFooter", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagingDataDiffer<T> differ;
    @NotNull
    private final Flow<CombinedLoadStates> loadStateFlow;
    /* access modifiers changed from: private */
    public boolean userSetRestorationPolicy;

    @JvmOverloads
    public PagingDataAdapter(@NotNull DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, (CoroutineDispatcher) null, (CoroutineDispatcher) null, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PagingDataAdapter(@NotNull DiffUtil.ItemCallback<T> itemCallback, @NotNull CoroutineDispatcher coroutineDispatcher) {
        this(itemCallback, coroutineDispatcher, (CoroutineDispatcher) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i11 & 2) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i11 & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher2);
    }

    public final void addLoadStateListener(@NotNull Function1<? super CombinedLoadStates, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.addLoadStateListener(function1);
    }

    @Nullable
    public final T getItem(@IntRange(from = 0) int i11) {
        return this.differ.getItem(i11);
    }

    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public final long getItemId(int i11) {
        return super.getItemId(i11);
    }

    @NotNull
    public final Flow<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    @Nullable
    public final T peek(@IntRange(from = 0) int i11) {
        return this.differ.peek(i11);
    }

    public final void refresh() {
        this.differ.refresh();
    }

    public final void removeLoadStateListener(@NotNull Function1<? super CombinedLoadStates, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.removeLoadStateListener(function1);
    }

    public final void retry() {
        this.differ.retry();
    }

    public final void setHasStableIds(boolean z11) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    public void setStateRestorationPolicy(@NotNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        Intrinsics.checkNotNullParameter(stateRestorationPolicy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    @NotNull
    public final ItemSnapshotList<T> snapshot() {
        return this.differ.snapshot();
    }

    @Nullable
    public final Object submitData(@NotNull PagingData<T> pagingData, @NotNull Continuation<? super Unit> continuation) {
        Object submitData = this.differ.submitData(pagingData, continuation);
        if (submitData == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return submitData;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final ConcatAdapter withLoadStateFooter(@NotNull LoadStateAdapter<?> loadStateAdapter) {
        Intrinsics.checkNotNullParameter(loadStateAdapter, "footer");
        addLoadStateListener(new PagingDataAdapter$withLoadStateFooter$1(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this, loadStateAdapter});
    }

    @NotNull
    public final ConcatAdapter withLoadStateHeader(@NotNull LoadStateAdapter<?> loadStateAdapter) {
        Intrinsics.checkNotNullParameter(loadStateAdapter, "header");
        addLoadStateListener(new PagingDataAdapter$withLoadStateHeader$1(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this});
    }

    @NotNull
    public final ConcatAdapter withLoadStateHeaderAndFooter(@NotNull LoadStateAdapter<?> loadStateAdapter, @NotNull LoadStateAdapter<?> loadStateAdapter2) {
        Intrinsics.checkNotNullParameter(loadStateAdapter, "header");
        Intrinsics.checkNotNullParameter(loadStateAdapter2, "footer");
        addLoadStateListener(new PagingDataAdapter$withLoadStateHeaderAndFooter$1(loadStateAdapter, loadStateAdapter2));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this, loadStateAdapter2});
    }

    @JvmOverloads
    public PagingDataAdapter(@NotNull DiffUtil.ItemCallback<T> itemCallback, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(itemCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "workerDispatcher");
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer = new AsyncPagingDataDiffer<>(itemCallback, new AdapterListUpdateCallback(this), coroutineDispatcher, coroutineDispatcher2);
        this.differ = asyncPagingDataDiffer;
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        final AnonymousClass1 r32 = new Function0<Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ PagingDataAdapter f36870g;

            {
                this.f36870g = r1;
            }

            public final void invoke() {
                if (this.f36870g.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT && !this.f36870g.userSetRestorationPolicy) {
                    this.f36870g.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
                }
            }
        };
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PagingDataAdapter f36871a;

            {
                this.f36871a = r1;
            }

            public void onItemRangeInserted(int i11, int i12) {
                r32.invoke();
                this.f36871a.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(i11, i12);
            }
        });
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>(this) {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PagingDataAdapter f36873b;
            private boolean ignoreNextEvent = true;

            {
                this.f36873b = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CombinedLoadStates) obj);
                return Unit.INSTANCE;
            }

            public void invoke(@NotNull CombinedLoadStates combinedLoadStates) {
                Intrinsics.checkNotNullParameter(combinedLoadStates, "loadStates");
                if (this.ignoreNextEvent) {
                    this.ignoreNextEvent = false;
                } else if (combinedLoadStates.getSource().getRefresh() instanceof LoadState.NotLoading) {
                    r32.invoke();
                    this.f36873b.removeLoadStateListener(this);
                }
            }
        });
        this.loadStateFlow = asyncPagingDataDiffer.getLoadStateFlow();
    }

    public final void submitData(@NotNull Lifecycle lifecycle, @NotNull PagingData<T> pagingData) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(pagingData, "pagingData");
        this.differ.submitData(lifecycle, pagingData);
    }
}
