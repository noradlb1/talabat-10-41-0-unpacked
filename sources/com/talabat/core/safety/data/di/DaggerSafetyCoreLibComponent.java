package com.talabat.core.safety.data.di;

import android.content.Context;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.safety.data.DefaultSafetyAgent;
import com.talabat.core.safety.data.DefaultSafetyAgent_Factory;
import com.talabat.core.safety.data.datasource.api.SafetyApi;
import com.talabat.core.safety.data.datasource.api.playintegrity.PlayIntegrityApi;
import com.talabat.core.safety.data.datasource.api.playintegrity.PlayIntegrityApi_Factory;
import com.talabat.core.safety.data.datasource.availability.AvailabilityCheck;
import com.talabat.core.safety.data.datasource.availability.play.GooglePlayAvailabilityCheck;
import com.talabat.core.safety.data.datasource.availability.play.GooglePlayAvailabilityCheck_Factory;
import com.talabat.core.safety.data.datasource.info.ShieldInfoDtoFactory;
import com.talabat.core.safety.data.datasource.info.impl.DefaultShieldInfoDtoFactory;
import com.talabat.core.safety.data.datasource.info.impl.DefaultShieldInfoDtoFactory_Factory;
import com.talabat.core.safety.data.di.SafetyCoreLibComponent;
import com.talabat.core.safety.data.interceptors.UserAgentInterceptor;
import com.talabat.core.safety.data.interceptors.UserAgentInterceptor_Factory;
import com.talabat.core.safety.data.repository.protection.ProtectionRepository;
import com.talabat.core.safety.data.repository.protection.local.LocalProtectionRepository_Factory;
import com.talabat.core.safety.data.repository.shield.ShieldRepository;
import com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository;
import com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository_Factory;
import com.talabat.core.safety.data.repository.shield.remote.ShieldBaseUrl_Factory;
import com.talabat.core.safety.domain.SafetyAgent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerSafetyCoreLibComponent {

    public static final class Factory implements SafetyCoreLibComponent.Factory {
        private Factory() {
        }

        public SafetyCoreLibComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SecretCoreLibApi secretCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(googleAdvertisementCoreLibApi);
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(talabatPerseusCoreLibApi);
            return new SafetyCoreLibComponentImpl(new PlayIntegrityNetworkModule(), configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, googleAdvertisementCoreLibApi, gmsBaseCoreLibApi, networkCoreLibApi, observabilityCoreLibApi, secretCoreLibApi, talabatPerseusCoreLibApi);
        }
    }

    public static final class SafetyCoreLibComponentImpl implements SafetyCoreLibComponent {
        private Provider<String> androidIdProvider;
        private Provider<AvailabilityCheck> availabilityCheckProvider;
        private Provider<DefaultSafetyAgent> defaultSafetyAgentProvider;
        private Provider<DefaultShieldInfoDtoFactory> defaultShieldInfoDtoFactoryProvider;
        private Provider<ShieldInfoDtoFactory> dtoFactoryProvider;
        private Provider<AppVersionProvider> getAppVersionProvider;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<GoogleAdvertisementRepository> getGoogleAdvertisementRepositoryProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<TalabatPerseusRepository> getTalabatPerseusRepositoryProvider;
        private Provider<GooglePlayAvailabilityCheck> googlePlayAvailabilityCheckProvider;
        private Provider<String> installationPathProvider;
        private Provider<Interceptor> interceptorProvider;
        private Provider<Boolean> isGmsAvailableProvider;
        private Provider<String> packageNameProvider;
        private Provider<PlayIntegrityApi> playIntegrityApiProvider;
        private Provider<ProtectionRepository> protectionRepositoryProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<ShieldRepository> remoteRepositoryProvider;
        private Provider<RemoteShieldRepository> remoteShieldRepositoryProvider;
        private Provider<Retrofit> retrofitProvider;
        private Provider<SafetyAgent> safetyAgentProvider;
        private final SafetyCoreLibComponentImpl safetyCoreLibComponentImpl;
        private Provider<SafetyApi> safetyNetApiProvider;
        private Provider<UserAgentInterceptor> userAgentInterceptorProvider;

        public static final class GetAppVersionProviderProvider implements Provider<AppVersionProvider> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetAppVersionProviderProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public AppVersionProvider get() {
                return (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider());
            }
        }

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
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

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        public static final class GetGoogleAdvertisementRepositoryProvider implements Provider<GoogleAdvertisementRepository> {
            private final GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi;

            public GetGoogleAdvertisementRepositoryProvider(GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi2) {
                this.googleAdvertisementCoreLibApi = googleAdvertisementCoreLibApi2;
            }

            public GoogleAdvertisementRepository get() {
                return (GoogleAdvertisementRepository) Preconditions.checkNotNullFromComponent(this.googleAdvertisementCoreLibApi.getGoogleAdvertisementRepository());
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

        public static final class GetSecretProviderProvider implements Provider<SecretProvider> {
            private final SecretCoreLibApi secretCoreLibApi;

            public GetSecretProviderProvider(SecretCoreLibApi secretCoreLibApi2) {
                this.secretCoreLibApi = secretCoreLibApi2;
            }

            public SecretProvider get() {
                return (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider());
            }
        }

        public static final class GetTalabatPerseusRepositoryProvider implements Provider<TalabatPerseusRepository> {
            private final TalabatPerseusCoreLibApi talabatPerseusCoreLibApi;

            public GetTalabatPerseusRepositoryProvider(TalabatPerseusCoreLibApi talabatPerseusCoreLibApi2) {
                this.talabatPerseusCoreLibApi = talabatPerseusCoreLibApi2;
            }

            public TalabatPerseusRepository get() {
                return (TalabatPerseusRepository) Preconditions.checkNotNullFromComponent(this.talabatPerseusCoreLibApi.getTalabatPerseusRepository());
            }
        }

        public static final class IsGmsAvailableProvider implements Provider<Boolean> {
            private final GmsBaseCoreLibApi gmsBaseCoreLibApi;

            public IsGmsAvailableProvider(GmsBaseCoreLibApi gmsBaseCoreLibApi2) {
                this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            }

            public Boolean get() {
                return Boolean.valueOf(this.gmsBaseCoreLibApi.isGmsAvailable());
            }
        }

        private SafetyCoreLibComponentImpl(PlayIntegrityNetworkModule playIntegrityNetworkModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SecretCoreLibApi secretCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            this.safetyCoreLibComponentImpl = this;
            initialize(playIntegrityNetworkModule, configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, googleAdvertisementCoreLibApi, gmsBaseCoreLibApi, networkCoreLibApi, observabilityCoreLibApi, secretCoreLibApi, talabatPerseusCoreLibApi);
        }

        private void initialize(PlayIntegrityNetworkModule playIntegrityNetworkModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SecretCoreLibApi secretCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
            PlayIntegrityNetworkModule playIntegrityNetworkModule2 = playIntegrityNetworkModule;
            NetworkCoreLibApi networkCoreLibApi2 = networkCoreLibApi;
            ContextCoreLibApi contextCoreLibApi2 = contextCoreLibApi;
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            PlayIntegrityApi_Factory create = PlayIntegrityApi_Factory.create(getContextProvider2);
            this.playIntegrityApiProvider = create;
            this.safetyNetApiProvider = SingleCheck.provider(create);
            this.isGmsAvailableProvider = new IsGmsAvailableProvider(gmsBaseCoreLibApi);
            GooglePlayAvailabilityCheck_Factory create2 = GooglePlayAvailabilityCheck_Factory.create(IdentifiersModule_DebugValueFactory.create(), this.isGmsAvailableProvider);
            this.googlePlayAvailabilityCheckProvider = create2;
            this.availabilityCheckProvider = SingleCheck.provider(create2);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi2);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi2);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideBaseUrlProvider = PlayIntegrityNetworkModule_ProvideBaseUrlFactory.create(playIntegrityNetworkModule, getBaseUrlFactoryProvider2, ShieldBaseUrl_Factory.create());
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi2);
            ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2 = configurationRemoteCoreLibApi;
            GetAppVersionProviderProvider getAppVersionProviderProvider = new GetAppVersionProviderProvider(configurationRemoteCoreLibApi);
            this.getAppVersionProvider = getAppVersionProviderProvider;
            UserAgentInterceptor_Factory create3 = UserAgentInterceptor_Factory.create(getAppVersionProviderProvider);
            this.userAgentInterceptorProvider = create3;
            Provider<Interceptor> provider = SingleCheck.provider(PlayIntegrityNetworkModule_InterceptorFactory.create(playIntegrityNetworkModule, create3));
            this.interceptorProvider = provider;
            this.retrofitProvider = SingleCheck.provider(PlayIntegrityNetworkModule_RetrofitFactory.create(playIntegrityNetworkModule, this.getOkHttpClientProvider, this.provideBaseUrlProvider, this.getRetrofitWithMoshiProvider, provider));
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getGoogleAdvertisementRepositoryProvider = new GetGoogleAdvertisementRepositoryProvider(googleAdvertisementCoreLibApi);
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.getTalabatPerseusRepositoryProvider = new GetTalabatPerseusRepositoryProvider(talabatPerseusCoreLibApi);
            this.androidIdProvider = IdentifiersModule_AndroidIdFactory.create(this.getContextProvider);
            this.packageNameProvider = IdentifiersModule_PackageNameFactory.create(this.getContextProvider);
            IdentifiersModule_InstallationPathFactory create4 = IdentifiersModule_InstallationPathFactory.create(this.getContextProvider);
            this.installationPathProvider = create4;
            DefaultShieldInfoDtoFactory_Factory create5 = DefaultShieldInfoDtoFactory_Factory.create(this.getGoogleAdvertisementRepositoryProvider, this.getAppVersionProvider, this.getRepositoryProvider, this.getTalabatPerseusRepositoryProvider, this.androidIdProvider, this.packageNameProvider, create4, IdentifiersModule_DeviceModelFactory.create());
            this.defaultShieldInfoDtoFactoryProvider = create5;
            Provider<ShieldInfoDtoFactory> provider2 = SingleCheck.provider(create5);
            this.dtoFactoryProvider = provider2;
            RemoteShieldRepository_Factory create6 = RemoteShieldRepository_Factory.create(this.retrofitProvider, this.getObservabilityManagerProvider, provider2);
            this.remoteShieldRepositoryProvider = create6;
            this.remoteRepositoryProvider = SingleCheck.provider(create6);
            this.protectionRepositoryProvider = SingleCheck.provider(LocalProtectionRepository_Factory.create());
            DispatcherCoreLibApi dispatcherCoreLibApi2 = dispatcherCoreLibApi;
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getSecretProvider = getSecretProviderProvider;
            DefaultSafetyAgent_Factory create7 = DefaultSafetyAgent_Factory.create(this.safetyNetApiProvider, this.availabilityCheckProvider, this.remoteRepositoryProvider, this.getObservabilityManagerProvider, this.protectionRepositoryProvider, this.getCoroutineDispatchersFactoryProvider, getSecretProviderProvider);
            this.defaultSafetyAgentProvider = create7;
            this.safetyAgentProvider = SingleCheck.provider(create7);
        }

        public SafetyAgent getSafetyAgent() {
            return this.safetyAgentProvider.get();
        }
    }

    private DaggerSafetyCoreLibComponent() {
    }

    public static SafetyCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
