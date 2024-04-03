package com.talabat.authentication.aaa;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class EndpointProvider_Factory implements Factory<EndpointProvider> {
    private final Provider<String> buildTypeProvider;
    private final Provider<String> serverProvider;

    public EndpointProvider_Factory(Provider<String> provider, Provider<String> provider2) {
        this.serverProvider = provider;
        this.buildTypeProvider = provider2;
    }

    public static EndpointProvider_Factory create(Provider<String> provider, Provider<String> provider2) {
        return new EndpointProvider_Factory(provider, provider2);
    }

    public static EndpointProvider newInstance(String str, String str2) {
        return new EndpointProvider(str, str2);
    }

    public EndpointProvider get() {
        return newInstance(this.serverProvider.get(), this.buildTypeProvider.get());
    }
}
