package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f25628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function4 f25629c;

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.f25628b = flow;
        this.f25629c = function4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f25631i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25631i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f25630h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25631i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            long r5 = r0.f25636n
            java.lang.Object r12 = r0.f25635m
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object r2 = r0.f25634l
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r7 = r0.f25633k
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r7 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x009a
        L_0x003a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0042:
            int r12 = r0.f25637o
            long r5 = r0.f25636n
            java.lang.Object r2 = r0.f25634l
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r7 = r0.f25633k
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r7 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0074
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r13)
            r5 = 0
            r13 = r11
        L_0x0058:
            kotlinx.coroutines.flow.Flow r2 = r13.f25628b
            r0.f25633k = r13
            r0.f25634l = r12
            r7 = 0
            r0.f25635m = r7
            r0.f25636n = r5
            r7 = 0
            r0.f25637o = r7
            r0.f25631i = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.catchImpl(r2, r12, r0)
            if (r2 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r10 = r2
            r2 = r12
            r12 = r7
            r7 = r13
            r13 = r10
        L_0x0074:
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            if (r13 == 0) goto L_0x00a8
            kotlin.jvm.functions.Function4 r12 = r7.f25629c
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r0.f25633k = r7
            r0.f25634l = r2
            r0.f25635m = r13
            r0.f25636n = r5
            r0.f25631i = r3
            r9 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r9)
            java.lang.Object r12 = r12.invoke(r2, r13, r8, r0)
            r8 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r8)
            if (r12 != r1) goto L_0x0097
            return r1
        L_0x0097:
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x009a:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00a7
            r12 = 1
            long r5 = r5 + r12
            r12 = r4
            goto L_0x00a8
        L_0x00a7:
            throw r12
        L_0x00a8:
            r13 = r7
            if (r12 != 0) goto L_0x00ae
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00ae:
            r12 = r2
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
