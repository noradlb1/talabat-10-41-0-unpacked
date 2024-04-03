package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 implements Flow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f25621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function3 f25622c;

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.f25621b = flow;
        this.f25622c = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f25624i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25624i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25623h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25624i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006f
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f25627l
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r2 = r0.f25626k
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.flow.Flow r7 = r5.f25621b
            r0.f25626k = r5
            r0.f25627l = r6
            r0.f25624i = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.catchImpl(r7, r6, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r2 = r5
        L_0x0053:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 == 0) goto L_0x006f
            kotlin.jvm.functions.Function3 r2 = r2.f25622c
            r4 = 0
            r0.f25626k = r4
            r0.f25627l = r4
            r0.f25624i = r3
            r3 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r3)
            java.lang.Object r6 = r2.invoke(r6, r7, r0)
            r7 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r7)
            if (r6 != r1) goto L_0x006f
            return r1
        L_0x006f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
