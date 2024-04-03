package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.CancelFreeTrialUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionDetailsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproSubscriptionDetailsViewModel_Factory implements Factory<TproSubscriptionDetailsViewModel> {
    private final Provider<CancelFreeTrialUseCase> cancelFreeTrialUseCaseProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ProCentralizationStatusWrapper> getProCentralizationStatusWrapperProvider;
    private final Provider<GetSavingsInfoUseCase> getSavingsInfoUseCaseProvider;
    private final Provider<GetSubscriptionDetailsUseCase> getSubscriptionDetailsProvider;
    private final Provider<ISubscriptionsCustomerRepository> subscriptionsCustomerHelperProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionsStatusRepositoryProvider;
    private final Provider<UpdateAutoRenewalUseCase> updateAutoRenewalUseCaseProvider;

    public TproSubscriptionDetailsViewModel_Factory(Provider<GetSubscriptionDetailsUseCase> provider, Provider<GetSavingsInfoUseCase> provider2, Provider<UpdateAutoRenewalUseCase> provider3, Provider<CancelFreeTrialUseCase> provider4, Provider<ISubscriptionsCustomerRepository> provider5, Provider<ISubscriptionStatusRepository> provider6, Provider<ConfigurationLocalRepository> provider7, Provider<ProCentralizationStatusWrapper> provider8) {
        this.getSubscriptionDetailsProvider = provider;
        this.getSavingsInfoUseCaseProvider = provider2;
        this.updateAutoRenewalUseCaseProvider = provider3;
        this.cancelFreeTrialUseCaseProvider = provider4;
        this.subscriptionsCustomerHelperProvider = provider5;
        this.subscriptionsStatusRepositoryProvider = provider6;
        this.configurationLocalRepositoryProvider = provider7;
        this.getProCentralizationStatusWrapperProvider = provider8;
    }

    public static TproSubscriptionDetailsViewModel_Factory create(Provider<GetSubscriptionDetailsUseCase> provider, Provider<GetSavingsInfoUseCase> provider2, Provider<UpdateAutoRenewalUseCase> provider3, Provider<CancelFreeTrialUseCase> provider4, Provider<ISubscriptionsCustomerRepository> provider5, Provider<ISubscriptionStatusRepository> provider6, Provider<ConfigurationLocalRepository> provider7, Provider<ProCentralizationStatusWrapper> provider8) {
        return new TproSubscriptionDetailsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static TproSubscriptionDetailsViewModel newInstance(GetSubscriptionDetailsUseCase getSubscriptionDetailsUseCase, GetSavingsInfoUseCase getSavingsInfoUseCase, UpdateAutoRenewalUseCase updateAutoRenewalUseCase, CancelFreeTrialUseCase cancelFreeTrialUseCase, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, ConfigurationLocalRepository configurationLocalRepository, ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        return new TproSubscriptionDetailsViewModel(getSubscriptionDetailsUseCase, getSavingsInfoUseCase, updateAutoRenewalUseCase, cancelFreeTrialUseCase, iSubscriptionsCustomerRepository, iSubscriptionStatusRepository, configurationLocalRepository, proCentralizationStatusWrapper);
    }

    public TproSubscriptionDetailsViewModel get() {
        return newInstance(this.getSubscriptionDetailsProvider.get(), this.getSavingsInfoUseCaseProvider.get(), this.updateAutoRenewalUseCaseProvider.get(), this.cancelFreeTrialUseCaseProvider.get(), this.subscriptionsCustomerHelperProvider.get(), this.subscriptionsStatusRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.getProCentralizationStatusWrapperProvider.get());
    }
}
