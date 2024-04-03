package com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetCheckoutTimeOutVariationUseCase;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "checkoutPaymentManagerRepository", "Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCheckoutTimeOutVariationUseCase {
    @NotNull
    private final CheckoutPaymentManagerRepository checkoutPaymentManagerRepository;
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;

    public GetCheckoutTimeOutVariationUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull CheckoutPaymentManagerRepository checkoutPaymentManagerRepository2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(checkoutPaymentManagerRepository2, "checkoutPaymentManagerRepository");
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.checkoutPaymentManagerRepository = checkoutPaymentManagerRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase$invoke$1 r0 = (com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase$invoke$1) r0
            int r1 = r0.f12540k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12540k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase$invoke$1 r0 = new com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase$invoke$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f12538i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12540k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f12537h
            com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase r0 = (com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0049
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r5 = r4.featureFlagRepo
            com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants$PayFeatureFlagsWithoutCountry r2 = com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.WALLET_CHECKOUT_OUT_TIME_OUT_ENABLED
            r0.f12537h = r4
            r0.f12540k = r3
            r3 = 0
            java.lang.Object r5 = r5.getFeatureFlag((com.talabat.core.fwfprojectskeys.domain.FWFKey) r2, (boolean) r3, (boolean) r3, (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r0)
            if (r5 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r0 = r4
        L_0x0049:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0059
            com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository r5 = r0.checkoutPaymentManagerRepository
            r0 = 95
            r5.setCheckoutTimeOut(r0)
            goto L_0x0060
        L_0x0059:
            com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository r5 = r0.checkoutPaymentManagerRepository
            r0 = 60
            r5.setCheckoutTimeOut(r0)
        L_0x0060:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetCheckoutTimeOutVariationUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
