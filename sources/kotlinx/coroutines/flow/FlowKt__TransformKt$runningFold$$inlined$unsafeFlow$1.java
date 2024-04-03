package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 implements Flow<R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f25908b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Flow f25909c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function3 f25910d;

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.f25908b = obj;
        this.f25909c = flow;
        this.f25910d = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super R> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f25912i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25912i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25911h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25912i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007b
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            java.lang.Object r7 = r0.f25916m
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r2 = r0.f25915l
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.f25914k
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0062
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.Object r2 = r6.f25908b
            r8.element = r2
            r0.f25914k = r6
            r0.f25915l = r7
            r0.f25916m = r8
            r0.f25912i = r4
            java.lang.Object r2 = r7.emit(r2, r0)
            if (r2 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r4 = r6
            r2 = r7
            r7 = r8
        L_0x0062:
            kotlinx.coroutines.flow.Flow r8 = r4.f25909c
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1 r5 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1
            kotlin.jvm.functions.Function3 r4 = r4.f25910d
            r5.<init>(r7, r4, r2)
            r7 = 0
            r0.f25914k = r7
            r0.f25915l = r7
            r0.f25916m = r7
            r0.f25912i = r3
            java.lang.Object r7 = r8.collect(r5, r0)
            if (r7 != r1) goto L_0x007b
            return r1
        L_0x007b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
