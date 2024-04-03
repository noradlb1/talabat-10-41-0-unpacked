package com.deliveryhero.customerchat;

import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.CustomerChatModule$fetchUserFeatures$1", f = "CustomerChatModule.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerChatModule$fetchUserFeatures$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29758h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29759i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$fetchUserFeatures$1(CustomerChatModule customerChatModule, Continuation<? super CustomerChatModule$fetchUserFeatures$1> continuation) {
        super(2, continuation);
        this.f29759i = customerChatModule;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerChatModule$fetchUserFeatures$1(this.f29759i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CustomerChatModule$fetchUserFeatures$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29758h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagProvider access$getFeatureFlagProvider = this.f29759i.getFeatureFlagProvider();
            this.f29758h = 1;
            if (access$getFeatureFlagProvider.determineUserFeatures(this) == coroutine_suspended) {
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
