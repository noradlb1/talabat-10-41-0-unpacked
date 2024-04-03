package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import com.talabat.feature.subscriptions.domain.usecase.CancelFreeTrialUseCase;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1", f = "TproSubscriptionDetailsViewModel.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59334h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f59335i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59336j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, String str, Continuation<? super TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1> continuation) {
        super(2, continuation);
        this.f59335i = tproSubscriptionDetailsViewModel;
        this.f59336j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1 tproSubscriptionDetailsViewModel$cancelFreeTrial$1$1 = new TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1(this.f59335i, this.f59336j, continuation);
        tproSubscriptionDetailsViewModel$cancelFreeTrial$1$1.L$0 = obj;
        return tproSubscriptionDetailsViewModel$cancelFreeTrial$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproSubscriptionDetailsViewModel$cancelFreeTrial$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59334h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel = this.f59335i;
            String str = this.f59336j;
            Result.Companion companion = Result.Companion;
            CancelFreeTrialUseCase access$getCancelFreeTrialUseCase$p = tproSubscriptionDetailsViewModel.cancelFreeTrialUseCase;
            CancelFreeTrialUseCase.Params params = new CancelFreeTrialUseCase.Params(str);
            this.f59334h = 1;
            if (access$getCancelFreeTrialUseCase$p.invoke(params, this) == coroutine_suspended) {
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
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel2 = this.f59335i;
        if (Result.m6336isSuccessimpl(obj2)) {
            Unit unit = (Unit) obj2;
            tproSubscriptionDetailsViewModel2._cancelFreeTrial.setValue(Boxing.boxBoolean(true));
        }
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel3 = this.f59335i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tproSubscriptionDetailsViewModel3._cancelFreeTrial.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
