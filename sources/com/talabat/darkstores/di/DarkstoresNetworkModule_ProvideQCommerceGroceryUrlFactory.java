package com.talabat.darkstores.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.darkstores.data.grocery.GroceryBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.QCommerceGrocery"})
public final class DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<GroceryBaseUrl> baseUrlProvider;

    public DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory(Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.baseUrlProvider = provider2;
    }

    public static DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory create(Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        return new DarkstoresNetworkModule_ProvideQCommerceGroceryUrlFactory(provider, provider2);
    }

    public static String provideQCommerceGroceryUrl(BaseUrlFactory baseUrlFactory, GroceryBaseUrl groceryBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideQCommerceGroceryUrl(baseUrlFactory, groceryBaseUrl));
    }

    public String get() {
        return provideQCommerceGroceryUrl(this.baseUrlFactoryProvider.get(), this.baseUrlProvider.get());
    }
}
