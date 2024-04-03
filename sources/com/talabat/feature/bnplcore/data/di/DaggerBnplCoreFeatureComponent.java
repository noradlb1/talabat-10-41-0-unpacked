package com.talabat.feature.bnplcore.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.bnplcore.data.di.BnplCoreFeatureComponent;
import com.talabat.feature.bnplcore.data.remote.BnplApi;
import com.talabat.feature.bnplcore.data.remote.BnplCoreFeatureBaseUrl_Factory;
import com.talabat.feature.bnplcore.data.repository.BnplRepositoryImpl;
import com.talabat.feature.bnplcore.data.repository.BnplRepositoryImpl_Factory;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.BNPLCoreFlutterChannel;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueNotificationAcknowledgeUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueNotificationAcknowledgeUseCaseImpl_Factory;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueUseCaseImpl_Factory;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.SendNavigationOptionLoadedEventUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.SendNavigationOptionLoadedEventUseCaseImpl_Factory;
import com.talabat.feature.bnplcore.domain.usecase.impl.UpdateOverdueAcknowledgeStateUseCaseImpl;
import com.talabat.feature.bnplcore.domain.usecase.impl.UpdateOverdueAcknowledgeStateUseCaseImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerBnplCoreFeatureComponent {

    public static final class BnplCoreFeatureComponentImpl implements BnplCoreFeatureComponent {
        private final BnplCoreFeatureComponentImpl bnplCoreFeatureComponentImpl;
        private Provider<BnplRepositoryImpl> bnplRepositoryImplProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Map<Class<?>, Provider<PlatformChannel>>> getChannelsProvider;
        private Provider<Context> getContextProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<GetOverdueNotificationAcknowledgeUseCaseImpl> getOverdueNotificationAcknowledgeUseCaseImplProvider;
        private Provider<GetOverdueUseCaseImpl> getOverdueUseCaseImplProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<BnplApi> provideBNPLApiProvider;
        private Provider<BNPLCoreFlutterChannel> provideBNPLCoreFlutterChannelProvider;
        private Provider<BnplRepository> provideBNPLRepositoryProvider;
        private Provider<FlutterEngine> provideFlutterEngineProvider;
        private Provider<GetOverdueUseCase> provideGetOverdueUseCaseProvider;
        private Provider<GetOverdueNotificationAcknowledgeUseCase> provideIsOverdueNotificationAcknowledgeUseCaseProvider;
        private Provider<Retrofit> provideRetrofitProvider;
        private Provider<SendNavigationOptionLoadedEventUseCase> provideSendNavigationOptionLoadedEventUseCaseProvider;
        private Provider<UpdateOverdueAcknowledgeStateUseCase> provideUpdateOverdueAcknowledgeStateUseCaseProvider;
        private Provider<SendNavigationOptionLoadedEventUseCaseImpl> sendNavigationOptionLoadedEventUseCaseImplProvider;
        private Provider<UpdateOverdueAcknowledgeStateUseCaseImpl> updateOverdueAcknowledgeStateUseCaseImplProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
            }
        }

        public static final class GetChannelsProvider implements Provider<Map<Class<?>, Provider<PlatformChannel>>> {
            private final FlutterChannelsCoreLibApi flutterChannelsCoreLibApi;

            public GetChannelsProvider(FlutterChannelsCoreLibApi flutterChannelsCoreLibApi2) {
                this.flutterChannelsCoreLibApi = flutterChannelsCoreLibApi2;
            }

            public Map<Class<?>, Provider<PlatformChannel>> get() {
                return (Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels());
            }
        }

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
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

        public static final class GetTalabatTrackerProvider implements Provider<TalabatTracker> {
            private final TrackingCoreLibApi trackingCoreLibApi;

            public GetTalabatTrackerProvider(TrackingCoreLibApi trackingCoreLibApi2) {
                this.trackingCoreLibApi = trackingCoreLibApi2;
            }

            public TalabatTracker get() {
                return (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker());
            }
        }

        private BnplCoreFeatureComponentImpl(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            this.bnplCoreFeatureComponentImpl = this;
            initialize(contextCoreLibApi, featureFlagCoreLibApi, flutterEngineCoreLibApi, flutterChannelsCoreLibApi, networkCoreLibApi, trackingCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            Provider<Retrofit> provider = SingleCheck.provider(BnplNetworkModule_ProvideRetrofitFactory.create(this.getRetrofitWithMoshiProvider, this.getOkHttpClientProvider, BnplCoreFeatureBaseUrl_Factory.create(), this.getBaseUrlFactoryProvider));
            this.provideRetrofitProvider = provider;
            Provider<BnplApi> provider2 = SingleCheck.provider(BnplNetworkModule_ProvideBNPLApiFactory.create(provider));
            this.provideBNPLApiProvider = provider2;
            BnplRepositoryImpl_Factory create = BnplRepositoryImpl_Factory.create(provider2);
            this.bnplRepositoryImplProvider = create;
            this.provideBNPLRepositoryProvider = SingleCheck.provider(create);
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            GetOverdueUseCaseImpl_Factory create2 = GetOverdueUseCaseImpl_Factory.create(this.provideBNPLRepositoryProvider, getTalabatFeatureFlagProvider2);
            this.getOverdueUseCaseImplProvider = create2;
            this.provideGetOverdueUseCaseProvider = SingleCheck.provider(create2);
            GetOverdueNotificationAcknowledgeUseCaseImpl_Factory create3 = GetOverdueNotificationAcknowledgeUseCaseImpl_Factory.create(this.provideBNPLRepositoryProvider, this.getTalabatFeatureFlagProvider);
            this.getOverdueNotificationAcknowledgeUseCaseImplProvider = create3;
            this.provideIsOverdueNotificationAcknowledgeUseCaseProvider = SingleCheck.provider(create3);
            UpdateOverdueAcknowledgeStateUseCaseImpl_Factory create4 = UpdateOverdueAcknowledgeStateUseCaseImpl_Factory.create(this.provideBNPLRepositoryProvider, this.getTalabatFeatureFlagProvider);
            this.updateOverdueAcknowledgeStateUseCaseImplProvider = create4;
            this.provideUpdateOverdueAcknowledgeStateUseCaseProvider = SingleCheck.provider(create4);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            SendNavigationOptionLoadedEventUseCaseImpl_Factory create5 = SendNavigationOptionLoadedEventUseCaseImpl_Factory.create(getTalabatTrackerProvider2);
            this.sendNavigationOptionLoadedEventUseCaseImplProvider = create5;
            this.provideSendNavigationOptionLoadedEventUseCaseProvider = SingleCheck.provider(create5);
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            this.provideFlutterEngineProvider = SingleCheck.provider(BnplNetworkModule_ProvideFlutterEngineFactory.create(getContextProvider2));
            GetChannelsProvider getChannelsProvider2 = new GetChannelsProvider(flutterChannelsCoreLibApi);
            this.getChannelsProvider = getChannelsProvider2;
            this.provideBNPLCoreFlutterChannelProvider = SingleCheck.provider(BnplNetworkModule_ProvideBNPLCoreFlutterChannelFactory.create(this.provideFlutterEngineProvider, getChannelsProvider2));
        }

        public GetOverdueUseCase getBnplOverduesUseCase() {
            return this.provideGetOverdueUseCaseProvider.get();
        }

        public GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase() {
            return this.provideIsOverdueNotificationAcknowledgeUseCaseProvider.get();
        }

        public IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase() {
            return new IsUserBNPLEligibleUseCase(this.provideBNPLCoreFlutterChannelProvider.get());
        }

        public SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase() {
            return this.provideSendNavigationOptionLoadedEventUseCaseProvider.get();
        }

        public UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase() {
            return this.provideUpdateOverdueAcknowledgeStateUseCaseProvider.get();
        }
    }

    public static final class Factory implements BnplCoreFeatureComponent.Factory {
        private Factory() {
        }

        public BnplCoreFeatureComponent create(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(flutterEngineCoreLibApi);
            Preconditions.checkNotNull(flutterChannelsCoreLibApi);
            return new BnplCoreFeatureComponentImpl(contextCoreLibApi, featureFlagCoreLibApi, flutterEngineCoreLibApi, flutterChannelsCoreLibApi, networkCoreLibApi, trackingCoreLibApi);
        }
    }

    private DaggerBnplCoreFeatureComponent() {
    }

    public static BnplCoreFeatureComponent.Factory factory() {
        return new Factory();
    }
}
