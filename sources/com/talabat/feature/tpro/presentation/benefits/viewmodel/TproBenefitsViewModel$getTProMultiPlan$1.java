package com.talabat.feature.tpro.presentation.benefits.viewmodel;

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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel$getTProMultiPlan$1", f = "TproBenefitsViewModel.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class TproBenefitsViewModel$getTProMultiPlan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59270h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproBenefitsViewModel f59271i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59272j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f59273k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproBenefitsViewModel$getTProMultiPlan$1(TproBenefitsViewModel tproBenefitsViewModel, String str, String str2, Continuation<? super TproBenefitsViewModel$getTProMultiPlan$1> continuation) {
        super(2, continuation);
        this.f59271i = tproBenefitsViewModel;
        this.f59272j = str;
        this.f59273k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproBenefitsViewModel$getTProMultiPlan$1 tproBenefitsViewModel$getTProMultiPlan$1 = new TproBenefitsViewModel$getTProMultiPlan$1(this.f59271i, this.f59272j, this.f59273k, continuation);
        tproBenefitsViewModel$getTProMultiPlan$1.L$0 = obj;
        return tproBenefitsViewModel$getTProMultiPlan$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproBenefitsViewModel$getTProMultiPlan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59270h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproBenefitsViewModel tproBenefitsViewModel = this.f59271i;
            String str = this.f59272j;
            String str2 = this.f59273k;
            Result.Companion companion = Result.Companion;
            GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase = tproBenefitsViewModel.multiPlanParams.getGetSubscriptionMultiPlanUseCase();
            GetSubscriptionMultiPlanUseCase.Params params = new GetSubscriptionMultiPlanUseCase.Params(tproBenefitsViewModel.countryId, str, (Boolean) null, str2, "onboarding", 4, (DefaultConstructorMarker) null);
            this.f59270h = 1;
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
        TproBenefitsViewModel tproBenefitsViewModel2 = this.f59271i;
        if (Result.m6336isSuccessimpl(obj2)) {
            SubscriptionMultiPlan subscriptionMultiPlan = (SubscriptionMultiPlan) obj2;
            String str3 = "";
            int i12 = 0;
            for (Object next : subscriptionMultiPlan.getPlans()) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                str3 = str3 + ((SubscriptionPlan) next).getPlanId();
                if (i12 < subscriptionMultiPlan.getPlans().size() - 1) {
                    str3 = str3 + ",";
                }
                i12 = i13;
            }
            tproBenefitsViewModel2.subscriptionsTracker.tProPlanLoaded(TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_TYPE, TproBenefitsViewModel.TPRO_BENEFITS_SCREEN_NAME, str3);
            tproBenefitsViewModel2.getTProMultiPlan().postValue(tproBenefitsViewModel2.multiPlanParams.getMultiPlanMapper().apply(subscriptionMultiPlan));
        }
        TproBenefitsViewModel tproBenefitsViewModel3 = this.f59271i;
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj2);
        if (r13 != null) {
            if (r13 instanceof SubscriptionsErrorMessage) {
                tproBenefitsViewModel3.getDisplayError().postValue(new SubscriptionsErrorDisplayModel((SubscriptionsErrorMessage) r13, true));
            } else {
                tproBenefitsViewModel3.getFailure().postValue(r13);
            }
        }
        return Unit.INSTANCE;
    }
}
