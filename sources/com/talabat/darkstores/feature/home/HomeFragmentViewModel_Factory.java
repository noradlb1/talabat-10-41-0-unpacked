package com.talabat.darkstores.feature.home;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.tracking.HomeTracker;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCase;
import com.talabat.darkstores.feature.cart.CartController;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase;
import com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCase;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler", "com.talabat.darkstores.di.qualifier.SmallBannerImpressionTracker", "com.talabat.darkstores.di.qualifier.HeroBannerImpressionTracker"})
public final class HomeFragmentViewModel_Factory implements Factory<HomeFragmentViewModel> {
    private final Provider<BuildBannerCampaignProductListingNavigationUseCase> buildBannerCampaignProductListingNavigationUseCaseProvider;
    private final Provider<BuildCategoryProductsNavigationActionUseCase> buildCategoryProductsNavigationActionProvider;
    private final Provider<BuildLifestyleSearchResultNavigationActionUseCase> buildLifestyleSearchNavigationActionUseCaseProvider;
    private final Provider<BuildSearchNavigationActionUseCase> buildSearchNavigationActionProvider;
    private final Provider<BuildSwimlanesSearchResultNavigationActionUseCase> buildSwimlanesSearchResultNavigationActionUseCaseProvider;
    private final Provider<BuildTalabatAiNavigationActionUseCase> buildTalabatAiNavigationActionUseCaseProvider;
    private final Provider<BuildVoucherDetailsNavigationUseCase> buildVoucherDetailsNavigationUseCaseProvider;
    private final Provider<BuildVoucherProductListingNavigationUseCase> buildVoucherProductListingNavigationUseCaseProvider;
    private final Provider<CartController> cartControllerProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DarkStoreObservabilityTracker> darkStoreObservabilityTrackerProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<GetVendorLightningOptimizationExpVariantUseCase> getVendorLightningOptimizationExpVariantProvider;
    private final Provider<ProductImpressionTracker> heroBannerProductTrackerProvider;
    private final Provider<HomeTracker> homeTrackerProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<IsVLPLoadTimeTrackingEnabledUseCase> isVLPLoadTimeTrackingEnabledUseCaseProvider;
    private final Provider<IsVendorLightningOptimizationEnabledUseCase> isVendorLightningOptimizationEnabledUseCaseProvider;
    private final Provider<DarkstoresListener> listenerProvider;
    private final Provider<ProductImpressionTracker> productImpressionTrackerProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ShouldShowTalabatAiEntryPointUseCase> shouldShowTalabatAiEntryPointUseCaseProvider;
    private final Provider<ProductImpressionTracker> smallBannerProductTrackerProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFlagsRepoProvider;
    private final Provider<SwimlanesTracker> swimlanesTrackerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;
    private final Provider<VendorLandingFeedUseCase> vendorLandingFeedUseCaseProvider;

