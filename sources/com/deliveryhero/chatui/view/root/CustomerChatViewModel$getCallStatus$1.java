package com.deliveryhero.chatui.view.root;

import com.deliveryhero.chatui.domain.call.CallStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"", "isChannelFrozen", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "callStatus", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.root.CustomerChatViewModel$getCallStatus$1", f = "CustomerChatViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerChatViewModel$getCallStatus$1 extends SuspendLambda implements Function3<Boolean, CallStatus, Continuation<? super CallStatus>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29702h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ boolean f29703i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f29704j;

    public CustomerChatViewModel$getCallStatus$1(Continuation<? super CustomerChatViewModel$getCallStatus$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (CallStatus) obj2, (Continuation<? super CallStatus>) (Continuation) obj3);
    }

    @Nullable
    public final Object invoke(boolean z11, @NotNull CallStatus callStatus, @Nullable Continuation<? super CallStatus> continuation) {
        CustomerChatViewModel$getCallStatus$1 customerChatViewModel$getCallStatus$1 = new CustomerChatViewModel$getCallStatus$1(continuation);
        customerChatViewModel$getCallStatus$1.f29703i = z11;
        customerChatViewModel$getCallStatus$1.f29704j = callStatus;
        return customerChatViewModel$getCallStatus$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f29702h == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z11 = this.f29703i;
            CallStatus callStatus = (CallStatus) this.f29704j;
            if (z11) {
                return CallStatus.Hidden.INSTANCE;
            }
            return callStatus;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
