package com.talabat.feature.mission.control.data.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.mission.control.data.RealMissionControlRepository;
import com.talabat.feature.mission.control.data.RealMissionControlRepository_Factory;
import com.talabat.feature.mission.control.data.di.MissionControlFeatureComponent;
import com.talabat.feature.mission.control.data.remote.GroceryBaseUrl_Factory;
import com.talabat.feature.mission.control.data.remote.LifeStyleMissionControlApi;
import com.talabat.feature.mission.control.data.remote.PrimaryMissionControlApi;
import com.talabat.feature.mission.control.data.remote.mapper.LifeStyleMissionControlMapper_Factory;
import com.talabat.feature.mission.control.data.remote.mapper.PrimaryMissionControlMapper_Factory;
import com.talabat.feature.mission.control.domain.MissionControlRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerMissionControlFeatureComponent {

    public static final class Factory implements MissionControlFeatureComponent.Factory {
        private Factory() {
        }

        public MissionControlFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new MissionControlFeatureComponentImpl(configurationLocalCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class MissionControlFeatureComponentImpl implements MissionControlFeatureComponent {
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private final MissionControlFeatureComponentImpl missionControlFeatureComponentImpl;
        private Provider<MissionControlRepository> missionControlRepositoryProvider;
        private Provider<LifeStyleMissionControlApi> provideLifeStyleMissionControlApiProvider;
        private Provider<PrimaryMissionControlApi> providePrimaryMissionControlApiProvider;
        private Provider<String> provideQCommerceGroceryBaseUrlProvider;
        private Provider<RealMissionControlRepository> realMissionControlRepositoryProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
            }
        }

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetOkHttpClientProvider implements Provider<OkHttpClient> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetOkHttpClientProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public OkHttpClient get() {
                return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
            }
        }

        public static final class GetRetrofitWithMoshiProvider implements Provider<Retrofit.Builder> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetRetrofitWithMoshiProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public Retrofit.Builder get() {
                return (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithMoshi());
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

        private MissionControlFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.missionControlFeatureComponentImpl = this;
            initialize(configurationLocalCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, observabilityCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideQCommerceGroceryBaseUrlProvider = MissionControlNetworkModule_ProvideQCommerceGroceryBaseUrlFactory.create(getBaseUrlFactoryProvider2, GroceryBaseUrl_Factory.create());
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetRetrofitWithMoshiProvider getRetrofitWithMoshiProvider2 = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getRetrofitWithMoshiProvider = getRetrofitWithMoshiProvider2;
            this.provideLifeStyleMissionControlApiProvider = MissionControlNetworkModule_ProvideLifeStyleMissionControlApiFactory.create(this.provideQCommerceGroceryBaseUrlProvider, this.getOkHttpClientProvider, getRetrofitWithMoshiProvider2);
            this.providePrimaryMissionControlApiProvider = MissionControlNetworkModule_ProvidePrimaryMissionControlApiFactory.create(this.provideQCommerceGroceryBaseUrlProvider, this.getOkHttpClientProvider, this.getRetrofitWithMoshiProvider);
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            RealMissionControlRepository_Factory create = RealMissionControlRepository_Factory.create(this.getRepositoryProvider, this.getTalabatFeatureFlagProvider, this.getExperimentProvider, LifeStyleMissionControlMapper_Factory.create(), this.provideLifeStyleMissionControlApiProvider, this.providePrimaryMissionControlApiProvider, this.getObservabilityManagerProvider, PrimaryMissionControlMapper_Factory.create());
            this.realMissionControlRepositoryProvider = create;
            this.missionControlRepositoryProvider = SingleCheck.provider(create);
        }

        public MissionControlRepository getRepository() {
            return this.missionControlRepositoryProvider.get();
        }
    }

    private DaggerMissionControlFeatureComponent() {
    }

    public static MissionControlFeatureComponent.Factory factory() {
        return new Factory();
    }
}
