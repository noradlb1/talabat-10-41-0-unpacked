package com.talabat.feature.rating.presentation.di;

import com.talabat.feature.rating.presentation.ui.RatingFeedBackViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingViewModelFactory_Factory implements Factory<RatingViewModelFactory> {
    private final Provider<RatingFeedBackViewModel> providerProvider;

    public RatingViewModelFactory_Factory(Provider<RatingFeedBackViewModel> provider) {
        this.providerProvider = provider;
    }

    public static RatingViewModelFactory_Factory create(Provider<RatingFeedBackViewModel> provider) {
        return new RatingViewModelFactory_Factory(provider);
    }

    public static RatingViewModelFactory newInstance(Provider<RatingFeedBackViewModel> provider) {
        return new RatingViewModelFactory(provider);
    }

    public RatingViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
