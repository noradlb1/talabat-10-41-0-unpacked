package com.talabat.feature.rating.presentation.ui;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingResourceProviderImpl_Factory implements Factory<RatingResourceProviderImpl> {
    private final Provider<Context> contextProvider;

    public RatingResourceProviderImpl_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static RatingResourceProviderImpl_Factory create(Provider<Context> provider) {
        return new RatingResourceProviderImpl_Factory(provider);
    }

    public static RatingResourceProviderImpl newInstance(Context context) {
        return new RatingResourceProviderImpl(context);
    }

    public RatingResourceProviderImpl get() {
        return newInstance(this.contextProvider.get());
    }
}
