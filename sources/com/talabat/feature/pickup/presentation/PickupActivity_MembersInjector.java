package com.talabat.feature.pickup.presentation;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.pickup.presentation.di.PickupViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PickupActivity_MembersInjector implements MembersInjector<PickupActivity> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkCoreLibApi> deepLinkCoreLibApiProvider;
    private final Provider<PickupViewModelFactory> factoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<NavigationCoreLibApi> navigatorCoreLibApiProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<TalabatTracker> trackerProvider;

    public PickupActivity_MembersInjector(Provider<PickupViewModelFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ITalabatExperiment> provider3, Provider<TalabatTracker> provider4, Provider<NavigationCoreLibApi> provider5, Provider<ConfigurationLocalRepository> provider6, Provider<DeepLinkCoreLibApi> provider7) {
        this.factoryProvider = provider;
        this.featureFlagProvider = provider2;
        this.talabatExperimentProvider = provider3;
        this.trackerProvider = provider4;
        this.navigatorCoreLibApiProvider = provider5;
        this.configurationLocalRepositoryProvider = provider6;
        this.deepLinkCoreLibApiProvider = provider7;
    }

    public static MembersInjector<PickupActivity> create(Provider<PickupViewModelFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ITalabatExperiment> provider3, Provider<TalabatTracker> provider4, Provider<NavigationCoreLibApi> provider5, Provider<ConfigurationLocalRepository> provider6, Provider<DeepLinkCoreLibApi> provider7) {
        return new PickupActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(PickupActivity pickupActivity, ConfigurationLocalRepository configurationLocalRepository) {
        pickupActivity.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.deepLinkCoreLibApi")
    public static void injectDeepLinkCoreLibApi(PickupActivity pickupActivity, DeepLinkCoreLibApi deepLinkCoreLibApi) {
        pickupActivity.deepLinkCoreLibApi = deepLinkCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.factory")
    public static void injectFactory(PickupActivity pickupActivity, PickupViewModelFactory pickupViewModelFactory) {
        pickupActivity.factory = pickupViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.featureFlag")
    public static void injectFeatureFlag(PickupActivity pickupActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        pickupActivity.featureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.navigatorCoreLibApi")
    public static void injectNavigatorCoreLibApi(PickupActivity pickupActivity, NavigationCoreLibApi navigationCoreLibApi) {
        pickupActivity.navigatorCoreLibApi = navigationCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.talabatExperiment")
    public static void injectTalabatExperiment(PickupActivity pickupActivity, ITalabatExperiment iTalabatExperiment) {
        pickupActivity.talabatExperiment = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.feature.pickup.presentation.PickupActivity.tracker")
    public static void injectTracker(PickupActivity pickupActivity, TalabatTracker talabatTracker) {
        pickupActivity.tracker = talabatTracker;
    }

    public void injectMembers(PickupActivity pickupActivity) {
        injectFactory(pickupActivity, this.factoryProvider.get());
        injectFeatureFlag(pickupActivity, this.featureFlagProvider.get());
        injectTalabatExperiment(pickupActivity, this.talabatExperimentProvider.get());
        injectTracker(pickupActivity, this.trackerProvider.get());
        injectNavigatorCoreLibApi(pickupActivity, this.navigatorCoreLibApiProvider.get());
        injectConfigurationLocalRepository(pickupActivity, this.configurationLocalRepositoryProvider.get());
        injectDeepLinkCoreLibApi(pickupActivity, this.deepLinkCoreLibApiProvider.get());
    }
}
