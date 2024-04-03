package com.talabat.wallet.features.walletCashBack.repository;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponseResult;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponseResult;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponseResult;
import com.talabat.wallet.features.walletCashBack.network.WalletCashBackApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J,\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J$\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/repository/WalletCashBackRepositoryImpl;", "Lcom/talabat/wallet/features/walletCashBack/repository/WalletCashBackRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "walletCashBackApi", "Lcom/talabat/wallet/features/walletCashBack/network/WalletCashBackApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/wallet/features/walletCashBack/network/WalletCashBackApi;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getCalculatedCashBack", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponse;", "requestModel", "Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "getCashBackCampaignOffer", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignOfferResponse;", "countryId", "", "cardBinNumber", "", "position", "getCashBackCampaigns", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "eventId", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCashBackRepositoryImpl implements WalletCashBackRepository {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final WalletCashBackApi walletCashBackApi;

    public WalletCashBackRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull WalletCashBackApi walletCashBackApi2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(walletCashBackApi2, "walletCashBackApi");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.networkHandler = networkHandler2;
        this.walletCashBackApi = walletCashBackApi2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public Either<Failure, WalletCalculateCashBackResponse> getCalculatedCashBack(@NotNull WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel) {
        Intrinsics.checkNotNullParameter(walletCalculateCashBackRequestModel, "requestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletCashBackApi.getEstimatedCashBack(walletCalculateCashBackRequestModel, this.configurationLocalRepository.selectedCountry().getCountryId()), WalletCashBackRepositoryImpl$getCalculatedCashBack$1.INSTANCE, new WalletCalculateCashBackResponse((WalletCalculateCashBackResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, WalletCashBackCampaignOfferResponse> getCashBackCampaignOffer(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "cardBinNumber");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletCashBackApi.getCashBackCampaignOffer(i11, str, this.configurationLocalRepository.selectedCountry().getCountryId()), WalletCashBackRepositoryImpl$getCashBackCampaignOffer$1.INSTANCE, new WalletCashBackCampaignOfferResponse((WalletCashBackCampaignOfferResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, WalletCashBackCampaignResponse> getCashBackCampaigns(int i11, int i12) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletCashBackApi.getCashBackCampaigns(i11, i12, this.configurationLocalRepository.selectedCountry().getCountryId()), WalletCashBackRepositoryImpl$getCashBackCampaigns$1.INSTANCE, new WalletCashBackCampaignResponse((WalletCashBackCampaignResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
