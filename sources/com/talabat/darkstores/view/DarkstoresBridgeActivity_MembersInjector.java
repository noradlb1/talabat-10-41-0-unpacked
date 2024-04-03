package com.talabat.darkstores.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DarkstoresBridgeActivity_MembersInjector implements MembersInjector<DarkstoresBridgeActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public DarkstoresBridgeActivity_MembersInjector(Provider<AppVersionProvider> provider, Provider<DiscoveryConfigurationRepository> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<LocationConfigurationRepository> provider5, Provider<IObservabilityManager> provider6) {
        this.appVersionProvider = provider;
        this.discoveryConfigurationRepositoryProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
        this.locationConfigRepositoryProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static MembersInjector<DarkstoresBridgeActivity> create(Provider<AppVersionProvider> provider, Provider<DiscoveryConfigurationRepository> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<LocationConfigurationRepository> provider5, Provider<IObservabilityManager> provider6) {
        return new DarkstoresBridgeActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.talabat.darkstores.view.DarkstoresBridgeActivity.appVersionProvider")
    public static void injectAppVersionProvider(DarkstoresBridgeActivity darkstoresBridgeActivity, AppVersionProvider appVersionProvider2) {
        darkstoresBridgeActivity.appVersionProvider = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.darkstores.view.DarkstoresBridgeActivity.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(DarkstoresBridgeActivity darkstoresBridgeActivity, ConfigurationLocalRepository configurationLocalRepository) {
        darkstoresBridgeActivity.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.darkstores.view.DarkstoresBridgeActivity.discoveryConfigurationRepository")
    public static void injectDiscoveryConfigurationRepository(DarkstoresBridgeActivity darkstoresBridgeActivity, DiscoveryConfigurationRepository discoveryConfigurationRepository) {
        darkstoresBridgeActivity.discoveryConfigurationRepository = discoveryConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.darkstores.view.DarkstoresBridgeActivity.locationConfigRepository")
    public static void injectLocationConfigRepository(DarkstoresBridgeActivity darkstoresBridgeActivity, LocationConfigurationRepository locationConfigurationRepository) {
        darkstoresBridgeActivity.locationConfigRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.darkstores.view.DarkstoresBridgeActivity.observabilityManager")
    public static void injectObservabilityManager(DarkstoresBridgeActivity darkstoresBridgeActivity, IObservabilityManager iObservabilityManager) {
        darkstoresBridgeActivity.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.darkstores.view.DarkstoresBridgeActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(DarkstoresBridgeActivity darkstoresBridgeActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        darkstoresBridgeActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(DarkstoresBridgeActivity darkstoresBridgeActivity) {
        injectAppVersionProvider(darkstoresBridgeActivity, this.appVersionProvider.get());
        injectDiscoveryConfigurationRepository(darkstoresBridgeActivity, this.discoveryConfigurationRepositoryProvider.get());
        injectConfigurationLocalRepository(darkstoresBridgeActivity, this.configurationLocalRepositoryProvider.get());
        injectTalabatFeatureFlag(darkstoresBridgeActivity, this.talabatFeatureFlagProvider.get());
        injectLocationConfigRepository(darkstoresBridgeActivity, this.locationConfigRepositoryProvider.get());
        injectObservabilityManager(darkstoresBridgeActivity, this.observabilityManagerProvider.get());
    }
}
