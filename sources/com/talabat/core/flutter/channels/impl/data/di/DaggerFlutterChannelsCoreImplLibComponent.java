package com.talabat.core.flutter.channels.impl.data.di;

import android.app.Application;
import android.content.Context;
import com.squareup.moshi.Moshi;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelCallback;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelCallback;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelCallback;
import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesChannelCallback;
import com.talabat.core.flutter.channels.domain.search.SearchChannelCallback;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallback;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelCallback;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelCallback;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.address.FlutterAddressMapper;
import com.talabat.core.flutter.channels.impl.data.address.NativeAddressMapper;
import com.talabat.core.flutter.channels.impl.data.apicallmocks.ApiCallsMockChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.authentication.AuthenticationMethodChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.cart.CartChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.config.GlobalChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.di.FlutterChannelsCoreImplLibComponent;
import com.talabat.core.flutter.channels.impl.data.dynamictrackingcache.DynamicTrackingCacheCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.experiment.ExperimentChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.featureflags.FeatureFlagChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl_Factory;
import com.talabat.core.flutter.channels.impl.data.home.HomeChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.legacydeeplink.LegacyDeeplinkNavigationChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.menu.MenuChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.observability.ObservabilityChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.ordertrackingdependencies.OrderTrackingDependenciesChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.search.SearchChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.sharedprefs.SharedPreferencesChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.tracking.AnalyticsMethodChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.tracking.TrackingChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.useraccount.UserAccountChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.vendor.VendorChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.vendorlist.InlineAdsChannelCallbackImpl;
import com.talabat.core.flutter.channels.impl.data.vendormenuinfo.VendorMenuInfoChannelCallbackImpl;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.data.googleclientid.GoogleClientIdProvider;
import com.talabat.location.SelectedLocationProvider;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFlutterChannelsCoreImplLibComponent {

    public static final class Factory implements FlutterChannelsCoreImplLibComponent.Factory {
        private Factory() {
        }

        public FlutterChannelsCoreImplLibComponent create(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ParserCoreLibApi parserCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibDataApi);
            Preconditions.checkNotNull(pinlessCheckoutCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            return new FlutterChannelsCoreImplLibComponentImpl(contextCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, experimentCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi, pinlessCheckoutCoreLibApi, navigationCoreLibApi, trackingCoreLibApi, parserCoreLibApi, mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi);
        }
    }

    public static final class FlutterChannelsCoreImplLibComponentImpl implements FlutterChannelsCoreImplLibComponent {
        private final ContextCoreLibApi contextCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FlutterChannelsCoreImplLibComponentImpl flutterChannelsCoreImplLibComponentImpl;
        private Provider<GemChannelCallbackImpl> gemChannelCallbackImplProvider;
        private Provider<Context> getContextProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final ParserCoreLibApi parserCoreLibApi;
        private final PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi;
        private Provider<DeviceIdProvider> provideDeviceIdProviderImplProvider;
        private Provider<GemChannelCallback> provideGemChannelCallbackProvider;
        private Provider<GoogleClientIdProvider> provideGoogleClientIdLocalStorageProvider;
        private Provider<RemoteConfiguration> provideRemoteConfigurationProvider;
        private Provider<SelectedLocationProvider> provideSelectedLocationProviderImplProvider;
        private final SecretCoreLibApi secretCoreLibApi;
        private final TokenCoreLibDataApi tokenCoreLibDataApi;
        private final TrackingCoreLibApi trackingCoreLibApi;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
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

        private FlutterChannelsCoreImplLibComponentImpl(ContextCoreLibApi contextCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, SecretCoreLibApi secretCoreLibApi2, TokenCoreLibDataApi tokenCoreLibDataApi2, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
            this.flutterChannelsCoreImplLibComponentImpl = this;
            this.secretCoreLibApi = secretCoreLibApi2;
            this.tokenCoreLibDataApi = tokenCoreLibDataApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.pinlessCheckoutCoreLibApi = pinlessCheckoutCoreLibApi2;
            this.parserCoreLibApi = parserCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            initialize(contextCoreLibApi2, featureFlagCoreLibApi2, observabilityCoreLibApi2, experimentCoreLibApi2, secretCoreLibApi2, tokenCoreLibDataApi2, pinlessCheckoutCoreLibApi2, navigationCoreLibApi2, trackingCoreLibApi2, parserCoreLibApi2, mutableConfigurationLocalCoreLibApi2, mutableConfigurationRemoteCoreLibApi2);
        }

        private AddressInfoChannelCallbackImpl addressInfoChannelCallbackImpl() {
            return new AddressInfoChannelCallbackImpl((Application) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getApplication()), (GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase) Preconditions.checkNotNullFromComponent(this.pinlessCheckoutCoreLibApi.getGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase()), new FlutterAddressMapper(), new NativeAddressMapper(), (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()), (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()), (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()), (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getPaymentConfigurationRepository()), (MutableConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getMutableRepository()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getRepository()), (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()), (MutableConfigurationRemoteRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableRepository()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        private AnalyticsMethodChannelCallbackImpl analyticsMethodChannelCallbackImpl() {
            return new AnalyticsMethodChannelCallbackImpl((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
        }

        private ApiCallsMockChannelCallbackImpl apiCallsMockChannelCallbackImpl() {
            return new ApiCallsMockChannelCallbackImpl((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private AuthenticationMethodChannelCallbackImpl authenticationMethodChannelCallbackImpl() {
            return new AuthenticationMethodChannelCallbackImpl((SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider()), (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getTokenRepository()), (TokenFlutterMapper) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getTokenFlutterMapper()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()), (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private ExperimentChannelCallbackImpl experimentChannelCallbackImpl() {
            return new ExperimentChannelCallbackImpl((ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
        }

        private FeatureFlagChannelCallbackImpl featureFlagChannelCallbackImpl() {
            return new FeatureFlagChannelCallbackImpl((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), this.provideRemoteConfigurationProvider.get());
        }

        private GlobalChannelCallbackImpl globalChannelCallbackImpl() {
            return new GlobalChannelCallbackImpl((AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getRepository()), (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getLocationConfigurationRepository()), this.provideSelectedLocationProviderImplProvider.get(), this.provideDeviceIdProviderImplProvider.get(), this.provideGoogleClientIdLocalStorageProvider.get(), (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getPaymentConfigurationRepository()), (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()), (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, SecretCoreLibApi secretCoreLibApi2, TokenCoreLibDataApi tokenCoreLibDataApi2, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
            this.provideSelectedLocationProviderImplProvider = SingleCheck.provider(FlutterChannelsCoreImplLibModule_Companion_ProvideSelectedLocationProviderImplFactory.create());
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi2);
            this.getContextProvider = getContextProvider2;
            this.provideDeviceIdProviderImplProvider = SingleCheck.provider(FlutterChannelsCoreImplLibModule_Companion_ProvideDeviceIdProviderImplFactory.create(getContextProvider2));
            this.provideGoogleClientIdLocalStorageProvider = SingleCheck.provider(FlutterChannelsCoreImplLibModule_Companion_ProvideGoogleClientIdLocalStorageFactory.create());
            this.provideRemoteConfigurationProvider = SingleCheck.provider(FlutterChannelsCoreImplLibModule_Companion_ProvideRemoteConfigurationFactory.create());
            GetExperimentProviderProvider getExperimentProviderProvider = new GetExperimentProviderProvider(experimentCoreLibApi2);
            this.getExperimentProvider = getExperimentProviderProvider;
            GemChannelCallbackImpl_Factory create = GemChannelCallbackImpl_Factory.create(this.getContextProvider, getExperimentProviderProvider);
            this.gemChannelCallbackImplProvider = create;
            this.provideGemChannelCallbackProvider = SingleCheck.provider(create);
        }

        private LegacyDeeplinkNavigationChannelCallbackImpl legacyDeeplinkNavigationChannelCallbackImpl() {
            return new LegacyDeeplinkNavigationChannelCallbackImpl((Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
        }

        private ObservabilityChannelCallbackImpl observabilityChannelCallbackImpl() {
            return new ObservabilityChannelCallbackImpl((IPerformanceTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getPerformanceTracker()), (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()), (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private OrderTrackingDependenciesChannelCallbackImpl orderTrackingDependenciesChannelCallbackImpl() {
            return new OrderTrackingDependenciesChannelCallbackImpl((Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
        }

        private SharedPreferencesChannelCallbackImpl sharedPreferencesChannelCallbackImpl() {
            return new SharedPreferencesChannelCallbackImpl((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private TrackingChannelCallbackImpl trackingChannelCallbackImpl() {
            return new TrackingChannelCallbackImpl(analyticsMethodChannelCallbackImpl(), (FlutterMigrationTools) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getFlutterMigrationTools()));
        }

        public AddressInfoChannelCallback getAddressInfoChannelCallback() {
            return addressInfoChannelCallbackImpl();
        }

        public ApiCallsMockChannelCallback getApiCallsMockChannelCallback() {
            return apiCallsMockChannelCallbackImpl();
        }

        public AuthenticationChannelCallback getAuthenticationChannelCallback() {
            return authenticationMethodChannelCallbackImpl();
        }

        public CartChannelCallback getCartChannelCallback() {
            return new CartChannelCallbackImpl();
        }

        public DynamicTrackingCacheCallback getDynamicTrackingCacheCallback() {
            return new DynamicTrackingCacheCallbackImpl();
        }

        public ExperimentChannelCallback getExperimentChannelCallback() {
            return experimentChannelCallbackImpl();
        }

        public FeatureFlagChannelCallback getFeatureFlagChannelCallback() {
            return featureFlagChannelCallbackImpl();
        }

        public GemChannelCallback getGemChannelCallback() {
            return this.provideGemChannelCallbackProvider.get();
        }

        public GlobalChannelCallback getGlobalChannelCallback() {
            return globalChannelCallbackImpl();
        }

        public HomeChannelCallback getHomeChannelCallback() {
            return new HomeChannelCallbackImpl();
        }

        public InlineAdsChannelCallback getInlineAdsChannelCallback() {
            return new InlineAdsChannelCallbackImpl();
        }

        public LegacyDeeplinkNavigationChannelCallback getLegacyDeeplinkNavigationChannelCallback() {
            return legacyDeeplinkNavigationChannelCallbackImpl();
        }

        public MenuChannelCallback getMenuChannelCallback() {
            return new MenuChannelCallbackImpl();
        }

        public ObservabilityChannelCallback getObservabilityChannelCallback() {
            return observabilityChannelCallbackImpl();
        }

        public OrderTrackingDependenciesChannelCallback getOrderTrackingDependenciesChannelCallback() {
            return orderTrackingDependenciesChannelCallbackImpl();
        }

        public SearchChannelCallback getSearchChannelCallback() {
            return new SearchChannelCallbackImpl();
        }

        public SharedPreferencesChannelCallback getSharedPreferencesChannelCallback() {
            return sharedPreferencesChannelCallbackImpl();
        }

        public TrackingChannelCallback getTrackingChannelCallback() {
            return trackingChannelCallbackImpl();
        }

        public UserAccountChannelCallback getUserAccountChannelCallback() {
            return new UserAccountChannelCallbackImpl();
        }

        public VendorChannelCallback getVendorChannelCallback() {
            return new VendorChannelCallbackImpl();
        }

        public VendorMenuInfoChannelCallback getVendorMenuInfoChannelCallback() {
            return new VendorMenuInfoChannelCallbackImpl();
        }
    }

    private DaggerFlutterChannelsCoreImplLibComponent() {
    }

    public static FlutterChannelsCoreImplLibComponent.Factory factory() {
        return new Factory();
    }
}
