package com.talabat.feature.subscriptions.data.usecase;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetTProOrderStatusUseCaseImpl_Factory implements Factory<GetTProOrderStatusUseCaseImpl> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFlagsProvider;
    private final Provider<SubscriptionsRepositoryImpl> subscriptionsRepositoryProvider;
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;

    public GetTProOrderStatusUseCaseImpl_Factory(Provider<ISubscriptionsFeatureFlagsRepository> provider, Provider<ISubscriptionStatusRepository> provider2, Provider<ISubscriptionsTracker> provider3, Provider<SubscriptionsRepositoryImpl> provider4, Provider<CoroutineDispatchersFactory> provider5) {
        this.subscriptionsFlagsProvider = provider;
        this.subscriptionStatusRepositoryProvider = provider2;
        this.subscriptionsTrackerProvider = provider3;
        this.subscriptionsRepositoryProvider = provider4;
        this.coroutineDispatchersFactoryProvider = provider5;
    }

    public static GetTProOrderStatusUseCaseImpl_Factory create(Provider<ISubscriptionsFeatureFlagsRepository> provider, Provider<ISubscriptionStatusRepository> provider2, Provider<ISubscriptionsTracker> provider3, Provider<SubscriptionsRepositoryImpl> provider4, Provider<CoroutineDispatchersFactory> provider5) {
        return new GetTProOrderStatusUseCaseImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static GetTProOrderStatusUseCaseImpl newInstance(ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, ISubscriptionsTracker iSubscriptionsTracker, SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new GetTProOrderStatusUseCaseImpl(iSubscriptionsFeatureFlagsRepository, iSubscriptionStatusRepository, iSubscriptionsTracker, subscriptionsRepositoryImpl, coroutineDispatchersFactory);
    }

    public GetTProOrderStatusUseCaseImpl get() {
        return newInstance(this.subscriptionsFlagsProvider.get(), this.subscriptionStatusRepositoryProvider.get(), this.subscriptionsTrackerProvider.get(), this.subscriptionsRepositoryProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
