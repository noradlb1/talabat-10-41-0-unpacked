package com.talabat.feature.tpro.presentation.payment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Customer;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import datamodels.CustomerInfo;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel$updateCustomerInfo$1", f = "TProPaymentBottomSheetViewModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class TProPaymentBottomSheetViewModel$updateCustomerInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59390h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetViewModel f59391i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetViewModel$updateCustomerInfo$1(TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel, Continuation<? super TProPaymentBottomSheetViewModel$updateCustomerInfo$1> continuation) {
        super(2, continuation);
        this.f59391i = tProPaymentBottomSheetViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TProPaymentBottomSheetViewModel$updateCustomerInfo$1 tProPaymentBottomSheetViewModel$updateCustomerInfo$1 = new TProPaymentBottomSheetViewModel$updateCustomerInfo$1(this.f59391i, continuation);
        tProPaymentBottomSheetViewModel$updateCustomerInfo$1.L$0 = obj;
        return tProPaymentBottomSheetViewModel$updateCustomerInfo$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProPaymentBottomSheetViewModel$updateCustomerInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        float f11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59390h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel = this.f59391i;
            Result.Companion companion = Result.Companion;
            GetActiveSubscriptionsUseCase access$getGetActiveSubscriptionsUseCase$p = tProPaymentBottomSheetViewModel.getActiveSubscriptionsUseCase;
            GetActiveSubscriptionsUseCase.Params params = new GetActiveSubscriptionsUseCase.Params(tProPaymentBottomSheetViewModel.configurationLocalRepository.selectedCountry());
            this.f59390h = 1;
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
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel2 = this.f59391i;
        Customer.getInstance().tProSubscriptionInfo = subscription;
        tProPaymentBottomSheetViewModel2.subscriptionStatusRepository.setTProSubscriptionInfo(subscription);
        if (subscription != null) {
            f11 = subscription.getMinDeliveryFee();
        } else {
            f11 = 0.0f;
        }
        customerInfo.minimOrderValueToEnableTproDiscount = f11;
        MutableLiveData<Unit> successSubscription$com_talabat_feature_tpro_presentation_presentation = this.f59391i.getSuccessSubscription$com_talabat_feature_tpro_presentation_presentation();
        Unit unit = Unit.INSTANCE;
        successSubscription$com_talabat_feature_tpro_presentation_presentation.postValue(unit);
        return unit;
    }
}
