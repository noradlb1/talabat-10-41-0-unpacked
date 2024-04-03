package com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel;

import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModel$loadReasons$1", f = "SubscriptionCancellationReasonsViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class SubscriptionCancellationReasonsViewModel$loadReasons$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59298h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonsViewModel f59299i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationReasonsViewModel$loadReasons$1(SubscriptionCancellationReasonsViewModel subscriptionCancellationReasonsViewModel, Continuation<? super SubscriptionCancellationReasonsViewModel$loadReasons$1> continuation) {
        super(2, continuation);
        this.f59299i = subscriptionCancellationReasonsViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SubscriptionCancellationReasonsViewModel$loadReasons$1 subscriptionCancellationReasonsViewModel$loadReasons$1 = new SubscriptionCancellationReasonsViewModel$loadReasons$1(this.f59299i, continuation);
        subscriptionCancellationReasonsViewModel$loadReasons$1.L$0 = obj;
        return subscriptionCancellationReasonsViewModel$loadReasons$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SubscriptionCancellationReasonsViewModel$loadReasons$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59298h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SubscriptionCancellationReasonsViewModel subscriptionCancellationReasonsViewModel = this.f59299i;
            Result.Companion companion = Result.Companion;
            GetSubscriptionCancellationReasonsUseCase access$getGetSubscriptionCancellationReasonsUseCase$p = subscriptionCancellationReasonsViewModel.getSubscriptionCancellationReasonsUseCase;
            this.f59298h = 1;
            obj = access$getGetSubscriptionCancellationReasonsUseCase$p.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((List) obj);
        SubscriptionCancellationReasonsViewModel subscriptionCancellationReasonsViewModel2 = this.f59299i;
        if (Result.m6336isSuccessimpl(obj2)) {
            subscriptionCancellationReasonsViewModel2._reasonsData.setValue((List) obj2);
        }
        return Unit.INSTANCE;
    }
}
