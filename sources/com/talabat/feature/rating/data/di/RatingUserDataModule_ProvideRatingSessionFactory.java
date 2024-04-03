package com.talabat.feature.rating.data.di;

import android.content.Context;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.feature.rating.domain.repo.RatingSession;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingUserDataModule_ProvideRatingSessionFactory implements Factory<RatingSession> {
    private final Provider<Context> contextProvider;
    private final Provider<EncryptedStorageProvider> encryptedStorageProvider;

    public RatingUserDataModule_ProvideRatingSessionFactory(Provider<Context> provider, Provider<EncryptedStorageProvider> provider2) {
        this.contextProvider = provider;
        this.encryptedStorageProvider = provider2;
    }

    public static RatingUserDataModule_ProvideRatingSessionFactory create(Provider<Context> provider, Provider<EncryptedStorageProvider> provider2) {
        return new RatingUserDataModule_ProvideRatingSessionFactory(provider, provider2);
    }

    public static RatingSession provideRatingSession(Context context, EncryptedStorageProvider encryptedStorageProvider2) {
        return (RatingSession) Preconditions.checkNotNullFromProvides(RatingUserDataModule.INSTANCE.provideRatingSession(context, encryptedStorageProvider2));
    }

    public RatingSession get() {
        return provideRatingSession(this.contextProvider.get(), this.encryptedStorageProvider.get());
    }
}
