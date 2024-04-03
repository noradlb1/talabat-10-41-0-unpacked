package com.talabat.feature.fees.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.fees.data.di.FeesFeatureComponent;
import com.talabat.feature.fees.data.local.InMemoryFeesDataSource_Factory;
import com.talabat.feature.fees.data.local.LocalFeesDataSource;
import com.talabat.feature.fees.data.mapper.FeesMapper;
import com.talabat.feature.fees.data.remote.PricingApi;
import com.talabat.feature.fees.data.repository.DisclaimerRepository;
import com.talabat.feature.fees.data.repository.PricingRepository;
import com.talabat.feature.fees.data.tracking.FeesTracker;
import com.talabat.feature.fees.domain.IFeesTracker;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.feature.fees.domain.repository.IPricingRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerFeesFeatureComponent {

    public static final class Factory implements FeesFeatureComponent.Factory {
        private Factory() {
        }

        public FeesFeatureComponent create(NetworkCoreLibApi networkCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            return new FeesFeatureComponentImpl(networkCoreLibApi, configurationLocalCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, contextCoreLibApi);
        }
    }

    public static final class FeesFeatureComponentImpl implements FeesFeatureComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ContextCoreLibApi contextCoreLibApi;
        private final FeesFeatureComponentImpl feesFeatureComponentImpl;
        private Provider<LocalFeesDataSource> localFeesDataSourceProvider;
        private final NetworkCoreLibApi networkCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private FeesFeatureComponentImpl(NetworkCoreLibApi networkCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi, ContextCoreLibApi contextCoreLibApi2) {
            this.feesFeatureComponentImpl = this;
            this.networkCoreLibApi = networkCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            initialize(networkCoreLibApi2, configurationLocalCoreLibApi2, trackingCoreLibApi2, featureFlagCoreLibApi, contextCoreLibApi2);
        }

        private DisclaimerRepository disclaimerRepository() {
            return new DisclaimerRepository(namedSharedPreferences());
        }

        private FeesTracker feesTracker() {
            return new FeesTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()), UserDataModule.INSTANCE.provideShopId());
        }

        private void initialize(NetworkCoreLibApi networkCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi, ContextCoreLibApi contextCoreLibApi2) {
            this.localFeesDataSourceProvider = SingleCheck.provider(InMemoryFeesDataSource_Factory.create());
        }

        private int namedInteger() {
            return UserDataModule.INSTANCE.provideCountryId(this.configurationLocalCoreLibApi);
        }

        private SharedPreferences namedSharedPreferences() {
            return FeesLocalModule_ProvideSharedPreferencesFactory.provideSharedPreferences((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private PricingApi pricingApi() {
            return FeesRemoteModule_ProvideFeesApiFactory.provideFeesApi(FeesRemoteModule_ProvideBaseUrlFactory.provideBaseUrl(), (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient()), (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithMoshi()));
        }

        private PricingRepository pricingRepository() {
            return new PricingRepository(pricingApi(), this.localFeesDataSourceProvider.get(), new FeesMapper(), namedInteger(), UserDataModule.INSTANCE.provideShopId(), UserDataModule_ProvideDeliveryModeFactory.provideDeliveryMode());
        }

        public IDisclaimerRepository getDisclaimerRepository() {
            return disclaimerRepository();
        }

        public IPricingRepository getPricingRepository() {
            return pricingRepository();
        }

        public IFeesTracker getTracker() {
            return feesTracker();
        }
    }

    private DaggerFeesFeatureComponent() {
    }

    public static FeesFeatureComponent.Factory factory() {
        return new Factory();
    }
}
