package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import android.content.res.Resources;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.subscriptions.domain.usecase.TProOnBoardingBannerAndPlansUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TproBenefitsViewModel_Factory implements Factory<TproBenefitsViewModel> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<Integer> countryIdProvider;
    private final Provider<GetActiveSubscriptionsUseCase> getActiveSubscriptionsUseCaseProvider;
    private final Provider<ProCentralizationStatusWrapper> getProCentralizationStatusWrapperProvider;
    private final Provider<MultiPlanParams> multiPlanParamsProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<GetSubscriptionWithB2BVoucherUseCase> subscriptionWithB2BVoucherUseCaseProvider;
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;
    private final Provider<TProOnBoardingBannerAndPlansUseCase> tProOnBoardingBannerAndPlansUseCaseProvider;

    public TproBenefitsViewModel_Factory(Provider<Resources> provider, Provider<Integer> provider2, Provider<MultiPlanParams> provider3, Provider<ISubscriptionsTracker> provider4, Provider<GetSubscriptionWithB2BVoucherUseCase> provider5, Provider<GetActiveSubscriptionsUseCase> provider6, Provider<ConfigurationLocalRepository> provider7, Provider<ISubscriptionStatusRepository> provider8, Provider<TProOnBoardingBannerAndPlansUseCase> provider9, Provider<ProCentralizationStatusWrapper> provider10) {
        this.resourcesProvider = provider;
        this.countryIdProvider = provider2;
        this.multiPlanParamsProvider = provider3;
        this.subscriptionsTrackerProvider = provider4;
        this.subscriptionWithB2BVoucherUseCaseProvider = provider5;
        this.getActiveSubscriptionsUseCaseProvider = provider6;
        this.configurationLocalRepositoryProvider = provider7;
        this.subscriptionStatusRepositoryProvider = provider8;
        this.tProOnBoardingBannerAndPlansUseCaseProvider = provider9;
        this.getProCentralizationStatusWrapperProvider = provider10;
    }

    public static TproBenefitsViewModel_Factory create(Provider<Resources> provider, Provider<Integer> provider2, Provider<MultiPlanParams> provider3, Provider<ISubscriptionsTracker> provider4, Provider<GetSubscriptionWithB2BVoucherUseCase> provider5, Provider<GetActiveSubscriptionsUseCase> provider6, Provider<ConfigurationLocalRepository> provider7, Provider<ISubscriptionStatusRepository> provider8, Provider<TProOnBoardingBannerAndPlansUseCase> provider9, Provider<ProCentralizationStatusWrapper> provider10) {
        return new TproBenefitsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static TproBenefitsViewModel newInstance(Resources resources, int i11, MultiPlanParams multiPlanParams, ISubscriptionsTracker iSubscriptionsTracker, GetSubscriptionWithB2BVoucherUseCase getSubscriptionWithB2BVoucherUseCase, GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase, ConfigurationLocalRepository configurationLocalRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, TProOnBoardingBannerAndPlansUseCase tProOnBoardingBannerAndPlansUseCase, ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        return new TproBenefitsViewModel(resources, i11, multiPlanParams, iSubscriptionsTracker, getSubscriptionWithB2BVoucherUseCase, getActiveSubscriptionsUseCase, configurationLocalRepository, iSubscriptionStatusRepository, tProOnBoardingBannerAndPlansUseCase, proCentralizationStatusWrapper);
    }

    public TproBenefitsViewModel get() {
        return newInstance(this.resourcesProvider.get(), this.countryIdProvider.get().intValue(), this.multiPlanParamsProvider.get(), this.subscriptionsTrackerProvider.get(), this.subscriptionWithB2BVoucherUseCaseProvider.get(), this.getActiveSubscriptionsUseCaseProvider.get(), this.configurationLocalRepositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get(), this.tProOnBoardingBannerAndPlansUseCaseProvider.get(), this.getProCentralizationStatusWrapperProvider.get());
    }
}
