package com.talabat.feature.tpro.presentation.checkout;

import com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionMultiPlanUseCase;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1", f = "SubscriptionAtCheckoutBannerViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59285h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SubscriptionAtCheckoutBannerViewModel f59286i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1(SubscriptionAtCheckoutBannerViewModel subscriptionAtCheckoutBannerViewModel, Continuation<? super SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1> continuation) {
        super(2, continuation);
        this.f59286i = subscriptionAtCheckoutBannerViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1 subscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1 = new SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1(this.f59286i, continuation);
        subscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1.L$0 = obj;
        return subscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SubscriptionAtCheckoutBannerViewModel$getSubscriptionMultiPlan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59285h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SubscriptionAtCheckoutBannerViewModel subscriptionAtCheckoutBannerViewModel = this.f59286i;
            Result.Companion companion = Result.Companion;
            GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase = subscriptionAtCheckoutBannerViewModel.multiPlanParams.getGetSubscriptionMultiPlanUseCase();
            GetSubscriptionMultiPlanUseCase.Params params = new GetSubscriptionMultiPlanUseCase.Params(subscriptionAtCheckoutBannerViewModel.configurationLocalRepository.selectedCountry().getPhoneCodeISO3166(), subscriptionAtCheckoutBannerViewModel.multiPlanParams.getMultiPlanDurations(), (Boolean) null, (String) null, "subscription-checkout", 12, (DefaultConstructorMarker) null);
            this.f59285h = 1;
            obj = getSubscriptionMultiPlanUseCase.invoke(params, this);
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
        obj2 = Result.m6329constructorimpl((SubscriptionMultiPlan) obj);
        SubscriptionAtCheckoutBannerViewModel subscriptionAtCheckoutBannerViewModel2 = this.f59286i;
        if (Result.m6336isSuccessimpl(obj2)) {
            SubscriptionMultiPlan subscriptionMultiPlan = (SubscriptionMultiPlan) obj2;
            String str = "";
            int i12 = 0;
            for (Object next : subscriptionMultiPlan.getPlans()) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                str = str + ((SubscriptionPlan) next).getPlanId();
                if (i12 < subscriptionMultiPlan.getPlans().size() - 1) {
                    str = str + ",";
                }
                i12 = i13;
            }
            subscriptionAtCheckoutBannerViewModel2.subscriptionsTracker.tProPlanLoaded("checkout", SubscriptionAtCheckoutBannerViewModel.TPRO_CHECKOUT_SCREEN_NAME, str);
            subscriptionAtCheckoutBannerViewModel2.getSubscriptionMultiPlan().postValue(subscriptionMultiPlan);
        }
        SubscriptionAtCheckoutBannerViewModel subscriptionAtCheckoutBannerViewModel3 = this.f59286i;
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj2);
        if (r13 != null) {
            if (r13 instanceof SubscriptionsErrorMessage) {
                subscriptionAtCheckoutBannerViewModel3.getDisplayError().postValue(new SubscriptionsErrorDisplayModel((SubscriptionsErrorMessage) r13, true));
            } else {
                r13.printStackTrace();
            }
        }
        return Unit.INSTANCE;
    }
}
