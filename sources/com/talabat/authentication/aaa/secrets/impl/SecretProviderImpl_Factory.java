package com.talabat.authentication.aaa.secrets.impl;

import com.talabat.authentication.aaa.EndpointProvider;
import com.talabat.secrets.Secrets;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SecretProviderImpl_Factory implements Factory<SecretProviderImpl> {
    private final Provider<String> buildTypeProvider;
    private final Provider<EndpointProvider> endPointProvider;
    private final Provider<String> instrumentationTestingServerProvider;
    private final Provider<Secrets> secretsProvider;

    public SecretProviderImpl_Factory(Provider<Secrets> provider, Provider<EndpointProvider> provider2, Provider<String> provider3, Provider<String> provider4) {
        this.secretsProvider = provider;
        this.endPointProvider = provider2;
        this.buildTypeProvider = provider3;
        this.instrumentationTestingServerProvider = provider4;
    }

    public static SecretProviderImpl_Factory create(Provider<Secrets> provider, Provider<EndpointProvider> provider2, Provider<String> provider3, Provider<String> provider4) {
        return new SecretProviderImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SecretProviderImpl newInstance(Secrets secrets, EndpointProvider endpointProvider, String str, String str2) {
        return new SecretProviderImpl(secrets, endpointProvider, str, str2);
    }

    public SecretProviderImpl get() {
        return newInstance(this.secretsProvider.get(), this.endPointProvider.get(), this.buildTypeProvider.get(), this.instrumentationTestingServerProvider.get());
    }
}
