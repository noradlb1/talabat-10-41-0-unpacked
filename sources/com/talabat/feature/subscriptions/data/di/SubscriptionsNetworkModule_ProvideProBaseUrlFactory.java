package com.talabat.feature.subscriptions.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.subscriptions.data.remote.ProBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class SubscriptionsNetworkModule_ProvideProBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<ProBaseUrl> proBaseUrlProvider;

    public SubscriptionsNetworkModule_ProvideProBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<ProBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.proBaseUrlProvider = provider2;
    }

    public static SubscriptionsNetworkModule_ProvideProBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<ProBaseUrl> provider2) {
        return new SubscriptionsNetworkModule_ProvideProBaseUrlFactory(provider, provider2);
    }

    public static String provideProBaseUrl(BaseUrlFactory baseUrlFactory, ProBaseUrl proBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(SubscriptionsNetworkModule.INSTANCE.provideProBaseUrl(baseUrlFactory, proBaseUrl));
    }

    public String get() {
        return provideProBaseUrl(this.baseUrlFactoryProvider.get(), this.proBaseUrlProvider.get());
    }
}
