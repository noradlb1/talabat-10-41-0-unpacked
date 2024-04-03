package com.talabat.darkstores.domain.recentsearches.observability;

import com.integration.grocerydiscovery.GroceryDiscoveryObservabilityIntegration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RecentSearchesObservabilityManagerImpl_Factory implements Factory<RecentSearchesObservabilityManagerImpl> {
    private final Provider<GroceryDiscoveryObservabilityIntegration> observabilityProvider;

    public RecentSearchesObservabilityManagerImpl_Factory(Provider<GroceryDiscoveryObservabilityIntegration> provider) {
        this.observabilityProvider = provider;
    }

    public static RecentSearchesObservabilityManagerImpl_Factory create(Provider<GroceryDiscoveryObservabilityIntegration> provider) {
        return new RecentSearchesObservabilityManagerImpl_Factory(provider);
    }

    public static RecentSearchesObservabilityManagerImpl newInstance(GroceryDiscoveryObservabilityIntegration groceryDiscoveryObservabilityIntegration) {
        return new RecentSearchesObservabilityManagerImpl(groceryDiscoveryObservabilityIntegration);
    }

    public RecentSearchesObservabilityManagerImpl get() {
        return newInstance(this.observabilityProvider.get());
    }
}
