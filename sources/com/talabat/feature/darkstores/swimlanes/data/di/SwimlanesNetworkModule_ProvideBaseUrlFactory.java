package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstores.swimlanes.data.remote.GroceryBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class SwimlanesNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<GroceryBaseUrl> baseUrlProvider;

    public SwimlanesNetworkModule_ProvideBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.baseUrlProvider = provider2;
    }

    public static SwimlanesNetworkModule_ProvideBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        return new SwimlanesNetworkModule_ProvideBaseUrlFactory(provider, provider2);
    }

    public static String provideBaseUrl(BaseUrlFactory baseUrlFactory, GroceryBaseUrl groceryBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(SwimlanesNetworkModule.INSTANCE.provideBaseUrl(baseUrlFactory, groceryBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.baseUrlFactoryProvider.get(), this.baseUrlProvider.get());
    }
}