    public HomeFragmentViewModel_Factory(Provider<CartController> provider, Provider<DarkstoresRepo> provider2, Provider<IScreenTracker> provider3, Provider<CustomerRepository> provider4, Provider<CompositeDisposable> provider5, Provider<DarkstoresEventTracker> provider6, Provider<HomeTracker> provider7, Provider<ITalabatExperiment> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<ISubscriptionsFeatureFlagsRepository> provider10, Provider<ConfigurationParameters> provider11, Provider<Scheduler> provider12, Provider<BuildSearchNavigationActionUseCase> provider13, Provider<BuildTalabatAiNavigationActionUseCase> provider14, Provider<DarkstoresListener> provider15, Provider<ShouldShowTalabatAiEntryPointUseCase> provider16, Provider<VendorLandingFeedUseCase> provider17, Provider<BuildCategoryProductsNavigationActionUseCase> provider18, Provider<ProductImpressionTracker> provider19, Provider<ProductImpressionTracker> provider20, Provider<ProductImpressionTracker> provider21, Provider<BuildSwimlanesSearchResultNavigationActionUseCase> provider22, Provider<BuildLifestyleSearchResultNavigationActionUseCase> provider23, Provider<DarkStoreObservabilityTracker> provider24, Provider<IsVLPLoadTimeTrackingEnabledUseCase> provider25, Provider<GetVendorLightningOptimizationExpVariantUseCase> provider26, Provider<IsVendorLightningOptimizationEnabledUseCase> provider27, Provider<SwimlanesTracker> provider28, Provider<BuildVoucherDetailsNavigationUseCase> provider29, Provider<BuildVoucherProductListingNavigationUseCase> provider30, Provider<BuildBannerCampaignProductListingNavigationUseCase> provider31) {
        this.cartControllerProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.screenTrackerProvider = provider3;
        this.customerRepositoryProvider = provider4;
        this.compositeDisposableProvider = provider5;
        this.trackerProvider = provider6;
        this.homeTrackerProvider = provider7;
        this.talabatExperimentProvider = provider8;
        this.talabatFeatureFlagProvider = provider9;
        this.subscriptionsFlagsRepoProvider = provider10;
        this.configurationParametersProvider = provider11;
        this.ioSchedulerProvider = provider12;
        this.buildSearchNavigationActionProvider = provider13;
        this.buildTalabatAiNavigationActionUseCaseProvider = provider14;
        this.listenerProvider = provider15;
        this.shouldShowTalabatAiEntryPointUseCaseProvider = provider16;
        this.vendorLandingFeedUseCaseProvider = provider17;
        this.buildCategoryProductsNavigationActionProvider = provider18;
        this.productImpressionTrackerProvider = provider19;
        this.smallBannerProductTrackerProvider = provider20;
        this.heroBannerProductTrackerProvider = provider21;
        this.buildSwimlanesSearchResultNavigationActionUseCaseProvider = provider22;
        this.buildLifestyleSearchNavigationActionUseCaseProvider = provider23;
        this.darkStoreObservabilityTrackerProvider = provider24;
        this.isVLPLoadTimeTrackingEnabledUseCaseProvider = provider25;
        this.getVendorLightningOptimizationExpVariantProvider = provider26;
        this.isVendorLightningOptimizationEnabledUseCaseProvider = provider27;
        this.swimlanesTrackerProvider = provider28;
        this.buildVoucherDetailsNavigationUseCaseProvider = provider29;
        this.buildVoucherProductListingNavigationUseCaseProvider = provider30;
        this.buildBannerCampaignProductListingNavigationUseCaseProvider = provider31;
    }

