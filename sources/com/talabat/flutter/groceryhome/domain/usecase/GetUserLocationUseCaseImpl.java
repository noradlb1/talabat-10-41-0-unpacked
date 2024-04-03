package com.talabat.flutter.groceryhome.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.flutter.groceryhome.domain.model.UserLocation;
import com.talabat.helpers.GlobalDataModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/flutter/groceryhome/domain/usecase/GetUserLocationUseCaseImpl;", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetUserLocationUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "invoke", "Lcom/talabat/flutter/groceryhome/domain/model/UserLocation;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetUserLocationUseCaseImpl implements GetUserLocationUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;

    @Inject
    public GetUserLocationUseCaseImpl(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public UserLocation invoke() {
        String valueOf = String.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId());
        String valueOf2 = String.valueOf(GlobalDataModel.SelectedAreaId);
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        Intrinsics.checkNotNullExpressionValue(latitude, "getLatitude()");
        String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
        Intrinsics.checkNotNullExpressionValue(longitude, "getLongitude()");
        return new UserLocation(valueOf, valueOf2, latitude, longitude);
    }
}
