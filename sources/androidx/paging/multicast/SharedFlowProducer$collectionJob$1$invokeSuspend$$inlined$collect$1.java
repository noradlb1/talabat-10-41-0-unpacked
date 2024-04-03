package androidx.paging.multicast;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SharedFlowProducer$collectionJob$1 f37232b;

    public SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1(SharedFlowProducer$collectionJob$1 sharedFlowProducer$collectionJob$1) {
        this.f37232b = sharedFlowProducer$collectionJob$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.f37234i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37234i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f37233h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f37234i
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r5) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.f37236k
            kotlinx.coroutines.CompletableDeferred r8 = (kotlinx.coroutines.CompletableDeferred) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.CompletableDeferred r9 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r4, r5, r4)
            androidx.paging.multicast.SharedFlowProducer$collectionJob$1 r2 = r7.f37232b
            androidx.paging.multicast.SharedFlowProducer r2 = r2.f37238i
            kotlin.jvm.functions.Function2 r2 = r2.sendUpsteamMessage
            androidx.paging.multicast.ChannelManager$Message$Dispatch$Value r6 = new androidx.paging.multicast.ChannelManager$Message$Dispatch$Value
            r6.<init>(r8, r9)
            r0.f37236k = r9
            r0.f37234i = r5
            java.lang.Object r8 = r2.invoke(r6, r0)
            if (r8 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r8 = r9
        L_0x005d:
            r0.f37236k = r4
            r0.f37234i = r3
            java.lang.Object r8 = r8.await(r0)
            if (r8 != r1) goto L_0x0068
            return r1
        L_0x0068:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
