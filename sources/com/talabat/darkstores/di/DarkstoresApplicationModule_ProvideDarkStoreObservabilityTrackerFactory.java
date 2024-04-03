package com.talabat.darkstores.di;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideDarkStoreObservabilityTrackerFactory implements Factory<DarkStoreObservabilityTracker> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<GetVendorLightningOptimizationExpVariantUseCase> getVendorLightningOptimizationExpVariantUseCaseProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> integrationGlobalDataModelProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public DarkstoresApplicationModule_ProvideDarkStoreObservabilityTrackerFactory(Provider<IObservabilityManager> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<ConfigurationParameters> provider3, Provider<AppVersionProvider> provider4, Provider<GetVendorLightningOptimizationExpVariantUseCase> provider5) {
        this.observabilityManagerProvider = provider;
        this.integrationGlobalDataModelProvider = provider2;
        this.configurationParametersProvider = provider3;
        this.appVersionProvider = provider4;
        this.getVendorLightningOptimizationExpVariantUseCaseProvider = provider5;
    }

    public static DarkstoresApplicationModule_ProvideDarkStoreObservabilityTrackerFactory create(Provider<IObservabilityManager> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<ConfigurationParameters> provider3, Provider<AppVersionProvider> provider4, Provider<GetVendorLightningOptimizationExpVariantUseCase> provider5) {
        return new DarkstoresApplicationModule_ProvideDarkStoreObservabilityTrackerFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static DarkStoreObservabilityTracker provideDarkStoreObservabilityTracker(IObservabilityManager iObservabilityManager, IntegrationGlobalDataModel.Companion companion, ConfigurationParameters configurationParameters, AppVersionProvider appVersionProvider2, GetVendorLightningOptimizationExpVariantUseCase getVendorLightningOptimizationExpVariantUseCase) {
        return (DarkStoreObservabilityTracker) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideDarkStoreObservabilityTracker(iObservabilityManager, companion, configurationParameters, appVersionProvider2, getVendorLightningOptimizationExpVariantUseCase));
    }

    public DarkStoreObservabilityTracker get() {
        return provideDarkStoreObservabilityTracker(this.observabilityManagerProvider.get(), this.integrationGlobalDataModelProvider.get(), this.configurationParametersProvider.get(), this.appVersionProvider.get(), this.getVendorLightningOptimizationExpVariantUseCaseProvider.get());
    }
}
