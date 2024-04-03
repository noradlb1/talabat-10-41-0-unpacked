package com.talabat.feature.subscriptions.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class SubscriptionsNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<SubscriptionsBaseUrl> subscriptionsBaseUrlProvider;

    public SubscriptionsNetworkModule_ProvideBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<SubscriptionsBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.subscriptionsBaseUrlProvider = provider2;
    }

    public static SubscriptionsNetworkModule_ProvideBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<SubscriptionsBaseUrl> provider2) {
        return new SubscriptionsNetworkModule_ProvideBaseUrlFactory(provider, provider2);
    }

    public static String provideBaseUrl(BaseUrlFactory baseUrlFactory, SubscriptionsBaseUrl subscriptionsBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(SubscriptionsNetworkModule.INSTANCE.provideBaseUrl(baseUrlFactory, subscriptionsBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.baseUrlFactoryProvider.get(), this.subscriptionsBaseUrlProvider.get());
    }
}