    public static HomeFragmentViewModel_Factory create(Provider<CartController> provider, Provider<DarkstoresRepo> provider2, Provider<IScreenTracker> provider3, Provider<CustomerRepository> provider4, Provider<CompositeDisposable> provider5, Provider<DarkstoresEventTracker> provider6, Provider<HomeTracker> provider7, Provider<ITalabatExperiment> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<ISubscriptionsFeatureFlagsRepository> provider10, Provider<ConfigurationParameters> provider11, Provider<Scheduler> provider12, Provider<BuildSearchNavigationActionUseCase> provider13, Provider<BuildTalabatAiNavigationActionUseCase> provider14, Provider<DarkstoresListener> provider15, Provider<ShouldShowTalabatAiEntryPointUseCase> provider16, Provider<VendorLandingFeedUseCase> provider17, Provider<BuildCategoryProductsNavigationActionUseCase> provider18, Provider<ProductImpressionTracker> provider19, Provider<ProductImpressionTracker> provider20, Provider<ProductImpressionTracker> provider21, Provider<BuildSwimlanesSearchResultNavigationActionUseCase> provider22, Provider<BuildLifestyleSearchResultNavigationActionUseCase> provider23, Provider<DarkStoreObservabilityTracker> provider24, Provider<IsVLPLoadTimeTrackingEnabledUseCase> provider25, Provider<GetVendorLightningOptimizationExpVariantUseCase> provider26, Provider<IsVendorLightningOptimizationEnabledUseCase> provider27, Provider<SwimlanesTracker> provider28, Provider<BuildVoucherDetailsNavigationUseCase> provider29, Provider<BuildVoucherProductListingNavigationUseCase> provider30, Provider<BuildBannerCampaignProductListingNavigationUseCase> provider31) {
        return new HomeFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31);
    }

    public static HomeFragmentViewModel newInstance(CartController cartController, DarkstoresRepo darkstoresRepo, IScreenTracker iScreenTracker, CustomerRepository customerRepository, CompositeDisposable compositeDisposable, DarkstoresEventTracker darkstoresEventTracker, HomeTracker homeTracker, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, ConfigurationParameters configurationParameters, Scheduler scheduler, BuildSearchNavigationActionUseCase buildSearchNavigationActionUseCase, BuildTalabatAiNavigationActionUseCase buildTalabatAiNavigationActionUseCase, DarkstoresListener darkstoresListener, ShouldShowTalabatAiEntryPointUseCase shouldShowTalabatAiEntryPointUseCase, VendorLandingFeedUseCase vendorLandingFeedUseCase, BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase, ProductImpressionTracker productImpressionTracker, ProductImpressionTracker productImpressionTracker2, ProductImpressionTracker productImpressionTracker3, BuildSwimlanesSearchResultNavigationActionUseCase buildSwimlanesSearchResultNavigationActionUseCase, BuildLifestyleSearchResultNavigationActionUseCase buildLifestyleSearchResultNavigationActionUseCase, DarkStoreObservabilityTracker darkStoreObservabilityTracker, IsVLPLoadTimeTrackingEnabledUseCase isVLPLoadTimeTrackingEnabledUseCase, GetVendorLightningOptimizationExpVariantUseCase getVendorLightningOptimizationExpVariantUseCase, IsVendorLightningOptimizationEnabledUseCase isVendorLightningOptimizationEnabledUseCase, SwimlanesTracker swimlanesTracker, BuildVoucherDetailsNavigationUseCase buildVoucherDetailsNavigationUseCase, BuildVoucherProductListingNavigationUseCase buildVoucherProductListingNavigationUseCase, BuildBannerCampaignProductListingNavigationUseCase buildBannerCampaignProductListingNavigationUseCase) {
        return new HomeFragmentViewModel(cartController, darkstoresRepo, iScreenTracker, customerRepository, compositeDisposable, darkstoresEventTracker, homeTracker, iTalabatExperiment, iTalabatFeatureFlag, iSubscriptionsFeatureFlagsRepository, configurationParameters, scheduler, buildSearchNavigationActionUseCase, buildTalabatAiNavigationActionUseCase, darkstoresListener, shouldShowTalabatAiEntryPointUseCase, vendorLandingFeedUseCase, buildCategoryProductsNavigationActionUseCase, productImpressionTracker, productImpressionTracker2, productImpressionTracker3, buildSwimlanesSearchResultNavigationActionUseCase, buildLifestyleSearchResultNavigationActionUseCase, darkStoreObservabilityTracker, isVLPLoadTimeTrackingEnabledUseCase, getVendorLightningOptimizationExpVariantUseCase, isVendorLightningOptimizationEnabledUseCase, swimlanesTracker, buildVoucherDetailsNavigationUseCase, buildVoucherProductListingNavigationUseCase, buildBannerCampaignProductListingNavigationUseCase);
    }

    public HomeFragmentViewModel get() {
        return newInstance(this.cartControllerProvider.get(), this.darkstoresRepoProvider.get(), this.screenTrackerProvider.get(), this.customerRepositoryProvider.get(), this.compositeDisposableProvider.get(), this.trackerProvider.get(), this.homeTrackerProvider.get(), this.talabatExperimentProvider.get(), this.talabatFeatureFlagProvider.get(), this.subscriptionsFlagsRepoProvider.get(), this.configurationParametersProvider.get(), this.ioSchedulerProvider.get(), this.buildSearchNavigationActionProvider.get(), this.buildTalabatAiNavigationActionUseCaseProvider.get(), this.listenerProvider.get(), this.shouldShowTalabatAiEntryPointUseCaseProvider.get(), this.vendorLandingFeedUseCaseProvider.get(), this.buildCategoryProductsNavigationActionProvider.get(), this.productImpressionTrackerProvider.get(), this.smallBannerProductTrackerProvider.get(), this.heroBannerProductTrackerProvider.get(), this.buildSwimlanesSearchResultNavigationActionUseCaseProvider.get(), this.buildLifestyleSearchNavigationActionUseCaseProvider.get(), this.darkStoreObservabilityTrackerProvider.get(), this.isVLPLoadTimeTrackingEnabledUseCaseProvider.get(), this.getVendorLightningOptimizationExpVariantProvider.get(), this.isVendorLightningOptimizationEnabledUseCaseProvider.get(), this.swimlanesTrackerProvider.get(), this.buildVoucherDetailsNavigationUseCaseProvider.get(), this.buildVoucherProductListingNavigationUseCaseProvider.get(), this.buildBannerCampaignProductListingNavigationUseCaseProvider.get());
    }
}
