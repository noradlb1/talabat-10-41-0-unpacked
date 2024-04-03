package com.talabat.core.pinless.checkout.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap_Factory implements Factory<GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap> {
    private final Provider<PinlessCheckoutFeatureRepository> repositoryProvider;

    public GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap_Factory(Provider<PinlessCheckoutFeatureRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap_Factory create(Provider<PinlessCheckoutFeatureRepository> provider) {
        return new GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap_Factory(provider);
    }

    public static GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap newInstance(PinlessCheckoutFeatureRepository pinlessCheckoutFeatureRepository) {
        return new GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap(pinlessCheckoutFeatureRepository);
    }

    public GetHasUserPinnedLocationInCurrentOnboardingSessionInOnboardingMap get() {
        return newInstance(this.repositoryProvider.get());
    }
}
