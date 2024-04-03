package com.talabat.core.pinless.checkout.domain;

import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutDomainModule;", "", "()V", "getHasUserPinnedLocationInCurrentOnboardingSessionUseCase", "Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;", "impl", "Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap;", "getHasUserPinnedLocationInCurrentOnboardingSessionUseCase$com_talabat_core_pinless_checkout_domain_domain", "setHasUserPinnedLocationInOnboardingMapUseCase", "Lcom/talabat/core/pinless/checkout/domain/SetHasUserPinnedLocationInOnboardingMapUseCase;", "setHasUserPinnedLocationInOnboardingMapUseCase$com_talabat_core_pinless_checkout_domain_domain", "com_talabat_core_pinless-checkout_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public abstract class PinlessCheckoutDomainModule {
    @NotNull
    @Binds
    public abstract GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getHasUserPinnedLocationInCurrentOnboardingSessionUseCase$com_talabat_core_pinless_checkout_domain_domain(@NotNull GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap getHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap);

    @NotNull
    @Binds
    public abstract SetHasUserPinnedLocationInOnboardingMapUseCase setHasUserPinnedLocationInOnboardingMapUseCase$com_talabat_core_pinless_checkout_domain_domain(@NotNull GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap getHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap);
}
