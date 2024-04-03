package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import buisnessmodels.Customer;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import datamodels.CustomerInfo;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel$updateCustomerInfo$1", f = "TproBenefitsViewModel.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
public final class TproBenefitsViewModel$updateCustomerInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59278h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f59279i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsViewModel$updateCustomerInfo$1(TproBenefitsViewModel tproBenefitsViewModel, Continuation<? super TproBenefitsViewModel$updateCustomerInfo$1> continuation) {
        super(2, continuation);
        this.f59279i = tproBenefitsViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproBenefitsViewModel$updateCustomerInfo$1 tproBenefitsViewModel$updateCustomerInfo$1 = new TproBenefitsViewModel$updateCustomerInfo$1(this.f59279i, continuation);
        tproBenefitsViewModel$updateCustomerInfo$1.L$0 = obj;
        return tproBenefitsViewModel$updateCustomerInfo$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproBenefitsViewModel$updateCustomerInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        float f11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59278h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproBenefitsViewModel tproBenefitsViewModel = this.f59279i;
            Result.Companion companion = Result.Companion;
            GetActiveSubscriptionsUseCase access$getGetActiveSubscriptionsUseCase$p = tproBenefitsViewModel.getActiveSubscriptionsUseCase;
            GetActiveSubscriptionsUseCase.Params params = new GetActiveSubscriptionsUseCase.Params(tproBenefitsViewModel.configurationLocalRepository.selectedCountry());
            this.f59278h = 1;
            obj = access$getGetActiveSubscriptionsUseCase$p.invoke(params, this);
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
        obj2 = Result.m6329constructorimpl((Subscription) obj);
        if (Result.m6335isFailureimpl(obj2)) {
            obj2 = null;
        }
        Subscription subscription = (Subscription) obj2;
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        this.f59279i.subscriptionStatusRepository.setTProSubscriptionInfo(subscription);
        if (subscription != null) {
            f11 = subscription.getMinDeliveryFee();
        } else {
            f11 = 0.0f;
        }
        customerInfo.minimOrderValueToEnableTproDiscount = f11;
        this.f59279i.isSubscribedWithB2BVoucher().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
