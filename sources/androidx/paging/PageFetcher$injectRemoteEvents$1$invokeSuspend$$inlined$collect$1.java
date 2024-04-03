package androidx.paging;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<PageEvent<Value>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageFetcher$injectRemoteEvents$1 f36703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SimpleProducerScope f36704c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MutableLoadStateCollection f36705d;

    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1(PageFetcher$injectRemoteEvents$1 pageFetcher$injectRemoteEvents$1, SimpleProducerScope simpleProducerScope, MutableLoadStateCollection mutableLoadStateCollection) {
        this.f36703b = pageFetcher$injectRemoteEvents$1;
        this.f36704c = simpleProducerScope;
        this.f36705d = mutableLoadStateCollection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1$1 r2 = (androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r2
            int r3 = r2.f36707i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36707i = r3
            goto L_0x001c
        L_0x0017:
            androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1$1 r2 = new androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36706h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f36707i
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x003d
            if (r4 == r7) goto L_0x0038
            if (r4 == r6) goto L_0x0038
            if (r4 != r5) goto L_0x0030
            goto L_0x0038
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00c7
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r17
            androidx.paging.PageEvent r1 = (androidx.paging.PageEvent) r1
            boolean r4 = r1 instanceof androidx.paging.PageEvent.Insert
            if (r4 == 0) goto L_0x0082
            androidx.paging.MutableLoadStateCollection r4 = r0.f36705d
            r8 = r1
            androidx.paging.PageEvent$Insert r8 = (androidx.paging.PageEvent.Insert) r8
            androidx.paging.CombinedLoadStates r1 = r8.getCombinedLoadStates()
            androidx.paging.LoadStates r1 = r1.getSource()
            androidx.paging.PageFetcher$injectRemoteEvents$1 r5 = r0.f36703b
            androidx.paging.RemoteMediatorAccessor r5 = r5.f36726j
            kotlinx.coroutines.flow.StateFlow r5 = r5.getState()
            java.lang.Object r5 = r5.getValue()
            androidx.paging.LoadStates r5 = (androidx.paging.LoadStates) r5
            r4.set(r1, r5)
            androidx.paging.SimpleProducerScope r1 = r0.f36704c
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            androidx.paging.MutableLoadStateCollection r4 = r0.f36705d
            androidx.paging.CombinedLoadStates r13 = r4.snapshot()
            r14 = 15
            r15 = 0
            androidx.paging.PageEvent$Insert r4 = androidx.paging.PageEvent.Insert.copy$default(r8, r9, r10, r11, r12, r13, r14, r15)
            r2.f36707i = r7
            java.lang.Object r1 = r1.send(r4, r2)
            if (r1 != r3) goto L_0x00c7
            return r3
        L_0x0082:
            boolean r4 = r1 instanceof androidx.paging.PageEvent.Drop
            if (r4 == 0) goto L_0x00a4
            androidx.paging.MutableLoadStateCollection r4 = r0.f36705d
            r5 = r1
            androidx.paging.PageEvent$Drop r5 = (androidx.paging.PageEvent.Drop) r5
            androidx.paging.LoadType r5 = r5.getLoadType()
            androidx.paging.LoadState$NotLoading$Companion r7 = androidx.paging.LoadState.NotLoading.Companion
            androidx.paging.LoadState$NotLoading r7 = r7.getIncomplete$paging_common()
            r8 = 0
            r4.set(r5, r8, r7)
            androidx.paging.SimpleProducerScope r4 = r0.f36704c
            r2.f36707i = r6
            java.lang.Object r1 = r4.send(r1, r2)
            if (r1 != r3) goto L_0x00c7
            return r3
        L_0x00a4:
            boolean r4 = r1 instanceof androidx.paging.PageEvent.LoadStateUpdate
            if (r4 == 0) goto L_0x00c7
            androidx.paging.MutableLoadStateCollection r4 = r0.f36705d
            r6 = r1
            androidx.paging.PageEvent$LoadStateUpdate r6 = (androidx.paging.PageEvent.LoadStateUpdate) r6
            androidx.paging.LoadType r7 = r6.getLoadType()
            boolean r8 = r6.getFromMediator()
            androidx.paging.LoadState r6 = r6.getLoadState()
            r4.set(r7, r8, r6)
            androidx.paging.SimpleProducerScope r4 = r0.f36704c
            r2.f36707i = r5
            java.lang.Object r1 = r4.send(r1, r2)
            if (r1 != r3) goto L_0x00c7
            return r3
        L_0x00c7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
