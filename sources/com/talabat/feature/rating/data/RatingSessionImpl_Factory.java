package com.talabat.feature.rating.data;

import android.content.Context;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingSessionImpl_Factory implements Factory<RatingSessionImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<EncryptedStorageProvider> encryptedStorageProvider;

    public RatingSessionImpl_Factory(Provider<Context> provider, Provider<EncryptedStorageProvider> provider2) {
        this.contextProvider = provider;
        this.encryptedStorageProvider = provider2;
    }

    public static RatingSessionImpl_Factory create(Provider<Context> provider, Provider<EncryptedStorageProvider> provider2) {
        return new RatingSessionImpl_Factory(provider, provider2);
    }

    public static RatingSessionImpl newInstance(Context context, EncryptedStorageProvider encryptedStorageProvider2) {
        return new RatingSessionImpl(context, encryptedStorageProvider2);
    }

    public RatingSessionImpl get() {
        return newInstance(this.contextProvider.get(), this.encryptedStorageProvider.get());
    }
}
