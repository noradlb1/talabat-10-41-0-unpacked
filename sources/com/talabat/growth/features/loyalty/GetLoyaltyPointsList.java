package com.talabat.growth.features.loyalty;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.growth.features.loyalty.models.LoyaltyPointsHistoryRequestModel;
import com.talabat.growth.features.loyalty.models.responses.LoyaltyPointsHistoryResponseModel;
import com.talabat.growth.features.loyalty.network.GetPointsService;
import com.talabat.growth.ui.loyalty.models.LoyaltyHistoryDisplayModel;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/growth/features/loyalty/GetLoyaltyPointsList;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyHistoryDisplayModel;", "Lcom/talabat/growth/features/loyalty/models/LoyaltyPointsHistoryRequestModel;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/growth/features/loyalty/network/GetPointsService;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/growth/features/loyalty/network/GetPointsService;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/growth/features/loyalty/models/LoyaltyPointsHistoryRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetLoyaltyPointsList extends UseCase<LoyaltyHistoryDisplayModel, LoyaltyPointsHistoryRequestModel> {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final GetPointsService f60560service;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetLoyaltyPointsList(@NotNull NetworkHandler networkHandler2, @NotNull GetPointsService getPointsService, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(getPointsService, "service");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.networkHandler = networkHandler2;
        this.f60560service = getPointsService;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public Object run(@NotNull LoyaltyPointsHistoryRequestModel loyaltyPointsHistoryRequestModel, @NotNull Continuation<? super Either<? extends Failure, LoyaltyHistoryDisplayModel>> continuation) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Call<LoyaltyPointsHistoryResponseModel> pointsList = this.f60560service.getPointsList(this.configurationLocalRepository.selectedCountry().getCountryId(), loyaltyPointsHistoryRequestModel.getFilterID().getValue(), loyaltyPointsHistoryRequestModel.getPageNumber(), loyaltyPointsHistoryRequestModel.getPageSize(), loyaltyPointsHistoryRequestModel.getLanguageCode());
            if (pointsList == null) {
                return new Either.Left(Failure.NetworkConnection.INSTANCE);
            }
            return RequestKt.request(pointsList, GetLoyaltyPointsList$run$2.INSTANCE, new LoyaltyPointsHistoryResponseModel());
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
