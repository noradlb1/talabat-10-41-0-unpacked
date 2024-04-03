package com.deliveryhero.chatui.view.chatroom;

import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.chatroom.ChatViewModel$fetchConfigIfPhoneCalling$1", f = "ChatViewModel.kt", i = {}, l = {951}, m = "invokeSuspend", n = {}, s = {})
public final class ChatViewModel$fetchConfigIfPhoneCalling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29498h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f29499i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatViewModel$fetchConfigIfPhoneCalling$1(ChatViewModel chatViewModel, Continuation<? super ChatViewModel$fetchConfigIfPhoneCalling$1> continuation) {
        super(2, continuation);
        this.f29499i = chatViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatViewModel$fetchConfigIfPhoneCalling$1(this.f29499i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatViewModel$fetchConfigIfPhoneCalling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29498h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagProvider access$getFeatureFlagProvider$p = this.f29499i.featureFlagProvider;
            this.f29498h = 1;
            obj = access$getFeatureFlagProvider$p.getPhoneCallingType(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!Intrinsics.areEqual(obj, (Object) PhoneCallType.None.INSTANCE)) {
            this.f29499i.f29493service.fetchConfig(this.f29499i.chatUtils.generateUUIDString());
        }
        return Unit.INSTANCE;
    }
}
