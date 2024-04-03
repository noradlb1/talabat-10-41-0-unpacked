package com.talabat.core.pinless.checkout.domain;

import com.talabat.domain.location.GeoCoordinate;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;", "", "invoke", "Lcom/talabat/domain/location/GeoCoordinate;", "com_talabat_core_pinless-checkout_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase {
    @Nullable
    GeoCoordinate invoke();
}
