package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstoresvendor.data.di.GroceryAffordability"})
public final class GroceryAffordabilityNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<IBaseUrl> groceryAffordabilityBaseUrlProvider;
    private final GroceryAffordabilityNetworkModule module;

    public GroceryAffordabilityNetworkModule_ProvideBaseUrlFactory(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<BaseUrlFactory> provider, Provider<IBaseUrl> provider2) {
        this.module = groceryAffordabilityNetworkModule;
        this.baseUrlFactoryProvider = provider;
        this.groceryAffordabilityBaseUrlProvider = provider2;
    }

    public static GroceryAffordabilityNetworkModule_ProvideBaseUrlFactory create(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<BaseUrlFactory> provider, Provider<IBaseUrl> provider2) {
        return new GroceryAffordabilityNetworkModule_ProvideBaseUrlFactory(groceryAffordabilityNetworkModule, provider, provider2);
    }

    public static String provideBaseUrl(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, BaseUrlFactory baseUrlFactory, IBaseUrl iBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(groceryAffordabilityNetworkModule.provideBaseUrl(baseUrlFactory, iBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.module, this.baseUrlFactoryProvider.get(), this.groceryAffordabilityBaseUrlProvider.get());
    }
}
