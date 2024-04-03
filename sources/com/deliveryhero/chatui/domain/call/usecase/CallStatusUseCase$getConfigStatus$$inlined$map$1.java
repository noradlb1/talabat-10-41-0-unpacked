package com.deliveryhero.chatui.domain.call.usecase;

import com.deliveryhero.chatui.domain.call.CallStatus;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallStatusUseCase$getConfigStatus$$inlined$map$1 implements Flow<CallStatus> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f29403b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f29404c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CallStatusUseCase f29405d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Pair f29406e;

    public CallStatusUseCase$getConfigStatus$$inlined$map$1(Flow flow, Function2 function2, CallStatusUseCase callStatusUseCase, Pair pair) {
        this.f29403b = flow;
        this.f29404c = function2;
        this.f29405d = callStatusUseCase;
        this.f29406e = pair;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.f29403b;
        final Function2 function2 = this.f29404c;
        final CallStatusUseCase callStatusUseCase = this.f29405d;
        final Pair pair = this.f29406e;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0080 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r11
                    com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$$inlined$map$1$2$1 r0 = (com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f29412i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f29412i = r1
                    goto L_0x0018
                L_0x0013:
                    com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$$inlined$map$1$2$1 r0 = new com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$$inlined$map$1$2$1
                    r0.<init>(r9, r11)
                L_0x0018:
                    java.lang.Object r11 = r0.f29411h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f29412i
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L_0x0081
                L_0x002c:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L_0x0034:
                    java.lang.Object r10 = r0.f29413j
                    kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L_0x0075
                L_0x003c:
                    kotlin.ResultKt.throwOnFailure(r11)
                    kotlinx.coroutines.flow.FlowCollector r11 = r6
                    com.deliveryhero.contract.model.ConfigMessage r10 = (com.deliveryhero.contract.model.ConfigMessage) r10
                    kotlin.jvm.functions.Function2 r2 = r2
                    com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase r5 = r3
                    java.util.List r10 = r10.getConfigs()
                    kotlin.Pair r6 = r4
                    java.lang.Object r6 = r6.getFirst()
                    java.lang.String r6 = (java.lang.String) r6
                    kotlin.Pair r7 = r4
                    java.lang.Object r7 = r7.getSecond()
                    java.lang.String r7 = (java.lang.String) r7
                    java.lang.String r10 = r5.getNumber(r10, r6, r7)
                    r0.f29413j = r11
                    r0.f29412i = r4
                    r4 = 6
                    kotlin.jvm.internal.InlineMarker.mark((int) r4)
                    java.lang.Object r10 = r2.invoke(r10, r0)
                    r2 = 7
                    kotlin.jvm.internal.InlineMarker.mark((int) r2)
                    if (r10 != r1) goto L_0x0072
                    return r1
                L_0x0072:
                    r8 = r11
                    r11 = r10
                    r10 = r8
                L_0x0075:
                    r2 = 0
                    r0.f29413j = r2
                    r0.f29412i = r3
                    java.lang.Object r10 = r10.emit(r11, r0)
                    if (r10 != r1) goto L_0x0081
                    return r1
                L_0x0081:
                    kotlin.Unit r10 = kotlin.Unit.INSTANCE
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
