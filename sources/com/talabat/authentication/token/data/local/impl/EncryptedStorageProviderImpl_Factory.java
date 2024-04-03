package com.talabat.authentication.token.data.local.impl;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class EncryptedStorageProviderImpl_Factory implements Factory<EncryptedStorageProviderImpl> {
    private final Provider<Context> contextProvider;

    public EncryptedStorageProviderImpl_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static EncryptedStorageProviderImpl_Factory create(Provider<Context> provider) {
        return new EncryptedStorageProviderImpl_Factory(provider);
    }

    public static EncryptedStorageProviderImpl newInstance(Context context) {
        return new EncryptedStorageProviderImpl(context);
    }

    public EncryptedStorageProviderImpl get() {
        return newInstance(this.contextProvider.get());
    }
}
