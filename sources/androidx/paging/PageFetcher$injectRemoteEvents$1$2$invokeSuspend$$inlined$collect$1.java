package androidx.paging;

import androidx.paging.PageFetcher$injectRemoteEvents$1;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<LoadStates> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageFetcher$injectRemoteEvents$1.AnonymousClass2 f36696b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f36697c;

    public PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1(PageFetcher$injectRemoteEvents$1.AnonymousClass2 r12, Ref.ObjectRef objectRef) {
        this.f36696b = r12;
        this.f36697c = objectRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.f36699i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36699i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f36698h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36699i
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x004d
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r9 = r0.f36702l
            androidx.paging.LoadStates r9 = (androidx.paging.LoadStates) r9
            java.lang.Object r0 = r0.f36701k
            androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 r0 = (androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0105
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0040:
            java.lang.Object r9 = r0.f36702l
            androidx.paging.LoadStates r9 = (androidx.paging.LoadStates) r9
            java.lang.Object r2 = r0.f36701k
            androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 r2 = (androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00cd
        L_0x004d:
            java.lang.Object r9 = r0.f36702l
            androidx.paging.LoadStates r9 = (androidx.paging.LoadStates) r9
            java.lang.Object r2 = r0.f36701k
            androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 r2 = (androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0096
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.paging.LoadStates r9 = (androidx.paging.LoadStates) r9
            kotlin.jvm.internal.Ref$ObjectRef r10 = r8.f36697c
            T r10 = r10.element
            androidx.paging.LoadStates r10 = (androidx.paging.LoadStates) r10
            androidx.paging.LoadState r10 = r10.getRefresh()
            androidx.paging.LoadState r2 = r9.getRefresh()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r2)
            r10 = r10 ^ r5
            if (r10 == 0) goto L_0x0095
            androidx.paging.PageFetcher$injectRemoteEvents$1$2 r10 = r8.f36696b
            androidx.paging.MutableLoadStateCollection r10 = r1
            androidx.paging.LoadType r2 = androidx.paging.LoadType.REFRESH
            androidx.paging.LoadState r6 = r9.getRefresh()
            r10.set(r2, r5, r6)
            androidx.paging.PageFetcher$injectRemoteEvents$1$2 r10 = r8.f36696b
            androidx.paging.PageFetcher$injectRemoteEvents$1$1 r10 = r3
            androidx.paging.LoadState r6 = r9.getRefresh()
            r0.f36701k = r8
            r0.f36702l = r9
            r0.f36699i = r5
            java.lang.Object r10 = r10.invoke((androidx.paging.LoadType) r2, (androidx.paging.LoadState) r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r10 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r2 = r8
        L_0x0096:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r2.f36697c
            T r10 = r10.element
            androidx.paging.LoadStates r10 = (androidx.paging.LoadStates) r10
            androidx.paging.LoadState r10 = r10.getPrepend()
            androidx.paging.LoadState r6 = r9.getPrepend()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r6)
            r10 = r10 ^ r5
            if (r10 == 0) goto L_0x00cd
            androidx.paging.PageFetcher$injectRemoteEvents$1$2 r10 = r2.f36696b
            androidx.paging.MutableLoadStateCollection r10 = r1
            androidx.paging.LoadType r6 = androidx.paging.LoadType.PREPEND
            androidx.paging.LoadState r7 = r9.getPrepend()
            r10.set(r6, r5, r7)
            androidx.paging.PageFetcher$injectRemoteEvents$1$2 r10 = r2.f36696b
            androidx.paging.PageFetcher$injectRemoteEvents$1$1 r10 = r3
            androidx.paging.LoadState r7 = r9.getPrepend()
            r0.f36701k = r2
            r0.f36702l = r9
            r0.f36699i = r4
            java.lang.Object r10 = r10.invoke((androidx.paging.LoadType) r6, (androidx.paging.LoadState) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r10 != r1) goto L_0x00cd
            return r1
        L_0x00cd:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r2.f36697c
            T r10 = r10.element
            androidx.paging.LoadStates r10 = (androidx.paging.LoadStates) r10
            androidx.paging.LoadState r10 = r10.getAppend()
            androidx.paging.LoadState r4 = r9.getAppend()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r4)
            r10 = r10 ^ r5
            if (r10 == 0) goto L_0x0106
            androidx.paging.PageFetcher$injectRemoteEvents$1$2 r10 = r2.f36696b
            androidx.paging.MutableLoadStateCollection r10 = r1
            androidx.paging.LoadType r4 = androidx.paging.LoadType.APPEND
            androidx.paging.LoadState r6 = r9.getAppend()
            r10.set(r4, r5, r6)
            androidx.paging.PageFetcher$injectRemoteEvents$1$2 r10 = r2.f36696b
            androidx.paging.PageFetcher$injectRemoteEvents$1$1 r10 = r3
            androidx.paging.LoadState r5 = r9.getAppend()
            r0.f36701k = r2
            r0.f36702l = r9
            r0.f36699i = r3
            java.lang.Object r10 = r10.invoke((androidx.paging.LoadType) r4, (androidx.paging.LoadState) r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r10 != r1) goto L_0x0104
            return r1
        L_0x0104:
            r0 = r2
        L_0x0105:
            r2 = r0
        L_0x0106:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r2.f36697c
            r10.element = r9
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
