package com.talabat.restaurants;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RestaurantsListScreenRefactor_MembersInjector implements MembersInjector<RestaurantsListScreenRefactor> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<NavigationCoreLibApi> navigatorCoreLibApiProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public RestaurantsListScreenRefactor_MembersInjector(Provider<ITalabatExperiment> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<NavigationCoreLibApi> provider5, Provider<IScreenTracker> provider6, Provider<DeepLinkNavigator> provider7) {
        this.talabatExperimentProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
        this.navigatorCoreLibApiProvider = provider5;
        this.screenTrackerProvider = provider6;
        this.deepLinkNavigatorProvider = provider7;
    }

    public static MembersInjector<RestaurantsListScreenRefactor> create(Provider<ITalabatExperiment> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<NavigationCoreLibApi> provider5, Provider<IScreenTracker> provider6, Provider<DeepLinkNavigator> provider7) {
        return new RestaurantsListScreenRefactor_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(RestaurantsListScreenRefactor restaurantsListScreenRefactor, ConfigurationLocalRepository configurationLocalRepository) {
        restaurantsListScreenRefactor.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.deepLinkNavigator")
    public static void injectDeepLinkNavigator(RestaurantsListScreenRefactor restaurantsListScreenRefactor, DeepLinkNavigator deepLinkNavigator) {
        restaurantsListScreenRefactor.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(RestaurantsListScreenRefactor restaurantsListScreenRefactor, LocationConfigurationRepository locationConfigurationRepository) {
        restaurantsListScreenRefactor.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.navigatorCoreLibApi")
    public static void injectNavigatorCoreLibApi(RestaurantsListScreenRefactor restaurantsListScreenRefactor, NavigationCoreLibApi navigationCoreLibApi) {
        restaurantsListScreenRefactor.navigatorCoreLibApi = navigationCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.screenTracker")
    public static void injectScreenTracker(RestaurantsListScreenRefactor restaurantsListScreenRefactor, IScreenTracker iScreenTracker) {
        restaurantsListScreenRefactor.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.talabatExperiment")
    public static void injectTalabatExperiment(RestaurantsListScreenRefactor restaurantsListScreenRefactor, ITalabatExperiment iTalabatExperiment) {
        restaurantsListScreenRefactor.talabatExperiment = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.restaurants.RestaurantsListScreenRefactor.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(RestaurantsListScreenRefactor restaurantsListScreenRefactor, ITalabatFeatureFlag iTalabatFeatureFlag) {
        restaurantsListScreenRefactor.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        injectTalabatExperiment(restaurantsListScreenRefactor, this.talabatExperimentProvider.get());
        injectTalabatFeatureFlag(restaurantsListScreenRefactor, this.talabatFeatureFlagProvider.get());
        injectConfigurationLocalRepository(restaurantsListScreenRefactor, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(restaurantsListScreenRefactor, this.locationConfigurationRepositoryProvider.get());
        injectNavigatorCoreLibApi(restaurantsListScreenRefactor, this.navigatorCoreLibApiProvider.get());
        injectScreenTracker(restaurantsListScreenRefactor, this.screenTrackerProvider.get());
        injectDeepLinkNavigator(restaurantsListScreenRefactor, this.deepLinkNavigatorProvider.get());
    }
}
