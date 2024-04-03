package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import com.bumptech.glide.load.HttpException;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.exception.SubscriptionsErrorMessage;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerAndPlanModel;
import com.talabat.feature.subscriptions.domain.usecase.TProOnBoardingBannerAndPlansUseCase;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1", f = "TproBenefitsViewModel.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
public final class TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59266h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f59267i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59268j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59269k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1(TproBenefitsViewModel tproBenefitsViewModel, String str, String str2, Continuation<? super TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1> continuation) {
        super(2, continuation);
        this.f59267i = tproBenefitsViewModel;
        this.f59268j = str;
        this.f59269k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1 tproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1 = new TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1(this.f59267i, this.f59268j, this.f59269k, continuation);
        tproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1.L$0 = obj;
        return tproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproBenefitsViewModel$fetchOnBoardingBannerAndPlans$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Integer num;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59266h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproBenefitsViewModel tproBenefitsViewModel = this.f59267i;
            String str = this.f59268j;
            String str2 = this.f59269k;
            Result.Companion companion = Result.Companion;
            TProOnBoardingBannerAndPlansUseCase access$getTProOnBoardingBannerAndPlansUseCase$p = tproBenefitsViewModel.tProOnBoardingBannerAndPlansUseCase;
            int access$getCountryId$p = tproBenefitsViewModel.countryId;
            this.f59266h = 1;
            obj = TProOnBoardingBannerAndPlansUseCase.invoke$default(access$getTProOnBoardingBannerAndPlansUseCase$p, access$getCountryId$p, str, (Boolean) null, str2, "onboarding", this, 4, (Object) null);
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
        obj2 = Result.m6329constructorimpl((TProOnBoardingBannerAndPlanModel) obj);
        TproBenefitsViewModel tproBenefitsViewModel2 = this.f59267i;
        if (Result.m6336isSuccessimpl(obj2)) {
            TProOnBoardingBannerAndPlanModel tProOnBoardingBannerAndPlanModel = (TProOnBoardingBannerAndPlanModel) obj2;
            tproBenefitsViewModel2.getTProOnBoardingPlan().postValue(tproBenefitsViewModel2.multiPlanParams.getMultiPlanMapper().createTProOnBoardingModel(tproBenefitsViewModel2.multiPlanParams.getMultiPlanMapper().apply(tProOnBoardingBannerAndPlanModel.getSubscriptionMultiPlan()), tProOnBoardingBannerAndPlanModel));
            tproBenefitsViewModel2.logNewRelicSuccessEvent(tProOnBoardingBannerAndPlanModel);
            tproBenefitsViewModel2.logNewRelicEventIfDefaultCardIsReceived(tProOnBoardingBannerAndPlanModel.getCards());
        }
        TproBenefitsViewModel tproBenefitsViewModel3 = this.f59267i;
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj2);
        if (r13 != null) {
            if (r13 instanceof HttpException) {
                num = Boxing.boxInt(((HttpException) r13).getStatusCode());
            } else {
                num = null;
            }
            if (r13 instanceof SubscriptionsErrorMessage) {
                tproBenefitsViewModel3.getDisplayError().postValue(new SubscriptionsErrorDisplayModel((SubscriptionsErrorMessage) r13, true));
            } else {
                tproBenefitsViewModel3.getFailure().postValue(r13);
            }
            ISubscriptionsTracker access$getSubscriptionsTracker$p = tproBenefitsViewModel3.subscriptionsTracker;
            String message = r13.getMessage();
            if (message == null) {
                message = "Api Call failed";
            }
            access$getSubscriptionsTracker$p.tProOnboardingApiFailure(message, num);
        }
        return Unit.INSTANCE;
    }
}
