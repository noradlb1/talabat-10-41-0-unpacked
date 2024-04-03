package com.talabat.flutter.secrets.data.handler;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SecretsMethodCallHandlerImpl_Factory implements Factory<SecretsMethodCallHandlerImpl> {
    private final Provider<SecretProvider> secretProvider;

    public SecretsMethodCallHandlerImpl_Factory(Provider<SecretProvider> provider) {
        this.secretProvider = provider;
    }

    public static SecretsMethodCallHandlerImpl_Factory create(Provider<SecretProvider> provider) {
        return new SecretsMethodCallHandlerImpl_Factory(provider);
    }

    public static SecretsMethodCallHandlerImpl newInstance(SecretProvider secretProvider2) {
        return new SecretsMethodCallHandlerImpl(secretProvider2);
    }

    public SecretsMethodCallHandlerImpl get() {
        return newInstance(this.secretProvider.get());
    }
}
