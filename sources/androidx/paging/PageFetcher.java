package androidx.paging;

import com.instabug.commons.snapshot.StateSnapshotCaptor;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002)*B^\u0012(\u0010\u001d\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010$ø\u0001\u0000¢\u0006\u0004\b'\u0010(J:\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\nJ5\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00160\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR9\u0010\u001d\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00018\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010%\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/paging/PageFetcher;", "", "Key", "Value", "Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/RemoteMediatorAccessor;", "accessor", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "injectRemoteEvents", "", "invalidate", "refresh", "Landroidx/paging/PagingSource;", "previousPagingSource", "a", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/ConflatedEventBus;", "", "refreshEvents", "Landroidx/paging/ConflatedEventBus;", "retryEvents", "Landroidx/paging/PagingData;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "pagingSourceFactory", "Lkotlin/jvm/functions/Function1;", "initialKey", "Ljava/lang/Object;", "Landroidx/paging/PagingConfig;", "config", "Landroidx/paging/PagingConfig;", "Landroidx/paging/RemoteMediator;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/paging/PagingConfig;Landroidx/paging/RemoteMediator;)V", "GenerationInfo", "PagerUiReceiver", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PageFetcher<Key, Value> {
    /* access modifiers changed from: private */
    public final PagingConfig config;
    @NotNull
    private final Flow<PagingData<Value>> flow;
    /* access modifiers changed from: private */
    public final Key initialKey;
    private final Function1<Continuation<? super PagingSource<Key, Value>>, Object> pagingSourceFactory;
    /* access modifiers changed from: private */
    public final ConflatedEventBus<Boolean> refreshEvents;
    /* access modifiers changed from: private */
    public final RemoteMediator<Key, Value> remoteMediator;
    /* access modifiers changed from: private */
    public final ConflatedEventBus<Unit> retryEvents;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "", "Value", "snapshot", "Landroidx/paging/PageFetcherSnapshot;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;)V", "getSnapshot", "()Landroidx/paging/PageFetcherSnapshot;", "getState", "()Landroidx/paging/PagingState;", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class GenerationInfo<Key, Value> {
        @NotNull
        private final PageFetcherSnapshot<Key, Value> snapshot;
        @Nullable
        private final PagingState<Key, Value> state;

        public GenerationInfo(@NotNull PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, @Nullable PagingState<Key, Value> pagingState) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
            this.snapshot = pageFetcherSnapshot;
            this.state = pagingState;
        }

        @NotNull
        public final PageFetcherSnapshot<Key, Value> getSnapshot() {
            return this.snapshot;
        }

        @Nullable
        public final PagingState<Key, Value> getState() {
            return this.state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0004B'\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "Key", "", "Value", "Landroidx/paging/UiReceiver;", "pageFetcherSnapshot", "Landroidx/paging/PageFetcherSnapshot;", "retryEventBus", "Landroidx/paging/ConflatedEventBus;", "", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/ConflatedEventBus;)V", "accessHint", "viewportHint", "Landroidx/paging/ViewportHint;", "refresh", "retry", "paging-common"}, k = 1, mv = {1, 4, 2})
    public final class PagerUiReceiver<Key, Value> implements UiReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PageFetcher f36709a;
        private final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        private final ConflatedEventBus<Unit> retryEventBus;

        public PagerUiReceiver(@NotNull PageFetcher pageFetcher, @NotNull PageFetcherSnapshot<Key, Value> pageFetcherSnapshot2, ConflatedEventBus<Unit> conflatedEventBus) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot2, "pageFetcherSnapshot");
            Intrinsics.checkNotNullParameter(conflatedEventBus, "retryEventBus");
            this.f36709a = pageFetcher;
            this.pageFetcherSnapshot = pageFetcherSnapshot2;
            this.retryEventBus = conflatedEventBus;
        }

        public void accessHint(@NotNull ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
            this.pageFetcherSnapshot.accessHint(viewportHint);
        }

        public void refresh() {
            this.f36709a.refresh();
        }

        public void retry() {
            this.retryEventBus.send(Unit.INSTANCE);
        }
    }

    public PageFetcher(@NotNull Function1<? super Continuation<? super PagingSource<Key, Value>>, ? extends Object> function1, @Nullable Key key, @NotNull PagingConfig pagingConfig, @Nullable RemoteMediator<Key, Value> remoteMediator2) {
        Intrinsics.checkNotNullParameter(function1, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(pagingConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.pagingSourceFactory = function1;
        this.initialKey = key;
        this.config = pagingConfig;
        this.remoteMediator = remoteMediator2;
        this.refreshEvents = new ConflatedEventBus<>((Object) null, 1, (DefaultConstructorMarker) null);
        this.retryEvents = new ConflatedEventBus<>((Object) null, 1, (DefaultConstructorMarker) null);
        this.flow = SimpleChannelFlowKt.simpleChannelFlow(new PageFetcher$flow$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final Flow<PageEvent<Value>> injectRemoteEvents(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor) {
        if (remoteMediatorAccessor == null) {
            return pageFetcherSnapshot.getPageEventFlow();
        }
        return SimpleChannelFlowKt.simpleChannelFlow(new PageFetcher$injectRemoteEvents$1(pageFetcherSnapshot, remoteMediatorAccessor, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void invalidate() {
        this.refreshEvents.send(Boolean.FALSE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(androidx.paging.PagingSource<Key, Value> r5, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource<Key, Value>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcher$generateNewPagingSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = (androidx.paging.PageFetcher$generateNewPagingSource$1) r0
            int r1 = r0.f36720i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36720i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcher$generateNewPagingSource$1 r0 = new androidx.paging.PageFetcher$generateNewPagingSource$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f36719h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36720i
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.f36723l
            androidx.paging.PagingSource r5 = (androidx.paging.PagingSource) r5
            java.lang.Object r0 = r0.f36722k
            androidx.paging.PageFetcher r0 = (androidx.paging.PageFetcher) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super androidx.paging.PagingSource<Key, Value>>, java.lang.Object> r6 = r4.pagingSourceFactory
            r0.f36722k = r4
            r0.f36723l = r5
            r0.f36720i = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r0 = r4
        L_0x004c:
            androidx.paging.PagingSource r6 = (androidx.paging.PagingSource) r6
            boolean r1 = r6 instanceof androidx.paging.LegacyPagingSource
            if (r1 == 0) goto L_0x005c
            r1 = r6
            androidx.paging.LegacyPagingSource r1 = (androidx.paging.LegacyPagingSource) r1
            androidx.paging.PagingConfig r2 = r0.config
            int r2 = r2.pageSize
            r1.setPageSize(r2)
        L_0x005c:
            if (r6 == r5) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r3 = 0
        L_0x0060:
            if (r3 == 0) goto L_0x007a
            androidx.paging.PageFetcher$generateNewPagingSource$3 r1 = new androidx.paging.PageFetcher$generateNewPagingSource$3
            r1.<init>(r0)
            r6.registerInvalidatedCallback(r1)
            if (r5 == 0) goto L_0x0074
            androidx.paging.PageFetcher$generateNewPagingSource$4 r1 = new androidx.paging.PageFetcher$generateNewPagingSource$4
            r1.<init>(r0)
            r5.unregisterInvalidatedCallback(r1)
        L_0x0074:
            if (r5 == 0) goto L_0x0079
            r5.invalidate()
        L_0x0079:
            return r6
        L_0x007a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher.a(androidx.paging.PagingSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final Flow<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public final void refresh() {
        this.refreshEvents.send(Boolean.TRUE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageFetcher(Function1 function1, Object obj, PagingConfig pagingConfig, RemoteMediator remoteMediator2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, obj, pagingConfig, (i11 & 8) != 0 ? null : remoteMediator2);
    }
}
