package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetSubscriptionWithB2BVoucherUseCase_Factory implements Factory<GetSubscriptionWithB2BVoucherUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionWithB2BVoucherUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSubscriptionWithB2BVoucherUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSubscriptionWithB2BVoucherUseCase_Factory(provider);
    }

    public static GetSubscriptionWithB2BVoucherUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSubscriptionWithB2BVoucherUseCase(iSubscriptionsRepository);
    }

    public GetSubscriptionWithB2BVoucherUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
