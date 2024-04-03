package com.talabat.core.pinless.checkout.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutCoreLibApi;", "Lcom/talabat/core/di/Api;", "getHasUserPinnedLocationInCurrentOnboardingSessionUseCase", "Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;", "getGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase", "()Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;", "setHasUserPinnedLocationInOnboardingMapUseCase", "Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;", "getSetHasUserPinnedLocationInOnboardingMapUseCase", "()Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;", "com_talabat_core_pinless-checkout_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PinlessCheckoutCoreLibApi extends Api {
    @NotNull
    GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase();

    @NotNull
    SetHasUserPinnedLocationInOnboardingMapUseCase getSetHasUserPinnedLocationInOnboardingMapUseCase();
}
