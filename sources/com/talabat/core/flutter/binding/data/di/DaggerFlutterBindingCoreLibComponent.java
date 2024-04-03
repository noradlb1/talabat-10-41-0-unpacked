package com.talabat.core.flutter.binding.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.flutter.binding.data.apicallmocks.ApiCallMocksFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.cart.CartFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.config.ConfigFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.di.FlutterBindingCoreLibComponent;
import com.talabat.core.flutter.binding.data.gem.GemFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.legacydeeplink.LegacyDeeplinkNavigationFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.menu.MenuFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.ordertrackingdependencies.OrderTrackingDependenciesFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.search.SearchFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.sharedprefs.SharedPreferencesFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendor.VendorFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendorlist.InlineAdsFlutterEngineBinding;
import com.talabat.core.flutter.binding.data.vendormenuinfo.VendorMenuInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.binding.domain.address.IAddressInfoFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.dynamictrackingcache.IDynamicTrackingCacheFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.home.IHomeFlutterEngineBinding;
import com.talabat.core.flutter.binding.domain.useraccount.IUserAccountFlutterEngineBinding;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.di.DeeplinkNavigationChannelCoreLibApi;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import com.talabat.core.flutter.engine.domain.IFlutterEngineProvider;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SingleCheck;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFlutterBindingCoreLibComponent {

    public static final class Factory implements FlutterBindingCoreLibComponent.Factory {
        private Factory() {
        }

        public FlutterBindingCoreLibComponent create(ContextCoreLibApi contextCoreLibApi, DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi, FlutterEngineCoreLibApi flutterEngineCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(deeplinkNavigationChannelCoreLibApi);
            Preconditions.checkNotNull(flutterChannelsCoreLibApi);
            Preconditions.checkNotNull(flutterEngineCoreLibApi);
            return new FlutterBindingCoreLibComponentImpl(contextCoreLibApi, deeplinkNavigationChannelCoreLibApi, flutterChannelsCoreLibApi, flutterEngineCoreLibApi);
        }
    }

    public static final class FlutterBindingCoreLibComponentImpl implements FlutterBindingCoreLibComponent {
        private final DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi;
        private final FlutterBindingCoreLibComponentImpl flutterBindingCoreLibComponentImpl;
        private final FlutterChannelsCoreLibApi flutterChannelsCoreLibApi;
        private final FlutterEngineCoreLibApi flutterEngineCoreLibApi;
        private Provider<Map<Class<?>, Provider<PlatformChannel>>> getChannelsProvider;
        private Provider<IAddressInfoFlutterEngineBinding> provideAddressInfoFlutterBindingProvider;
        private Provider<ApiCallMocksFlutterEngineBinding> provideApiMocksFlutterBindingProvider;
        private Provider<CartFlutterEngineBinding> provideCartFlutterBindingProvider;
        private Provider<LegacyDeeplinkNavigationFlutterEngineBinding> provideLegacyDeeplinkNavigationFlutterBindingProvider;
        private Provider<MenuFlutterEngineBinding> provideMenuFlutterBindingProvider;
        private Provider<OrderTrackingDependenciesFlutterEngineBinding> provideOrderTrackingDependenciesFlutterBindingProvider;
        private Provider<SharedPreferencesFlutterEngineBinding> provideSharedPreferencesFlutterBindingProvider;
        private Provider<VendorFlutterEngineBinding> provideVendorFlutterBindingProvider;
        private Provider<InlineAdsFlutterEngineBinding> provideVendorListFlutterBindingProvider;
        private Provider<VendorMenuInfoFlutterEngineBinding> provideVendorMenuInfoFlutterBindingProvider;

        public static final class GetChannelsProvider implements Provider<Map<Class<?>, Provider<PlatformChannel>>> {
            private final FlutterChannelsCoreLibApi flutterChannelsCoreLibApi;

            public GetChannelsProvider(FlutterChannelsCoreLibApi flutterChannelsCoreLibApi2) {
                this.flutterChannelsCoreLibApi = flutterChannelsCoreLibApi2;
            }

            public Map<Class<?>, Provider<PlatformChannel>> get() {
                return (Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels());
            }
        }

        private FlutterBindingCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi, DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi2, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi2, FlutterEngineCoreLibApi flutterEngineCoreLibApi2) {
            this.flutterBindingCoreLibComponentImpl = this;
            this.flutterChannelsCoreLibApi = flutterChannelsCoreLibApi2;
            this.deeplinkNavigationChannelCoreLibApi = deeplinkNavigationChannelCoreLibApi2;
            this.flutterEngineCoreLibApi = flutterEngineCoreLibApi2;
            initialize(contextCoreLibApi, deeplinkNavigationChannelCoreLibApi2, flutterChannelsCoreLibApi2, flutterEngineCoreLibApi2);
        }

        private ConfigFlutterEngineBinding configFlutterEngineBinding() {
            return FlutterBindingCoreLibModule_ProvideConfigFlutterEngineBindingFactory.provideConfigFlutterEngineBinding((Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()), (DeeplinkNavigationNativeDomain) Preconditions.checkNotNullFromComponent(this.deeplinkNavigationChannelCoreLibApi.getDeeplinkNavigationNativeDomain()));
        }

        private GemFlutterEngineBinding gemFlutterEngineBinding() {
            return FlutterBindingCoreLibModule_ProvideGemFlutterBindingFactory.provideGemFlutterBinding((Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()));
        }

        private IDynamicTrackingCacheFlutterEngineBinding iDynamicTrackingCacheFlutterEngineBinding() {
            return FlutterBindingCoreLibModule_ProvideDynamicTrackingCacheFlutterEngineBindingFactory.provideDynamicTrackingCacheFlutterEngineBinding((Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()));
        }

        private IHomeFlutterEngineBinding iHomeFlutterEngineBinding() {
            return FlutterBindingCoreLibModule_ProvideHomeFlutterBindingFactory.provideHomeFlutterBinding((Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()));
        }

        private IUserAccountFlutterEngineBinding iUserAccountFlutterEngineBinding() {
            return FlutterBindingCoreLibModule_ProvideUserAccountFlutterBindingFactory.provideUserAccountFlutterBinding((Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()));
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, DeeplinkNavigationChannelCoreLibApi deeplinkNavigationChannelCoreLibApi2, FlutterChannelsCoreLibApi flutterChannelsCoreLibApi2, FlutterEngineCoreLibApi flutterEngineCoreLibApi2) {
            GetChannelsProvider getChannelsProvider2 = new GetChannelsProvider(flutterChannelsCoreLibApi2);
            this.getChannelsProvider = getChannelsProvider2;
            this.provideCartFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideCartFlutterBindingFactory.create(getChannelsProvider2));
            this.provideMenuFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideMenuFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideVendorFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideVendorFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideVendorMenuInfoFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideVendorMenuInfoFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideAddressInfoFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideAddressInfoFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideApiMocksFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideApiMocksFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideOrderTrackingDependenciesFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideOrderTrackingDependenciesFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideVendorListFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideVendorListFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideLegacyDeeplinkNavigationFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideLegacyDeeplinkNavigationFlutterBindingFactory.create(this.getChannelsProvider));
            this.provideSharedPreferencesFlutterBindingProvider = SingleCheck.provider(FlutterBindingCoreLibModule_ProvideSharedPreferencesFlutterBindingFactory.create(this.getChannelsProvider));
        }

        private Set<EngineBinding> provideRegisteredFlutterBindingModules() {
            return FlutterBindingCoreLibModule_ProvideRegisteredFlutterBindingModulesFactory.provideRegisteredFlutterBindingModules(configFlutterEngineBinding(), this.provideCartFlutterBindingProvider.get(), gemFlutterEngineBinding(), searchFlutterEngineBinding(), this.provideMenuFlutterBindingProvider.get(), this.provideVendorFlutterBindingProvider.get(), this.provideVendorMenuInfoFlutterBindingProvider.get(), this.provideAddressInfoFlutterBindingProvider.get(), iHomeFlutterEngineBinding(), iUserAccountFlutterEngineBinding(), iDynamicTrackingCacheFlutterEngineBinding(), this.provideApiMocksFlutterBindingProvider.get(), this.provideOrderTrackingDependenciesFlutterBindingProvider.get(), this.provideVendorListFlutterBindingProvider.get(), this.provideLegacyDeeplinkNavigationFlutterBindingProvider.get(), this.provideSharedPreferencesFlutterBindingProvider.get());
        }

        private SearchFlutterEngineBinding searchFlutterEngineBinding() {
            return FlutterBindingCoreLibModule_ProvideSearchFlutterBindingFactory.provideSearchFlutterBinding((Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()));
        }

        public DeeplinkEngineBindingRegistry getDeeplinkEngineBindingRegistry() {
            return FlutterBindingCoreLibModule_ProvideDeeplinkEngineBindingRegistryFactory.provideDeeplinkEngineBindingRegistry((IFlutterEngineProvider) Preconditions.checkNotNullFromComponent(this.flutterEngineCoreLibApi.getFlutterEngineProvider()), getRegisteredFlutterBindingModules(), (Map) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreLibApi.getChannels()));
        }

        public Set<EngineBinding> getRegisteredFlutterBindingModules() {
            return SetBuilder.newSetBuilder(1).addAll(provideRegisteredFlutterBindingModules()).build();
        }
    }

    private DaggerFlutterBindingCoreLibComponent() {
    }

    public static FlutterBindingCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
