package com.deliveryhero.chatui.domain.call.usecase;

import com.deliveryhero.chatui.domain.call.CallStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$getConfigStatus$2", f = "CallStatusUseCase.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class CallStatusUseCase$getConfigStatus$2 extends SuspendLambda implements Function3<FlowCollector<? super CallStatus>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f29417h;

    public CallStatusUseCase$getConfigStatus$2(Continuation<? super CallStatusUseCase$getConfigStatus$2> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super CallStatus> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        CallStatusUseCase$getConfigStatus$2 callStatusUseCase$getConfigStatus$2 = new CallStatusUseCase$getConfigStatus$2(continuation);
        callStatusUseCase$getConfigStatus$2.L$0 = flowCollector;
        return callStatusUseCase$getConfigStatus$2.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29417h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CallStatus.Pending pending = CallStatus.Pending.INSTANCE;
            this.f29417h = 1;
            if (((FlowCollector) this.L$0).emit(pending, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
