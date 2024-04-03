package com.talabat.feature.mission.control.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.mission.control.data.remote.GroceryBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class MissionControlNetworkModule_ProvideQCommerceGroceryBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<GroceryBaseUrl> baseUrlProvider;

    public MissionControlNetworkModule_ProvideQCommerceGroceryBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.baseUrlProvider = provider2;
    }

    public static MissionControlNetworkModule_ProvideQCommerceGroceryBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        return new MissionControlNetworkModule_ProvideQCommerceGroceryBaseUrlFactory(provider, provider2);
    }

    public static String provideQCommerceGroceryBaseUrl(BaseUrlFactory baseUrlFactory, GroceryBaseUrl groceryBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(MissionControlNetworkModule.INSTANCE.provideQCommerceGroceryBaseUrl(baseUrlFactory, groceryBaseUrl));
    }

    public String get() {
        return provideQCommerceGroceryBaseUrl(this.baseUrlFactoryProvider.get(), this.baseUrlProvider.get());
    }
}
