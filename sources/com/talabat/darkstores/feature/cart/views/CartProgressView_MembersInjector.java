package com.talabat.darkstores.feature.cart.views;

import androidx.lifecycle.ViewModelProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CartProgressView_MembersInjector implements MembersInjector<CartProgressView> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFlagsRepoProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CartProgressView_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<ISubscriptionsFeatureFlagsRepository> provider2, Provider<CustomerRepository> provider3, Provider<ITalabatFeatureFlag> provider4) {
        this.viewModelFactoryProvider = provider;
        this.subscriptionsFlagsRepoProvider = provider2;
        this.customerRepositoryProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
    }

    public static MembersInjector<CartProgressView> create(Provider<ViewModelProvider.Factory> provider, Provider<ISubscriptionsFeatureFlagsRepository> provider2, Provider<CustomerRepository> provider3, Provider<ITalabatFeatureFlag> provider4) {
        return new CartProgressView_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.darkstores.feature.cart.views.CartProgressView.customerRepository")
    public static void injectCustomerRepository(CartProgressView cartProgressView, CustomerRepository customerRepository) {
        cartProgressView.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.darkstores.feature.cart.views.CartProgressView.subscriptionsFlagsRepo")
    public static void injectSubscriptionsFlagsRepo(CartProgressView cartProgressView, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        cartProgressView.subscriptionsFlagsRepo = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.darkstores.feature.cart.views.CartProgressView.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(CartProgressView cartProgressView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        cartProgressView.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.darkstores.feature.cart.views.CartProgressView.viewModelFactory")
    public static void injectViewModelFactory(CartProgressView cartProgressView, ViewModelProvider.Factory factory) {
        cartProgressView.viewModelFactory = factory;
    }

    public void injectMembers(CartProgressView cartProgressView) {
        injectViewModelFactory(cartProgressView, this.viewModelFactoryProvider.get());
        injectSubscriptionsFlagsRepo(cartProgressView, this.subscriptionsFlagsRepoProvider.get());
        injectCustomerRepository(cartProgressView, this.customerRepositoryProvider.get());
        injectTalabatFeatureFlag(cartProgressView, this.talabatFeatureFlagProvider.get());
    }
}
