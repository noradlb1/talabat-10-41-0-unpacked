package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutKitWrapper;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/ICheckoutKit;", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "(Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;)V", "createCardToken", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutResponse;", "checkoutCard", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutCard;", "verticalId", "", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutCard;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutKitWrapper implements ICheckoutKit {
    @NotNull
    private final GenerateCardTokenUseCase generateCardTokenUseCase;

    @Inject
    public CheckoutKitWrapper(@NotNull GenerateCardTokenUseCase generateCardTokenUseCase2) {
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "generateCardTokenUseCase");
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createCardToken(@org.jetbrains.annotations.NotNull com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutCard r11, @org.jetbrains.annotations.Nullable java.lang.Integer r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper$createCardToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper$createCardToken$1 r0 = (com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper$createCardToken$1) r0
            int r1 = r0.f11961j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11961j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper$createCardToken$1 r0 = new com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper$createCardToken$1
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f11959h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f11961j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005b
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r13)
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase r13 = r10.generateCardTokenUseCase
            com.talabat.feature.tokenization.domain.entity.TokenizationCard r2 = new com.talabat.feature.tokenization.domain.entity.TokenizationCard
            java.lang.String r5 = r11.getNumber()
            java.lang.String r6 = r11.getName()
            java.lang.String r7 = r11.getExpiryMonth()
            java.lang.String r8 = r11.getExpiryYear()
            java.lang.String r9 = r11.getCvv()
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$UseCase r11 = com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase.UseCase.CHECKOUT
            r0.f11961j = r3
            java.lang.Object r13 = r13.invoke(r2, r11, r12, r0)
            if (r13 != r1) goto L_0x005b
            return r1
        L_0x005b:
            java.lang.String r13 = (java.lang.String) r13
            com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse r11 = new com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse
            r11.<init>(r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper.createCardToken(com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutCard, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
