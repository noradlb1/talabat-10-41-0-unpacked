package com.talabat.feature.rewards.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.rewards.data.RewardsBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RewardsNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<RewardsBaseUrl> rewardsBaseUrlProvider;

    public RewardsNetworkModule_ProvideBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<RewardsBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.rewardsBaseUrlProvider = provider2;
    }

    public static RewardsNetworkModule_ProvideBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<RewardsBaseUrl> provider2) {
        return new RewardsNetworkModule_ProvideBaseUrlFactory(provider, provider2);
    }

    public static String provideBaseUrl(BaseUrlFactory baseUrlFactory, RewardsBaseUrl rewardsBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(RewardsNetworkModule.INSTANCE.provideBaseUrl(baseUrlFactory, rewardsBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.baseUrlFactoryProvider.get(), this.rewardsBaseUrlProvider.get());
    }
}
