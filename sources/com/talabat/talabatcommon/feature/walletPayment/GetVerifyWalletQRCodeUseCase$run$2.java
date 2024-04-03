package com.talabat.talabatcommon.feature.walletPayment;

import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResponse;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletVerifyQRCodeDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletVerifyQRCodeDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVerifyWalletQRCodeUseCase$run$2 extends Lambda implements Function1<WalletVerifyQRCodeResponse, WalletVerifyQRCodeDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetVerifyWalletQRCodeUseCase f61727g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetVerifyWalletQRCodeUseCase$run$2(GetVerifyWalletQRCodeUseCase getVerifyWalletQRCodeUseCase) {
        super(1);
        this.f61727g = getVerifyWalletQRCodeUseCase;
    }

    @NotNull
    public final WalletVerifyQRCodeDisplayModel invoke(@NotNull WalletVerifyQRCodeResponse walletVerifyQRCodeResponse) {
        Intrinsics.checkNotNullParameter(walletVerifyQRCodeResponse, "it");
        return (WalletVerifyQRCodeDisplayModel) this.f61727g.mapper.invoke(walletVerifyQRCodeResponse);
    }
}
