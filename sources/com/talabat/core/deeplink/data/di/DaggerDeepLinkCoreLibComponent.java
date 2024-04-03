package com.talabat.core.deeplink.data.di;

import com.talabat.core.deeplink.data.DefaultDeepLinkNavigator;
import com.talabat.core.deeplink.data.DefaultDeepLinkNavigator_Factory;
import com.talabat.core.deeplink.data.di.DeepLinkCoreLibComponent;
import com.talabat.core.deeplink.data.handler.flutter.uiless.DeepLinkFlutterNavigationChannel_Factory;
import com.talabat.core.deeplink.data.handler.flutter.uiless.UiLessFlutterEngineBinding;
import com.talabat.core.deeplink.data.parser.AppLinkParser;
import com.talabat.core.deeplink.data.parser.AppLinkParser_Factory;
import com.talabat.core.deeplink.data.parser.DeepLinkParser_Factory;
import com.talabat.core.deeplink.data.parser.LinkParser;
import com.talabat.core.deeplink.data.registry.AppLinkHandlerRegistry;
import com.talabat.core.deeplink.data.registry.AppLinkHandlerRegistry_Factory;
import com.talabat.core.deeplink.data.registry.DeepLinkHandlerRegistry;
import com.talabat.core.deeplink.data.registry.DeepLinkHandlerRegistry_Factory;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDeepLinkCoreLibComponent {

    public static final class DeepLinkCoreLibComponentImpl implements DeepLinkCoreLibComponent {
        private Provider<AppLinkHandlerRegistry> appLinkHandlerRegistryProvider;
        private Provider<AppLinkParser> appLinkParserProvider;
        private final DeepLinkCoreLibComponentImpl deepLinkCoreLibComponentImpl;
        private Provider<DeepLinkHandlerRegistry> deepLinkHandlerRegistryProvider;
        private Provider<DefaultDeepLinkNavigator> defaultDeepLinkNavigatorProvider;
        private Provider<Map<Class<?>, Provider<PlatformChannel>>> getChannelsProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<IFlutterEngineProvider> getFlutterEngineProvider;
        private Provider<Navigator> getNavigatorProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<CustomerRepository> getRepositoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<DeepLinkNavigator> provideDeepLinkNavigatorProvider;
        private Provider<LinkParser> provideDeepLinkParserProvider;
        private Provider<UiLessFlutterEngineBinding> provideUiLessFlutterEngineBindingProvider;

        public static final class GetChannelsProvider implements Provider<Map<Class<?>, Provider<PlatformChannel>>> {
            private final FlutterChannelsCoreLibApi flutterChannelsCoreLibApi;

            public GetChannelsProvider(FlutterChannelsCoreLibApi flutterChannelsCoreLibApi2) {
                this.flutterChannelsCoreLibApi = flutterChannelsCoreLibApi2;
            }

            public Map<Class<?>, Provider<PlatformChannel>> get() {
                return (Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels());
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

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetFlutterEngineProviderProvider implements Provider<IFlutterEngineProvider> {
            private final FlutterEngineCoreLibApi flutterEngineCoreLibApi;

            public GetFlutterEngineProviderProvider(FlutterEngineCoreLibApi flutterEngineCoreLibApi2) {
                this.flutterEngineCoreLibApi = flutterEngineCoreLibApi2;
            }

            public IFlutterEngineProvider get() {
                return (IFlutterEngineProvider) Preconditions.checkNotNullFromComponent(this.flutterEngineCoreLibApi.getFlutterEngineProvider());
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

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetRepositoryProvider implements Provider<CustomerRepository> {
            private final CustomerCoreLibApi customerCoreLibApi;

            public GetRepositoryProvider(CustomerCoreLibApi customerCoreLibApi2) {
                this.customerCoreLibApi = customerCoreLibApi2;
            }

            public CustomerRepository get() {
                return (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository());
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

        private DeepLinkCoreLibComponentImpl(NavigationCoreLibApi navigationCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
            this.deepLinkCoreLibComponentImpl = this;
            initialize(navigationCoreLibApi, observabilityCoreLibApi, featureFlagCoreLibApi, experimentCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi, dispatcherCoreLibApi, customerCoreLibApi);
        }

        private void initialize(NavigationCoreLibApi navigationCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
            this.provideDeepLinkParserProvider = SingleCheck.provider(DeepLinkParser_Factory.create());
            this.getNavigatorProvider = new GetNavigatorProvider(navigationCoreLibApi);
            this.getFlutterEngineProvider = new GetFlutterEngineProviderProvider(flutterEngineCoreLibApi);
            this.getChannelsProvider = new GetChannelsProvider(flutterChannelsCoreLibApi);
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.provideUiLessFlutterEngineBindingProvider = DeepLinkCoreLibModule_Ext_ProvideUiLessFlutterEngineBindingFactory.create(this.getFlutterEngineProvider, DeepLinkFlutterNavigationChannel_Factory.create(), this.getChannelsProvider, this.getObservabilityManagerProvider);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(customerCoreLibApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.deepLinkHandlerRegistryProvider = SingleCheck.provider(DeepLinkHandlerRegistry_Factory.create(this.getNavigatorProvider, this.provideUiLessFlutterEngineBindingProvider, this.getTalabatFeatureFlagProvider, this.getExperimentProvider, getRepositoryProvider2, this.getObservabilityManagerProvider));
            this.appLinkParserProvider = SingleCheck.provider(AppLinkParser_Factory.create());
            this.appLinkHandlerRegistryProvider = SingleCheck.provider(AppLinkHandlerRegistry_Factory.create(this.getNavigatorProvider));
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            DefaultDeepLinkNavigator_Factory create = DefaultDeepLinkNavigator_Factory.create(this.provideDeepLinkParserProvider, this.deepLinkHandlerRegistryProvider, this.appLinkParserProvider, this.appLinkHandlerRegistryProvider, this.getObservabilityManagerProvider, getCoroutineDispatchersFactoryProvider2, this.getTalabatFeatureFlagProvider);
            this.defaultDeepLinkNavigatorProvider = create;
            this.provideDeepLinkNavigatorProvider = SingleCheck.provider(create);
        }

        public DeepLinkNavigator getDeepLinkNavigator() {
            return this.provideDeepLinkNavigatorProvider.get();
        }
    }

    public static final class Factory implements DeepLinkCoreLibComponent.Factory {
        private Factory() {
        }

        public DeepLinkCoreLibComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, CustomerCoreLibApi customerCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(flutterChannelsCoreLibApi);
            Preconditions.checkNotNull(flutterEngineCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            return new DeepLinkCoreLibComponentImpl(navigationCoreLibApi, observabilityCoreLibApi, featureFlagCoreLibApi, experimentCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi, dispatcherCoreLibApi, customerCoreLibApi);
        }
    }

    private DaggerDeepLinkCoreLibComponent() {
    }

    public static DeepLinkCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
