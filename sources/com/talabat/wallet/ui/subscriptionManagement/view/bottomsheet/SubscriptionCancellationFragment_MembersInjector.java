package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class SubscriptionCancellationFragment_MembersInjector implements MembersInjector<SubscriptionCancellationFragment> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GetSavingsInfoUseCase> getSavingsInfoUseCaseProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagProvider;

    public SubscriptionCancellationFragment_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<GetSavingsInfoUseCase> provider2, Provider<ISubscriptionsFeatureFlagsRepository> provider3) {
        this.featureFlagRepoProvider = provider;
        this.getSavingsInfoUseCaseProvider = provider2;
        this.subscriptionsFeatureFlagProvider = provider3;
    }

    public static MembersInjector<SubscriptionCancellationFragment> create(Provider<ITalabatFeatureFlag> provider, Provider<GetSavingsInfoUseCase> provider2, Provider<ISubscriptionsFeatureFlagsRepository> provider3) {
        return new SubscriptionCancellationFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(SubscriptionCancellationFragment subscriptionCancellationFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        subscriptionCancellationFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment.getSavingsInfoUseCase")
    public static void injectGetSavingsInfoUseCase(SubscriptionCancellationFragment subscriptionCancellationFragment, GetSavingsInfoUseCase getSavingsInfoUseCase) {
        subscriptionCancellationFragment.getSavingsInfoUseCase = getSavingsInfoUseCase;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment.subscriptionsFeatureFlag")
    public static void injectSubscriptionsFeatureFlag(SubscriptionCancellationFragment subscriptionCancellationFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        subscriptionCancellationFragment.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public void injectMembers(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        injectFeatureFlagRepo(subscriptionCancellationFragment, this.featureFlagRepoProvider.get());
        injectGetSavingsInfoUseCase(subscriptionCancellationFragment, this.getSavingsInfoUseCaseProvider.get());
        injectSubscriptionsFeatureFlag(subscriptionCancellationFragment, this.subscriptionsFeatureFlagProvider.get());
    }
}
