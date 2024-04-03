package androidx.paging;

import androidx.paging.PageFetcherSnapshot$pageEventFlow$1;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<PageEvent<Value>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot$pageEventFlow$1.AnonymousClass2 f36747b;

    public PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1(PageFetcherSnapshot$pageEventFlow$1.AnonymousClass2 r12) {
        this.f36747b = r12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.f36749i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36749i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f36748h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36749i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ ClosedSendChannelException -> 0x0043 }
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.paging.PageEvent r5 = (androidx.paging.PageEvent) r5
            androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2 r6 = r4.f36747b     // Catch:{ ClosedSendChannelException -> 0x0043 }
            androidx.paging.SimpleProducerScope r6 = r14     // Catch:{ ClosedSendChannelException -> 0x0043 }
            r0.f36749i = r3     // Catch:{ ClosedSendChannelException -> 0x0043 }
            java.lang.Object r5 = r6.send(r5, r0)     // Catch:{ ClosedSendChannelException -> 0x0043 }
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
