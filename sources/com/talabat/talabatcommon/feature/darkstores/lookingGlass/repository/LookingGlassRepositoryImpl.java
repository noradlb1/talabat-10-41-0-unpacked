package com.talabat.talabatcommon.feature.darkstores.lookingGlass.repository;

import com.facebook.internal.NativeProtocol;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.request.LookingGlassRequestModel;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.LookingGlassResponse;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.network.LookingGlassService;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/repository/LookingGlassRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/repository/LookingGlassRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "lookingGlassService", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/network/LookingGlassService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/network/LookingGlassService;)V", "getGlassData", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/request/LookingGlassRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassRepositoryImpl implements LookingGlassRepository {
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final LookingGlassService lookingGlassService;
    @NotNull
    private final NetworkHandler networkHandler;

    public LookingGlassRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull LookingGlassService lookingGlassService2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(lookingGlassService2, "lookingGlassService");
        this.networkHandler = networkHandler2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.lookingGlassService = lookingGlassService2;
    }

    @NotNull
    public Either<Failure, LookingGlassDisplayModel> getGlassData(@NotNull LookingGlassRequestModel lookingGlassRequestModel) {
        Either<Failure, R> either;
        Intrinsics.checkNotNullParameter(lookingGlassRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        Country selectedCountry = this.locationConfigurationRepository.selectedCountry();
        if (selectedCountry != null) {
            boolean isConnected = this.networkHandler.isConnected();
            if (isConnected) {
                either = RequestKt.request(this.lookingGlassService.getGlassData(lookingGlassRequestModel.getCountryId(), lookingGlassRequestModel.getAreaId(), lookingGlassRequestModel.getProductTag(), lookingGlassRequestModel.getLat(), lookingGlassRequestModel.getLng(), lookingGlassRequestModel.getLimit(), lookingGlassRequestModel.getOffset()), new LookingGlassRepositoryImpl$getGlassData$1$1(selectedCountry), new LookingGlassResponse());
            } else if (!isConnected) {
                either = new Either.Left<>(Failure.NetworkConnection.INSTANCE);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (either != null) {
                return either;
            }
        }
        return new Either.Left(new SystemError("no selected country available"));
    }
}
