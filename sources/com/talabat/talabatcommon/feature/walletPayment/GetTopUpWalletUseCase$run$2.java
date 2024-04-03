package com.talabat.talabatcommon.feature.walletPayment;

import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResponse;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetTopUpWalletUseCase$run$2 extends Lambda implements Function1<WalletPaymentResponse, WalletPaymentDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetTopUpWalletUseCase f61726g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTopUpWalletUseCase$run$2(GetTopUpWalletUseCase getTopUpWalletUseCase) {
        super(1);
        this.f61726g = getTopUpWalletUseCase;
    }

    @NotNull
    public final WalletPaymentDisplayModel invoke(@NotNull WalletPaymentResponse walletPaymentResponse) {
        Intrinsics.checkNotNullParameter(walletPaymentResponse, "it");
        return (WalletPaymentDisplayModel) this.f61726g.mapper.invoke(walletPaymentResponse);
    }
}
