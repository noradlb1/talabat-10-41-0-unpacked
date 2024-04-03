package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.talabatcommon.extentions.BooleanKt;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipFeatureUseCase$invoke$2", f = "GetOrderConfirmationRiderTipFeatureUseCase.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class GetOrderConfirmationRiderTipFeatureUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61565h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetOrderConfirmationRiderTipFeatureUseCase f61566i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetOrderConfirmationRiderTipFeatureUseCase$invoke$2(GetOrderConfirmationRiderTipFeatureUseCase getOrderConfirmationRiderTipFeatureUseCase, Continuation<? super GetOrderConfirmationRiderTipFeatureUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61566i = getOrderConfirmationRiderTipFeatureUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetOrderConfirmationRiderTipFeatureUseCase$invoke$2(this.f61566i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((GetOrderConfirmationRiderTipFeatureUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61565h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FWFKey walletFeatureFwfKey = PayFeatureFlagConstants.INSTANCE.getWalletFeatureFwfKey(Boxing.boxInt(IntegrationGlobalDataModel.Companion.selectedCountryCode()), PayFeatureFlagConstants.WALLET_TIP_RIDER_ON_ORDER_CONFIRMATION_SCREEN);
            z11 = false;
            if (BooleanKt.orFalse((Boolean) this.f61566i.isCustomerLoggedInProvider.invoke())) {
                ITalabatFeatureFlag access$getFeatureFlagRepo$p = this.f61566i.featureFlagRepo;
                this.f61565h = 1;
                obj = access$getFeatureFlagRepo$p.getFeatureFlag(walletFeatureFwfKey, false, false, (Continuation<? super Boolean>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z11);
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z11 = ((Boolean) obj).booleanValue();
        return Boxing.boxBoolean(z11);
    }
}
