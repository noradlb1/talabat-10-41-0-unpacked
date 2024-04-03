package com.talabat.feature.rewards.data.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.rewards.data.RealRewardsMissionRepository;
import com.talabat.feature.rewards.data.RealRewardsMissionRepository_Factory;
import com.talabat.feature.rewards.data.RewardsBaseUrl_Factory;
import com.talabat.feature.rewards.data.di.RewardsFeatureComponent;
import com.talabat.feature.rewards.data.remote.RewardsMissionApi;
import com.talabat.feature.rewards.data.tracking.DefaultMissionTracker;
import com.talabat.feature.rewards.data.tracking.DefaultRewardsTracker;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import com.talabat.feature.rewards.domain.RewardsTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerRewardsFeatureComponent {

    public static final class Factory implements RewardsFeatureComponent.Factory {
        private Factory() {
        }

        public RewardsFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new RewardsFeatureComponentImpl(configurationLocalCoreLibApi, networkCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class RewardsFeatureComponentImpl implements RewardsFeatureComponent {
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<RewardsMissionApi> provideRewardsMissionApiProvider;
        private Provider<RealRewardsMissionRepository> realRewardsMissionRepositoryProvider;
        private final RewardsFeatureComponentImpl rewardsFeatureComponentImpl;
        private Provider<RewardsMissionRepository> rewardsMissionRepositoryProvider;
        private final TrackingCoreLibApi trackingCoreLibApi;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
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

        private RewardsFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2) {
            this.rewardsFeatureComponentImpl = this;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            initialize(configurationLocalCoreLibApi, networkCoreLibApi, trackingCoreLibApi2);
        }

        private DefaultMissionTracker defaultMissionTracker() {
            return new DefaultMissionTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
        }

        private DefaultRewardsTracker defaultRewardsTracker() {
            return new DefaultRewardsTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2) {
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideBaseUrlProvider = RewardsNetworkModule_ProvideBaseUrlFactory.create(getBaseUrlFactoryProvider2, RewardsBaseUrl_Factory.create());
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            GetRetrofitWithMoshiProvider getRetrofitWithMoshiProvider2 = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getRetrofitWithMoshiProvider = getRetrofitWithMoshiProvider2;
            this.provideRewardsMissionApiProvider = RewardsNetworkModule_ProvideRewardsMissionApiFactory.create(this.provideBaseUrlProvider, this.getOkHttpClientProvider, getRetrofitWithMoshiProvider2);
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            RealRewardsMissionRepository_Factory create = RealRewardsMissionRepository_Factory.create(this.provideRewardsMissionApiProvider, getRepositoryProvider2);
            this.realRewardsMissionRepositoryProvider = create;
            this.rewardsMissionRepositoryProvider = SingleCheck.provider(create);
        }

        public MissionTracker getMissionTracker() {
            return defaultMissionTracker();
        }

        public RewardsMissionRepository getRepository() {
            return this.rewardsMissionRepositoryProvider.get();
        }

        public RewardsTracker getRewardsTracker() {
            return defaultRewardsTracker();
        }
    }

    private DaggerRewardsFeatureComponent() {
    }

    public static RewardsFeatureComponent.Factory factory() {
        return new Factory();
    }
}
