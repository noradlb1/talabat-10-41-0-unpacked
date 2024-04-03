package com.talabat.splash.core.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import androidx.work.WorkManager;
import buisnessmodels.Cart;
import buisnessmodels.Cart_MembersInjector;
import buisnessmodels.Customer;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper_Factory;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase_Factory;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwf.domain.config.IFWFManager;
import com.talabat.core.fwf.domain.di.FWFCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.di.cart.CartUtilityModule_ProvideCartUtilityFactory;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper_Factory;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignDeeplinkUseCase;
import com.talabat.helpers.TalabatApplication;
import com.talabat.helpers.TalabatApplication_MembersInjector;
import com.talabat.location.domain.LocationRepository;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.messaging.MessagingServiceType;
import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.splash.core.di.ApplicationComponent;
import com.talabat.splash.core.di.viewmodel.ViewModelFactory;
import com.talabat.splash.core.di.viewmodel.ViewModelFactory_Factory;
import com.talabat.splash.core.navigation.Navigator;
import com.talabat.splash.core.navigation.Navigator_Factory;
import com.talabat.splash.core.platform.NetworkHandler;
import com.talabat.splash.core.platform.NetworkHandler_Factory;
import com.talabat.splash.data.local.LocalCache;
import com.talabat.splash.data.preferences.AppInfoLocalDataSource;
import com.talabat.splash.data.preferences.AppInfoLocalDataSourceImp;
import com.talabat.splash.data.preferences.AppInfoLocalDataSourceImp_Factory;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.data.preferences.SplashPreferences_Factory;
import com.talabat.splash.data.remote.DownloadManager;
import com.talabat.splash.data.remote.DownloadManager_Factory;
import com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource;
import com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource_Factory;
import com.talabat.splash.data.repositories.AppInfoRepository;
import com.talabat.splash.data.repositories.AppInfoRepositoryImpl;
import com.talabat.splash.data.repositories.AppInfoRepositoryImpl_Factory;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepository;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepositoryImp;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepositoryImp_Factory;
import com.talabat.splash.domain.model.AppInfoGlobalConstantsWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalConstantsWrapper_Factory;
import com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper_Factory;
import com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper_Factory;
import com.talabat.splash.domain.model.AppInfoResponseMapper_Factory;
import com.talabat.splash.domain.repository.DownloadsRepository;
import com.talabat.splash.domain.repository.SplashConfigurationRepository;
import com.talabat.splash.domain.usecase.ClearOwinStartupUseCaseImpl;
import com.talabat.splash.domain.usecase.ClearOwinStartupUseCaseImpl_Factory;
import com.talabat.splash.domain.usecase.GetAppInfoUseCase;
import com.talabat.splash.domain.usecase.GetAppInfoUseCase_Factory;
import com.talabat.splash.domain.usecase.GetAppLanguageUseCase;
import com.talabat.splash.domain.usecase.GetAppLanguageUseCase_Factory;
import com.talabat.splash.domain.usecase.GetAppPreferncesUseCase;
import com.talabat.splash.domain.usecase.GetAppPreferncesUseCase_Factory;
import com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase;
import com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase_Factory;
import com.talabat.splash.domain.usecase.GetCurrentLocationUseCase;
import com.talabat.splash.domain.usecase.GetCurrentLocationUseCase_Factory;
import com.talabat.splash.domain.usecase.GetDeviceDeepLinkUseCase;
import com.talabat.splash.domain.usecase.GetDeviceDeepLinkUseCase_Factory;
import com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase;
import com.talabat.splash.domain.usecase.GetGpsStausUseCase;
import com.talabat.splash.domain.usecase.GetGpsStausUseCase_Factory;
import com.talabat.splash.domain.usecase.GetLocationPermissionStatusUseCase;
import com.talabat.splash.domain.usecase.GetLocationPermissionStatusUseCase_Factory;
import com.talabat.splash.domain.usecase.GetRedirectionFlowUseCase;
import com.talabat.splash.domain.usecase.GetRedirectionFlowUseCase_Factory;
import com.talabat.splash.domain.usecase.GetReverseGeoCodeCountryUseCase;
import com.talabat.splash.domain.usecase.GetReverseGeoCodeCountryUseCase_Factory;
import com.talabat.splash.domain.usecase.GetSplashPhaseOneUseCase;
import com.talabat.splash.domain.usecase.GetSplashPhaseOneUseCase_Factory;
import com.talabat.splash.domain.usecase.GetThirdPartyInitUseCase;
import com.talabat.splash.domain.usecase.GetThirdPartyInitUseCase_Factory;
import com.talabat.splash.domain.usecase.SetAppConfigUseCase;
import com.talabat.splash.domain.usecase.SetAppConfigUseCase_Factory;
import com.talabat.splash.network.SplashServices;
import com.talabat.splash.network.SplashServices_Factory;
import com.talabat.splash.presentation.infrastructure.device.CommonUtils;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastrcture;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastructureImpl;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastructureImpl_Factory;
import com.talabat.splash.presentation.infrastructure.thirdparty.SplashConfig;
import com.talabat.splash.presentation.infrastructure.thirdparty.SplashConfig_Factory;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructure;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl_Factory;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking_Factory;
import com.talabat.splash.presentation.ui.SplashActivity;
import com.talabat.splash.presentation.ui.SplashActivitySharedViewModel;
import com.talabat.splash.presentation.ui.SplashActivitySharedViewModel_Factory;
import com.talabat.splash.presentation.ui.SplashActivity_MembersInjector;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import com.talabat.userandlocation.token.ClearOwinUseCaseImpl;
import com.talabat.userandlocation.token.ClearOwinUseCaseImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.cart.CartUtility;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerApplicationComponent {

    public static final class ApplicationComponentImpl implements ApplicationComponent {
        private Provider<AppInfoGlobalConstantsWrapper> appInfoGlobalConstantsWrapperProvider;
        private Provider<AppInfoGlobalCountryWrapper> appInfoGlobalCountryWrapperProvider;
        private Provider<AppInfoGlobalCustomerWrapper> appInfoGlobalCustomerWrapperProvider;
        private Provider<AppInfoLocalDataSourceImp> appInfoLocalDataSourceImpProvider;
        private Provider<AppInfoRepositoryImpl> appInfoRepositoryImplProvider;
        private final ApplicationComponentImpl applicationComponentImpl;
        private final ApplicationModule applicationModule;
        private Provider<CLInfrastructureImpl> cLInfrastructureImplProvider;
        private final CampaignMigratorFeatureApi campaignMigratorFeatureApi;
        private Provider<ClearOwinStartupUseCaseImpl> clearOwinStartupUseCaseImplProvider;
        private Provider<ClearOwinUseCaseImpl> clearOwinUseCaseImplProvider;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private Provider<DownloadManager> downloadManagerProvider;
        private final FWFCoreLibApi fWFCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FoodCartFeatureApi foodCartFeatureApi;
        private Provider<GetAppInfoUseCase> getAppInfoUseCaseProvider;
        private Provider<GetAppLanguageUseCase> getAppLanguageUseCaseProvider;
        private Provider<GetAppPreferncesUseCase> getAppPreferncesUseCaseProvider;
        private Provider<AppVersionProvider> getAppVersionProvider;
        private Provider<AuthenticationRepository> getAuthenticationRepositoryProvider;
        private Provider<GetAuthenticationTokenUseCase> getAuthenticationTokenUseCaseProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<GetCurrentLocationUseCase> getCurrentLocationUseCaseProvider;
        private Provider<GetDeviceDeepLinkUseCase> getDeviceDeepLinkUseCaseProvider;
        private Provider<DiscoveryConfigurationRepository> getDiscoveryConfigurationRepositoryProvider;
        private Provider<GetProCentralizationStatusUseCase> getGetProCentralizationStatusUseCaseProvider;
        private Provider<GetGpsStausUseCase> getGpsStausUseCaseProvider;
        private Provider<LocationConfigurationRepository> getLocationConfigurationRepositoryProvider;
        private Provider<GetLocationPermissionStatusUseCase> getLocationPermissionStatusUseCaseProvider;
        private Provider<LocationRepository> getLocationRepositoryProvider;
        private Provider<Moshi> getMoshiProvider;
        private Provider<MutableLocationConfigurationRepository> getMutableLocationConfigurationRepositoryProvider;
        private Provider<MutableConfigurationLocalRepository> getMutableRepositoryProvider;
        private Provider<MutableConfigurationRemoteRepository> getMutableRepositoryProvider2;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<PaymentConfigurationRepository> getPaymentConfigurationRepositoryProvider;
        private Provider<GetRedirectionFlowUseCase> getRedirectionFlowUseCaseProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<GetReverseGeoCodeCountryUseCase> getReverseGeoCodeCountryUseCaseProvider;
        private Provider<GetSplashPhaseOneUseCase> getSplashPhaseOneUseCaseProvider;
        private Provider<ISubscriptionsCustomerRepository> getSubscriptionsCustomerRepositoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<GetThirdPartyInitUseCase> getThirdPartyInitUseCaseProvider;
        private Provider<TokenRepository> getTokenRepositoryProvider;
        private final GmsBaseCoreLibApi gmsBaseCoreLibApi;
        private final HmsBaseCoreLibApi hmsBaseCoreLibApi;
        private Provider<IsOnboardingExperimentEnabledUseCase> isOnboardingExperimentEnabledUseCaseProvider;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;
        private final MessagingModule messagingModule;
        private Provider<MigrationExchangeObservabilityUseCase> migrationExchangeObservabilityUseCaseProvider;
        private Provider<MutableConfigurationLocalCoreLibApi> mutableConfigurationLocalCoreLibApiProvider;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private Provider<Navigator> navigatorProvider;
        private Provider<NetworkHandler> networkHandlerProvider;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<ProCentralizationStatusWrapper> proCentralizationStatusWrapperProvider;
        private Provider<AppInfoLocalDataSource> provideAppInfoLocalDataSourceProvider;
        private Provider<AppInfoRepository> provideAppInfoRepositoryProvider;
        private Provider<Context> provideApplicationContextProvider;
        private Provider<BrazeUserMigrator> provideBrazeUserMigratorProvider;
        private Provider<CLInfrastrcture> provideCLRepositoryProvider;
        private Provider<CommonUtils> provideCommonUtilsProvider;
        private Provider<CoroutineDispatcher> provideCoroutineDispatcherProvider;
        private Provider<CustomerInfoRepository> provideCustomerInfoRepositoryProvider;
        private Provider<Customer> provideCustomerProvider;
        private Provider<CustomerRepository> provideCustomerRepositoryProvider;
        private Provider<DownloadsRepository> provideDownloadsRepositoryProvider;
        private Provider<GetDynamicSplashContentUseCase> provideGetDynamicSplashContentUseCaseProvider;
        private Provider<Gson> provideGsonProvider;
        private Provider<LocalCache> provideLocalCacheProvider;
        private Provider<Function<String, Unit>> providePilotSetterProvider;
        private Provider<PresentationUtils> providePresentationUtilsProvider;
        private Provider<Retrofit> provideRetrofitProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<SplashConfigurationRepository> provideSplashConfigurationRepositoryProvider;
        private Provider<RemoteConfiguration> provideTalabatRemoteConfigurationProvider;
        private Provider<ThirdPartyLibraryInfrastructure> provideThirdPartyLibraryInfrastructureProvider;
        private Provider<WorkManager> provideWorkManagerProvider;
        private Provider<RetrieveAndCacheCustomerAddressesUseCase> providesRetrieveAndCacheCustomerAddressesUseCaseProvider;
        private Provider<SplashCustomerInfoRepository> providesSplashCustomerInfoRepositoryProvider;
        private Provider<UserStatusRepository> providesUserStatusRepositoryProvider;
        private Provider<SetAppConfigUseCase> setAppConfigUseCaseProvider;
        private Provider<SplashActivitySharedViewModel> splashActivitySharedViewModelProvider;
        private Provider<SplashConfig> splashConfigProvider;
        private Provider<SplashConfigurationRemoteDataSource> splashConfigurationRemoteDataSourceProvider;
        private Provider<SplashCustomerInfoRepositoryImp> splashCustomerInfoRepositoryImpProvider;
        private Provider<SplashPreferences> splashPreferencesProvider;
        private Provider<SplashServices> splashServicesProvider;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;
        private Provider<ThirdPartyLibraryInfrastructureImpl> thirdPartyLibraryInfrastructureImplProvider;
        private Provider<TokenizedBankCardToOldTokenizedBankCardMapper> tokenizedBankCardToOldTokenizedBankCardMapperProvider;
        private Provider<Tracking> trackingProvider;
        private Provider<ViewModelFactory> viewModelFactoryProvider;

        public static final class GetAppVersionProviderProvider implements Provider<AppVersionProvider> {
            private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

            public GetAppVersionProviderProvider(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
                this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            }

            public AppVersionProvider get() {
                return (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider());
            }
        }

        public static final class GetAuthenticationRepositoryProvider implements Provider<AuthenticationRepository> {
            private final AuthenticationCoreLibApi authenticationCoreLibApi;

            public GetAuthenticationRepositoryProvider(AuthenticationCoreLibApi authenticationCoreLibApi2) {
                this.authenticationCoreLibApi = authenticationCoreLibApi2;
            }

            public AuthenticationRepository get() {
                return (AuthenticationRepository) Preconditions.checkNotNullFromComponent(this.authenticationCoreLibApi.getAuthenticationRepository());
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

        public static final class GetDiscoveryConfigurationRepositoryProvider implements Provider<DiscoveryConfigurationRepository> {
            private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

            public GetDiscoveryConfigurationRepositoryProvider(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
                this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            }

            public DiscoveryConfigurationRepository get() {
                return (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getDiscoveryConfigurationRepository());
            }
        }

        public static final class GetGetProCentralizationStatusUseCaseProvider implements Provider<GetProCentralizationStatusUseCase> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetGetProCentralizationStatusUseCaseProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public GetProCentralizationStatusUseCase get() {
                return (GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase());
            }
        }

        public static final class GetLocationConfigurationRepositoryProvider implements Provider<LocationConfigurationRepository> {
            private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

            public GetLocationConfigurationRepositoryProvider(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
                this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            }

            public LocationConfigurationRepository get() {
                return (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getLocationConfigurationRepository());
            }
        }

        public static final class GetLocationRepositoryProvider implements Provider<LocationRepository> {
            private final LocationCoreLibApi locationCoreLibApi;

            public GetLocationRepositoryProvider(LocationCoreLibApi locationCoreLibApi2) {
                this.locationCoreLibApi = locationCoreLibApi2;
            }

            public LocationRepository get() {
                return (LocationRepository) Preconditions.checkNotNullFromComponent(this.locationCoreLibApi.getLocationRepository());
            }
        }

        public static final class GetMoshiProvider implements Provider<Moshi> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetMoshiProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Moshi get() {
                return (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi());
            }
        }

        public static final class GetMutableLocationConfigurationRepositoryProvider implements Provider<MutableLocationConfigurationRepository> {
            private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

            public GetMutableLocationConfigurationRepositoryProvider(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
                this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            }

            public MutableLocationConfigurationRepository get() {
                return (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository());
            }
        }

        public static final class GetMutableRepositoryProvider implements Provider<MutableConfigurationLocalRepository> {
            private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;

            public GetMutableRepositoryProvider(MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2) {
                this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
            }

            public MutableConfigurationLocalRepository get() {
                return (MutableConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getMutableRepository());
            }
        }

        public static final class GetMutableRepositoryProvider2 implements Provider<MutableConfigurationRemoteRepository> {
            private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

            public GetMutableRepositoryProvider2(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
                this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            }

            public MutableConfigurationRemoteRepository get() {
                return (MutableConfigurationRemoteRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableRepository());
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

        public static final class GetPaymentConfigurationRepositoryProvider implements Provider<PaymentConfigurationRepository> {
            private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

            public GetPaymentConfigurationRepositoryProvider(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
                this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            }

            public PaymentConfigurationRepository get() {
                return (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getPaymentConfigurationRepository());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;

            public GetRepositoryProvider(MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2) {
                this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationLocalCoreLibApi.getRepository());
            }
        }

        public static final class GetSubscriptionsCustomerRepositoryProvider implements Provider<ISubscriptionsCustomerRepository> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetSubscriptionsCustomerRepositoryProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionsCustomerRepository get() {
                return (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository());
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

        public static final class GetTokenRepositoryProvider implements Provider<TokenRepository> {
            private final TokenCoreLibApi tokenCoreLibApi;

            public GetTokenRepositoryProvider(TokenCoreLibApi tokenCoreLibApi2) {
                this.tokenCoreLibApi = tokenCoreLibApi2;
            }

            public TokenRepository get() {
                return (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getTokenRepository());
            }
        }

        public static final class IsOnboardingExperimentEnabledUseCaseProvider implements Provider<IsOnboardingExperimentEnabledUseCase> {
            private final OnBoardingExperimentApi onBoardingExperimentApi;

            public IsOnboardingExperimentEnabledUseCaseProvider(OnBoardingExperimentApi onBoardingExperimentApi2) {
                this.onBoardingExperimentApi = onBoardingExperimentApi2;
            }

            public IsOnboardingExperimentEnabledUseCase get() {
                return (IsOnboardingExperimentEnabledUseCase) Preconditions.checkNotNullFromComponent(this.onBoardingExperimentApi.isOnboardingExperimentEnabledUseCase());
            }
        }

        private ApplicationComponentImpl(ApplicationModule applicationModule2, MessagingModule messagingModule2, AuthenticationCoreLibApi authenticationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi2, HmsBaseCoreLibApi hmsBaseCoreLibApi2, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, ParserCoreLibApi parserCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, FWFCoreLibApi fWFCoreLibApi2, FoodCartFeatureApi foodCartFeatureApi2, CampaignMigratorFeatureApi campaignMigratorFeatureApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, TokenCoreLibApi tokenCoreLibApi, OnBoardingExperimentApi onBoardingExperimentApi) {
            this.applicationComponentImpl = this;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.applicationModule = applicationModule2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.fWFCoreLibApi = fWFCoreLibApi2;
            this.campaignMigratorFeatureApi = campaignMigratorFeatureApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.messagingModule = messagingModule2;
            this.gmsBaseCoreLibApi = gmsBaseCoreLibApi2;
            this.hmsBaseCoreLibApi = hmsBaseCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.foodCartFeatureApi = foodCartFeatureApi2;
            initialize(applicationModule2, messagingModule2, authenticationCoreLibApi, deepLinkCoreLibApi2, dispatcherCoreLibApi, gmsBaseCoreLibApi2, hmsBaseCoreLibApi2, locationCoreLibApi, mapsCoreLibApi, mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi2, parserCoreLibApi, subscriptionsFeatureApi2, featureFlagCoreLibApi2, fWFCoreLibApi2, foodCartFeatureApi2, campaignMigratorFeatureApi2, observabilityCoreLibApi2, tokenCoreLibApi, onBoardingExperimentApi);
        }

        private CartUtility cartUtility() {
            return CartUtilityModule_ProvideCartUtilityFactory.provideCartUtility((IFoodCartRepository) Preconditions.checkNotNullFromComponent(this.foodCartFeatureApi.getRepository()));
        }

        private CustomerInfoRepository customerInfoRepository() {
            return ApplicationModule_ProvideCustomerInfoRepositoryFactory.provideCustomerInfoRepository(this.applicationModule, proCentralizationStatusWrapper());
        }

        private void initialize(ApplicationModule applicationModule2, MessagingModule messagingModule2, AuthenticationCoreLibApi authenticationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi2, HmsBaseCoreLibApi hmsBaseCoreLibApi2, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, ParserCoreLibApi parserCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, FWFCoreLibApi fWFCoreLibApi2, FoodCartFeatureApi foodCartFeatureApi2, CampaignMigratorFeatureApi campaignMigratorFeatureApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, TokenCoreLibApi tokenCoreLibApi, OnBoardingExperimentApi onBoardingExperimentApi) {
            ApplicationModule applicationModule3 = applicationModule2;
            MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2 = mutableConfigurationLocalCoreLibApi;
            MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi3 = mutableConfigurationRemoteCoreLibApi2;
            SubscriptionsFeatureApi subscriptionsFeatureApi3 = subscriptionsFeatureApi2;
            Provider<Context> provider = DoubleCheck.provider(ApplicationModule_ProvideApplicationContextFactory.create(applicationModule2));
            this.provideApplicationContextProvider = provider;
            this.provideSharedPreferencesProvider = DoubleCheck.provider(ApplicationModule_ProvideSharedPreferencesFactory.create(applicationModule3, provider));
            this.providePresentationUtilsProvider = DoubleCheck.provider(ApplicationModule_ProvidePresentationUtilsFactory.create(applicationModule3, this.provideApplicationContextProvider));
            Provider<Gson> provider2 = DoubleCheck.provider(ApplicationModule_ProvideGsonFactory.create(applicationModule2));
            this.provideGsonProvider = provider2;
            this.provideCommonUtilsProvider = DoubleCheck.provider(ApplicationModule_ProvideCommonUtilsFactory.create(applicationModule3, provider2));
            this.provideCustomerProvider = DoubleCheck.provider(ApplicationModule_ProvideCustomerFactory.create(applicationModule2));
            this.providePilotSetterProvider = ApplicationModule_ProvidePilotSetterFactory.create(applicationModule2);
            this.getPaymentConfigurationRepositoryProvider = new GetPaymentConfigurationRepositoryProvider(mutableConfigurationRemoteCoreLibApi3);
            this.tokenizedBankCardToOldTokenizedBankCardMapperProvider = SingleCheck.provider(TokenizedBankCardToOldTokenizedBankCardMapper_Factory.create());
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi2);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            this.appInfoGlobalCustomerWrapperProvider = DoubleCheck.provider(AppInfoGlobalCustomerWrapper_Factory.create(this.provideApplicationContextProvider, this.provideCustomerProvider, this.providePilotSetterProvider, this.getPaymentConfigurationRepositoryProvider, this.tokenizedBankCardToOldTokenizedBankCardMapperProvider, getTalabatFeatureFlagProvider2));
            this.getMutableRepositoryProvider = new GetMutableRepositoryProvider(mutableConfigurationLocalCoreLibApi2);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi2);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            this.splashPreferencesProvider = DoubleCheck.provider(SplashPreferences_Factory.create(this.provideSharedPreferencesProvider, this.providePresentationUtilsProvider, this.provideCommonUtilsProvider, this.provideApplicationContextProvider, this.appInfoGlobalCustomerWrapperProvider, this.getMutableRepositoryProvider, getObservabilityManagerProvider2));
            this.clearOwinUseCaseImplProvider = ClearOwinUseCaseImpl_Factory.create(this.getTalabatFeatureFlagProvider, this.getObservabilityManagerProvider, this.provideApplicationContextProvider);
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getAuthenticationRepositoryProvider = new GetAuthenticationRepositoryProvider(authenticationCoreLibApi);
            this.migrationExchangeObservabilityUseCaseProvider = MigrationExchangeObservabilityUseCase_Factory.create(this.getObservabilityManagerProvider);
            GetTokenRepositoryProvider getTokenRepositoryProvider2 = new GetTokenRepositoryProvider(tokenCoreLibApi);
            this.getTokenRepositoryProvider = getTokenRepositoryProvider2;
            this.getAuthenticationTokenUseCaseProvider = GetAuthenticationTokenUseCase_Factory.create(this.provideApplicationContextProvider, this.provideCustomerProvider, this.clearOwinUseCaseImplProvider, this.getCoroutineDispatchersFactoryProvider, this.getTalabatFeatureFlagProvider, this.getAuthenticationRepositoryProvider, this.migrationExchangeObservabilityUseCaseProvider, getTokenRepositoryProvider2);
            this.networkHandlerProvider = DoubleCheck.provider(NetworkHandler_Factory.create(this.provideApplicationContextProvider));
            Provider<Retrofit> provider3 = DoubleCheck.provider(ApplicationModule_ProvideRetrofitFactory.create(applicationModule2));
            this.provideRetrofitProvider = provider3;
            this.splashServicesProvider = DoubleCheck.provider(SplashServices_Factory.create(provider3));
            this.getAppVersionProvider = new GetAppVersionProviderProvider(mutableConfigurationRemoteCoreLibApi3);
            this.getMutableRepositoryProvider2 = new GetMutableRepositoryProvider2(mutableConfigurationRemoteCoreLibApi3);
            GetMoshiProvider getMoshiProvider2 = new GetMoshiProvider(parserCoreLibApi);
            this.getMoshiProvider = getMoshiProvider2;
            AppInfoLocalDataSourceImp_Factory create = AppInfoLocalDataSourceImp_Factory.create(this.getAppVersionProvider, this.provideSharedPreferencesProvider, this.getMutableRepositoryProvider2, getMoshiProvider2);
            this.appInfoLocalDataSourceImpProvider = create;
            this.provideAppInfoLocalDataSourceProvider = ApplicationModule_ProvideAppInfoLocalDataSourceFactory.create(applicationModule3, create);
            this.appInfoGlobalConstantsWrapperProvider = DoubleCheck.provider(AppInfoGlobalConstantsWrapper_Factory.create(this.splashPreferencesProvider));
            this.trackingProvider = Tracking_Factory.create(this.provideApplicationContextProvider, this.getTalabatFeatureFlagProvider);
            this.getRepositoryProvider = new GetRepositoryProvider(mutableConfigurationLocalCoreLibApi2);
            this.getLocationConfigurationRepositoryProvider = new GetLocationConfigurationRepositoryProvider(mutableConfigurationRemoteCoreLibApi3);
            dagger.internal.Factory create2 = InstanceFactory.create(mutableConfigurationLocalCoreLibApi);
            this.mutableConfigurationLocalCoreLibApiProvider = create2;
            this.appInfoGlobalCountryWrapperProvider = DoubleCheck.provider(AppInfoGlobalCountryWrapper_Factory.create(this.splashPreferencesProvider, this.trackingProvider, this.getRepositoryProvider, this.getLocationConfigurationRepositoryProvider, create2, this.getObservabilityManagerProvider));
            this.getDiscoveryConfigurationRepositoryProvider = new GetDiscoveryConfigurationRepositoryProvider(mutableConfigurationRemoteCoreLibApi3);
            this.provideCoroutineDispatcherProvider = ApplicationModule_ProvideCoroutineDispatcherFactory.create(applicationModule2);
            this.getMutableLocationConfigurationRepositoryProvider = new GetMutableLocationConfigurationRepositoryProvider(mutableConfigurationRemoteCoreLibApi3);
            AppInfoRepositoryImpl_Factory create3 = AppInfoRepositoryImpl_Factory.create(this.networkHandlerProvider, this.splashServicesProvider, this.splashPreferencesProvider, this.provideAppInfoLocalDataSourceProvider, this.appInfoGlobalConstantsWrapperProvider, this.appInfoGlobalCountryWrapperProvider, this.appInfoGlobalCustomerWrapperProvider, this.getDiscoveryConfigurationRepositoryProvider, this.getLocationConfigurationRepositoryProvider, this.provideCoroutineDispatcherProvider, AppInfoResponseMapper_Factory.create(), this.getTalabatFeatureFlagProvider, this.getMutableLocationConfigurationRepositoryProvider);
            this.appInfoRepositoryImplProvider = create3;
            this.provideAppInfoRepositoryProvider = DoubleCheck.provider(ApplicationModule_ProvideAppInfoRepositoryFactory.create(applicationModule3, create3));
            this.providesRetrieveAndCacheCustomerAddressesUseCaseProvider = ApplicationModule_ProvidesRetrieveAndCacheCustomerAddressesUseCaseFactory.create(applicationModule3, this.provideApplicationContextProvider, this.getTalabatFeatureFlagProvider);
            this.providesUserStatusRepositoryProvider = ApplicationModule_ProvidesUserStatusRepositoryFactory.create(applicationModule2);
            this.getGetProCentralizationStatusUseCaseProvider = new GetGetProCentralizationStatusUseCaseProvider(subscriptionsFeatureApi3);
            GetSubscriptionsCustomerRepositoryProvider getSubscriptionsCustomerRepositoryProvider2 = new GetSubscriptionsCustomerRepositoryProvider(subscriptionsFeatureApi3);
            this.getSubscriptionsCustomerRepositoryProvider = getSubscriptionsCustomerRepositoryProvider2;
            ProCentralizationStatusWrapper_Factory create4 = ProCentralizationStatusWrapper_Factory.create(this.getGetProCentralizationStatusUseCaseProvider, getSubscriptionsCustomerRepositoryProvider2);
            this.proCentralizationStatusWrapperProvider = create4;
            this.provideCustomerInfoRepositoryProvider = ApplicationModule_ProvideCustomerInfoRepositoryFactory.create(applicationModule3, create4);
            this.provideCustomerRepositoryProvider = ApplicationModule_ProvideCustomerRepositoryFactory.create(applicationModule3, this.provideApplicationContextProvider);
            SplashCustomerInfoRepositoryImp_Factory create5 = SplashCustomerInfoRepositoryImp_Factory.create(this.provideCustomerInfoRepositoryProvider, this.provideCoroutineDispatcherProvider, this.getTalabatFeatureFlagProvider);
            this.splashCustomerInfoRepositoryImpProvider = create5;
            this.providesSplashCustomerInfoRepositoryProvider = DoubleCheck.provider(ApplicationModule_ProvidesSplashCustomerInfoRepositoryFactory.create(applicationModule3, create5));
            ApplicationModule_ProvideBrazeUserMigratorFactory create6 = ApplicationModule_ProvideBrazeUserMigratorFactory.create(applicationModule2);
            this.provideBrazeUserMigratorProvider = create6;
            this.getAppInfoUseCaseProvider = GetAppInfoUseCase_Factory.create(this.provideAppInfoRepositoryProvider, this.provideApplicationContextProvider, this.appInfoGlobalConstantsWrapperProvider, this.providesRetrieveAndCacheCustomerAddressesUseCaseProvider, this.providesUserStatusRepositoryProvider, this.provideCustomerInfoRepositoryProvider, this.provideCustomerRepositoryProvider, this.getLocationConfigurationRepositoryProvider, this.providesSplashCustomerInfoRepositoryProvider, create6);
            this.setAppConfigUseCaseProvider = SetAppConfigUseCase_Factory.create(this.provideAppInfoRepositoryProvider);
            this.getAppPreferncesUseCaseProvider = GetAppPreferncesUseCase_Factory.create(this.provideAppInfoRepositoryProvider);
            this.getAppLanguageUseCaseProvider = GetAppLanguageUseCase_Factory.create(this.provideAppInfoRepositoryProvider);
            ThirdPartyLibraryInfrastructureImpl_Factory create7 = ThirdPartyLibraryInfrastructureImpl_Factory.create(this.provideApplicationContextProvider, this.appInfoGlobalCountryWrapperProvider, this.getCoroutineDispatchersFactoryProvider);
            this.thirdPartyLibraryInfrastructureImplProvider = create7;
            Provider<ThirdPartyLibraryInfrastructure> provider4 = DoubleCheck.provider(ApplicationModule_ProvideThirdPartyLibraryInfrastructureFactory.create(applicationModule3, create7));
            this.provideThirdPartyLibraryInfrastructureProvider = provider4;
            this.getThirdPartyInitUseCaseProvider = GetThirdPartyInitUseCase_Factory.create(provider4);
            this.getRedirectionFlowUseCaseProvider = GetRedirectionFlowUseCase_Factory.create(this.splashPreferencesProvider);
            this.getSplashPhaseOneUseCaseProvider = GetSplashPhaseOneUseCase_Factory.create(this.splashPreferencesProvider);
            GetLocationRepositoryProvider getLocationRepositoryProvider2 = new GetLocationRepositoryProvider(locationCoreLibApi);
            this.getLocationRepositoryProvider = getLocationRepositoryProvider2;
            Provider<CLInfrastructureImpl> provider5 = DoubleCheck.provider(CLInfrastructureImpl_Factory.create(this.provideApplicationContextProvider, this.trackingProvider, getLocationRepositoryProvider2));
            this.cLInfrastructureImplProvider = provider5;
            Provider<CLInfrastrcture> provider6 = DoubleCheck.provider(ApplicationModule_ProvideCLRepositoryFactory.create(applicationModule3, provider5));
            this.provideCLRepositoryProvider = provider6;
            this.getCurrentLocationUseCaseProvider = GetCurrentLocationUseCase_Factory.create(provider6);
            this.getGpsStausUseCaseProvider = GetGpsStausUseCase_Factory.create(this.provideCLRepositoryProvider);
            this.getLocationPermissionStatusUseCaseProvider = GetLocationPermissionStatusUseCase_Factory.create(this.provideCLRepositoryProvider);
            this.getReverseGeoCodeCountryUseCaseProvider = GetReverseGeoCodeCountryUseCase_Factory.create(this.provideThirdPartyLibraryInfrastructureProvider);
            this.getDeviceDeepLinkUseCaseProvider = GetDeviceDeepLinkUseCase_Factory.create(this.splashPreferencesProvider);
            ApplicationModule_ProvideTalabatRemoteConfigurationFactory create8 = ApplicationModule_ProvideTalabatRemoteConfigurationFactory.create(applicationModule2);
            this.provideTalabatRemoteConfigurationProvider = create8;
            SplashConfigurationRemoteDataSource_Factory create9 = SplashConfigurationRemoteDataSource_Factory.create(create8);
            this.splashConfigurationRemoteDataSourceProvider = create9;
            this.provideSplashConfigurationRepositoryProvider = ApplicationModule_ProvideSplashConfigurationRepositoryFactory.create(applicationModule3, create9);
            this.provideWorkManagerProvider = ApplicationModule_ProvideWorkManagerFactory.create(applicationModule2);
            ApplicationModule_ProvideLocalCacheFactory create10 = ApplicationModule_ProvideLocalCacheFactory.create(applicationModule2);
            this.provideLocalCacheProvider = create10;
            DownloadManager_Factory create11 = DownloadManager_Factory.create(this.provideWorkManagerProvider, create10, this.provideApplicationContextProvider);
            this.downloadManagerProvider = create11;
            ApplicationModule_ProvideDownloadsRepositoryFactory create12 = ApplicationModule_ProvideDownloadsRepositoryFactory.create(applicationModule3, create11);
            this.provideDownloadsRepositoryProvider = create12;
            this.provideGetDynamicSplashContentUseCaseProvider = ApplicationModule_ProvideGetDynamicSplashContentUseCaseFactory.create(applicationModule3, this.provideSplashConfigurationRepositoryProvider, create12);
            this.splashConfigProvider = SplashConfig_Factory.create(this.splashPreferencesProvider, this.getTalabatFeatureFlagProvider);
            this.clearOwinStartupUseCaseImplProvider = ClearOwinStartupUseCaseImpl_Factory.create(this.clearOwinUseCaseImplProvider, this.getTokenRepositoryProvider, this.getObservabilityManagerProvider);
            IsOnboardingExperimentEnabledUseCaseProvider isOnboardingExperimentEnabledUseCaseProvider2 = r1;
            IsOnboardingExperimentEnabledUseCaseProvider isOnboardingExperimentEnabledUseCaseProvider3 = new IsOnboardingExperimentEnabledUseCaseProvider(onBoardingExperimentApi);
            this.isOnboardingExperimentEnabledUseCaseProvider = isOnboardingExperimentEnabledUseCaseProvider3;
            this.splashActivitySharedViewModelProvider = SplashActivitySharedViewModel_Factory.create(this.getAuthenticationTokenUseCaseProvider, this.getAppInfoUseCaseProvider, this.setAppConfigUseCaseProvider, this.getAppPreferncesUseCaseProvider, this.getAppLanguageUseCaseProvider, this.getThirdPartyInitUseCaseProvider, this.getRedirectionFlowUseCaseProvider, this.providePresentationUtilsProvider, this.getSplashPhaseOneUseCaseProvider, this.getCurrentLocationUseCaseProvider, this.getGpsStausUseCaseProvider, this.getLocationPermissionStatusUseCaseProvider, this.getReverseGeoCodeCountryUseCaseProvider, this.getDeviceDeepLinkUseCaseProvider, this.trackingProvider, this.provideGetDynamicSplashContentUseCaseProvider, this.getMutableRepositoryProvider, this.getTalabatFeatureFlagProvider, this.splashConfigProvider, this.clearOwinStartupUseCaseImplProvider, isOnboardingExperimentEnabledUseCaseProvider2);
            MapProviderFactory build = MapProviderFactory.builder(1).put((Object) SplashActivitySharedViewModel.class, (Provider) this.splashActivitySharedViewModelProvider).build();
            this.mapOfClassOfAndProviderOfViewModelProvider = build;
            this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(build));
            this.navigatorProvider = DoubleCheck.provider(Navigator_Factory.create());
        }

        @CanIgnoreReturnValue
        private Cart injectCart(Cart cart) {
            Cart_MembersInjector.injectTalabatFeatureFlag(cart, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            Cart_MembersInjector.injectCartUtility(cart, cartUtility());
            return cart;
        }

        @CanIgnoreReturnValue
        private SplashActivity injectSplashActivity(SplashActivity splashActivity) {
            SplashActivity_MembersInjector.injectViewModelFactory(splashActivity, this.viewModelFactoryProvider.get());
            SplashActivity_MembersInjector.injectNavigator(splashActivity, this.navigatorProvider.get());
            SplashActivity_MembersInjector.injectPresentationUtils(splashActivity, this.providePresentationUtilsProvider.get());
            SplashActivity_MembersInjector.injectTalabatFeatureFlag(splashActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            SplashActivity_MembersInjector.injectDeepLinkNavigator(splashActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            SplashActivity_MembersInjector.injectObservabilityManager(splashActivity, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return splashActivity;
        }

        @CanIgnoreReturnValue
        private TalabatApplication injectTalabatApplication(TalabatApplication talabatApplication) {
            TalabatApplication_MembersInjector.injectSplashPreferences(talabatApplication, this.splashPreferencesProvider.get());
            TalabatApplication_MembersInjector.injectConfigurationRemoteCoreLibApi(talabatApplication, this.mutableConfigurationRemoteCoreLibApi);
            TalabatApplication_MembersInjector.injectCustomerInfoRepository(talabatApplication, customerInfoRepository());
            TalabatApplication_MembersInjector.injectFWFManager(talabatApplication, (IFWFManager) Preconditions.checkNotNullFromComponent(this.fWFCoreLibApi.getFwfManager()));
            TalabatApplication_MembersInjector.injectVoucherCampaignDeeplinkUseCase(talabatApplication, (VoucherCampaignDeeplinkUseCase) Preconditions.checkNotNullFromComponent(this.campaignMigratorFeatureApi.getVoucherCampaignDeeplinkUseCase()));
            TalabatApplication_MembersInjector.injectScreenTracker(talabatApplication, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            TalabatApplication_MembersInjector.injectMessagingServiceType(talabatApplication, messagingServiceType());
            return talabatApplication;
        }

        private MessagingServiceType messagingServiceType() {
            return MessagingModule_MessagingServiceTypeFactory.messagingServiceType(this.messagingModule, this.gmsBaseCoreLibApi.isGmsAvailable(), this.hmsBaseCoreLibApi.isHmsAvailable());
        }

        private ProCentralizationStatusWrapper proCentralizationStatusWrapper() {
            return new ProCentralizationStatusWrapper((GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase()), (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
        }

        public void inject(TalabatApplication talabatApplication) {
            injectTalabatApplication(talabatApplication);
        }

        public void inject(SplashActivity splashActivity) {
            injectSplashActivity(splashActivity);
        }

        public void inject(Cart cart) {
            injectCart(cart);
        }
    }

    public static final class Factory implements ApplicationComponent.Factory {
        private Factory() {
        }

        public ApplicationComponent create(AuthenticationCoreLibApi authenticationCoreLibApi, ApplicationModule applicationModule, DeepLinkCoreLibApi deepLinkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi, HmsBaseCoreLibApi hmsBaseCoreLibApi, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, ParserCoreLibApi parserCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FoodCartFeatureApi foodCartFeatureApi, FWFCoreLibApi fWFCoreLibApi, CampaignMigratorFeatureApi campaignMigratorFeatureApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenCoreLibApi tokenCoreLibApi, OnBoardingExperimentApi onBoardingExperimentApi) {
            ApplicationModule applicationModule2 = applicationModule;
            FWFCoreLibApi fWFCoreLibApi2 = fWFCoreLibApi;
            Preconditions.checkNotNull(authenticationCoreLibApi);
            Preconditions.checkNotNull(applicationModule);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(gmsBaseCoreLibApi);
            Preconditions.checkNotNull(hmsBaseCoreLibApi);
            Preconditions.checkNotNull(locationCoreLibApi);
            Preconditions.checkNotNull(mapsCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(foodCartFeatureApi);
            Preconditions.checkNotNull(fWFCoreLibApi);
            Preconditions.checkNotNull(campaignMigratorFeatureApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibApi);
            Preconditions.checkNotNull(onBoardingExperimentApi);
            MessagingModule messagingModule = r21;
            MessagingModule messagingModule2 = new MessagingModule();
            return new ApplicationComponentImpl(applicationModule2, messagingModule, authenticationCoreLibApi, deepLinkCoreLibApi, dispatcherCoreLibApi, gmsBaseCoreLibApi, hmsBaseCoreLibApi, locationCoreLibApi, mapsCoreLibApi, mutableConfigurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi, parserCoreLibApi, subscriptionsFeatureApi, featureFlagCoreLibApi, fWFCoreLibApi2, foodCartFeatureApi, campaignMigratorFeatureApi, observabilityCoreLibApi, tokenCoreLibApi, onBoardingExperimentApi);
        }
    }

    private DaggerApplicationComponent() {
    }

    public static ApplicationComponent.Factory factory() {
        return new Factory();
    }
}
