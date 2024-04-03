package com.talabat.darkstores.feature.cart;

import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CartFragment_MembersInjector implements MembersInjector<CartFragment> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFlagsRepoProvider;

    public CartFragment_MembersInjector(Provider<ISubscriptionsFeatureFlagsRepository> provider, Provider<CustomerRepository> provider2) {
        this.subscriptionsFlagsRepoProvider = provider;
        this.customerRepositoryProvider = provider2;
    }

    public static MembersInjector<CartFragment> create(Provider<ISubscriptionsFeatureFlagsRepository> provider, Provider<CustomerRepository> provider2) {
        return new CartFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.darkstores.feature.cart.CartFragment.customerRepository")
    public static void injectCustomerRepository(CartFragment cartFragment, CustomerRepository customerRepository) {
        cartFragment.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.darkstores.feature.cart.CartFragment.subscriptionsFlagsRepo")
    public static void injectSubscriptionsFlagsRepo(CartFragment cartFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        cartFragment.subscriptionsFlagsRepo = iSubscriptionsFeatureFlagsRepository;
    }

    public void injectMembers(CartFragment cartFragment) {
        injectSubscriptionsFlagsRepo(cartFragment, this.subscriptionsFlagsRepoProvider.get());
        injectCustomerRepository(cartFragment, this.customerRepositoryProvider.get());
    }
}
