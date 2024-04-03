package com.talabat.darkstores.feature.observability;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkStoreObservabilityTrackerImpl_Factory implements Factory<DarkStoreObservabilityTrackerImpl> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> integrationGlobalDataModelProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public DarkStoreObservabilityTrackerImpl_Factory(Provider<IObservabilityManager> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<ConfigurationParameters> provider3, Provider<AppVersionProvider> provider4) {
        this.observabilityManagerProvider = provider;
        this.integrationGlobalDataModelProvider = provider2;
        this.configurationParametersProvider = provider3;
        this.appVersionProvider = provider4;
    }

    public static DarkStoreObservabilityTrackerImpl_Factory create(Provider<IObservabilityManager> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<ConfigurationParameters> provider3, Provider<AppVersionProvider> provider4) {
        return new DarkStoreObservabilityTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DarkStoreObservabilityTrackerImpl newInstance(IObservabilityManager iObservabilityManager, IntegrationGlobalDataModel.Companion companion, ConfigurationParameters configurationParameters, AppVersionProvider appVersionProvider2) {
        return new DarkStoreObservabilityTrackerImpl(iObservabilityManager, companion, configurationParameters, appVersionProvider2);
    }

    public DarkStoreObservabilityTrackerImpl get() {
        return newInstance(this.observabilityManagerProvider.get(), this.integrationGlobalDataModelProvider.get(), this.configurationParametersProvider.get(), this.appVersionProvider.get());
    }
}
