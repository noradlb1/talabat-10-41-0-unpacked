package com.talabat.feature.tmart.growth.data.di;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository_Factory;
import com.talabat.feature.tmart.growth.data.TMartGrowthRepository;
import com.talabat.feature.tmart.growth.data.TMartGrowthRepository_Factory;
import com.talabat.feature.tmart.growth.data.di.TMartGrowthFeatureComponent;
import com.talabat.feature.tmart.growth.data.files.FileDownloadManager;
import com.talabat.feature.tmart.growth.data.files.FileDownloadManager_Factory;
import com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager;
import com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager_Factory;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import com.talabat.feature.tmart.growth.data.tracking.TMartGrowthTracker;
import com.talabat.feature.tmart.growth.data.tracking.TMartGrowthTracker_Factory;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.io.File;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@DaggerGenerated
public final class DaggerTMartGrowthFeatureComponent {

    public static final class Factory implements TMartGrowthFeatureComponent.Factory {
        private Factory() {
        }

        public TMartGrowthFeatureComponent create(SecretCoreLibApi secretCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            return new TMartGrowthFeatureComponentImpl(secretCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi);
        }
    }

    public static final class TMartGrowthFeatureComponentImpl implements TMartGrowthFeatureComponent {
        private Provider<FileDownloadManager> fileDownloadManagerProvider;
        private Provider<ITMartGrowthFileManager> fileManagerProvider;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<ConfigurationLocalRepository> provideConfigurationLocalRepositoryProvider;
        private Provider<String> provideCountryCodeProvider;
        private Provider<Country> provideCountryProvider;
        private Provider<DiskCache> provideDiskCacheProvider;
        private Provider<File> provideFileDirectoryProvider;
        private Provider<TMartGrowthApi> provideTMartGrowthApiProvider;
        private Provider<ITMartGrowthReminderRepository> reminderRepositoryProvider;
        private Provider<ITMartGrowthRepository> repositoryProvider;
        private final TMartGrowthFeatureComponentImpl tMartGrowthFeatureComponentImpl;
        private Provider<TMartGrowthFileManager> tMartGrowthFileManagerProvider;
        private Provider<TMartGrowthReminderRepository> tMartGrowthReminderRepositoryProvider;
        private Provider<TMartGrowthRepository> tMartGrowthRepositoryProvider;
        private Provider<TMartGrowthTracker> tMartGrowthTrackerProvider;
        private Provider<ITMartGrowthTracker> trackerProvider;

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

        public static final class GetOkHttpClientProvider implements Provider<OkHttpClient> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetOkHttpClientProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public OkHttpClient get() {
                return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient());
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

        private TMartGrowthFeatureComponentImpl(SecretCoreLibApi secretCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            this.tMartGrowthFeatureComponentImpl = this;
            initialize(secretCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi);
        }

        private void initialize(SecretCoreLibApi secretCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            TMartGrowthUserDataModule_ProvideConfigurationLocalRepositoryFactory create = TMartGrowthUserDataModule_ProvideConfigurationLocalRepositoryFactory.create(getContextProvider2);
            this.provideConfigurationLocalRepositoryProvider = create;
            TMartGrowthUserDataModule_ProvideCountryFactory create2 = TMartGrowthUserDataModule_ProvideCountryFactory.create(create);
            this.provideCountryProvider = create2;
            this.provideCountryCodeProvider = TMartGrowthUserDataModule_ProvideCountryCodeFactory.create(create2);
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi);
            this.getSecretProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.provideTMartGrowthApiProvider = TMartGrowthNetworkModule_ProvideTMartGrowthApiFactory.create(TMartGrowthNetworkModule_ProvideBaseUrlFactory.create(), TMartGrowthNetworkModule_ProvideFeatureMoshiFactory.create(), this.getOkHttpClientProvider, this.getSecretProvider);
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            TMartGrowthRepository_Factory create3 = TMartGrowthRepository_Factory.create(this.provideCountryCodeProvider, this.provideTMartGrowthApiProvider, TMartGrowthUserDataModule_ProvideGlobalDataModelFactory.create(), this.getCoroutineDispatchersFactoryProvider);
            this.tMartGrowthRepositoryProvider = create3;
            this.repositoryProvider = SingleCheck.provider(create3);
            TMartGrowthReminderRepository_Factory create4 = TMartGrowthReminderRepository_Factory.create(this.provideCountryCodeProvider, TMartGrowthUserDataModule_ProvideGlobalDataModelFactory.create(), this.provideTMartGrowthApiProvider);
            this.tMartGrowthReminderRepositoryProvider = create4;
            this.reminderRepositoryProvider = SingleCheck.provider(create4);
            TMartGrowthCacheModule_ProvideFileDirectoryFactory create5 = TMartGrowthCacheModule_ProvideFileDirectoryFactory.create(this.getContextProvider);
            this.provideFileDirectoryProvider = create5;
            this.provideDiskCacheProvider = TMartGrowthCacheModule_ProvideDiskCacheFactory.create(create5);
            FileDownloadManager_Factory create6 = FileDownloadManager_Factory.create(this.getOkHttpClientProvider);
            this.fileDownloadManagerProvider = create6;
            TMartGrowthFileManager_Factory create7 = TMartGrowthFileManager_Factory.create(this.provideDiskCacheProvider, create6, this.getCoroutineDispatchersFactoryProvider);
            this.tMartGrowthFileManagerProvider = create7;
            this.fileManagerProvider = SingleCheck.provider(create7);
            TMartGrowthTracker_Factory create8 = TMartGrowthTracker_Factory.create(this.getContextProvider, TMartGrowthTrackingModule_ProvideFirebaseTrackingFactory.create(), TMartGrowthUserDataModule_ProvideGlobalDataModelFactory.create());
            this.tMartGrowthTrackerProvider = create8;
            this.trackerProvider = SingleCheck.provider(create8);
        }

        public ITMartGrowthFileManager getFileManager() {
            return this.fileManagerProvider.get();
        }

        public ITMartGrowthReminderRepository getReminderRepository() {
            return this.reminderRepositoryProvider.get();
        }

        public ITMartGrowthRepository getRepository() {
            return this.repositoryProvider.get();
        }

        public ITMartGrowthTracker getTracker() {
            return this.trackerProvider.get();
        }
    }

    private DaggerTMartGrowthFeatureComponent() {
    }

    public static TMartGrowthFeatureComponent.Factory factory() {
        return new Factory();
    }
}
