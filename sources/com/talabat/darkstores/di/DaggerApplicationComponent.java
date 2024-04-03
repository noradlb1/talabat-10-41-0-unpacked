package com.talabat.darkstores.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.darkstores.common.TimeProvider;
import com.talabat.darkstores.common.helpers.Base64Helper;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.NetworkConnectionInterceptor;
import com.talabat.darkstores.data.NetworkConnectionInterceptor_Factory;
import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.basket.BasketUpsellRepositoryImpl;
import com.talabat.darkstores.data.darkstores.AuthHeaderInterceptor;
import com.talabat.darkstores.data.darkstores.DarkstoresApi;
import com.talabat.darkstores.data.darkstores.DarkstoresHeaderInterceptor;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo_Factory;
import com.talabat.darkstores.data.darkstores.PlatformHeaderInterceptor_Factory;
import com.talabat.darkstores.data.darkstores.mapper.CartResponseMapper_Factory;
import com.talabat.darkstores.data.deliveryfee.FlutterDeliveryTierMapper;
import com.talabat.darkstores.data.disclaimer.DisclaimerRepositoryImpl;
import com.talabat.darkstores.data.disclaimer.DisclaimerRepositoryImpl_Factory;
import com.talabat.darkstores.data.discovery.DiscoveryApi;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo_Factory;
import com.talabat.darkstores.data.discovery.FeedApi;
import com.talabat.darkstores.data.discovery.ProductApi;
import com.talabat.darkstores.data.discovery.mappers.BannerDomainToViewModelMapper_Factory;
import com.talabat.darkstores.data.discovery.mappers.SortOptionMapper_Factory;
import com.talabat.darkstores.data.discovery.mappers.SubcategorySwimlanesResultMapper;
import com.talabat.darkstores.data.discovery.mappers.SubcategorySwimlanesResultMapper_Factory;
import com.talabat.darkstores.data.discovery.mappers.VendorLandingToFeedsMapper;
import com.talabat.darkstores.data.discovery.mappers.VendorLandingToFeedsMapper_Factory;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import com.talabat.darkstores.data.discovery.model.NetworkSortOption;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo_Factory;
import com.talabat.darkstores.data.grocery.GroceryBaseUrl;
import com.talabat.darkstores.data.grocery.GroceryBaseUrl_Factory;
import com.talabat.darkstores.data.grocery.GroceryShoppingApi;
import com.talabat.darkstores.data.grocery.GroceryShoppingRepository;
import com.talabat.darkstores.data.grocery.GroceryShoppingRepository_Factory;
import com.talabat.darkstores.data.lookingglass.LookingGlassVoucherApi;
import com.talabat.darkstores.data.mission.control.MissionControlProductApi;
import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.darkstores.data.mission.control.MissionControlProductRepository_Factory;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentApi;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo_Factory;
import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl;
import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl_Factory;
import com.talabat.darkstores.data.search.QCommerceGroceryApi;
import com.talabat.darkstores.data.search.QCommerceSearchApi;
import com.talabat.darkstores.data.search.SearchApi;
import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.SearchRepository_Factory;
import com.talabat.darkstores.data.swimlanes.SwimlanesProductRepository;
import com.talabat.darkstores.data.swimlanes.SwimlanesProductRepository_Factory;
import com.talabat.darkstores.data.swimlanes.SwimlanseProductApi;
import com.talabat.darkstores.data.tracking.BaseTracker;
import com.talabat.darkstores.data.tracking.BaseTracker_Factory;
import com.talabat.darkstores.data.tracking.HomeTracker;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider_Factory;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider_Factory;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.data.tracking.SearchTracker_Factory;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider_Factory;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTracker;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTrackerImpl;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTrackerImpl_Factory;
import com.talabat.darkstores.data.tracking.fees.tracker.DarkstoresFeesTracker;
import com.talabat.darkstores.data.tracking.fees.tracker.DarkstoresFeesTracker_Factory;
import com.talabat.darkstores.data.tracking.fees.tracker.IDarkstoresFeesTracker;
import com.talabat.darkstores.data.tracking.impression.BannerImpressionMapper;
import com.talabat.darkstores.data.tracking.impression.BannerImpressionMapper_Factory;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker_Factory;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTracker;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTrackerImpl;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTrackerImpl_Factory;
import com.talabat.darkstores.data.vendors.remote.VendorsApi;
import com.talabat.darkstores.di.ApplicationComponent;
import com.talabat.darkstores.domain.banner.IsFlutterBannerProductListingEnabledUseCaseImpl;
import com.talabat.darkstores.domain.basket.BasketUpsellRepository;
import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCaseImpl;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCaseImpl;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCaseImpl;
import com.talabat.darkstores.domain.cart.IsFlutterCartEnabledUseCaseImpl;
import com.talabat.darkstores.domain.cart.IsFlutterCartEnabledUseCaseImpl_Factory;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCaseImpl;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCaseImpl_Factory;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCaseImpl_Factory;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCaseImpl_Factory;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.GetFlutterConfigurationParamsUseCaseImpl;
import com.talabat.darkstores.domain.common.GetFlutterConfigurationParamsUseCaseImpl_Factory;
import com.talabat.darkstores.domain.common.IsFlutterVLPEnabledUseCaseImpl;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapperImpl_Factory;
import com.talabat.darkstores.domain.presearch.GetPreSearchSwimlaneUseCaseImpl;
import com.talabat.darkstores.domain.products.CheckFlutterCategoryProductsEnabledUseCaseImpl;
import com.talabat.darkstores.domain.swimlanes.CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl;
import com.talabat.darkstores.domain.voucher.IsVoucherBottomSheetNavigationEnabledUseCaseImpl;
import com.talabat.darkstores.feature.campaigns.CampaignProgressSourceMapper_Factory;
import com.talabat.darkstores.feature.campaigns.CampaignProgressStateMapper;
import com.talabat.darkstores.feature.campaigns.CampaignProgressStateSource;
import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase;
import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase_Factory;
import com.talabat.darkstores.feature.cart.CampaignProgressUseCase;
import com.talabat.darkstores.feature.cart.CartController;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.cart.CartSwimlaneUseCase;
import com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCase;
import com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCaseImpl;
import com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory;
import com.talabat.darkstores.feature.cart.PostCartUseCase;
import com.talabat.darkstores.feature.cart.cartabadonment.StartCartClearedEventTrackerUseCase;
import com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase;
import com.talabat.darkstores.feature.cart.views.CartProgressContract;
import com.talabat.darkstores.feature.cart.views.CartProgressViewPresenter;
import com.talabat.darkstores.feature.categories.CategoriesFragmentViewModel;
import com.talabat.darkstores.feature.categories.subcategories.C0475SubcategoriesFragmentViewModel_Factory;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel_Factory_Impl;
import com.talabat.darkstores.feature.categories.subcategories.experiment.C0476SubcategoriesFragmentViewModelNew_Factory;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew_Factory_Impl;
import com.talabat.darkstores.feature.categories.subcategories.sort.GetSortOnPLPEnabledUseCaseImpl;
import com.talabat.darkstores.feature.categories.subcategories.sort.GetSortOnPLPEnabledUseCaseImpl_Factory;
import com.talabat.darkstores.feature.categories.subcategories.sort.SortOptionBottomSheetViewModel;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewFragmentViewModel;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import com.talabat.darkstores.feature.home.HomeFragmentViewModel;
import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCaseImpl_Factory;
import com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCaseImpl;
import com.talabat.darkstores.feature.main.usecase.GenerateVoucherUseCaseImpl;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierBottomSheetViewStateViewModel;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase_Factory;
import com.talabat.darkstores.feature.mission.control.GetPrimaryMissionControlProductsUseCase;
import com.talabat.darkstores.feature.mission.control.GetPrimaryMissionControlProductsUseCase_Factory;
import com.talabat.darkstores.feature.mission.control.MainViewModel;
import com.talabat.darkstores.feature.model.mapper.PreSearchSwimlaneToListItemsMapperImpl;
import com.talabat.darkstores.feature.model.mapper.RecentSearchesToListItemsMapperImpl;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import com.talabat.darkstores.feature.product.C0477ProductFragmentViewModel_Factory;
import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.darkstores.feature.product.ProductFragmentViewModel_Factory_Impl;
import com.talabat.darkstores.feature.product.usecase.GetSwimlaneProductUseCase;
import com.talabat.darkstores.feature.product.usecase.GetSwimlaneProductUseCase_Factory;
import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase_Factory;
import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import com.talabat.darkstores.feature.searchCategory.SearchCategoryUseCase;
import com.talabat.darkstores.feature.searchResults.C0478SearchResultsFragmentViewModel_Factory;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel_Factory_Impl;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase_Factory;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactoryImpl;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactoryImpl_Factory;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider_Factory;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesRepository;
import com.talabat.feature.darkstores.vendorlanding.domain.VendorLandingFeatureApi;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import com.talabat.feature.darkstorescampaignmessage.domain.CampaignMessagingApi;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.feature.darkstorescampaignmessage.domain.usecase.GetCampaignMessageUseCase;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.features.swimlanevoucherslist.domain.LoadCustomerVouchersSwimLaneUseCase;
import com.talabat.features.swimlanevoucherslist.domain.LoadCustomerVouchersSwimLaneUseCase_Factory;
import com.talabat.features.swimlanevoucherslist.domain.di.CustomerVouchersSwimLaneFeaturesApi;
import com.talabat.features.swimlanevoucherslist.domain.repository.CustomerVouchersSwimLaneRepository;
import com.talabat.impressiontracking.TalabatImpressionTracker;
import com.talabat.mapper.ModelMapper;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerApplicationComponent {

    public static final class ApplicationComponentImpl implements ApplicationComponent {
        private final ApplicationComponentImpl applicationComponentImpl;
        private final Context applicationContext;
        private Provider<Context> applicationContextProvider;
        private Provider<ApplyDiscountsAndCampaignsUseCaseImpl> applyDiscountsAndCampaignsUseCaseImplProvider;
        private Provider<BaseTracker> baseTrackerProvider;
        private final BaseUrlFactory baseUrlFactory;
        private Provider<BaseUrlFactory> baseUrlFactoryProvider;
        private Provider<BasketLifeTimeTooltipUseCase> basketLifeTimeTooltipUseCaseProvider;
        private Provider<ModelMapper<CampaignSource, CampaignProgressStateSource>> bindCampaignProgressSourceMapperProvider;
        private Provider<GroceryDeliveryFeeTierFeatureFlagUseCase> bindGroceryDeliveryFeeTierFeatureFlagUseCaseProvider;
        private Provider<SortAndFilterOptionTracker> bindSortAndFilterOptionTrackerProvider;
        private Provider<ModelMapper<NetworkSortOption, SortOption>> bindSortOptionMapperProvider;
        private Provider<ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse>> bindSubcategoruSwimlanesResultMapperProvider;
        private Provider<ModelMapper<VendorLanding, FeedMultiListData>> bindVendorLandingToFeedsMapperProvider;
        private Provider<BuildCartNavigationActionUseCaseImpl> buildCartNavigationActionUseCaseImplProvider;
        private Provider<BuildSearchNavigationActionUseCaseImpl> buildSearchNavigationActionUseCaseImplProvider;
        private final CampaignMessagingApi campaignMessagingApi;
        private Provider<DarkstoresCartRepository> cartRepositoryProvider;
        private final ConfigurationParameters configurationParameters;
        private Provider<ConfigurationParameters> configurationParametersProvider;
        private final CustomerCoreLibApi customerCoreLibApi;
        private Provider<DarkStoreBottomSheetTrackerImpl> darkStoreBottomSheetTrackerImplProvider;
        private final DarkstoresCampaignMessageModule darkstoresCampaignMessageModule;
        private final DarkstoresCartApi darkstoresCartApi;
        private final DarkstoresCartListApi darkstoresCartListApi;
        private final DarkstoresDatabaseModule darkstoresDatabaseModule;
        private Provider<DarkstoresFeesTracker> darkstoresFeesTrackerProvider;
        private Provider<DarkstoresRepo> darkstoresRepoProvider;
        private Provider<DarkstoresRepositoryImpl> darkstoresRepositoryImplProvider;
        private Provider<DeliveryDetailsRepo> deliveryDetailsRepoProvider;
        private Provider<DisclaimerRepositoryImpl> disclaimerRepositoryImplProvider;
        private Provider<DiscoveryRepo> discoveryRepoProvider;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private Provider<SearchResultsFragmentViewModel.Factory> factoryProvider;
        private Provider<ProductFragmentViewModel.Factory> factoryProvider2;
        private Provider<SubcategoriesFragmentViewModel.Factory> factoryProvider3;
        private Provider<SubcategoriesFragmentViewModelNew.Factory> factoryProvider4;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<AppVersionProvider> getAppVersionProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<GetFlutterConfigurationParamsUseCaseImpl> getFlutterConfigurationParamsUseCaseImplProvider;
        private Provider<GetLifestyleMissionControlProductsUseCase> getLifestyleMissionControlProductsUseCaseProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<GetPrimaryMissionControlProductsUseCase> getPrimaryMissionControlProductsUseCaseProvider;
        private Provider<IRemoteConfigurationDataSource> getRemoteConfigurationDataSourceProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<SwimlanesRepository> getRepositoryProvider2;
        private Provider<RxSchedulersFactory> getRxSchedulersFactoryProvider;
        private Provider<IScreenTracker> getScreenTrackerProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<GetSortOnPLPEnabledUseCaseImpl> getSortOnPLPEnabledUseCaseImplProvider;
        private Provider<GetSwimlaneProductUseCase> getSwimlaneProductUseCaseProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<GetVendorLightningOptimizationExpVariantUseCaseImpl> getVendorLightningOptimizationExpVariantUseCaseImplProvider;
        private Provider<CustomerVouchersSwimLaneRepository> getVouchersSwimLaneRepositoryProvider;
        private Provider<GroceryDeliveryFeeTierFeatureFlagUseCaseImpl> groceryDeliveryFeeTierFeatureFlagUseCaseImplProvider;
        private Provider<GroceryShoppingRepository> groceryShoppingRepositoryProvider;
        private final Gson gson;
        private Provider<Gson> gsonProvider;
        private Provider<IsFlutterCartEnabledUseCaseImpl> isFlutterCartEnabledUseCaseImplProvider;
        private Provider<LoadCustomerVouchersSwimLaneUseCase> loadCustomerVouchersSwimLaneUseCaseProvider;
        private Provider<LocationTrackingProvider> locationTrackingProvider;
        private Provider<MissionControlProductRepository> missionControlProductRepositoryProvider;
        private Provider<NetworkConnectionInterceptor> networkConnectionInterceptorProvider;
        private final NonMigratedCartModule nonMigratedCartModule;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<PagingSourceFactoryImpl> pagingSourceFactoryImplProvider;
        private Provider<PartialFulfillmentRepo> partialFulfillmentRepoProvider;
        private C0477ProductFragmentViewModel_Factory productFragmentViewModelProvider;
        private Provider<ProductSwimlanesUseCase> productSwimlanesUseCaseProvider;
        private Provider<ProductTrackingProvider> productTrackingProvider;
        private Provider<AuthHeaderInterceptor> provideAuthHeaderInterceptorProvider;
        private Provider<Retrofit.Builder> provideBaseRetrofitBuilderProvider;
        private Provider<BasketApi> provideBasketApiProvider;
        private Provider<DarkStoreBottomSheetTracker> provideBottomSheetEventTrackerProvider;
        private Provider<ProductTracker> provideCategoryTrackerProvider;
        private Provider<DarkStoreObservabilityTracker> provideDarkStoreObservabilityTrackerProvider;
        private Provider<String> provideDarkstoresBaseUrlProvider;
        private Provider<DarkstoresEventTracker> provideDarkstoresEventTrackerProvider;
        private Provider<DarkstoresHeaderInterceptor> provideDarkstoresHeaderInterceptorProvider;
        private Provider<OkHttpClient> provideDarkstoresOkHttpProvider;
        private Provider<DarkstoresRepository> provideDarkstoresRepositoryProvider;
        private Provider<DisclaimerRepository> provideDisclaimerRepositoryProvider;
        private Provider<DiscoveryApi> provideDiscoveryApiProvider;
        private Provider<String> provideDiscoveryBaseUrlProvider;
        private Provider<DarkstoresApi> provideDjiniApiProvider;
        private Provider<FeedApi> provideFeedApiProvider;
        private Provider<GroceryShoppingApi> provideGroceryShoppingApiProvider;
        private Provider<TalabatImpressionTracker> provideImpressionTrackerProvider;
        private Provider<LookingGlassVoucherApi> provideLookingGlassVoucherApiProvider;
        private Provider<MissionControlProductApi> provideMissionControlProductApiProvider;
        private Provider<Moshi> provideMoshiProvider;
        private Provider<OkHttpClient> provideOkHttpProvider;
        private Provider<PartialFulfillmentApi> providePartialFulfillmentApiProvider;
        private Provider<String> providePartialFulfillmentBaseUrlProvider;
        private Provider<ProductApi> provideProductApiProvider;
        private Provider<ProductImpressionTracker> provideProductImpressionTrackerProvider;
        private Provider<QCommerceGroceryApi> provideQCGroceryCategorySearchApiProvider;
        private Provider<String> provideQCommerceGroceryUrlProvider;
        private Provider<QCommerceSearchApi> provideQCommerceSearchApiProvider;
        private Provider<SearchApi> provideSearchApiProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<SwimlanseProductApi> provideSwimlanseProductApiProvider;
        private Provider<TalabatAPIBuilder> provideTalabatApiBuilderProvider;
        private Provider<String> provideVendorBaseUrlProvider;
        private Provider<VendorsApi> provideVendorsApiProvider;
        private Provider<Base64Helper> providesBase64HelperProvider;
        private Provider<IDarkstoresFeesTracker> providesFeesTrackerProvider;
        private final RemoteConfigCoreLibApi remoteConfigCoreLibApi;
        private Provider<SearchRepository> searchRepositoryProvider;
        private C0478SearchResultsFragmentViewModel_Factory searchResultsFragmentViewModelProvider;
        private Provider<SearchResultsUseCase> searchResultsUseCaseProvider;
        private Provider<SearchTracker> searchTrackerProvider;
        private Provider<SortAndFilterOptionTrackerImpl> sortAndFilterOptionTrackerImplProvider;
        private Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;
        private C0476SubcategoriesFragmentViewModelNew_Factory subcategoriesFragmentViewModelNewProvider;
        private C0475SubcategoriesFragmentViewModel_Factory subcategoriesFragmentViewModelProvider;
        private Provider<SubcategorySwimlanesResultMapper> subcategorySwimlanesResultMapperProvider;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;
        private Provider<SwimlanesProductRepository> swimlanesProductRepositoryProvider;
        private Provider<SwimlanesTracker> swimlanesTrackerProvider;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private final VendorLandingFeatureApi vendorLandingFeatureApi;
        private Provider<VendorLandingToFeedsMapper> vendorLandingToFeedsMapperProvider;
        private Provider<VendorRepository> vendorRepositoryProvider;

        public static final class CartRepositoryProvider implements Provider<DarkstoresCartRepository> {
            private final DarkstoresCartApi darkstoresCartApi;

            public CartRepositoryProvider(DarkstoresCartApi darkstoresCartApi2) {
                this.darkstoresCartApi = darkstoresCartApi2;
            }

            public DarkstoresCartRepository get() {
                return (DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository());
            }
        }

        public static final class GetAppVersionProviderProvider implements Provider<AppVersionProvider> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetAppVersionProviderProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public AppVersionProvider get() {
                return (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider());
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

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetRemoteConfigurationDataSourceProvider implements Provider<IRemoteConfigurationDataSource> {
            private final RemoteConfigCoreLibApi remoteConfigCoreLibApi;

            public GetRemoteConfigurationDataSourceProvider(RemoteConfigCoreLibApi remoteConfigCoreLibApi2) {
                this.remoteConfigCoreLibApi = remoteConfigCoreLibApi2;
            }

            public IRemoteConfigurationDataSource get() {
                return (IRemoteConfigurationDataSource) Preconditions.checkNotNullFromComponent(this.remoteConfigCoreLibApi.getRemoteConfigurationDataSource());
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

        public static final class GetRepositoryProvider2 implements Provider<SwimlanesRepository> {
            private final SwimlanesFeatureApi swimlanesFeatureApi;

            public GetRepositoryProvider2(SwimlanesFeatureApi swimlanesFeatureApi2) {
                this.swimlanesFeatureApi = swimlanesFeatureApi2;
            }

            public SwimlanesRepository get() {
                return (SwimlanesRepository) Preconditions.checkNotNullFromComponent(this.swimlanesFeatureApi.getRepository());
            }
        }

        public static final class GetRxSchedulersFactoryProvider implements Provider<RxSchedulersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetRxSchedulersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public RxSchedulersFactory get() {
                return (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory());
            }
        }

        public static final class GetScreenTrackerProvider implements Provider<IScreenTracker> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetScreenTrackerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IScreenTracker get() {
                return (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker());
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

        public static final class GetVouchersSwimLaneRepositoryProvider implements Provider<CustomerVouchersSwimLaneRepository> {
            private final CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi;

            public GetVouchersSwimLaneRepositoryProvider(CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi2) {
                this.customerVouchersSwimLaneFeaturesApi = customerVouchersSwimLaneFeaturesApi2;
            }

            public CustomerVouchersSwimLaneRepository get() {
                return (CustomerVouchersSwimLaneRepository) Preconditions.checkNotNullFromComponent(this.customerVouchersSwimLaneFeaturesApi.getVouchersSwimLaneRepository());
            }
        }

        public static final class VendorRepositoryProvider implements Provider<VendorRepository> {
            private final DarkstoresVendorApi darkstoresVendorApi;

            public VendorRepositoryProvider(DarkstoresVendorApi darkstoresVendorApi2) {
                this.darkstoresVendorApi = darkstoresVendorApi2;
            }

            public VendorRepository get() {
                return (VendorRepository) Preconditions.checkNotNullFromComponent(this.darkstoresVendorApi.vendorRepository());
            }
        }

        private ApplicationComponentImpl(DarkstoresCampaignMessageModule darkstoresCampaignMessageModule2, DarkstoresDatabaseModule darkstoresDatabaseModule2, NonMigratedCartModule nonMigratedCartModule2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, CustomerCoreLibApi customerCoreLibApi2, DarkstoresCartApi darkstoresCartApi2, DarkstoresCartListApi darkstoresCartListApi2, DarkstoresFlutterCartApi darkstoresFlutterCartApi, DarkstoresVendorApi darkstoresVendorApi, DeepLinkCoreLibApi deepLinkCoreLibApi, CampaignMessagingApi campaignMessagingApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, SecretCoreLibApi secretCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, SwimlanesFeatureApi swimlanesFeatureApi, VendorLandingFeatureApi vendorLandingFeatureApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi, Context context, ConfigurationParameters configurationParameters2, Gson gson2, BaseUrlFactory baseUrlFactory2) {
            this.applicationComponentImpl = this;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.configurationParameters = configurationParameters2;
            this.darkstoresCartApi = darkstoresCartApi2;
            this.darkstoresCartListApi = darkstoresCartListApi2;
            this.darkstoresDatabaseModule = darkstoresDatabaseModule2;
            this.applicationContext = context;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.gson = gson2;
            this.vendorLandingFeatureApi = vendorLandingFeatureApi2;
            this.remoteConfigCoreLibApi = remoteConfigCoreLibApi2;
            this.baseUrlFactory = baseUrlFactory2;
            this.campaignMessagingApi = campaignMessagingApi2;
            this.darkstoresCampaignMessageModule = darkstoresCampaignMessageModule2;
            this.nonMigratedCartModule = nonMigratedCartModule2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            initialize(darkstoresCampaignMessageModule2, darkstoresDatabaseModule2, nonMigratedCartModule2, configurationLocalCoreLibApi, configurationRemoteCoreLibApi, customerCoreLibApi2, darkstoresCartApi2, darkstoresCartListApi2, darkstoresFlutterCartApi, darkstoresVendorApi, deepLinkCoreLibApi, campaignMessagingApi2, dispatcherCoreLibApi2, featureFlagCoreLibApi2, secretCoreLibApi, trackingCoreLibApi2, subscriptionsFeatureApi2, swimlanesFeatureApi, vendorLandingFeatureApi2, observabilityCoreLibApi2, customerVouchersSwimLaneFeaturesApi, remoteConfigCoreLibApi2, navigationCoreLibApi, context, configurationParameters2, gson2, baseUrlFactory2);
            initialize2(darkstoresCampaignMessageModule2, darkstoresDatabaseModule2, nonMigratedCartModule2, configurationLocalCoreLibApi, configurationRemoteCoreLibApi, customerCoreLibApi2, darkstoresCartApi2, darkstoresCartListApi2, darkstoresFlutterCartApi, darkstoresVendorApi, deepLinkCoreLibApi, campaignMessagingApi2, dispatcherCoreLibApi2, featureFlagCoreLibApi2, secretCoreLibApi, trackingCoreLibApi2, subscriptionsFeatureApi2, swimlanesFeatureApi, vendorLandingFeatureApi2, observabilityCoreLibApi2, customerVouchersSwimLaneFeaturesApi, remoteConfigCoreLibApi2, navigationCoreLibApi, context, configurationParameters2, gson2, baseUrlFactory2);
        }

        private BasketUpsellRepository basketUpsellRepository() {
            return DarkstoreBasketUpsellModule_ProvidesBasketUpsellRepositoryFactory.providesBasketUpsellRepository(basketUpsellRepositoryImpl());
        }

        private BasketUpsellRepositoryImpl basketUpsellRepositoryImpl() {
            return new BasketUpsellRepositoryImpl(DarkstoreBasketUpsellModule_ProvidesBasketUpsellLocalDataSourceFactory.providesBasketUpsellLocalDataSource());
        }

        private BuildBannerCampaignProductListingNavigationUseCaseImpl buildBannerCampaignProductListingNavigationUseCaseImpl() {
            return new BuildBannerCampaignProductListingNavigationUseCaseImpl(isFlutterBannerProductListingEnabledUseCaseImpl(), getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildBasketUpsellActionUseCase buildBasketUpsellActionUseCase() {
            return DarkstoreBasketUpsellModule_ProvidesBuildBasketUpsellActionUseCaseImplFactory.providesBuildBasketUpsellActionUseCaseImpl(buildBasketUpsellActionUseCaseImpl());
        }

        private BuildBasketUpsellActionUseCaseImpl buildBasketUpsellActionUseCaseImpl() {
            return new BuildBasketUpsellActionUseCaseImpl(isBasketUpsellExperimentEnabledUseCase(), isBasketUpsellBottomSheetShownUseCase(), getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildCartNavigationActionUseCaseImpl buildCartNavigationActionUseCaseImpl() {
            return new BuildCartNavigationActionUseCaseImpl(isFlutterCartEnabledUseCaseImpl(), getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildCategoryProductsNavigationActionUseCaseImpl buildCategoryProductsNavigationActionUseCaseImpl() {
            return new BuildCategoryProductsNavigationActionUseCaseImpl(checkFlutterCategoryProductsEnabledUseCaseImpl(), getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildDeliveryFeeTierNavigationUseCaseImpl buildDeliveryFeeTierNavigationUseCaseImpl() {
            return new BuildDeliveryFeeTierNavigationUseCaseImpl(getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildLifestyleSearchResultNavigationActionUseCaseImpl buildLifestyleSearchResultNavigationActionUseCaseImpl() {
            return new BuildLifestyleSearchResultNavigationActionUseCaseImpl(checkFlutterSwimlanesSearchResultEnabledUseCaseImpl(), getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildSearchNavigationActionUseCaseImpl buildSearchNavigationActionUseCaseImpl() {
            return new BuildSearchNavigationActionUseCaseImpl(getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildSwimlanesSearchResultNavigationActionUseCaseImpl buildSwimlanesSearchResultNavigationActionUseCaseImpl() {
            return new BuildSwimlanesSearchResultNavigationActionUseCaseImpl(checkFlutterSwimlanesSearchResultEnabledUseCaseImpl(), getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildTalabatAiNavigationActionUseCaseImpl buildTalabatAiNavigationActionUseCaseImpl() {
            return new BuildTalabatAiNavigationActionUseCaseImpl(getFlutterConfigurationParamsUseCaseImpl());
        }

        private BuildVoucherDetailsNavigationUseCaseImpl buildVoucherDetailsNavigationUseCaseImpl() {
            return new BuildVoucherDetailsNavigationUseCaseImpl(getFlutterConfigurationParamsUseCaseImpl(), isVoucherBottomSheetNavigationEnabledUseCaseImpl());
        }

        private BuildVoucherProductListingNavigationUseCaseImpl buildVoucherProductListingNavigationUseCaseImpl() {
            return new BuildVoucherProductListingNavigationUseCaseImpl(getFlutterConfigurationParamsUseCaseImpl());
        }

        private CampaignProgressStateMapper campaignProgressStateMapper() {
            return new CampaignProgressStateMapper(this.bindCampaignProgressSourceMapperProvider.get());
        }

        private CampaignProgressUseCase campaignProgressUseCase() {
            return new CampaignProgressUseCase(this.darkstoresRepoProvider.get(), this.groceryShoppingRepositoryProvider.get(), this.deliveryDetailsRepoProvider.get(), DarkstoresSchedulersModule_ProvideIoSchedulerFactory.provideIoScheduler(), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), (GetCampaignMessageUseCase) Preconditions.checkNotNullFromComponent(this.campaignMessagingApi.getVendorUseCase()), this.configurationParameters, DarkstoresCampaignMessageModule_ProvideCampaignProgressResponseMapperFactory.provideCampaignProgressResponseMapper(this.darkstoresCampaignMessageModule), campaignProgressStateMapper(), this.bindGroceryDeliveryFeeTierFeatureFlagUseCaseProvider.get());
        }

        private CartController cartController() {
            return new CartController((DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository()), (DarkstoresCartListRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.cartListRepository()), sharedPreferences(), this.provideDarkstoresEventTrackerProvider.get(), this.provideCategoryTrackerProvider.get(), new TimeProvider());
        }

        private CartSwimlaneUseCase cartSwimlaneUseCase() {
            return new CartSwimlaneUseCase(this.discoveryRepoProvider.get());
        }

        private CheckFlutterCategoryProductsEnabledUseCaseImpl checkFlutterCategoryProductsEnabledUseCaseImpl() {
            return new CheckFlutterCategoryProductsEnabledUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment());
        }

        private CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl checkFlutterSwimlanesSearchResultEnabledUseCaseImpl() {
            return new CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment());
        }

        private DarkstoresListener darkstoresListener() {
            return DarkstoresApplicationModule_ProvideDarkstoresListenerFactory.provideDarkstoresListener(this.gson);
        }

        private GenerateVoucherUseCaseImpl generateVoucherUseCaseImpl() {
            return new GenerateVoucherUseCaseImpl(this.darkstoresRepoProvider.get(), this.configurationParameters);
        }

        private GetFlutterConfigurationParamsUseCaseImpl getFlutterConfigurationParamsUseCaseImpl() {
            return new GetFlutterConfigurationParamsUseCaseImpl(this.configurationParameters);
        }

        private GetPreSearchSwimlaneUseCaseImpl getPreSearchSwimlaneUseCaseImpl() {
            return new GetPreSearchSwimlaneUseCaseImpl(this.discoveryRepoProvider.get());
        }

        private GetVendorLightningOptimizationExpVariantUseCaseImpl getVendorLightningOptimizationExpVariantUseCaseImpl() {
            return new GetVendorLightningOptimizationExpVariantUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment());
        }

        private ProductImpressionTracker heroBannerImpressionTrackerProductImpressionTracker() {
            return DarkstoresApplicationModule_ProvideHeroBannerProductImpressionTrackerFactory.provideHeroBannerProductImpressionTracker(new BannerImpressionMapper(), talabatImpressionTracker(), storeInfoTrackingProvider(), locationTrackingProvider());
        }

        private HomeTracker homeTracker() {
            return new HomeTracker(this.baseTrackerProvider.get(), new ScreenTrackingProvider());
        }

        private InitCartUseCase initCartUseCase() {
            return new InitCartUseCase(this.darkstoresRepoProvider.get(), (DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository()), (IsMultiBasketEnabledUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.isMultiBasketEnabledUseCase()), this.applyDiscountsAndCampaignsUseCaseImplProvider.get(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
        }

        private void initialize(DarkstoresCampaignMessageModule darkstoresCampaignMessageModule2, DarkstoresDatabaseModule darkstoresDatabaseModule2, NonMigratedCartModule nonMigratedCartModule2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, CustomerCoreLibApi customerCoreLibApi2, DarkstoresCartApi darkstoresCartApi2, DarkstoresCartListApi darkstoresCartListApi2, DarkstoresFlutterCartApi darkstoresFlutterCartApi, DarkstoresVendorApi darkstoresVendorApi, DeepLinkCoreLibApi deepLinkCoreLibApi, CampaignMessagingApi campaignMessagingApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, SecretCoreLibApi secretCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, SwimlanesFeatureApi swimlanesFeatureApi, VendorLandingFeatureApi vendorLandingFeatureApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi, Context context, ConfigurationParameters configurationParameters2, Gson gson2, BaseUrlFactory baseUrlFactory2) {
            DispatcherCoreLibApi dispatcherCoreLibApi3 = dispatcherCoreLibApi2;
            ObservabilityCoreLibApi observabilityCoreLibApi3 = observabilityCoreLibApi2;
            this.applicationContextProvider = InstanceFactory.create(context);
            this.getTalabatTrackerProvider = new GetTalabatTrackerProvider(trackingCoreLibApi2);
            dagger.internal.Factory create = InstanceFactory.create(configurationParameters2);
            this.configurationParametersProvider = create;
            this.storeInfoTrackingProvider = StoreInfoTrackingProvider_Factory.create(create);
            LocationTrackingProvider_Factory create2 = LocationTrackingProvider_Factory.create(DarkstoresApplicationModule_ProvideDataModelFactory.create());
            this.locationTrackingProvider = create2;
            this.provideDarkstoresEventTrackerProvider = DoubleCheck.provider(DarkstoresApplicationModule_ProvideDarkstoresEventTrackerFactory.create(this.applicationContextProvider, this.getTalabatTrackerProvider, this.storeInfoTrackingProvider, create2));
            this.provideCategoryTrackerProvider = SingleCheck.provider(DarkstoresApplicationModule_ProvideCategoryTrackerFactory.create(this.getTalabatTrackerProvider, this.storeInfoTrackingProvider, this.configurationParametersProvider));
            Provider<Moshi> provider = DoubleCheck.provider(DarkstoresNetworkModule_ProvideMoshiFactory.create());
            this.provideMoshiProvider = provider;
            this.provideBaseRetrofitBuilderProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideBaseRetrofitBuilderFactory.create(provider));
            NetworkConnectionInterceptor_Factory create3 = NetworkConnectionInterceptor_Factory.create(this.applicationContextProvider);
            this.networkConnectionInterceptorProvider = create3;
            this.provideOkHttpProvider = DoubleCheck.provider(DarkstoresNetworkModule_ProvideOkHttpFactory.create(create3));
            this.getSecretProvider = new GetSecretProviderProvider(secretCoreLibApi);
            Provider<Base64Helper> provider2 = DoubleCheck.provider(DarkstoresApplicationModule_ProvidesBase64HelperFactory.create());
            this.providesBase64HelperProvider = provider2;
            this.provideAuthHeaderInterceptorProvider = DoubleCheck.provider(DarkstoresNetworkModule_ProvideAuthHeaderInterceptorFactory.create(this.getSecretProvider, provider2));
            GetAppVersionProviderProvider getAppVersionProviderProvider = new GetAppVersionProviderProvider(configurationRemoteCoreLibApi);
            this.getAppVersionProvider = getAppVersionProviderProvider;
            Provider<DarkstoresHeaderInterceptor> provider3 = DoubleCheck.provider(DarkstoresNetworkModule_ProvideDarkstoresHeaderInterceptorFactory.create(getAppVersionProviderProvider));
            this.provideDarkstoresHeaderInterceptorProvider = provider3;
            this.provideDarkstoresOkHttpProvider = DoubleCheck.provider(DarkstoresNetworkModule_ProvideDarkstoresOkHttpFactory.create(this.provideOkHttpProvider, this.provideAuthHeaderInterceptorProvider, provider3));
            Provider<String> provider4 = DoubleCheck.provider(DarkstoresNetworkModule_ProvideDarkstoresBaseUrlFactory.create());
            this.provideDarkstoresBaseUrlProvider = provider4;
            this.provideDjiniApiProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideDjiniApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideDarkstoresOkHttpProvider, provider4));
            dagger.internal.Factory create4 = InstanceFactory.create(baseUrlFactory2);
            this.baseUrlFactoryProvider = create4;
            DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory create5 = DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory.create(create4, GroceryBaseUrl_Factory.create());
            this.provideQCommerceGroceryUrlProvider = create5;
            this.provideProductApiProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideProductApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, create5));
            this.provideBasketApiProvider = DarkstoresApiModule_ProvideBasketApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideDarkstoresOkHttpProvider, DarkstoresNetworkModule_ProvideBasketBaseUrlFactory.create(), PlatformHeaderInterceptor_Factory.create());
            this.provideLookingGlassVoucherApiProvider = DarkstoresApiModule_ProvideLookingGlassVoucherApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideDarkstoresOkHttpProvider, this.provideQCommerceGroceryUrlProvider);
            this.vendorRepositoryProvider = new VendorRepositoryProvider(darkstoresVendorApi);
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.cartRepositoryProvider = new CartRepositoryProvider(darkstoresCartApi2);
            this.getObservabilityManagerProvider = new GetObservabilityManagerProvider(observabilityCoreLibApi3);
            this.getVendorLightningOptimizationExpVariantUseCaseImplProvider = GetVendorLightningOptimizationExpVariantUseCaseImpl_Factory.create(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.create());
            this.provideDarkStoreObservabilityTrackerProvider = DoubleCheck.provider(DarkstoresApplicationModule_ProvideDarkStoreObservabilityTrackerFactory.create(this.getObservabilityManagerProvider, DarkstoresApplicationModule_ProvideDataModelFactory.create(), this.configurationParametersProvider, this.getAppVersionProvider, this.getVendorLightningOptimizationExpVariantUseCaseImplProvider));
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi2);
            GetVouchersSwimLaneRepositoryProvider getVouchersSwimLaneRepositoryProvider2 = new GetVouchersSwimLaneRepositoryProvider(customerVouchersSwimLaneFeaturesApi);
            this.getVouchersSwimLaneRepositoryProvider = getVouchersSwimLaneRepositoryProvider2;
            this.loadCustomerVouchersSwimLaneUseCaseProvider = LoadCustomerVouchersSwimLaneUseCase_Factory.create(getVouchersSwimLaneRepositoryProvider2);
            this.darkstoresRepoProvider = DoubleCheck.provider(DarkstoresRepo_Factory.create(this.configurationParametersProvider, this.provideDjiniApiProvider, this.provideProductApiProvider, this.provideBasketApiProvider, this.provideLookingGlassVoucherApiProvider, this.provideDarkstoresEventTrackerProvider, this.vendorRepositoryProvider, this.getRepositoryProvider, this.cartRepositoryProvider, CartResponseMapper_Factory.create(), this.provideDarkStoreObservabilityTrackerProvider, this.getTalabatFeatureFlagProvider, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create(), this.loadCustomerVouchersSwimLaneUseCaseProvider, DarkstoresUserDataModule_ProvideSelectedAreaIdFactory.create()));
            this.baseTrackerProvider = DoubleCheck.provider(BaseTracker_Factory.create(this.applicationContextProvider, DarkstoresApplicationModule_ProvideTalabatFirebaseFactory.create(), this.storeInfoTrackingProvider, this.locationTrackingProvider, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create()));
            VendorLandingToFeedsMapper_Factory create6 = VendorLandingToFeedsMapper_Factory.create(BannerDomainToViewModelMapper_Factory.create());
            this.vendorLandingToFeedsMapperProvider = create6;
            this.bindVendorLandingToFeedsMapperProvider = SingleCheck.provider(create6);
            this.applyDiscountsAndCampaignsUseCaseImplProvider = SingleCheck.provider(ApplyDiscountsAndCampaignsUseCaseImpl_Factory.create(this.darkstoresRepoProvider, this.getTalabatFeatureFlagProvider));
            Provider<String> provider5 = DoubleCheck.provider(DarkstoresNetworkModule_ProvideDiscoveryBaseUrlFactory.create());
            this.provideDiscoveryBaseUrlProvider = provider5;
            this.provideDiscoveryApiProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideDiscoveryApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, provider5));
            this.provideFeedApiProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideFeedApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, this.provideQCommerceGroceryUrlProvider));
            this.productTrackingProvider = ProductTrackingProvider_Factory.create(this.configurationParametersProvider);
            this.searchTrackerProvider = SearchTracker_Factory.create(this.baseTrackerProvider, ScreenTrackingProvider_Factory.create(), this.productTrackingProvider);
            Provider<ModelMapper<NetworkSortOption, SortOption>> provider6 = SingleCheck.provider(SortOptionMapper_Factory.create());
            this.bindSortOptionMapperProvider = provider6;
            SubcategorySwimlanesResultMapper_Factory create7 = SubcategorySwimlanesResultMapper_Factory.create(provider6);
            this.subcategorySwimlanesResultMapperProvider = create7;
            this.bindSubcategoruSwimlanesResultMapperProvider = SingleCheck.provider(create7);
            this.discoveryRepoProvider = DoubleCheck.provider(DiscoveryRepo_Factory.create(this.configurationParametersProvider, this.darkstoresRepoProvider, this.provideDiscoveryApiProvider, this.provideBasketApiProvider, this.provideFeedApiProvider, this.provideProductApiProvider, this.getTalabatFeatureFlagProvider, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create(), this.searchTrackerProvider, this.bindSubcategoruSwimlanesResultMapperProvider));
            this.getRemoteConfigurationDataSourceProvider = new GetRemoteConfigurationDataSourceProvider(remoteConfigCoreLibApi2);
            this.provideSearchApiProvider = DarkstoresApiModule_ProvideSearchApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, this.provideDiscoveryBaseUrlProvider);
            this.provideQCGroceryCategorySearchApiProvider = DarkstoresApiModule_ProvideQCGroceryCategorySearchApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, this.provideQCommerceGroceryUrlProvider);
            DarkstoresApiModule_ProvideQCommerceSearchApiFactory create8 = DarkstoresApiModule_ProvideQCommerceSearchApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, DarkstoresNetworkModule_ProvideQCommerceSearchBaseUrlFactory.create());
            this.provideQCommerceSearchApiProvider = create8;
            SearchRepository_Factory create9 = SearchRepository_Factory.create(this.configurationParametersProvider, this.getRemoteConfigurationDataSourceProvider, this.darkstoresRepoProvider, this.provideSearchApiProvider, this.provideQCGroceryCategorySearchApiProvider, create8, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create());
            this.searchRepositoryProvider = create9;
            this.searchResultsUseCaseProvider = SingleCheck.provider(SearchResultsUseCase_Factory.create(this.darkstoresRepoProvider, this.discoveryRepoProvider, this.getTalabatFeatureFlagProvider, create9, this.searchTrackerProvider));
            DarkstoresApiModule_ProvideMissionControlProductApiFactory create10 = DarkstoresApiModule_ProvideMissionControlProductApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideDarkstoresOkHttpProvider, this.provideQCommerceGroceryUrlProvider);
            this.provideMissionControlProductApiProvider = create10;
            MissionControlProductRepository_Factory create11 = MissionControlProductRepository_Factory.create(this.configurationParametersProvider, this.getRemoteConfigurationDataSourceProvider, this.darkstoresRepoProvider, create10, MissionControlProductsResponseToDomainMapperImpl_Factory.create(), DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create());
            this.missionControlProductRepositoryProvider = create11;
            this.getLifestyleMissionControlProductsUseCaseProvider = SingleCheck.provider(GetLifestyleMissionControlProductsUseCase_Factory.create(this.darkstoresRepoProvider, this.discoveryRepoProvider, this.getTalabatFeatureFlagProvider, create11, this.searchTrackerProvider));
            this.getPrimaryMissionControlProductsUseCaseProvider = GetPrimaryMissionControlProductsUseCase_Factory.create(this.missionControlProductRepositoryProvider, this.applyDiscountsAndCampaignsUseCaseImplProvider);
            this.provideSwimlanseProductApiProvider = DarkstoresApiModule_ProvideSwimlanseProductApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideDarkstoresOkHttpProvider, DarkstoresNetworkModule_ProvideGroceryBaseUrlFactory.create());
            this.getRxSchedulersFactoryProvider = new GetRxSchedulersFactoryProvider(dispatcherCoreLibApi3);
            SwimlanesProductRepository_Factory create12 = SwimlanesProductRepository_Factory.create(this.configurationParametersProvider, this.darkstoresRepoProvider, this.provideSwimlanseProductApiProvider, MissionControlProductsResponseToDomainMapperImpl_Factory.create(), this.getRxSchedulersFactoryProvider);
            this.swimlanesProductRepositoryProvider = create12;
            GetSwimlaneProductUseCase_Factory create13 = GetSwimlaneProductUseCase_Factory.create(create12, this.applyDiscountsAndCampaignsUseCaseImplProvider);
            this.getSwimlaneProductUseCaseProvider = create13;
            this.pagingSourceFactoryImplProvider = PagingSourceFactoryImpl_Factory.create(this.discoveryRepoProvider, this.searchResultsUseCaseProvider, this.getLifestyleMissionControlProductsUseCaseProvider, this.getPrimaryMissionControlProductsUseCaseProvider, create13, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create());
            this.provideImpressionTrackerProvider = DarkstoresApplicationModule_ProvideImpressionTrackerFactory.create(this.getTalabatTrackerProvider);
            this.provideProductImpressionTrackerProvider = DarkstoresApplicationModule_ProvideProductImpressionTrackerFactory.create(BannerImpressionMapper_Factory.create(), this.provideImpressionTrackerProvider, this.storeInfoTrackingProvider, this.locationTrackingProvider);
            this.getScreenTrackerProvider = new GetScreenTrackerProvider(observabilityCoreLibApi3);
            GetFlutterConfigurationParamsUseCaseImpl_Factory create14 = GetFlutterConfigurationParamsUseCaseImpl_Factory.create(this.configurationParametersProvider);
            this.getFlutterConfigurationParamsUseCaseImplProvider = create14;
            this.buildSearchNavigationActionUseCaseImplProvider = BuildSearchNavigationActionUseCaseImpl_Factory.create(create14);
            C0478SearchResultsFragmentViewModel_Factory create15 = C0478SearchResultsFragmentViewModel_Factory.create(this.discoveryRepoProvider, this.pagingSourceFactoryImplProvider, this.searchTrackerProvider, this.provideProductImpressionTrackerProvider, this.getScreenTrackerProvider, DarkstoresApplicationModule_ProvideCompositeDisposableFactory.create(), this.buildSearchNavigationActionUseCaseImplProvider, this.getTalabatFeatureFlagProvider, DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.create());
            this.searchResultsFragmentViewModelProvider = create15;
            this.factoryProvider = SearchResultsFragmentViewModel_Factory_Impl.create(create15);
            this.swimlanesTrackerProvider = SwimlanesTracker_Factory.create(this.getTalabatTrackerProvider, this.storeInfoTrackingProvider);
            this.basketLifeTimeTooltipUseCaseProvider = BasketLifeTimeTooltipUseCase_Factory.create(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.create());
            GetRepositoryProvider2 getRepositoryProvider22 = new GetRepositoryProvider2(swimlanesFeatureApi);
            this.getRepositoryProvider2 = getRepositoryProvider22;
            this.productSwimlanesUseCaseProvider = SingleCheck.provider(ProductSwimlanesUseCase_Factory.create(this.darkstoresRepoProvider, this.discoveryRepoProvider, getRepositoryProvider22, this.configurationParametersProvider, this.getTalabatFeatureFlagProvider));
            IsFlutterCartEnabledUseCaseImpl_Factory create16 = IsFlutterCartEnabledUseCaseImpl_Factory.create(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.create());
            this.isFlutterCartEnabledUseCaseImplProvider = create16;
            this.buildCartNavigationActionUseCaseImplProvider = BuildCartNavigationActionUseCaseImpl_Factory.create(create16, this.getFlutterConfigurationParamsUseCaseImplProvider);
            C0477ProductFragmentViewModel_Factory create17 = C0477ProductFragmentViewModel_Factory.create(this.discoveryRepoProvider, this.darkstoresRepoProvider, DarkstoresApplicationModule_ProvideCompositeDisposableFactory.create(), this.provideDarkstoresEventTrackerProvider, this.provideCategoryTrackerProvider, this.swimlanesTrackerProvider, this.getTalabatFeatureFlagProvider, this.basketLifeTimeTooltipUseCaseProvider, this.productSwimlanesUseCaseProvider, this.getRxSchedulersFactoryProvider, DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.create(), this.getRepositoryProvider, this.buildCartNavigationActionUseCaseImplProvider);
            this.productFragmentViewModelProvider = create17;
            this.factoryProvider2 = ProductFragmentViewModel_Factory_Impl.create(create17);
            DarkstoresFeesTracker_Factory create18 = DarkstoresFeesTracker_Factory.create(this.getTalabatTrackerProvider);
            this.darkstoresFeesTrackerProvider = create18;
            this.providesFeesTrackerProvider = SingleCheck.provider(create18);
            this.deliveryDetailsRepoProvider = DoubleCheck.provider(DeliveryDetailsRepo_Factory.create(this.darkstoresRepoProvider, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create()));
            Provider<String> provider7 = DoubleCheck.provider(DarkstoresNetworkModule_ProvidePartialFulfillmentBaseUrlFactory.create());
            this.providePartialFulfillmentBaseUrlProvider = provider7;
            Provider<PartialFulfillmentApi> provider8 = DoubleCheck.provider(DarkstoresApiModule_ProvidePartialFulfillmentApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideOkHttpProvider, provider7));
            this.providePartialFulfillmentApiProvider = provider8;
            this.partialFulfillmentRepoProvider = DoubleCheck.provider(PartialFulfillmentRepo_Factory.create(provider8, this.configurationParametersProvider));
            Provider<GroceryShoppingApi> provider9 = DoubleCheck.provider(DarkstoresApiModule_ProvideGroceryShoppingApiFactory.create(this.provideBaseRetrofitBuilderProvider, this.provideDarkstoresOkHttpProvider, this.provideDarkstoresBaseUrlProvider));
            this.provideGroceryShoppingApiProvider = provider9;
            this.groceryShoppingRepositoryProvider = DoubleCheck.provider(GroceryShoppingRepository_Factory.create(provider9, this.configurationParametersProvider));
            this.bindCampaignProgressSourceMapperProvider = SingleCheck.provider(CampaignProgressSourceMapper_Factory.create());
            GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory create19 = GroceryDeliveryFeeTierFeatureFlagUseCaseImpl_Factory.create(this.getTalabatFeatureFlagProvider);
            this.groceryDeliveryFeeTierFeatureFlagUseCaseImplProvider = create19;
            this.bindGroceryDeliveryFeeTierFeatureFlagUseCaseProvider = SingleCheck.provider(create19);
            this.provideSharedPreferencesProvider = DarkstoresDatabaseModule_ProvideSharedPreferencesFactory.create(darkstoresDatabaseModule2, this.applicationContextProvider);
            this.provideTalabatApiBuilderProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideTalabatApiBuilderFactory.create());
            Provider<String> provider10 = DoubleCheck.provider(DarkstoresNetworkModule_ProvideVendorBaseUrlFactory.create());
            this.provideVendorBaseUrlProvider = provider10;
            this.provideVendorsApiProvider = DoubleCheck.provider(DarkstoresApiModule_ProvideVendorsApiFactory.create(this.provideTalabatApiBuilderProvider, provider10));
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi3);
            this.gsonProvider = InstanceFactory.create(gson2);
            DarkstoresRepositoryImpl_Factory create20 = DarkstoresRepositoryImpl_Factory.create(this.cartRepositoryProvider, this.provideSharedPreferencesProvider, this.provideVendorsApiProvider, DarkstoresUserDataModule_ProvideSelectedAreaIdFactory.create(), DarkstoresUserDataModule_ProvideSelectedLatitudeFactory.create(), DarkstoresUserDataModule_ProvideSelectedLongitudeFactory.create(), DarkstoresUserDataModule_ProvideSelectedCountryIdFactory.create(), DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create(), this.getCoroutineDispatchersFactoryProvider, this.gsonProvider);
            this.darkstoresRepositoryImplProvider = create20;
            this.provideDarkstoresRepositoryProvider = SingleCheck.provider(create20);
            DisclaimerRepositoryImpl_Factory create21 = DisclaimerRepositoryImpl_Factory.create(this.provideSharedPreferencesProvider);
            this.disclaimerRepositoryImplProvider = create21;
            this.provideDisclaimerRepositoryProvider = SingleCheck.provider(create21);
            DarkStoreBottomSheetTrackerImpl_Factory create22 = DarkStoreBottomSheetTrackerImpl_Factory.create(this.getTalabatTrackerProvider, this.storeInfoTrackingProvider);
            this.darkStoreBottomSheetTrackerImplProvider = create22;
            this.provideBottomSheetEventTrackerProvider = SingleCheck.provider(create22);
        }

        private void initialize2(DarkstoresCampaignMessageModule darkstoresCampaignMessageModule2, DarkstoresDatabaseModule darkstoresDatabaseModule2, NonMigratedCartModule nonMigratedCartModule2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, CustomerCoreLibApi customerCoreLibApi2, DarkstoresCartApi darkstoresCartApi2, DarkstoresCartListApi darkstoresCartListApi2, DarkstoresFlutterCartApi darkstoresFlutterCartApi, DarkstoresVendorApi darkstoresVendorApi, DeepLinkCoreLibApi deepLinkCoreLibApi, CampaignMessagingApi campaignMessagingApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, SecretCoreLibApi secretCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, SwimlanesFeatureApi swimlanesFeatureApi, VendorLandingFeatureApi vendorLandingFeatureApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi, Context context, ConfigurationParameters configurationParameters2, Gson gson2, BaseUrlFactory baseUrlFactory2) {
            C0475SubcategoriesFragmentViewModel_Factory create = C0475SubcategoriesFragmentViewModel_Factory.create(this.discoveryRepoProvider, this.darkstoresRepoProvider, this.cartRepositoryProvider, this.provideDarkstoresEventTrackerProvider, this.provideCategoryTrackerProvider, this.provideProductImpressionTrackerProvider, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.create());
            this.subcategoriesFragmentViewModelProvider = create;
            this.factoryProvider3 = SubcategoriesFragmentViewModel_Factory_Impl.create(create);
            this.getSortOnPLPEnabledUseCaseImplProvider = GetSortOnPLPEnabledUseCaseImpl_Factory.create(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.create());
            SortAndFilterOptionTrackerImpl_Factory create2 = SortAndFilterOptionTrackerImpl_Factory.create(this.getTalabatTrackerProvider, this.storeInfoTrackingProvider, this.locationTrackingProvider);
            this.sortAndFilterOptionTrackerImplProvider = create2;
            Provider<SortAndFilterOptionTracker> provider = SingleCheck.provider(create2);
            this.bindSortAndFilterOptionTrackerProvider = provider;
            C0476SubcategoriesFragmentViewModelNew_Factory create3 = C0476SubcategoriesFragmentViewModelNew_Factory.create(this.discoveryRepoProvider, this.provideDarkstoresEventTrackerProvider, this.provideCategoryTrackerProvider, this.getScreenTrackerProvider, this.provideProductImpressionTrackerProvider, this.buildSearchNavigationActionUseCaseImplProvider, this.basketLifeTimeTooltipUseCaseProvider, this.getRxSchedulersFactoryProvider, this.buildCartNavigationActionUseCaseImplProvider, this.getSortOnPLPEnabledUseCaseImplProvider, provider);
            this.subcategoriesFragmentViewModelNewProvider = create3;
            this.factoryProvider4 = SubcategoriesFragmentViewModelNew_Factory_Impl.create(create3);
        }

        private IsBasketUpsellBottomSheetShownUseCase isBasketUpsellBottomSheetShownUseCase() {
            return DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellBottomSheetShownUseCaseFactory.providesIsBasketUpsellBottomSheetShownUseCase(isBasketUpsellBottomSheetShownUseCaseImpl());
        }

        private IsBasketUpsellBottomSheetShownUseCaseImpl isBasketUpsellBottomSheetShownUseCaseImpl() {
            return new IsBasketUpsellBottomSheetShownUseCaseImpl(basketUpsellRepository());
        }

        private IsBasketUpsellExperimentEnabledUseCase isBasketUpsellExperimentEnabledUseCase() {
            return DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellExperimentEnabledUseCaseImplFactory.providesIsBasketUpsellExperimentEnabledUseCaseImpl(isBasketUpsellExperimentEnabledUseCaseImpl());
        }

        private IsBasketUpsellExperimentEnabledUseCaseImpl isBasketUpsellExperimentEnabledUseCaseImpl() {
            return new IsBasketUpsellExperimentEnabledUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment(), this.configurationParameters);
        }

        private IsFlutterBannerProductListingEnabledUseCaseImpl isFlutterBannerProductListingEnabledUseCaseImpl() {
            return new IsFlutterBannerProductListingEnabledUseCaseImpl((ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        private IsFlutterCartEnabledUseCaseImpl isFlutterCartEnabledUseCaseImpl() {
            return new IsFlutterCartEnabledUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment());
        }

        private IsVendorLightningOptimizationEnabledUseCaseImpl isVendorLightningOptimizationEnabledUseCaseImpl() {
            return new IsVendorLightningOptimizationEnabledUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment());
        }

        private IsVoucherBottomSheetNavigationEnabledUseCaseImpl isVoucherBottomSheetNavigationEnabledUseCaseImpl() {
            return new IsVoucherBottomSheetNavigationEnabledUseCaseImpl((ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        private LocationTrackingProvider locationTrackingProvider() {
            return new LocationTrackingProvider(DarkstoresApplicationModule_ProvideDataModelFactory.provideDataModel());
        }

        private PostCartUseCase postCartUseCase() {
            return new PostCartUseCase(this.darkstoresRepoProvider.get(), (IsMultiBasketEnabledUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.isMultiBasketEnabledUseCase()), (DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository()));
        }

        private ProductTrackingProvider productTrackingProvider() {
            return new ProductTrackingProvider(this.configurationParameters);
        }

        private QCommerceGroceryApi qCommerceGroceryApi() {
            return DarkstoresApiModule_ProvideQCGroceryCategorySearchApiFactory.provideQCGroceryCategorySearchApi(this.provideBaseRetrofitBuilderProvider.get(), this.provideOkHttpProvider.get(), qCommerceGroceryString());
        }

        private String qCommerceGroceryString() {
            return DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory.provideQCommerceGroceryUrl(this.baseUrlFactory, new GroceryBaseUrl());
        }

        private QCommerceSearchApi qCommerceSearchApi() {
            return DarkstoresApiModule_ProvideQCommerceSearchApiFactory.provideQCommerceSearchApi(this.provideBaseRetrofitBuilderProvider.get(), this.provideOkHttpProvider.get(), DarkstoresNetworkModule_ProvideQCommerceSearchBaseUrlFactory.provideQCommerceSearchBaseUrl());
        }

        private SaveBasketUpsellBottomSheetShownUseCase saveBasketUpsellBottomSheetShownUseCase() {
            return DarkstoreBasketUpsellModule_ProvidesSaveBasketUpsellBottomSheetShownUseCaseFactory.providesSaveBasketUpsellBottomSheetShownUseCase(saveBasketUpsellBottomSheetShownUseCaseImpl());
        }

        private SaveBasketUpsellBottomSheetShownUseCaseImpl saveBasketUpsellBottomSheetShownUseCaseImpl() {
            return new SaveBasketUpsellBottomSheetShownUseCaseImpl(basketUpsellRepository());
        }

        private SearchApi searchApi() {
            return DarkstoresApiModule_ProvideSearchApiFactory.provideSearchApi(this.provideBaseRetrofitBuilderProvider.get(), this.provideOkHttpProvider.get(), this.provideDiscoveryBaseUrlProvider.get());
        }

        private SearchCategoryUseCase searchCategoryUseCase() {
            return new SearchCategoryUseCase(searchRepository(), searchTracker());
        }

        private SearchRepository searchRepository() {
            return new SearchRepository(this.configurationParameters, (IRemoteConfigurationDataSource) Preconditions.checkNotNullFromComponent(this.remoteConfigCoreLibApi.getRemoteConfigurationDataSource()), this.darkstoresRepoProvider.get(), searchApi(), qCommerceGroceryApi(), qCommerceSearchApi(), DarkstoresSchedulersModule_ProvideIoSchedulerFactory.provideIoScheduler());
        }

        private SearchTracker searchTracker() {
            return new SearchTracker(this.baseTrackerProvider.get(), new ScreenTrackingProvider(), productTrackingProvider());
        }

        private SharedPreferences sharedPreferences() {
            return DarkstoresDatabaseModule_ProvideSharedPreferencesFactory.provideSharedPreferences(this.darkstoresDatabaseModule, this.applicationContext);
        }

        private ShouldShowTalabatAiEntryPointUseCaseImpl shouldShowTalabatAiEntryPointUseCaseImpl() {
            return new ShouldShowTalabatAiEntryPointUseCaseImpl(DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment());
        }

        private ProductImpressionTracker smallBannerImpressionTrackerProductImpressionTracker() {
            return DarkstoresApplicationModule_ProvideSmallBannerProductImpressionTrackerFactory.provideSmallBannerProductImpressionTracker(new BannerImpressionMapper(), talabatImpressionTracker(), storeInfoTrackingProvider(), locationTrackingProvider());
        }

        private StartCartClearedEventTrackerUseCase startCartClearedEventTrackerUseCase() {
            return new StartCartClearedEventTrackerUseCase((DarkstoresCartRepository) Preconditions.checkNotNullFromComponent(this.darkstoresCartApi.cartRepository()), this.provideCategoryTrackerProvider.get());
        }

        private StoreInfoTrackingProvider storeInfoTrackingProvider() {
            return new StoreInfoTrackingProvider(this.configurationParameters);
        }

        private SwimlanesTracker swimlanesTracker() {
            return new SwimlanesTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()), storeInfoTrackingProvider());
        }

        private TalabatImpressionTracker talabatImpressionTracker() {
            return DarkstoresApplicationModule_ProvideImpressionTrackerFactory.provideImpressionTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
        }

        private VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl() {
            return new VendorLandingFeedUseCaseImpl(this.configurationParameters, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.provideIoScheduler(), (VendorLandingRepository) Preconditions.checkNotNullFromComponent(this.vendorLandingFeatureApi.getRepository()), this.bindVendorLandingToFeedsMapperProvider.get(), this.darkstoresRepoProvider.get(), this.applyDiscountsAndCampaignsUseCaseImplProvider.get(), isVendorLightningOptimizationEnabledUseCaseImpl());
        }

        public CartFragmentViewModel getCartFragmentViewModel() {
            PostCartUseCase postCartUseCase = postCartUseCase();
            FlutterDeliveryTierMapper flutterDeliveryTierMapper = r1;
            FlutterDeliveryTierMapper flutterDeliveryTierMapper2 = new FlutterDeliveryTierMapper();
            return new CartFragmentViewModel(cartController(), this.darkstoresRepoProvider.get(), (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()), darkstoresListener(), DarkstoresApplicationModule_ProvideCompositeDisposableFactory.provideCompositeDisposable(), this.provideDarkstoresEventTrackerProvider.get(), this.providesFeesTrackerProvider.get(), this.deliveryDetailsRepoProvider.get(), this.partialFulfillmentRepoProvider.get(), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment(), DarkstoresApplicationModule_ProvidesCustomerFactory.providesCustomer(), this.configurationParameters, cartSwimlaneUseCase(), campaignProgressUseCase(), this.provideDarkstoresRepositoryProvider.get(), this.provideDisclaimerRepositoryProvider.get(), postCartUseCase, flutterDeliveryTierMapper, this.provideBottomSheetEventTrackerProvider.get(), this.bindGroceryDeliveryFeeTierFeatureFlagUseCaseProvider.get(), storeInfoTrackingProvider(), NonMigratedCartModule_ProvideNonMigratedCartFactory.provideNonMigratedCart(this.nonMigratedCartModule), (GetCartListToastUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.getCartListToastUseCase()), (InvalidateCartListCacheUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresCartListApi.invalidateCartListCacheUseCase()), initCartUseCase(), startCartClearedEventTrackerUseCase(), buildBasketUpsellActionUseCase(), saveBasketUpsellBottomSheetShownUseCase(), swimlanesTracker(), buildDeliveryFeeTierNavigationUseCaseImpl());
        }

        public CartProgressContract.Presenter getCartProgressPresenter() {
            return new CartProgressViewPresenter();
        }

        public CategoriesFragmentViewModel getCategoriesFragmentViewModel() {
            return new CategoriesFragmentViewModel(this.discoveryRepoProvider.get(), DarkstoresApplicationModule_ProvideCompositeDisposableFactory.provideCompositeDisposable(), this.provideDarkstoresEventTrackerProvider.get(), buildSearchNavigationActionUseCaseImpl());
        }

        public CategoriesOverviewFragmentViewModel getCategoriesOverviewFragmentViewModel() {
            return new CategoriesOverviewFragmentViewModel(DarkstoresApplicationModule_ProvideCompositeDisposableFactory.provideCompositeDisposable(), searchCategoryUseCase(), this.provideDarkstoresEventTrackerProvider.get(), DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment(), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), searchTracker(), buildCategoryProductsNavigationActionUseCaseImpl());
        }

        public ConfigurationParameters getConfigurationParameters() {
            return this.configurationParameters;
        }

        public DeliveryTierBottomSheetViewStateViewModel getDeliveryTierBottomSheetViewStateViewModel() {
            return new DeliveryTierBottomSheetViewStateViewModel();
        }

        public HomeFragmentViewModel getHomeFragmentViewModel() {
            IsVLPLoadTimeTrackingEnabledUseCaseImpl isVLPLoadTimeTrackingEnabledUseCaseImpl = r1;
            IsVLPLoadTimeTrackingEnabledUseCaseImpl isVLPLoadTimeTrackingEnabledUseCaseImpl2 = new IsVLPLoadTimeTrackingEnabledUseCaseImpl();
            return new HomeFragmentViewModel(cartController(), this.darkstoresRepoProvider.get(), (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()), (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()), DarkstoresApplicationModule_ProvideCompositeDisposableFactory.provideCompositeDisposable(), this.provideDarkstoresEventTrackerProvider.get(), homeTracker(), DarkstoresApplicationModule_ProvidesTalabatExperimentFactory.providesTalabatExperiment(), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()), this.configurationParameters, DarkstoresSchedulersModule_ProvideIoSchedulerFactory.provideIoScheduler(), buildSearchNavigationActionUseCaseImpl(), buildTalabatAiNavigationActionUseCaseImpl(), darkstoresListener(), shouldShowTalabatAiEntryPointUseCaseImpl(), vendorLandingFeedUseCaseImpl(), buildCategoryProductsNavigationActionUseCaseImpl(), getTracker(), smallBannerImpressionTrackerProductImpressionTracker(), heroBannerImpressionTrackerProductImpressionTracker(), buildSwimlanesSearchResultNavigationActionUseCaseImpl(), buildLifestyleSearchResultNavigationActionUseCaseImpl(), this.provideDarkStoreObservabilityTrackerProvider.get(), isVLPLoadTimeTrackingEnabledUseCaseImpl, getVendorLightningOptimizationExpVariantUseCaseImpl(), isVendorLightningOptimizationEnabledUseCaseImpl(), swimlanesTracker(), buildVoucherDetailsNavigationUseCaseImpl(), buildVoucherProductListingNavigationUseCaseImpl(), buildBannerCampaignProductListingNavigationUseCaseImpl());
        }

        public MainViewModel getMainViewModel() {
            return new MainViewModel(DarkstoresApplicationModule_ProvideCompositeDisposableFactory.provideCompositeDisposable(), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), this.discoveryRepoProvider.get(), buildCategoryProductsNavigationActionUseCaseImpl(), buildCartNavigationActionUseCaseImpl(), buildSwimlanesSearchResultNavigationActionUseCaseImpl(), buildLifestyleSearchResultNavigationActionUseCaseImpl(), getFlutterConfigurationParamsUseCaseImpl(), new IsFlutterVLPEnabledUseCaseImpl(), generateVoucherUseCaseImpl(), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()), (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()), buildBannerCampaignProductListingNavigationUseCaseImpl());
        }

        public ProductFragmentViewModel.Factory getProductFragmentViewModelFactory() {
            return this.factoryProvider2.get();
        }

        public SearchFragmentViewModel getSearchFragmentViewModel() {
            return new SearchFragmentViewModel(this.discoveryRepoProvider.get(), this.darkstoresRepoProvider.get(), searchTracker(), DarkstoresApplicationModule_ProvideCompositeDisposableFactory.provideCompositeDisposable(), DarkstoresSchedulersModule_ProvideIoSchedulerFactory.provideIoScheduler(), new RecentSearchesToListItemsMapperImpl(), new PreSearchSwimlaneToListItemsMapperImpl(), getPreSearchSwimlaneUseCaseImpl());
        }

        public SearchResultsFragmentViewModel.Factory getSearchResultsFragmentViewModelFactory() {
            return this.factoryProvider.get();
        }

        public SortOptionBottomSheetViewModel getSortOptionBottomSheetViewModel() {
            return new SortOptionBottomSheetViewModel(this.bindSortAndFilterOptionTrackerProvider.get());
        }

        public SubcategoriesFragmentViewModel.Factory getSubcategoriesFragmentViewModelFactory() {
            return this.factoryProvider3.get();
        }

        public SubcategoriesFragmentViewModelNew.Factory getSubcategoriesFragmentViewModelNewFactory() {
            return this.factoryProvider4.get();
        }

        public ProductImpressionTracker getTracker() {
            return DarkstoresApplicationModule_ProvideProductImpressionTrackerFactory.provideProductImpressionTracker(new BannerImpressionMapper(), talabatImpressionTracker(), storeInfoTrackingProvider(), locationTrackingProvider());
        }
    }

    public static final class Factory implements ApplicationComponent.Factory {
        private Factory() {
        }

        public ApplicationComponent create(Context context, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationParameters configurationParameters, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, CustomerCoreLibApi customerCoreLibApi, DarkstoresCartApi darkstoresCartApi, DarkstoresCartListApi darkstoresCartListApi, DarkstoresFlutterCartApi darkstoresFlutterCartApi, DarkstoresVendorApi darkstoresVendorApi, VendorLandingFeatureApi vendorLandingFeatureApi, CampaignMessagingApi campaignMessagingApi, DeepLinkCoreLibApi deepLinkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, Gson gson, SecretCoreLibApi secretCoreLibApi, SwimlanesFeatureApi swimlanesFeatureApi, TrackingCoreLibApi trackingCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, BaseUrlFactory baseUrlFactory, ObservabilityCoreLibApi observabilityCoreLibApi, CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi, NavigationCoreLibApi navigationCoreLibApi) {
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
            ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2 = configurationRemoteCoreLibApi;
            CustomerCoreLibApi customerCoreLibApi2 = customerCoreLibApi;
            DarkstoresCartApi darkstoresCartApi2 = darkstoresCartApi;
            DarkstoresCartListApi darkstoresCartListApi2 = darkstoresCartListApi;
            DarkstoresFlutterCartApi darkstoresFlutterCartApi2 = darkstoresFlutterCartApi;
            DarkstoresVendorApi darkstoresVendorApi2 = darkstoresVendorApi;
            VendorLandingFeatureApi vendorLandingFeatureApi2 = vendorLandingFeatureApi;
            CampaignMessagingApi campaignMessagingApi2 = campaignMessagingApi;
            DeepLinkCoreLibApi deepLinkCoreLibApi2 = deepLinkCoreLibApi;
            DispatcherCoreLibApi dispatcherCoreLibApi2 = dispatcherCoreLibApi;
            FeatureFlagCoreLibApi featureFlagCoreLibApi2 = featureFlagCoreLibApi;
            SecretCoreLibApi secretCoreLibApi2 = secretCoreLibApi;
            SwimlanesFeatureApi swimlanesFeatureApi2 = swimlanesFeatureApi;
            TrackingCoreLibApi trackingCoreLibApi2 = trackingCoreLibApi;
            SubscriptionsFeatureApi subscriptionsFeatureApi2 = subscriptionsFeatureApi;
            ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
            CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi2 = customerVouchersSwimLaneFeaturesApi;
            RemoteConfigCoreLibApi remoteConfigCoreLibApi2 = remoteConfigCoreLibApi;
            NavigationCoreLibApi navigationCoreLibApi2 = navigationCoreLibApi;
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationParameters);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(darkstoresCartApi);
            Preconditions.checkNotNull(darkstoresCartListApi);
            Preconditions.checkNotNull(darkstoresFlutterCartApi);
            Preconditions.checkNotNull(darkstoresVendorApi);
            Preconditions.checkNotNull(vendorLandingFeatureApi);
            Preconditions.checkNotNull(campaignMessagingApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(gson);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(swimlanesFeatureApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(baseUrlFactory);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(customerVouchersSwimLaneFeaturesApi);
            Preconditions.checkNotNull(remoteConfigCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            DarkstoresCampaignMessageModule darkstoresCampaignMessageModule = r2;
            DarkstoresCampaignMessageModule darkstoresCampaignMessageModule2 = new DarkstoresCampaignMessageModule();
            DarkstoresDatabaseModule darkstoresDatabaseModule = r3;
            DarkstoresDatabaseModule darkstoresDatabaseModule2 = new DarkstoresDatabaseModule();
            NonMigratedCartModule nonMigratedCartModule = r28;
            NonMigratedCartModule nonMigratedCartModule2 = new NonMigratedCartModule();
            return new ApplicationComponentImpl(darkstoresCampaignMessageModule, darkstoresDatabaseModule, nonMigratedCartModule, configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, customerCoreLibApi2, darkstoresCartApi2, darkstoresCartListApi2, darkstoresFlutterCartApi2, darkstoresVendorApi2, deepLinkCoreLibApi2, campaignMessagingApi2, dispatcherCoreLibApi2, featureFlagCoreLibApi2, secretCoreLibApi2, trackingCoreLibApi2, subscriptionsFeatureApi2, swimlanesFeatureApi2, vendorLandingFeatureApi2, observabilityCoreLibApi2, customerVouchersSwimLaneFeaturesApi2, remoteConfigCoreLibApi2, navigationCoreLibApi2, context, configurationParameters, gson, baseUrlFactory);
        }
    }

    private DaggerApplicationComponent() {
    }

    public static ApplicationComponent.Factory factory() {
        return new Factory();
    }
}
