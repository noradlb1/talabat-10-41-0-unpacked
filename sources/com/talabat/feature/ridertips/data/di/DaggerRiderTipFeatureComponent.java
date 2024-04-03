package com.talabat.feature.ridertips.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.ridertips.data.RiderTipRepository;
import com.talabat.feature.ridertips.data.convert.RiderTipResponseToRiderTipMapper;
import com.talabat.feature.ridertips.data.di.RiderTipFeatureComponent;
import com.talabat.feature.ridertips.data.remote.RiderTipApi;
import com.talabat.feature.ridertips.data.tracking.RiderTipTracker;
import com.talabat.feature.ridertips.domain.IRiderTipObservability;
import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import com.talabat.feature.ridertips.domain.IRiderTipTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerRiderTipFeatureComponent {

    public static final class Factory implements RiderTipFeatureComponent.Factory {
        private Factory() {
        }

        public RiderTipFeatureComponent create(ContextCoreLibApi contextCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            return new RiderTipFeatureComponentImpl(contextCoreLibApi, networkCoreLibApi, configurationLocalCoreLibApi, trackingCoreLibApi, experimentCoreLibApi);
        }
    }

    public static final class RiderTipFeatureComponentImpl implements RiderTipFeatureComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final NetworkCoreLibApi networkCoreLibApi;
        private final RiderTipFeatureComponentImpl riderTipFeatureComponentImpl;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private RiderTipFeatureComponentImpl(ContextCoreLibApi contextCoreLibApi, NetworkCoreLibApi networkCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi) {
            this.riderTipFeatureComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.networkCoreLibApi = networkCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
        }

        private int namedInteger() {
            return RiderTipUserDataModule.INSTANCE.provideCountryId(this.configurationLocalCoreLibApi);
        }

        private RiderTipApi riderTipApi() {
            return RiderTipNetworkModule_ProvideRiderTipApiFactory.provideRiderTipApi(RiderTipNetworkModule_ProvideBaseUrlFactory.provideBaseUrl(), (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient()), (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithMoshi()));
        }

        private RiderTipRepository riderTipRepository() {
            return new RiderTipRepository(namedInteger(), riderTipApi(), new RiderTipResponseToRiderTipMapper());
        }

        private RiderTipTracker riderTipTracker() {
            return new RiderTipTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()), RiderTipUserDataModule.INSTANCE.provideShopId());
        }

        public IRiderTipRepository getRepository() {
            return riderTipRepository();
        }

        public IRiderTipObservability getRiderTipObservability() {
            return RiderTipUserDataModule_ProvideRiderTipObservabilityFactory.provideRiderTipObservability();
        }

        public IRiderTipTracker getTracker() {
            return riderTipTracker();
        }
    }

    private DaggerRiderTipFeatureComponent() {
    }

    public static RiderTipFeatureComponent.Factory factory() {
        return new Factory();
    }
}
