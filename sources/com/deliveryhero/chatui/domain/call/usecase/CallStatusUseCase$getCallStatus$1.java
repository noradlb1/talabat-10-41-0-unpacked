package com.deliveryhero.chatui.domain.call.usecase;

import com.deliveryhero.chatui.domain.call.CallStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getCallStatus$1", f = "CallStatusUseCase.kt", i = {0}, l = {31, 32, 33, 34, 35}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
public final class CallStatusUseCase$getCallStatus$1 extends SuspendLambda implements Function2<FlowCollector<? super CallStatus>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f29415h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CallStatusUseCase f29416i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallStatusUseCase$getCallStatus$1(CallStatusUseCase callStatusUseCase, Continuation<? super CallStatusUseCase$getCallStatus$1> continuation) {
        super(2, continuation);
        this.f29416i = callStatusUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CallStatusUseCase$getCallStatus$1 callStatusUseCase$getCallStatus$1 = new CallStatusUseCase$getCallStatus$1(this.f29416i, continuation);
        callStatusUseCase$getCallStatus$1.L$0 = obj;
        return callStatusUseCase$getCallStatus$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super CallStatus> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((CallStatusUseCase$getCallStatus$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f29415h
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r6) goto L_0x0025
            if (r1 == r5) goto L_0x0020
            if (r1 == r4) goto L_0x0020
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009b
        L_0x0025:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0046
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase r9 = r8.f29416i
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r9 = r9.featureFlagProvider
            r8.L$0 = r1
            r8.f29415h = r6
            java.lang.Object r9 = r9.getPhoneCallingType(r8)
            if (r9 != r0) goto L_0x0046
            return r0
        L_0x0046:
            com.deliveryhero.contract.model.PhoneCallType r9 = (com.deliveryhero.contract.model.PhoneCallType) r9
            boolean r6 = r9 instanceof com.deliveryhero.contract.model.PhoneCallType.Normal
            r7 = 0
            if (r6 == 0) goto L_0x005e
            com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase r9 = r8.f29416i
            com.deliveryhero.chatui.domain.call.CallStatus r9 = r9.mapNormalStatus()
            r8.L$0 = r7
            r8.f29415h = r5
            java.lang.Object r9 = r1.emit(r9, r8)
            if (r9 != r0) goto L_0x009b
            return r0
        L_0x005e:
            boolean r5 = r9 instanceof com.deliveryhero.contract.model.PhoneCallType.Masked
            if (r5 == 0) goto L_0x0073
            com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase r9 = r8.f29416i
            kotlinx.coroutines.flow.Flow r9 = r9.mapMaskedToStatus()
            r8.L$0 = r7
            r8.f29415h = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r9, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r8)
            if (r9 != r0) goto L_0x009b
            return r0
        L_0x0073:
            boolean r4 = r9 instanceof com.deliveryhero.contract.model.PhoneCallType.Toku
            if (r4 == 0) goto L_0x008a
            com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase r2 = r8.f29416i
            com.deliveryhero.contract.model.PhoneCallType$Toku r9 = (com.deliveryhero.contract.model.PhoneCallType.Toku) r9
            kotlinx.coroutines.flow.Flow r9 = r2.mapTokuStatus(r9)
            r8.L$0 = r7
            r8.f29415h = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r9, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r8)
            if (r9 != r0) goto L_0x009b
            return r0
        L_0x008a:
            boolean r9 = r9 instanceof com.deliveryhero.contract.model.PhoneCallType.None
            if (r9 == 0) goto L_0x009b
            com.deliveryhero.chatui.domain.call.CallStatus$Hidden r9 = com.deliveryhero.chatui.domain.call.CallStatus.Hidden.INSTANCE
            r8.L$0 = r7
            r8.f29415h = r2
            java.lang.Object r9 = r1.emit(r9, r8)
            if (r9 != r0) goto L_0x009b
            return r0
        L_0x009b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getCallStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
