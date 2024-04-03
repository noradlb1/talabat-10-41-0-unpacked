package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig;

import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResponse;
import com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentWidgetConfigUseCase$run$2 extends Lambda implements Function1<WalletPaymentWidgetConfigResponse, WalletPaymentWidgetConfigDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetWalletPaymentWidgetConfigUseCase f61732g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetWalletPaymentWidgetConfigUseCase$run$2(GetWalletPaymentWidgetConfigUseCase getWalletPaymentWidgetConfigUseCase) {
        super(1);
        this.f61732g = getWalletPaymentWidgetConfigUseCase;
    }

    @NotNull
    public final WalletPaymentWidgetConfigDisplayModel invoke(@NotNull WalletPaymentWidgetConfigResponse walletPaymentWidgetConfigResponse) {
        Intrinsics.checkNotNullParameter(walletPaymentWidgetConfigResponse, "it");
        return (WalletPaymentWidgetConfigDisplayModel) this.f61732g.mapper.invoke(walletPaymentWidgetConfigResponse);
    }
}
