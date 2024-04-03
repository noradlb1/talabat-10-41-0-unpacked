package com.talabat.feature.tpro.presentation.payment.viewmodel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.MultiPlanParams;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProPaymentBottomSheetViewModel_Factory implements Factory<TProPaymentBottomSheetViewModel> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GetActiveSubscriptionsUseCase> getActiveSubscriptionsUseCaseProvider;
    private final Provider<GetSubscriptionPaymentUseCase> getSubscriptionPaymentUseCaseProvider;
    private final Provider<MultiPlanParams> multiPlanParamsProvider;
    private final Provider<RemoteConfiguration> remoteConfigProvider;
    private final Provider<SubscriptionPaymentOTPUseCase> subscriptionPaymentOTPUseCaseProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<GetSubscriptionWithB2BVoucherUseCase> subscriptionWithB2BVoucherUseCaseProvider;

    public TProPaymentBottomSheetViewModel_Factory(Provider<GetSubscriptionPaymentUseCase> provider, Provider<GetActiveSubscriptionsUseCase> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<ISubscriptionStatusRepository> provider4, Provider<GetSubscriptionWithB2BVoucherUseCase> provider5, Provider<MultiPlanParams> provider6, Provider<SubscriptionPaymentOTPUseCase> provider7, Provider<RemoteConfiguration> provider8) {
        this.getSubscriptionPaymentUseCaseProvider = provider;
        this.getActiveSubscriptionsUseCaseProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.subscriptionStatusRepositoryProvider = provider4;
        this.subscriptionWithB2BVoucherUseCaseProvider = provider5;
        this.multiPlanParamsProvider = provider6;
        this.subscriptionPaymentOTPUseCaseProvider = provider7;
        this.remoteConfigProvider = provider8;
    }

    public static TProPaymentBottomSheetViewModel_Factory create(Provider<GetSubscriptionPaymentUseCase> provider, Provider<GetActiveSubscriptionsUseCase> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<ISubscriptionStatusRepository> provider4, Provider<GetSubscriptionWithB2BVoucherUseCase> provider5, Provider<MultiPlanParams> provider6, Provider<SubscriptionPaymentOTPUseCase> provider7, Provider<RemoteConfiguration> provider8) {
        return new TProPaymentBottomSheetViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static TProPaymentBottomSheetViewModel newInstance(GetSubscriptionPaymentUseCase getSubscriptionPaymentUseCase, GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase, ConfigurationLocalRepository configurationLocalRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, GetSubscriptionWithB2BVoucherUseCase getSubscriptionWithB2BVoucherUseCase, MultiPlanParams multiPlanParams, SubscriptionPaymentOTPUseCase subscriptionPaymentOTPUseCase, RemoteConfiguration remoteConfiguration) {
        return new TProPaymentBottomSheetViewModel(getSubscriptionPaymentUseCase, getActiveSubscriptionsUseCase, configurationLocalRepository, iSubscriptionStatusRepository, getSubscriptionWithB2BVoucherUseCase, multiPlanParams, subscriptionPaymentOTPUseCase, remoteConfiguration);
    }

    public TProPaymentBottomSheetViewModel get() {
        return newInstance(this.getSubscriptionPaymentUseCaseProvider.get(), this.getActiveSubscriptionsUseCaseProvider.get(), this.configurationLocalRepositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get(), this.subscriptionWithB2BVoucherUseCaseProvider.get(), this.multiPlanParamsProvider.get(), this.subscriptionPaymentOTPUseCaseProvider.get(), this.remoteConfigProvider.get());
    }
}
