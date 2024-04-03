package com.talabat.feature.subscriptions.data.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionPaymentOTPUseCaseImpl_Factory implements Factory<SubscriptionPaymentOTPUseCaseImpl> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public SubscriptionPaymentOTPUseCaseImpl_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static SubscriptionPaymentOTPUseCaseImpl_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new SubscriptionPaymentOTPUseCaseImpl_Factory(provider);
    }

    public static SubscriptionPaymentOTPUseCaseImpl newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new SubscriptionPaymentOTPUseCaseImpl(iSubscriptionsRepository);
    }

    public SubscriptionPaymentOTPUseCaseImpl get() {
        return newInstance(this.repositoryProvider.get());
    }
}
