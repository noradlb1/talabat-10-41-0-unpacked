package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel$subscribeWithB2BVoucher$1$1", f = "TproBenefitsViewModel.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
public final class TproBenefitsViewModel$subscribeWithB2BVoucher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59274h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f59275i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TProPlanDisplayModel f59276j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59277k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsViewModel$subscribeWithB2BVoucher$1$1(TproBenefitsViewModel tproBenefitsViewModel, TProPlanDisplayModel tProPlanDisplayModel, String str, Continuation<? super TproBenefitsViewModel$subscribeWithB2BVoucher$1$1> continuation) {
        super(2, continuation);
        this.f59275i = tproBenefitsViewModel;
        this.f59276j = tProPlanDisplayModel;
        this.f59277k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproBenefitsViewModel$subscribeWithB2BVoucher$1$1 tproBenefitsViewModel$subscribeWithB2BVoucher$1$1 = new TproBenefitsViewModel$subscribeWithB2BVoucher$1$1(this.f59275i, this.f59276j, this.f59277k, continuation);
        tproBenefitsViewModel$subscribeWithB2BVoucher$1$1.L$0 = obj;
        return tproBenefitsViewModel$subscribeWithB2BVoucher$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproBenefitsViewModel$subscribeWithB2BVoucher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59274h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproBenefitsViewModel tproBenefitsViewModel = this.f59275i;
            TProPlanDisplayModel tProPlanDisplayModel = this.f59276j;
            String str = this.f59277k;
            Result.Companion companion = Result.Companion;
            GetSubscriptionWithB2BVoucherUseCase access$getSubscriptionWithB2BVoucherUseCase$p = tproBenefitsViewModel.subscriptionWithB2BVoucherUseCase;
            GetSubscriptionWithB2BVoucherUseCase.Params params = new GetSubscriptionWithB2BVoucherUseCase.Params(tProPlanDisplayModel.getPlanId(), str, "");
            this.f59274h = 1;
            obj = access$getSubscriptionWithB2BVoucherUseCase$p.invoke(params, this);
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
        obj2 = Result.m6329constructorimpl((String) obj);
        TproBenefitsViewModel tproBenefitsViewModel2 = this.f59275i;
        TProPlanDisplayModel tProPlanDisplayModel2 = this.f59276j;
        if (Result.m6336isSuccessimpl(obj2)) {
            tproBenefitsViewModel2.getSendFirebaseEvent().postValue(TProEvent.NAME_SUBSCRIPTION_COMPLETED);
            if (Intrinsics.areEqual((Object) (String) obj2, (Object) tProPlanDisplayModel2.getPlanId())) {
                Job unused = tproBenefitsViewModel2.updateCustomerInfo();
            }
        }
        TproBenefitsViewModel tproBenefitsViewModel3 = this.f59275i;
        Throwable r72 = Result.m6332exceptionOrNullimpl(obj2);
        if (r72 != null) {
            tproBenefitsViewModel3.getSendFirebaseEvent().postValue(TProEvent.NAME_SUBSCRIPTION_FAILED);
            if (r72 instanceof SubscriptionsErrorMessage) {
                tproBenefitsViewModel3.getDisplayError().postValue(new SubscriptionsErrorDisplayModel((SubscriptionsErrorMessage) r72, true));
            } else {
                tproBenefitsViewModel3.getFailure().postValue(r72);
            }
        }
        return Unit.INSTANCE;
    }
}
