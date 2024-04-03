package com.talabat.feature.rating.presentation.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingFeedBackViewModelFactory_Factory implements Factory<RatingFeedBackViewModelFactory> {
    private final Provider<RatingFeedBackViewModel> providerProvider;

    public RatingFeedBackViewModelFactory_Factory(Provider<RatingFeedBackViewModel> provider) {
        this.providerProvider = provider;
    }

    public static RatingFeedBackViewModelFactory_Factory create(Provider<RatingFeedBackViewModel> provider) {
        return new RatingFeedBackViewModelFactory_Factory(provider);
    }

    public static RatingFeedBackViewModelFactory newInstance(Provider<RatingFeedBackViewModel> provider) {
        return new RatingFeedBackViewModelFactory(provider);
    }

    public RatingFeedBackViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
