package com.talabat.authentication.aaa.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.secrets.Secrets;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class SecretProviderModule_SecretProviderFactory implements Factory<SecretProvider> {
    private final Provider<Secrets> secretsProvider;

    public SecretProviderModule_SecretProviderFactory(Provider<Secrets> provider) {
        this.secretsProvider = provider;
    }

    public static SecretProviderModule_SecretProviderFactory create(Provider<Secrets> provider) {
        return new SecretProviderModule_SecretProviderFactory(provider);
    }

    public static SecretProvider secretProvider(Secrets secrets) {
        return (SecretProvider) Preconditions.checkNotNullFromProvides(SecretProviderModule.INSTANCE.secretProvider(secrets));
    }

    public SecretProvider get() {
        return secretProvider(this.secretsProvider.get());
    }
}
