package com.talabat.feature.pickup.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.pickup.data.PickupApi;
import com.talabat.feature.pickup.data.PickupBaseUrl;
import com.talabat.feature.pickup.data.PickupRepositoryImpl;
import com.talabat.feature.pickup.data.PickupSharedPreferences;
import com.talabat.feature.pickup.data.di.PickupFeatureComponent;
import com.talabat.feature.pickup.data.local.InMemoryDataSource;
import com.talabat.feature.pickup.domain.PickupRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerPickupFeatureComponent {

    public static final class Factory implements PickupFeatureComponent.Factory {
        private Factory() {
        }

        public PickupFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new PickupFeatureComponentImpl(configurationLocalCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class PickupFeatureComponentImpl implements PickupFeatureComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ContextCoreLibApi contextCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final NetworkCoreLibApi networkCoreLibApi;
        private final PickupFeatureComponentImpl pickupFeatureComponentImpl;

        private PickupFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ContextCoreLibApi contextCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, NetworkCoreLibApi networkCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi) {
            this.pickupFeatureComponentImpl = this;
            this.networkCoreLibApi = networkCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.contextCoreLibApi = contextCoreLibApi2;
        }

        private PickupApi pickupApi() {
            return PickupNetworkModule_ProvidePickupApiFactory.providePickupApi(string(), (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient()), (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithGson()));
        }

        private PickupRepositoryImpl pickupRepositoryImpl() {
            return new PickupRepositoryImpl(pickupApi(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()), PickupFeatureModule_ProvideVendorTagsUseCaseFactory.provideVendorTagsUseCase(), pickupSharedPreferences(), new InMemoryDataSource());
        }

        private PickupSharedPreferences pickupSharedPreferences() {
            return new PickupSharedPreferences(sharedPreferences());
        }

        private SharedPreferences sharedPreferences() {
            return PickupFeatureModule_ProvideSharedPrefsFactory.provideSharedPrefs((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private String string() {
            return PickupNetworkModule_ProvideBaseUrlFactory.provideBaseUrl((BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory()), new PickupBaseUrl());
        }

        public PickupRepository getRepository() {
            return PickupFeatureModule_ProvideRepositoryFactory.provideRepository(pickupRepositoryImpl());
        }
    }

    private DaggerPickupFeatureComponent() {
    }

    public static PickupFeatureComponent.Factory factory() {
        return new Factory();
    }
}
