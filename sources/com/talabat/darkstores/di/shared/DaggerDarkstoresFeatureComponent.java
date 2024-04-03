package com.talabat.darkstores.di.shared;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.darkstores.data.Environment;
import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl;
import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl_Factory;
import com.talabat.darkstores.data.vendors.remote.VendorsApi;
import com.talabat.darkstores.di.DarkstoresApiModule_ProvideTalabatApiBuilderFactory;
import com.talabat.darkstores.di.DarkstoresApiModule_ProvideVendorsApiFactory;
import com.talabat.darkstores.di.DarkstoresDatabaseModule;
import com.talabat.darkstores.di.DarkstoresDatabaseModule_ProvideSharedPreferencesFactory;
import com.talabat.darkstores.di.DarkstoresNetworkModule_ProvideVendorBaseUrlFactory;
import com.talabat.darkstores.di.DarkstoresSchedulersModule_ProvideIoSchedulerFactory;
import com.talabat.darkstores.di.DarkstoresUserDataModule_ProvideSelectedAreaIdFactory;
import com.talabat.darkstores.di.DarkstoresUserDataModule_ProvideSelectedCountryIdFactory;
import com.talabat.darkstores.di.DarkstoresUserDataModule_ProvideSelectedLatitudeFactory;
import com.talabat.darkstores.di.DarkstoresUserDataModule_ProvideSelectedLongitudeFactory;
import com.talabat.darkstores.di.shared.DarkstoresFeatureComponent;
import com.talabat.darkstores.domain.naivgator.DarkstoresNavigatorImpl;
import com.talabat.darkstores.domain.naivgator.DarkstoresNavigatorImpl_Factory;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDarkstoresFeatureComponent {

    public static final class DarkstoresFeatureComponentImpl implements DarkstoresFeatureComponent {
        private Provider<DarkstoresCartRepository> cartRepositoryProvider;
        private final DarkstoresFeatureComponentImpl darkstoresFeatureComponentImpl;
        private Provider<DarkstoresNavigatorImpl> darkstoresNavigatorImplProvider;
        private Provider<DarkstoresRepositoryImpl> darkstoresRepositoryImplProvider;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<DeepLinkNavigator> getDeepLinkNavigatorProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<Navigator> getNavigatorProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<DarkstoresNavigator> provideDarkstoresNavigatorProvider;
        private Provider<DarkstoresRepository> provideDarkstoresRepositoryProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<TalabatAPIBuilder> provideTalabatApiBuilderProvider;
        private Provider<String> provideVendorBaseUrlProvider;
        private Provider<VendorsApi> provideVendorsApiProvider;

        public static final class CartRepositoryProvider implements Provider<DarkstoresCartRepository> {
            private final DarkstoresCartApi darkstoresCartApi;

            public CartRepositoryProvider(DarkstoresCartApi darkstoresCartApi2) {
                this.darkstoresCartApi = darkstoresCartApi2;
            }

            public DarkstoresCartRepository get() {
                return (DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository());
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

        public static final class GetDeepLinkNavigatorProvider implements Provider<DeepLinkNavigator> {
            private final DeepLinkCoreLibApi deepLinkCoreLibApi;

            public GetDeepLinkNavigatorProvider(DeepLinkCoreLibApi deepLinkCoreLibApi2) {
                this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            }

            public DeepLinkNavigator get() {
                return (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator());
            }
        }

        public static final class GetGsonProvider implements Provider<Gson> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetGsonProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Gson get() {
                return (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson());
            }
        }

        public static final class GetNavigatorProvider implements Provider<Navigator> {
            private final NavigationCoreLibApi navigationCoreLibApi;

            public GetNavigatorProvider(NavigationCoreLibApi navigationCoreLibApi2) {
                this.navigationCoreLibApi = navigationCoreLibApi2;
            }

            public Navigator get() {
                return (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator());
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

        private DarkstoresFeatureComponentImpl(DarkstoresDatabaseModule darkstoresDatabaseModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DarkstoresCartApi darkstoresCartApi, DeepLinkCoreLibApi deepLinkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, ParserCoreLibApi parserCoreLibApi, Environment environment) {
            this.darkstoresFeatureComponentImpl = this;
            initialize(darkstoresDatabaseModule, configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, darkstoresCartApi, deepLinkCoreLibApi, dispatcherCoreLibApi, navigationCoreLibApi, parserCoreLibApi, environment);
        }

        private void initialize(DarkstoresDatabaseModule darkstoresDatabaseModule, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DarkstoresCartApi darkstoresCartApi, DeepLinkCoreLibApi deepLinkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, ParserCoreLibApi parserCoreLibApi, Environment environment) {
            this.cartRepositoryProvider = new CartRepositoryProvider(darkstoresCartApi);
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            DarkstoresDatabaseModule darkstoresDatabaseModule2 = darkstoresDatabaseModule;
            this.provideSharedPreferencesProvider = DarkstoresDatabaseModule_ProvideSharedPreferencesFactory.create(darkstoresDatabaseModule, getContextProvider2);
            this.provideTalabatApiBuilderProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideTalabatApiBuilderFactory.create());
            Provider<String> provider = DoubleCheck.provider(DarkstoresNetworkModule_ProvideVendorBaseUrlFactory.create());
            this.provideVendorBaseUrlProvider = provider;
            this.provideVendorsApiProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideVendorsApiFactory.create(this.provideTalabatApiBuilderProvider, provider));
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getGsonProvider = new GetGsonProvider(parserCoreLibApi);
            DarkstoresRepositoryImpl_Factory create = DarkstoresRepositoryImpl_Factory.create(this.cartRepositoryProvider, this.provideSharedPreferencesProvider, this.provideVendorsApiProvider, DarkstoresUserDataModule_ProvideSelectedAreaIdFactory.create(), DarkstoresUserDataModule_ProvideSelectedLatitudeFactory.create(), DarkstoresUserDataModule_ProvideSelectedLongitudeFactory.create(), DarkstoresUserDataModule_ProvideSelectedCountryIdFactory.create(), DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create(), this.getCoroutineDispatchersFactoryProvider, this.getGsonProvider);
            this.darkstoresRepositoryImplProvider = create;
            this.provideDarkstoresRepositoryProvider = SingleCheck.provider(create);
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.getDeepLinkNavigatorProvider = new GetDeepLinkNavigatorProvider(deepLinkCoreLibApi);
            GetNavigatorProvider getNavigatorProvider2 = new GetNavigatorProvider(navigationCoreLibApi);
            this.getNavigatorProvider = getNavigatorProvider2;
            DarkstoresNavigatorImpl_Factory create2 = DarkstoresNavigatorImpl_Factory.create(this.getRepositoryProvider, this.getDeepLinkNavigatorProvider, getNavigatorProvider2, this.getCoroutineDispatchersFactoryProvider);
            this.darkstoresNavigatorImplProvider = create2;
            this.provideDarkstoresNavigatorProvider = SingleCheck.provider(create2);
        }

        public DarkstoresNavigator darkstoresNavigator() {
            return this.provideDarkstoresNavigatorProvider.get();
        }

        public DarkstoresRepository darkstoresRepository() {
            return this.provideDarkstoresRepositoryProvider.get();
        }
    }

    public static final class Factory implements DarkstoresFeatureComponent.Factory {
        private Factory() {
        }

        public DarkstoresFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, DarkstoresCartApi darkstoresCartApi, DeepLinkCoreLibApi deepLinkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, Environment environment, ParserCoreLibApi parserCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(darkstoresCartApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(environment);
            Preconditions.checkNotNull(parserCoreLibApi);
            return new DarkstoresFeatureComponentImpl(new DarkstoresDatabaseModule(), configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, darkstoresCartApi, deepLinkCoreLibApi, dispatcherCoreLibApi, navigationCoreLibApi, parserCoreLibApi, environment);
        }
    }

    private DaggerDarkstoresFeatureComponent() {
    }

    public static DarkstoresFeatureComponent.Factory factory() {
        return new Factory();
    }
}
