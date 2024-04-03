package com.talabat.core.deeplink.data.handler.bnpl;

import com.talabat.core.navigation.domain.Navigator;
import com.talabat.customer.domain.CustomerRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BNPLDashboardHandler_Factory implements Factory<BNPLDashboardHandler> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;

    public BNPLDashboardHandler_Factory(Provider<Navigator> provider, Provider<CustomerRepository> provider2) {
        this.navigatorProvider = provider;
        this.customerRepositoryProvider = provider2;
    }

    public static BNPLDashboardHandler_Factory create(Provider<Navigator> provider, Provider<CustomerRepository> provider2) {
        return new BNPLDashboardHandler_Factory(provider, provider2);
    }

    public static BNPLDashboardHandler newInstance(Navigator navigator, CustomerRepository customerRepository) {
        return new BNPLDashboardHandler(navigator, customerRepository);
    }

    public BNPLDashboardHandler get() {
        return newInstance(this.navigatorProvider.get(), this.customerRepositoryProvider.get());
    }
}
