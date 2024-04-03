package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 1, 2, 2, 2}, l = {595, 160, 607}, m = "invokeSuspend", n = {"$this$cancelableChannelFlow", "it", "this_$iv", "$this$withLock$iv$iv", "$this$cancelableChannelFlow", "$this$cancelableChannelFlow", "this_$iv", "$this$withLock$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2"})
public final class PageFetcherSnapshot$pageEventFlow$1 extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f36803h;

    /* renamed from: i  reason: collision with root package name */
    public Object f36804i;

    /* renamed from: j  reason: collision with root package name */
    public Object f36805j;

    /* renamed from: k  reason: collision with root package name */
    public int f36806k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36807l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f36807l = pageFetcherSnapshot;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.f36807l, continuation);
        pageFetcherSnapshot$pageEventFlow$1.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0111  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.f36806k
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0049
            if (r1 == r4) goto L_0x0035
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r13.f36804i
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r1 = r13.f36803h
            androidx.paging.PageFetcherSnapshotState$Holder r1 = (androidx.paging.PageFetcherSnapshotState.Holder) r1
            java.lang.Object r2 = r13.L$0
            androidx.paging.SimpleProducerScope r2 = (androidx.paging.SimpleProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00fc
        L_0x0023:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x002b:
            java.lang.Object r1 = r13.L$0
            androidx.paging.SimpleProducerScope r1 = (androidx.paging.SimpleProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r1
            goto L_0x00e1
        L_0x0035:
            java.lang.Object r1 = r13.f36805j
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r4 = r13.f36804i
            androidx.paging.PageFetcherSnapshotState$Holder r4 = (androidx.paging.PageFetcherSnapshotState.Holder) r4
            java.lang.Object r6 = r13.f36803h
            androidx.paging.RemoteMediatorConnection r6 = (androidx.paging.RemoteMediatorConnection) r6
            java.lang.Object r7 = r13.L$0
            androidx.paging.SimpleProducerScope r7 = (androidx.paging.SimpleProducerScope) r7
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b6
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            androidx.paging.SimpleProducerScope r14 = (androidx.paging.SimpleProducerScope) r14
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.pageEventChCollected
            r12 = 0
            boolean r1 = r1.compareAndSet(r12, r4)
            if (r1 == 0) goto L_0x011e
            r7 = 0
            r8 = 0
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2 r9 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2
            r9.<init>(r13, r14, r5)
            r10 = 3
            r11 = 0
            r6 = r14
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            r1 = 6
            kotlinx.coroutines.channels.Channel r1 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r12, r5, r5, r1, r5)
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3 r9 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3
            r9.<init>(r13, r1, r5)
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4 r9 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4
            r9.<init>(r13, r1, r5)
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            boolean r1 = r1.triggerRemoteRefresh
            if (r1 == 0) goto L_0x00ce
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            androidx.paging.RemoteMediatorConnection r6 = r1.getRemoteMediatorConnection()
            if (r6 == 0) goto L_0x00ce
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            androidx.paging.PagingState r1 = r1.previousPagingState
            if (r1 == 0) goto L_0x0098
            goto L_0x00c3
        L_0x0098:
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r1 = r1.stateHolder
            kotlinx.coroutines.sync.Mutex r7 = r1.lock
            r13.L$0 = r14
            r13.f36803h = r6
            r13.f36804i = r1
            r13.f36805j = r7
            r13.f36806k = r4
            java.lang.Object r4 = r7.lock(r5, r13)
            if (r4 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            r4 = r1
            r1 = r7
            r7 = r14
        L_0x00b6:
            androidx.paging.PageFetcherSnapshotState r14 = r4.state     // Catch:{ all -> 0x00c9 }
            androidx.paging.PagingState r14 = r14.currentPagingState$paging_common(r5)     // Catch:{ all -> 0x00c9 }
            r1.unlock(r5)
            r1 = r14
            r14 = r7
        L_0x00c3:
            androidx.paging.LoadType r4 = androidx.paging.LoadType.REFRESH
            r6.requestLoad(r4, r1)
            goto L_0x00ce
        L_0x00c9:
            r14 = move-exception
            r1.unlock(r5)
            throw r14
        L_0x00ce:
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            r13.L$0 = r14
            r13.f36803h = r5
            r13.f36804i = r5
            r13.f36805j = r5
            r13.f36806k = r3
            java.lang.Object r1 = r1.b(r13)
            if (r1 != r0) goto L_0x00e1
            return r0
        L_0x00e1:
            androidx.paging.PageFetcherSnapshot r1 = r13.f36807l
            androidx.paging.PageFetcherSnapshotState$Holder r1 = r1.stateHolder
            kotlinx.coroutines.sync.Mutex r3 = r1.lock
            r13.L$0 = r14
            r13.f36803h = r1
            r13.f36804i = r3
            r13.f36806k = r2
            java.lang.Object r2 = r3.lock(r5, r13)
            if (r2 != r0) goto L_0x00fa
            return r0
        L_0x00fa:
            r2 = r14
            r0 = r3
        L_0x00fc:
            androidx.paging.PageFetcherSnapshotState r14 = r1.state     // Catch:{ all -> 0x0119 }
            androidx.paging.LoadStates r14 = r14.getSourceLoadStates$paging_common()     // Catch:{ all -> 0x0119 }
            androidx.paging.LoadType r1 = androidx.paging.LoadType.REFRESH     // Catch:{ all -> 0x0119 }
            androidx.paging.LoadState r14 = r14.get$paging_common(r1)     // Catch:{ all -> 0x0119 }
            r0.unlock(r5)
            boolean r14 = r14 instanceof androidx.paging.LoadState.Error
            if (r14 != 0) goto L_0x0116
            androidx.paging.PageFetcherSnapshot r14 = r13.f36807l
            r14.startConsumingHints(r2)
        L_0x0116:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0119:
            r14 = move-exception
            r0.unlock(r5)
            throw r14
        L_0x011e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?"
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
