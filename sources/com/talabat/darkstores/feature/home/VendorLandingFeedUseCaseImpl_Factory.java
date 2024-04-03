package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class VendorLandingFeedUseCaseImpl_Factory implements Factory<VendorLandingFeedUseCaseImpl> {
    private final Provider<ApplyDiscountsAndCampaignsUseCase> applyDiscountsAndCampaignsProvider;
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<IsVendorLightningOptimizationEnabledUseCase> isVendorLightningOptimizationEnabledUseCaseProvider;
    private final Provider<VendorLandingRepository> vendorLandingRepositoryProvider;
    private final Provider<ModelMapper<VendorLanding, FeedMultiListData>> vendorLandingToFeedsMapperProvider;

    public VendorLandingFeedUseCaseImpl_Factory(Provider<ConfigurationParameters> provider, Provider<Scheduler> provider2, Provider<VendorLandingRepository> provider3, Provider<ModelMapper<VendorLanding, FeedMultiListData>> provider4, Provider<DarkstoresRepo> provider5, Provider<ApplyDiscountsAndCampaignsUseCase> provider6, Provider<IsVendorLightningOptimizationEnabledUseCase> provider7) {
        this.configurationParametersProvider = provider;
        this.ioSchedulerProvider = provider2;
        this.vendorLandingRepositoryProvider = provider3;
        this.vendorLandingToFeedsMapperProvider = provider4;
        this.darkstoresRepoProvider = provider5;
        this.applyDiscountsAndCampaignsProvider = provider6;
        this.isVendorLightningOptimizationEnabledUseCaseProvider = provider7;
    }

    public static VendorLandingFeedUseCaseImpl_Factory create(Provider<ConfigurationParameters> provider, Provider<Scheduler> provider2, Provider<VendorLandingRepository> provider3, Provider<ModelMapper<VendorLanding, FeedMultiListData>> provider4, Provider<DarkstoresRepo> provider5, Provider<ApplyDiscountsAndCampaignsUseCase> provider6, Provider<IsVendorLightningOptimizationEnabledUseCase> provider7) {
        return new VendorLandingFeedUseCaseImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static VendorLandingFeedUseCaseImpl newInstance(ConfigurationParameters configurationParameters, Scheduler scheduler, VendorLandingRepository vendorLandingRepository, ModelMapper<VendorLanding, FeedMultiListData> modelMapper, DarkstoresRepo darkstoresRepo, ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase, IsVendorLightningOptimizationEnabledUseCase isVendorLightningOptimizationEnabledUseCase) {
        return new VendorLandingFeedUseCaseImpl(configurationParameters, scheduler, vendorLandingRepository, modelMapper, darkstoresRepo, applyDiscountsAndCampaignsUseCase, isVendorLightningOptimizationEnabledUseCase);
    }

    public VendorLandingFeedUseCaseImpl get() {
        return newInstance(this.configurationParametersProvider.get(), this.ioSchedulerProvider.get(), this.vendorLandingRepositoryProvider.get(), this.vendorLandingToFeedsMapperProvider.get(), this.darkstoresRepoProvider.get(), this.applyDiscountsAndCampaignsProvider.get(), this.isVendorLightningOptimizationEnabledUseCaseProvider.get());
    }
}
