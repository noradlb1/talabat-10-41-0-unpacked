package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
public final class FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlowExtKt$simpleRunningReduce$1 f36569b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlowCollector f36570c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f36571d;

    public FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1(FlowExtKt$simpleRunningReduce$1 flowExtKt$simpleRunningReduce$1, FlowCollector flowCollector, Ref.ObjectRef objectRef) {
        this.f36569b = flowExtKt$simpleRunningReduce$1;
        this.f36570c = flowCollector;
        this.f36571d = objectRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1$1 r0 = (androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.f36573i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36573i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1$1 r0 = new androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f36572h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f36573i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0085
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.f36576l
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.f36575k
            androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 r2 = (androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x006f
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = r7.f36571d
            T r2 = r9.element
            java.lang.Object r5 = androidx.paging.FlowExtKt.NULL
            if (r2 != r5) goto L_0x0052
        L_0x0050:
            r2 = r7
            goto L_0x006f
        L_0x0052:
            androidx.paging.FlowExtKt$simpleRunningReduce$1 r2 = r7.f36569b
            kotlin.jvm.functions.Function3 r2 = r2.f36591j
            kotlin.jvm.internal.Ref$ObjectRef r5 = r7.f36571d
            T r5 = r5.element
            r0.f36575k = r7
            r0.f36576l = r9
            r0.f36573i = r4
            r4 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r4)
            java.lang.Object r8 = r2.invoke(r5, r8, r0)
            r2 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r2)
            if (r8 != r1) goto L_0x0050
            return r1
        L_0x006f:
            r9.element = r8
            kotlinx.coroutines.flow.FlowCollector r8 = r2.f36570c
            kotlin.jvm.internal.Ref$ObjectRef r9 = r2.f36571d
            T r9 = r9.element
            r2 = 0
            r0.f36575k = r2
            r0.f36576l = r2
            r0.f36573i = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L_0x0085
            return r1
        L_0x0085:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
