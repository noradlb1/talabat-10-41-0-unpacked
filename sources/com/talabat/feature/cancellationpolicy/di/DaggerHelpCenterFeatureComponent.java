package com.talabat.feature.cancellationpolicy.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.cancellationpolicy.di.HelpCenterFeatureComponent;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyApi;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyBaseUrl_Factory;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerHelpCenterFeatureComponent {

    public static final class Factory implements HelpCenterFeatureComponent.Factory {
        private Factory() {
        }

        public HelpCenterFeatureComponent create(NetworkCoreLibApi networkCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new HelpCenterFeatureComponentImpl(networkCoreLibApi, configurationLocalCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, dispatcherCoreLibApi);
        }
    }

    public static final class HelpCenterFeatureComponentImpl implements HelpCenterFeatureComponent {
        private Provider<ICancellationPolicyMapper> cancellationPolicyMapperProvider;
        private Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private final HelpCenterFeatureComponentImpl helpCenterFeatureComponentImpl;
        private Provider<String> provideBaseUrlCancellationPolicyProvider;
        private Provider<CancellationPolicyApi> provideCancellationApiProvider;
        private Provider<ICancellationPolicyFlag> provideCancellationPolicyFeatureFlagProvider;
        private Provider<CancellationPolicyService> provideCancellationServiceProvider;
        private Provider<Integer> provideCountryIdProvider;
        private Provider<ICancellationPolicyRepository> provideGetPastOrderRepositoryProvider;
        private Provider<IHelpCenterDeeplinkBuilder> provideHelpCenterDeeplinkNavigatorProvider;
        private Provider<IHelpCenterEventTracker> provideHelpCenterEventTrackerProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
            }
        }

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
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

        private HelpCenterFeatureComponentImpl(NetworkCoreLibApi networkCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.helpCenterFeatureComponentImpl = this;
            initialize(networkCoreLibApi, configurationLocalCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, dispatcherCoreLibApi);
        }

        private void initialize(NetworkCoreLibApi networkCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            HelpCenterNetworkModule_ProvideBaseUrlCancellationPolicyFactory create = HelpCenterNetworkModule_ProvideBaseUrlCancellationPolicyFactory.create(getBaseUrlFactoryProvider2, CancellationPolicyBaseUrl_Factory.create());
            this.provideBaseUrlCancellationPolicyProvider = create;
            HelpCenterNetworkModule_ProvideCancellationApiFactory create2 = HelpCenterNetworkModule_ProvideCancellationApiFactory.create(create);
            this.provideCancellationApiProvider = create2;
            this.provideCancellationServiceProvider = HelpCenterNetworkModule_ProvideCancellationServiceFactory.create(create2);
            this.cancellationPolicyMapperProvider = SingleCheck.provider(HelpCenterFeatureModule_CancellationPolicyMapperFactory.create());
            dagger.internal.Factory create3 = InstanceFactory.create(configurationLocalCoreLibApi);
            this.configurationLocalCoreLibApiProvider = create3;
            HelpCenterUserDataModule_ProvideCountryIdFactory create4 = HelpCenterUserDataModule_ProvideCountryIdFactory.create(create3);
            this.provideCountryIdProvider = create4;
            this.provideGetPastOrderRepositoryProvider = SingleCheck.provider(HelpCenterFeatureModule_ProvideGetPastOrderRepositoryFactory.create(this.getCoroutineDispatchersFactoryProvider, this.provideCancellationServiceProvider, this.cancellationPolicyMapperProvider, create4, HelpCenterUserDataModule_ProvideVerticalTypeFactory.create()));
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            this.provideCancellationPolicyFeatureFlagProvider = SingleCheck.provider(HelpCenterFeatureModule_ProvideCancellationPolicyFeatureFlagFactory.create(getTalabatFeatureFlagProvider2));
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            this.provideHelpCenterEventTrackerProvider = SingleCheck.provider(HelpCenterFeatureModule_ProvideHelpCenterEventTrackerFactory.create(getTalabatTrackerProvider2));
            this.provideHelpCenterDeeplinkNavigatorProvider = SingleCheck.provider(HelpCenterFeatureModule_ProvideHelpCenterDeeplinkNavigatorFactory.create());
        }

        public ICancellationPolicyFlag getCancellationPolicyFlag() {
            return this.provideCancellationPolicyFeatureFlagProvider.get();
        }

        public ICancellationPolicyRepository getCancellationPolicyRepository() {
            return this.provideGetPastOrderRepositoryProvider.get();
        }

        public IHelpCenterDeeplinkBuilder getHelpCenterDeeplinkNavigator() {
            return this.provideHelpCenterDeeplinkNavigatorProvider.get();
        }

        public IHelpCenterEventTracker getHelpCenterEventTracker() {
            return this.provideHelpCenterEventTrackerProvider.get();
        }
    }

    private DaggerHelpCenterFeatureComponent() {
    }

    public static HelpCenterFeatureComponent.Factory factory() {
        return new Factory();
    }
}
