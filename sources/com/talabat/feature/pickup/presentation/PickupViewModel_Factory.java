package com.talabat.feature.pickup.presentation;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.pickup.domain.GetPickupVendorsUseCase;
import com.talabat.feature.pickup.presentation.provider.CreditProvider;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupViewModel_Factory implements Factory<PickupViewModel> {
    private final Provider<ConfigurationLocalRepository> configLocalRepoProvider;
    private final Provider<CreditProvider> creditBalanceProvider;
    private final Provider<RemoteConfiguration> remoteConfigProvider;
    private final Provider<TalabatTracker> trackerProvider;
    private final Provider<GetPickupVendorsUseCase> useCaseProvider;

    public PickupViewModel_Factory(Provider<GetPickupVendorsUseCase> provider, Provider<TalabatTracker> provider2, Provider<CreditProvider> provider3, Provider<ConfigurationLocalRepository> provider4, Provider<RemoteConfiguration> provider5) {
        this.useCaseProvider = provider;
        this.trackerProvider = provider2;
        this.creditBalanceProvider = provider3;
        this.configLocalRepoProvider = provider4;
        this.remoteConfigProvider = provider5;
    }

    public static PickupViewModel_Factory create(Provider<GetPickupVendorsUseCase> provider, Provider<TalabatTracker> provider2, Provider<CreditProvider> provider3, Provider<ConfigurationLocalRepository> provider4, Provider<RemoteConfiguration> provider5) {
        return new PickupViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PickupViewModel newInstance(GetPickupVendorsUseCase getPickupVendorsUseCase, TalabatTracker talabatTracker, CreditProvider creditProvider, ConfigurationLocalRepository configurationLocalRepository, RemoteConfiguration remoteConfiguration) {
        return new PickupViewModel(getPickupVendorsUseCase, talabatTracker, creditProvider, configurationLocalRepository, remoteConfiguration);
    }

    public PickupViewModel get() {
        return newInstance(this.useCaseProvider.get(), this.trackerProvider.get(), this.creditBalanceProvider.get(), this.configLocalRepoProvider.get(), this.remoteConfigProvider.get());
    }
}
