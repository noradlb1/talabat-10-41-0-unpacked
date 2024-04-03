package com.talabat.feature.tpro.presentation.payment.viewmodel;

import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionMultiPlanUseCase;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1", f = "TProPaymentBottomSheetViewModel.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
public final class TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59372h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TProPaymentBottomSheetViewModel f59373i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1(TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel, Continuation<? super TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1> continuation) {
        super(2, continuation);
        this.f59373i = tProPaymentBottomSheetViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1 tProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1 = new TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1(this.f59373i, continuation);
        tProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1.L$0 = obj;
        return tProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TProPaymentBottomSheetViewModel$getSubscriptionMultiPlan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59372h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel = this.f59373i;
            Result.Companion companion = Result.Companion;
            GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase = tProPaymentBottomSheetViewModel.multiPlanParams.getGetSubscriptionMultiPlanUseCase();
            GetSubscriptionMultiPlanUseCase.Params params = new GetSubscriptionMultiPlanUseCase.Params(tProPaymentBottomSheetViewModel.configurationLocalRepository.selectedCountry().getPhoneCodeISO3166(), tProPaymentBottomSheetViewModel.multiPlanParams.getMultiPlanDurations(), (Boolean) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            this.f59372h = 1;
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
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel2 = this.f59373i;
        if (Result.m6336isSuccessimpl(obj2)) {
            TProPlanDisplayModel tProPlanDisplayModel = (TProPlanDisplayModel) CollectionsKt___CollectionsKt.firstOrNull(tProPaymentBottomSheetViewModel2.multiPlanParams.getMultiPlanMapper().apply((SubscriptionMultiPlan) obj2).getPlans());
            if (tProPlanDisplayModel != null) {
                tProPaymentBottomSheetViewModel2.getSubscriptionMultiPlan$com_talabat_feature_tpro_presentation_presentation().postValue(tProPlanDisplayModel);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                tProPaymentBottomSheetViewModel2.getSubscriptionMultiPlanFailure$com_talabat_feature_tpro_presentation_presentation().postValue(Unit.INSTANCE);
            }
        }
        TProPaymentBottomSheetViewModel tProPaymentBottomSheetViewModel3 = this.f59373i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            tProPaymentBottomSheetViewModel3.getSubscriptionMultiPlanFailure$com_talabat_feature_tpro_presentation_presentation().postValue(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
