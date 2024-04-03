package com.deliveryhero.chatui.domain.call.usecase;

import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.contract.model.PhoneCallType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"", "number", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase$mapTokuStatus$1", f = "CallStatusUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CallStatusUseCase$mapTokuStatus$1 extends SuspendLambda implements Function2<String, Continuation<? super CallStatus>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29420h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f29421i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PhoneCallType.Toku f29422j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallStatusUseCase$mapTokuStatus$1(PhoneCallType.Toku toku, Continuation<? super CallStatusUseCase$mapTokuStatus$1> continuation) {
        super(2, continuation);
        this.f29422j = toku;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CallStatusUseCase$mapTokuStatus$1 callStatusUseCase$mapTokuStatus$1 = new CallStatusUseCase$mapTokuStatus$1(this.f29422j, continuation);
        callStatusUseCase$mapTokuStatus$1.f29421i = obj;
        return callStatusUseCase$mapTokuStatus$1;
    }

    @Nullable
    public final Object invoke(@Nullable String str, @Nullable Continuation<? super CallStatus> continuation) {
        return ((CallStatusUseCase$mapTokuStatus$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f29420h == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.f29421i;
            if (!StringsKt__StringsJVMKt.isBlank(this.f29422j.getLicenseKey())) {
                if (str == null || str.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    return new CallStatus.VoipActive(str, CallStatus.VoipActive.TOKU_PROVIDER);
                }
            }
            return CallStatus.Pending.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
