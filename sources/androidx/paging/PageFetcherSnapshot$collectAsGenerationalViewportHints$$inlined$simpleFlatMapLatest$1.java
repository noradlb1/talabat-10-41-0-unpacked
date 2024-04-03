package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/FlowExtKt$simpleFlatMapLatest$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1", f = "PageFetcherSnapshot.kt", i = {0, 0}, l = {109, 130}, m = "invokeSuspend", n = {"this_$iv", "generationId"}, s = {"L$1", "I$0"})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super GenerationalViewportHint>, Integer, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;

    /* renamed from: h  reason: collision with root package name */
    public int f36735h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36736i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LoadType f36737j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36738k;

    /* renamed from: l  reason: collision with root package name */
    public int f36739l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(Continuation continuation, PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        super(3, continuation);
        this.f36736i = pageFetcherSnapshot;
        this.f36737j = loadType;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super GenerationalViewportHint> flowCollector, Integer num, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(flowCollector, "$this$create");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(continuation, this.f36736i, this.f36737j);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$0 = flowCollector;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.L$1 = num;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1) create((FlowCollector) obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f36735h
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00bc
        L_0x0014:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001c:
            int r1 = r11.f36739l
            java.lang.Object r5 = r11.f36738k
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r11.L$1
            androidx.paging.PageFetcherSnapshotState$Holder r6 = (androidx.paging.PageFetcherSnapshotState.Holder) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0059
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r7 = r12
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r12 = r11.L$1
            java.lang.Number r12 = (java.lang.Number) r12
            int r1 = r12.intValue()
            androidx.paging.PageFetcherSnapshot r12 = r11.f36736i
            androidx.paging.PageFetcherSnapshotState$Holder r6 = r12.stateHolder
            kotlinx.coroutines.sync.Mutex r5 = r6.lock
            r11.L$0 = r7
            r11.L$1 = r6
            r11.f36738k = r5
            r11.f36739l = r1
            r11.f36735h = r3
            java.lang.Object r12 = r5.lock(r4, r11)
            if (r12 != r0) goto L_0x0059
            return r0
        L_0x0059:
            androidx.paging.PageFetcherSnapshotState r12 = r6.state     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadStates r6 = r12.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadType r8 = r11.f36737j     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadState r6 = r6.get$paging_common(r8)     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadState$NotLoading$Companion r8 = androidx.paging.LoadState.NotLoading.Companion     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadState$NotLoading r9 = r8.getComplete$paging_common()     // Catch:{ all -> 0x00bf }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r9)     // Catch:{ all -> 0x00bf }
            r9 = 0
            if (r6 == 0) goto L_0x007e
            androidx.paging.GenerationalViewportHint[] r12 = new androidx.paging.GenerationalViewportHint[r9]     // Catch:{ all -> 0x00bf }
            kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.flowOf((T[]) r12)     // Catch:{ all -> 0x00bf }
            r5.unlock(r4)
            goto L_0x00ad
        L_0x007e:
            androidx.paging.LoadStates r6 = r12.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadType r10 = r11.f36737j     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadState r6 = r6.get$paging_common(r10)     // Catch:{ all -> 0x00bf }
            boolean r6 = r6 instanceof androidx.paging.LoadState.Error     // Catch:{ all -> 0x00bf }
            if (r6 != 0) goto L_0x0095
            androidx.paging.LoadType r6 = r11.f36737j     // Catch:{ all -> 0x00bf }
            androidx.paging.LoadState$NotLoading r8 = r8.getIncomplete$paging_common()     // Catch:{ all -> 0x00bf }
            r12.setSourceLoadState(r6, r8)     // Catch:{ all -> 0x00bf }
        L_0x0095:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bf }
            r5.unlock(r4)
            androidx.paging.PageFetcherSnapshot r12 = r11.f36736i
            kotlinx.coroutines.flow.MutableSharedFlow r12 = r12.hintSharedFlow
            if (r1 != 0) goto L_0x00a3
            r3 = r9
        L_0x00a3:
            kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.drop(r12, r3)
            androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1$lambda$1 r3 = new androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1$lambda$1
            r3.<init>(r12, r1)
            r12 = r3
        L_0x00ad:
            r11.L$0 = r4
            r11.L$1 = r4
            r11.f36738k = r4
            r11.f36735h = r2
            java.lang.Object r12 = r12.collect(r7, r11)
            if (r12 != r0) goto L_0x00bc
            return r0
        L_0x00bc:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00bf:
            r12 = move-exception
            r5.unlock(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
