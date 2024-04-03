package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper$single$1", f = "GetActiveSubscriptionsRxWrapper.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
public final class GetActiveSubscriptionsRxWrapper$single$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Subscription>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59000h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetActiveSubscriptionsRxWrapper f59001i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetActiveSubscriptionsUseCase.Params f59002j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetActiveSubscriptionsRxWrapper$single$1(GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper, GetActiveSubscriptionsUseCase.Params params, Continuation<? super GetActiveSubscriptionsRxWrapper$single$1> continuation) {
        super(2, continuation);
        this.f59001i = getActiveSubscriptionsRxWrapper;
        this.f59002j = params;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetActiveSubscriptionsRxWrapper$single$1(this.f59001i, this.f59002j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Subscription> continuation) {
        return ((GetActiveSubscriptionsRxWrapper$single$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59000h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetActiveSubscriptionsUseCase access$getGetActiveSubscriptionsUseCase$p = this.f59001i.getActiveSubscriptionsUseCase;
            GetActiveSubscriptionsUseCase.Params params = this.f59002j;
            this.f59000h = 1;
            obj = access$getGetActiveSubscriptionsUseCase$p.invoke(params, this);
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
