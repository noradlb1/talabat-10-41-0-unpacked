package com.talabat.restaurants.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.restaurants.RestaurantsListScreenRefactor_MembersInjector;
import com.talabat.restaurants.di.RestaurantsListScreenRefactorComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRestaurantsListScreenRefactorComponent {

    public static final class Factory implements RestaurantsListScreenRefactorComponent.Factory {
        private Factory() {
        }

        public RestaurantsListScreenRefactorComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new RestaurantsListScreenRefactorComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi);
        }
    }

    public static final class RestaurantsListScreenRefactorComponentImpl implements RestaurantsListScreenRefactorComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final RestaurantsListScreenRefactorComponentImpl restaurantsListScreenRefactorComponentImpl;

        private RestaurantsListScreenRefactorComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.restaurantsListScreenRefactorComponentImpl = this;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RestaurantsListScreenRefactor injectRestaurantsListScreenRefactor(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
            RestaurantsListScreenRefactor_MembersInjector.injectTalabatExperiment(restaurantsListScreenRefactor, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            RestaurantsListScreenRefactor_MembersInjector.injectTalabatFeatureFlag(restaurantsListScreenRefactor, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            RestaurantsListScreenRefactor_MembersInjector.injectConfigurationLocalRepository(restaurantsListScreenRefactor, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            RestaurantsListScreenRefactor_MembersInjector.injectLocationConfigurationRepository(restaurantsListScreenRefactor, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            RestaurantsListScreenRefactor_MembersInjector.injectNavigatorCoreLibApi(restaurantsListScreenRefactor, this.navigationCoreLibApi);
            RestaurantsListScreenRefactor_MembersInjector.injectScreenTracker(restaurantsListScreenRefactor, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            RestaurantsListScreenRefactor_MembersInjector.injectDeepLinkNavigator(restaurantsListScreenRefactor, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return restaurantsListScreenRefactor;
        }

        public void inject(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
            injectRestaurantsListScreenRefactor(restaurantsListScreenRefactor);
        }
    }

    private DaggerRestaurantsListScreenRefactorComponent() {
    }

    public static RestaurantsListScreenRefactorComponent.Factory factory() {
        return new Factory();
    }
}
