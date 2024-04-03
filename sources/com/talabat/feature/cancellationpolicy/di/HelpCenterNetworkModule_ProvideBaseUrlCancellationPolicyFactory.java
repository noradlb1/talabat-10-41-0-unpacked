package com.talabat.feature.cancellationpolicy.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class HelpCenterNetworkModule_ProvideBaseUrlCancellationPolicyFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<CancellationPolicyBaseUrl> cancellationPolicyBaseUrlProvider;

    public HelpCenterNetworkModule_ProvideBaseUrlCancellationPolicyFactory(Provider<BaseUrlFactory> provider, Provider<CancellationPolicyBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.cancellationPolicyBaseUrlProvider = provider2;
    }

    public static HelpCenterNetworkModule_ProvideBaseUrlCancellationPolicyFactory create(Provider<BaseUrlFactory> provider, Provider<CancellationPolicyBaseUrl> provider2) {
        return new HelpCenterNetworkModule_ProvideBaseUrlCancellationPolicyFactory(provider, provider2);
    }

    public static String provideBaseUrlCancellationPolicy(BaseUrlFactory baseUrlFactory, CancellationPolicyBaseUrl cancellationPolicyBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(HelpCenterNetworkModule.INSTANCE.provideBaseUrlCancellationPolicy(baseUrlFactory, cancellationPolicyBaseUrl));
    }

    public String get() {
        return provideBaseUrlCancellationPolicy(this.baseUrlFactoryProvider.get(), this.cancellationPolicyBaseUrlProvider.get());
    }
}
