package com.talabat.darkstores.feature.mission.control;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.GetFlutterConfigurationParamsUseCase;
import com.talabat.darkstores.domain.common.IsFlutterVLPEnabledUseCase;
import com.talabat.darkstores.feature.main.usecase.GenerateVoucherUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MainViewModel_Factory implements Factory<MainViewModel> {
    private final Provider<BuildBannerCampaignProductListingNavigationUseCase> buildBannerCampaignProductListingNavigationUseCaseProvider;
    private final Provider<BuildCartNavigationActionUseCase> buildCartNavigationActionProvider;
    private final Provider<BuildCategoryProductsNavigationActionUseCase> buildCategoryProductsNavigationActionProvider;
    private final Provider<BuildLifestyleSearchResultNavigationActionUseCase> buildLifestyleSearchResultNavigationActionUseCaseProvider;
    private final Provider<BuildSwimlanesSearchResultNavigationActionUseCase> buildSwimlanesSearchResultNavigationActionUseCaseProvider;
    private final Provider<CompositeDisposable> compositeDisposableProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<GenerateVoucherUseCase> generateVoucherUseCaseProvider;
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsUseCaseProvider;
    private final Provider<IsFlutterVLPEnabledUseCase> isFlutterVLPEnabledUseCaseProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public MainViewModel_Factory(Provider<CompositeDisposable> provider, Provider<ITalabatFeatureFlag> provider2, Provider<DiscoveryRepo> provider3, Provider<BuildCategoryProductsNavigationActionUseCase> provider4, Provider<BuildCartNavigationActionUseCase> provider5, Provider<BuildSwimlanesSearchResultNavigationActionUseCase> provider6, Provider<BuildLifestyleSearchResultNavigationActionUseCase> provider7, Provider<GetFlutterConfigurationParamsUseCase> provider8, Provider<IsFlutterVLPEnabledUseCase> provider9, Provider<GenerateVoucherUseCase> provider10, Provider<RxSchedulersFactory> provider11, Provider<IObservabilityManager> provider12, Provider<BuildBannerCampaignProductListingNavigationUseCase> provider13) {
        this.compositeDisposableProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
        this.discoveryRepoProvider = provider3;
        this.buildCategoryProductsNavigationActionProvider = provider4;
        this.buildCartNavigationActionProvider = provider5;
        this.buildSwimlanesSearchResultNavigationActionUseCaseProvider = provider6;
        this.buildLifestyleSearchResultNavigationActionUseCaseProvider = provider7;
        this.getFlutterConfigurationParamsUseCaseProvider = provider8;
        this.isFlutterVLPEnabledUseCaseProvider = provider9;
        this.generateVoucherUseCaseProvider = provider10;
        this.rxSchedulersFactoryProvider = provider11;
        this.observabilityManagerProvider = provider12;
        this.buildBannerCampaignProductListingNavigationUseCaseProvider = provider13;
    }

    public static MainViewModel_Factory create(Provider<CompositeDisposable> provider, Provider<ITalabatFeatureFlag> provider2, Provider<DiscoveryRepo> provider3, Provider<BuildCategoryProductsNavigationActionUseCase> provider4, Provider<BuildCartNavigationActionUseCase> provider5, Provider<BuildSwimlanesSearchResultNavigationActionUseCase> provider6, Provider<BuildLifestyleSearchResultNavigationActionUseCase> provider7, Provider<GetFlutterConfigurationParamsUseCase> provider8, Provider<IsFlutterVLPEnabledUseCase> provider9, Provider<GenerateVoucherUseCase> provider10, Provider<RxSchedulersFactory> provider11, Provider<IObservabilityManager> provider12, Provider<BuildBannerCampaignProductListingNavigationUseCase> provider13) {
        return new MainViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static MainViewModel newInstance(CompositeDisposable compositeDisposable, ITalabatFeatureFlag iTalabatFeatureFlag, DiscoveryRepo discoveryRepo, BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase, BuildCartNavigationActionUseCase buildCartNavigationActionUseCase, BuildSwimlanesSearchResultNavigationActionUseCase buildSwimlanesSearchResultNavigationActionUseCase, BuildLifestyleSearchResultNavigationActionUseCase buildLifestyleSearchResultNavigationActionUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase, IsFlutterVLPEnabledUseCase isFlutterVLPEnabledUseCase, GenerateVoucherUseCase generateVoucherUseCase, RxSchedulersFactory rxSchedulersFactory, IObservabilityManager iObservabilityManager, BuildBannerCampaignProductListingNavigationUseCase buildBannerCampaignProductListingNavigationUseCase) {
        return new MainViewModel(compositeDisposable, iTalabatFeatureFlag, discoveryRepo, buildCategoryProductsNavigationActionUseCase, buildCartNavigationActionUseCase, buildSwimlanesSearchResultNavigationActionUseCase, buildLifestyleSearchResultNavigationActionUseCase, getFlutterConfigurationParamsUseCase, isFlutterVLPEnabledUseCase, generateVoucherUseCase, rxSchedulersFactory, iObservabilityManager, buildBannerCampaignProductListingNavigationUseCase);
    }

    public MainViewModel get() {
        return newInstance(this.compositeDisposableProvider.get(), this.talabatFeatureFlagProvider.get(), this.discoveryRepoProvider.get(), this.buildCategoryProductsNavigationActionProvider.get(), this.buildCartNavigationActionProvider.get(), this.buildSwimlanesSearchResultNavigationActionUseCaseProvider.get(), this.buildLifestyleSearchResultNavigationActionUseCaseProvider.get(), this.getFlutterConfigurationParamsUseCaseProvider.get(), this.isFlutterVLPEnabledUseCaseProvider.get(), this.generateVoucherUseCaseProvider.get(), this.rxSchedulersFactoryProvider.get(), this.observabilityManagerProvider.get(), this.buildBannerCampaignProductListingNavigationUseCaseProvider.get());
    }
}
