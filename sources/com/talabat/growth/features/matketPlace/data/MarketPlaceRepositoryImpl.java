package com.talabat.growth.features.matketPlace.data;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceApi;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceService;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnItemResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionDetailsResponse;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnOptionsMapper;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.MarketPlaceRedeemBurnOptionService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.MarketPlaceRedeemBurnOptionRepositoryImpl;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ-\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/talabat/growth/features/matketPlace/data/MarketPlaceRepositoryImpl;", "Lcom/talabat/growth/features/matketPlace/data/MarketPlaceRepository;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/MarketPlaceRedeemBurnOptionRepositoryImpl;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "marketPlaceService", "Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceService;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "redeemService", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemBurnOptionService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceService;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemBurnOptionService;)V", "getNetworkHandler", "()Lcom/talabat/talabatcore/platform/NetworkHandler;", "getBurnOptionDetails", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "burnOptionItemId", "", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "(Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceRepositoryImpl extends MarketPlaceRedeemBurnOptionRepositoryImpl implements MarketPlaceRepository {
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final MarketPlaceService marketPlaceService;
    @NotNull
    private final NetworkHandler networkHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketPlaceRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull MarketPlaceService marketPlaceService2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull MarketPlaceRedeemBurnOptionService marketPlaceRedeemBurnOptionService) {
        super(networkHandler2, marketPlaceRedeemBurnOptionService, configurationLocalRepository);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(marketPlaceService2, "marketPlaceService");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(marketPlaceRedeemBurnOptionService, "redeemService");
        this.networkHandler = networkHandler2;
        this.marketPlaceService = marketPlaceService2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    @Nullable
    public Object getBurnOptionDetails(@NotNull String str, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull Continuation<? super Either<? extends Failure, BurnItemDisplayModel>> continuation) {
        boolean isConnected = getNetworkHandler().isConnected();
        if (isConnected) {
            Call itemDetails$default = MarketPlaceApi.DefaultImpls.getItemDetails$default(this.marketPlaceService, 0, str, IntegrationGlobalDataModel.Companion.selectedLanguage(), loyaltyBurnOptionType.getStringValue(), 1, (Object) null);
            Object marketPlaceBurnOptionDetailsResponse = new MarketPlaceBurnOptionDetailsResponse();
            try {
                Response execute = itemDetails$default.clone().execute();
                boolean isSuccessful = execute.isSuccessful();
                if (isSuccessful) {
                    Object body = execute.body();
                    if (body != null) {
                        marketPlaceBurnOptionDetailsResponse = body;
                    }
                    BurnOptionsMapper burnOptionsMapper = BurnOptionsMapper.INSTANCE;
                    Object result = ((MarketPlaceBurnOptionDetailsResponse) marketPlaceBurnOptionDetailsResponse).getResult();
                    Intrinsics.checkNotNull(result);
                    return new Either.Right(burnOptionsMapper.mapMarketPlaceBurnItemResponse$com_talabat_NewArchi_GrowthSquad_GrowthSquad((MarketPlaceBurnItemResponse) result, this.locationConfigurationRepository));
                } else if (!isSuccessful) {
                    Intrinsics.checkNotNullExpressionValue(execute, "response");
                    return new Either.Left(RequestKt.parseTheServerError(execute));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } catch (Failure e11) {
                LogManager.logException(e11);
                return new Either.Left(e11);
            } catch (Throwable th2) {
                LogManager.logException(th2);
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                return new Either.Left(new SystemError(message));
            }
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public NetworkHandler getNetworkHandler() {
        return this.networkHandler;
    }
}
