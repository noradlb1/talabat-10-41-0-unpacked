package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.flutter.channels.data.di.FlutterChannelsCoreLibComponent;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallbackDomain;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import com.talabat.core.flutter.channels.domain.cart.CartChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import com.talabat.core.flutter.channels.domain.gem.GemChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import com.talabat.core.flutter.channels.domain.home.HomeChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationFlutterDomain;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelCallback;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesFlutterDomain;
import com.talabat.core.flutter.channels.domain.search.SearchChannelCallback;
import com.talabat.core.flutter.channels.domain.search.SearchChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallback;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelCallback;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelCallback;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelFlutterDomain;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFlutterChannelsCoreLibComponent {

    public static final class Factory implements FlutterChannelsCoreLibComponent.Factory {
        private Factory() {
        }

        public FlutterChannelsCoreLibComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi, FlutterSecretsCoreLibApi flutterSecretsCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(flutterChannelsCoreImplLibApi);
            Preconditions.checkNotNull(flutterSecretsCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new FlutterChannelsCoreLibComponentImpl(dispatcherCoreLibApi, flutterChannelsCoreImplLibApi, flutterSecretsCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class FlutterChannelsCoreLibComponentImpl implements FlutterChannelsCoreLibComponent {
        private final FlutterChannelsCoreLibComponentImpl flutterChannelsCoreLibComponentImpl;
        private Provider<AddressInfoChannelCallback> getAddressInfoChannelCallbackProvider;
        private Provider<ApiCallsMockChannelCallback> getApiCallsMockChannelCallbackProvider;
        private Provider<AuthenticationChannelCallback> getAuthenticationChannelCallbackProvider;
        private Provider<CartChannelCallback> getCartChannelCallbackProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<DynamicTrackingCacheCallback> getDynamicTrackingCacheCallbackProvider;
        private Provider<ExperimentChannelCallback> getExperimentChannelCallbackProvider;
        private Provider<FeatureFlagChannelCallback> getFeatureFlagChannelCallbackProvider;
        private Provider<GemChannelCallback> getGemChannelCallbackProvider;
        private Provider<GlobalChannelCallback> getGlobalChannelCallbackProvider;
        private Provider<HomeChannelCallback> getHomeChannelCallbackProvider;
        private Provider<InlineAdsChannelCallback> getInlineAdsChannelCallbackProvider;
        private Provider<LegacyDeeplinkNavigationChannelCallback> getLegacyDeeplinkNavigationChannelCallbackProvider;
        private Provider<MenuChannelCallback> getMenuChannelCallbackProvider;
        private Provider<ObservabilityChannelCallback> getObservabilityChannelCallbackProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<OrderTrackingDependenciesChannelCallback> getOrderTrackingDependenciesChannelCallbackProvider;
        private Provider<SearchChannelCallback> getSearchChannelCallbackProvider;
        private Provider<SharedPreferencesChannelCallback> getSharedPreferencesChannelCallbackProvider;
        private Provider<TrackingChannelCallback> getTrackingChannelCallbackProvider;
        private Provider<UserAccountChannelCallback> getUserAccountChannelCallbackProvider;
        private Provider<VendorChannelCallback> getVendorChannelCallbackProvider;
        private Provider<VendorMenuInfoChannelCallback> getVendorMenuInfoChannelCallbackProvider;
        private Provider<PlatformChannel> provideAddressInfoMethodChannelProvider;
        private Provider<PlatformChannel> provideApiCallsMockChannelProvider;
        private Provider<PlatformChannel> provideAuthenticationMethodChannelProvider;
        private Provider<PlatformChannel> provideCartMethodChannelProvider;
        private Provider<PlatformChannel> provideDynamicTrackingCacheMethodChannelProvider;
        private Provider<PlatformChannel> provideExperimentMethodChannelProvider;
        private Provider<PlatformChannel> provideFeatureFlagMethodChannelProvider;
        private Provider<PlatformChannel> provideGemMethodChannelProvider;
        private Provider<PlatformChannel> provideGlobalMethodChannelProvider;
        private Provider<PlatformChannel> provideHelpCenterMethodChannelProvider;
        private Provider<PlatformChannel> provideHomeMethodChannelProvider;
        private Provider<PlatformChannel> provideInlineAdsMethodChannelProvider;
        private Provider<PlatformChannel> provideLegacyDeepLinkNavigationMethodChannelProvider;
        private Provider<PlatformChannel> provideMenuMethodChannelProvider;
        private Provider<PlatformChannel> provideObservabilityMethodChannelProvider;
        private Provider<PlatformChannel> provideSearchMethodChannelProvider;
        private Provider<PlatformChannel> provideSecretsMethodChannelProvider;
        private Provider<PlatformChannel> provideSharedPreferencesMethodChannelProvider;
        private Provider<PlatformChannel> provideTrackingMethodChannelProvider;
        private Provider<PlatformChannel> provideUserAccountMethodChannelProvider;
        private Provider<PlatformChannel> provideVendorMenuInfoMethodChannelProvider;
        private Provider<PlatformChannel> provideVendorMethodChannelProvider;
        private Provider<SecretsMethodCallHandler> secretsMethodCallHandlerProvider;

        public static final class GetAddressInfoChannelCallbackProvider implements Provider<AddressInfoChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetAddressInfoChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public AddressInfoChannelCallback get() {
                return (AddressInfoChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getAddressInfoChannelCallback());
            }
        }

        public static final class GetApiCallsMockChannelCallbackProvider implements Provider<ApiCallsMockChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetApiCallsMockChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public ApiCallsMockChannelCallback get() {
                return (ApiCallsMockChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getApiCallsMockChannelCallback());
            }
        }

        public static final class GetAuthenticationChannelCallbackProvider implements Provider<AuthenticationChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetAuthenticationChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public AuthenticationChannelCallback get() {
                return (AuthenticationChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getAuthenticationChannelCallback());
            }
        }

        public static final class GetCartChannelCallbackProvider implements Provider<CartChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetCartChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public CartChannelCallback get() {
                return (CartChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getCartChannelCallback());
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

        public static final class GetDynamicTrackingCacheCallbackProvider implements Provider<DynamicTrackingCacheCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetDynamicTrackingCacheCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public DynamicTrackingCacheCallback get() {
                return (DynamicTrackingCacheCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getDynamicTrackingCacheCallback());
            }
        }

        public static final class GetExperimentChannelCallbackProvider implements Provider<ExperimentChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetExperimentChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public ExperimentChannelCallback get() {
                return (ExperimentChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getExperimentChannelCallback());
            }
        }

        public static final class GetFeatureFlagChannelCallbackProvider implements Provider<FeatureFlagChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetFeatureFlagChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public FeatureFlagChannelCallback get() {
                return (FeatureFlagChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getFeatureFlagChannelCallback());
            }
        }

        public static final class GetGemChannelCallbackProvider implements Provider<GemChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetGemChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public GemChannelCallback get() {
                return (GemChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getGemChannelCallback());
            }
        }

        public static final class GetGlobalChannelCallbackProvider implements Provider<GlobalChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetGlobalChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public GlobalChannelCallback get() {
                return (GlobalChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getGlobalChannelCallback());
            }
        }

        public static final class GetHomeChannelCallbackProvider implements Provider<HomeChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetHomeChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public HomeChannelCallback get() {
                return (HomeChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getHomeChannelCallback());
            }
        }

        public static final class GetInlineAdsChannelCallbackProvider implements Provider<InlineAdsChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetInlineAdsChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public InlineAdsChannelCallback get() {
                return (InlineAdsChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getInlineAdsChannelCallback());
            }
        }

        public static final class GetLegacyDeeplinkNavigationChannelCallbackProvider implements Provider<LegacyDeeplinkNavigationChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetLegacyDeeplinkNavigationChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public LegacyDeeplinkNavigationChannelCallback get() {
                return (LegacyDeeplinkNavigationChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getLegacyDeeplinkNavigationChannelCallback());
            }
        }

        public static final class GetMenuChannelCallbackProvider implements Provider<MenuChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetMenuChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public MenuChannelCallback get() {
                return (MenuChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getMenuChannelCallback());
            }
        }

        public static final class GetObservabilityChannelCallbackProvider implements Provider<ObservabilityChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetObservabilityChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public ObservabilityChannelCallback get() {
                return (ObservabilityChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getObservabilityChannelCallback());
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

        public static final class GetOrderTrackingDependenciesChannelCallbackProvider implements Provider<OrderTrackingDependenciesChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetOrderTrackingDependenciesChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public OrderTrackingDependenciesChannelCallback get() {
                return (OrderTrackingDependenciesChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getOrderTrackingDependenciesChannelCallback());
            }
        }

        public static final class GetSearchChannelCallbackProvider implements Provider<SearchChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetSearchChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public SearchChannelCallback get() {
                return (SearchChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getSearchChannelCallback());
            }
        }

        public static final class GetSharedPreferencesChannelCallbackProvider implements Provider<SharedPreferencesChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetSharedPreferencesChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public SharedPreferencesChannelCallback get() {
                return (SharedPreferencesChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getSharedPreferencesChannelCallback());
            }
        }

        public static final class GetTrackingChannelCallbackProvider implements Provider<TrackingChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetTrackingChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public TrackingChannelCallback get() {
                return (TrackingChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getTrackingChannelCallback());
            }
        }

        public static final class GetUserAccountChannelCallbackProvider implements Provider<UserAccountChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetUserAccountChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public UserAccountChannelCallback get() {
                return (UserAccountChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getUserAccountChannelCallback());
            }
        }

        public static final class GetVendorChannelCallbackProvider implements Provider<VendorChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetVendorChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public VendorChannelCallback get() {
                return (VendorChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getVendorChannelCallback());
            }
        }

        public static final class GetVendorMenuInfoChannelCallbackProvider implements Provider<VendorMenuInfoChannelCallback> {
            private final FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi;

            public GetVendorMenuInfoChannelCallbackProvider(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi2) {
                this.flutterChannelsCoreImplLibApi = flutterChannelsCoreImplLibApi2;
            }

            public VendorMenuInfoChannelCallback get() {
                return (VendorMenuInfoChannelCallback) Preconditions.checkNotNullFromComponent(this.flutterChannelsCoreImplLibApi.getVendorMenuInfoChannelCallback());
            }
        }

        public static final class SecretsMethodCallHandlerProvider implements Provider<SecretsMethodCallHandler> {
            private final FlutterSecretsCoreLibApi flutterSecretsCoreLibApi;

            public SecretsMethodCallHandlerProvider(FlutterSecretsCoreLibApi flutterSecretsCoreLibApi2) {
                this.flutterSecretsCoreLibApi = flutterSecretsCoreLibApi2;
            }

            public SecretsMethodCallHandler get() {
                return (SecretsMethodCallHandler) Preconditions.checkNotNullFromComponent(this.flutterSecretsCoreLibApi.secretsMethodCallHandler());
            }
        }

        private FlutterChannelsCoreLibComponentImpl(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi, FlutterSecretsCoreLibApi flutterSecretsCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.flutterChannelsCoreLibComponentImpl = this;
            initialize(dispatcherCoreLibApi, flutterChannelsCoreImplLibApi, flutterSecretsCoreLibApi, observabilityCoreLibApi);
        }

        private void initialize(DispatcherCoreLibApi dispatcherCoreLibApi, FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi, FlutterSecretsCoreLibApi flutterSecretsCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            GetAuthenticationChannelCallbackProvider getAuthenticationChannelCallbackProvider2 = new GetAuthenticationChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getAuthenticationChannelCallbackProvider = getAuthenticationChannelCallbackProvider2;
            this.provideAuthenticationMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideAuthenticationMethodChannelFactory.create(getAuthenticationChannelCallbackProvider2);
            this.getGlobalChannelCallbackProvider = new GetGlobalChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            this.provideGlobalMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideGlobalMethodChannelFactory.create(this.getGlobalChannelCallbackProvider, getObservabilityManagerProvider2);
            GetFeatureFlagChannelCallbackProvider getFeatureFlagChannelCallbackProvider2 = new GetFeatureFlagChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getFeatureFlagChannelCallbackProvider = getFeatureFlagChannelCallbackProvider2;
            this.provideFeatureFlagMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideFeatureFlagMethodChannelFactory.create(getFeatureFlagChannelCallbackProvider2);
            GetExperimentChannelCallbackProvider getExperimentChannelCallbackProvider2 = new GetExperimentChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getExperimentChannelCallbackProvider = getExperimentChannelCallbackProvider2;
            this.provideExperimentMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideExperimentMethodChannelFactory.create(getExperimentChannelCallbackProvider2);
            GetObservabilityChannelCallbackProvider getObservabilityChannelCallbackProvider2 = new GetObservabilityChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getObservabilityChannelCallbackProvider = getObservabilityChannelCallbackProvider2;
            this.provideObservabilityMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideObservabilityMethodChannelFactory.create(getObservabilityChannelCallbackProvider2);
            GetCartChannelCallbackProvider getCartChannelCallbackProvider2 = new GetCartChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getCartChannelCallbackProvider = getCartChannelCallbackProvider2;
            this.provideCartMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideCartMethodChannelFactory.create(getCartChannelCallbackProvider2);
            GetMenuChannelCallbackProvider getMenuChannelCallbackProvider2 = new GetMenuChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getMenuChannelCallbackProvider = getMenuChannelCallbackProvider2;
            this.provideMenuMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideMenuMethodChannelFactory.create(getMenuChannelCallbackProvider2);
            GetHomeChannelCallbackProvider getHomeChannelCallbackProvider2 = new GetHomeChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getHomeChannelCallbackProvider = getHomeChannelCallbackProvider2;
            this.provideHomeMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideHomeMethodChannelFactory.create(getHomeChannelCallbackProvider2);
            GetUserAccountChannelCallbackProvider getUserAccountChannelCallbackProvider2 = new GetUserAccountChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getUserAccountChannelCallbackProvider = getUserAccountChannelCallbackProvider2;
            this.provideUserAccountMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideUserAccountMethodChannelFactory.create(getUserAccountChannelCallbackProvider2);
            GetDynamicTrackingCacheCallbackProvider getDynamicTrackingCacheCallbackProvider2 = new GetDynamicTrackingCacheCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getDynamicTrackingCacheCallbackProvider = getDynamicTrackingCacheCallbackProvider2;
            this.provideDynamicTrackingCacheMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideDynamicTrackingCacheMethodChannelFactory.create(getDynamicTrackingCacheCallbackProvider2);
            SecretsMethodCallHandlerProvider secretsMethodCallHandlerProvider2 = new SecretsMethodCallHandlerProvider(flutterSecretsCoreLibApi);
            this.secretsMethodCallHandlerProvider = secretsMethodCallHandlerProvider2;
            this.provideSecretsMethodChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideSecretsMethodChannelFactory.create(secretsMethodCallHandlerProvider2));
            GetVendorChannelCallbackProvider getVendorChannelCallbackProvider2 = new GetVendorChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getVendorChannelCallbackProvider = getVendorChannelCallbackProvider2;
            this.provideVendorMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideVendorMethodChannelFactory.create(getVendorChannelCallbackProvider2);
            GetVendorMenuInfoChannelCallbackProvider getVendorMenuInfoChannelCallbackProvider2 = new GetVendorMenuInfoChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getVendorMenuInfoChannelCallbackProvider = getVendorMenuInfoChannelCallbackProvider2;
            this.provideVendorMenuInfoMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideVendorMenuInfoMethodChannelFactory.create(getVendorMenuInfoChannelCallbackProvider2);
            this.getAddressInfoChannelCallbackProvider = new GetAddressInfoChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            this.provideAddressInfoMethodChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideAddressInfoMethodChannelFactory.create(this.getAddressInfoChannelCallbackProvider, this.getObservabilityManagerProvider, getCoroutineDispatchersFactoryProvider2));
            GetOrderTrackingDependenciesChannelCallbackProvider getOrderTrackingDependenciesChannelCallbackProvider2 = new GetOrderTrackingDependenciesChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getOrderTrackingDependenciesChannelCallbackProvider = getOrderTrackingDependenciesChannelCallbackProvider2;
            this.provideHelpCenterMethodChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideHelpCenterMethodChannelFactory.create(getOrderTrackingDependenciesChannelCallbackProvider2));
            GetTrackingChannelCallbackProvider getTrackingChannelCallbackProvider2 = new GetTrackingChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getTrackingChannelCallbackProvider = getTrackingChannelCallbackProvider2;
            this.provideTrackingMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideTrackingMethodChannelFactory.create(getTrackingChannelCallbackProvider2);
            GetGemChannelCallbackProvider getGemChannelCallbackProvider2 = new GetGemChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getGemChannelCallbackProvider = getGemChannelCallbackProvider2;
            this.provideGemMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideGemMethodChannelFactory.create(getGemChannelCallbackProvider2);
            GetSearchChannelCallbackProvider getSearchChannelCallbackProvider2 = new GetSearchChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getSearchChannelCallbackProvider = getSearchChannelCallbackProvider2;
            this.provideSearchMethodChannelProvider = FlutterChannelsCoreLibModule_Companion_ProvideSearchMethodChannelFactory.create(getSearchChannelCallbackProvider2);
            GetApiCallsMockChannelCallbackProvider getApiCallsMockChannelCallbackProvider2 = new GetApiCallsMockChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getApiCallsMockChannelCallbackProvider = getApiCallsMockChannelCallbackProvider2;
            this.provideApiCallsMockChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideApiCallsMockChannelFactory.create(getApiCallsMockChannelCallbackProvider2));
            GetInlineAdsChannelCallbackProvider getInlineAdsChannelCallbackProvider2 = new GetInlineAdsChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getInlineAdsChannelCallbackProvider = getInlineAdsChannelCallbackProvider2;
            this.provideInlineAdsMethodChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideInlineAdsMethodChannelFactory.create(getInlineAdsChannelCallbackProvider2));
            GetLegacyDeeplinkNavigationChannelCallbackProvider getLegacyDeeplinkNavigationChannelCallbackProvider2 = new GetLegacyDeeplinkNavigationChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getLegacyDeeplinkNavigationChannelCallbackProvider = getLegacyDeeplinkNavigationChannelCallbackProvider2;
            this.provideLegacyDeepLinkNavigationMethodChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideLegacyDeepLinkNavigationMethodChannelFactory.create(getLegacyDeeplinkNavigationChannelCallbackProvider2));
            GetSharedPreferencesChannelCallbackProvider getSharedPreferencesChannelCallbackProvider2 = new GetSharedPreferencesChannelCallbackProvider(flutterChannelsCoreImplLibApi);
            this.getSharedPreferencesChannelCallbackProvider = getSharedPreferencesChannelCallbackProvider2;
            this.provideSharedPreferencesMethodChannelProvider = SingleCheck.provider(FlutterChannelsCoreLibModule_Companion_ProvideSharedPreferencesMethodChannelFactory.create(getSharedPreferencesChannelCallbackProvider2));
        }

        public Map<Class<?>, Provider<PlatformChannel>> getChannels() {
            return MapBuilder.newMapBuilder(22).put(AuthenticationChannelFlutterDomain.class, this.provideAuthenticationMethodChannelProvider).put(GlobalChannelFlutterDomain.class, this.provideGlobalMethodChannelProvider).put(FeatureFlagChannelFlutterDomain.class, this.provideFeatureFlagMethodChannelProvider).put(ExperimentChannelFlutterDomain.class, this.provideExperimentMethodChannelProvider).put(ObservabilityChannelFlutterDomain.class, this.provideObservabilityMethodChannelProvider).put(CartChannelFlutterDomain.class, this.provideCartMethodChannelProvider).put(MenuChannelFlutterDomain.class, this.provideMenuMethodChannelProvider).put(HomeChannelFlutterDomain.class, this.provideHomeMethodChannelProvider).put(UserAccountChannelFlutterDomain.class, this.provideUserAccountMethodChannelProvider).put(DynamicTrackingCacheFlutterDomain.class, this.provideDynamicTrackingCacheMethodChannelProvider).put(SecretsChannelFlutterDomain.class, this.provideSecretsMethodChannelProvider).put(VendorChannelFlutterDomain.class, this.provideVendorMethodChannelProvider).put(VendorMenuInfoChannelFlutterDomain.class, this.provideVendorMenuInfoMethodChannelProvider).put(AddressInfoChannelFlutterDomain.class, this.provideAddressInfoMethodChannelProvider).put(OrderTrackingDependenciesFlutterDomain.class, this.provideHelpCenterMethodChannelProvider).put(TrackingChannelFlutterDomain.class, this.provideTrackingMethodChannelProvider).put(GemChannelFlutterDomain.class, this.provideGemMethodChannelProvider).put(SearchChannelFlutterDomain.class, this.provideSearchMethodChannelProvider).put(ApiCallsMockChannelCallbackDomain.class, this.provideApiCallsMockChannelProvider).put(InlineAdsChannelFlutterDomain.class, this.provideInlineAdsMethodChannelProvider).put(LegacyDeeplinkNavigationFlutterDomain.class, this.provideLegacyDeepLinkNavigationMethodChannelProvider).put(SharedPreferencesChannelFlutterDomain.class, this.provideSharedPreferencesMethodChannelProvider).build();
        }
    }

    private DaggerFlutterChannelsCoreLibComponent() {
    }

    public static FlutterChannelsCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
