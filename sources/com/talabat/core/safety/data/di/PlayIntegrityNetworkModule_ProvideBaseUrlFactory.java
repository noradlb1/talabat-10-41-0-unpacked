package com.talabat.core.safety.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.safety.data.repository.shield.remote.ShieldBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.ShieldEndpointBaseUrl"})
public final class PlayIntegrityNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final PlayIntegrityNetworkModule module;
    private final Provider<ShieldBaseUrl> shieldBaseUrlProvider;

    public PlayIntegrityNetworkModule_ProvideBaseUrlFactory(PlayIntegrityNetworkModule playIntegrityNetworkModule, Provider<BaseUrlFactory> provider, Provider<ShieldBaseUrl> provider2) {
        this.module = playIntegrityNetworkModule;
        this.baseUrlFactoryProvider = provider;
        this.shieldBaseUrlProvider = provider2;
    }

    public static PlayIntegrityNetworkModule_ProvideBaseUrlFactory create(PlayIntegrityNetworkModule playIntegrityNetworkModule, Provider<BaseUrlFactory> provider, Provider<ShieldBaseUrl> provider2) {
        return new PlayIntegrityNetworkModule_ProvideBaseUrlFactory(playIntegrityNetworkModule, provider, provider2);
    }

    public static String provideBaseUrl(PlayIntegrityNetworkModule playIntegrityNetworkModule, BaseUrlFactory baseUrlFactory, ShieldBaseUrl shieldBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(playIntegrityNetworkModule.provideBaseUrl(baseUrlFactory, shieldBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.module, this.baseUrlFactoryProvider.get(), this.shieldBaseUrlProvider.get());
    }
}
