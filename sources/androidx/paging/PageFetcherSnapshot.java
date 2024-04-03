package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageFetcherSnapshotState;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0001\u0012\b\u0010=\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A\u0012\u0006\u0010G\u001a\u00020F\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c\u0012\b\b\u0002\u0010K\u001a\u00020J\u0012\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010M\u0012\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0019\u0012\u000e\b\u0002\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00050T¢\u0006\u0004\bW\u0010XJ\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0011\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0005J\u001f\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000e0\u001c2\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001bJ#\u0010\"\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J+\u0010$\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R \u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0001000/8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R \u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001038\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R#\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0001000\u001c8\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00018\u00008\u0000X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R&\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A8\u0000X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010:R\u0014\u0010K\u001a\u00020J8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR%\u0010N\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\"\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00050T8\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "startConsumingHints", "Landroidx/paging/LoadType;", "loadType", "key", "Landroidx/paging/PagingSource$LoadParams;", "loadParams", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "Landroidx/paging/PageFetcherSnapshotState;", "", "generationId", "presentedItemsBeyondAnchor", "nextLoadKeyOrNull", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "Landroidx/paging/ViewportHint;", "viewportHint", "d", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accessHint", "close", "Landroidx/paging/PagingState;", "currentPagingState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "a", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Landroidx/paging/GenerationalViewportHint;", "generationalHint", "c", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "hintSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/paging/ViewportHint$Access;", "lastHint", "Landroidx/paging/ViewportHint$Access;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageEventChCollected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageEvent;", "pageEventCh", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "stateHolder", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "Lkotlinx/coroutines/CompletableJob;", "pageEventChannelFlowJob", "Lkotlinx/coroutines/CompletableJob;", "pageEventFlow", "Lkotlinx/coroutines/flow/Flow;", "getPageEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "initialKey", "Ljava/lang/Object;", "getInitialKey$paging_common", "()Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/PagingSource;", "getPagingSource$paging_common", "()Landroidx/paging/PagingSource;", "Landroidx/paging/PagingConfig;", "config", "Landroidx/paging/PagingConfig;", "retryFlow", "", "triggerRemoteRefresh", "Z", "Landroidx/paging/RemoteMediatorConnection;", "remoteMediatorConnection", "Landroidx/paging/RemoteMediatorConnection;", "getRemoteMediatorConnection", "()Landroidx/paging/RemoteMediatorConnection;", "previousPagingState", "Landroidx/paging/PagingState;", "Lkotlin/Function0;", "invalidate", "Lkotlin/jvm/functions/Function0;", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/Flow;ZLandroidx/paging/RemoteMediatorConnection;Landroidx/paging/PagingState;Lkotlin/jvm/functions/Function0;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PageFetcherSnapshot<Key, Value> {
    /* access modifiers changed from: private */
    public final PagingConfig config;
    /* access modifiers changed from: private */
    public final MutableSharedFlow<ViewportHint> hintSharedFlow;
    @Nullable
    private final Key initialKey;
    /* access modifiers changed from: private */
    public final Function0<Unit> invalidate;
    /* access modifiers changed from: private */
    public ViewportHint.Access lastHint;
    /* access modifiers changed from: private */
    public final Channel<PageEvent<Value>> pageEventCh;
    /* access modifiers changed from: private */
    public final AtomicBoolean pageEventChCollected;
    private final CompletableJob pageEventChannelFlowJob;
    @NotNull
    private final Flow<PageEvent<Value>> pageEventFlow;
    @NotNull
    private final PagingSource<Key, Value> pagingSource;
    /* access modifiers changed from: private */
    public final PagingState<Key, Value> previousPagingState;
    @Nullable
    private final RemoteMediatorConnection<Key, Value> remoteMediatorConnection;
    /* access modifiers changed from: private */
    public final Flow<Unit> retryFlow;
    /* access modifiers changed from: private */
    public final PageFetcherSnapshotState.Holder<Key, Value> stateHolder;
    /* access modifiers changed from: private */
    public final boolean triggerRemoteRefresh;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.REFRESH;
            iArr[loadType.ordinal()] = 1;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[loadType.ordinal()] = 1;
            int[] iArr3 = new int[LoadType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            LoadType loadType2 = LoadType.PREPEND;
            iArr3[loadType2.ordinal()] = 1;
            LoadType loadType3 = LoadType.APPEND;
            iArr3[loadType3.ordinal()] = 2;
            iArr3[loadType.ordinal()] = 3;
            int[] iArr4 = new int[LoadType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[loadType2.ordinal()] = 1;
            iArr4[loadType3.ordinal()] = 2;
            int[] iArr5 = new int[LoadType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[loadType2.ordinal()] = 1;
        }
    }

    public PageFetcherSnapshot(@Nullable Key key, @NotNull PagingSource<Key, Value> pagingSource2, @NotNull PagingConfig pagingConfig, @NotNull Flow<Unit> flow, boolean z11, @Nullable RemoteMediatorConnection<Key, Value> remoteMediatorConnection2, @Nullable PagingState<Key, Value> pagingState, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(pagingSource2, "pagingSource");
        Intrinsics.checkNotNullParameter(pagingConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(flow, "retryFlow");
        Intrinsics.checkNotNullParameter(function0, "invalidate");
        this.initialKey = key;
        this.pagingSource = pagingSource2;
        this.config = pagingConfig;
        this.retryFlow = flow;
        this.triggerRemoteRefresh = z11;
        this.remoteMediatorConnection = remoteMediatorConnection2;
        this.previousPagingState = pagingState;
        this.invalidate = function0;
        if (pagingConfig.jumpThreshold == Integer.MIN_VALUE || pagingSource2.getJumpingSupported()) {
            this.hintSharedFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);
            this.pageEventChCollected = new AtomicBoolean(false);
            this.pageEventCh = ChannelKt.Channel$default(-2, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            this.stateHolder = new PageFetcherSnapshotState.Holder<>(pagingConfig);
            CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
            this.pageEventChannelFlowJob = Job$default;
            this.pageEventFlow = CancelableChannelFlowKt.cancelableChannelFlow(Job$default, new PageFetcherSnapshot$pageEventFlow$1(this, (Continuation) null));
            return;
        }
        throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
    }

    private final PagingSource.LoadParams<Key> loadParams(LoadType loadType, Key key) {
        int i11;
        PagingSource.LoadParams.Companion companion = PagingSource.LoadParams.Companion;
        if (loadType == LoadType.REFRESH) {
            i11 = this.config.initialLoadSize;
        } else {
            i11 = this.config.pageSize;
        }
        return companion.create(loadType, key, i11, this.config.enablePlaceholders);
    }

    private final Key nextLoadKeyOrNull(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, int i11, int i12) {
        if (i11 != pageFetcherSnapshotState.generationId$paging_common(loadType) || (pageFetcherSnapshotState.getSourceLoadStates$paging_common().get$paging_common(loadType) instanceof LoadState.Error) || i12 >= this.config.prefetchDistance) {
            return null;
        }
        if (loadType == LoadType.PREPEND) {
            return ((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.first(pageFetcherSnapshotState.getPages$paging_common())).getPrevKey();
        }
        return ((PagingSource.LoadResult.Page) CollectionsKt___CollectionsKt.last(pageFetcherSnapshotState.getPages$paging_common())).getNextKey();
    }

    /* access modifiers changed from: private */
    public final void startConsumingHints(CoroutineScope coroutineScope) {
        if (this.config.jumpThreshold != Integer.MIN_VALUE) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageFetcherSnapshot$startConsumingHints$1(this, (Continuation) null), 3, (Object) null);
        }
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageFetcherSnapshot$startConsumingHints$2(this, (Continuation) null), 3, (Object) null);
        Job unused3 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageFetcherSnapshot$startConsumingHints$3(this, (Continuation) null), 3, (Object) null);
    }

    public final /* synthetic */ Object a(Flow<Integer> flow, LoadType loadType, Continuation<? super Unit> continuation) {
        Object collect = FlowKt.conflate(FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(flow, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1((Continuation) null, this, loadType)), new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(loadType, (Continuation) null))).collect(new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$collect$1(this, loadType), continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    public final void accessHint(@NotNull ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        if (viewportHint instanceof ViewportHint.Access) {
            this.lastHint = (ViewportHint.Access) viewportHint;
        }
        this.hintSharedFlow.tryEmit(viewportHint);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0268, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0269, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x026a, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x026d, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0270, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadResult.Error) == false) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0272, code lost:
        r5 = r7.stateHolder;
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r5);
        r0.f36782k = r7;
        r0.f36783l = r6;
        r0.f36784m = r5;
        r0.f36785n = r12;
        r0.f36780i = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0288, code lost:
        if (r12.lock((java.lang.Object) null, r0) != r1) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x028a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r2 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5);
        r5 = new androidx.paging.LoadState.Error(((androidx.paging.PagingSource.LoadResult.Error) r6).getThrowable());
        r6 = androidx.paging.LoadType.REFRESH;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02a0, code lost:
        if (r2.setSourceLoadState(r6, r5) == false) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02a2, code lost:
        r2 = r7.pageEventCh;
        r7 = new androidx.paging.PageEvent.LoadStateUpdate(r6, false, r5);
        r0.f36782k = r12;
        r0.f36783l = null;
        r0.f36784m = null;
        r0.f36785n = null;
        r0.f36780i = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02b9, code lost:
        if (r2.send(r7, r0) != r1) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02bb, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02bc, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02bf, code lost:
        r0.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02c4, code lost:
        r10 = r0;
        r0 = r12;
        r12 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02c7, code lost:
        r0.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ca, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02cd, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5);
        r5 = androidx.paging.LoadType.REFRESH;
        r0.f36782k = r6;
        r0.f36783l = r2;
        r0.f36784m = null;
        r0.f36780i = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0110, code lost:
        if (r6.e(r12, r5, r0) != r1) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0112, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0113, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0116, code lost:
        r2.unlock((java.lang.Object) null);
        r12 = r5.loadParams(androidx.paging.LoadType.REFRESH, r5.initialKey);
        r2 = r5.pagingSource;
        r0.f36782k = r5;
        r0.f36783l = null;
        r0.f36780i = 3;
        r12 = r2.load(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012e, code lost:
        if (r12 != r1) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0130, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0131, code lost:
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0132, code lost:
        r6 = (androidx.paging.PagingSource.LoadResult) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0137, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadResult.Page) == false) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0139, code lost:
        r5 = r7.stateHolder;
        r2 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r5);
        r0.f36782k = r7;
        r0.f36783l = r6;
        r0.f36784m = r5;
        r0.f36785n = r2;
        r0.f36780i = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x014e, code lost:
        if (r2.lock((java.lang.Object) null, r0) != r1) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0150, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5).insert(0, androidx.paging.LoadType.REFRESH, (androidx.paging.PagingSource.LoadResult.Page) r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0162, code lost:
        r2.unlock((java.lang.Object) null);
        r2 = r12.booleanValue();
        r5 = r7.stateHolder;
        r3 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r5);
        r0.f36782k = r7;
        r0.f36783l = r6;
        r0.f36784m = r5;
        r0.f36785n = r3;
        r0.f36786o = r2;
        r0.f36780i = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0180, code lost:
        if (r3.lock((java.lang.Object) null, r0) != r1) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0182, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5);
        r5 = androidx.paging.LoadType.REFRESH;
        r8 = androidx.paging.LoadState.NotLoading.Companion;
        r12.setSourceLoadState(r5, r8.getIncomplete$paging_common());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0199, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r6).getPrevKey() != null) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x019b, code lost:
        r12.setSourceLoadState(androidx.paging.LoadType.PREPEND, r8.getComplete$paging_common());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ab, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r6).getNextKey() != null) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ad, code lost:
        r12.setSourceLoadState(androidx.paging.LoadType.APPEND, r8.getComplete$paging_common());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b6, code lost:
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01bb, code lost:
        if (r2 == false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01bd, code lost:
        r3 = r7.stateHolder;
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r3);
        r0.f36782k = r7;
        r0.f36783l = r6;
        r0.f36784m = r3;
        r0.f36785n = r12;
        r0.f36780i = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01d2, code lost:
        if (r12.lock((java.lang.Object) null, r0) != r1) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01d4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01d5, code lost:
        r2 = r12;
        r5 = r6;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r3);
        r3 = r6.pageEventCh;
        r12 = r12.toPageEvent$paging_common((androidx.paging.PagingSource.LoadResult.Page) r5, androidx.paging.LoadType.REFRESH);
        r0.f36782k = r6;
        r0.f36783l = r5;
        r0.f36784m = r2;
        r0.f36785n = null;
        r0.f36780i = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01f6, code lost:
        if (r3.send(r12, r0) != r1) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01f8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f9, code lost:
        r3 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01fb, code lost:
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01fd, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0205, code lost:
        r3 = r6;
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0209, code lost:
        if (r5.remoteMediatorConnection == null) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x020b, code lost:
        r12 = (androidx.paging.PagingSource.LoadResult.Page) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0212, code lost:
        if (r12.getPrevKey() == null) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0218, code lost:
        if (r12.getNextKey() != null) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x021a, code lost:
        r2 = r5.stateHolder;
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r2);
        r0.f36782k = r5;
        r0.f36783l = r3;
        r0.f36784m = r2;
        r0.f36785n = r12;
        r0.f36780i = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0230, code lost:
        if (r12.lock((java.lang.Object) null, r0) != r1) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0232, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0233, code lost:
        r1 = r12;
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r12 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r2).currentPagingState$paging_common(r0.lastHint);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x023f, code lost:
        r1.unlock((java.lang.Object) null);
        r3 = (androidx.paging.PagingSource.LoadResult.Page) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0248, code lost:
        if (r3.getPrevKey() != null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x024a, code lost:
        r0.remoteMediatorConnection.requestLoad(androidx.paging.LoadType.PREPEND, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0255, code lost:
        if (r3.getNextKey() != null) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0257, code lost:
        r0.remoteMediatorConnection.requestLoad(androidx.paging.LoadType.APPEND, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x025f, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0260, code lost:
        r1.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0263, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0264, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0265, code lost:
        r3.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.paging.PageFetcherSnapshot$doInitialLoad$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.paging.PageFetcherSnapshot$doInitialLoad$1 r0 = (androidx.paging.PageFetcherSnapshot$doInitialLoad$1) r0
            int r1 = r0.f36780i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36780i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcherSnapshot$doInitialLoad$1 r0 = new androidx.paging.PageFetcherSnapshot$doInitialLoad$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f36779h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36780i
            r3 = 0
            r4 = 0
            switch(r2) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00d2;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00a4;
                case 5: goto L_0x008d;
                case 6: goto L_0x0078;
                case 7: goto L_0x0064;
                case 8: goto L_0x004f;
                case 9: goto L_0x0039;
                case 10: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x002d:
            java.lang.Object r0 = r0.f36782k
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0036 }
            goto L_0x02bd
        L_0x0036:
            r12 = move-exception
            goto L_0x02c7
        L_0x0039:
            java.lang.Object r2 = r0.f36785n
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36784m
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36783l
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r7 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r7 = (androidx.paging.PageFetcherSnapshot) r7
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r2
            goto L_0x028b
        L_0x004f:
            java.lang.Object r1 = r0.f36785n
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.f36784m
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r3 = r0.f36783l
            androidx.paging.PagingSource$LoadResult r3 = (androidx.paging.PagingSource.LoadResult) r3
            java.lang.Object r0 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0235
        L_0x0064:
            java.lang.Object r2 = r0.f36784m
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r3 = r0.f36783l
            androidx.paging.PagingSource$LoadResult r3 = (androidx.paging.PagingSource.LoadResult) r3
            java.lang.Object r5 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r5 = (androidx.paging.PageFetcherSnapshot) r5
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0075 }
            goto L_0x01fb
        L_0x0075:
            r12 = move-exception
            goto L_0x0201
        L_0x0078:
            java.lang.Object r2 = r0.f36785n
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r3 = r0.f36784m
            androidx.paging.PageFetcherSnapshotState$Holder r3 = (androidx.paging.PageFetcherSnapshotState.Holder) r3
            java.lang.Object r5 = r0.f36783l
            androidx.paging.PagingSource$LoadResult r5 = (androidx.paging.PagingSource.LoadResult) r5
            java.lang.Object r6 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r6 = (androidx.paging.PageFetcherSnapshot) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x01d8
        L_0x008d:
            boolean r2 = r0.f36786o
            java.lang.Object r3 = r0.f36785n
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r5 = r0.f36784m
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36783l
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r7 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r7 = (androidx.paging.PageFetcherSnapshot) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0183
        L_0x00a4:
            java.lang.Object r2 = r0.f36785n
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36784m
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36783l
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r7 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r7 = (androidx.paging.PageFetcherSnapshot) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0151
        L_0x00b9:
            java.lang.Object r2 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r2 = (androidx.paging.PageFetcherSnapshot) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r2
            goto L_0x0132
        L_0x00c3:
            java.lang.Object r2 = r0.f36783l
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r5 = (androidx.paging.PageFetcherSnapshot) r5
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00cf }
            goto L_0x0114
        L_0x00cf:
            r12 = move-exception
            goto L_0x02ce
        L_0x00d2:
            java.lang.Object r2 = r0.f36784m
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f36783l
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r0.f36782k
            androidx.paging.PageFetcherSnapshot r6 = (androidx.paging.PageFetcherSnapshot) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00fd
        L_0x00e2:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r11.stateHolder
            kotlinx.coroutines.sync.Mutex r12 = r5.lock
            r0.f36782k = r11
            r0.f36783l = r5
            r0.f36784m = r12
            r2 = 1
            r0.f36780i = r2
            java.lang.Object r2 = r12.lock(r4, r0)
            if (r2 != r1) goto L_0x00fb
            return r1
        L_0x00fb:
            r6 = r11
            r2 = r12
        L_0x00fd:
            androidx.paging.PageFetcherSnapshotState r12 = r5.state     // Catch:{ all -> 0x00cf }
            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x00cf }
            r0.f36782k = r6     // Catch:{ all -> 0x00cf }
            r0.f36783l = r2     // Catch:{ all -> 0x00cf }
            r0.f36784m = r4     // Catch:{ all -> 0x00cf }
            r7 = 2
            r0.f36780i = r7     // Catch:{ all -> 0x00cf }
            java.lang.Object r12 = r6.e(r12, r5, r0)     // Catch:{ all -> 0x00cf }
            if (r12 != r1) goto L_0x0113
            return r1
        L_0x0113:
            r5 = r6
        L_0x0114:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00cf }
            r2.unlock(r4)
            androidx.paging.LoadType r12 = androidx.paging.LoadType.REFRESH
            Key r2 = r5.initialKey
            androidx.paging.PagingSource$LoadParams r12 = r5.loadParams(r12, r2)
            androidx.paging.PagingSource<Key, Value> r2 = r5.pagingSource
            r0.f36782k = r5
            r0.f36783l = r4
            r6 = 3
            r0.f36780i = r6
            java.lang.Object r12 = r2.load(r12, r0)
            if (r12 != r1) goto L_0x0131
            return r1
        L_0x0131:
            r7 = r5
        L_0x0132:
            r6 = r12
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            boolean r12 = r6 instanceof androidx.paging.PagingSource.LoadResult.Page
            if (r12 == 0) goto L_0x026e
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r7.stateHolder
            kotlinx.coroutines.sync.Mutex r2 = r5.lock
            r0.f36782k = r7
            r0.f36783l = r6
            r0.f36784m = r5
            r0.f36785n = r2
            r12 = 4
            r0.f36780i = r12
            java.lang.Object r12 = r2.lock(r4, r0)
            if (r12 != r1) goto L_0x0151
            return r1
        L_0x0151:
            androidx.paging.PageFetcherSnapshotState r12 = r5.state     // Catch:{ all -> 0x0269 }
            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0269 }
            r8 = r6
            androidx.paging.PagingSource$LoadResult$Page r8 = (androidx.paging.PagingSource.LoadResult.Page) r8     // Catch:{ all -> 0x0269 }
            boolean r12 = r12.insert(r3, r5, r8)     // Catch:{ all -> 0x0269 }
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)     // Catch:{ all -> 0x0269 }
            r2.unlock(r4)
            boolean r2 = r12.booleanValue()
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r7.stateHolder
            kotlinx.coroutines.sync.Mutex r3 = r5.lock
            r0.f36782k = r7
            r0.f36783l = r6
            r0.f36784m = r5
            r0.f36785n = r3
            r0.f36786o = r2
            r12 = 5
            r0.f36780i = r12
            java.lang.Object r12 = r3.lock(r4, r0)
            if (r12 != r1) goto L_0x0183
            return r1
        L_0x0183:
            androidx.paging.PageFetcherSnapshotState r12 = r5.state     // Catch:{ all -> 0x0264 }
            androidx.paging.LoadType r5 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0264 }
            androidx.paging.LoadState$NotLoading$Companion r8 = androidx.paging.LoadState.NotLoading.Companion     // Catch:{ all -> 0x0264 }
            androidx.paging.LoadState$NotLoading r9 = r8.getIncomplete$paging_common()     // Catch:{ all -> 0x0264 }
            r12.setSourceLoadState(r5, r9)     // Catch:{ all -> 0x0264 }
            r5 = r6
            androidx.paging.PagingSource$LoadResult$Page r5 = (androidx.paging.PagingSource.LoadResult.Page) r5     // Catch:{ all -> 0x0264 }
            java.lang.Object r5 = r5.getPrevKey()     // Catch:{ all -> 0x0264 }
            if (r5 != 0) goto L_0x01a4
            androidx.paging.LoadType r5 = androidx.paging.LoadType.PREPEND     // Catch:{ all -> 0x0264 }
            androidx.paging.LoadState$NotLoading r9 = r8.getComplete$paging_common()     // Catch:{ all -> 0x0264 }
            r12.setSourceLoadState(r5, r9)     // Catch:{ all -> 0x0264 }
        L_0x01a4:
            r5 = r6
            androidx.paging.PagingSource$LoadResult$Page r5 = (androidx.paging.PagingSource.LoadResult.Page) r5     // Catch:{ all -> 0x0264 }
            java.lang.Object r5 = r5.getNextKey()     // Catch:{ all -> 0x0264 }
            if (r5 != 0) goto L_0x01b6
            androidx.paging.LoadType r5 = androidx.paging.LoadType.APPEND     // Catch:{ all -> 0x0264 }
            androidx.paging.LoadState$NotLoading r8 = r8.getComplete$paging_common()     // Catch:{ all -> 0x0264 }
            r12.setSourceLoadState(r5, r8)     // Catch:{ all -> 0x0264 }
        L_0x01b6:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0264 }
            r3.unlock(r4)
            if (r2 == 0) goto L_0x0205
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r3 = r7.stateHolder
            kotlinx.coroutines.sync.Mutex r12 = r3.lock
            r0.f36782k = r7
            r0.f36783l = r6
            r0.f36784m = r3
            r0.f36785n = r12
            r2 = 6
            r0.f36780i = r2
            java.lang.Object r2 = r12.lock(r4, r0)
            if (r2 != r1) goto L_0x01d5
            return r1
        L_0x01d5:
            r2 = r12
            r5 = r6
            r6 = r7
        L_0x01d8:
            androidx.paging.PageFetcherSnapshotState r12 = r3.state     // Catch:{ all -> 0x0075 }
            kotlinx.coroutines.channels.Channel<androidx.paging.PageEvent<Value>> r3 = r6.pageEventCh     // Catch:{ all -> 0x0075 }
            r7 = r5
            androidx.paging.PagingSource$LoadResult$Page r7 = (androidx.paging.PagingSource.LoadResult.Page) r7     // Catch:{ all -> 0x0075 }
            androidx.paging.LoadType r8 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0075 }
            androidx.paging.PageEvent r12 = r12.toPageEvent$paging_common(r7, r8)     // Catch:{ all -> 0x0075 }
            r0.f36782k = r6     // Catch:{ all -> 0x0075 }
            r0.f36783l = r5     // Catch:{ all -> 0x0075 }
            r0.f36784m = r2     // Catch:{ all -> 0x0075 }
            r0.f36785n = r4     // Catch:{ all -> 0x0075 }
            r7 = 7
            r0.f36780i = r7     // Catch:{ all -> 0x0075 }
            java.lang.Object r12 = r3.send(r12, r0)     // Catch:{ all -> 0x0075 }
            if (r12 != r1) goto L_0x01f9
            return r1
        L_0x01f9:
            r3 = r5
            r5 = r6
        L_0x01fb:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0075 }
            r2.unlock(r4)
            goto L_0x0207
        L_0x0201:
            r2.unlock(r4)
            throw r12
        L_0x0205:
            r3 = r6
            r5 = r7
        L_0x0207:
            androidx.paging.RemoteMediatorConnection<Key, Value> r12 = r5.remoteMediatorConnection
            if (r12 == 0) goto L_0x02cb
            r12 = r3
            androidx.paging.PagingSource$LoadResult$Page r12 = (androidx.paging.PagingSource.LoadResult.Page) r12
            java.lang.Object r2 = r12.getPrevKey()
            if (r2 == 0) goto L_0x021a
            java.lang.Object r12 = r12.getNextKey()
            if (r12 != 0) goto L_0x02cb
        L_0x021a:
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r2 = r5.stateHolder
            kotlinx.coroutines.sync.Mutex r12 = r2.lock
            r0.f36782k = r5
            r0.f36783l = r3
            r0.f36784m = r2
            r0.f36785n = r12
            r6 = 8
            r0.f36780i = r6
            java.lang.Object r0 = r12.lock(r4, r0)
            if (r0 != r1) goto L_0x0233
            return r1
        L_0x0233:
            r1 = r12
            r0 = r5
        L_0x0235:
            androidx.paging.PageFetcherSnapshotState r12 = r2.state     // Catch:{ all -> 0x025f }
            androidx.paging.ViewportHint$Access r2 = r0.lastHint     // Catch:{ all -> 0x025f }
            androidx.paging.PagingState r12 = r12.currentPagingState$paging_common(r2)     // Catch:{ all -> 0x025f }
            r1.unlock(r4)
            androidx.paging.PagingSource$LoadResult$Page r3 = (androidx.paging.PagingSource.LoadResult.Page) r3
            java.lang.Object r1 = r3.getPrevKey()
            if (r1 != 0) goto L_0x0251
            androidx.paging.RemoteMediatorConnection<Key, Value> r1 = r0.remoteMediatorConnection
            androidx.paging.LoadType r2 = androidx.paging.LoadType.PREPEND
            r1.requestLoad(r2, r12)
        L_0x0251:
            java.lang.Object r1 = r3.getNextKey()
            if (r1 != 0) goto L_0x02cb
            androidx.paging.RemoteMediatorConnection<Key, Value> r0 = r0.remoteMediatorConnection
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            r0.requestLoad(r1, r12)
            goto L_0x02cb
        L_0x025f:
            r12 = move-exception
            r1.unlock(r4)
            throw r12
        L_0x0264:
            r12 = move-exception
            r3.unlock(r4)
            throw r12
        L_0x0269:
            r12 = move-exception
            r2.unlock(r4)
            throw r12
        L_0x026e:
            boolean r12 = r6 instanceof androidx.paging.PagingSource.LoadResult.Error
            if (r12 == 0) goto L_0x02cb
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r7.stateHolder
            kotlinx.coroutines.sync.Mutex r12 = r5.lock
            r0.f36782k = r7
            r0.f36783l = r6
            r0.f36784m = r5
            r0.f36785n = r12
            r2 = 9
            r0.f36780i = r2
            java.lang.Object r2 = r12.lock(r4, r0)
            if (r2 != r1) goto L_0x028b
            return r1
        L_0x028b:
            androidx.paging.PageFetcherSnapshotState r2 = r5.state     // Catch:{ all -> 0x02c3 }
            androidx.paging.LoadState$Error r5 = new androidx.paging.LoadState$Error     // Catch:{ all -> 0x02c3 }
            androidx.paging.PagingSource$LoadResult$Error r6 = (androidx.paging.PagingSource.LoadResult.Error) r6     // Catch:{ all -> 0x02c3 }
            java.lang.Throwable r6 = r6.getThrowable()     // Catch:{ all -> 0x02c3 }
            r5.<init>(r6)     // Catch:{ all -> 0x02c3 }
            androidx.paging.LoadType r6 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x02c3 }
            boolean r2 = r2.setSourceLoadState(r6, r5)     // Catch:{ all -> 0x02c3 }
            if (r2 == 0) goto L_0x02bc
            kotlinx.coroutines.channels.Channel<androidx.paging.PageEvent<Value>> r2 = r7.pageEventCh     // Catch:{ all -> 0x02c3 }
            androidx.paging.PageEvent$LoadStateUpdate r7 = new androidx.paging.PageEvent$LoadStateUpdate     // Catch:{ all -> 0x02c3 }
            r7.<init>(r6, r3, r5)     // Catch:{ all -> 0x02c3 }
            r0.f36782k = r12     // Catch:{ all -> 0x02c3 }
            r0.f36783l = r4     // Catch:{ all -> 0x02c3 }
            r0.f36784m = r4     // Catch:{ all -> 0x02c3 }
            r0.f36785n = r4     // Catch:{ all -> 0x02c3 }
            r3 = 10
            r0.f36780i = r3     // Catch:{ all -> 0x02c3 }
            java.lang.Object r0 = r2.send(r7, r0)     // Catch:{ all -> 0x02c3 }
            if (r0 != r1) goto L_0x02bc
            return r1
        L_0x02bc:
            r0 = r12
        L_0x02bd:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0036 }
            r0.unlock(r4)
            goto L_0x02cb
        L_0x02c3:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x02c7:
            r0.unlock(r4)
            throw r12
        L_0x02cb:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x02ce:
            r2.unlock(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: androidx.paging.PagingSource$LoadResult$Page} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: androidx.paging.PageEvent$Drop} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v68, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v71, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v75, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v82, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v83, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v85, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v86, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x03a7, code lost:
        throw new java.lang.IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x03a8, code lost:
        r2 = ((androidx.paging.PagingSource.LoadResult.Page) r6).getPrevKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x03b6, code lost:
        if (r9.pagingSource.getKeyReuseSupported() != false) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x03c0, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r2, (java.lang.Object) r10.element)) == false) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03c3, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03c5, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03c6, code lost:
        if (r2 != false) goto L_0x0401;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03ca, code lost:
        if (r13 != androidx.paging.LoadType.PREPEND) goto L_0x03cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03cc, code lost:
        r0 = "prevKey";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03cf, code lost:
        r0 = "nextKey";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0400, code lost:
        throw new java.lang.IllegalStateException(kotlin.text.StringsKt__IndentKt.trimMargin$default("The same value, " + r10.element + ", was passed as the " + r0 + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            ", (java.lang.String) null, 1, (java.lang.Object) null).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0401, code lost:
        r2 = r9.stateHolder;
        r14 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r2);
        r3.f36790k = r9;
        r3.f36791l = r13;
        r3.f36792m = r12;
        r3.f36793n = r11;
        r3.f36794o = r10;
        r3.f36795p = r0;
        r3.f36796q = r8;
        r3.f36797r = r6;
        r3.f36798s = r2;
        r3.f36799t = r14;
        r3.f36788i = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0423, code lost:
        if (r14.lock((java.lang.Object) null, r3) != r4) goto L_0x0426;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0425, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0426, code lost:
        r5 = r2;
        r16 = r9;
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5).insert(r12.getGenerationId(), r13, (androidx.paging.PagingSource.LoadResult.Page) r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x043f, code lost:
        r14.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0447, code lost:
        if (r2.booleanValue() != false) goto L_0x044b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x044b, code lost:
        r5 = (androidx.paging.PagingSource.LoadResult.Page) r6;
        r11.element += r5.getData().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x045d, code lost:
        if (r13 != androidx.paging.LoadType.PREPEND) goto L_0x0468;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0463, code lost:
        if (r5.getPrevKey() == null) goto L_0x0466;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x046a, code lost:
        if (r13 != androidx.paging.LoadType.APPEND) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0470, code lost:
        if (r5.getNextKey() != null) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0473, code lost:
        r9.element = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0475, code lost:
        r16 = r9;
        r9 = r0;
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x047d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x047e, code lost:
        r14.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0482, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0485, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadResult.Error) == false) goto L_0x04fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0487, code lost:
        r5 = r9.stateHolder;
        r0 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r5);
        r3.f36790k = r9;
        r3.f36791l = r13;
        r3.f36792m = r12;
        r3.f36793n = r6;
        r3.f36794o = r5;
        r3.f36795p = r0;
        r3.f36796q = null;
        r3.f36788i = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x04a3, code lost:
        if (r0.lock((java.lang.Object) null, r3) != r4) goto L_0x04a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x04a5, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x04a6, code lost:
        r2 = r4;
        r4 = r0;
        r0 = r3;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        r5 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5);
        r7 = new androidx.paging.LoadState.Error(((androidx.paging.PagingSource.LoadResult.Error) r6).getThrowable());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x04bd, code lost:
        if (r5.setSourceLoadState(r3, r7) == false) goto L_0x04e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x04bf, code lost:
        r6 = r9.pageEventCh;
        r8 = new androidx.paging.PageEvent.LoadStateUpdate(r3, false, r7);
        r0.f36790k = r3;
        r0.f36791l = r12;
        r0.f36792m = r4;
        r0.f36793n = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r0.f36794o = null;
        r0.f36795p = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        r0.f36788i = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x04db, code lost:
        if (r6.send(r8, r0) != r2) goto L_0x04de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x04dd, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x04de, code lost:
        r0 = r5;
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04e0, code lost:
        r12 = r5;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x04e3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x04e4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x04e6, code lost:
        r5.getFailedHintsByLoadType$paging_common().put(r3, r12.getHint());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x04f3, code lost:
        r4.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04f9, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0508, code lost:
        if (androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$4[r13.ordinal()] == 1) goto L_0x050d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x050a, code lost:
        r2 = androidx.paging.LoadType.PREPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x050d, code lost:
        r2 = androidx.paging.LoadType.APPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x050f, code lost:
        r15 = r9.stateHolder;
        r5 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r15);
        r3.f36790k = r9;
        r3.f36791l = r13;
        r3.f36792m = r12;
        r3.f36793n = r11;
        r3.f36794o = r10;
        r3.f36795p = r0;
        r3.f36796q = r8;
        r3.f36797r = r6;
        r3.f36798s = r2;
        r3.f36799t = r15;
        r3.f36800u = r5;
        r3.f36788i = 8;
        r18 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0536, code lost:
        if (r5.lock((java.lang.Object) null, r3) != r4) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0538, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0539, code lost:
        r14 = r12;
        r12 = r10;
        r10 = r8;
        r8 = r6;
        r6 = r2;
        r2 = r5;
        r5 = r15;
        r15 = r13;
        r13 = r11;
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        r0 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5);
        r5 = r0.dropEventOrNull(r6, r14.getHint());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0550, code lost:
        if (r5 == 0) goto L_0x058f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0552, code lost:
        r0.drop(r5);
        r6 = r9.pageEventCh;
        r3.f36790k = r9;
        r3.f36791l = r15;
        r3.f36792m = r14;
        r3.f36793n = r13;
        r3.f36794o = r12;
        r3.f36795p = r11;
        r3.f36796q = r10;
        r3.f36797r = r8;
        r3.f36798s = r2;
        r3.f36799t = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x056b, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x056c, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        r3.f36800u = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:?, code lost:
        r3.f36788i = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0576, code lost:
        if (r6.send(r5, r3) != r4) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0578, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0579, code lost:
        r5 = r2;
        r6 = r8;
        r8 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r15 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0582, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        r1 = kotlin.Unit.INSTANCE;
        r9 = r15;
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x058f, code lost:
        r5 = r2;
        r6 = r8;
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0592, code lost:
        r1 = r9.nextLoadKeyOrNull(r0, r15, r14.getGenerationId(), r14.presentedItemsBeyondAnchor$paging_common(r15) + r13.element);
        r12.element = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x05a3, code lost:
        if (r1 != null) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x05af, code lost:
        if ((r0.getSourceLoadStates$paging_common().get$paging_common(r15) instanceof androidx.paging.LoadState.Error) != false) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x05b3, code lost:
        if (r11.element == false) goto L_0x05bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x05b5, code lost:
        r1 = androidx.paging.LoadState.NotLoading.Companion.getComplete$paging_common();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x05bc, code lost:
        r1 = androidx.paging.LoadState.NotLoading.Companion.getIncomplete$paging_common();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00be, code lost:
        r1 = null;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x05c2, code lost:
        r0.setSourceLoadState(r15, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x05c5, code lost:
        r0 = r0.toPageEvent$paging_common((androidx.paging.PagingSource.LoadResult.Page) r6, r15);
        r1 = r9.pageEventCh;
        r3.f36790k = r9;
        r3.f36791l = r15;
        r3.f36792m = r14;
        r3.f36793n = r13;
        r3.f36794o = r12;
        r3.f36795p = r11;
        r3.f36796q = r8;
        r3.f36797r = r6;
        r3.f36798s = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        r3.f36799t = null;
        r3.f36800u = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x05e7, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        r3.f36788i = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x05ed, code lost:
        if (r1.send(r0, r3) != r4) goto L_0x05f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05ef, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05f0, code lost:
        r0 = r6;
        r6 = r8;
        r10 = r9;
        r8 = r14;
        r14 = r12;
        r16 = r13;
        r13 = r11;
        r11 = r15;
        r15 = r16;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05fb, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05fd, code lost:
        r5.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0603, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadParams.Prepend) == false) goto L_0x0610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x060c, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r0).getPrevKey() != null) goto L_0x0610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x060e, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0610, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0613, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadParams.Append) == false) goto L_0x061f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x061b, code lost:
        if (((androidx.paging.PagingSource.LoadResult.Page) r0).getNextKey() != null) goto L_0x061f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x061d, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x061f, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0622, code lost:
        if (r10.remoteMediatorConnection == null) goto L_0x0670;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0624, code lost:
        if (r5 != 0) goto L_0x0628;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0626, code lost:
        if (r0 == 0) goto L_0x0670;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0628, code lost:
        r12 = r10.stateHolder;
        r6 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r12);
        r3.f36790k = r10;
        r3.f36791l = r11;
        r3.f36792m = r8;
        r3.f36793n = r15;
        r3.f36794o = r14;
        r3.f36795p = r13;
        r3.f36796q = r12;
        r3.f36797r = r6;
        r3.f36798s = null;
        r3.f36801v = r5;
        r3.f36802w = r0;
        r3.f36788i = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x064d, code lost:
        if (r6.lock((java.lang.Object) null, r3) != r4) goto L_0x0650;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x064f, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:?, code lost:
        r1 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r12).currentPagingState$paging_common(r10.lastHint);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x065e, code lost:
        if (r5 == 0) goto L_0x0667;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0660, code lost:
        r10.remoteMediatorConnection.requestLoad(androidx.paging.LoadType.PREPEND, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0667, code lost:
        if (r0 == 0) goto L_0x0670;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0669, code lost:
        r10.remoteMediatorConnection.requestLoad(androidx.paging.LoadType.APPEND, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0670, code lost:
        r12 = r10;
        r0 = r13;
        r2 = r14;
        r9 = r15;
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0676, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0677, code lost:
        r6.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x067b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x067c, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0680, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0681, code lost:
        r1 = null;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0683, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0684, code lost:
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0108, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x068d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x068e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x068f, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0696, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0697, code lost:
        r2.unlock((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x069b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0109, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x015c, code lost:
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r5);
        r10 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$2[r0.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0239, code lost:
        if (r10 == 1) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x023c, code lost:
        if (r10 == 2) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x023e, code lost:
        if (r10 == 3) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0247, code lost:
        throw new java.lang.IllegalStateException("Use doInitialLoad for LoadType == REFRESH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0248, code lost:
        r10 = (r5.getInitialPageIndex$paging_common() + r9.getHint().getOriginalPageOffsetLast()) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0257, code lost:
        if (r10 >= 0) goto L_0x0265;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0259, code lost:
        r8.element += r11.config.pageSize * (-r10);
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0265, code lost:
        r12 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r5.getPages$paging_common());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x026d, code lost:
        if (r10 > r12) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x026f, code lost:
        r8.element += ((androidx.paging.PagingSource.LoadResult.Page) r5.getPages$paging_common().get(r10)).getData().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0286, code lost:
        if (r10 == r12) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0288, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x028b, code lost:
        r10 = (r5.getInitialPageIndex$paging_common() + r9.getHint().getOriginalPageOffsetFirst()) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02a2, code lost:
        if (r10 <= kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r5.getPages$paging_common())) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02a4, code lost:
        r8.element += r11.config.pageSize * (r10 - kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r5.getPages$paging_common()));
        r10 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r5.getPages$paging_common());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02bf, code lost:
        if (r10 < 0) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02c1, code lost:
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02c2, code lost:
        r8.element += ((androidx.paging.PagingSource.LoadResult.Page) r5.getPages$paging_common().get(r12)).getData().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02d9, code lost:
        if (r12 == r10) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02db, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02de, code lost:
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02e0, code lost:
        r2.unlock((java.lang.Object) null);
        r2 = new kotlin.jvm.internal.Ref.ObjectRef();
        r5 = r11.stateHolder;
        r10 = androidx.paging.PageFetcherSnapshotState.Holder.access$getLock$p(r5);
        r3.f36790k = r11;
        r3.f36791l = r0;
        r3.f36792m = r9;
        r3.f36793n = r8;
        r3.f36794o = r2;
        r3.f36795p = r5;
        r3.f36796q = r10;
        r3.f36797r = r2;
        r3.f36788i = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0307, code lost:
        if (r10.lock((java.lang.Object) null, r3) != r4) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0309, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x030a, code lost:
        r12 = r11;
        r11 = r0;
        r0 = r2;
        r16 = r8;
        r8 = r5;
        r5 = r10;
        r10 = r9;
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r8 = androidx.paging.PageFetcherSnapshotState.Holder.access$getState$p(r8);
        r13 = r12.nextLoadKeyOrNull(r8, r11, r10.getGenerationId(), r10.presentedItemsBeyondAnchor$paging_common(r11) + r9.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0327, code lost:
        if (r13 == null) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0329, code lost:
        r3.f36790k = r12;
        r3.f36791l = r11;
        r3.f36792m = r10;
        r3.f36793n = r9;
        r3.f36794o = r2;
        r3.f36795p = r5;
        r3.f36796q = r13;
        r3.f36797r = r0;
        r3.f36788i = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x033f, code lost:
        if (r12.e(r8, r11, r3) != r4) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0341, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0342, code lost:
        r8 = r2;
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0344, code lost:
        r5 = r6;
        r2 = r8;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0348, code lost:
        r6 = null;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x034a, code lost:
        r5.unlock(r6);
        r0.element = r13;
        r0 = new kotlin.jvm.internal.Ref.BooleanRef();
        r0.element = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0357, code lost:
        r5 = r2.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0359, code lost:
        if (r5 == null) goto L_0x068b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x035b, code lost:
        r5 = r12.loadParams(r11, r5);
        r6 = r12.pagingSource;
        r3.f36790k = r12;
        r3.f36791l = r11;
        r3.f36792m = r10;
        r3.f36793n = r9;
        r3.f36794o = r2;
        r3.f36795p = r0;
        r3.f36796q = r5;
        r3.f36797r = null;
        r3.f36798s = null;
        r3.f36788i = 4;
        r6 = r6.load(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x037b, code lost:
        if (r6 != r4) goto L_0x037e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x037d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x037e, code lost:
        r8 = r5;
        r13 = r11;
        r11 = r9;
        r9 = r12;
        r12 = r10;
        r10 = r2;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0385, code lost:
        r6 = (androidx.paging.PagingSource.LoadResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x038a, code lost:
        if ((r6 instanceof androidx.paging.PagingSource.LoadResult.Page) == false) goto L_0x0483;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x038c, code lost:
        r2 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$3[r13.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0395, code lost:
        if (r2 == 1) goto L_0x03a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0398, code lost:
        if (r2 != 2) goto L_0x03a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x039a, code lost:
        r2 = ((androidx.paging.PagingSource.LoadResult.Page) r6).getNextKey();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:22:0x0103, B:149:0x04d0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object c(androidx.paging.LoadType r18, androidx.paging.GenerationalViewportHint r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.paging.PageFetcherSnapshot$doLoad$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            androidx.paging.PageFetcherSnapshot$doLoad$1 r3 = (androidx.paging.PageFetcherSnapshot$doLoad$1) r3
            int r4 = r3.f36788i
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f36788i = r4
            goto L_0x001e
        L_0x0019:
            androidx.paging.PageFetcherSnapshot$doLoad$1 r3 = new androidx.paging.PageFetcherSnapshot$doLoad$1
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f36787h
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f36788i
            r6 = 3
            java.lang.String r7 = "Use doInitialLoad for LoadType == REFRESH"
            switch(r5) {
                case 0: goto L_0x01f8;
                case 1: goto L_0x01da;
                case 2: goto L_0x01b0;
                case 3: goto L_0x0188;
                case 4: goto L_0x0160;
                case 5: goto L_0x012e;
                case 6: goto L_0x010c;
                case 7: goto L_0x00f3;
                case 8: goto L_0x00c1;
                case 9: goto L_0x0090;
                case 10: goto L_0x005d;
                case 11: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            int r0 = r3.f36802w
            int r5 = r3.f36801v
            java.lang.Object r6 = r3.f36797r
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r12 = r3.f36796q
            androidx.paging.PageFetcherSnapshotState$Holder r12 = (androidx.paging.PageFetcherSnapshotState.Holder) r12
            java.lang.Object r13 = r3.f36795p
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r14 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r15 = (kotlin.jvm.internal.Ref.IntRef) r15
            java.lang.Object r8 = r3.f36792m
            androidx.paging.GenerationalViewportHint r8 = (androidx.paging.GenerationalViewportHint) r8
            java.lang.Object r11 = r3.f36791l
            androidx.paging.LoadType r11 = (androidx.paging.LoadType) r11
            java.lang.Object r10 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r10 = (androidx.paging.PageFetcherSnapshot) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0650
        L_0x005d:
            java.lang.Object r0 = r3.f36798s
            r5 = r0
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r0 = r3.f36797r
            androidx.paging.PagingSource$LoadResult r0 = (androidx.paging.PagingSource.LoadResult) r0
            java.lang.Object r6 = r3.f36796q
            androidx.paging.PagingSource$LoadParams r6 = (androidx.paging.PagingSource.LoadParams) r6
            java.lang.Object r8 = r3.f36795p
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            java.lang.Object r10 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r3.f36792m
            androidx.paging.GenerationalViewportHint r12 = (androidx.paging.GenerationalViewportHint) r12
            java.lang.Object r13 = r3.f36791l
            androidx.paging.LoadType r13 = (androidx.paging.LoadType) r13
            java.lang.Object r14 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r14 = (androidx.paging.PageFetcherSnapshot) r14
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x00bd }
            r15 = r11
            r11 = r13
            r13 = r8
            r8 = r12
            r16 = r14
            r14 = r10
            r10 = r16
            goto L_0x05fb
        L_0x0090:
            java.lang.Object r0 = r3.f36799t
            androidx.paging.PageFetcherSnapshotState r0 = (androidx.paging.PageFetcherSnapshotState) r0
            java.lang.Object r5 = r3.f36798s
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r3.f36797r
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r8 = r3.f36796q
            androidx.paging.PagingSource$LoadParams r8 = (androidx.paging.PagingSource.LoadParams) r8
            java.lang.Object r10 = r3.f36795p
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            java.lang.Object r13 = r3.f36792m
            androidx.paging.GenerationalViewportHint r13 = (androidx.paging.GenerationalViewportHint) r13
            java.lang.Object r14 = r3.f36791l
            androidx.paging.LoadType r14 = (androidx.paging.LoadType) r14
            java.lang.Object r15 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r15 = (androidx.paging.PageFetcherSnapshot) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0582
        L_0x00bd:
            r0 = move-exception
        L_0x00be:
            r1 = 0
            goto L_0x0687
        L_0x00c1:
            java.lang.Object r0 = r3.f36800u
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r5 = r3.f36799t
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r3.f36798s
            androidx.paging.LoadType r6 = (androidx.paging.LoadType) r6
            java.lang.Object r8 = r3.f36797r
            androidx.paging.PagingSource$LoadResult r8 = (androidx.paging.PagingSource.LoadResult) r8
            java.lang.Object r10 = r3.f36796q
            androidx.paging.PagingSource$LoadParams r10 = (androidx.paging.PagingSource.LoadParams) r10
            java.lang.Object r11 = r3.f36795p
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r13 = (kotlin.jvm.internal.Ref.IntRef) r13
            java.lang.Object r14 = r3.f36792m
            androidx.paging.GenerationalViewportHint r14 = (androidx.paging.GenerationalViewportHint) r14
            java.lang.Object r15 = r3.f36791l
            androidx.paging.LoadType r15 = (androidx.paging.LoadType) r15
            java.lang.Object r9 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r9 = (androidx.paging.PageFetcherSnapshot) r9
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            goto L_0x0544
        L_0x00f3:
            java.lang.Object r0 = r3.f36793n
            androidx.paging.PageFetcherSnapshotState r0 = (androidx.paging.PageFetcherSnapshotState) r0
            java.lang.Object r4 = r3.f36792m
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            java.lang.Object r5 = r3.f36791l
            androidx.paging.GenerationalViewportHint r5 = (androidx.paging.GenerationalViewportHint) r5
            java.lang.Object r3 = r3.f36790k
            androidx.paging.LoadType r3 = (androidx.paging.LoadType) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0108 }
            goto L_0x04e0
        L_0x0108:
            r0 = move-exception
            r2 = 0
            goto L_0x04fa
        L_0x010c:
            java.lang.Object r0 = r3.f36795p
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r5 = r3.f36794o
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r3.f36793n
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r7 = r3.f36792m
            androidx.paging.GenerationalViewportHint r7 = (androidx.paging.GenerationalViewportHint) r7
            java.lang.Object r8 = r3.f36791l
            androidx.paging.LoadType r8 = (androidx.paging.LoadType) r8
            java.lang.Object r9 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r9 = (androidx.paging.PageFetcherSnapshot) r9
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r4
            r12 = r7
            r4 = r0
            r0 = r3
            r3 = r8
            goto L_0x04aa
        L_0x012e:
            java.lang.Object r0 = r3.f36799t
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r5 = r3.f36798s
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r6 = r3.f36797r
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            java.lang.Object r8 = r3.f36796q
            androidx.paging.PagingSource$LoadParams r8 = (androidx.paging.PagingSource.LoadParams) r8
            java.lang.Object r9 = r3.f36795p
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r3.f36792m
            androidx.paging.GenerationalViewportHint r12 = (androidx.paging.GenerationalViewportHint) r12
            java.lang.Object r13 = r3.f36791l
            androidx.paging.LoadType r13 = (androidx.paging.LoadType) r13
            java.lang.Object r14 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r14 = (androidx.paging.PageFetcherSnapshot) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r14
            r14 = r0
        L_0x015c:
            r0 = r16
            goto L_0x042c
        L_0x0160:
            java.lang.Object r0 = r3.f36796q
            androidx.paging.PagingSource$LoadParams r0 = (androidx.paging.PagingSource.LoadParams) r0
            java.lang.Object r5 = r3.f36795p
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref.BooleanRef) r5
            java.lang.Object r6 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r8 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r3.f36792m
            androidx.paging.GenerationalViewportHint r9 = (androidx.paging.GenerationalViewportHint) r9
            java.lang.Object r10 = r3.f36791l
            androidx.paging.LoadType r10 = (androidx.paging.LoadType) r10
            java.lang.Object r11 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r11 = (androidx.paging.PageFetcherSnapshot) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r12 = r9
            r13 = r10
            r9 = r11
            r10 = r6
            r11 = r8
            r8 = r0
            r0 = r5
            goto L_0x0385
        L_0x0188:
            java.lang.Object r0 = r3.f36797r
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r5 = r3.f36796q
            java.lang.Object r6 = r3.f36795p
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r8 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r3.f36792m
            androidx.paging.GenerationalViewportHint r10 = (androidx.paging.GenerationalViewportHint) r10
            java.lang.Object r11 = r3.f36791l
            androidx.paging.LoadType r11 = (androidx.paging.LoadType) r11
            java.lang.Object r12 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r12 = (androidx.paging.PageFetcherSnapshot) r12
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x01ac }
            r13 = r5
            goto L_0x0344
        L_0x01ac:
            r0 = move-exception
        L_0x01ad:
            r1 = 0
            goto L_0x0692
        L_0x01b0:
            java.lang.Object r0 = r3.f36797r
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r5 = r3.f36796q
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r8 = r3.f36795p
            androidx.paging.PageFetcherSnapshotState$Holder r8 = (androidx.paging.PageFetcherSnapshotState.Holder) r8
            java.lang.Object r9 = r3.f36794o
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r11 = r3.f36792m
            androidx.paging.GenerationalViewportHint r11 = (androidx.paging.GenerationalViewportHint) r11
            java.lang.Object r12 = r3.f36791l
            androidx.paging.LoadType r12 = (androidx.paging.LoadType) r12
            java.lang.Object r13 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r13 = (androidx.paging.PageFetcherSnapshot) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            goto L_0x0314
        L_0x01da:
            java.lang.Object r0 = r3.f36795p
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r5 = r3.f36794o
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            java.lang.Object r8 = r3.f36793n
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r3.f36792m
            androidx.paging.GenerationalViewportHint r9 = (androidx.paging.GenerationalViewportHint) r9
            java.lang.Object r10 = r3.f36791l
            androidx.paging.LoadType r10 = (androidx.paging.LoadType) r10
            java.lang.Object r11 = r3.f36790k
            androidx.paging.PageFetcherSnapshot r11 = (androidx.paging.PageFetcherSnapshot) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r10
            goto L_0x022c
        L_0x01f8:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.paging.LoadType r2 = androidx.paging.LoadType.REFRESH
            if (r0 == r2) goto L_0x0201
            r2 = 1
            goto L_0x0202
        L_0x0201:
            r2 = 0
        L_0x0202:
            if (r2 == 0) goto L_0x069c
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            r2 = 0
            r8.element = r2
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r1.stateHolder
            kotlinx.coroutines.sync.Mutex r2 = r5.lock
            r3.f36790k = r1
            r3.f36791l = r0
            r9 = r19
            r3.f36792m = r9
            r3.f36793n = r8
            r3.f36794o = r5
            r3.f36795p = r2
            r10 = 1
            r3.f36788i = r10
            r10 = 0
            java.lang.Object r11 = r2.lock(r10, r3)
            if (r11 != r4) goto L_0x022b
            return r4
        L_0x022b:
            r11 = r1
        L_0x022c:
            androidx.paging.PageFetcherSnapshotState r5 = r5.state     // Catch:{ all -> 0x0696 }
            int[] r10 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$2     // Catch:{ all -> 0x0696 }
            int r12 = r0.ordinal()     // Catch:{ all -> 0x0696 }
            r10 = r10[r12]     // Catch:{ all -> 0x0696 }
            r12 = 1
            if (r10 == r12) goto L_0x028b
            r12 = 2
            if (r10 == r12) goto L_0x0248
            if (r10 == r6) goto L_0x0242
            goto L_0x02de
        L_0x0242:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0696 }
            r0.<init>(r7)     // Catch:{ all -> 0x0696 }
            throw r0     // Catch:{ all -> 0x0696 }
        L_0x0248:
            int r10 = r5.getInitialPageIndex$paging_common()     // Catch:{ all -> 0x0696 }
            androidx.paging.ViewportHint r12 = r9.getHint()     // Catch:{ all -> 0x0696 }
            int r12 = r12.getOriginalPageOffsetLast()     // Catch:{ all -> 0x0696 }
            int r10 = r10 + r12
            r12 = 1
            int r10 = r10 + r12
            if (r10 >= 0) goto L_0x0265
            int r12 = r8.element     // Catch:{ all -> 0x0696 }
            androidx.paging.PagingConfig r13 = r11.config     // Catch:{ all -> 0x0696 }
            int r13 = r13.pageSize     // Catch:{ all -> 0x0696 }
            int r10 = -r10
            int r13 = r13 * r10
            int r12 = r12 + r13
            r8.element = r12     // Catch:{ all -> 0x0696 }
            r10 = 0
        L_0x0265:
            java.util.List r12 = r5.getPages$paging_common()     // Catch:{ all -> 0x0696 }
            int r12 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r12)     // Catch:{ all -> 0x0696 }
            if (r10 > r12) goto L_0x02de
        L_0x026f:
            int r13 = r8.element     // Catch:{ all -> 0x0696 }
            java.util.List r14 = r5.getPages$paging_common()     // Catch:{ all -> 0x0696 }
            java.lang.Object r14 = r14.get(r10)     // Catch:{ all -> 0x0696 }
            androidx.paging.PagingSource$LoadResult$Page r14 = (androidx.paging.PagingSource.LoadResult.Page) r14     // Catch:{ all -> 0x0696 }
            java.util.List r14 = r14.getData()     // Catch:{ all -> 0x0696 }
            int r14 = r14.size()     // Catch:{ all -> 0x0696 }
            int r13 = r13 + r14
            r8.element = r13     // Catch:{ all -> 0x0696 }
            if (r10 == r12) goto L_0x02de
            int r10 = r10 + 1
            goto L_0x026f
        L_0x028b:
            int r10 = r5.getInitialPageIndex$paging_common()     // Catch:{ all -> 0x0696 }
            androidx.paging.ViewportHint r12 = r9.getHint()     // Catch:{ all -> 0x0696 }
            int r12 = r12.getOriginalPageOffsetFirst()     // Catch:{ all -> 0x0696 }
            int r10 = r10 + r12
            r12 = 1
            int r10 = r10 - r12
            java.util.List r12 = r5.getPages$paging_common()     // Catch:{ all -> 0x0696 }
            int r12 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r12)     // Catch:{ all -> 0x0696 }
            if (r10 <= r12) goto L_0x02bf
            int r12 = r8.element     // Catch:{ all -> 0x0696 }
            androidx.paging.PagingConfig r13 = r11.config     // Catch:{ all -> 0x0696 }
            int r13 = r13.pageSize     // Catch:{ all -> 0x0696 }
            java.util.List r14 = r5.getPages$paging_common()     // Catch:{ all -> 0x0696 }
            int r14 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r14)     // Catch:{ all -> 0x0696 }
            int r10 = r10 - r14
            int r13 = r13 * r10
            int r12 = r12 + r13
            r8.element = r12     // Catch:{ all -> 0x0696 }
            java.util.List r10 = r5.getPages$paging_common()     // Catch:{ all -> 0x0696 }
            int r10 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r10)     // Catch:{ all -> 0x0696 }
        L_0x02bf:
            if (r10 < 0) goto L_0x02de
            r12 = 0
        L_0x02c2:
            int r13 = r8.element     // Catch:{ all -> 0x0696 }
            java.util.List r14 = r5.getPages$paging_common()     // Catch:{ all -> 0x0696 }
            java.lang.Object r14 = r14.get(r12)     // Catch:{ all -> 0x0696 }
            androidx.paging.PagingSource$LoadResult$Page r14 = (androidx.paging.PagingSource.LoadResult.Page) r14     // Catch:{ all -> 0x0696 }
            java.util.List r14 = r14.getData()     // Catch:{ all -> 0x0696 }
            int r14 = r14.size()     // Catch:{ all -> 0x0696 }
            int r13 = r13 + r14
            r8.element = r13     // Catch:{ all -> 0x0696 }
            if (r12 == r10) goto L_0x02de
            int r12 = r12 + 1
            goto L_0x02c2
        L_0x02de:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0696 }
            r5 = 0
            r2.unlock(r5)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r11.stateHolder
            kotlinx.coroutines.sync.Mutex r10 = r5.lock
            r3.f36790k = r11
            r3.f36791l = r0
            r3.f36792m = r9
            r3.f36793n = r8
            r3.f36794o = r2
            r3.f36795p = r5
            r3.f36796q = r10
            r3.f36797r = r2
            r12 = 2
            r3.f36788i = r12
            r12 = 0
            java.lang.Object r13 = r10.lock(r12, r3)
            if (r13 != r4) goto L_0x030a
            return r4
        L_0x030a:
            r12 = r11
            r11 = r0
            r0 = r2
            r16 = r8
            r8 = r5
            r5 = r10
            r10 = r9
            r9 = r16
        L_0x0314:
            androidx.paging.PageFetcherSnapshotState r8 = r8.state     // Catch:{ all -> 0x068e }
            int r13 = r10.getGenerationId()     // Catch:{ all -> 0x068e }
            int r14 = r10.presentedItemsBeyondAnchor$paging_common(r11)     // Catch:{ all -> 0x068e }
            int r15 = r9.element     // Catch:{ all -> 0x068e }
            int r14 = r14 + r15
            java.lang.Object r13 = r12.nextLoadKeyOrNull(r8, r11, r13, r14)     // Catch:{ all -> 0x068e }
            if (r13 == 0) goto L_0x0348
            r3.f36790k = r12     // Catch:{ all -> 0x068e }
            r3.f36791l = r11     // Catch:{ all -> 0x068e }
            r3.f36792m = r10     // Catch:{ all -> 0x068e }
            r3.f36793n = r9     // Catch:{ all -> 0x068e }
            r3.f36794o = r2     // Catch:{ all -> 0x068e }
            r3.f36795p = r5     // Catch:{ all -> 0x068e }
            r3.f36796q = r13     // Catch:{ all -> 0x068e }
            r3.f36797r = r0     // Catch:{ all -> 0x068e }
            r3.f36788i = r6     // Catch:{ all -> 0x068e }
            java.lang.Object r6 = r12.e(r8, r11, r3)     // Catch:{ all -> 0x068e }
            if (r6 != r4) goto L_0x0342
            return r4
        L_0x0342:
            r8 = r2
            r6 = r5
        L_0x0344:
            r5 = r6
            r2 = r8
            r6 = 0
            goto L_0x034a
        L_0x0348:
            r6 = 0
            r13 = 0
        L_0x034a:
            r5.unlock(r6)
            r0.element = r13
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            r5 = 0
            r0.element = r5
        L_0x0357:
            T r5 = r2.element
            if (r5 == 0) goto L_0x068b
            androidx.paging.PagingSource$LoadParams r5 = r12.loadParams(r11, r5)
            androidx.paging.PagingSource<Key, Value> r6 = r12.pagingSource
            r3.f36790k = r12
            r3.f36791l = r11
            r3.f36792m = r10
            r3.f36793n = r9
            r3.f36794o = r2
            r3.f36795p = r0
            r3.f36796q = r5
            r8 = 0
            r3.f36797r = r8
            r3.f36798s = r8
            r8 = 4
            r3.f36788i = r8
            java.lang.Object r6 = r6.load(r5, r3)
            if (r6 != r4) goto L_0x037e
            return r4
        L_0x037e:
            r8 = r5
            r13 = r11
            r11 = r9
            r9 = r12
            r12 = r10
            r10 = r2
            r2 = r6
        L_0x0385:
            r6 = r2
            androidx.paging.PagingSource$LoadResult r6 = (androidx.paging.PagingSource.LoadResult) r6
            boolean r2 = r6 instanceof androidx.paging.PagingSource.LoadResult.Page
            if (r2 == 0) goto L_0x0483
            int[] r2 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$3
            int r5 = r13.ordinal()
            r2 = r2[r5]
            r5 = 1
            if (r2 == r5) goto L_0x03a8
            r5 = 2
            if (r2 != r5) goto L_0x03a2
            r2 = r6
            androidx.paging.PagingSource$LoadResult$Page r2 = (androidx.paging.PagingSource.LoadResult.Page) r2
            java.lang.Object r2 = r2.getNextKey()
            goto L_0x03b0
        L_0x03a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x03a8:
            r5 = 2
            r2 = r6
            androidx.paging.PagingSource$LoadResult$Page r2 = (androidx.paging.PagingSource.LoadResult.Page) r2
            java.lang.Object r2 = r2.getPrevKey()
        L_0x03b0:
            androidx.paging.PagingSource<Key, Value> r14 = r9.pagingSource
            boolean r14 = r14.getKeyReuseSupported()
            if (r14 != 0) goto L_0x03c5
            T r14 = r10.element
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r14)
            r14 = 1
            r2 = r2 ^ r14
            if (r2 == 0) goto L_0x03c3
            goto L_0x03c5
        L_0x03c3:
            r2 = 0
            goto L_0x03c6
        L_0x03c5:
            r2 = 1
        L_0x03c6:
            if (r2 != 0) goto L_0x0401
            androidx.paging.LoadType r0 = androidx.paging.LoadType.PREPEND
            if (r13 != r0) goto L_0x03cf
            java.lang.String r0 = "prevKey"
            goto L_0x03d1
        L_0x03cf:
            java.lang.String r0 = "nextKey"
        L_0x03d1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The same value, "
            r2.append(r3)
            T r3 = r10.element
            r2.append(r3)
            java.lang.String r3 = ", was passed as the "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            "
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 1
            r3 = 0
            java.lang.String r0 = kotlin.text.StringsKt__IndentKt.trimMargin$default(r0, r3, r2, r3)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0401:
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r2 = r9.stateHolder
            kotlinx.coroutines.sync.Mutex r14 = r2.lock
            r3.f36790k = r9
            r3.f36791l = r13
            r3.f36792m = r12
            r3.f36793n = r11
            r3.f36794o = r10
            r3.f36795p = r0
            r3.f36796q = r8
            r3.f36797r = r6
            r3.f36798s = r2
            r3.f36799t = r14
            r15 = 5
            r3.f36788i = r15
            r15 = 0
            java.lang.Object r5 = r14.lock(r15, r3)
            if (r5 != r4) goto L_0x0426
            return r4
        L_0x0426:
            r5 = r2
            r16 = r9
            r9 = r0
            goto L_0x015c
        L_0x042c:
            androidx.paging.PageFetcherSnapshotState r2 = r5.state     // Catch:{ all -> 0x047d }
            int r5 = r12.getGenerationId()     // Catch:{ all -> 0x047d }
            r15 = r6
            androidx.paging.PagingSource$LoadResult$Page r15 = (androidx.paging.PagingSource.LoadResult.Page) r15     // Catch:{ all -> 0x047d }
            boolean r2 = r2.insert(r5, r13, r15)     // Catch:{ all -> 0x047d }
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch:{ all -> 0x047d }
            r5 = 0
            r14.unlock(r5)
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x044b
            goto L_0x068b
        L_0x044b:
            int r2 = r11.element
            r5 = r6
            androidx.paging.PagingSource$LoadResult$Page r5 = (androidx.paging.PagingSource.LoadResult.Page) r5
            java.util.List r14 = r5.getData()
            int r14 = r14.size()
            int r2 = r2 + r14
            r11.element = r2
            androidx.paging.LoadType r2 = androidx.paging.LoadType.PREPEND
            if (r13 != r2) goto L_0x0468
            java.lang.Object r2 = r5.getPrevKey()
            if (r2 == 0) goto L_0x0466
            goto L_0x0468
        L_0x0466:
            r2 = 1
            goto L_0x0473
        L_0x0468:
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
            if (r13 != r2) goto L_0x0475
            java.lang.Object r2 = r5.getNextKey()
            if (r2 != 0) goto L_0x0475
            goto L_0x0466
        L_0x0473:
            r9.element = r2
        L_0x0475:
            r14 = 0
            r16 = r9
            r9 = r0
            r0 = r16
            goto L_0x04ff
        L_0x047d:
            r0 = move-exception
            r2 = 0
            r14.unlock(r2)
            throw r0
        L_0x0483:
            boolean r2 = r6 instanceof androidx.paging.PagingSource.LoadResult.Error
            if (r2 == 0) goto L_0x04fe
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r5 = r9.stateHolder
            kotlinx.coroutines.sync.Mutex r0 = r5.lock
            r3.f36790k = r9
            r3.f36791l = r13
            r3.f36792m = r12
            r3.f36793n = r6
            r3.f36794o = r5
            r3.f36795p = r0
            r2 = 0
            r3.f36796q = r2
            r7 = 6
            r3.f36788i = r7
            java.lang.Object r7 = r0.lock(r2, r3)
            if (r7 != r4) goto L_0x04a6
            return r4
        L_0x04a6:
            r2 = r4
            r4 = r0
            r0 = r3
            r3 = r13
        L_0x04aa:
            androidx.paging.PageFetcherSnapshotState r5 = r5.state     // Catch:{ all -> 0x0108 }
            androidx.paging.LoadState$Error r7 = new androidx.paging.LoadState$Error     // Catch:{ all -> 0x0108 }
            androidx.paging.PagingSource$LoadResult$Error r6 = (androidx.paging.PagingSource.LoadResult.Error) r6     // Catch:{ all -> 0x0108 }
            java.lang.Throwable r6 = r6.getThrowable()     // Catch:{ all -> 0x0108 }
            r7.<init>(r6)     // Catch:{ all -> 0x0108 }
            boolean r6 = r5.setSourceLoadState(r3, r7)     // Catch:{ all -> 0x0108 }
            if (r6 == 0) goto L_0x04e6
            kotlinx.coroutines.channels.Channel<androidx.paging.PageEvent<Value>> r6 = r9.pageEventCh     // Catch:{ all -> 0x0108 }
            androidx.paging.PageEvent$LoadStateUpdate r8 = new androidx.paging.PageEvent$LoadStateUpdate     // Catch:{ all -> 0x0108 }
            r14 = 0
            r8.<init>(r3, r14, r7)     // Catch:{ all -> 0x0108 }
            r0.f36790k = r3     // Catch:{ all -> 0x0108 }
            r0.f36791l = r12     // Catch:{ all -> 0x0108 }
            r0.f36792m = r4     // Catch:{ all -> 0x0108 }
            r0.f36793n = r5     // Catch:{ all -> 0x0108 }
            r7 = 0
            r0.f36794o = r7     // Catch:{ all -> 0x04e3 }
            r0.f36795p = r7     // Catch:{ all -> 0x04e3 }
            r7 = 7
            r0.f36788i = r7     // Catch:{ all -> 0x0108 }
            java.lang.Object r0 = r6.send(r8, r0)     // Catch:{ all -> 0x0108 }
            if (r0 != r2) goto L_0x04de
            return r2
        L_0x04de:
            r0 = r5
            r5 = r12
        L_0x04e0:
            r12 = r5
            r5 = r0
            goto L_0x04e6
        L_0x04e3:
            r0 = move-exception
            r2 = r7
            goto L_0x04fa
        L_0x04e6:
            java.util.Map r0 = r5.getFailedHintsByLoadType$paging_common()     // Catch:{ all -> 0x0108 }
            androidx.paging.ViewportHint r2 = r12.getHint()     // Catch:{ all -> 0x0108 }
            r0.put(r3, r2)     // Catch:{ all -> 0x0108 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0108 }
            r2 = 0
            r4.unlock(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x04fa:
            r4.unlock(r2)
            throw r0
        L_0x04fe:
            r14 = 0
        L_0x04ff:
            int[] r2 = androidx.paging.PageFetcherSnapshot.WhenMappings.$EnumSwitchMapping$4
            int r5 = r13.ordinal()
            r2 = r2[r5]
            r5 = 1
            if (r2 == r5) goto L_0x050d
            androidx.paging.LoadType r2 = androidx.paging.LoadType.PREPEND
            goto L_0x050f
        L_0x050d:
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
        L_0x050f:
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r15 = r9.stateHolder
            kotlinx.coroutines.sync.Mutex r5 = r15.lock
            r3.f36790k = r9
            r3.f36791l = r13
            r3.f36792m = r12
            r3.f36793n = r11
            r3.f36794o = r10
            r3.f36795p = r0
            r3.f36796q = r8
            r3.f36797r = r6
            r3.f36798s = r2
            r3.f36799t = r15
            r3.f36800u = r5
            r14 = 8
            r3.f36788i = r14
            r18 = r0
            r14 = 0
            java.lang.Object r0 = r5.lock(r14, r3)
            if (r0 != r4) goto L_0x0539
            return r4
        L_0x0539:
            r14 = r12
            r12 = r10
            r10 = r8
            r8 = r6
            r6 = r2
            r2 = r5
            r5 = r15
            r15 = r13
            r13 = r11
            r11 = r18
        L_0x0544:
            androidx.paging.PageFetcherSnapshotState r0 = r5.state     // Catch:{ all -> 0x0683 }
            androidx.paging.ViewportHint r5 = r14.getHint()     // Catch:{ all -> 0x0683 }
            androidx.paging.PageEvent$Drop r5 = r0.dropEventOrNull(r6, r5)     // Catch:{ all -> 0x0683 }
            if (r5 == 0) goto L_0x058f
            r0.drop(r5)     // Catch:{ all -> 0x0683 }
            kotlinx.coroutines.channels.Channel<androidx.paging.PageEvent<Value>> r6 = r9.pageEventCh     // Catch:{ all -> 0x0683 }
            r3.f36790k = r9     // Catch:{ all -> 0x0683 }
            r3.f36791l = r15     // Catch:{ all -> 0x0683 }
            r3.f36792m = r14     // Catch:{ all -> 0x0683 }
            r3.f36793n = r13     // Catch:{ all -> 0x0683 }
            r3.f36794o = r12     // Catch:{ all -> 0x0683 }
            r3.f36795p = r11     // Catch:{ all -> 0x0683 }
            r3.f36796q = r10     // Catch:{ all -> 0x0683 }
            r3.f36797r = r8     // Catch:{ all -> 0x0683 }
            r3.f36798s = r2     // Catch:{ all -> 0x0683 }
            r3.f36799t = r0     // Catch:{ all -> 0x0683 }
            r1 = 0
            r3.f36800u = r1     // Catch:{ all -> 0x058b }
            r1 = 9
            r3.f36788i = r1     // Catch:{ all -> 0x0683 }
            java.lang.Object r1 = r6.send(r5, r3)     // Catch:{ all -> 0x0683 }
            if (r1 != r4) goto L_0x0579
            return r4
        L_0x0579:
            r5 = r2
            r6 = r8
            r8 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r9
        L_0x0582:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bd }
            r9 = r15
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            goto L_0x0592
        L_0x058b:
            r0 = move-exception
            r5 = r2
            goto L_0x0687
        L_0x058f:
            r5 = r2
            r6 = r8
            r8 = r10
        L_0x0592:
            int r1 = r14.getGenerationId()     // Catch:{ all -> 0x00bd }
            int r2 = r14.presentedItemsBeyondAnchor$paging_common(r15)     // Catch:{ all -> 0x00bd }
            int r10 = r13.element     // Catch:{ all -> 0x00bd }
            int r2 = r2 + r10
            java.lang.Object r1 = r9.nextLoadKeyOrNull(r0, r15, r1, r2)     // Catch:{ all -> 0x00bd }
            r12.element = r1     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x05c5
            androidx.paging.LoadStates r1 = r0.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x00bd }
            androidx.paging.LoadState r1 = r1.get$paging_common(r15)     // Catch:{ all -> 0x00bd }
            boolean r1 = r1 instanceof androidx.paging.LoadState.Error     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x05c5
            boolean r1 = r11.element     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x05bc
            androidx.paging.LoadState$NotLoading$Companion r1 = androidx.paging.LoadState.NotLoading.Companion     // Catch:{ all -> 0x00bd }
            androidx.paging.LoadState$NotLoading r1 = r1.getComplete$paging_common()     // Catch:{ all -> 0x00bd }
            goto L_0x05c2
        L_0x05bc:
            androidx.paging.LoadState$NotLoading$Companion r1 = androidx.paging.LoadState.NotLoading.Companion     // Catch:{ all -> 0x00bd }
            androidx.paging.LoadState$NotLoading r1 = r1.getIncomplete$paging_common()     // Catch:{ all -> 0x00bd }
        L_0x05c2:
            r0.setSourceLoadState(r15, r1)     // Catch:{ all -> 0x00bd }
        L_0x05c5:
            r1 = r6
            androidx.paging.PagingSource$LoadResult$Page r1 = (androidx.paging.PagingSource.LoadResult.Page) r1     // Catch:{ all -> 0x00bd }
            androidx.paging.PageEvent r0 = r0.toPageEvent$paging_common(r1, r15)     // Catch:{ all -> 0x00bd }
            kotlinx.coroutines.channels.Channel<androidx.paging.PageEvent<Value>> r1 = r9.pageEventCh     // Catch:{ all -> 0x00bd }
            r3.f36790k = r9     // Catch:{ all -> 0x00bd }
            r3.f36791l = r15     // Catch:{ all -> 0x00bd }
            r3.f36792m = r14     // Catch:{ all -> 0x00bd }
            r3.f36793n = r13     // Catch:{ all -> 0x00bd }
            r3.f36794o = r12     // Catch:{ all -> 0x00bd }
            r3.f36795p = r11     // Catch:{ all -> 0x00bd }
            r3.f36796q = r8     // Catch:{ all -> 0x00bd }
            r3.f36797r = r6     // Catch:{ all -> 0x00bd }
            r3.f36798s = r5     // Catch:{ all -> 0x00bd }
            r2 = 0
            r3.f36799t = r2     // Catch:{ all -> 0x0680 }
            r3.f36800u = r2     // Catch:{ all -> 0x0680 }
            r2 = 10
            r3.f36788i = r2     // Catch:{ all -> 0x00bd }
            java.lang.Object r0 = r1.send(r0, r3)     // Catch:{ all -> 0x00bd }
            if (r0 != r4) goto L_0x05f0
            return r4
        L_0x05f0:
            r0 = r6
            r6 = r8
            r10 = r9
            r8 = r14
            r14 = r12
            r16 = r13
            r13 = r11
            r11 = r15
            r15 = r16
        L_0x05fb:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bd }
            r1 = 0
            r5.unlock(r1)
            boolean r1 = r6 instanceof androidx.paging.PagingSource.LoadParams.Prepend
            if (r1 == 0) goto L_0x0610
            r1 = r0
            androidx.paging.PagingSource$LoadResult$Page r1 = (androidx.paging.PagingSource.LoadResult.Page) r1
            java.lang.Object r1 = r1.getPrevKey()
            if (r1 != 0) goto L_0x0610
            r5 = 1
            goto L_0x0611
        L_0x0610:
            r5 = 0
        L_0x0611:
            boolean r1 = r6 instanceof androidx.paging.PagingSource.LoadParams.Append
            if (r1 == 0) goto L_0x061f
            androidx.paging.PagingSource$LoadResult$Page r0 = (androidx.paging.PagingSource.LoadResult.Page) r0
            java.lang.Object r0 = r0.getNextKey()
            if (r0 != 0) goto L_0x061f
            r0 = 1
            goto L_0x0620
        L_0x061f:
            r0 = 0
        L_0x0620:
            androidx.paging.RemoteMediatorConnection<Key, Value> r1 = r10.remoteMediatorConnection
            if (r1 == 0) goto L_0x0670
            if (r5 != 0) goto L_0x0628
            if (r0 == 0) goto L_0x0670
        L_0x0628:
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r12 = r10.stateHolder
            kotlinx.coroutines.sync.Mutex r6 = r12.lock
            r3.f36790k = r10
            r3.f36791l = r11
            r3.f36792m = r8
            r3.f36793n = r15
            r3.f36794o = r14
            r3.f36795p = r13
            r3.f36796q = r12
            r3.f36797r = r6
            r1 = 0
            r3.f36798s = r1
            r3.f36801v = r5
            r3.f36802w = r0
            r2 = 11
            r3.f36788i = r2
            java.lang.Object r2 = r6.lock(r1, r3)
            if (r2 != r4) goto L_0x0650
            return r4
        L_0x0650:
            androidx.paging.PageFetcherSnapshotState r1 = r12.state     // Catch:{ all -> 0x0676 }
            androidx.paging.ViewportHint$Access r2 = r10.lastHint     // Catch:{ all -> 0x0676 }
            androidx.paging.PagingState r1 = r1.currentPagingState$paging_common(r2)     // Catch:{ all -> 0x0676 }
            r2 = 0
            r6.unlock(r2)
            if (r5 == 0) goto L_0x0667
            androidx.paging.RemoteMediatorConnection<Key, Value> r2 = r10.remoteMediatorConnection
            androidx.paging.LoadType r5 = androidx.paging.LoadType.PREPEND
            r2.requestLoad(r5, r1)
        L_0x0667:
            if (r0 == 0) goto L_0x0670
            androidx.paging.RemoteMediatorConnection<Key, Value> r0 = r10.remoteMediatorConnection
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
            r0.requestLoad(r2, r1)
        L_0x0670:
            r12 = r10
            r0 = r13
            r2 = r14
            r9 = r15
            r10 = r8
            goto L_0x067c
        L_0x0676:
            r0 = move-exception
            r1 = 0
            r6.unlock(r1)
            throw r0
        L_0x067c:
            r1 = r17
            goto L_0x0357
        L_0x0680:
            r0 = move-exception
            r1 = r2
            goto L_0x0687
        L_0x0683:
            r0 = move-exception
            r5 = r2
            goto L_0x00be
        L_0x0687:
            r5.unlock(r1)
            throw r0
        L_0x068b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x068e:
            r0 = move-exception
            r6 = r5
            goto L_0x01ad
        L_0x0692:
            r6.unlock(r1)
            throw r0
        L_0x0696:
            r0 = move-exception
            r1 = 0
            r2.unlock(r1)
            throw r0
        L_0x069c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.c(androidx.paging.LoadType, androidx.paging.GenerationalViewportHint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void close() {
        Job.DefaultImpls.cancel$default((Job) this.pageEventChannelFlowJob, (CancellationException) null, 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object currentPagingState(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PagingState<Key, Value>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$currentPagingState$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = (androidx.paging.PageFetcherSnapshot$currentPagingState$1) r0
            int r1 = r0.f36774i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36774i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcherSnapshot$currentPagingState$1 r0 = new androidx.paging.PageFetcherSnapshot$currentPagingState$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f36773h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36774i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r4) goto L_0x0036
            java.lang.Object r1 = r0.f36778m
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.f36777l
            androidx.paging.PageFetcherSnapshotState$Holder r2 = (androidx.paging.PageFetcherSnapshotState.Holder) r2
            java.lang.Object r0 = r0.f36776k
            androidx.paging.PageFetcherSnapshot r0 = (androidx.paging.PageFetcherSnapshot) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0058
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.paging.PageFetcherSnapshotState$Holder<Key, Value> r2 = r5.stateHolder
            kotlinx.coroutines.sync.Mutex r6 = r2.lock
            r0.f36776k = r5
            r0.f36777l = r2
            r0.f36778m = r6
            r0.f36774i = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r0 = r5
            r1 = r6
        L_0x0058:
            androidx.paging.PageFetcherSnapshotState r6 = r2.state     // Catch:{ all -> 0x0066 }
            androidx.paging.ViewportHint$Access r0 = r0.lastHint     // Catch:{ all -> 0x0066 }
            androidx.paging.PagingState r6 = r6.currentPagingState$paging_common(r0)     // Catch:{ all -> 0x0066 }
            r1.unlock(r3)
            return r6
        L_0x0066:
            r6 = move-exception
            r1.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.currentPagingState(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final /* synthetic */ Object d(LoadType loadType, ViewportHint viewportHint, Continuation<? super Unit> continuation) {
        boolean z11 = true;
        if (WhenMappings.$EnumSwitchMapping$1[loadType.ordinal()] != 1) {
            if (viewportHint == null) {
                z11 = false;
            }
            if (z11) {
                this.hintSharedFlow.tryEmit(viewportHint);
            } else {
                throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
            }
        } else {
            Object b11 = b(continuation);
            if (b11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return b11;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object e(androidx.paging.PageFetcherSnapshotState<Key, Value> r6, androidx.paging.LoadType r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.paging.PageFetcherSnapshot$setLoading$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.paging.PageFetcherSnapshot$setLoading$1 r0 = (androidx.paging.PageFetcherSnapshot$setLoading$1) r0
            int r1 = r0.f36818i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36818i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcherSnapshot$setLoading$1 r0 = new androidx.paging.PageFetcherSnapshot$setLoading$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f36817h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36818i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004d
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.paging.LoadState$Loading r8 = androidx.paging.LoadState.Loading.INSTANCE
            boolean r6 = r6.setSourceLoadState(r7, r8)
            if (r6 == 0) goto L_0x004d
            kotlinx.coroutines.channels.Channel<androidx.paging.PageEvent<Value>> r6 = r5.pageEventCh
            androidx.paging.PageEvent$LoadStateUpdate r2 = new androidx.paging.PageEvent$LoadStateUpdate
            r4 = 0
            r2.<init>(r7, r4, r8)
            r0.f36818i = r3
            java.lang.Object r6 = r6.send(r2, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.e(androidx.paging.PageFetcherSnapshotState, androidx.paging.LoadType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Key getInitialKey$paging_common() {
        return this.initialKey;
    }

    @NotNull
    public final Flow<PageEvent<Value>> getPageEventFlow() {
        return this.pageEventFlow;
    }

    @NotNull
    public final PagingSource<Key, Value> getPagingSource$paging_common() {
        return this.pagingSource;
    }

    @Nullable
    public final RemoteMediatorConnection<Key, Value> getRemoteMediatorConnection() {
        return this.remoteMediatorConnection;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PageFetcherSnapshot(java.lang.Object r12, androidx.paging.PagingSource r13, androidx.paging.PagingConfig r14, kotlinx.coroutines.flow.Flow r15, boolean r16, androidx.paging.RemoteMediatorConnection r17, androidx.paging.PagingState r18, kotlin.jvm.functions.Function0 r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r7 = r1
            goto L_0x000b
        L_0x0009:
            r7 = r16
        L_0x000b:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r8 = r2
            goto L_0x0014
        L_0x0012:
            r8 = r17
        L_0x0014:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001a
            r9 = r2
            goto L_0x001c
        L_0x001a:
            r9 = r18
        L_0x001c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0024
            androidx.paging.PageFetcherSnapshot$1 r0 = androidx.paging.PageFetcherSnapshot.AnonymousClass1.INSTANCE
            r10 = r0
            goto L_0x0026
        L_0x0024:
            r10 = r19
        L_0x0026:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot.<init>(java.lang.Object, androidx.paging.PagingSource, androidx.paging.PagingConfig, kotlinx.coroutines.flow.Flow, boolean, androidx.paging.RemoteMediatorConnection, androidx.paging.PagingState, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
