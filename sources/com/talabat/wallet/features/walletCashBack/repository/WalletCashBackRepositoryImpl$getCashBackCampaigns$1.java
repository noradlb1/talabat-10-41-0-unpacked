package com.talabat.wallet.features.walletCashBack.repository;

import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletCashBackRepositoryImpl$getCashBackCampaigns$1 extends Lambda implements Function1<WalletCashBackCampaignResponse, WalletCashBackCampaignResponse> {
    public static final WalletCashBackRepositoryImpl$getCashBackCampaigns$1 INSTANCE = new WalletCashBackRepositoryImpl$getCashBackCampaigns$1();

    public WalletCashBackRepositoryImpl$getCashBackCampaigns$1() {
        super(1);
    }

    @NotNull
    public final WalletCashBackCampaignResponse invoke(@NotNull WalletCashBackCampaignResponse walletCashBackCampaignResponse) {
        Intrinsics.checkNotNullParameter(walletCashBackCampaignResponse, "it");
        return walletCashBackCampaignResponse;
    }
}
