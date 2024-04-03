package com.talabat.core.pinless.checkout.domain;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.domain.location.GeoCoordinate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap;", "Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;", "Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;", "repository", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutFeatureRepository;", "(Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutFeatureRepository;)V", "invoke", "Lcom/talabat/domain/location/GeoCoordinate;", "userPinnedLocationManually", "", "latLng", "com_talabat_core_pinless-checkout_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap implements SetHasUserPinnedLocationInOnboardingMapUseCase, GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase {
    @NotNull
    private final PinlessCheckoutFeatureRepository repository;

    @Inject
    public GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap(@NotNull PinlessCheckoutFeatureRepository pinlessCheckoutFeatureRepository) {
        Intrinsics.checkNotNullParameter(pinlessCheckoutFeatureRepository, "repository");
        this.repository = pinlessCheckoutFeatureRepository;
    }

    @Nullable
    public GeoCoordinate invoke() {
        GeoCoordinate manuallyPinnedLocationOfUser = this.repository.getManuallyPinnedLocationOfUser();
        if (manuallyPinnedLocationOfUser != null) {
            boolean z11 = true;
            if (this.repository.getUserPinnedLocationCount() != 1) {
                z11 = false;
            }
            if (z11) {
                return manuallyPinnedLocationOfUser;
            }
        }
        return null;
    }

    public void userPinnedLocationManually(@NotNull GeoCoordinate geoCoordinate) {
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        if (this.repository.getUserPinnedLocationCount() <= 2) {
            PinlessCheckoutFeatureRepository pinlessCheckoutFeatureRepository = this.repository;
            pinlessCheckoutFeatureRepository.setUserPinnedLocationCount(pinlessCheckoutFeatureRepository.getUserPinnedLocationCount() + 1);
        }
        this.repository.setManuallyPinnedLocationOfUser(geoCoordinate);
    }
}
