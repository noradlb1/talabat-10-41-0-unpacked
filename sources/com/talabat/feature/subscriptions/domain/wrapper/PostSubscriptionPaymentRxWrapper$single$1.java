package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentWithErrorHandlingUseCase;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.wrapper.PostSubscriptionPaymentRxWrapper$single$1", f = "PostSubscriptionPaymentRxWrapper.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
public final class PostSubscriptionPaymentRxWrapper$single$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SubscriptionPaymentStatus>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59003h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PostSubscriptionPaymentRxWrapper f59004i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetSubscriptionPaymentWithErrorHandlingUseCase.Params f59005j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostSubscriptionPaymentRxWrapper$single$1(PostSubscriptionPaymentRxWrapper postSubscriptionPaymentRxWrapper, GetSubscriptionPaymentWithErrorHandlingUseCase.Params params, Continuation<? super PostSubscriptionPaymentRxWrapper$single$1> continuation) {
        super(2, continuation);
        this.f59004i = postSubscriptionPaymentRxWrapper;
        this.f59005j = params;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostSubscriptionPaymentRxWrapper$single$1(this.f59004i, this.f59005j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SubscriptionPaymentStatus> continuation) {
        return ((PostSubscriptionPaymentRxWrapper$single$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59003h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetSubscriptionPaymentWithErrorHandlingUseCase access$getGetSubscriptionPaymentUseCase$p = this.f59004i.getSubscriptionPaymentUseCase;
            GetSubscriptionPaymentWithErrorHandlingUseCase.Params params = this.f59005j;
            this.f59003h = 1;
            obj = access$getGetSubscriptionPaymentUseCase$p.invoke(params, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
