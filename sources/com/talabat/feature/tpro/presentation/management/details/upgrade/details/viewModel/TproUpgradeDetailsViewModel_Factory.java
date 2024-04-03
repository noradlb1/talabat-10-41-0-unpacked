package com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpgradeSubscriptionPlanUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproUpgradeDetailsViewModel_Factory implements Factory<TproUpgradeDetailsViewModel> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GetActiveSubscriptionsUseCase> getActiveSubscriptionsUseCaseProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<UpgradeSubscriptionPlanUseCase> upgradePlanUseCaseProvider;

    public TproUpgradeDetailsViewModel_Factory(Provider<UpgradeSubscriptionPlanUseCase> provider, Provider<GetActiveSubscriptionsUseCase> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<ISubscriptionStatusRepository> provider4) {
        this.upgradePlanUseCaseProvider = provider;
        this.getActiveSubscriptionsUseCaseProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.subscriptionStatusRepositoryProvider = provider4;
    }

    public static TproUpgradeDetailsViewModel_Factory create(Provider<UpgradeSubscriptionPlanUseCase> provider, Provider<GetActiveSubscriptionsUseCase> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<ISubscriptionStatusRepository> provider4) {
        return new TproUpgradeDetailsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TproUpgradeDetailsViewModel newInstance(UpgradeSubscriptionPlanUseCase upgradeSubscriptionPlanUseCase, GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase, ConfigurationLocalRepository configurationLocalRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        return new TproUpgradeDetailsViewModel(upgradeSubscriptionPlanUseCase, getActiveSubscriptionsUseCase, configurationLocalRepository, iSubscriptionStatusRepository);
    }

    public TproUpgradeDetailsViewModel get() {
        return newInstance(this.upgradePlanUseCaseProvider.get(), this.getActiveSubscriptionsUseCaseProvider.get(), this.configurationLocalRepositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get());
    }
}
