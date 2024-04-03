package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeSubscriptionPaymentOTPUseCase_Factory implements Factory<FakeSubscriptionPaymentOTPUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public FakeSubscriptionPaymentOTPUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static FakeSubscriptionPaymentOTPUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new FakeSubscriptionPaymentOTPUseCase_Factory(provider);
    }

    public static FakeSubscriptionPaymentOTPUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new FakeSubscriptionPaymentOTPUseCase(iSubscriptionsRepository);
    }

    public FakeSubscriptionPaymentOTPUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
