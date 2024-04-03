package com.talabat.core.pinless.checkout.domain;

import com.talabat.domain.location.GeoCoordinate;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutFeatureRepository;", "", "manuallyPinnedLocationOfUser", "Lcom/talabat/domain/location/GeoCoordinate;", "getManuallyPinnedLocationOfUser", "()Lcom/talabat/domain/location/GeoCoordinate;", "setManuallyPinnedLocationOfUser", "(Lcom/talabat/domain/location/GeoCoordinate;)V", "userPinnedLocationCount", "", "getUserPinnedLocationCount", "()I", "setUserPinnedLocationCount", "(I)V", "com_talabat_core_pinless-checkout_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PinlessCheckoutFeatureRepository {
    @Nullable
    GeoCoordinate getManuallyPinnedLocationOfUser();

    int getUserPinnedLocationCount();

    void setManuallyPinnedLocationOfUser(@Nullable GeoCoordinate geoCoordinate);

    void setUserPinnedLocationCount(int i11);
}
