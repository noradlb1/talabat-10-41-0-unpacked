package com.talabat.wallet.features.walletCashBack.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/network/WalletCashBackService;", "Lcom/talabat/wallet/features/walletCashBack/network/WalletCashBackApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "walletCashBackApi", "getWalletCashBackApi", "()Lcom/talabat/wallet/features/walletCashBack/network/WalletCashBackApi;", "walletCashBackApi$delegate", "Lkotlin/Lazy;", "getCashBackCampaignOffer", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignOfferResponse;", "countryId", "", "binNumber", "", "countryQueryId", "getCashBackCampaigns", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "eventId", "getEstimatedCashBack", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponse;", "requestModel", "Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashBackService implements WalletCashBackApi {
    @NotNull
    private final Lazy walletCashBackApi$delegate;

    public WalletCashBackService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.walletCashBackApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletCashBackService$walletCashBackApi$2(talabatAPIBuilder));
    }

    private final WalletCashBackApi getWalletCashBackApi() {
        return (WalletCashBackApi) this.walletCashBackApi$delegate.getValue();
    }

    @NotNull
    public Call<WalletCashBackCampaignOfferResponse> getCashBackCampaignOffer(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "binNumber");
        return getWalletCashBackApi().getCashBackCampaignOffer(i11, str, i12);
    }

    @NotNull
    public Call<WalletCashBackCampaignResponse> getCashBackCampaigns(int i11, int i12, int i13) {
        return getWalletCashBackApi().getCashBackCampaigns(i11, i12, i13);
    }

    @NotNull
    public Call<WalletCalculateCashBackResponse> getEstimatedCashBack(@NotNull WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel, int i11) {
        Intrinsics.checkNotNullParameter(walletCalculateCashBackRequestModel, "requestModel");
        return getWalletCashBackApi().getEstimatedCashBack(walletCalculateCashBackRequestModel, i11);
    }
}
