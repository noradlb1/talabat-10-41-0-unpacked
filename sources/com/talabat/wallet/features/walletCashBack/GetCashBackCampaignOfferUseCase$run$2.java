package com.talabat.wallet.features.walletCashBack;

import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponse;
import com.talabat.wallet.ui.walletTopUp.model.WalletCashBackCampaignOfferDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletTopUpCardListMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCashBackCampaignOfferDisplayModel;", "t", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignOfferResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetCashBackCampaignOfferUseCase$run$2 extends Lambda implements Function1<WalletCashBackCampaignOfferResponse, WalletCashBackCampaignOfferDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CashBackCampaignOfferParams f12589g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetCashBackCampaignOfferUseCase$run$2(CashBackCampaignOfferParams cashBackCampaignOfferParams) {
        super(1);
        this.f12589g = cashBackCampaignOfferParams;
    }

    @NotNull
    public final WalletCashBackCampaignOfferDisplayModel invoke(@NotNull WalletCashBackCampaignOfferResponse walletCashBackCampaignOfferResponse) {
        Intrinsics.checkNotNullParameter(walletCashBackCampaignOfferResponse, "t");
        return WalletTopUpCardListMapper.Companion.mapWalletCashBackCampaignResponseToDisplayModel(walletCashBackCampaignOfferResponse, this.f12589g.getPosition());
    }
}
