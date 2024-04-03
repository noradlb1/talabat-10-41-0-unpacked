package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<IndexedValue<? extends PageEvent<T>>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1 f36479b;

    public CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1(CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1 cachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1) {
        this.f36479b = cachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.f36481i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36481i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f36480h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36481i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007e
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f36484l
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            java.lang.Object r2 = r0.f36483k
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1 r2 = (androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1 r7 = r5.f36479b
            androidx.paging.TemporaryDownstream r7 = r7.f36491k
            r7.close()
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1 r7 = r5.f36479b
            kotlinx.coroutines.Job r7 = r7.f36492l
            r0.f36483k = r5
            r0.f36484l = r6
            r0.f36481i = r4
            java.lang.Object r7 = r7.join(r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r2 = r5
        L_0x005e:
            int r7 = r6.getIndex()
            androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1 r2 = r2.f36479b
            kotlin.jvm.internal.Ref$IntRef r4 = r2.f36493m
            int r4 = r4.element
            if (r7 <= r4) goto L_0x007e
            androidx.paging.SimpleProducerScope r7 = r2.f36490j
            java.lang.Object r6 = r6.getValue()
            r2 = 0
            r0.f36483k = r2
            r0.f36484l = r2
            r0.f36481i = r3
            java.lang.Object r6 = r7.send(r6, r0)
            if (r6 != r1) goto L_0x007e
            return r1
        L_0x007e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
