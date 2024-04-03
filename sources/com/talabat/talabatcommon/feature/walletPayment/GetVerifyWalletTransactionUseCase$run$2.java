package com.talabat.talabatcommon.feature.walletPayment;

import com.talabat.talabatcommon.feature.walletPayment.model.response.VerifyWalletTransactionResponse;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.VerifyWalletTransactionDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/VerifyWalletTransactionDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/VerifyWalletTransactionResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVerifyWalletTransactionUseCase$run$2 extends Lambda implements Function1<VerifyWalletTransactionResponse, VerifyWalletTransactionDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetVerifyWalletTransactionUseCase f61728g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetVerifyWalletTransactionUseCase$run$2(GetVerifyWalletTransactionUseCase getVerifyWalletTransactionUseCase) {
        super(1);
        this.f61728g = getVerifyWalletTransactionUseCase;
    }

    @NotNull
    public final VerifyWalletTransactionDisplayModel invoke(@NotNull VerifyWalletTransactionResponse verifyWalletTransactionResponse) {
        Intrinsics.checkNotNullParameter(verifyWalletTransactionResponse, "it");
        return (VerifyWalletTransactionDisplayModel) this.f61728g.mapper.invoke(verifyWalletTransactionResponse);
    }
}
