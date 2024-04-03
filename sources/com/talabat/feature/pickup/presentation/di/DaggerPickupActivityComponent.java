package com.talabat.feature.pickup.presentation.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.pickup.domain.GetPickupVendorsUseCase;
import com.talabat.feature.pickup.domain.GetPickupVendorsUseCase_Factory;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.pickup.domain.PickupRepository;
import com.talabat.feature.pickup.presentation.PickupActivity;
import com.talabat.feature.pickup.presentation.PickupActivity_MembersInjector;
import com.talabat.feature.pickup.presentation.PickupViewModel;
import com.talabat.feature.pickup.presentation.PickupViewModel_Factory;
import com.talabat.feature.pickup.presentation.di.PickupActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerPickupActivityComponent {

    public static final class Factory implements PickupActivityComponent.Factory {
        private Factory() {
        }

        public PickupActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, PickupFeatureApi pickupFeatureApi, TrackingCoreLibApi trackingCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(pickupFeatureApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new PickupActivityComponentImpl(configurationLocalCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, pickupFeatureApi, trackingCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi);
        }
    }

    public static final class PickupActivityComponentImpl implements PickupActivityComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<GetPickupVendorsUseCase> getPickupVendorsUseCaseProvider;
        private Provider<PickupRepository> getRepositoryProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider2;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final PickupActivityComponentImpl pickupActivityComponentImpl;
        private Provider<PickupViewModel> pickupViewModelProvider;
        private final TrackingCoreLibApi trackingCoreLibApi;

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetRepositoryProvider implements Provider<PickupRepository> {
            private final PickupFeatureApi pickupFeatureApi;

            public GetRepositoryProvider(PickupFeatureApi pickupFeatureApi2) {
                this.pickupFeatureApi = pickupFeatureApi2;
            }

            public PickupRepository get() {
                return (PickupRepository) Preconditions.checkNotNullFromComponent(this.pickupFeatureApi.getRepository());
            }
        }

        public static final class GetRepositoryProvider2 implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider2(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        public static final class GetTalabatTrackerProvider implements Provider<TalabatTracker> {
            private final TrackingCoreLibApi trackingCoreLibApi;

            public GetTalabatTrackerProvider(TrackingCoreLibApi trackingCoreLibApi2) {
                this.trackingCoreLibApi = trackingCoreLibApi2;
            }

            public TalabatTracker get() {
                return (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker());
            }
        }

        private PickupActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, PickupFeatureApi pickupFeatureApi, TrackingCoreLibApi trackingCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.pickupActivityComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            initialize(configurationLocalCoreLibApi2, experimentCoreLibApi2, featureFlagCoreLibApi2, pickupFeatureApi, trackingCoreLibApi2, navigationCoreLibApi2, deepLinkCoreLibApi2);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, PickupFeatureApi pickupFeatureApi, TrackingCoreLibApi trackingCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.getRepositoryProvider = new GetRepositoryProvider(pickupFeatureApi);
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi2);
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi2);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            this.getPickupVendorsUseCaseProvider = GetPickupVendorsUseCase_Factory.create(this.getRepositoryProvider, this.getExperimentProvider, getTalabatFeatureFlagProvider2);
            this.getTalabatTrackerProvider = new GetTalabatTrackerProvider(trackingCoreLibApi2);
            this.getRepositoryProvider2 = new GetRepositoryProvider2(configurationLocalCoreLibApi2);
            this.pickupViewModelProvider = PickupViewModel_Factory.create(this.getPickupVendorsUseCaseProvider, this.getTalabatTrackerProvider, PickupPresentationModule_ProvideCreditBalanceFactory.create(), this.getRepositoryProvider2, PickupPresentationModule_ProvideRemoteConfigFactory.create());
        }

        private PickupActivity injectPickupActivity(PickupActivity pickupActivity) {
            PickupActivity_MembersInjector.injectFactory(pickupActivity, pickupViewModelFactory());
            PickupActivity_MembersInjector.injectFeatureFlag(pickupActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            PickupActivity_MembersInjector.injectTalabatExperiment(pickupActivity, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            PickupActivity_MembersInjector.injectTracker(pickupActivity, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            PickupActivity_MembersInjector.injectNavigatorCoreLibApi(pickupActivity, this.navigationCoreLibApi);
            PickupActivity_MembersInjector.injectConfigurationLocalRepository(pickupActivity, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            PickupActivity_MembersInjector.injectDeepLinkCoreLibApi(pickupActivity, this.deepLinkCoreLibApi);
            return pickupActivity;
        }

        private PickupViewModelFactory pickupViewModelFactory() {
            return new PickupViewModelFactory(this.pickupViewModelProvider);
        }

        public void inject(PickupActivity pickupActivity) {
            injectPickupActivity(pickupActivity);
        }
    }

    private DaggerPickupActivityComponent() {
    }

    public static PickupActivityComponent.Factory factory() {
        return new Factory();
    }
}
