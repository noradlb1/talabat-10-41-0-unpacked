package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.core.network.domain.endpoint.IBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstoresvendor.data.di.GroceryAffordability"})
public final class GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityBaseUrlFactory implements Factory<IBaseUrl> {
    private final GroceryAffordabilityNetworkModule module;

    public GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityBaseUrlFactory(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule) {
        this.module = groceryAffordabilityNetworkModule;
    }

    public static GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityBaseUrlFactory create(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule) {
        return new GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityBaseUrlFactory(groceryAffordabilityNetworkModule);
    }

    public static IBaseUrl provideGroceryAffordabilityBaseUrl(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule) {
        return (IBaseUrl) Preconditions.checkNotNullFromProvides(groceryAffordabilityNetworkModule.provideGroceryAffordabilityBaseUrl());
    }

    public IBaseUrl get() {
        return provideGroceryAffordabilityBaseUrl(this.module);
    }
}
